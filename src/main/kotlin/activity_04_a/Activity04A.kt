package activity_04_a
class Student(var firstname:String = "", var lastname:String = "", var nickname:String = "", var id:Int = 0, var yearenrolled:String = ""){
    var firstNameList:ArrayList<String> = arrayListOf("Marco","Eugene","Sarah","Isaiah","Anthony","Henry","Elizabeth",
        "Olivia", "Sara","Maria","Mary","Christopher","Andrew","Daniel","Matthew","Michael","Jake","James",
        "Raymond","James Nico")
    var lastNameList:ArrayList<String> = arrayListOf("Marco","Eugene","Sarah","Isaiah","Anthony","Henry","Elizabeth",
        "Olivia", "Sara","Maria","Mary","Christopher","Andrew","Daniel","Matthew","Michael","Jake","James",
        "Raymond","Rara")
    var nicknameList:ArrayList<String> = arrayListOf("Marco","Eugene","Sarah","Isaiah","Anthony","Henry","Elizabeth",
        "Olivia", "Sara","Maria","Mary","Christopher","Andrew","Daniel","Matthew","Michael","Jake","James",
        "Raymond","Nico")
}

private var resultList: ArrayList<String> = ArrayList()

fun main() {
    var firstName = ""
    var lastName = ""
    var nickname = ""
    var student = Student("","","")
    var prompt = ""

    println("Student Record (Class)")
    println("==============================")
    println("- Student Search w/ wildcard")
    println("==============================")

    println("Search method (firstname/lastname/nickname:")
    prompt = readLine().toString()

    if(prompt == "firstname"){
        println("Enter First Name: ")
        firstName = readLine().toString()
        student.firstname = firstName
        resultList = searchStudentWildSearch(firstname = student.firstname)
        showResult()
    }
    if(prompt == "lastname"){
        println("Enter Last Name: ")
        lastName = readLine().toString()
        student.lastname = lastName
        resultList = searchStudentWildSearch(lastname = student.lastname)
        showResult()
    }
    if(prompt == "nickname"){
        println("Enter Nickname: ")
        nickname = readLine().toString()
        student.nickname = nickname
        resultList = searchStudentWildSearch(nickname = student.nickname)
        showResult()
    }

}

// act04_a changes start
fun searchStudentWildSearch(firstname:String = "", lastname:String = "", nickname:String = ""): ArrayList<String> {
    var name = ""
    var found = false
    var searchList:ArrayList<String> = ArrayList()
    var searchResult:ArrayList<String> = ArrayList()

    if (firstname.isNotEmpty()) {
        name = firstname
        searchList = Student().firstNameList
    }
    if (lastname.isNotEmpty()) {
        name = lastname
        searchList = Student().lastNameList
    }
    if (nickname.isNotEmpty()) {
        name = nickname
        searchList = Student().nicknameList
    }
    for (index in searchList.indices) {
        if (searchList[index].contains(name,ignoreCase = true)) {
            searchResult.add(searchList[index])
            found = true
        }
    }
    if (found) {
        return searchResult
    } else {
        return ArrayList()
    }
}
// act04_a changes end

fun showResult(list: ArrayList<String> = resultList){
    println("Search Result: ")
    list.forEach() {
        println(it)
    }
}

