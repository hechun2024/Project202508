// task 2

public class Bus extends Car {

    private int capacity;         // max load
    private int passengerCount;   // current passenger number

    // constructor  (initial)
    public Bus(String typeName, int capacity) {
        super(typeName);
        this.capacity = capacity;
        this.passengerCount = 0;
    }

    public Bus(String typeName, double gasolineLevel, double speed, int capacity) {
        super(typeName, gasolineLevel, speed);
        this.capacity = capacity;
        this.passengerCount = 0;
    }


    public void passengerEnter() {
        if (passengerCount < capacity) {
            passengerCount++;
            System.out.println("One passenger entered. Current passengers: " + passengerCount);
        } else {
            System.out.println("Bus is full!");
        }
    }


    public void passengerExit() {
        if (passengerCount > 0) {
            passengerCount--;
            System.out.println("One passenger exited. Current passengers: " + passengerCount);
        } else {
            System.out.println("No passengers to exit.");
        }
    }

    // Getter
    public int getPassengerCount() {return passengerCount;}

    public int getCapacity() {return capacity;}
}

