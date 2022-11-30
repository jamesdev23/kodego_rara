package activity_05_b

import java.util.*

open class Publication {
    var publisherName:String = ""
    var address:String = ""
    open var yearPublished: Date = Date()
}

class Book (var title:String) : Publication(){
    var authors:String = ""
    override var yearPublished:Date = Date()
    var edition:String = ""
    var ISBN:Int = 0
    var publisher:String = ""
    var chapterList:ArrayList<String> = ArrayList()
    private var numberOfPages:Int? = null
}

class Magazine : Publication(){
    var editor:String = ""
    var monthPublished:Date = Date()
    override var yearPublished:Date = Date()

}

class Newspaper(var name:String) : Publication(){
    var dayPublished:Date = Date()
    var monthPublished:Date = Date()
    override var yearPublished:Date = Date()
    var headline:String = ""
}


class Comics(var title:String) : Publication(){
    var monthPublished:Date = Date()
    override var yearPublished:Date = Date()
    var illustrators:String = ""
    var publisher: String = ""
}

// #2 answer: using enum. For readability and efficiency of not adding 4 diff. classes.
enum class AudioVideoTypes {
    RECORDINGS,
    DOCUMENTARY,
    MOVIES,
    POWERPOINT
}

// #3 answer: using class. "Authors" class will be used for books and "Illustrator" class is for comics.
class Authors(var firstName:String,var lastName:String,var middleName:String){
    var birthDate: Date = Date()
}

class Illustrator(var firstName:String, var lastName:String, var middleName: String){
    var birthDate:Date = Date()
}

fun main(){

}





