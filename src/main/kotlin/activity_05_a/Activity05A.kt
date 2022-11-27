package activity_05_a

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
    var studentStatus = StudentStatus.UNKNOWN

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

fun main(){
    var student1 = CertificateStudent()
    var student2 = CertificateStudent()
    var student3 = Student("","","")

    student1.courseTaken.add("Computer Science")
    student1.courseTaken.add("Network Technician")
    student1.courseTaken.add("Electrical Technician")
    student2.courseTaken.add("Public Speaking")
    student2.courseTaken.add("Debate")
    student2.courseTaken.add("Advertising Article")

    student3.firstname = "James"
    student3.address = "sample address"
}

