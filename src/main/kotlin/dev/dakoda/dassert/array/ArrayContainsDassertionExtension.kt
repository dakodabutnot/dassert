package dev.dakoda.dassert.array

import dev.dakoda.dassert.Dassert
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.AssertionsForClassTypes
import org.opentest4j.AssertionFailedError

class ArrayContainsDassertionExtension<T>(
    private val dassert: Dassert,
    private val originalArray: Array<T>,
    private val firstValue: T
) {

    infix fun and(other: T): ArrayContainsDassertionAndExtension<T> {
        return ArrayContainsDassertionAndExtension(originalArray)
    }

    @Suppress("UNCHECKED_CAST")
    infix fun or(other: T): ArrayContainsDassertionOrExtension<T> {
        return ArrayContainsDassertionOrExtension(originalArray, firstValue, other).also {
            dassert.ors.add(it as ArrayContainsDassertionOrExtension<Any>)
        }
    }

    @Suppress("UNCHECKED_CAST")
    infix fun xor(other: T): ArrayContainsDassertionXorExtension<T> {
        return ArrayContainsDassertionXorExtension(originalArray, firstValue, other).also {
            dassert.xors.add(it as ArrayContainsDassertionXorExtension<Any>)
        }
    }
}

class ArrayContainsDassertionAndExtension<T>(private val originalArray: Array<T>) {

    infix fun and(other: T): ArrayContainsDassertionAndExtension<T> {
        check(other)
        return this
    }

    private fun check(other: T) {
        try {
            AssertionsForClassTypes.assertThat(originalArray.contains(other)).isTrue()
        } catch (e: AssertionFailedError) {
            throw AssertionFailedError("Assertion failed. Expecting array to contain value ($other)")
        }
    }
}

class ArrayContainsDassertionOrExtension<T>(private val originalArray: Array<T>, private val firstValue: T, secondValue: T) {

    var ors = arrayListOf(firstValue, secondValue)

    infix fun or(other: T): ArrayContainsDassertionOrExtension<T> {
        ors.add(other)
        return this
    }

    fun check() {
        var atLeastOne = false
        for (or in ors) {
            if (originalArray.contains(or)) atLeastOne = true
        }
        try {
            assertThat(atLeastOne).isTrue()
        } catch (e: AssertionFailedError) {
            throw AssertionFailedError("Assertion failed. The array did not contain any of the provided elements.")
        }
    }
}

class ArrayContainsDassertionXorExtension<T>(private val originalArray: Array<T>, private val firstValue: T, secondValue: T) {

    var xors = arrayListOf(firstValue, secondValue)

    infix fun xor(other: T): ArrayContainsDassertionXorExtension<T> {
        xors.add(other)
        return this
    }

    fun check() {
        var matches = 0
        for (or in xors) {
            if (originalArray.contains(or)) {
                matches += 1
            }
        }
        try {
            assertThat(matches).isEqualTo(1)
        } catch (e: AssertionFailedError) {
            if (matches == 0) {
                throw AssertionFailedError("Assertion failed. The array did not contain any of the provided elements.")
            } else throw AssertionFailedError("Assertion failed. The array did not contain only one of the provided elements.")
        }
    }
}