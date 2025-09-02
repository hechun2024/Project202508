// task 3

// Vehicle interface (as before)
interface Vehicle3 {
    void start();
    void stop();
    String getInfo();
}

// New ElectricVehicle interface
interface ElectricVehicle {
    void charge();  // Method to charge the vehicle
}

// AbstractVehicle implements both Vehicle3 and ElectricVehicle
abstract class AbstractVehicle3 implements Vehicle3, ElectricVehicle {
    protected String brand;
    protected String model;
    protected int year;

    public AbstractVehicle3(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }

    // Default implementation of charge (for non-electric vehicles)
    public void charge() {
        System.out.println("Not possible to charge this type of vehicle.");
    }
}

// Regular Car (non-electric)
class Car3 extends AbstractVehicle3 {
    public Car3(String brand, String model, int year) {
        super(brand, model, year);
    }

    public void start() {
        System.out.println("Car is starting...");
    }

    public void stop() {
        System.out.println("Car is stopping...");
    }

    public String getInfo() {
        return "This is a Car. Brand: " + brand + ", Model: " + model;
    }
}

// ElectricCar (extends AbstractVehicle but overrides charge)
class ElectricCar extends AbstractVehicle3 {
    public ElectricCar(String brand, String model, int year) {
        super(brand, model, year);
    }

    public void start() {
        System.out.println("Electric Car is starting silently...");
    }

    public void stop() {
        System.out.println("Electric Car is stopping.");
    }

    public String getInfo() {
        return "This is an Electric Car. Brand: " + brand + ", Model: " + model;
    }

    // Overriding charge method
    public void charge() {
        System.out.println("Electric Car is charging...");
    }
}

// ElectricMotorcycle (extends AbstractVehicle)
class ElectricMotorcycle extends AbstractVehicle3 {
    public ElectricMotorcycle(String brand, String model, int year) {
        super(brand, model, year);
    }

    public void start() {
        System.out.println("Electric Motorcycle is starting silently...");
    }

    public void stop() {
        System.out.println("Electric Motorcycle is stopping.");
    }

    public String getInfo() {
        return "This is an Electric Motorcycle. Brand: " + brand + ", Model: " + model;
    }

    public void charge() {
        System.out.println("Electric Motorcycle is charging...");
    }
}

// Demo class
public class VehicleDemo3 {
    public static void main(String[] args) {
        Vehicle3 car = new Car3("Toyota", "Corolla", 2022);
        Vehicle3 eCar = new ElectricCar("Tesla", "Model 3", 2023);
        Vehicle3 eBike = new ElectricMotorcycle("Zero", "SR/F", 2022);

        // Car (non-electric)
        car.start();
        car.stop();
        System.out.println(car.getInfo());
        ((AbstractVehicle3)car).charge(); // "Not possible to charge"
        //「把 car 当作 AbstractVehicle 类型来看待」，这样才能调用 charge()。type casting强制类型转换

        // Electric Car
        eCar.start();
        eCar.stop();
        System.out.println(eCar.getInfo());
        ((AbstractVehicle3)eCar).charge(); // "Electric Car is charging..."

        // Electric Motorcycle
        eBike.start();
        eBike.stop();
        System.out.println(eBike.getInfo());
        ((AbstractVehicle3)eBike).charge(); // "Electric Motorcycle is charging..."
    }
}

