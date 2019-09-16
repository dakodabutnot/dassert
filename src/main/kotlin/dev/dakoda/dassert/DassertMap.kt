package dev.dakoda.dassert

import org.opentest4j.AssertionFailedError
import java.util.ArrayList

class MapDassertion<K, V>(
    private val mutableMap: Map<K, V>
) {

    private var mapDassert = mutableMapOf(mutableMap to arrayListOf<MapDassertExpectant<K, V>>())

    @Suppress("UNCHECKED_CAST")
    infix fun <K: Any, V> K.maps(value: V) {
        try {
            dassert {
                (mutableMap as Map<K, V>) has this@maps
                mutableMap[this@maps] equals value
            }
            (mapDassert[mutableMap]!! as ArrayList<MapDassertExpectant<K, V>>).add(MapDassertExpectant(this, value))
        } catch (e: AssertionFailedError) {
            throw AssertionFailedError("Assertion failed. Expecting key [${this}] to map onto ${e.expected}, but was ${e.actual}.")
        }
    }

    class MapDassertExpectant<K, V>(val key: K, val value: V)
}