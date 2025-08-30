// task 2

import java.util.ArrayList;

public class Library2 {
    private ArrayList<Book> books = new ArrayList<>();

    //add book
    public void addBook(Book book){
        books.add(book);
    }

    //display books
    public void displayBooks(){
        System.out.println("Library Catalog:");

        for (int i = 0; i < books.size(); i++){
            Book book = books.get(i);
            System.out.println((i+1) +"." + book);
        }
    }

    //findBooksByAuthor(String author)
    public void findBooksByAuthor(String author) {
        System.out.println("\nBooks by Author \"" + author + "\":");

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getAuthor().equals(author)) {
                System.out.println("Title:" + book.getTitle() + ", Year:" + book.getYear());
            }
        }
    }

    ///////task 2 借书
    public Book borrowBook(String title){
        if (title == null) return null;

        for (int i = 0; i < books.size(); i++){
            Book book = books.get(i);
            if (book.getTitle().equalsIgnoreCase(title)){
                books.remove(i);
                System.out.println("Borrowed: " + book.getTitle());
                return book;
            }
        }
        // if not found the book
        System.out.println("Sorry, \"" + title + "\" is not available.");
        return null;
    }

    // return the book
    public void returnBook(Book book){
        if (book == null){
            System.out.println("Cannot return a null book.");
            return;
        }
        books.add(book);
        System.out.println("Returned: " + book.getTitle());

    }
}