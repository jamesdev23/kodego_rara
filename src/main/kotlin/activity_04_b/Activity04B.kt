package activity_04_b

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Book(var title:String){
    var authors:String = ""
    var yearPublished:String = ""
    var edition:String = ""
    var ISBN:Int = 0
    var publisher:String = ""
    var chapterList:ArrayList<String> = ArrayList()
    private var numberOfPages:Int = 0
}

open class Article(var title:String, var content:String, var author:String)
class Magazine(title: String,content: String,author: String) : Article(title,content,author) {
    var editor:String = ""
    var monthPublished:String = ""
    var yearPublished: String = ""
}

class Newspaper(title: String,content: String,author: String) : Article(title,content,author) {
    var name:String = ""
    var dayPublished:String = ""
    var monthPublished: String = ""
    var yearPublished: String = ""
}

class Authors(var firstName:String = "", var lastName:String = "", var middleName:String = ""){
    var birthDate: Date = Date()
}

class Comics(var title:String){
    var monthPublished: String = ""
    var yearPublished: String = ""
    var illustrators:String = ""
    var publisher: String = ""
    class Illustrator(var firstName:String, var lastName:String, var middleName: String) {
        var birthDate:Date = Date()
    }
}

class AudioVideoRecording(var title: String){
    var length:String = ""
    var dateRecorded:Date = Date()
    var publisher:String = ""
    var recordingHasVideo:Boolean? = null
    var recordingHasAudio:Boolean? = null
    var recordingHasBoth:Boolean? = null
}
class Publisher(var name:String) {
    var address: String = ""
    var dateEstablished:Date = Date()
}

private var magazineList:ArrayList<String> = arrayListOf("Don Quixote","Alice's Adventures in Wonderland",
    "The Adventures of Tom Sawyer","Treasure Island","Pride and Prejudice","Wuthering Heights","Jane Eyre",
    "Moby Dick","The Scarlet Letter")

private var newspaperList:ArrayList<String> = arrayListOf("Don Quixote","Alice's Adventures in Wonderland",
    "The Adventures of Tom Sawyer","Treasure Island","Pride and Prejudice","Wuthering Heights","Jane Eyre",
    "Moby Dick","The Scarlet Letter")

private var comicsList:ArrayList<String> = arrayListOf("Don Quixote","Alice's Adventures in Wonderland",
    "The Adventures of Tom Sawyer","Treasure Island","Pride and Prejudice","Wuthering Heights","Jane Eyre",
    "Moby Dick","The Scarlet Letter")


private var authorAndTitleList = hashMapOf<String,String>(
    "Miguel de Cervantes" to "Don Quixote",
    "Lewis Carroll" to "Alice's Adventures in Wonderland",
    "Mark Twain" to "The Adventures of Tom Sawyer",
    "Robert Louis Stevenson" to "Treasure Island",
    "Jane Austen" to "Pride and Prejudice",
    "Emily Brontë" to "Wuthering Heights",
    "Charlotte Brontë" to "Jane Eyre",
    "Herman Melville" to "Moby Dick",
    "Nathaniel Hawthorne" to "The Scarlet Letter"
)

private var resultList = ArrayList<String>()

fun main(){
    val search1 = "Don Quixote"
    val search2 = "Mark Twain"
    println("Search Title: $search1")
    resultList = searchTitle(magazineTitle = search1)
    showSearchResult()

    println("Search Title by Author: $search2")
    resultList = searchTitleByAuthor("Mark Twain")
    showSearchResult()

}

fun searchTitle(magazineTitle:String = "", newspaperTitle:String = "", comicsTitle:String = ""): ArrayList<String>{
    var titlename= ""
    var list = ArrayList<String>()
    var searchResult = ArrayList<String>()
    var found = false

    if(magazineTitle.isNotEmpty()){
        titlename = magazineTitle
        list = magazineList
    }
    if(newspaperTitle.isNotEmpty()){
        titlename = newspaperTitle
        list = newspaperList
    }
    if(comicsTitle.isNotEmpty()){
        titlename = comicsTitle
        list = comicsList
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

fun searchTitleByAuthor(name:String, list:HashMap<String,String> = authorAndTitleList): ArrayList<String>{
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