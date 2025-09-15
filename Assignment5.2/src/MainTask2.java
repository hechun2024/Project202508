// 5.2_2
// Implement a thread-safe list that allows multiple threads to add and remove elements concurrently without
// causing data inconsistency.
// Use synchronization mechanisms to ensure thread safety during add and remove operations.


import java.util.ArrayList;

class ThreadSafeList<T> {  // 泛型类T → Type（任意类型）
    private final ArrayList<T> list = new ArrayList<>();  // 用final修饰，保证引用不可变,不会创建多个list对象

    public synchronized void add(T element) {
        list.add(element);
    }

    public synchronized int size() {
        return list.size();
    }

    public synchronized boolean remove(T element) {
        return list.remove(element);  // remove返回boolean，表示是否成功删除
    }

    public synchronized void printList() {
        System.out.println(list);
    }
}

// Tester class
class ListWorker extends Thread {
    private ThreadSafeList<String> safeList;
    private String item;

    public ListWorker(ThreadSafeList<String> safeList, String item) {
        this.safeList = safeList;
        this.item = item;
    }

    public void run() {
        safeList.add(item);
        System.out.println(getName() + " added: " + item);
    }
}

public class MainTask2 {
    public static void main(String[] args) {
        ThreadSafeList<String> safeList = new ThreadSafeList<>();

        // multiple threads adding elements
        Thread t1 = new ListWorker(safeList, "Apple");
        Thread t2 = new ListWorker(safeList, "Banana");
        Thread t3 = new ListWorker(safeList, "Cherry");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {}

        safeList.printList(); // should contain all added elements safely
        System.out.println("Final size: " + safeList.size());
        safeList.remove("Banana");  //test remove
        System.out.println("After removal:");
        safeList.printList();
        System.out.println("Final size: " + safeList.size());

    }
}
