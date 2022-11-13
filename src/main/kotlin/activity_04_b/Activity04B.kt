package activity_04_b

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

// Book
// - Magazine
// -- Article
// - Newspaper
// -- Article
// - Comics
// - Authors
// - Publishers

class Book(var title:String, var authors:String, var yearPublished:String,
           var edition:String, var ISBN:Int, var publisher:String){
    var chapterList:ArrayList<String> = ArrayList()
    private var numberOfPages:Int? = null
}
class Magazine(var editor:String, var monthPublished:String, var yearPublished: String) {
    class Article(var title:String, var content:String = "", var author:String = "")
}

class Newspaper(var name:String, var dayPublished:String, var monthPublished: String, var yearPublished: String) {
    class Article(var title:String, var content:String = "", var author:String = "")
}

class Authors(var firstName:String = "", var lastName:String = "", var middleName:String = "", var birthDate: Date = Date())

class Comics(var title:String, var monthPublished: String = "", var yearPublished: String = "", var illustrators:String = "", var publisher: String = ""){
    class Illustrator(var firstName:String, var lastName:String, var middleName: String, birthDate:String)

}

class Article(var title:String, var content:String, var author:String)

class AudioVideoRecording(var length:String, var dateRecorded:Date, var title: String, var publisher:String){
    var recordingHasVideo:Boolean? = null
    var recordingHasAudio:Boolean? = null
    var recordingHasBoth:Boolean? = null
}
class Publisher(var name:String, var address:String, var dateEstablished:Date)

class TitleList (){
    var magazineList:ArrayList<String> = arrayListOf("Don Quixote","Alice's Adventures in Wonderland",
        "The Adventures of Huckleberry Finn","The Adventures of Tom Sawyer","Treasure Island",
        "Pride and Prejudice","Wuthering Heights","Jane Eyre","Moby Dick","The Scarlet Letter")

    var newspaperList:ArrayList<String> = arrayListOf("Don Quixote","Alice's Adventures in Wonderland",
        "The Adventures of Huckleberry Finn","The Adventures of Tom Sawyer","Treasure Island",
        "Pride and Prejudice","Wuthering Heights","Jane Eyre","Moby Dick","The Scarlet Letter")

    var comicsList:ArrayList<String> = arrayListOf("Don Quixote","Alice's Adventures in Wonderland",
        "The Adventures of Huckleberry Finn","The Adventures of Tom Sawyer","Treasure Island",
        "Pride and Prejudice","Wuthering Heights","Jane Eyre","Moby Dick","The Scarlet Letter")
}

class AuthorAndTitleList (){
    var authorAndTitleList = hashMapOf<String,String>(
        "Miguel de Cervantes" to "Don Quixote",
        "Lewis Carroll" to "Alice's Adventures in Wonderland",
        "Mark Twain" to "The Adventures of Huckleberry Finn",
        "Mark Twain" to "The Adventures of Tom Sawyer",
        "Robert Louis Stevenson" to "Treasure Island",
        "Jane Austen" to "Pride and Prejudice",
        "Emily Brontë" to "Wuthering Heights",
        "Charlotte Brontë" to "Jane Eyre",
        "Herman Melville" to "Moby Dick",
        "Nathaniel Hawthorne" to "The Scarlet Letter"
    )
}

private var resultList = ArrayList<String>()

fun main(){
    var magazine = Magazine.Article("")
    var newspaper = Newspaper.Article("")
    var comics = Comics("")
    var authorName = Authors("")
    var namePrompt = ""
    var prompt = ""
    var bookType = ""
    var bookName = ""

    println("Book Record:")
    println("============")
    println("- Search title")
    println("- Search title by author")
    println("Search type by (title/author): ")
    prompt = readLine().toString()
    if(prompt == "title"){
        println("Magazine/newspaper/comics title: ")
        bookName = readLine().toString()
        println("Book/Article Type (magazine/newspaper/comics): ")
        bookType = readLine().toString()
        if(bookType == "magazine"){
            magazine.title = bookName
            resultList = searchTitle(magazine.title,"","")
            showSearchResult()
        }else if(bookType == "newspaper"){
            newspaper.title = bookName
            resultList = searchTitle("",newspaper.title,"")
            showSearchResult()
        }else if(bookType == "comics"){
            comics.title = bookName
            resultList = searchTitle("","",comics.title)
            showSearchResult()
        }else{
            println("Error: Name and type must not be empty.")
        }

    }else if(prompt == "author"){
        println("Author Name: ")
        namePrompt = readLine().toString()
        authorName.firstName = namePrompt
        resultList = searchTitleByAuthor(authorName.firstName)
        showSearchResult()

    }else{
        println("Search type not found.")
    }

}

fun searchTitle(magazineTitle:String = "", newspaperTitle:String = "", comicsTitle:String = ""): ArrayList<String>{
    var titlename= ""
    var list = ArrayList<String>()
    var searchResult = ArrayList<String>()
    var found = false

    if(magazineTitle.isNotEmpty()){
        titlename = magazineTitle
        list = TitleList().magazineList
    }
    if(newspaperTitle.isNotEmpty()){
        titlename = newspaperTitle
        list = TitleList().newspaperList
    }
    if(comicsTitle.isNotEmpty()){
        titlename = comicsTitle
        list = TitleList().comicsList
    }

    for(index in list.indices){
        if(list[index].contains(titlename) || list[index].equals(titlename,ignoreCase = true)){
            searchResult.add(list[index])
            found = true
        }
    }
    if(found){
        return searchResult
    }else{
        return ArrayList()
    }
}

fun searchTitleByAuthor(name:String, list:HashMap<String,String> = AuthorAndTitleList().authorAndTitleList): ArrayList<String>{
    var searchResult = ArrayList<String>()
    var found = false
    var title = ""
    for(entry in list.keys){
        if(entry.contains(name) || entry.equals(name,ignoreCase = true)){
            title = list.getValue(entry.toString())
            searchResult.add(title)
            found = true
        }
    }
    if(found){
        return searchResult
    }else{
        return ArrayList()
    }

}

fun showSearchResult(list: ArrayList<String> = resultList){
    println("Search Result: ")
    list.forEach() {
        println(it)
    }
}