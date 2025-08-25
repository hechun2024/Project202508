import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter start number: ");
        int start = scanner.nextInt();

        System.out.print("Enter end number: ");
        int end = scanner.nextInt();

        System.out.println("from " + start + " to " + end + " The prime number is：");

        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }

        scanner.close();
    }

    // check if it is prime number
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;  // 1 和负数不是质数
        }

        // check from 2 to n
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false; // 能被整除 → 不是质数
            }
        }
        return true; // 没有整除 → 是质数
    }
}