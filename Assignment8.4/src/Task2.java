// 8.4_task2 Description: 使用Java Stream API对一个整数列表进行以下操作：过滤出所有奇数，将每个奇数乘以2，然后计算结果的总和。

import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        int result = numbers.stream()
                .filter(n -> n % 2 != 0)  // 保留奇数
                .map(n -> n * 2)          // 每个数乘2
                .reduce(0, Integer::sum); // 求和

        System.out.println("Result: " + result);
    }
}
