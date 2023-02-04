package activity_02_a

// activity 01_a w/ data structure
// A01_a: create student directory for this course. check student progress
fun main() {
    // from activity 01_a
    val courseName = "Mobile App Development (Part-Time)"
    var studentList = arrayListOf("James","Bert","Jane","Mark","Jeff") // filler name
    var studentName: String = ""
    var batchNumber: String = ""
    var studentStatus = "Enrolled"
    var isDropped = "No"
    var attendanceCount = "n/a"
    var numberOfLateAttendance = "n/a"
    var exerciseStatus = "n/a"
    var exerciseCompleted = "n/a"
    var exerciseInProgress = "n/a"
    var exerciseCount = "n/a"
    var assignmentStatus = "n/a"
    var assignmentCompleted = "n/a"
    var assignmentInProgress = "n/a"
    var assignmentCount = "n/a"
    var projectStatus = "n/a"
    var projectCompleted = "n/a"
    var projectInProgress = "n/a"
    var projectCount = "n/a"
    var capstoneProjectStatus = "n/a"
    var weekStatus = "n/a"
    var weeksTotal = "n/a"
    var totalStudents: Int? = null

    // var for this activity
    var optionsInput:String? = null
    var firstName:String? = null
    var lastName:String? = null
    var startDate:String? = null
    var studentRecord = ArrayList<String>()
    var studentRecordColumn = arrayListOf("Student Name","Batch Number","Class Start","Status","Dropped","Attendance Count",
        "Late Attendance","Exercise Status","Exercise Completed","Exercise in Progress","Exercise Count",
        "Assignment Status","Assignment Completed","Assignment in Progress","Assignment Count","Project Status",
        "Project in Progress","Project Completed","Project Count","Capstone Project Status")
    var column = 0
    var addStudent = true

    println("Student Directory Menu:")
    println("- Add Student")
    println("- View Student Directory")
    println("- Check Student Progress")
    println(" ")

    // add student
    println("Proceed to add student...")
    while(addStudent) {
        println("Enter first name: ")
        firstName = readLine()!!.toString()
        if (firstName.isEmpty()) {
            println("Student name can't be empty.")
        }
        println("Enter last name: ")
        lastName = readLine()!!.toString()
        if (firstName.isEmpty()) {
            println("Student name can't be empty.")
        }
        studentName = "$firstName $lastName"
        println("Enter batch number: ")
        batchNumber = readLine().toString()
        if (batchNumber != "MD2P") {
            println("Error: This directory only adds student for this course.")
        }
        println("Enter class start date (mm-dd-YYYY): ")
        startDate = readLine().toString()
        // adds a bunch of record to student record. total of 20 records
        studentList.add(studentName)
        studentRecord.add(studentName)
        studentRecord.add(batchNumber)
        studentRecord.add(startDate)
        studentRecord.add(studentStatus)
        studentRecord.add(isDropped)
        studentRecord.add(attendanceCount)
        studentRecord.add(numberOfLateAttendance)
        studentRecord.add(exerciseStatus)
        studentRecord.add(exerciseCompleted)
        studentRecord.add(exerciseInProgress)
        studentRecord.add(exerciseCount)
        studentRecord.add(assignmentStatus)
        studentRecord.add(assignmentCompleted)
        studentRecord.add(assignmentInProgress)
        studentRecord.add(assignmentCount)
        studentRecord.add(projectStatus)
        studentRecord.add(projectCompleted)
        studentRecord.add(projectInProgress)
        studentRecord.add(projectCount)
        studentRecord.add(capstoneProjectStatus)
        println("Added student to directory.")
        println("Welcome to $courseName, $studentName! ")
        println("Do you want to add another student? (Y/N): ")
        optionsInput = readLine().toString()
        if(optionsInput == "N" || optionsInput == "n"){
            addStudent = false
        }
    }


    println("Do you want to view student record? (Y/N): ")
    optionsInput = readLine().toString()
    if(optionsInput == "Y" || optionsInput == "y") {
        // view student directory
        println("Proceed to view student directory...")
        println("Student List: ")
        studentList.forEach() {
            println(it)
        }
        println(" ")
        totalStudents = studentList.size
        println("Total Students: $totalStudents")
    }

    println("Do you want to view student progress?: (Y/N): ")
    optionsInput = readLine().toString()
    if(optionsInput == "Y" || optionsInput == "y") {
        println("Enter student name to view: ")
        studentName = readLine().toString()
        if(studentRecord.contains(studentName)){
            var index = studentRecord.indexOf(studentName)
            println("Student Record: ")
            do{
                println("${studentRecordColumn[column]}: ${studentRecord[index]}")
                ++ index
                ++ column
                if(column == 20){
                    column -= 20
                    println(" ")
                }
            }while(index < studentRecord.size)
        }else{
            println("Name not found.")
        }
    }

}
