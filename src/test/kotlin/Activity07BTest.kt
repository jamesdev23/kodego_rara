import activity_07_b.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LibraryTest {
    private val library: Library = Library()

    var user1 = User("user1")
    var user2 = User("user2")
    val book1 = Book("Book 1")
    val book2 = Book("Book 2")
    val book3 = Book("Book 3")
    val book4 = Book("Book 4")

    var bookReserved = book2
    var bookForInteralUse = book3
    var bookForFixing = book4

    @Test
    fun borrowItem() {

        assertThrows<LibraryException.UserException.UserHas5orMoreItems> {
            user1.borrowCount = 5
            library.borrowItem(user1, book1)
        }

        assertThrows<LibraryException.UserException.UserHasUnpaidDues> {
            user1.borrowCount = 0
            user1.unpaidDues = 500.0
            library.borrowItem(user1,book1)
        }

        assertThrows<LibraryException.ItemException.ItemIsReserved> {
            library.borrowItem(user2,bookReserved)
        }

        assertThrows<LibraryException.ItemException.ItemIsForInternalUse> {
            library.borrowItem(user2,bookForInteralUse)
        }

        assertThrows<LibraryException.ItemException.ItemIsForFixing> {
            library.borrowItem(user2,bookForFixing)
        }



    }
}