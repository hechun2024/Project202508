import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        String filename = "fibonacci.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            long a = 0, b = 1;
            writer.write("Index;Fibonacci\n"); //first row for column name
            for (int i = 0; i < 60; i++) {
                writer.write(i + ";" + a + "\n");
                long next = a + b;
                a = b;
                b = next;
            }
            System.out.println("Fibonacci sequence written to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
