import java.util.Random;
import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) {
        // hard-coded name arrays
        String[] firstNames = {"Tracy", "Bob", "Leo", "Mike", "Swift", "Frank", "Grace", "Helena"};
        String[] lastNames = {"Goodman", "Joh", "Brown", "Taylor", "Wilson", "Lee", "Walker", "Hall"};

        // numbers of random names
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the names: ");
        int count = scanner.nextInt();

        Random random = new Random();

        // generate random names in a for loop
        for (int i = 0; i < count; i++) {
            int firstIndex = random.nextInt(firstNames.length);
            int lastIndex = random.nextInt(lastNames.length);

            String fullName = firstNames[firstIndex] + " " + lastNames[lastIndex];
            System.out.println(fullName);
        }

        scanner.close();
    }
}