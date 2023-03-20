import activity_01_h.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FindPrimeNumbersTest{
    @Test
    fun checkPrimeNumbersResult() {
        val expected1: ArrayList<Int> = arrayListOf(1,2,3,5,7)
        val expected2: ArrayList<Int> = arrayListOf(1)
        val expected3: ArrayList<Int> = arrayListOf()

        // success
        assertEquals(expected1, findPrimes(1,10))
        assertEquals(expected2, findPrimes(1,1))
        assertEquals(expected3, findPrimes(-1,-10))

        // fail
        assertEquals(expected2, findPrimes(1, 10))
        assertEquals(expected1, findPrimes(1,1))
        assertEquals(expected2, findPrimes(-1,-10))
    }
}