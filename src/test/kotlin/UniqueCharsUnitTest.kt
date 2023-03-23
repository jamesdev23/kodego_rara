import activity_01_f.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class UniqueCharsUnitTest {

    @Test
    fun testUniqueChars() {
        val string1 = "Bird"
        val string2 = "Cat"
        val expectedResult1 = listOf('a','b','c','d','i','r','t')
        assertEquals(expectedResult1, findUniqueChars(string1, string2))

        val string3 = "Bird"
        val string4 = "BigBird"
        val expectedResult2 = listOf('b','d','g','i','r')
        assertEquals(expectedResult2, findUniqueChars(string3, string4))

        val string5 = "Eat"
        val string6 = "Tea"
        val expectedResult3 = listOf('a','e','t')
        assertEquals(expectedResult3, findUniqueChars(string5, string6))
    }
}