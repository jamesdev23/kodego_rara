package activity_04_a

import mu.KotlinLogging
val logger = KotlinLogging.logger {  }

class Student (var firstName:String, var middleName:String, var lastName:String, var nickName:String){
    var id:String = ""
    var yearEnrolled:String = ""
}

private var studentList: ArrayList<Student> = arrayListOf(
    Student("James","Nico","Rara","James"),
    Student("Enzo", "Lynch", "Sierra","Enzo"),
    Student("Alana","Robinson","Kosma","Lana"),
    Student("Kenny","Hicks","Isa","Ken")
)

fun main(){
    var searchResult: ArrayList<Student> = ArrayList()


    val searchTerm = "jam"

    val name1 = "ra"
    val searchCategory1 = "lastname"
    val name2 = "s"
    val searchCategory2 = "middlename"
    val name3 = "en"
    val searchCategory3 = "nickname"
    val name4 = "enzos"
    val searchCategory4 = "nickname"


    searchResult = searchStudentWildSearch(searchTerm)
    showResult(searchResult)

    searchResult = searchStudentWildSearch(name1, searchCategory1)
    showResult(searchResult)

    searchResult = searchStudentWildSearch(name2, searchCategory2)
    showResult(searchResult)

    searchResult = searchStudentWildSearch(name3, searchCategory3)
    showResult(searchResult)

    searchResult = searchStudentWildSearch(name4, searchCategory4)
    showResult(searchResult)



}
fun searchStudentWildSearch(searchTerm:String): ArrayList<Student>{
    val result:ArrayList<Student> = ArrayList()
    var found = false

    println("Search name: $searchTerm")

    for(student in studentList){
        if(student.lastName.contains(searchTerm, ignoreCase = true) ||
            student.middleName.contains(searchTerm, ignoreCase = true) ||
            student.firstName.contains(searchTerm, ignoreCase = true)) {

            result.add(student)
            found = true
        }
    }

    return if(!found) ArrayList() else result
}

fun searchStudentWildSearch(name: String, searchCategory: String): ArrayList<Student>{
    val result:ArrayList<Student> = ArrayList()
    var found = false

    println("Search name: $name")
    println("Search Category: $searchCategory")

    when(searchCategory){
        "lastname" ->
            for(student in studentList){
                if(student.lastName.contains(name, ignoreCase = true)){
                    result.add(student)
                    found = true
                }
            }
        "middlename" ->
            for(student in studentList){
                if(student.middleName.contains(name, ignoreCase = true)){
                    result.add(student)
                    found = true
                }
            }
        "nickname" ->
            for(student in studentList){
                if(student.nickName.contains(name, ignoreCase = true)){
                    result.add(student)
                    found = true
                }
            }
    }

    return if(!found) ArrayList() else result
}

fun showResult(result: ArrayList<Student>){
    if(result.isEmpty()) {
        println("Search Result: Name not found.")
    }else {
        println("Search Result: ")
        for(student in result){
            println("${student.firstName} ${student.middleName} ${student.lastName} (nickname: ${student.nickName})")
        }
        println("")
    }
}

