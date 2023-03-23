package activity_05_a

// updated 3/20/23

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

fun main(){
    // certificate student 1
    val student1 = CertificateStudent("James","","Bond")
    student1.courseTaken.add("Computer Science")
    student1.courseTaken.add("Network Technician")
    student1.courseTaken.add("Electrical Technician")

    println("Student 1," + student1.courseTaken.joinToString(","))

    // certificate student 2
    val student2 = CertificateStudent("Juan","Dela","Cruz")
    student2.courseTaken.add("Public Speaking")
    student2.courseTaken.add("Debate")
    student2.courseTaken.add("Advertising Article")

    println("Student 2," + student2.courseTaken.joinToString(","))

    // undergrad student 1
    val undergradStudent1 = UnderGraduateStudent("John","","Smith")
    undergradStudent1.collegeList.add("College of Engineering")
    undergradStudent1.degreeTakenList.add("Bachelor of Interior Design")
    undergradStudent1.degreeYears = 2020
    undergradStudent1.degreeYears = 2
    undergradStudent1.studentStatus = StudentStatus.GRADUATED
//    undergradStudent1.studentStatus = StudentStatus.UNKNOWN
    undergradStudent1.degreeEnd = checkUndergradStudentCourse(undergradStudent1)

    // shows undergrad student info
    print("Undergraduate Studend 1,")
    print(" ${undergradStudent1.collegeList[0]},")
    print(" ${undergradStudent1.degreeTakenList[0]},")
    print(" ${undergradStudent1.degreeStart}(start)")

    // checks if degreeEnd has a value more than 0
    if(undergradStudent1.degreeEnd != 0){
        print(", ${undergradStudent1.degreeEnd}(end)")
    }
}

