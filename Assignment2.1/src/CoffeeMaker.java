
public class CoffeeMaker {
    private boolean on;
    private String coffeeType;
    private int coffeeAmount;

    public CoffeeMaker() {
        on = false;
        coffeeType = "normal";
        coffeeAmount = 10; // default minimum
    }

    public void pressOnOff() {
        on = !on;
    }

    public boolean isOn() {
        return on;
    }

    public void setCoffeeType(String type) {
        if (on) {
            if (type.equalsIgnoreCase("normal") || type.equalsIgnoreCase("espresso")) {
                coffeeType = type.toLowerCase();
            }
        }
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeAmount(int amount) {
        if (on) {
            if (amount >= 10 && amount <= 80) {
                coffeeAmount = amount;
            }
        }
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }
}



// test: CoffeeMakerDriver
class CoffeeMakerDriver {
    public static void main(String[] args) {
        CoffeeMaker myCoffeeMaker = new CoffeeMaker();

        myCoffeeMaker.pressOnOff();  // Turn it on
        System.out.println("Coffee maker is " + (myCoffeeMaker.isOn() ? "on" : "off"));

        myCoffeeMaker.setCoffeeType("espresso");
        System.out.println("Coffee type is " + myCoffeeMaker.getCoffeeType());

        myCoffeeMaker.setCoffeeAmount(50);
        System.out.println("Coffee amount is " + myCoffeeMaker.getCoffeeAmount() + " ml");

        myCoffeeMaker.pressOnOff();  // Turn it off
        System.out.println("Coffee maker is " + (myCoffeeMaker.isOn() ? "on" : "off"));
    }
}