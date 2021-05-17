package oop;

public class Rööpkülik extends Shape {
    private double base;
    private double height;
    private double leg;


    public Rööpkülik(double base, double height, double leg) {
        this.base = base;
        this.height = height;
        this.leg = leg;
    }


    @Override
    String Area() {
        double area = base * height;
        String rounded = String.format("%.2f", area);
        return rounded;
    }

    @Override
    String Circumference() {
        double circumference = 2 * (leg + base);
        String rounded = String.format("%.2f", circumference);
        return rounded;
    }
}
