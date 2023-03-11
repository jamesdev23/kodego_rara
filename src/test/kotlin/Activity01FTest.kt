import activity_01_f.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class UniqueCharsTest {

    @Test
    fun testUniqueChars() {
        val string1 = "Bird"
        val string2 = "Cat"
        assertEquals("BIRDCAT", findUniqueChars(string1, string2))

        val string3 = "Bird"
        val string4 = "BigBird"
        assertEquals("BIRDG", findUniqueChars(string3, string4))

        val string5 = "Eat"
        val string6 = "Tea"
        assertEquals("TEA", findUniqueChars(string5, string6))
    }
}