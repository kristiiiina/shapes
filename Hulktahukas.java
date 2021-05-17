package oop;

public class Hulktahukas extends Shape {
    private double apothem;
    private double length;
    private int numberOfSides;

    public Hulktahukas(double apothem, double length, int numberOfSides) {
        this.apothem = apothem;
        this.length = length;
        this.numberOfSides = numberOfSides;
    }


    @Override
    String Area() {
        double circumference = CircumferencePolygon();
        double apothem = 5.0;
        double area = 0.5 * apothem * circumference;
        String rounded = String.format("%.2f", area);
        return rounded;
    }

    @Override
    String Circumference() {
        double circumference = CircumferencePolygon();
        String rounded = String.format("%.2f", circumference);
        return rounded;
    }

    private double CircumferencePolygon() {
        double circumference = numberOfSides * length;
        return circumference;
    }
}
