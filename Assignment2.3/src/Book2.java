// task 4- book
import java.util.ArrayList;

public class Book2 {
    private String title;
    private String author;
    private int year;

    // Task 4 新增字段
    private double rating; // 书的评分
    private ArrayList<String> reviews; // 存评论

    // constructor
    public Book2(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
        this.rating = 0.0; // 默认没有评分
        this.reviews = new ArrayList<>();
    }

    // get method
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public int getYear(){return year;}
    public double getRating(){ return rating; }     //
    public ArrayList<String> getReviews(){ return reviews; }


    // Task 4 方法
    public void setRating(double rating){
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;  //表示 把方法参数 rating 的值，赋给当前对象的成员变量 rating。
        } else {
            System.out.println("Invalid rating! (0 ~ 5 allowed)");
        }
    }

    public void addReview(String review){
        reviews.add(review);
    }



    //print method（toString() is a method in Java)
    @Override
    public String toString(){
        return "Title:" + title + ", Author:"+  author +", Year:"+ year;
    }
}



