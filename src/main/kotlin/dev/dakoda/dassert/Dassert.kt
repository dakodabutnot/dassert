package dev.dakoda.dassert

import org.assertj.core.api.*

fun dassert(block: Dassert.() -> Unit) {
    Dassert().block()
}

class Dassert {

    fun Any.isNull() {
        AssertionsForClassTypes.assertThat(this).isNull()
    }

    fun Any.isNotNull(): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isNotNull
    }

    infix fun <T> Any.isEqualTo(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isEqualTo(t)
    }

    infix fun <T> Any.isNotEqualTo(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isNotEqualTo(t)
    }

    infix fun <T> Any.isSameAs(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isSameAs(t)
    }

    infix fun <T> Any.isNotSameAs(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isNotSameAs(t)
    }

    infix fun <T> Any.isIn(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isIn(t)
    }

    infix fun <T> Any.isNotIn(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isNotIn(t)
    }

    infix fun <T : Condition<*>> Any.`is`(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).`is`(t)
    }

    infix fun <T : Condition<*>> Any.isNot(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isNot(t)
    }

    infix fun <T : Condition<*>> Any.satisfies(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).satisfies(t)
    }

    infix fun <T> Any.isInstanceOf(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isInstanceOf(t)
    }

    infix fun <T> Any.isNotInstanceOf(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).isNotInstanceOf(t)
    }

    infix fun <T> Any.hasToString(t: T): ObjectAssert<Any>? {
        return AssertionsForClassTypes.assertThat(this).hasToString(t)
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

    fun Boolean.isTrue() {
        AssertionsForClassTypes.assertThat(this).isTrue()
    }

    fun Boolean.isFalse() {
        AssertionsForClassTypes.assertThat(this).isFalse()
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