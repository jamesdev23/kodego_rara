package activity_06_a

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

sealed class GradesException(message:String): Exception(message) {
    class InvalidInputException(message: String = "Invalid Input"): GradesException(message)
    class IncompleteGradeException(message: String = "Incomplete Grades"): GradesException(message)
}

class Grades {
    fun checkGrades(gradeList:IntArray){
        when {
            gradeList.size > 10 ->
                throw GradesException.InvalidInputException()

            gradeList.min() == 0 || gradeList.size < 10 ->
                throw GradesException.IncompleteGradeException()
        }

    }
}
fun main(){
    val grades1:IntArray = intArrayOf(75,80,83,85,90,95,80,91,82,99,100) // <- 11 entries
    val grades2:IntArray = intArrayOf(75,80,83,85,90,95,80,91,82,99)

    Grades().checkGrades(grades1)

    grades2[2] = 0
    Grades().checkGrades(grades2)

}