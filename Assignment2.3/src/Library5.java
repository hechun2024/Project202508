// Task 5: Library Statistics


import java.util.ArrayList;

public class Library5 {
    private ArrayList<Book2> books = new ArrayList<>();

    //add book
    public void addBook(Book2 book) {
        books.add(book);
    }

    //display books
    public void displayBooks() {
        System.out.println("Library Catalog:");

        for (int i = 0; i < books.size(); i++) {
            Book2 book = books.get(i);
            System.out.println((i + 1) + "." + book);
        }
    }

    //findBooksByAuthor(String author)
    public void findBooksByAuthor(String author) {
        System.out.println("\nBooks by Author \"" + author + "\":");

        for (int i = 0; i < books.size(); i++) {
            Book2 book = books.get(i);
            if (book.getAuthor().equals(author)) {
                System.out.println("Title:" + book.getTitle() + ", Year:" + book.getYear());
            }
        }
    }

    /// ////task 2 借书
    public Book2 borrowBook(String title) {
        if (title == null) return null;

        for (int i = 0; i < books.size(); i++) {
            Book2 book = books.get(i);
            if (book.getTitle().equalsIgnoreCase(title)) {
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
    public void returnBook(Book2 book) {
        if (book == null) {
            System.out.println("Cannot return a null book.");
            return;
        }
        books.add(book);
        System.out.println("Returned: " + book.getTitle());
    }


    // === Task 3: Book Availability Check ===
    public boolean isBookAvailable(String title) {
        if (title == null)
            return false;
        for (Book2 book : books) {   //for-each 里不能修改列表结构（不能直接 remove）
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    // task 5-
    public double getAverageBookRating() {
        if (books.isEmpty()) return 0;

        double sum = 0;
        int count = 0;
        for (Book2 book : books) {
            if (book.getRating() > 0) {// 只算有评分的书
                sum += book.getRating();
                count++;
            }
        }
        //Java 的三元运算符 (ternary operator)：如果条件成立，就返回 值1，否则返回值2      （条件） ? 值1 : 值2
        return (count == 0) ? 0.0 : sum/count;
    }
    // 找到评论数最多的书
    public Book2 getMostReviewedBook(){
        if (books.isEmpty()) return null;

        Book2 mostReviewed = books.get(0);    //books.get(0) 是取 第 1 本书，作为初始比较对象，先假设第 1 本书评论最多
        for (Book2 book : books){
            if (book.getReviews().size() > mostReviewed.getReviews().size()){
                mostReviewed = book;   //找到评论更多的，就替换
            }
        }
        return mostReviewed;
    }
}
