//task 3 Book
package library3.model;

// Represents a book in the library
public class Book {
    private String title;
    private String author;
    private String isbn;

    // 🔹 NEW: add reserved field
    private boolean reserved = false;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    // 🔹 NEW: methods for reservation
    public boolean isReserved() { return reserved; }
    public void setReserved(boolean reserved) { this.reserved = reserved; }

    @Override
    public String toString() {
        // 🔹 NEW: show reserved status in output
        return title + " by " + author + " (ISBN: " + isbn + ")" + (reserved ? " [Reserved]" : "");
    }
}
