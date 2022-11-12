package activity_03_a

// make array of 20 names. make functions according to instruction

private val nameList:ArrayList<String> = arrayListOf("Marco","Eugene","Sarah","Isaiah","Anthony","Henry","Elizabeth","Olivia",
    "Sara","Maria","Mary","Christopher","Andrew","Daniel","Matthew","Michael","Nicholas","James","Brian","Ryan")


fun main(){
    var prompt:String = ""
    var studentName:String = ""

    println("Function List:")
    println("1. Show Student Record")
    println("2. Check Student in Record")
    println("3. Add Student")
    println("4. Remove Student")
    println("5. Student Count")
    println("6. Search Student Name (using wildcard)")
    println("7. Search Student Name (whole name)")
    println("8. Search Student")
    print("Prompt: ")
    prompt = readLine().toString()

    when(prompt){
        "1" -> {
            println("Student List: ")
            showStudents()
        }
        "2" -> {
            print("Student Name: ")
            studentName = readLine().toString()
            println("Is student in record?: ")
            println(isStudentInRecord(studentName))

        }
        "3" -> {
            println("Student Name: ")
            studentName = readLine().toString()
            addStudent(studentName)
        }
        "4" -> {
            println("Student Name: ")
            studentName = readLine().toString()
            removeStudent(studentName)
        }
        "5" -> {
            print("Student Count: ")
            print(countStudent())
        }
        "6" -> {
            print("Student Name: ")
            studentName = readLine().toString()
            println("Result: ")
            searchStudentWildSearch(studentName)
        }
        "7" -> {
            print("Student Name: ")
            studentName = readLine().toString()
            println("Result: ")
            searchStudentName(studentName)
        }
        "8" -> {
            print("Student Name: ")
            studentName = readLine().toString()
            println("Result: ")
            searchStudent(studentName)
        }
    }
}

fun isStudentInRecord(name: String,list: ArrayList<String> = nameList): Boolean {
    return list.contains(name)
}

fun addStudent(name: String,list: ArrayList<String> = nameList){
    list.add(name)
    println("Added $name to list.")
}

fun removeStudent(name: String,list: ArrayList<String> = nameList){
    list.remove(name)
    println("Removed $name to list.")
}

fun countStudent(list: ArrayList<String> = nameList): Int{
    return list.size
}

fun searchStudent(name: String){
    if(name.length <= 3){
        searchStudentWildSearch(name)
    }else{
        searchStudentName(name)
    }
}

fun searchStudentWildSearch(name: String){
    for(index in nameList.indices){
        if(nameList[index].contains(name,ignoreCase = true)){
            println(nameList[index])
        }
    }
}

fun searchStudentName(name: String){
    for(index in nameList.indices){
        if(nameList[index].equals(name,ignoreCase = true)){
            println(nameList[index])
        }
    }
}


fun showStudents(list: ArrayList<String> = nameList){
    list.forEach {
        println(it)
    }
}
