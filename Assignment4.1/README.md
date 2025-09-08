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
