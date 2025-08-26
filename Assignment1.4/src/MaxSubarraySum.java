import java.util.Scanner;

public class MaxSubarraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入数组大小
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // 输入数组元素
        System.out.println("Enter the integers into the array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // 最大子数组和
        int maxSum = Integer.MIN_VALUE;
        int start = 0, end = 0;

        // 遍历所有子数组
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start = i;
                    end = j;
                }
            }
        }

        // 输出结果（索引从 1 开始）
        System.out.println("\nMaximum sum: " + maxSum);
        System.out.println("Integers: " + (start + 1) + "–" + (end + 1));

        scanner.close();
    }
}
