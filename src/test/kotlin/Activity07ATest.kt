import activity_07_a.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class GradeTest {
    val gradeChecking: GradeChecking = GradeChecking()

    @Test
    fun checkGrades() {
        assertThrows<GradesException.InvalidInputException> {
            gradeChecking.checkGrades(intArrayOf(81,82,83,84,85,86,87,88,89,100,91))
        }

        assertThrows<GradesException.IncompleteGradeException> {
            gradeChecking.checkGrades(intArrayOf(81,82,83,84,85,86,87,88,100,0))
        }

        assertThrows<GradesException.IncompleteGradeException> {
            gradeChecking.checkGrades(intArrayOf(81,82,83,84,85))
        }

        assertThrows<GradesException.GradeOutOfRangeException> {
            gradeChecking.checkGrades(intArrayOf(81,82,83,84,85,86,87,88,100,-10))
        }
        assertThrows<GradesException.GradeOutOfRangeException> {
            gradeChecking.checkGrades(intArrayOf(81,82,83,84,85,86,87,88,100,110))
        }
    }

    @Test
    fun averageGradeIs4() {
        assertEquals(4.0, gradeChecking.getAverage(intArrayOf(94,94,94,94,94,94,94,94,94,94)))
        assertEquals(4.0, gradeChecking.getAverage(intArrayOf(94,94,95,95,96,96,97,98,99,100)))
    }

    @Test
    fun averageGradeIs3Point5() {
        assertEquals(3.5, gradeChecking.getAverage(intArrayOf(89,89,89,89,89,89,89,89,89,89)))
        assertEquals(3.5, gradeChecking.getAverage(intArrayOf(89,89,90,90,91,91,92,92,93,93)))
    }

    @Test
    fun averageGradeIs3() {
        assertEquals(3.0, gradeChecking.getAverage(intArrayOf(83,83,83,83,83,83,83,83,83,83)))
        assertEquals(3.0, gradeChecking.getAverage(intArrayOf(83,83,84,84,85,85,86,86,87,88)))
    }

    @Test
    fun averageGradeIs2Point5() {
        assertEquals(2.5, gradeChecking.getAverage(intArrayOf(78,78,78,78,78,78,78,78,78,78)))
        assertEquals(2.5, gradeChecking.getAverage(intArrayOf(78,78,77,77,78,78,79,80,81,82)))
    }

    @Test
    fun averageGradeIs2() {
        assertEquals(2.0, gradeChecking.getAverage(intArrayOf(72,72,72,72,72,72,72,72,72,72)))
        assertEquals(2.0, gradeChecking.getAverage(intArrayOf(72,72,73,73,74,74,75,75,76,77)))
    }

    @Test
    fun averageGradeIs1Point5() {
        assertEquals(1.5, gradeChecking.getAverage(intArrayOf(66,66,66,66,66,66,66,66,66,66)))
        assertEquals(1.5, gradeChecking.getAverage(intArrayOf(66,66,67,67,68,68,69,69,70,71)))
    }

    @Test
    fun averageGradeIs1() {
        assertEquals(1.0, gradeChecking.getAverage(intArrayOf(60,60,60,60,60,60,60,60,60,60)))
        assertEquals(1.0, gradeChecking.getAverage(intArrayOf(60,60,61,61,62,62,63,63,64,65)))
    }

    @Test
    fun averageGradeIsZero() {
        assertEquals(0.0, gradeChecking.getAverage(intArrayOf(59,59,59,59,59,59,59,59,59,59)))
        assertEquals(0.0, gradeChecking.getAverage(intArrayOf(10,20,30,40,50,16,27,38,49,50)))
    }

}
