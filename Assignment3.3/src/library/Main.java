// task 2 Main
package library;

import library.model.Book;
import library.model.LibraryMember;
import library.system.Library;

// Main class to test the system
public class Main{
    public static void main(String[] args) {
        Library library = new Library();

        // Create books
        Book book1 = new Book("Java Basics", "John Doe", "ISBN001");
        Book book2 = new Book("Advanced Java", "Jane Smith", "ISBN002");

        // Create members
        LibraryMember member1 = new LibraryMember("Alice", 1);
        LibraryMember member2 = new LibraryMember("Bob", 2);

        // Add to library
        library.addBook(book1);
        library.addBook(book2);
        library.addMember(member1);
        library.addMember(member2);

        // Borrow and return
        library.borrowBook(member1, book1);
        library.returnBook(member1, book1);
    }
}
