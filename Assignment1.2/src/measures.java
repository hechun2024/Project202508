import java.util.Scanner;


public class measures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Weight (g): ");
        double grams = scanner.nextDouble();

        final double originalGrams = grams;

        // conversion constants
        double gramsPerLuoti = 13.28;
        double gramsPerNaula = 32 * gramsPerLuoti;      // 425 g
        double gramsPerLeiviska = 20 * gramsPerNaula;   // 8512 g

        // calculate leiviskä
        int leiviska = (int)(grams / gramsPerLeiviska);

        // calculate naula
        int naula = (int)(grams / gramsPerNaula);

        // calculate luoti
        double luoti = grams / gramsPerLuoti;

        // print result
        System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti.%n",
                originalGrams, leiviska, naula, luoti);
    }
}