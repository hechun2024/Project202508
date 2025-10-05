//8.3_task2 - 使用 Lambda 表达式和 Stream API 对整数列表进行排序和过滤
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Task2 {
    public static void main(String[] args) {

        //  Create a list of integers
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 8, 20, 15, 3, 12));
        System.out.println("Original list: " + numbers);

        // Remove even numbers using removeIf
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After removing even numbers: " + numbers);

        // Double each remaining number using replaceAll
        numbers.replaceAll(n -> n * 2);
        System.out.println("After doubling odd numbers: " + numbers);

        // Calculate the sum using forEach
        final int[] sum = {0};  //只有一个元素的整型数组，内容是 {0}。final 修饰符确保引用不可变，但数组内容可变
        numbers.forEach(n -> sum[0] += n);    // Lambda 表达式中对 sum[0] 进行累加
        System.out.println("Total sum: " + sum[0]);
    }
}
