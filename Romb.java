package oop;

public class Romb extends Shape {
    private double side;
    private double height;

    public Romb(double side, double height) {
        this.height = height;
        this.side = side;
    }

    @Override
    String Area() {
        double area = 0.5 * side * height;
        String rounded = String.format("%.2f", area);
        return rounded;
    }

    @Override
    String Circumference() {
        double circumference = 4 * side;
        String rounded = String.format("%.2f", circumference);
        return rounded;
    }
}
