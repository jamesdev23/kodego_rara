package activity_06_a

sealed class GradeException(message:String): Exception(message) {
    class InvalidOutputException(message: String = "Invalid Output"): GradeException(message)
    class IncompleteGradeException(message: String = "Incomplete Grades"): GradeException(message)
}

class Grade {
    fun checkGrades(gradeList:IntArray){
        if(gradeList.size > 10)
            throw GradeException.InvalidOutputException()

        for(grade in gradeList){
            if(grade == 0) throw GradeException.IncompleteGradeException()
        }
    }
}
fun main(){
    var grades1 = intArrayOf(75,80,83,85,90,95,80,91,82,99,100) // <- 11 entries
    var grades2 = intArrayOf(75,80,83,85,90,95,80,91,82,99)

    // expected: invalid output exception
    Grade().checkGrades(grades1)

    // expected: incomplete grade exception
    grades2[0] = 0
    Grade().checkGrades(grades2)

}