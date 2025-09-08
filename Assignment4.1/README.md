# Calculator Program

This program demonstrates a simple Calculator class.  
The calculator keeps track of a running total, supports resetting,  
adding positive integers, and retrieving the current value.  
Negative integers are not allowed and will throw an exception.

```java
public class Calculator {
    private int value;

    public void reset() {
        value = 0;
    }

    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        value += number;
    }

    public int getValue() {
        return value;
    }
}
```
# Explanation 

Field value: stores the current sum of all numbers added.

Method reset(): sets the total back to zero.

Method add(int number): adds a positive integer to the total. If the input is negative, an IllegalArgumentException is thrown.

Method getValue(): returns the current total stored in the calculator.

This design follows the MVC pattern, where the Calculator class acts as the Model.
It does not handle user interface but only the logic of calculation.