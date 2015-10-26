package progjake.obinject

fun <P1, P2> Provider<P1>.and(second: Provider<P2>): Tuple2<P1, P2> = Tuple2(this, second)

class Tuple2<out P1, out P2>(private val _first: Provider<P1>, private val _second: Provider<P2>) {
    val first: P1 get() = _first()
    val second: P2 get() = _second()

    fun <P3> and(third: Provider<P3>): Tuple3<P1, P2, P3> = Tuple3(_first, _second, third)
}

class Tuple3<out P1, out P2, out P3>(private val _first: Provider<P1>, private val _second: Provider<P2>, private val _third: Provider<P3>) {
    val first: P1 get() = _first()
    val second: P2 get() = _second()
    val third: P3 get() = _third()

    fun <P4> and(fourth: Provider<P4>): Tuple4<P1, P2, P3, P4> = Tuple4(_first, _second, _third, fourth)
}

class Tuple4<out P1, out P2, out P3, out P4>(private val _first: Provider<P1>, private val _second: Provider<P2>, private val _third: Provider<P3>, private val _fourth: Provider<P4>) {
    val first: P1 get() = _first()
    val second: P2 get() = _second()
    val third: P3 get() = _third()
    val fourth: P4 get() = _fourth()

    fun <P5> and(fifth: Provider<P5>): Tuple5<P1, P2, P3, P4, P5> = Tuple5(_first, _second, _third, _fourth, fifth)
}

class Tuple5<out P1, out P2, out P3, out P4, out P5>(private val _first: Provider<P1>, private val _second: Provider<P2>, private val _third: Provider<P3>, private val _fourth: Provider<P4>, private val _fifth: Provider<P5>) {
    val first: P1 get() = _first()
    val second: P2 get() = _second()
    val third: P3 get() = _third()
    val fourth: P4 get() = _fourth()
    val fifth: P5 get() = _fifth()

    fun <P6> and(sixth: Provider<P6>): Tuple6<P1, P2, P3, P4, P5, P6> = Tuple6(_first, _second, _third, _fourth, _fifth, sixth)
}

class Tuple6<out P1, out P2, out P3, out P4, out P5, out P6>(private val _first: Provider<P1>, private val _second: Provider<P2>, private val _third: Provider<P3>, private val _fourth: Provider<P4>, private val _fifth: Provider<P5>, private val _sixth: Provider<P6>) {
    val first: P1 get() = _first()
    val second: P2 get() = _second()
    val third: P3 get() = _third()
    val fourth: P4 get() = _fourth()
    val fifth: P5 get() = _fifth()
    val sixth: P6 get() = _sixth()

    fun <P7> and(seventh: Provider<P7>): Tuple7<P1, P2, P3, P4, P5, P6, P7> = Tuple7(_first, _second, _third, _fourth, _fifth, _sixth, seventh)
}

class Tuple7<out P1, out P2, out P3, out P4, out P5, out P6, out P7>(private val _first: Provider<P1>, private val _second: Provider<P2>, private val _third: Provider<P3>, private val _fourth: Provider<P4>, private val _fifth: Provider<P5>, private val _sixth: Provider<P6>, private val _seventh: Provider<P7>) {
    val first: P1 get() = _first()
    val second: P2 get() = _second()
    val third: P3 get() = _third()
    val fourth: P4 get() = _fourth()
    val fifth: P5 get() = _fifth()
    val sixth: P6 get() = _sixth()
    val seventh: P7 get() = _seventh()

    fun <P8> and(eighth: Provider<P8>): Tuple8<P1, P2, P3, P4, P5, P6, P7, P8> = Tuple8(_first, _second, _third, _fourth, _fifth, _sixth, _seventh, eighth)
}

class Tuple8<out P1, out P2, out P3, out P4, out P5, out P6, out P7, out P8>(private val _first: Provider<P1>, private val _second: Provider<P2>, private val _third: Provider<P3>, private val _fourth: Provider<P4>, private val _fifth: Provider<P5>, private val _sixth: Provider<P6>, private val _seventh: Provider<P7>, private val _eighth: Provider<P8>) {
    val first: P1 get() = _first()
    val second: P2 get() = _second()
    val third: P3 get() = _third()
    val fourth: P4 get() = _fourth()
    val fifth: P5 get() = _fifth()
    val sixth: P6 get() = _sixth()
    val seventh: P7 get() = _seventh()
    val eighth: P8 get() = _eighth()

    fun <P9> and(ninth: Provider<P9>): Tuple9<P1, P2, P3, P4, P5, P6, P7, P8, P9> = Tuple9(_first, _second, _third, _fourth, _fifth, _sixth, _seventh, _eighth, ninth)
}

class Tuple9<out P1, out P2, out P3, out P4, out P5, out P6, out P7, out P8, out P9>(private val _first: Provider<P1>, private val _second: Provider<P2>, private val _third: Provider<P3>, private val _fourth: Provider<P4>, private val _fifth: Provider<P5>, private val _sixth: Provider<P6>, private val _seventh: Provider<P7>, private val _eighth: Provider<P8>, private val _ninth: Provider<P9>) {
    val first: P1 get() = _first()
    val second: P2 get() = _second()
    val third: P3 get() = _third()
    val fourth: P4 get() = _fourth()
    val fifth: P5 get() = _fifth()
    val sixth: P6 get() = _sixth()
    val seventh: P7 get() = _seventh()
    val eighth: P8 get() = _eighth()
    val ninth: P9 get() = _ninth()

    fun <P10> and(tenth: Provider<P10>): Tuple10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> = Tuple10(_first, _second, _third, _fourth, _fifth, _sixth, _seventh, _eighth, _ninth, tenth)
}

class Tuple10<out P1, out P2, out P3, out P4, out P5, out P6, out P7, out P8, out P9, out P10>(private val _first: Provider<P1>, private val _second: Provider<P2>, private val _third: Provider<P3>, private val _fourth: Provider<P4>, private val _fifth: Provider<P5>, private val _sixth: Provider<P6>, private val _seventh: Provider<P7>, private val _eighth: Provider<P8>, private val _ninth: Provider<P9>, private val _tenth: Provider<P10>) {
    val first: P1 get() = _first()
    val second: P2 get() = _second()
    val third: P3 get() = _third()
    val fourth: P4 get() = _fourth()
    val fifth: P5 get() = _fifth()
    val sixth: P6 get() = _sixth()
    val seventh: P7 get() = _seventh()
    val eighth: P8 get() = _eighth()
    val ninth: P9 get() = _ninth()
    val tenth: P10 get() = _tenth()
}