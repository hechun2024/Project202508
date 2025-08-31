// task 3

public class ShapeCalculator {
    public static void main(String[] args) {    //program entry point
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
        shapes[2] = new Triangle(3.0, 8.0);

        // 遍历数组，多态调用 calculateArea()
        System.out.println("Shape Calculator:");
        System.out.println("Area of Circle with radius 5.0: " + shapes[0].calculateArea());
        System.out.println("Area of Rectangle with width 4.0 and height 6.0: " + shapes[1].calculateArea());
        System.out.println("Area of Triangle with base 3.0 and height 8.0: " + shapes[2].calculateArea());
    }
}

// 基类
class Shape {
    public double calculateArea() {
        return 0.0;
    }
}

// 子类 Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// 子类 Rectangle
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// 子类 Triangle
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
