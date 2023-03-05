import activity_01_f.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniqueCharsTest {

    @Test
    fun testUniqueChars() {
        val string1 = "Bird"
        val string2 = "Cat"
        assertEquals("birdcat", findUniqueChars(string1, string2))

        val string3 = "Bird"
        val string4 = "BigBird"
        assertEquals("birdg", findUniqueChars(string3, string4))

        val string5 = "Eat"
        val string6 = "Tea"
        assertEquals("tea", findUniqueChars(string5, string6))
    }
}