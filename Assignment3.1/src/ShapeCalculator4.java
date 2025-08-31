// task 4

public class ShapeCalculator4 {
    public static void main(String[] args) {
        Shape4[] shapes = new Shape4[3];      //array
        shapes[0] = new Circle4("Red", 5.0);
        shapes[1] = new Rectangle4("Blue", 4.0, 6.0);
        shapes[2] = new Triangle4("Green", 3.0, 8.0);

        for (Shape4 shape : shapes) {
            System.out.println(
                    "Shape Color: " + shape.getColor() +
                            ", Area: " + shape.calculateArea()
            );
        }
    }
}

// superclass
class Shape4 {
    private String color;

    public Shape4(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double calculateArea() {
        return 0.0;
    }
}

// subclass Circle
class Circle4 extends Shape4 {
    private double radius;

    public Circle4(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// subclass Rectangle
class Rectangle4 extends Shape4 {
    private double width;
    private double height;

    public Rectangle4(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// subclass Triangle
class Triangle4 extends Shape4 {
    private double base;
    private double height;

    public Triangle4(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
