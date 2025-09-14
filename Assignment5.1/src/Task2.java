// Task5.1_2使用多线程计算大数组的和

import java.util.Random;

class SumWorker extends Thread {
    private int[] array;
    private int start, end;
    private long partialSum;

    SumWorker(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.partialSum = 0;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            partialSum += array[i];
        }
    }

    public long getPartialSum() {
        return partialSum;
    }
}

public class Task2 {
    public static void main(String[] args) {
        int size = 100000;
        int[] array = new int[size];

        // 填充随机数
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100); // 0~99
        }

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available cores: " + cores);

        int chunk = size / cores;
        SumWorker[] workers = new SumWorker[cores];

        // 分配任务
        for (int i = 0; i < cores; i++) {
            int start = i * chunk;
            int end = (i == cores - 1) ? size : (i + 1) * chunk;
            workers[i] = new SumWorker(array, start, end);
            workers[i].start();
        }

        // 汇总结果
        long total = 0;
        for (int i = 0; i < cores; i++) {
            try {
                workers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            total += workers[i].getPartialSum();
        }

        System.out.println("Total sum = " + total);
    }
}
