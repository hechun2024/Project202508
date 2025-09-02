//task 1

// 1. Define the Vehicle interface
// This interface declares the common methods that all vehicles must implement
interface Vehicle {
    void start();
    void stop();
    String getInfo();
}

// 2. Car class implementing Vehicle
class Car implements Vehicle {
    public void start() {
        System.out.println("Car is starting...");
    }
    public void stop() {
        System.out.println("Car is stopping...");
    }
    public String getInfo() {
        return "This is a Car. It has 4 wheels.";
    }
}

// 3. Motorcycle class implementing Vehicle
class Motorcycle implements Vehicle {
    public void start() {
        System.out.println("Motorcycle is starting...");
    }
    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }
    public String getInfo() {
        return "This is a Motorcycle. It has 2 wheels.";
    }
}

// 4. Bus class implementing Vehicle
class Bus implements Vehicle {
    public void start() {
        System.out.println("Bus is starting...");
    }
    public void stop() {
        System.out.println("Bus is stopping...");
    }
    public String getInfo() {
        return "This is a Bus. It can carry many passengers.";
    }
}

// 5. Demo class to test Vehicle interface implementations
public class VehicleDemo {
    public static void main(String[] args) {
        // Create instances of Car, Motorcycle, and Bus
        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();
        Vehicle bus = new Bus();

        // Demonstrate Car
        car.start();
        car.stop();
        System.out.println(car.getInfo());

        // Demonstrate Motorcycle
        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo());

        // Demonstrate Bus
        bus.start();
        bus.stop();                            //方法是 void，它们直接打印消息，不返回值。
        System.out.println(bus.getInfo());   //getInfo() 返回一个 String，需要决定是：打印 保存 传递？
    }
}
