// 8.3_task1 - 使用 Lambda 表达式和 Comparator 对象列表进行排序和过滤

import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        // 1️⃣ Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25, "New York"));
        people.add(new Person("Bob", 30, "London"));
        people.add(new Person("Charlie", 22, "New York"));
        people.add(new Person("David", 28, "Paris"));
        people.add(new Person("Eve", 35, "Berlin"));

        System.out.println("Original list:");
        people.forEach(System.out::println);   //用了方法引用use method reference

        // 2️⃣ Sort the list by age (ascending) using a Lambda expression
        people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        System.out.println("\nSorted by age:");
        people.forEach(System.out::println);

        // 3️⃣ Remove everyone who is not from New York using removeIf
        people.removeIf(person -> !person.getCity().equalsIgnoreCase("New York"));

        System.out.println("\nPeople from New York:");
        people.forEach(System.out::println);
    }
}

// Person class
class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return name + " (" + age + ", " + city + ")";
    }
}
