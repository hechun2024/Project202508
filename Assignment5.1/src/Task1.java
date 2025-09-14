// Task5.1_1 实现两个线程交替打印 1-20 的奇偶数，要求奇数线程先打印 1，然后偶数线程打印完，再由奇数线程打印剩下的奇数。

class OddPrinter extends Thread {
    private int max;
    private Thread evenThread;  // 保存偶数线程引用

    OddPrinter(int max) {
        this.max = max;
    }

    public void setEvenThread(Thread evenThread) {
        this.evenThread = evenThread;
    }

    public void run() {
        // 第一步：先打印 1
        System.out.println("Odd Thread: 1");

        // 第二步：等偶数线程执行完
        try {
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 第三步：打印剩下的奇数
        for (int i = 3; i <= max; i += 2) {
            System.out.println("Odd Thread: " + i);
        }
    }
}

class EvenPrinter extends Thread {
    private int max;

    EvenPrinter(int max) {
        this.max = max;
    }

    public void run() {
        for (int i = 2; i <= max; i += 2) {
            System.out.println("Even Thread: " + i);
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        int max = 20;

        EvenPrinter evenThread = new EvenPrinter(max);
        OddPrinter oddThread = new OddPrinter(max);

        // 把偶数线程传给奇数线程，让它能 join
        oddThread.setEvenThread(evenThread);

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Printing complete.");
    }
}
