@file:Suppress("unused")

package dev.dakoda.dassert

import dev.dakoda.dassert.array.DassertionExtensionArrayContains
import dev.dakoda.dassert.array.DassertionExtensionArrayContainsOR
import dev.dakoda.dassert.array.DassertionExtensionArrayContainsXOR
import dev.dakoda.dassert.map.MapDassertion
import org.assertj.core.api.*

fun dassert(block: Dassert.() -> Unit) {
    Dassert().also {
        it.block()
        it.evaluateBooleans()
    }
}

val Any.formatExceptionString
    get(): String {
        return if (this is String)
            "\"$this\""
        else this.toString()
    }


class Dassert {

    var extensions = arrayListOf<DassertionExtension<Any>>()

    var extensionsOR = arrayListOf<DassertionExtensionArrayContainsOR<Any>>()
    var extensionsXOR = arrayListOf<DassertionExtensionArrayContainsXOR<Any>>()

    internal fun evaluateBooleans() {
        if (extensionsOR.isNotEmpty()) extensionsOR.forEach { it.check() }
        if (extensionsXOR.isNotEmpty()) extensionsXOR.forEach { it.check() }
        if (extensions.isNotEmpty()) extensions.forEach { it.check() }
    }

    fun map(map: Map<Any, Any>, block: MapDassertion<Any, Any>.() -> Unit) {
        block.invoke(MapDassertion(map))
    }

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

    infix fun <T : Any> Array<T>.contains(t: T): DassertionExtensionArrayContains<T> {
        return DassertionExtensionArrayContains(this@Dassert, this@contains, t)

    }

    fun <T> Array<T>.contains(vararg t: T) {
        for (item in t) {
            AssertionsForClassTypes.assertThat(this.toList().contains(item)).isTrue()
        }
    }

    fun <T> Array<T>.containsExactly(vararg t: T) {
        AssertionsForClassTypes.assertThat(this).containsExactlyElementsOf(t.asIterable())
    }

    infix fun <T> Array<T>.doesntContain(t: T) {
        AssertionsForClassTypes.assertThat(this.toList().contains(t)).isFalse()
    }

    infix fun <T, U> Map<T, U>.has(t: T) {
        AssertionsForInterfaceTypes.assertThat(this).containsKey(t)
    }

    infix fun <T, U> Map<T, U>.hasKey(t: T) {
        AssertionsForInterfaceTypes.assertThat(this).containsKey(t)
    }

    infix fun <T, U> Map<T, U>.doesntHaveKey(t: T) {
        AssertionsForInterfaceTypes.assertThat(this).doesNotContainKey(t)
    }

    infix fun <T, U> Map<T, U>.doesntHave(t: T) {
        AssertionsForInterfaceTypes.assertThat(this).doesNotContainKey(t)
    }

    infix fun <T, U> Map<T, U>.hasValue(u: U) {
        AssertionsForInterfaceTypes.assertThat(this).containsValue(u)
    }

    infix fun <T, U> Map<T, U>.doesntHaveValue(u: U) {
        AssertionsForInterfaceTypes.assertThat(this).doesNotContainValue(u)
    }

    infix fun <T, U> Map<T, U>.containsKey(t: T) {
        AssertionsForInterfaceTypes.assertThat(this).containsKey(t)
    }

    infix fun <T, U> Map<T, U>.doesntContainKey(t: T) {
        AssertionsForInterfaceTypes.assertThat(this).doesNotContainKey(t)
    }

    infix fun <T, U> Map<T, U>.containsValue(u: U) {
        AssertionsForInterfaceTypes.assertThat(this).containsValue(u)
    }

    infix fun <T, U> Map<T, U>.doesntContainValue(u: U) {
        AssertionsForInterfaceTypes.assertThat(this).doesNotContainValue(u)
    }
}