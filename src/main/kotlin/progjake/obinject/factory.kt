package progjake.obinject

import java.util.WeakHashMap

interface Provider<out T> {
    fun create() :T
}

class Factory<T> (private val supplier: () -> T): Provider<T> {
    override fun create(): T = supplier()
}

class PerThreadFactory<T>(private val supplier: () -> T): Provider<T> {
    private val threadSupplier: MutableMap<Thread, T> = WeakHashMap()
    override fun create(): T {
        val thisThread = Thread.currentThread()
        if(thisThread !in threadSupplier)
            threadSupplier[thisThread] = supplier()
        return threadSupplier[thisThread]!!
    }
}

class Singleton<T> (supplier: () -> T): Provider<T> {
    private val cache: T by lazy(supplier);
    override fun create(): T {
        return cache
    }
}

class ThreadSafeSingleton<T> (private val supplier: () -> T): Provider<T> {
    private var current: Provider<T> = Factory{swapper()}

    override fun create(): T {
        return current.create()
    }

    @Synchronized
    private fun swapper(): T {
        if(current !is Returner<*>) {
            current = Returner(supplier())
        }
        return current.create()
    }
}

class Returner<T> (private val value: T): Provider<T> {
    override fun create(): T {
        return value
    }
}