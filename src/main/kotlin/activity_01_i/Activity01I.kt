package activity_01_i
import java.time.LocalDate
import java.time.Period

// Borrowing book and check record. User: Librarian

fun main(){
    var optionsInput:String? = null
    var optionYesNo:String? = null
    var bookBorrowerName:String? = null
    var bookTitle:String? = null
    var borrowDuration:Int = 0
    var borrowDateEnd:String? = null
    var borrowerInfoColumn = arrayListOf("Name","Type","Book Borrowed","Duration (in days)","Borrowed on","Return Date")
    var borrowerInfo = arrayListOf("James","Student","The Scarlet Letter","7","2022-10-22","2022-10-29")
    var bookBorrowDateStart = LocalDate.now()
    var bookBorrowed = arrayListOf("The Scarlet Letter")
    var borrowerType = arrayOf(
        "Visitor",
        "Student",
        "Faculty"
    )

    var borrowerTypeBorrowDuration = arrayOf(
        "room-use",
        "7 days",
        "30 days"
    )
    var bookList = arrayListOf<String>(
        "Don Quixote",
        "Alice\'s Adventures in Wonderland",
        "The Adventures of Huckleberry Finn",
        "The Adventures of Tom Sawyer",
        "Treasure Island",
        "Pride and Prejudice",
        "Wuthering Heights",
        "Jane Eyre",
        "Moby Dick",
        "The Scarlet Letter"
    )

    var bookAuthor = arrayListOf<String>(
        "Miguel de Cervantes",
        "Lewis Carroll",
        "Mark Twain",
        "Mark Twain",
        "Robert Louis Stevenson",
        "Jane Austen",
        "Emily Brontë",
        "Charlotte Brontë",
        "Herman Melville",
        "Nathaniel Hawthorne"
    )
    var canBorrow = true
    var counter = 0
    var column = 0

    println("Librarian Menu: ")
    println("- Borrow a Book")
    println("- Borrowed Book Record")

    while(canBorrow) {
        print("Enter Borrower's Name: ")
        bookBorrowerName = readLine().toString()
        borrowerInfo.add(bookBorrowerName)
        print("Enter Borrower Type (visitor,student,faculty): ")
        var tempBorrowerType = readLine().toString()
        borrowerInfo.add(tempBorrowerType)

        if (tempBorrowerType == "visitor"){
            println("Note: Any books borrowed by visitor is for room-use only, within 1 day.")
            borrowDuration = 1
        } else if (tempBorrowerType == "student") {
            println("Note: Students can borrow a book up to 7 days")
            borrowDuration = 7
        } else if (tempBorrowerType == "faculty") {
            println("Note: Faculty and other school staff can borrow a book up to 30 days")
            borrowDuration = 30
        } else {
            println("Invalid option.")
            borrowDuration = 1
        }
        println("Book Title: ")
        bookTitle = readLine().toString()

        // simple check if it can be borrowed
        if (bookBorrowed.contains(bookTitle)) {
            println("This book can not be borrowed.")
        } else {
            println("This book can be borrowed.")
            borrowerInfo.add(bookTitle)
            var durationStr = borrowDuration.toString()
            borrowerInfo.add(durationStr)
            borrowerInfo.add(bookBorrowDateStart.toString())
            var endDate = bookBorrowDateStart.plus(Period.of(0,0,borrowDuration)).toString()
            borrowerInfo.add(endDate)
            println("Added entry to borrowed book list")
        }
        print("Do you want to borrow another book? (Y/N): ")
        optionYesNo = readLine().toString()
        if(optionYesNo == "N" || optionYesNo == "n"){
            canBorrow = false
        }
    }


    println("Proceed to Book Record...")
    print("Do you want to check borrowed book list?(Y/N): ")
    optionYesNo = readLine().toString()
    if(optionYesNo == "Y" || optionYesNo == "y"){
        println("Book Borrowed List: ")
        bookBorrowed.forEach(){
            println(it)
        }
        println(" ")
        println("Checking borrower\'s info...")
        println(" ")
        if(borrowerInfo.size == 0){
            println("No entry found.")
        }else {
            println("Borrower Info: ")
            do{
                println("${borrowerInfoColumn[column]}: ${borrowerInfo[counter]}")
                ++ counter
                ++ column
                if(column == 6){
                    column = column - 6
                    println(" ")
                }
            }while(counter < borrowerInfo.size)
        }
    }
}
