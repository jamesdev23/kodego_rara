import activity_01_f.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class UniqueCharsTest {

    @Test
    fun testUniqueChars() {
        val string1 = "Bird"
        val string2 = "Cat"
        // success
        assertEquals("BirdCat", findUniqueChars(string1, string2))

        // fail
        assertEquals("CatBird", findUniqueChars(string1, string2))

        val string3 = "Bird"
        val string4 = "BigBird"
        // success
        assertEquals("Birdg", findUniqueChars(string3, string4))

        // fail
        assertEquals("Big", findUniqueChars(string3, string4))

        val string5 = "Eat"
        val string6 = "Tea"
        // success
        assertEquals("Tea", findUniqueChars(string5, string6))

        // fail
        assertEquals("Eat", findUniqueChars(string5, string6))
    }
}