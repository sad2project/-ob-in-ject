package progjake.obinject

import java.util.*

interface Provider<out T> {
    operator fun invoke() :T
}

class Factory<T> (private val supplier: () -> T): Provider<T> {
    override fun invoke(): T = supplier()
}

class PerThreadFactory<T>(private val supplier: () -> T): Provider<T> {
    private val threadSupplier: MutableMap<Thread, T> = WeakHashMap()
    override fun invoke(): T {
        val thisThread = Thread.currentThread()
        if(thisThread !in threadSupplier)
            threadSupplier[thisThread] = supplier()
        return threadSupplier[thisThread]!!
    }
}

class Singleton<T> (private val supplier: () -> T): Provider<T> {
    private var cache: T? = null;
    override fun invoke(): T {
        if(cache == null)
            cache = supplier()
        return cache!!
    }
}

class ThreadSafeSingleton<T> (private val supplier: () -> T): Provider<T> {
    private var current: Provider<T> = Factory{swapper()}

    override fun invoke(): T {
        return current()
    }

    @Synchronized
    private fun swapper(): T {
        if(current !is Returner<*>) {
            current = Returner(supplier())
        }
        return current()
    }
}

class Returner<T> (private val value: T): Provider<T> {
    override fun invoke(): T {
        return value
    }
}