import activity_07_b.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LibraryTest {
    val library: Library = Library()

    var user1 = User("SampleUser1")
    var user2 = User("SampleUser2")
    var book1 = Book("Don Quixote")
    var bookReserved = Book("Wuthering Heights")
    var bookForInteralUse = Book("East of Eden")
    var bookForFixing = Book("The Scarlet Letter")

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