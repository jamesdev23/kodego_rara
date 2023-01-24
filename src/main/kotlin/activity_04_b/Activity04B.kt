package activity_04_b

import java.util.*

class Book(
    var title: String, var authors: Authors, var yearPublished: Int, var edition: Int,
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

fun main() {
    val author1= Authors("John", "Doe", "", Date(1981-1-1))
    val author2 = Authors("Jane", "Smith", "", Date(1982-2-2))
    val author3 = Authors("Amy", "Lee", "", Date(1983-3-3))

    val publisher1 = Publisher("Publisher 1", "Address 1", "2022-01-01")
    val publisher2 = Publisher("Publisher 2", "Address 2", "2022-01-01")

    val bookChapter = listOf("Chapter 1", "Chapter 2")

    val book1 = Book("Book 1", author1, 2022, 1, "123-456-789", publisher1, bookChapter, 100)
    val book2 = Book("Book 2", author2, 2022, 2, "987-654-321", publisher2, bookChapter, 150)
    val books = listOf(book1, book2)

    val magazine1 = Magazines("Jane Smith", 1, 2022, "Sports Illustrated", "Content 1", author1)
    val magazine2 = Magazines("John Doe", 2, 2022, "Vogue", "Content 2", author2)
    val magazine3 = Magazines("Amy Lee", 3, 2022, "National Geographic", "Content 3", author3)
    val magazines = listOf(magazine1, magazine2, magazine3)

    val newspaper1 = Newspaper("New York Times", 1, 1, 2022, "Headline 1", "Article 4", "Content 4", author1)
    val newspaper2 = Newspaper("The Guardian", 2, 1, 2022, "Headline 2", "Article 5", "Content 5", author2)
    val newspaper3 = Newspaper("The Washington Post", 3, 1, 2022, "Headline 3", "Article 6", "Content 6", author3)
    val newspapers = listOf(newspaper1, newspaper2, newspaper3)

    val comic1 = Comics(
        1,
        2022,
        Illustrator("Jack", "Smith", "", Date(1981-1-1)),
        Publisher("DC Comics", "New York", "2022-01-01"),
        "Superman",
        "Comic 1",
        author1
    )
    val comic2 = Comics(
        2,
        2022,
        Illustrator("Mary", "Johnson", "", Date(1982-2-2)),
        Publisher("Marvel", "Los Angeles", "2022-01-01"),
        "Batman",
        "Comic 2",
        author2
    )
    val comic3 = Comics(
        3,
        2022,
        Illustrator("Robert", "Williams", "", Date(1983-3-3)),
        Publisher("Dark Horse", "Seattle", "2022-01-01"),
        "Wonder Woman",
        "Comic 3",
        author3
    )
    val comics = listOf(comic1, comic2, comic3)

    val title = "Vogue"
    searchTitle(title, magazines, newspapers, comics)

    val authorFirstName = "John"
    val authorLastName = "Smith"
    searchTitleByAuthor(authorFirstName, magazines, newspapers, comics, books)
    searchTitleByAuthor(authorLastName, magazines, newspapers, comics, books)
}

fun searchTitle(title: String, Magazines: List<Magazines>, newspapers: List<Newspaper>, comics: List<Comics>) {
    for (magazines in Magazines) {
        if (magazines.title == title) {
            println("Found Magazines: $title")
            return
        }
    }
    for (newspaper in newspapers) {
        if (newspaper.title == title) {
            println("Found newspaper: $title")
            return
        }
    }
    for (comic in comics) {
        if (comic.title == title) {
            println("Found comic: $title")
            return
        }
    }
    println("Not found")
}

fun searchTitleByAuthor(name: String, magazines: List<Magazines>, newspapers: List<Newspaper>, comics: List<Comics>, books: List<Book>) {
    println("Works by $name:")
    for (book in books) {
        if (book.authors.firstName == name || book.authors.lastName == name) {
            println("- ${book.title} (Book)")
        }
    }
    for (magazine in magazines) {
        if (magazine.author.firstName == name || magazine.author.lastName == name) {
            println("- ${magazine.title} (Magazine)")
        }
    }
    for (newspaper in newspapers) {
        if (newspaper.author.firstName == name || newspaper.author.lastName == name) {
            println("- ${newspaper.title} (Newspaper)")
        }
    }
    for (comic in comics) {
        if (comic.author.firstName == name || comic.author.lastName == name) {
            println("- ${comic.title} (Comic)")
        }
    }
}

