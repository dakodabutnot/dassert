@file:JvmName("DassertTest")

package dev.dakoda.dassert

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.AssertionError

@DisplayName("Equality")
class EqualityTest {

    @Test
    fun booleans() {
        // key and value are the same
        mapOf(
            true to true,
            false to false
        ).forEach { (key, value) ->
            assertEquality(key, value)
            catchInequalityFailure(key, value)
        }

        // key and value are not the same
        mapOf(
            false to true,
            true to false
        ).forEach { (key, value) ->
            assertInequality(key, value)
            catchEqualityFailure(key, value)
        }
    }

    @Test
    fun strings() {
        // key and value are the same
        mapOf(
            "true" to "true",
            "" to "",
            "12345" to "12345",
            "#" to "#",
            "\\\\" to "\\\\",
            " " to " "
        ).forEach { (key, value) ->
            assertEquality(key, value)
            catchInequalityFailure(key, value)
        }

        // key and value are not the same
        mapOf(
            "true" to "false",
            "" to " ",
            "12345" to "12345 ",
            "#" to "$",
            "\\\\\\" to "\\\\",
            " " to "   "
        ).forEach { (key, value) ->
            assertInequality(key, value)
            catchEqualityFailure(key, value)
        }
    }

    @Test
    fun integers() {
        // key and value are the same
        mapOf(
            1 to 1,
            0 to 0,
            -1 to -1
        ).forEach { (key, value) ->
            assertEquality(key, value)
            catchInequalityFailure(key, value)
        }

        // key and value are not the same
        mapOf(
            0 to 1,
            0 to -1,
            -1 to 1
        ).forEach { (key, value) ->
            assertInequality(key, value)
            catchEqualityFailure(key, value)
        }
    }

    private fun assertInequality(key: Any, value: Any) {
        dassert {
            key noEquals value
            key isNotEqualTo value
        }
    }

    private fun assertEquality(key: Any, value: Any) {
        dassert {
            key equals value
            key isEqualTo value
        }
    }

    private fun catchInequalityFailure(key: Any, value: Any) {
        assertThrows<AssertionError> {
            dassert { key noEquals value }
        }
        assertThrows<AssertionError> {
            dassert { key isNotEqualTo value }
        }
    }

    private fun catchEqualityFailure(key: Any, value: Any) {
        assertThrows<AssertionError> {
            dassert { key equals value }
        }
        assertThrows<AssertionError> {
            dassert { key isEqualTo value }
        }
    }
}