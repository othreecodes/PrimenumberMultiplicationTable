package com.davidmadethis.primenumbermultiplicationtable

import com.davidmadethis.primenumbermultiplicationtable.data.Generator
import com.davidmadethis.primenumbermultiplicationtable.data.isPrime
import com.davidmadethis.primenumbermultiplicationtable.data.nthPrime
import com.davidmadethis.primenumbermultiplicationtable.ui.main.MainViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PrimeNumberUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkPrimeNumberReturnsValidResult() {

       assert(3.isPrime())
       assert(31.isPrime())
       assert(11.isPrime())
       assert(37.isPrime())
        assertFalse(8.isPrime())
        assertFalse(50.isPrime())
        assertFalse(30.isPrime())
        assertFalse(95.isPrime())
    }

    @Test
    fun PrimeNumberGeneratorGeneratesPrimeNumbers() {
        val result = Generator.primesUpTo(nthPrime(10))

        assert(result.size == 10)
        assert(result == listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))
    }


}
