package activity_04_b

import java.util.*

class Book(var title: String, var authors: Authors, var yearPublished: Int, var edition: Int,
    var ISBN: String, var publisher:Publisher, var chapters: List<String>, var pages: Int)
class Authors(var firstName: String, var lastName: String, var middleName: String, var dateOfBirth: Date)

open class Article(var title: String,var content: String,var author: Authors)

class Magazines(var editor: String, var monthPublished: Int, var yearPublished: Int, title:String, content:String,
                author:Authors) : Article(title,content, author)

class Newspaper(var name: String, var dayPublished: Int, var monthPublished: Int, var yearPublished: Int,
                var headline: String, title:String, content:String,author:Authors) : Article(title,content, author)

class Comics(var monthPublished: Int, var yearPublished: Int, var illustrators: Illustrator,
             var publisher: Publisher,title: String,content: String,author: Authors) : Article(title,content,author)

class Illustrator(var firstName: String, var lastName: String, var middleName: String, var dateOfBirth: Date)


class Publisher (var name: String, var address: String, var dateEstablished: String)

class audioVideoRecording(var length: Int, var dateRecorded: String, var title: String, var publisher: Publisher){
    var hasVideo: Boolean = true
    var hasAudio: Boolean = true
    var hasBoth: Boolean = true
}

private val publisherList: List<Publisher> = listOf(
    Publisher("Publisher 1", "Address 1", "2022-01-01"),
    Publisher("Publisher 2", "Address 2", "2022-01-01")
)

private val authorList: List<Authors> = listOf(
    Authors("John", "Doe", "", Date(1981-1-1)),
    Authors("Jane", "Smith", "", Date(1982-2-2)),
    Authors("Amy", "Lee", "", Date(1983-3-3))
)

private val bookChapter = listOf("Chapter 1", "Chapter 2")

private val bookList: List<Book> = listOf(
    Book("Book 1", authorList[0], 2022, 1, "123-456-789", publisherList[0], bookChapter, 100),
    Book("Book 2", authorList[1], 2022, 2, "987-654-321", publisherList[1], bookChapter, 150)
)

private val magazineList: List<Magazines> = listOf(
    Magazines("Jane Smith", 1, 2022, "Sports Illustrated", "Content 1", authorList[0]),
    Magazines("John Doe", 2, 2022, "Vogue", "Content 2", authorList[1]),
    Magazines("Amy Lee", 3, 2022, "National Geographic", "Content 3", authorList[2])
)

private val newspaperList: List<Newspaper> = listOf(
    Newspaper("New York Times", 1, 1, 2022, "Headline 1", "Article 4", "Content 4", authorList[0]),
    Newspaper("The Guardian", 2, 1, 2022, "Headline 2", "Article 5", "Content 5", authorList[1]),
    Newspaper("The Washington Post", 3, 1, 2022, "Headline 3", "Article 6", "Content 6", authorList[2])
)

private val comicsList: List<Comics> = listOf(
    Comics(1, 2022, Illustrator("Jack", "Smith", "", Date(1981-1-1)), Publisher("DC Comics", "New York", "2022-01-01"), "Superman", "Comic 1", authorList[0]),
    Comics(2, 2022, Illustrator("Mary", "Johnson", "", Date(1982-2-2)), Publisher("Marvel", "Los Angeles", "2022-01-01"), "Batman", "Comic 2", authorList[1]),
    Comics(3, 2022, Illustrator("Robert", "Williams", "", Date(1983-3-3)), Publisher("Dark Horse", "Seattle", "2022-01-01"), "Wonder Woman", "Comic 3", authorList[2])
)

fun main() {
    // TODO: move list outside of fun main()


    val title = "Vogue"
    searchTitle(title)

    val authorFirstName = "John"
    val authorLastName = "Smith"
    searchTitleByAuthor(authorFirstName)
    searchTitleByAuthor(authorLastName)
}

fun searchTitle(title: String) {
    for (magazines in magazineList) {
        if (magazines.title == title) {
            println("Found Magazines: $title")
            return
        }
    }
    for (newspaper in newspaperList) {
        if (newspaper.title == title) {
            println("Found newspaper: $title")
            return
        }
    }
    for (comic in comicsList) {
        if (comic.title == title) {
            println("Found comic: $title")
            return
        }
    }
    println("Not found")
}

fun searchTitleByAuthor(name: String) {
    println("Works by $name:")
    for (book in bookList) {
        if (book.authors.firstName == name || book.authors.lastName == name) {
            println("- ${book.title} (Book)")
        }
    }
    for (magazine in magazineList) {
        if (magazine.author.firstName == name || magazine.author.lastName == name) {
            println("- ${magazine.title} (Magazine)")
        }
    }
    for (newspaper in newspaperList) {
        if (newspaper.author.firstName == name || newspaper.author.lastName == name) {
            println("- ${newspaper.title} (Newspaper)")
        }
    }
    for (comics in comicsList) {
        if (comics.author.firstName == name || comics.author.lastName == name) {
            println("- ${comics.title} (Comic)")
        }
    }
}

