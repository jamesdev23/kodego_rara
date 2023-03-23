package activity_03_b

private val bookList:ArrayList<String> = arrayListOf("Don Quixote","Alice\'s Adventures in Wonderland",
    "The Adventures of Huckleberry Finn","The Adventures of Tom Sawyer","Treasure Island","Pride and Prejudice",
    "Wuthering Heights","Jane Eyre","Moby Dick","The Scarlet Letter","Anna Karenina","Madame Bovary","War and Peace",
    "The stories of Anton Chekhov","Middlemarch","Crime and Punishment","Great Expectations","Emma",
    "The Great Gatsby","In Search of Lost Time")

fun main(){
    var prompt:String = ""
    var bookName:String = ""

    println("Function List:")
    println("1. Show Book Record")
    println("2. Check Book in Record")
    println("3. Add Book")
    println("4. Remove Book")
    println("5. Book Count")
    println("6. Search Book Name using wildcard")
    println("7. Search Book Name using whole name")
    println("8. Search Book")
    print("Prompt: ")
    prompt = readLine().toString()

    when(prompt){
        "1" -> {
            println("Book List: ")
            showBooks()
        }
        "2" -> {
            print("Book Name: ")
            bookName = readLine().toString()
            println("Is Book in record?: ")
            println(isBookInRecord(bookName))

        }
        "3" -> {
            println("Book Name: ")
            bookName = readLine().toString()
            addBook(bookName)
        }
        "4" -> {
            println("Book Name: ")
            bookName = readLine().toString()
            removeBook(bookName)
        }
        "5" -> {
            print("Book Count: ")
            print(countBooks())
        }
        "6" -> {
            print("Book Name: ")
            bookName = readLine().toString()
            println("Result: ")
            searchBookWildSearch(bookName)
        }
        "7" -> {
            print("Book Name: ")
            bookName = readLine().toString()
            println("Result: ")
            searchbookName(bookName)
        }
        "8" -> {
            print("Book Name: ")
            bookName = readLine().toString()
            println("Result: ")
            searchBook(bookName)
        }
    }
}

fun isBookInRecord(book: String): Boolean {
    return bookList.contains(book)
}

fun addBook(book: String){
    bookList.add(book)
    println("Added $book to list.")
}

fun removeBook(book: String){
    bookList.remove(book)
    println("Removed $book to list.")
}

fun countBooks(): Int{
    return bookList.size
}

fun searchBook(book: String){
    if(book.length <= 3){
        searchBookWildSearch(book)
    }else{
        searchbookName(book)
    }
}

fun searchBookWildSearch(book: String){
    for(index in bookList.indices){
        if(bookList[index].contains(book)){
            println(bookList[index])
        }
    }
}

fun searchbookName(book: String){
    for(index in bookList.indices){
        if(bookList[index] == book){
            println(bookList[index])
        }
    }
}


fun showBooks(){
    bookList.forEach {
        println(it)
    }
}
