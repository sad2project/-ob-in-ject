package progjake.obinject


fun <T> valueOf(value: T): Provider<T> = Returner(value)

fun <T, R> into(factory: (T) -> R): (Provider<T>) -> R = { factory(it.create()) }
fun <T1, T2, R> into(factory: (T1, T2) -> R): (Tuple2<T1, T2>) -> R = { factory(it.first, it.second) }
fun <T1, T2, T3, R> into(factory: (T1, T2, T3) -> R): (Tuple3<T1, T2, T3>) -> R = { factory(it.first, it.second, it.third) }
fun <T1, T2, T3, T4, R> into(factory: (T1, T2, T3, T4) -> R): (Tuple4<T1, T2, T3, T4>) -> R = { factory(it.first, it.second, it.third, it.fourth) }
fun <T1, T2, T3, T4, T5, R> into(factory: (T1, T2, T3, T4, T5) -> R): (Tuple5<T1, T2, T3, T4, T5>) -> R = { factory(it.first, it.second, it.third, it.fourth, it.fifth) }
fun <T1, T2, T3, T4, T5, T6, R> into(factory: (T1, T2, T3, T4, T5, T6) -> R): (Tuple6<T1, T2, T3, T4, T5, T6>) -> R = { factory(it.first, it.second, it.third, it.fourth, it.fifth, it.sixth) }
fun <T1, T2, T3, T4, T5, T6, T7, R> into(factory: (T1, T2, T3, T4, T5, T6, T7) -> R): (Tuple7<T1, T2, T3, T4, T5, T6, T7>) -> R = { factory(it.first, it.second, it.third, it.fourth, it.fifth, it.sixth, it.seventh) }
fun <T1, T2, T3, T4, T5, T6, T7, T8, R> into(factory: (T1, T2, T3, T4, T5, T6, T7, T8) -> R): (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>) -> R = { factory(it.first, it.second, it.third, it.fourth, it.fifth, it.sixth, it.seventh, it.eighth) }
fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> into(factory: (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R): (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>) -> R = { factory(it.first, it.second, it.third, it.fourth, it.fifth, it.sixth, it.seventh, it.eighth, it.ninth) }
fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> into(factory: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R): (Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>) -> R = { factory(it.first, it.second, it.third, it.fourth, it.fifth, it.sixth, it.seventh, it.eighth, it.ninth, it.tenth) }

fun <R> inject(factory: () -> R, injector: (() -> R) -> Provider<R>): Provider<R> = injector(factory)
fun <R> inject(factory: Provider<R>, injector: (() -> R) -> Provider<R>): Provider<R> = injector{ factory.create() }
fun <T, R> inject(args: Provider<T>, factory: (Provider<T>) -> R, injector: (() -> R) -> Provider<R>): Provider<R> = injector{factory(args)}
fun <T1, T2, R> inject(args: Tuple2<T1, T2>, factory: (Tuple2<T1, T2>) -> R, injector: (() -> R) -> Provider<R>): Provider<R> = injector{factory(args)}
fun <T1, T2, T3, R> inject(args: Tuple3<T1, T2, T3>, factory: (Tuple3<T1, T2, T3>) -> R, injector: (() -> R) -> Provider<R>): Provider<R> = injector{factory(args)}
fun <T1, T2, T3, T4, R> inject(args: Tuple4<T1, T2, T3, T4>, factory: (Tuple4<T1, T2, T3, T4>) -> R, injector: (() -> R) -> Provider<R>): Provider<R> = injector{factory(args)}
fun <T1, T2, T3, T4, T5, R> inject(args: Tuple5<T1, T2, T3, T4, T5>, factory: (Tuple5<T1, T2, T3, T4, T5>) -> R, injector: (() -> R) -> Provider<R>): Provider<R> = injector{factory(args)}
fun <T1, T2, T3, T4, T5, T6, R> inject(args: Tuple6<T1, T2, T3, T4, T5, T6>, factory: (Tuple6<T1, T2, T3, T4, T5, T6>) -> R, injector: (() -> R) -> Provider<R>): Provider<R> = injector{factory(args)}
fun <T1, T2, T3, T4, T5, T6, T7, R> inject(args: Tuple7<T1, T2, T3, T4, T5, T6, T7>, factory: (Tuple7<T1, T2, T3, T4, T5, T6, T7>) -> R, injector: (() -> R) -> Provider<R>): Provider<R> = injector{factory(args)}
fun <T1, T2, T3, T4, T5, T6, T7, T8, R> inject(args: Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>, factory: (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>) -> R, injector: (() -> R) -> Provider<R>): Provider<R> = injector{factory(args)}
fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> inject(args: Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, factory: (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>) -> R, injector: (() -> R) -> Provider<R>): Provider<R> = injector{factory(args)}
fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> inject(args: Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, factory: (Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>) -> R, injector: (() -> R) -> Provider<R>): Provider<R> = injector{factory(args)}

fun <R> asSingleton(): (() -> R) -> Provider<R> = {Singleton(it)}
fun <R> asThreadSafeSingleton(): (() -> R) -> Provider<R> = {ThreadSafeSingleton(it)}
fun <R> asFactory(): (() -> R) -> Provider<R> = {Factory(it)}
fun <R> asPerThreadFactory(): (() -> R) -> Provider<R> = {PerThreadFactory(it)}

class Basic
val t = inject( {Basic()}, asSingleton())