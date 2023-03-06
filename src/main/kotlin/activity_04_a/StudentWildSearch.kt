package activity_04_a

// Student search using string and result is using Student class.
// Also, another search function that will ask either first/last/nickname.

import mu.KotlinLogging
val logger = KotlinLogging.logger {  }

class Student (var firstName:String, var middleName:String, var lastName:String, var nickName:String){
    var id:String = ""
    var yearEnrolled:String = ""
}


fun main(){
    var searchResult: ArrayList<Student> = ArrayList()

    val students: ArrayList<Student> = arrayListOf(
        Student("James","Nico","Rara","James"),
        Student("Enzo", "Lynch", "Sierra","Enzo"),
        Student("Alana","Robinson","Kosma","Lana"),
        Student("Kenny","Hicks","Isa","Ken")
    )
    val searchTerm = "jam"

    val name1 = "ra"
    val searchCategory1 = "lastname"
    val name2 = "s"
    val searchCategory2 = "middlename"
    val name3 = "en"
    val searchCategory3 = "nickname"
    val name4 = "enzos"
    val searchCategory4 = "nickname"


    searchResult = searchStudentWildSearch(searchTerm, students)
    showResult(searchResult)

    searchResult = searchStudentWildSearch(name1, searchCategory1, students)
    showResult(searchResult)

    searchResult = searchStudentWildSearch(name2, searchCategory2, students)
    showResult(searchResult)

    searchResult = searchStudentWildSearch(name3, searchCategory3, students)
    showResult(searchResult)

    searchResult = searchStudentWildSearch(name4, searchCategory4, students)
    showResult(searchResult)



}
fun searchStudentWildSearch(searchTerm:String, studentList: ArrayList<Student>): ArrayList<Student>{
    val result:ArrayList<Student> = ArrayList()
    var found = false

    println("Search name: $searchTerm")

    // searches student name from student list (lastname/middlename/firstname). if found, returns arraylist of students. if not, returns empty arraylist
    for(student in studentList){
        if(student.lastName.contains(searchTerm, ignoreCase = true) ||
            student.middleName.contains(searchTerm, ignoreCase = true) ||
            student.firstName.contains(searchTerm, ignoreCase = true)) {

            result.add(student)
            found = true

//            logger.info { "student: ${student.firstName} ${student.middleName} ${student.lastName} ${student.nickName}" }
        }
    }

    // returns empty arraylist if nothing found. Otherwise, returns ArrayList of students
    return if(!found) ArrayList() else result
}

// 2nd student wild search, but accepts either of lastname,middlename or nickname, depends  on search category.
fun searchStudentWildSearch(name: String, searchCategory: String, studentList: ArrayList<Student>): ArrayList<Student>{
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
//                    logger.info { "search: lastname. student: ${student.firstName} ${student.middleName}
                //                    ${student.lastName} ${student.nickName}" }
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

    // returns empty arraylist if nothing found. Otherwise, returns ArrayList of students
    return if(!found) ArrayList() else result
}

// function for showing result
fun showResult(studentList: ArrayList<Student>){
    if(studentList.isEmpty()) {
        println("Search Result: Name not found.")
    }else {
        println("Search Result: ")
        for(student in studentList){
            println("${student.firstName} ${student.middleName} ${student.lastName} (nickname: ${student.nickName})")
        }
        println("")
    }
}

