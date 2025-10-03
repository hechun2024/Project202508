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
/*
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

class MyClass {
    void sayHello() {
        System.out.println("Hello");
    }
}

public class a {
    public static void main(String[] args) {
        MyClass obj = new MyClass();

        // Even though MyClass doesn't extend anything explicitly,
        // it still inherits methods from Object
        System.out.println(obj.toString());  // from Object
        System.out.println(obj.hashCode());  // from Object
        System.out.println(obj.equals(obj)); // from Object
    }
}
/*  上面例子表示，如果一个类没有显式地继承任何其他类，它会 隐式地继承 Object 类。
Q: Java 中所有类的父类是谁？
A: java.lang.Object。
Q: Object 提供了哪些常用方法？
A: toString(), equals(), hashCode(), clone(), finalize(), getClass(), wait(), notify(), notifyAll() 等


//-----------------------------------------------------------------------------
public class a {
    public static void main(String[] args) {
        int x = 0;

        int k = 1, j = 1;
        for (int i = 1; --j != 0 || k != 0;
             k = j != 0 ? i % j != 0 ? k : k-j : (j = i += 2));

        System.out.println(x);
    }
}
/*
“没人知道 println(x) 会不会被执行”？

因为 for 循环的条件依赖于 奇完全数是否存在。

如果奇完全数存在，循环会停，println(x) 就会执行。

如果不存在，循环永远不会停，println(x) 就永远不会执行。

由于数学界至今不知道奇完全数是否存在 → 我们也不能确定这段程序的行为。
（为什么运行后“没有任何提示”？
原因是：你的 for 循环 没有结束，程序一直在跑循环，所以永远执行不到 System.out.println(x);。）
 */


import java.util.ArrayList;
import java.util.Scanner;

public class a{
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String input = "one\n" + "two\n" +
                "three\n" + "four\n" +
                "five\n" + "one\n" +
                "six\n";

        Scanner reader = new Scanner(input);    // Not System.in, but a string!

        ArrayList<String> read = new ArrayList<>();

        while (true) {
            System.out.println("Enter an input: ");
            String line = reader.nextLine();
            if (read.contains(line)) {   //当读到一个已经出现过的单词时，就退出循环。
                break;
            }
            read.add(line);
        }
        System.out.println("Thank you!");

        if (read.contains("six")) {
            //因为 "six" 没有被加入（程序在读到第二个 "one" 就结束了），所以这个提示不会打印。
            System.out.println("A value that should not have been added to the group was added to it.");
        }}
    }