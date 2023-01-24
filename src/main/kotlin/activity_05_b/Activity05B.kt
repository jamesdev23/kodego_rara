package activity_05_b

import activity_06_b.Authors
import java.util.*

open class Publication(var title: String, var authors: Authors, var yearPublished: Int, var publisher: Publisher) {
    open fun getDetails(): String {
        return "Title: $title, Authors: ${authors.firstName} ${authors.lastName}, Year Published: $yearPublished, Publisher: ${publisher.name}"
    }
    open fun searchByTitle(title: String): Boolean {
        return this.title.equals(title, ignoreCase = true)
    }
}
class Book(var title: String) {
    var authors: Authors = Authors("","")
    var yearPublished: Int = 0
    var edition: Int = 0
    var ISBN: String = ""
    var publisher: Publisher = Publisher("")
    var chapters: List<String> = emptyList()
    var pages: Int = 0
}

open class Article(var title: String,var content: String,var author: Authors)

class Magazines(var editor: String, var monthPublished: Int, var yearPublished: Int, title:String, content:String,
                author: Authors
) : Article(title,content, author)

class Newspaper(var name: String, var dayPublished: Int, var monthPublished: Int, var yearPublished: Int,
                var headline: String, title:String, content:String,author: Authors
) : Article(title,content, author)

class Comics(var monthPublished: Int, var yearPublished: Int, var illustrators: activity_05_b.Illustrator,
             var publisher: Publisher, title: String, content: String, author: Authors
) : Article(title,content,author)

class Publisher (var name: String){
    var address: String = ""
    var dateEstablished: Date = Date()
}

class audioVideoRecording(var length: Int, var dateRecorded: String, var title: String, var publisher: Publisher){
    var hasVideo: Boolean = true
    var hasAudio: Boolean = true
    var hasBoth: Boolean = true
}



// #2 answer: using enum. more readable and efficient than using class
enum class AudioVideoTypes {
    RECORDINGS,
    DOCUMENTARY,
    MOVIES,
    POWERPOINT
}

// #3 answer: using class. "Authors" class will be used for books,magazines,and newspaper and "Illustrator" class is for comics.
class Authors(var firstName: String, var lastName: String){
    var middleName: String = ""
    var dateOfBirth: Date = Date()
    // class for books, magazines and newspaper
}

class Illustrator(var firstName: String, var lastName: String){
    var middleName: String = ""
    var dateOfBirth: Date = Date()
    // class for comics
}

fun main(){

}





