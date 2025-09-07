import java.io.*;

class Person implements Serializable {
    String name;
    int age;
}

public class Test {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.name = "Alice";
        p.age = 20;

        // 序列化：写入文件
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"));
        oos.writeObject(p);
        oos.close();

        // 反序列化：从文件读出
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"));
        Person p2 = (Person) ois.readObject();
        ois.close();

        System.out.println(p2.name + " - " + p2.age);
    }
}
