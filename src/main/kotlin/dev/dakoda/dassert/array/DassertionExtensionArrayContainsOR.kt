package dev.dakoda.dassert.array

import dev.dakoda.dassert.DassertionExtension
import org.assertj.core.api.Assertions.assertThat
import org.opentest4j.AssertionFailedError

class DassertionExtensionArrayContainsOR<T: Any>(
    private val originalArray: Array<T>,
    firstValue: T,
    secondValue: T
) : DassertionExtension<T> {

    private var ors = arrayListOf(firstValue, secondValue)

    infix fun or(other: T): DassertionExtensionArrayContainsOR<T> {
        ors.add(other)
        return this
    }

    override fun check() {
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