import activity_01_d.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MonetaryAppUnitTest {
    @Test
    fun testMonetaryApp() {
        val monetaryAmounts = mutableListOf(10.0, 20.0, 30.0, 40.0, 50.0)
        val monetaryAmounts2 = mutableListOf(0.0, 0.0, 0.0, 0.0, 0.0)
        val monetaryAmounts3 = mutableListOf(10.0, 20.0, 30.0, 40.0, 50.0)
        val monetaryAmounts4 = mutableListOf(0.0, 0.0, 0.0, 0.0, 0.0)
        val monetaryAmounts5 = mutableListOf(-100.0, -100.0, -100.0, -100.0, -100.0)

        val divisor = 2
        val divisor2 = 2
        val divisor3 = 0
        val divisor4 = 0
        val divisor5 = -100

        val result = calculateResult(monetaryAmounts, divisor)
        val result2 = calculateResult(monetaryAmounts2, divisor2)
        val result3 = calculateResult(monetaryAmounts3, divisor3)
        val result4 = calculateResult(monetaryAmounts4, divisor4)
        val result5 = calculateResult(monetaryAmounts5, divisor5)

        assertEquals(75.0, result)
        assertEquals(0.0, result2)
        assertEquals( Double.POSITIVE_INFINITY, result3)
        assertEquals(Double.NaN, result4)
        assertEquals(-5.0, result5)

    }
}