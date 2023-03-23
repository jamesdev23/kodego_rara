import activity_07_b.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LibraryUnitTest {
    private val user1 = User("user1")
    private val user2 = User("user2")
    private val book1 = Book("Book 1")
    private val book2 = Book("Book 2")
    private val book3 = Book("Book 3")
    private val book4 = Book("Book 4")
    private val available = book1
    private val reserved = book2
    private val forInternalUse = book3
    private val forFixing = book4

    @Test
    fun acceptAndBorrowItem() {
        assertThrows<LibraryException.UserException.UserHas5orMoreItems> {
            user1.borrowCount = 10
            user2.borrowCount = 20

            acceptAndBorrowItem(user1, available)
            acceptAndBorrowItem(user2, available)
        }

        assertThrows<LibraryException.UserException.UserHasUnpaidDues> {
            user1.borrowCount = 0
            user1.unpaidDues = 500.0
            user2.borrowCount = 0
            user2.unpaidDues = 1_000.0

            acceptAndBorrowItem(user1, available)
            acceptAndBorrowItem(user2, available)
        }

        assertThrows<LibraryException.ItemException.ItemIsReserved> {
            acceptAndBorrowItem(user1, reserved)
            acceptAndBorrowItem(user2, reserved)
        }

        assertThrows<LibraryException.ItemException.ItemIsForInternalUse> {
            acceptAndBorrowItem(user1, forInternalUse)
            acceptAndBorrowItem(user2, forInternalUse)
        }

        assertThrows<LibraryException.ItemException.ItemIsForFixing> {
            acceptAndBorrowItem(user1, forFixing)
            acceptAndBorrowItem(user2, forFixing)
        }

    }
}