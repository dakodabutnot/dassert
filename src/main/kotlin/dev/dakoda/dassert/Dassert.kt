@file:Suppress("unused")

package dev.dakoda.dassert

import org.assertj.core.api.*

fun dassert(block: Dassert.() -> Unit) {
    Dassert().block()
}

class Dassert {

    val <K> K.isNull: Unit
        get() {
            AssertionsForClassTypes.assertThat(this).isNull()
        }

    val <K> K.isNotNull: Unit
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

    val Int.isZero: Unit
        get() {
            AssertionsForClassTypes.assertThat(this).isEqualTo(0)
        }

    val Float.isZero: Unit
        get() {
            AssertionsForClassTypes.assertThat(this).isEqualTo(0f)
        }

    val Double.isZero: Unit
        get() {
            AssertionsForClassTypes.assertThat(this).isEqualTo(0f)
        }

    val Long.isZero: Unit
        get() {
            AssertionsForClassTypes.assertThat(this).isEqualTo(0f)
        }

    val Int.isNotZero: Unit
        get() {
            AssertionsForClassTypes.assertThat(this).isNotEqualTo(0)
        }

    val Float.isNotZero: Unit
        get() {
            AssertionsForClassTypes.assertThat(this).isNotEqualTo(0f)
        }

    val Double.isNotZero: Unit
        get() {
            AssertionsForClassTypes.assertThat(this).isNotEqualTo(0f)
        }

    val Long.isNotZero: Unit
        get() {
            AssertionsForClassTypes.assertThat(this).isNotEqualTo(0f)
        }

    infix fun <T, K> K.equals(t: T): ObjectAssert<K>? {
        return AssertionsForClassTypes.assertThat(this).isEqualTo(t)
    }

    infix fun <T, K> K.noEquals(t: T): ObjectAssert<K>? {
        return AssertionsForClassTypes.assertThat(this).isNotEqualTo(t)
    }

    infix fun <T, K> K.isEqualTo(t: T): ObjectAssert<K>? {
        return AssertionsForClassTypes.assertThat(this).isEqualTo(t)
    }

    infix fun <T, K> K.isNotEqualTo(t: T): ObjectAssert<K>? {
        return AssertionsForClassTypes.assertThat(this).isNotEqualTo(t)
    }

    infix fun <T, K> K.inside(t: T): ObjectAssert<K>? {
        return AssertionsForClassTypes.assertThat(this).isIn(t)
    }

    infix fun <T, K> K.notInside(t: T): ObjectAssert<K>? {
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

    infix fun <T, U> Map<T, U>.hasKey(t: T) {
        AssertionsForInterfaceTypes.assertThat(this).containsKey(t)
    }

    infix fun <T, U> Map<T, U>.doesntHaveKey(t: T) {
        AssertionsForInterfaceTypes.assertThat(this).containsKey(t)
    }

    infix fun <T, U> Map<T, U>.hasValue(u: U) {
        AssertionsForInterfaceTypes.assertThat(this).containsValue(u)
    }

    infix fun <T, U> Map<T, U>.doesntHaveValue(u: U) {
        AssertionsForInterfaceTypes.assertThat(this).containsValue(u)
    }

    infix fun <T, U> Map<T, U>.containsKey(t: T) {
        AssertionsForInterfaceTypes.assertThat(this).containsKey(t)
    }

    infix fun <T, U> Map<T, U>.doesntContainKey(t: T) {
        AssertionsForInterfaceTypes.assertThat(this).containsKey(t)
    }

    infix fun <T, U> Map<T, U>.containsValue(u: U) {
        AssertionsForInterfaceTypes.assertThat(this).containsValue(u)
    }

    infix fun <T, U> Map<T, U>.doesntContainValue(u: U) {
        AssertionsForInterfaceTypes.assertThat(this).containsValue(u)
    }
}