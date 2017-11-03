package samples.algorithms

object Util {

    fun checkEquals(actual:Any, expected:Any) {
        if (actual != expected) throw RuntimeException("Values are not equal\nActual:   $actual\nExpected: $expected")
    }
}