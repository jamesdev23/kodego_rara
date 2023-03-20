import activity_07_b.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class AcceptAndacceptAndBorrowItemTest {
    private val library: Library = Library()

    val user1 = User("user1")
    val user2 = User("user2")
    val book1 = Book("Book 1")
    val book2 = Book("Book 2")
    val book3 = Book("Book 3")
    val book4 = Book("Book 4")

    val available = book1
    val reserved = book2
    val forInteralUse = book3
    val forFixing = book4

    @Test
    fun acceptAndBorrowItem() {
        // expected: success
        assertThrows<LibraryException.UserException.UserHas5orMoreItems> {
            user1.borrowCount = 10
            user2.borrowCount = 20

            acceptAndBorrowItem(user1, available)
            acceptAndBorrowItem(user2, available)
        }

        // expected: fail
        assertThrows<LibraryException.UserException.UserHas5orMoreItems> {
            user1.borrowCount = 0
            user1.unpaidDues = 500.0
            user2.borrowCount = 0
            user2.unpaidDues = 1_000.0

            acceptAndBorrowItem(user1, available)
            acceptAndBorrowItem(user2, available)
        }

        // expected: success
        assertThrows<LibraryException.UserException.UserHasUnpaidDues> {
            user1.borrowCount = 0
            user1.unpaidDues = 500.0
            user2.borrowCount = 0
            user2.unpaidDues = 1_000.0

            acceptAndBorrowItem(user1, available)
            acceptAndBorrowItem(user2, available)
        }

        // expected: fail
        assertThrows<LibraryException.UserException.UserHasUnpaidDues> {
            user1.borrowCount = 10
            user2.borrowCount = 20

            acceptAndBorrowItem(user1, available)
            acceptAndBorrowItem(user2, available)
        }


        // expected: success
        assertThrows<LibraryException.ItemException.ItemIsReserved> {
            acceptAndBorrowItem(user1, reserved)
            acceptAndBorrowItem(user2, reserved)
        }

        // expected: fail
        assertThrows<LibraryException.ItemException.ItemIsReserved> {
            user1.borrowCount = 10
            user2.borrowCount = 20

            acceptAndBorrowItem(user1, available)
            acceptAndBorrowItem(user2, available)
        }

        // expected: success
        assertThrows<LibraryException.ItemException.ItemIsForInternalUse> {
            acceptAndBorrowItem(user1, forInteralUse)
            acceptAndBorrowItem(user2, forInteralUse)
        }

        // expected: fail
        assertThrows<LibraryException.ItemException.ItemIsForInternalUse> {
            user1.borrowCount = 10
            user2.borrowCount = 20

            acceptAndBorrowItem(user1, available)
            acceptAndBorrowItem(user2, available)
        }

        // expected: success
        assertThrows<LibraryException.ItemException.ItemIsForFixing> {
            acceptAndBorrowItem(user1, forFixing)
            acceptAndBorrowItem(user2, forFixing)
        }

        // expected: fail
        assertThrows<LibraryException.ItemException.ItemIsForFixing> {
            user1.borrowCount = 10
            user2.borrowCount = 20

            acceptAndBorrowItem(user1, available)
            acceptAndBorrowItem(user2, available)
        }

    }
}