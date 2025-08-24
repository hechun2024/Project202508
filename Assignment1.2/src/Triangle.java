import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the lengths of the two legs
        System.out.print("Enter the length of the first leg: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the length of the second leg: ");
        double b = scanner.nextDouble();

        // Compute hypotenuse using Pythagoras' theorem
        double hypotenuse = Math.sqrt(a * a + b * b);

        // Print result with two decimals
        System.out.printf("The length of the hypotenuse is: %.2f\n", hypotenuse);
    }
}
