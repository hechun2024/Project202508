// task 4.1_1
// A simple calculator class that stores a running total
public class Calculator {
    private int value; // holds the current sum

    // Reset the calculator to zero
    public void reset() {
        value = 0;
    }

    // Add a positive integer; throw exception if input is negative
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        value += number;
    }

    // Return the current value
    public int getValue() {
        return value;
    }

    // Temporary main method for testing
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.reset();
        calc.add(5);
        calc.add(10);
        calc.add(20);
        System.out.println("Current value: " + calc.getValue()); // should print 35
    }
}
