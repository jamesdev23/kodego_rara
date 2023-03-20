package activity_07_a

// updated 3/20/23

import activity_05_a.StudentStatus
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

class CertificateStudent(firstname: String,middlename: String,lastname: String):Student(firstname, middlename, lastname){
    var courseTaken:ArrayList<String> = ArrayList()
}

class UnderGraduateStudent(firstname: String,middlename: String,lastname: String):Student(firstname, middlename, lastname){
    var collegeList: ArrayList<String> = ArrayList()
    var yearJoined: String = ""
    var degreeTakenList: ArrayList<String> = ArrayList()
    var degreeStart: Int = 2020 // Int type because value is only a year instead of whole date (month/day/year)
    var degreeYears: Int = 0
    var degreeEnd: Int = 0
    var studentStatus = StudentStatus.UNKNOWN
}

fun checkUndergradStudentCourse(undergradStudent: UnderGraduateStudent): Int {
    var newDegreeEnd = 0
    if(undergradStudent.studentStatus == StudentStatus.GRADUATED){
        newDegreeEnd = undergradStudent.degreeStart + undergradStudent.degreeYears
    }
    return newDegreeEnd
}

class MasterStudent(firstname: String,middlename: String,lastname: String):Student(firstname, middlename, lastname){
    var collegeList:ArrayList<String> = ArrayList()
    var yearJoined:String = ""
    var masterDegreeTaken:String = ""
}

class GraduateStudent(firstname: String,middlename: String,lastname: String):Student(firstname, middlename, lastname){
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

fun checkGrades(grades:IntArray){
    when {
        grades.size > 10 ->
            throw GradesException.InvalidInputException()
        grades.contains(0) ->
            throw GradesException.IncompleteGradeException()
    }
}
fun getAverage(gradeList:IntArray): Double {
    val resultAverage = gradeList.average()

    return when {
        resultAverage >= 94 -> 4.0
        resultAverage >= 89 -> 3.5
        resultAverage >= 83 -> 3.0
        resultAverage >= 78 -> 2.5
        resultAverage >= 72 -> 2.0
        resultAverage >= 66 -> 1.5
        resultAverage >= 60 -> 1.0
        resultAverage < 60 -> 0.0
        else -> throw IllegalArgumentException("Invalid average value: $resultAverage")
    }
}

// exceptions from activity 6A and 7A

sealed class GradesException(message:String): Exception(message) {
    class InvalidInputException(message: String = "Invalid Input"): GradesException(message)
    class IncompleteGradeException(message: String = "Incomplete Grades"): GradesException(message)
}

fun main(){
//    var gradeChecking = GradeChecking()
//    val grades1:IntArray = intArrayOf(75,80,83,85,90,95,80,91,82,99,100) // <- 11 grades
//    val grades2:IntArray = intArrayOf(75,80,83,85,90,95,80,91,82,99) // ideal no. of grades (10 grades)
//    val grades3:IntArray = intArrayOf(75,80,83,85,90,95,80,91,82) // <- only 9 grades

//
    // expected: invalid input exception
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