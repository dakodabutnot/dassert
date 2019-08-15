package dev.dakoda.dassert

import dev.dakoda.dassert.MapDassert.MapDassertDSL.ValExpect
import dev.dakoda.dassert.MapDassert.MapDassertDSL.ValExpect.Companion.ValExpectant
import org.opentest4j.AssertionFailedError
import java.lang.RuntimeException

fun <K, V> dassertMap(block: MutableMap<K, ValExpect<K, V>>.() -> Unit): ValExpectant<K, V> = ValExpectant(block)

fun <K, V> MutableMap<K, ValExpect<K, V>>.that(valExpect: ValExpect<K, V>) {
    this[valExpect.key] = valExpect
}

private infix fun <K, V> Any.maps(value: V): ValExpect<K, V> {
    return ValExpect(this as K, value)
}

class MapDassert {

    class MapDassertDSL {

        class ValExpect <K, V> (val key: K, val value: V) {

            companion object {

                private fun <K, V> MutableMap<K, ValExpect<K, V>>.assertAsEqualTo(otherMap: Map<K, V>) {
                    for (valExpect in this.values) {
                        val key = valExpect.key
                        val value1 = otherMap[key]
                        val value2 = this@assertAsEqualTo[key]?.value
                        try {
                            dassert {
                                value1 equals value2
                            }
                        } catch (assertionFailure: AssertionFailedError) {
                            if (value1 == null) {
                                throw RuntimeException("Error during assertion. The key [$key] does not exist in the supplied map.")
                            } else {
                                throw RuntimeException("Error during assertion. At key [$key], expected value " +
                                        "to be ${assertionFailure.expected} but was ${assertionFailure.actual}.")
                            }
                        }
                    }
                }

                class ValExpectant <K, V>(
                    private val block: MutableMap<K, ValExpect<K, V>>.() -> Unit
                ) {
                    fun on(otherMap: MutableMap<K, V>) {
                        mutableMapOf<K, ValExpect<K, V>>().also(block).assertAsEqualTo(otherMap)
                    }
                }
            }

        }

    }
}