package oop;


import javafx.scene.text.Text;

public class Ring extends Shape {
    private double radius;

    public Ring(double radius) {

        this.radius = radius;
    }

    @Override
    String Area() {

        Text tekst = new Text();
        double area = Math.PI * radius * radius;
        String rounded = String.format("%.2f", area);
        return rounded;
    }

    @Override
    String Circumference() {
        double circumference = Math.PI * 2 * radius;
        String rounded = String.format("%.2f", circumference);
        return rounded;
    }
}
