//  task 1-library class

import java.util.ArrayList;

public class Library {
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
}