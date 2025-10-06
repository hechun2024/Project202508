// 8.4_task1  Calculate mean of an array in functional way (e.g. no for-loops)

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10};

        double mean = Arrays.stream(numbers)
                .average()       // 直接计算平均值
                .orElse(0.0);   // 如果数组为空，返回0.0

        System.out.println("Mean: " + mean);
    }
}
