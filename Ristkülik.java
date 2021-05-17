package oop;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.util.Scanner;

public class Ristkülik extends Shape {
    private double length;
    private double width;

    public Ristkülik(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    String Area() {
        double area = length * width;
        String rounded = String.format("%.2f", area);
        return rounded;
    }

    @Override
    String Circumference() {
        //double length = Ask("length");
        //double width = Ask("width");
        double circumference = 2 * (length + width);
        String rounded = String.format("%.2f", circumference);
        return rounded;
    }
}
