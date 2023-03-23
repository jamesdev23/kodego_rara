import activity_07_a.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

// updated: 3/6/23

internal class StudentDirectoryUnitTest {
    @Test
    fun checkGradeExceptions() {
        assertThrows<GradesException.InvalidInputException> {
            checkGrades(intArrayOf(81, 82, 83, 84, 85, 86, 87, 88, 89, 100, 91))
            checkGrades(intArrayOf(81, 82, 83, 84, 85, 86, 87, 88, 89, 100, 91, 88, 82, 90, 90, 90, 90))
        }

        assertThrows<GradesException.IncompleteGradeException> {
            checkGrades(intArrayOf(81, 82, 83, 84, 85, 86, 87, 88, 100, 0))
            checkGrades(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        }
    }

    fun checkGradeResult() {
        assertEquals(4.0, getAverage(intArrayOf(94,94,94,94,94,94,94,94,94,94)))
        assertEquals(3.5, getAverage(intArrayOf(89,89,89,89,89,89,89,89,89,89)))
        assertEquals(3.0, getAverage(intArrayOf(83,83,83,83,83,83,83,83,83,83)))
        assertEquals(2.5, getAverage(intArrayOf(78,78,78,78,78,78,78,78,78,78)))
        assertEquals(2.0, getAverage(intArrayOf(72,72,72,72,72,72,72,72,72,72)))
        assertEquals(1.5, getAverage(intArrayOf(66,66,66,66,66,66,66,66,66,66)))
        assertEquals(1.0, getAverage(intArrayOf(60,60,60,60,60,60,60,60,60,60)))
        assertEquals(0.0, getAverage(intArrayOf(59,59,59,59,59,59,59,59,59,59)))
    }
}
