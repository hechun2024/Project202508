import java.util.Scanner;

public class F_Celsius {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();

        double celsius = (fahrenheit - 32) * 5 / 9;

        // keep the value with one decimal
        System.out.printf("Temperature in Celsius: %.1f\n", celsius);
    }
}
