// task 4

// Vehicle interface
interface Vehicle4 {
    void start();
    void stop(); //直接打印 没有返回值
    String getInfo();
    String calculateFuelEfficiency(); // now returns String (value + unit)
}

// ElectricVehicle interface
interface ElectricVehicle4 {
    void charge();
}

// AbstractVehicle class
abstract class AbstractVehicle4 implements Vehicle4, ElectricVehicle4 {
    protected String brand;   //protected = 子类可以直接访问（即使在不同包里），但外部普通类不能访问。
    protected String model;
    protected int year;
    protected double fuelEfficiency;
    protected String efficiencyUnit; // new field

    public AbstractVehicle4(String brand, String model, int year, double fuelEfficiency, String efficiencyUnit) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelEfficiency = fuelEfficiency;
        this.efficiencyUnit = efficiencyUnit;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }

    // Default implementation of charge()
    public void charge() {
        System.out.println("Not possible to charge this type of vehicle.");
    }

    // New implementation: return value + unit
    public String calculateFuelEfficiency() {
        return fuelEfficiency + " " + efficiencyUnit;
    }
}

// Car (fuel vehicle)
class Car4 extends AbstractVehicle4 {
    public Car4(String brand, String model, int year, double fuelEfficiency, String efficiencyUnit) {
        super(brand, model, year, fuelEfficiency, efficiencyUnit);
    }

    public void start() {
        System.out.println("Car is starting...");
    }

    public void stop() {
        System.out.println("Car is stopping...");
    }

    public String getInfo() {
        return "Car - Brand: " + brand + ", Model: " + model;
    }
}

// Electric Car
class ElectricCar4 extends AbstractVehicle4 {
    public ElectricCar4(String brand, String model, int year, double fuelEfficiency, String efficiencyUnit) {
        super(brand, model, year, fuelEfficiency, efficiencyUnit);
    }

    public void start() {
        System.out.println("Electric Car is starting silently...");
    }

    public void stop() {
        System.out.println("Electric Car is stopping.");
    }

    public String getInfo() {
        return "Electric Car - Brand: " + brand + ", Model: " + model;
    }

    public void charge() {
        System.out.println("Electric Car is charging...");
    }
}

// Demo class
public class VehicleDemo4 {
    public static void main(String[] args) {
        Vehicle4 car = new Car4("Toyota", "Corolla", 2022, 15.5, "km/l");
        Vehicle4 usCar = new Car4("Ford", "Fusion", 2020, 35.0, "mpg");
        Vehicle4 eCar = new ElectricCar4("Tesla", "Model 3", 2023, 0.15, "kWh/km");

        // Car in metric
        car.start();
        System.out.println(car.getInfo());
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency());

        // Car in imperial
        usCar.start();
        System.out.println(usCar.getInfo());
        System.out.println("Fuel Efficiency: " + usCar.calculateFuelEfficiency());

        // Electric Car
        eCar.start();
        System.out.println(eCar.getInfo());
        System.out.println("Energy Efficiency: " + eCar.calculateFuelEfficiency());
        ((AbstractVehicle4)eCar).charge();
    }
}
