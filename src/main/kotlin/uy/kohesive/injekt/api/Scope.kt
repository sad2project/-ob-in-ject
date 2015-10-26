@file:Suppress("NOTHING_TO_INLINE")

package uy.kohesive.injekt.api

import kotlin.reflect.KClass

public open class InjektScope(val registrar: InjektRegistrar) : InjektRegistrar by registrar

public inline fun <reified T: Any> InjektScope.injectLazy(): Lazy<T> {
    return lazy { get(fullType<T>()) }
}

public inline fun <reified T: Any> InjektScope.injectValue(): Lazy<T> {
    return lazyOf( get(fullType<T>()))
}

public inline fun <reified T: Any> InjektScope.injectLazy(key: Any): Lazy<T> {
    return lazy { get(fullType<T>(), key) }
}

public inline fun <reified T: Any> InjektScope.injectValue(key: Any): Lazy<T> {
    return lazyOf(get(fullType<T>(), key))
}

public inline fun <reified T: Any, O: Any> InjektScope.injectLogger(forClass: Class<O>): Lazy<T> {
    return lazy { logger(fullType<T>(), forClass) }
}

public inline fun <reified T: Any, O: Any> InjektScope.injectLogger(forClass: KClass<O>): Lazy<T> {
    return lazy { logger(fullType<T>(), forClass.java) }
}


