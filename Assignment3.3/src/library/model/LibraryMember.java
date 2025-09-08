// task 2
package library.model;

import java.util.ArrayList;
import java.util.List;

// Represents a member of the library
public class LibraryMember {
    private String name;
    private int memberId;
    private List<Book> borrowedBooks = new ArrayList<>();

    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() { return name; }
    public int getMemberId() { return memberId; }

    public void borrowBook(Book book) { borrowedBooks.add(book); }
    public void returnBook(Book book) { borrowedBooks.remove(book); }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    @Override
    public String toString() {
        return "Member " + name + " (ID: " + memberId + ")";
    }
}

