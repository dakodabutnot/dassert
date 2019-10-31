package dev.dakoda.dassert.array

import dev.dakoda.dassert.DassertionExtension
import org.assertj.core.api.Assertions.assertThat
import org.opentest4j.AssertionFailedError

class DassertionExtensionArrayContainsXOR<T: Any>(
    private val originalArray: Array<T>,
    firstValue: T,
    secondValue: T
): DassertionExtension<T> {

    private var xors = arrayListOf(firstValue, secondValue)

    infix fun xor(other: T): DassertionExtensionArrayContainsXOR<T> {
        xors.add(other)
        return this
    }

    override fun check() {
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