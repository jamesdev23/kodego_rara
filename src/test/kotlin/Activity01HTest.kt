import activity_01_h.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PrimeNumbers{
    @Test
    fun checkPrimeNumbersResult() {
        val answer1to10:ArrayList<Int> = arrayListOf(1,2,3,5,7)
        val answer1to1:ArrayList<Int> = arrayListOf(1)
        val answerNegativeNumbers: ArrayList<Int> = arrayListOf()

        // success
        assertEquals(answer1to10, findPrimes(1,10))
        assertEquals(answer1to1, findPrimes(1,1))
        assertEquals(answerNegativeNumbers, findPrimes(-1,-10))

        // fail
        assertEquals(answer1to1, findPrimes(1, 10))
        assertEquals(answer1to10, findPrimes(1,1))
        assertEquals(answer1to1, findPrimes(-1,-10))
    }
}