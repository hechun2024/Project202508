public class Car4 {
    private double speed;
    private double gasolineLevel;
    private String typeName;

    // Cruise control fields
    private boolean cruiseOn;
    private double targetSpeed;
    private static final double MIN_SPEED = 30; // lower bound
    private static final double MAX_SPEED = 150; //  upper bound

    public Car4(String typeName) {
        this.typeName = typeName;
        this.speed = 0;
        this.gasolineLevel = 100; // start full tank for simplicity
        this.cruiseOn = false;
        this.targetSpeed = 0;
    }

    public Car4(String typeName, double gasolineLevel, double speed) {
        this.typeName = typeName;
        this.gasolineLevel = gasolineLevel;
        this.speed = speed;
        this.cruiseOn = false;
        this.targetSpeed = 0;
    }

    // ---- Cruise control methods ----
    public boolean setCruiseSpeed(double target) {
        if (target >= MIN_SPEED && target <= MAX_SPEED) {
            this.targetSpeed = target;
            return true;
        }
        return false;
    }

    public boolean turnCruiseOn() {
        if (targetSpeed == 0 || gasolineLevel <= 0) {
            cruiseOn = false;
            return false; // failed to enable
        }
        cruiseOn = true;
        adjustSpeed();
        return true;
    }

    public void turnCruiseOff() {
        cruiseOn = false;
    }

    public boolean isCruiseOn() {
        return cruiseOn;
    }

    public double getTargetSpeed() {
        return targetSpeed;
    }

    // Adjust speed to reach target
    private void adjustSpeed() {
        if (!cruiseOn) return;

        if (gasolineLevel <= 0) {
            cruiseOn = false;
            speed = 0;
            return;
        }

        if (speed < targetSpeed) {
            while (speed < targetSpeed && gasolineLevel > 0) {
                accelerate();
            }
        } else if (speed > targetSpeed) {
            while (speed > targetSpeed && gasolineLevel > 0) {
                decelerate(5); // slow down step
            }
        }
    }

    // ---- Existing methods ----
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 10;
            gasolineLevel -= 1;
        } else {
            speed = 0;
        }
    }

    public void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else {
            speed = 0;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public String getTypeName() {
        return typeName;
    }

    public void fillTank() {
        gasolineLevel = 100;
    }

    public double getGasolineLevel() {
        return gasolineLevel;
    }
}

// test
class CarDriver {
    public static void main(String[] args) {
        Car4 myCar = new Car4("BMW", 80, 0);

        myCar.setCruiseSpeed(100);
        boolean success = myCar.turnCruiseOn();

        if (success) {
            System.out.println("Cruise control ON. Target speed: " + myCar.getTargetSpeed());
            System.out.println("Current speed: " + myCar.getSpeed());
        } else {
            System.out.println("Failed to enable cruise control!");
        }

        myCar.turnCruiseOff();
        System.out.println("Cruise control OFF");
    }
}
