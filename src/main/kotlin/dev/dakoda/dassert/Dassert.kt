package dev.dakoda.dassert

import org.assertj.core.api.*

fun dassert(block: Dassert.() -> Unit) {
    Dassert().block()
}

fun main() {
    dassert {
    }
}

class Dassert {

    val Any.isNull: Unit
        get() {
            AssertionsForClassTypes.assertThat(this).isNull()
        }

    val Any.isNotNull: Unit
        get() {
            AssertionsForClassTypes.assertThat(this).isNotNull
        }

    val Boolean.isTrue: Unit
        get() {
            AssertionsForClassTypes.assertThat(this).isTrue()
        }

    val Boolean.isFalse: Unit
        get() {
            AssertionsForClassTypes.assertThat(this).isFalse()
        }

    infix fun <T> Any.isEqualTo(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isEqualTo(t)
    }

    infix fun <T> Any.isNotEqualTo(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isNotEqualTo(t)
    }

    infix fun <T> Any.isIn(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isIn(t)
    }

    infix fun <T> Any.isNotIn(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isNotIn(t)
    }

    infix fun Int.isGreaterThan(t: Int): AbstractIntegerAssert<*>? {
        return AssertionsForClassTypes.assertThat(this).isGreaterThan(t)
    }

    infix fun Int.isLessThan(t: Int): AbstractIntegerAssert<*>? {
        return AssertionsForClassTypes.assertThat(this).isLessThan(t)
    }

    infix fun Int.isGreaterThanOrEqualTo(t: Int): AbstractIntegerAssert<*>? {
        return AssertionsForClassTypes.assertThat(this).isGreaterThanOrEqualTo(t)
    }

    infix fun Int.isLessThanOrEqualTo(t: Int): AbstractIntegerAssert<*>? {
        return AssertionsForClassTypes.assertThat(this).isLessThanOrEqualTo(t)
    }

    infix fun <T> List<T>.doesContain(t: T) {
        AssertionsForInterfaceTypes.assertThat(this.contains(t)).isTrue()
    }

    infix fun <T> List<T>.doesntContain(t: T) {
        AssertionsForInterfaceTypes.assertThat(this.contains(t)).isFalse()
    }

    infix fun <T> Set<T>.doesContain(t: T) {
        AssertionsForInterfaceTypes.assertThat(this.contains(t)).isTrue()
    }

    infix fun <T> Set<T>.doesntContain(t: T) {
        AssertionsForInterfaceTypes.assertThat(this.contains(t)).isFalse()
    }

    infix fun <T> Array<T>.doesContain(t: T) {
        AssertionsForClassTypes.assertThat(this.toList().contains(t)).isTrue()
    }

    infix fun <T> Array<T>.doesntContain(t: T) {
        AssertionsForClassTypes.assertThat(this.toList().contains(t)).isFalse()
    }
}