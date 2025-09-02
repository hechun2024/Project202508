// task 2

// Vehicle interface (same as before)
interface Vehicle2 {
    void start();
    void stop();
    String getInfo();
}

// AbstractVehicle class implements Vehicle and adds common fields/methods
abstract class AbstractVehicle implements Vehicle2 {
    protected String brand;
    protected String model;
    protected int year;

    // Constructor for all vehicles
    public AbstractVehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // A common method for all vehicles
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }
}

// Car class extends AbstractVehicle
class Car2 extends AbstractVehicle {
    public Car2(String brand, String model, int year) {
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

// Motorcycle class extends AbstractVehicle
class Motorcycle2 extends AbstractVehicle {
    public Motorcycle2(String brand, String model, int year) {
        super(brand, model, year);
    }

    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }

    public String getInfo() {
        return "This is a Motorcycle. Brand: " + brand + ", Model: " + model;
    }
}

// Bus class extends AbstractVehicle
class Bus2 extends AbstractVehicle {
    public Bus2(String brand, String model, int year) {
        super(brand, model, year);
    }

    public void start() {
        System.out.println("Bus is starting...");
    }

    public void stop() {
        System.out.println("Bus is stopping...");
    }

    public String getInfo() {
        return "This is a Bus. Brand: " + brand + ", Model: " + model;
    }
}

// Demo class
public class VehicleDemo2 {
    public static void main(String[] args) {
        Vehicle2 car = new Car2("Toyota", "Corolla", 2022);
        Vehicle2 motorcycle = new Motorcycle2("Yamaha", "MT-07", 2021);
        Vehicle2 bus = new Bus2("Volvo", "9700", 2020);

        // Start, stop, and display info
        car.start();
        car.stop();
        System.out.println(car.getInfo());
        ((AbstractVehicle)car).displayInfo(); // Casting to access displayInfo()

        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo());
        ((AbstractVehicle)motorcycle).displayInfo();

        bus.start();
        bus.stop();
        System.out.println(bus.getInfo());
        ((AbstractVehicle)bus).displayInfo();
    }
}

