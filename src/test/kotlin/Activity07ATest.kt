import activity_07_a.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

// updated: 3/6/23

internal class GradeCheckingTest {
    @Test
    fun checkThrowsAndGrades() {
        // success test case for InvalidInputException
        assertThrows<GradesException.InvalidInputException> {
            checkGrades(intArrayOf(81, 82, 83, 84, 85, 86, 87, 88, 89, 100, 91))    // size = 11
            checkGrades(intArrayOf(81, 82, 83, 84, 85, 86, 87, 88, 89, 100, 91, 88, 82, 90, 90, 90, 90))    // size = 17
        }

        // fail test case for InvalidInputException
        assertThrows<GradesException.InvalidInputException> {
            checkGrades(intArrayOf(81, 82, 83, 84, 85, 86, 87, 88, 100, 0))    // lowest grade is 0
            checkGrades(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))    // lowest grade is 0
        }

        // success test case for IncompleteGradeException
        assertThrows<GradesException.IncompleteGradeException> {
            checkGrades(intArrayOf(81, 82, 83, 84, 85, 86, 87, 88, 100, 0))    // lowest grade is 0
            checkGrades(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))    // lowest grade is 0
        }

        // fail test case for IncompleteGradeException
        assertThrows<GradesException.IncompleteGradeException> {
            checkGrades(intArrayOf(81, 82, 83, 84, 85, 86, 87, 88, 89, 100, 91))    // size = 11
            checkGrades(intArrayOf(81, 82, 83, 84, 85, 86, 87, 88, 89, 100, 91, 88, 82, 90, 90, 90, 90))    // size = 17
        }


        // checking grade result

        // success test cases
        assertEquals(4.0, getAverage(intArrayOf(94,94,94,94,94,94,94,94,94,94)))
        assertEquals(3.5, getAverage(intArrayOf(89,89,89,89,89,89,89,89,89,89)))
        assertEquals(3.0, getAverage(intArrayOf(83,83,83,83,83,83,83,83,83,83)))
        assertEquals(2.5, getAverage(intArrayOf(78,78,78,78,78,78,78,78,78,78)))
        assertEquals(2.0, getAverage(intArrayOf(72,72,72,72,72,72,72,72,72,72)))
        assertEquals(1.5, getAverage(intArrayOf(66,66,66,66,66,66,66,66,66,66)))
        assertEquals(1.0, getAverage(intArrayOf(60,60,60,60,60,60,60,60,60,60)))
        assertEquals(0.0, getAverage(intArrayOf(59,59,59,59,59,59,59,59,59,59)))

        // fail test cases
        assertEquals(3.5, getAverage(intArrayOf(94,94,95,95,96,96,97,98,99,100)))
        assertEquals(4.0, getAverage(intArrayOf(89,89,90,90,91,91,92,92,93,93)))
        assertEquals(4.0, getAverage(intArrayOf(83,83,84,84,85,85,86,86,87,88)))
        assertEquals(4.0, getAverage(intArrayOf(78,78,77,77,78,78,79,80,81,82)))
        assertEquals(4.0, getAverage(intArrayOf(72,72,73,73,74,74,75,75,76,77)))
        assertEquals(4.0, getAverage(intArrayOf(66,66,67,67,68,68,69,69,70,71)))
        assertEquals(4.0, getAverage(intArrayOf(60,60,61,61,62,62,63,63,64,65)))
        assertEquals(4.0, getAverage(intArrayOf(10,20,30,40,50,16,27,38,49,50)))
    }
}
