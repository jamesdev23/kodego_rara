package activity_06_a


sealed class GradeException(message:String): Exception(message) {
    class FailGradeException(message: String = "Failed Grades"): GradeException(message)
    class IncompleteGradeException(message: String = "Incomplete Grades"): GradeException(message)
}

class Grade {
    fun checkGrades(gradeList:Array<Int>){
        for(grades in gradeList){
            if(grades == 0) throw GradeException.IncompleteGradeException()
            if(grades < 60) throw GradeException.FailGradeException()
        }
    }
}
fun main(){
    var gradeList1:Array<Int> = arrayOf(60,70,80,80,80,80,80,80,90,100)

    gradeList1[9] = 0
    Grade().checkGrades(gradeList1)

//    gradeList1[9] = 59
//    Grade().checkGrades(gradeList1)
}