import java.io.*;
import java.util.Date;

class Student implements Serializable {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return id + " " + name + " (" + age + ")";
    }
}

class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private String instructor;

    public Course(String courseCode, String courseName, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
    }
    @Override
    public String toString() {
        return courseCode + " " + courseName + " by " + instructor;
    }
}

class Enrollment implements Serializable {
    private Student student;
    private Course course;
    private String enrollmentDate;

    public Enrollment(Student student, Course course, String enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }
    @Override
    public String toString() {
        return student + " enrolled in " + course + " on " + enrollmentDate;
    }
}

public class Task3 {
    private static final String FILENAME = "enrollments.ser";

    public static void main(String[] args) {
        Enrollment enrollment = new Enrollment(
                new Student(1, "Anna", 25),
                new Course("TX2024", "OOP-Java", "Jarkko"),
                new Date().toString()
        );

        // Serialize
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            out.writeObject(enrollment);
            System.out.println("Enrollment serialized to " + FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILENAME))) {
            Enrollment e = (Enrollment) in.readObject();
            System.out.println("Deserialized: " + e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
