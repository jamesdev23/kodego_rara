package activity_02_b

fun main() {
    var bookList = ArrayList<String>()
    var bookAllowedToBorrowList = ArrayList<String>()
    var bookBorrowed = ArrayList<String>()
    var bookReturned = ArrayList<String>()
    var bookName: String? = ""
    var bookAuthor: String = ""
    var bookPublisher: String = ""
    var bookISBN: Long = 0
    var bookType: String = ""
    var bookCondition: String = ""
    var bookQuantity: Int = 0
    var bookRemarks: String = "" // for other book info
    var bookBorrowStatus: String = ""
    var totalItemsInLibrary: Int = 0

    var borrowable = ArrayList<String>()
    var nonborrowable = ArrayList<String>()
    var optionsInput:String? = ""
    var bookCharacteristic = ArrayList<String>()
    var bookCharacteristicColumn = arrayListOf("Book Name","Type","Author","Publisher","ISBN","Condition")
    var count = 0
    var column = 0

    println("School Library Menu")
    println("- Add Borrowable item")
    println("- Add Item Info")
    println("Proceed to add borrowable item...")
    while(true) {
        println("Enter book name: ")
        bookName = readLine().toString()
        println("Adding book to list...")

        bookList.add(bookName)
        bookCharacteristic.add(bookName)
        bookCharacteristic.add(bookType)
        bookCharacteristic.add(bookAuthor)
        bookCharacteristic.add(bookPublisher)
        bookCharacteristic.add(bookISBN.toString())
        bookCharacteristic.add(bookCondition)
        println("Book added to borrowable list.")
        println("Do you want to add another book? (Y/N): ")
        optionsInput = readLine().toString()
        if(optionsInput == "N" || optionsInput == "n"){
            break
        }
    }

    println("Do you want to add book characteristics? (Y/N): ")
    optionsInput = readLine().toString()

    if(optionsInput == "Y" || optionsInput == "y"){
        println("Enter book name to add info: ")
        bookName = readLine().toString()
        if(bookCharacteristic.contains(bookName)){
            println("Found $bookName.")
            println("Add Book type: ")
            bookType = readLine().toString()
            println("Add Book author: ")
            bookAuthor = readLine().toString()
            println("Add Book publisher: ")
            bookPublisher = readLine().toString()
            println("Add Book ISBN: ")
            bookISBN = readLine()!!.toLong()
            println("Add book condition (like new/good/fair/poor):")
            bookCondition = readLine().toString()
            println("Adding new info...")
            var index = bookCharacteristic.indexOf(bookName)
            bookCharacteristic.set(index+1,bookType)
            bookCharacteristic.set(index+2,bookAuthor)
            bookCharacteristic.set(index+3,bookPublisher)
            bookCharacteristic.set(index+4,bookISBN.toString())
            bookCharacteristic.set(index+5,bookCondition)
        }else{
            println("Book name not found.")
        }
    }
    println("Do you want to check book list? (Y/N): ")
    optionsInput = readLine().toString()
    if(optionsInput == "Y" || optionsInput == "y"){
        do{
            println("${bookCharacteristicColumn[column]}: ${bookCharacteristic[count]}")
            ++ count
            ++ column
            if(column == 6){
                column -= 6
                println(" ")
            }
        }while(count < bookCharacteristic.size)
    }

}