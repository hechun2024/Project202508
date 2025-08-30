//  task 6-user

import java.util.ArrayList;     // 基于 数组 实现，可以动态扩展大小。
import java.util.List;         //是一个 接口，它规定了“线性有序集合”该有哪些功能

public class User {
    private String name;
    private int age;
    private List<Book2> borrowedBooks;

    public User(String name, int age){
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {return name;}
    public int getAge(){return age;}
    public List<Book2> getBorrowedBooks(){return borrowedBooks;}

    // 借书：加到用户的借书列表
    public void borrowBook(Book2 book){borrowedBooks.add(book);}

    // 还书：从用户的借书列表移除
    public void returnBook(Book2 book){borrowedBooks.remove(book);}

    @Override
    public String toString(){
        return "User: " + name + " (Age: " + age + "), Borrowed Books: " + borrowedBooks.size();
    }

}

//====================


class Library6 {
    private List<Book2> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    // 添加书
    public void addBook(Book2 book){
        if (book != null) books.add(book);
    }

    // 添加用户
    public void addUser(User user){
        if (user != null) users.add(user);
    }

    // 用户借书
    public void borrowBook(User user, String title){
        if (user == null || title == null) return;

        for (int i = 0; i < books.size(); i++){
            Book2 book = books.get(i);
            if (book.getTitle().equalsIgnoreCase(title)){
                books.remove(i);           // 从馆藏移除
                user.borrowBook(book);     // 加到用户的借书列表
                System.out.println(user.getName() + " borrowed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Sorry, \"" + title + "\" is not available.");
    }

    // 用户还书
    public void returnBook(User user, Book2 book){
        if (user == null || book == null) return;
        user.returnBook(book);   // 从用户的借书列表移除
        books.add(book);         // 加回馆藏
        System.out.println(user.getName() + " returned: " + book.getTitle());
    }

    // 展示所有用户和他们借的书
    public void displayUsers(){
        System.out.println("=== Library Users ===");
        for (User user : users){
            System.out.println(user);
            for (Book2 b : user.getBorrowedBooks()){
                System.out.println("   - " + b.getTitle());
            }
        }
    }
}



//==================FOR TESTING==================

class LibraryUserDemo {
    public static void main(String[] args) {
        Library6 lib = new Library6();

        // 添加书
        lib.addBook(new Book2("Clean Code", "Robert Martin", 2008));
        lib.addBook(new Book2("Effective Java", "Joshua Bloch", 2018));

        // 添加用户
        User alice = new User("Alice", 20);
        User bob = new User("Bob", 22);
        lib.addUser(alice);
        lib.addUser(bob);

        // Alice 借书
        lib.borrowBook(alice, "Clean Code");

        // Bob 借书
        lib.borrowBook(bob, "Effective Java");

        // 显示所有用户和他们的借书情况
        lib.displayUsers();

        // Alice 还书
        Book2 bookToReturn = alice.getBorrowedBooks().get(0);
        lib.returnBook(alice, bookToReturn);

        // 再次显示
        System.out.println("\nAfter returning:");
        lib.displayUsers();
    }
}
