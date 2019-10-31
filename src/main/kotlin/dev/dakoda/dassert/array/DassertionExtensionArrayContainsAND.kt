package dev.dakoda.dassert.array

import dev.dakoda.dassert.DassertionExtension
import dev.dakoda.dassert.formatExceptionString
import org.assertj.core.api.AssertionsForClassTypes
import org.opentest4j.AssertionFailedError

class DassertionExtensionArrayContainsAND<T: Any>(
    private val originalArray: Array<T>
) : DassertionExtension<T> {

    infix fun and(other: T): DassertionExtensionArrayContainsAND<T> {
        check(other)
        return this
    }

    override fun check() {}

    private fun check(other: T) {
        try {
            AssertionsForClassTypes.assertThat(originalArray.contains(other)).isTrue()
        } catch (e: AssertionFailedError) {
            throw AssertionFailedError("Assertion failed. Expecting array to contain value (${other.formatExceptionString})")
        }
    }
}