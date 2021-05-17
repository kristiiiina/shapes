package oop;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;


public class TestShape extends Application {
    public void start(Stage primaryStage) {
        Group juur = new Group();
        VBox vBox = new VBox(15);

        Button nuppKolmnurk = new Button("Kolmnurk");
        Button nuppRomb = new Button("Romb");
        Button nuppRööpkülik = new Button("Rööpkülik");
        Button nuppRing = new Button("Ring");
        Button nuppRistkülik = new Button("Ristkülik");
        Button nuppPolügon = new Button("Polügon");

        Text text = new Text("Vali kujund, mille pindala ja ümbermõõtsoovid teada. Väljumiseks vajuta \"X\".");

        vBox.getChildren().addAll(nuppKolmnurk, nuppRomb, nuppRööpkülik
                , nuppRing, nuppRistkülik, nuppPolügon);

        juur.getChildren().add(vBox);


        nuppKolmnurk.setOnMouseClicked(me -> {
            vBox.getChildren().removeAll(vBox.getChildren());
            Stage kusimus = new Stage();
            ShapeToDraw("Kolmnurk", juur);
            Button arvuta = buttonArvuta(juur);
            BorderPane piir = new BorderPane();
            String esimeneKülg = "Esimese külje pikkus";
            TextField firstSideIn = textFieldPrint(esimeneKülg);
            piir.setTop(firstSideIn);
            String teineKülg = "Teise külje pikkus";
            TextField secondSideIn = textFieldPrint(teineKülg);
            piir.setCenter(secondSideIn);
            String kolmasKülg = "Kolmanda külje pikkus";
            TextField thirdSideIn = textFieldPrint(kolmasKülg);
            piir.setBottom(thirdSideIn);
            juur.getChildren().add(piir);
            arvuta.setOnMouseClicked(me1 -> {
                double firstSide =kontrollJaVäärtustamineDouble(firstSideIn);
                double secondSide =kontrollJaVäärtustamineDouble(secondSideIn);
                double thirdSide =kontrollJaVäärtustamineDouble(thirdSideIn);
                if (firstSide != 0 && secondSide != 0 && thirdSide!=0) {
                    Kolmnurk kolmnurk = new Kolmnurk(firstSide, secondSide, thirdSide);
                    arvutamineJaFailiKirjutamine(juur,kolmnurk);
                }

            });
            Scene scene = new Scene(juur, 600, 300);
            kusimus.setScene(scene);
            kusimus.show();
        });
        nuppRööpkülik.setOnMouseClicked(me -> {
            vBox.getChildren().removeAll(vBox.getChildren());
            Stage kusimus = new Stage();
            ShapeToDraw("Rööpkülik", juur);
            Button arvuta = buttonArvuta(juur);
            BorderPane piir = new BorderPane();
            String alus = "Alus";
            TextField baseIn = textFieldPrint(alus);
            piir.setTop(baseIn);
            String kõrgus = "Kõrgus";
            TextField heightIn = textFieldPrint(kõrgus);
            piir.setCenter(heightIn);
            String külg = "Külje pikkus";
            TextField legIn = textFieldPrint(külg);
            piir.setBottom(legIn);
            juur.getChildren().add(piir);
            arvuta.setOnMouseClicked(me1 -> {
                double base = kontrollJaVäärtustamineDouble(baseIn);
                double height = kontrollJaVäärtustamineDouble(heightIn);
                double leg = kontrollJaVäärtustamineDouble(legIn);
                if (base != 0 && height != 0 && leg !=0) {
                    Rööpkülik rööpkülik = new Rööpkülik(base, height, leg);
                    arvutamineJaFailiKirjutamine(juur,rööpkülik);
                    try {
                        KirjutaAndmed(rööpkülik);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            Scene scene = new Scene(juur, 600, 300);
            kusimus.setScene(scene);
            kusimus.show();

        });

        nuppRomb.setOnMouseClicked(me -> {
            vBox.getChildren().removeAll(vBox.getChildren());
            Stage kusimus = new Stage();
            ShapeToDraw("Romb", juur);
            Button arvuta = buttonArvuta(juur);
            BorderPane piir = new BorderPane();
            String külg = "Külje pikkus";
            TextField Iside = textFieldPrint(külg);
            piir.setTop(Iside);
            String kõrgus = "Kõrgus";
            TextField Iheight = textFieldPrint(kõrgus);
            piir.setBottom(Iheight);
            juur.getChildren().add(piir);
            arvuta.setOnMouseClicked(me1 -> {
                double side =kontrollJaVäärtustamineDouble(Iside);
                double height =kontrollJaVäärtustamineDouble(Iheight);
                if (side != 0 && height != 0) {
                    Romb romb = new Romb(side, height);
                    arvutamineJaFailiKirjutamine(juur,romb);
                }

        });
            Scene scene = new Scene(juur, 600, 300);
            kusimus.setScene(scene);
            kusimus.show();
        });

        nuppRistkülik.setOnMouseClicked(me -> {
            vBox.getChildren().removeAll(vBox.getChildren());
            Stage kusimus = new Stage();
            ShapeToDraw("Ristkülik", juur);
            Button arvuta = buttonArvuta(juur);
            BorderPane piir = new BorderPane();
            String pikkus = "Pikkus";
            TextField lenghtIn = textFieldPrint(pikkus);
            piir.setTop(lenghtIn);
            String laius = "Laius";
            TextField widthIn = textFieldPrint(laius);
            piir.setBottom(widthIn);
            juur.getChildren().add(piir);
            arvuta.setOnMouseClicked(me1 -> {
                double lenght =kontrollJaVäärtustamineDouble(lenghtIn);
                double width =kontrollJaVäärtustamineDouble(widthIn);
                if (lenght != 0 && width != 0) {
                    Ristkülik ristkülik = new Ristkülik(lenght, width);
                    arvutamineJaFailiKirjutamine(juur,ristkülik);
                }
            });
            Scene scene = new Scene(juur, 600, 300);
            kusimus.setScene(scene);
            kusimus.show();


        });

        nuppRing.setOnMouseClicked(me -> {
            vBox.getChildren().removeAll(vBox.getChildren());
            Stage kusimus = new Stage();
            ShapeToDraw("Ring", juur);
            BorderPane piir = new BorderPane();
            Button arvuta = buttonArvuta(juur);
            String radiusString = "Raadiuse pikkus";
            TextField textField = textFieldPrint(radiusString);
            piir.setCenter(textField);
            juur.getChildren().add(piir);
            arvuta.setOnMouseClicked(me1 -> {
                    double radius = kontrollJaVäärtustamineDouble(textField);
                if (radius != 0) {
                    Ring ring = new Ring(radius);
                    arvutamineJaFailiKirjutamine(juur,ring);
                }


            });
            Scene scene = new Scene(juur, 600, 300);
            kusimus.setScene(scene);
            kusimus.show();

        });


        nuppPolügon.setOnMouseClicked(me -> {
            vBox.getChildren().removeAll(vBox.getChildren());
            Stage kusimus = new Stage();
            ShapeToDraw("Polügon", juur);
            Button arvuta = buttonArvuta(juur);
            BorderPane piir = new BorderPane();
            TextField apothemIn, lenghtIn, numberOfSidesIn;
            String apoteem = "Apoteem";
            apothemIn = textFieldPrint(apoteem);
            piir.setTop(apothemIn);
            String pikkus = "Pikkus";
            lenghtIn = textFieldPrint(pikkus);
            piir.setCenter(lenghtIn);
            String palju = "Mitu külge on";
            numberOfSidesIn = textFieldPrint(palju);
            piir.setBottom(numberOfSidesIn);
            juur.getChildren().add(piir);
            arvuta.setOnMouseClicked(me1 -> {
                double apothem =kontrollJaVäärtustamineDouble(apothemIn);
                double lenght =kontrollJaVäärtustamineDouble(lenghtIn);
                int numberOfSides = kontrollJaVäärtustamineInt(numberOfSidesIn);
                if (apothem != 0 && lenght != 0 && numberOfSides != 0) {
                    Hulktahukas hulktahukas = new Hulktahukas(apothem, lenght, numberOfSides);
                    arvutamineJaFailiKirjutamine(juur,hulktahukas);
                }
            });
            Scene scene = new Scene(juur, 600, 300);
            kusimus.setScene(scene);
            kusimus.show();


        });
        Scene stseen1 = new Scene(juur, 535, 535, Color.SNOW);
        stseen1.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.X) { //"X" vajutamisel programm lõpetab töö
                primaryStage.close();
            }
        });
        primaryStage.setTitle("Shape");
        primaryStage.setMinWidth(500); //Selleks, et andmed oleks selgelt kuvatud, ei tohi akna suurus olla liiga väike
        primaryStage.setMinHeight(400);
        primaryStage.setScene(stseen1);
        primaryStage.show();
    }

    protected void ShapeToDraw(String shape, Group juur) {
        switch (shape) {
            case "Kolmnurk": {
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(250.0, 10.0,
                        200.0, 70.0,
                        300.0, 70.0);

                juur.getChildren().add(triangle);
                triangle.setFill(Color.LIGHTPINK);
                triangle.setStroke(Color.LIGHTBLUE);
                break;
            }
            case "Romb": {
                Polygon rhombus = new Polygon();
                rhombus.getPoints().addAll(250.0, 10.0,
                        200.0, 75.0,
                        250.00, 140.0,
                        300.0, 75.0);
                rhombus.setFill(Color.VIOLET);
                rhombus.setStroke(Color.BLACK);
                juur.getChildren().add(rhombus);
                break;
            }
            case "Polügon": {
                Polygon polygon = new Polygon();
                polygon.getPoints().addAll(250.0, 10.0,
                        200.0, 50.0,
                        250.0, 90.0,
                        300.0, 90.0,
                        350.0, 50.0,
                        300.0, 10.0);
                juur.getChildren().add(polygon);
                polygon.setFill(Color.INDIGO);
                polygon.setStroke(Color.BLUEVIOLET);
                break;
            }
            case "Ring":
                Circle circle = new Circle(30, Color.LIGHTBLUE);
                circle.setCenterX(200);
                circle.setCenterY(40);
                circle.setStroke(Color.BLACK);
                juur.getChildren().add(circle);
                break;

            case "Ristkülik":
                Rectangle rectangle = new Rectangle(200, 10, 100, 100);
                juur.getChildren().add(rectangle);
                rectangle.setFill(Color.LIGHTBLUE);
                rectangle.setStroke(Color.LIGHTPINK);
                break;

            case "Rööpkülik":
                Polygon parallelogram = new Polygon();
                parallelogram.getPoints().addAll(250.0, 10.0,
                        200.0, 70.0,
                        350.00, 70.0,
                        400.0, 10.0);
                parallelogram.setFill(Color.KHAKI);
                parallelogram.setStroke(Color.BLACK);
                juur.getChildren().add(parallelogram);

                break;
        }
    }

    private Button buttonArvuta(Group juur) { //tekitakse nupp arvutamiseks
        Button arvuta = new Button("Arvuta");
        arvuta.setLayoutX(10);
        arvuta.setLayoutY(110);
        juur.getChildren().add(arvuta);
        return arvuta;
    }

    private void areaPrint(Group juur, Shape figuur) {
        Text areaPrint = new Text();
        areaPrint.setText("Pindala on " + figuur.Area());
        areaPrint.setX(10);
        areaPrint.setY(200);
        juur.getChildren().add(areaPrint);
    }

    private void circumferencePrint(Group juur, Shape figuur) {
        Text circumferencePrint = new Text();
        circumferencePrint.setText("Ümbermõõt on " + figuur.Circumference());
        circumferencePrint.setX(10);
        circumferencePrint.setY(230);
        juur.getChildren().add(circumferencePrint);
    }

    private TextField textFieldPrint(String side) { //et alguses oleks kirjas, mida peab sisestama, nupu vajutamisel tekst kaob ära
        TextField textField = new TextField(side);
        textField.setOnMouseClicked(me1 -> {
            if (textField.getText().equals(side)) {
                textField.setText("");
            } else {
                textField.setText(side);
            }
        });
        return textField;
    }
public void KirjutaAndmed(Shape figuur) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fileShape.txt")))) {
        writer.write("Pindala on " + figuur.Area() + "\n");
        writer.write("Ümbermõõt on " +figuur.Circumference() + "\n");
    }
}

    private double kontrollJaVäärtustamineDouble(TextField sideIn) { //sisestatud andmete kontrollimiseks
    double side = 0;
        try {
            side = Double.parseDouble(sideIn.getText());
        } catch (NumberFormatException e) {
            sideIn.setText("Proovi uuesti!");
        }
        return side;
    }
    private int kontrollJaVäärtustamineInt(TextField sideIn) {
        int side = 0;
        try {
        side = Integer.parseInt(sideIn.getText());
        } catch (NumberFormatException e) {
        sideIn.setText("Proovi uuesti!");
        }
        return side;
        }

        private void arvutamineJaFailiKirjutamine(Group juur, Shape figuur) {
            areaPrint(juur, figuur);
            circumferencePrint(juur, figuur);
            try {
                KirjutaAndmed(figuur);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {
        launch(args);
    }
}
