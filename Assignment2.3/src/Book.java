// task1-Book

public class Book {
    private String title;
    private String author;
    private int year;

    // constructor
    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // get method
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getYear(){
        return year;
    }

    //print method（toString() is a method in Java)
    @Override
    public String toString(){
        return "Title:" + title + ", Author:"+  author +", Year:"+ year;
    }
}



