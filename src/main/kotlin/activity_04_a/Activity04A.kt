package activity_04_a

// Student, but using class instead of string. Also, search will ask either first/last/nickname.
class Student(var firstname:String,var lastname:String,var nickname:String){
    var ID:String = ""
    var yearEnrolled:String = ""
}

private var firstNameList:ArrayList<String> = arrayListOf("Marco","Eugene","Sarah","Isaiah","Anthony","Henry","Elizabeth",
        "Olivia", "Sara","Maria","Mary","Christopher","Andrew","Daniel","Matthew","Michael","Jake","James",
        "Raymond","James Nico")

private var lastNameList:ArrayList<String> = arrayListOf("Marco","Eugene","Sarah","Isaiah","Anthony","Henry","Elizabeth",
        "Olivia", "Sara","Maria","Mary","Christopher","Andrew","Daniel","Matthew","Michael","Jake","James",
        "Raymond","Rara")

private var nicknameList:ArrayList<String> = arrayListOf("Marco","Eugene","Sarah","Isaiah","Anthony","Henry","Elizabeth",
        "Olivia", "Sara","Maria","Mary","Christopher","Andrew","Daniel","Matthew","Michael","Jake","James",
        "Raymond","Nico")

private var resultList: ArrayList<String> = ArrayList()

fun main(){
    var firstName = ""
    var lastName = ""
    var nickname = ""
    var student = Student("","","")
    var prompt = ""

    println("Student Record (Class)")
    println("- Student Search w/ wildcard")

    println("Search method (firstname/lastname/nickname:")
    prompt = readLine().toString()

    if(prompt == "firstname"){
        println("Enter First Name: ")
        firstName = readLine().toString()
        student.firstname = firstName
        resultList = searchStudentWildSearch(student.firstname,"","")
        showSearchResult()
    }
    if(prompt == "lastname"){
        println("Enter Last Name: ")
        lastName = readLine().toString()
        student.lastname = lastName
        resultList = searchStudentWildSearch("",student.lastname,"")
        showSearchResult()
    }
    if(prompt == "nickname"){
        println("Enter Nickname: ")
        nickname = readLine().toString()
        student.nickname = nickname
        resultList = searchStudentWildSearch("","",student.nickname)
        showSearchResult()
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
        searchList = firstNameList
    }
    if (lastname.isNotEmpty()) {
        name = lastname
        searchList = lastNameList
    }
    if (nickname.isNotEmpty()) {
        name = nickname
        searchList = nicknameList
    }
    for (index in searchList.indices) {
        if (searchList[index].contains(name,ignoreCase = true)) {
            searchResult.add(searchList[index])
            found = true
        }
    }
    // if match found, return a list of search result. otherwise, return empty arraylist
    if(found){
        return searchResult
    }else {
        return ArrayList()
    }
}
// act04_a changes end

fun showSearchResult(list: ArrayList<String> = resultList){
    println("Search Result: ")
    list.forEach() {
        println(it)
    }
}

