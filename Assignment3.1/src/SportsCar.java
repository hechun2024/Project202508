// task 1

public class SportsCar extends Car {
    public SportsCar(String typeName) {
        super(typeName);
    }

    public SportsCar(String typeName, double gasolineLevel, double speed) {
        super(typeName, gasolineLevel, speed);
    }

    @Override
    public void accelerate() {
        if (getGasolineLevel() > 0) {
            super.accelerate(); // 保证基础逻辑
            super.accelerate(); // 再多加一次加速
        }
    }

    @Override
    void decelerate(int amount) {
        // 比普通车刹车更灵敏
        super.decelerate(amount * 2);
    }

    @Override
    void fillTank() {
        // 跑车耗油更快，所以一次加满可能默认容量更大
        super.fillTank();
        System.out.println("Sports car consumes more gasoline!");
    }
}
