package oop;

import static java.lang.Math.sqrt;

public class Kolmnurk extends Shape {
    private double firstSide;
    private double secondSide;
    private double thirdSide;

    public Kolmnurk(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }


    @Override
    String Area() {
        double halfArea = 0.5 * (firstSide + secondSide + thirdSide);
        double area = sqrt(halfArea * (halfArea - firstSide) * (halfArea - secondSide) * (halfArea - thirdSide));
        String rounded = String.format("%.2f", area);
        return rounded;
    }

    @Override
    String Circumference() {
        double circumference = firstSide + secondSide + thirdSide;
        String rounded = String.format("%.2f", circumference);
        return rounded;
    }
}
