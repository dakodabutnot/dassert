package dev.dakoda.dassert.array

import dev.dakoda.dassert.Dassert
import dev.dakoda.dassert.DassertionExtension
import dev.dakoda.dassert.formatExceptionString
import org.assertj.core.api.AssertionsForClassTypes
import org.opentest4j.AssertionFailedError

// TODO: Optional clauses (!A n B)
// TODO: Match all in a collection as unequal/equal

class DassertionExtensionArrayContains<T: Any>(
    private val dassert: Dassert,
    private val originalArray: Array<T>,
    private val firstValue: T
) : DassertionExtension<T> {

    override fun check() {
        try {
            AssertionsForClassTypes.assertThat(originalArray.contains(firstValue)).isTrue()
        } catch (e: AssertionFailedError) {
            throw AssertionFailedError("Assertion failed. Expecting array to contain value (${firstValue.formatExceptionString})")
        }
    }

    init {
        @Suppress("UNCHECKED_CAST")
        dassert.extensions.add(this as DassertionExtensionArrayContains<Any>)
    }

    infix fun and(other: T): DassertionExtensionArrayContainsAND<T> {
        removeDassertReference(this@DassertionExtensionArrayContains)
        return DassertionExtensionArrayContainsAND(originalArray)
    }

    @Suppress("UNCHECKED_CAST")
    infix fun or(other: T): DassertionExtensionArrayContainsOR<T> {
        return DassertionExtensionArrayContainsOR(originalArray, firstValue, other).also {
            removeDassertReference(this@DassertionExtensionArrayContains)
            dassert.extensionsOR.add(it as DassertionExtensionArrayContainsOR<Any>)
        }
    }

    @Suppress("UNCHECKED_CAST")
    infix fun xor(other: T): DassertionExtensionArrayContainsXOR<T> {
        return DassertionExtensionArrayContainsXOR(originalArray, firstValue, other).also {
            removeDassertReference(this@DassertionExtensionArrayContains)
            dassert.extensionsXOR.add(it as DassertionExtensionArrayContainsXOR<Any>)
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun removeDassertReference(self: DassertionExtensionArrayContains<T>) {
        dassert.extensions.remove(self as DassertionExtensionArrayContains<Any>)
    }
}