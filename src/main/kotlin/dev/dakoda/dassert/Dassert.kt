package dev.dakoda.dassert

import org.assertj.core.api.*

fun dassert(block: Dassert.() -> Unit) {
    Dassert().block()
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

    infix fun <T> Any.equals(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isEqualTo(t)
    }

    infix fun <T> Any.noEquals(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isNotEqualTo(t)
    }

    infix fun <T> Any.inside(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isIn(t)
    }

    infix fun <T> Any.notInside(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isNotIn(t)
    }

    infix fun Int.greaterThan(t: Int): AbstractIntegerAssert<*>? {
        return AssertionsForClassTypes.assertThat(this).isGreaterThan(t)
    }

    infix fun Int.lessThan(t: Int): AbstractIntegerAssert<*>? {
        return AssertionsForClassTypes.assertThat(this).isLessThan(t)
    }

    infix fun Int.greaterThanOrEquals(t: Int): AbstractIntegerAssert<*>? {
        return AssertionsForClassTypes.assertThat(this).isGreaterThanOrEqualTo(t)
    }

    infix fun Int.lessThanOrEquals(t: Int): AbstractIntegerAssert<*>? {
        return AssertionsForClassTypes.assertThat(this).isLessThanOrEqualTo(t)
    }

    infix fun Int.notLessThan(t: Int): AbstractIntegerAssert<*>? {
        return AssertionsForClassTypes.assertThat(this).isGreaterThanOrEqualTo(t)
    }

    infix fun Int.notGreaterThan(t: Int): AbstractIntegerAssert<*>? {
        return AssertionsForClassTypes.assertThat(this).isLessThanOrEqualTo(t)
    }

    infix fun <T> List<T>.has(t: T) {
        AssertionsForInterfaceTypes.assertThat(this.contains(t)).isTrue()
    }

    infix fun <T> List<T>.doesntHave(t: T) {
        AssertionsForInterfaceTypes.assertThat(this.contains(t)).isFalse()
    }

    infix fun <T> Set<T>.has(t: T) {
        AssertionsForInterfaceTypes.assertThat(this.contains(t)).isTrue()
    }

    infix fun <T> Set<T>.doesntHave(t: T) {
        AssertionsForInterfaceTypes.assertThat(this.contains(t)).isFalse()
    }

    infix fun <T> Array<T>.has(t: T) {
        AssertionsForClassTypes.assertThat(this.toList().contains(t)).isTrue()
    }

    infix fun <T> Array<T>.doesntHave(t: T) {
        AssertionsForClassTypes.assertThat(this.toList().contains(t)).isFalse()
    }

    infix fun <T> List<T>.contains(t: T) {
        AssertionsForInterfaceTypes.assertThat(this.contains(t)).isTrue()
    }

    infix fun <T> List<T>.doesntContain(t: T) {
        AssertionsForInterfaceTypes.assertThat(this.contains(t)).isFalse()
    }

    infix fun <T> Set<T>.contains(t: T) {
        AssertionsForInterfaceTypes.assertThat(this.contains(t)).isTrue()
    }

    infix fun <T> Set<T>.doesntContain(t: T) {
        AssertionsForInterfaceTypes.assertThat(this.contains(t)).isFalse()
    }

    infix fun <T> Array<T>.contains(t: T) {
        AssertionsForClassTypes.assertThat(this.toList().contains(t)).isTrue()
    }

    infix fun <T> Array<T>.doesntContain(t: T) {
        AssertionsForClassTypes.assertThat(this.toList().contains(t)).isFalse()
    }
}