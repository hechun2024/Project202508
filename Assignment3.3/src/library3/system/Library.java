//task 3 Library
package library3.system;

import library3.model.Book;
import library3.model.LibraryMember;
import java.util.ArrayList;
import java.util.List;

// Manages books and members of the library
public class Library {
    private List<Book> books = new ArrayList<>();
    private List<LibraryMember> members = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void addMember(LibraryMember member) { members.add(member); }

    public void borrowBook(LibraryMember member, Book book) {
        if (books.contains(book) && !book.isReserved()) { // 🔹 check not reserved
            member.borrowBook(book);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Book not available.");
        }
    }

    public void returnBook(LibraryMember member, Book book) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            System.out.println(member.getName() + " returned " + book.getTitle());
        }
    }

    // 🔹 NEW: reserve a book
    public void reserveBook(LibraryMember member, Book book) {
        if (books.contains(book) && !book.isReserved()) {
            book.setReserved(true); // mark as reserved
            member.reserveBook(book);
            System.out.println(member.getName() + " reserved " + book.getTitle());
        } else {
            System.out.println("Book already reserved.");
        }
    }

    // 🔹 NEW: cancel reservation
    public void cancelReservation(LibraryMember member, Book book) {
        if (member.getReservedBooks().contains(book)) {
            book.setReserved(false);
            member.cancelReservation(book);
            System.out.println(member.getName() + " canceled reservation of " + book.getTitle());
        }
    }

    // 🔹 NEW: display reserved books
    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        for (Book book : member.getReservedBooks()) {
            System.out.println(" - " + book.getTitle());
        }
    }
}
