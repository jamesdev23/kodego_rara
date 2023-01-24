package activity_07_a

import java.util.*
import kotlin.collections.ArrayList

open class Person(var firstname:String,var middlename:String,var lastname:String) {
    var address:String = ""
    var birthday: Date = Date()
}

open class Student(firstname: String,middlename: String,lastname: String) : Person(firstname,middlename,lastname){
    var yearEntered:String = ""
    var id:String = ""
}

class CertificateStudent{
    var courseTaken:ArrayList<String> = ArrayList()
}

class UnderGraduateStudent{
    var collegeList:ArrayList<String> = ArrayList()
    var yearJoined:String = ""
    var degreeTaken:String = ""
    var degreeStart:String = ""
    var yearOfDegree:Int = 0
    var studentStatus:StudentStatus = StudentStatus.UNKNOWN

    fun collegeDegreeEnd(studentStatus:StudentStatus){
        if(studentStatus == StudentStatus.GRADUATED){
            var degreeEnd:String = ""
        }
    }
}

class MasterStudent{
    var collegeList:ArrayList<String> = ArrayList()
    var yearJoined:String = ""
    var masterDegreeTaken:String = ""
}

class GraduateStudent {
    var collegeList:ArrayList<String> = ArrayList()
    var yearJoined:String = ""
    var graduateDegreeTaken:String = ""
}

enum class StudentStatus {
    LEAVE_OF_ABSENCE,
    ONGOING,
    GRADUATED,
    WILL_BEGIN,
    SHIFTED,
    UNKNOWN,
}

// exceptions from act6a and act7a

sealed class GradesException(message:String): Exception(message) {
    class InvalidInputException(message: String = "Invalid Input"): GradesException(message)
    class IncompleteGradeException(message: String = "Incomplete Grades"): GradesException(message)
    class GradeOutOfRangeException(message: String = "Grades are not within 0 to 100 range"): GradesException(message)
}

class GradeChecking {
    fun checkGrades(grades:IntArray){
        if(grades.size > 10)
            throw GradesException.InvalidInputException()

        // using this instead of finding the zero grade one by one
        if(grades.size < 10 || grades.min() == 0)
            throw GradesException.IncompleteGradeException()

        if(grades.min() < 0 || grades.max() > 100)
            throw GradesException.GradeOutOfRangeException()

    }
    fun getAverage(gradeList:IntArray): Double{
        val resultAverage = gradeList.average()

        if(resultAverage >= 94){
            return 4.0
        }
        if(resultAverage >= 89){
            return 3.5
        }
        if(resultAverage >= 83){
            return 3.0
        }
        if(resultAverage >= 78){
            return 2.5
        }
        if(resultAverage >= 72){
            return 2.0
        }
        if(resultAverage >= 66){
            return 1.5
        }
        if(resultAverage >= 60){
            return 1.0
        }
        // return 0.0 if below 60
        return 0.0
    }
}
fun main(){
//    val grades1:IntArray = intArrayOf(75,80,83,85,90,95,80,91,82,99,100) // <- 11 grades
//    val grades2:IntArray = intArrayOf(75,80,83,85,90,95,80,91,82,99) // ideal no. of grades (10 grades)
//    val grades3:IntArray = intArrayOf(75,80,83,85,90,95,80,91,82) // <- only 9 grades
//    var gradeChecking = GradeChecking()
//
//    // expected: invalid output exception
//    gradeChecking.checkGrades(grades1)
//
//    // expected: incomplete grade exception
//    grades2[0] = 0
//    gradeChecking.checkGrades(grades2)
//
//    // also incomplete grade exception
//    gradeChecking.checkGrades(grades3)

//    grades2[0] = 80
//    gradeChecking.checkGrades(grades2)
//    var average1 = gradeChecking.getAverage(grades2)
//    println(average1)



}