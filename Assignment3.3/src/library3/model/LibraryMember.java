//task 3 LibraryMember
package library3.model;

import java.util.ArrayList;
import java.util.List;

// Represents a member of the library
public class LibraryMember {
    private String name;
    private int memberId;
    private List<Book> borrowedBooks = new ArrayList<>();

    // 🔹 NEW: add reserved books list
    private List<Book> reservedBooks = new ArrayList<>();

    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() { return name; }
    public int getMemberId() { return memberId; }

    public void borrowBook(Book book) { borrowedBooks.add(book); }
    public void returnBook(Book book) { borrowedBooks.remove(book); }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    // 🔹 NEW: reservation methods
    public void reserveBook(Book book) { reservedBooks.add(book); }
    public void cancelReservation(Book book) { reservedBooks.remove(book); }
    public List<Book> getReservedBooks() { return reservedBooks; }

    @Override
    public String toString() {
        return "Member " + name + " (ID: " + memberId + ")";
    }
}
