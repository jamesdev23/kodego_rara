import activity_01_d.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MonetaryAppTest {
    @Test
    fun testMonetaryApp() {
        // Set up test input
        // 1st input
        val monetaryAmounts = mutableListOf(10.0, 20.0, 30.0, 40.0, 50.0)
        val divisor = 2
        val result = calculateResult(monetaryAmounts, divisor)
        // 2nd input
        val monetaryAmounts2 = mutableListOf(0.0, 0.0, 0.0, 0.0, 0.0)
        val divisor2 = 2
        val result2 = calculateResult(monetaryAmounts2, divisor2)
        // 3rd input
        val monetaryAmounts3 = mutableListOf(10.0, 20.0, 30.0, 40.0, 50.0)
        val divisor3 = 0
        val result3 = calculateResult(monetaryAmounts3, divisor3)
        // 4th input
        val monetaryAmounts4 = mutableListOf(0.0, 0.0, 0.0, 0.0, 0.0)
        val divisor4 = 0
        val result4 = calculateResult(monetaryAmounts4, divisor4)
        // 5th input
        val monetaryAmounts5 = mutableListOf(-100.0, -100.0, -100.0, -100.0, -100.0)
        val divisor5 = -100
        val result5 = calculateResult(monetaryAmounts5, divisor5)
        // 6th input
        val monetaryAmounts6 = mutableListOf(1_000_000.0, 1_000_000.0, 1_000_000.0, 1_000_000.0, 1_000_000.0)
        val divisor6 = 1_000
        val result6 = calculateResult(monetaryAmounts6, divisor6)


        // test cases

        // success
        assertEquals(75.0, result)
        assertEquals(0.0, result2)
        assertEquals( Double.POSITIVE_INFINITY, result3)
        assertEquals(Double.NaN, result4)
        assertEquals(-5.0, result5)
        assertEquals(5_000.0, result6)

        // fail
        assertEquals(75.0, result2)
        assertEquals(75.0, result3)
        assertEquals(75.0, result4)
        assertEquals(75.0, result5)
        assertEquals(75.0, result6)

    }
}