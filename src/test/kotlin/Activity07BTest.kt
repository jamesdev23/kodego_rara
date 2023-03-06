import activity_07_b.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LibraryTest {
    private val library: Library = Library()

    val user1 = User("user1")
    val user2 = User("user2")
    val book1 = Book("Book 1")
    val book2 = Book("Book 2")
    val book3 = Book("Book 3")
    val book4 = Book("Book 4")

    val bookAvailable = book1
    val bookReserved = book2
    val bookForInteralUse = book3
    val bookForFixing = book4

    @Test
    fun borrowItem() {

        assertThrows<LibraryException.UserException.UserHas5orMoreItems> {
            // expected: success
            user1.borrowCount = 5
            library.borrowItem(user1, bookAvailable)

            // expected: fail
            user1.borrowCount = 1
            library.borrowItem(user1, bookAvailable)
        }

        assertThrows<LibraryException.UserException.UserHasUnpaidDues> {
            // expected: success
            user1.borrowCount = 0
            user1.unpaidDues = 500.0
            library.borrowItem(user1,bookAvailable)

            // expected: fail
            user1.borrowCount = 0
            user1.unpaidDues = 0.0
            library.borrowItem(user1,bookAvailable)


        }

        assertThrows<LibraryException.ItemException.ItemIsReserved> {
            // expected: success
            library.borrowItem(user2,bookReserved)

            // expected: fail
            library.borrowItem(user2,book1)
        }

        assertThrows<LibraryException.ItemException.ItemIsForInternalUse> {
            // expected: success
            library.borrowItem(user2,bookForInteralUse)

            // expected: fail
            library.borrowItem(user2,book2)
        }

        assertThrows<LibraryException.ItemException.ItemIsForFixing> {
            // expected: success
            library.borrowItem(user2,bookForFixing)

            // expected: fail
            library.borrowItem(user2,book3)
        }

    }
}