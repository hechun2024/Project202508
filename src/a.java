//public class a {
//    public static void main(String[] args) {
//        double a = 5.678;
//        double b = 3.456;
//        double sum = a + b;
//
//        // 保留 2 位小数
//        System.out.printf("Result: %.2f\n", sum); //%占位符， .2表示保留两位小数，f表示浮点数
//        // 也可以用%n表示换行
//        System.out.printf("Result: %f \n", sum); //c,f,d,s是常用的占位符，代表字符，浮点数，整数，字符串
//    }
//}


//-----------------------------------------------------------------------------
//
//abstract class Animal {
//    String name;
//    Animal(String name) {
//        this.name = name;
//    }
//    abstract void makeSound();
//}
//
//class Cat extends Animal {
//    Cat(String name) {
//        super(name);
//    }
//    void makeSound() {
//        System.out.println(name + " says: Meow!");
//    }
//}
//
//class Dog extends Animal {
//    Dog(String name) {
//        super(name);
//    }
//    void makeSound() {
//        System.out.println(name + " says: Woof!");
//    }
//}
//
//public class a {
//    public static void main(String[] args) {
//        Animal c = new Cat("Kitty");
//        Animal d = new Dog("Buddy");
//
//        c.makeSound();
//        d.makeSound();
//    }
//}

//-----------------------------------------------------------------------------
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class a {
//    public static void main(String[] args) {
//        try {
//            File file = new File("test.txt"); // 假设文件名
//            Scanner sc = new Scanner(file);
//
//
//            while (sc.hasNextLine()) {
//                System.out.println(sc.nextLine());
//            }
//            sc.close();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found!");
//            e.printStackTrace();
//        }
//    }
//}

//-----------------------------------------------------------------------------
import java.io.*;

public class a {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
        }
    }
}
