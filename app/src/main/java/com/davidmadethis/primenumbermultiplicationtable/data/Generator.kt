package com.davidmadethis.primenumbermultiplicationtable.data

import kotlin.coroutines.experimental.buildSequence
import kotlin.math.sqrt

object Generator {
    /**
     * Returns a list of all prime numbers up to *and including* [n].
     */
    fun primesUpTo(n: Int): List<Int> {
        return sieveOfEratosthenes(n)
    }

    private fun sieveOfEratosthenes(n: Int): List<Int> {
        /* Index is the number, boolean value is whether the number is possibly prime */
        val nums = BooleanArray(n + 1) { i -> i !in 0..1 }   // initially true for all x in 2..n

        var p = 2
        while (p != -1) {
            /* Mark composite numbers at 2p, 3p, 4p, ... */
            ((p * 2)..n step p).forEach { np ->
                nums[np] = false
            }

            /* Find the first number greater than p in the list that is not marked */
            p = nums.withIndex().indexOfFirst { (index, unmarked) ->
                index > p && unmarked
            }
        }

        return nums.withIndex()
            .filter { (_, isPrime) -> isPrime }
            .map { it.index }
    }
}


fun primeNumberSequence(): Sequence<Int> {
    /*
    Builds a sequence by lazily yielding values one by one
    In this case a sequence of prime numbers
    */
    return buildSequence {
        yieldAll(generateSequence(2) { it + 1 }
            .filter { it.isPrime() })
    }
}

fun nthPrime(n: Int): Int {
    require(n > 0) { "nth undefined for input: $n." }
    return primeNumberSequence().take(n).last()
}

/**
 * Determines if the integer is a prime number.
 *
 * **Time**: `O(n)`
 *
 * **Space**: `O(1)`
 */
fun Int.isPrime(): Boolean {
    if (this <= 1)
        return false

    val sqrt = sqrt(toDouble()).toInt()
    return (2..sqrt).all { this % it != 0 }
}