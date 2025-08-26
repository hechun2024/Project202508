
public class Car {

    private double speed;
    private double gasolineLevel;
    private String typeName;

    public Car(String typeName) {
        speed = 0;
        gasolineLevel = 0;
        this.typeName = typeName;
    }

    // additional constructor with gasoline tank capacity and speed arguments.
    public Car(String typeName, double gasolineLevel, double speed) {
        this.typeName = typeName;
        this.gasolineLevel = gasolineLevel;
        this.speed = speed;
    }

  
    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
        else
            speed = 0;
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }

    double getSpeed() {
        return speed;
    }

    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = 100;
    }

    double getGasolineLevel() {
        return gasolineLevel;
    }
}