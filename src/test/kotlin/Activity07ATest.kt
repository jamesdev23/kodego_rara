import activity_07_a.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

// updated: 3/6/23

internal class GradeCheckingTest {

    @Test
    fun checkThrowsAndGrades() {
        assertThrows<GradesException.InvalidInputException> {
            // expected result: success
            checkGrades(intArrayOf(81,82,83,84,85,86,87,88,89,100,91))    // size = 11
            checkGrades(intArrayOf(81,82,83,84,85,86,87,88,89,100,91,88,82,90,90,90,90))    // size = 17

            // expected result: fail
            checkGrades(intArrayOf(81))   // size = 1
            checkGrades(intArrayOf())   // size = 0
        }

        assertThrows<GradesException.IncompleteGradeException> {
            // expected result: success
            checkGrades(intArrayOf(81,82,83,84,85,86,87,88,100,0))    // lowest grade is 0
            checkGrades(intArrayOf(0,0,0,0,0,0,0,0,0,0))    // lowest grade is 0

            // expected result: fail
            checkGrades(intArrayOf(81,82,83,84,85,86,87,88,89,100,91))    // size = 11
            checkGrades(intArrayOf(81,82,83,84,85,86,87,88,89,100,91,88,82,90,90,90,90))    // size = 17
        }
//
//        assertThrows<GradesException.IncompleteGradeException> {
//            // expected result: success
//            checkGrades(intArrayOf(81,82,83,84,85)) // size = 5
//            checkGrades(intArrayOf(81)) // size = 1
//
//            // expected result: fail
//            checkGrades(intArrayOf(81,82,83,84,85,86,87,88,89,100,91))    // size = 11, grades != 0
//            checkGrades(intArrayOf(81,82,83,84,85,86,87,88,89,100,91,88,82,90,90,90,90))    // size = 17, grades != 0
//        }
//
//        assertThrows<GradesException.GradeOutOfRangeException> {
//            // expected result: success
//            checkGrades(intArrayOf(81,82,83,84,85,86,87,88,100,-10))  // 1 grade set below 0
//            checkGrades(intArrayOf(-10,-10,-10,-10,-10,-10,-10,-10,-10,-10))  // all is below 0
//
//            // expected result: fail
//            checkGrades(intArrayOf(80,80,80,80,80,80,80,80,80,80))
//            checkGrades(intArrayOf(100,100,100,100,100,100,100,100,100,100))
//        }
//
//        assertThrows<GradesException.GradeOutOfRangeException> {
//            // expected result: success
//            checkGrades(intArrayOf(120,120,120,120,120,120,120,120,120,120)) // all above 100
//            checkGrades(intArrayOf(1_000,10_000,100_000,1_000_000,10_000_000,10_000_000,10_000_000,10_000_000,10_000_000,10_000_000)) // up to 10m
//
//            // expected result: fail
//            checkGrades(intArrayOf(80,80,80,80,80,80,80,80,80,80))
//            checkGrades(intArrayOf(100,100,100,100,100,100,100,100,100,100))
//        }
//
//        // checking grade result
//
//        // success
//        assertEquals(4.0, getAverage(intArrayOf(94,94,94,94,94,94,94,94,94,94)))
//        assertEquals(3.5, getAverage(intArrayOf(89,89,89,89,89,89,89,89,89,89)))
//        assertEquals(3.0, getAverage(intArrayOf(83,83,83,83,83,83,83,83,83,83)))
//        assertEquals(2.5, getAverage(intArrayOf(78,78,78,78,78,78,78,78,78,78)))
//        assertEquals(2.0, getAverage(intArrayOf(72,72,72,72,72,72,72,72,72,72)))
//        assertEquals(1.5, getAverage(intArrayOf(66,66,66,66,66,66,66,66,66,66)))
//        assertEquals(1.0, getAverage(intArrayOf(60,60,60,60,60,60,60,60,60,60)))
//        assertEquals(0.0, getAverage(intArrayOf(59,59,59,59,59,59,59,59,59,59)))
//
//        // fail
//        assertEquals(3.5, getAverage(intArrayOf(94,94,95,95,96,96,97,98,99,100)))
//        assertEquals(4.0, getAverage(intArrayOf(89,89,90,90,91,91,92,92,93,93)))
//        assertEquals(4.0, getAverage(intArrayOf(83,83,84,84,85,85,86,86,87,88)))
//        assertEquals(4.0, getAverage(intArrayOf(78,78,77,77,78,78,79,80,81,82)))
//        assertEquals(4.0, getAverage(intArrayOf(72,72,73,73,74,74,75,75,76,77)))
//        assertEquals(4.0, getAverage(intArrayOf(66,66,67,67,68,68,69,69,70,71)))
//        assertEquals(4.0, getAverage(intArrayOf(60,60,61,61,62,62,63,63,64,65)))
//        assertEquals(4.0, getAverage(intArrayOf(10,20,30,40,50,16,27,38,49,50)))
    }
}
