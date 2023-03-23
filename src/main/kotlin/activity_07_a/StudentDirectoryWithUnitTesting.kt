package activity_07_a

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
        grades.min() == 0 ->
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

sealed class GradesException(message:String): Exception(message) {
    class InvalidInputException(message: String = "Invalid Input"): GradesException(message)
    class IncompleteGradeException(message: String = "Incomplete Grades"): GradesException(message)
}

fun main(){
}