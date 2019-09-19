package dev.dakoda.dassert.map

import dev.dakoda.dassert.dassert
import org.opentest4j.AssertionFailedError

class MapDassertion<K, V>(private val mutableMap: Map<K, V>) {

    infix fun <K: Any, V> K.onto(value: V) = maps(value)

    @Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
    infix fun <K: Any, V> K.maps(value: V) {
        try {
            dassert {
                (mutableMap as Map<K, V>) has this@maps
                mutableMap[this@maps] equals value
            }
        } catch (e: AssertionFailedError) {
            throw AssertionFailedError("Assertion failed. Expecting existing key ${this@maps} to map onto ${e.expected}, but was ${e.actual}.")
        } catch (e: AssertionError) {
            throw AssertionFailedError("Assertion failed. Expecting key (${if (this@maps is String) "\"${this@maps}\"" else this@maps}) to exist in map, but it did not.")
        }
    }
}