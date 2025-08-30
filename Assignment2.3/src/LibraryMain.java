// task1-LibraryMain


public class LibraryMain {
    public static void main(String[] args){

        //create book instances
        Book book1 = new Book("Introduction to Java Programming","John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms",  "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson",  2019);

        //create library
        Library library = new Library();

        //add book to library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        //display books
        library.displayBooks();

        //searched by author
        library.findBooksByAuthor("Jane Doe");

    }
}
