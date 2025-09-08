//task 3 Main
package library3;

import library3.model.Book;
import library3.model.LibraryMember;
import library3.system.Library;

// Main class to test the system
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Java Basics", "John Doe", "ISBN001");
        Book book2 = new Book("Advanced Java", "Jane Smith", "ISBN002");

        LibraryMember member1 = new LibraryMember("Alice", 1);

        library.addBook(book1);
        library.addBook(book2);
        library.addMember(member1);

        // 🔹 NEW: Reserve a book
        library.reserveBook(member1, book1);
        library.displayReservedBooks(member1);

        // 🔹 NEW: Cancel reservation
        library.cancelReservation(member1, book1);
        library.displayReservedBooks(member1);
    }
}
