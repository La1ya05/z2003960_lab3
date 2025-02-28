package Lavanya;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Garden extends Application {
    private iComposite selectedItem;
    private double lastX, lastY;
    private FlowerBed flowerBed;
    private Flower f1, f2;
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setStyle("-fx-background-color:green;");
        flowerBed = new FlowerBed(165, 215, 215, 115);
        f1 = new Flower(new Point2D(100, 100), Color.RED, true);
        f2 = new Flower(new Point2D(300, 125), Color.RED, true);
        root.getChildren().add(flowerBed.getRectangle());
        root.getChildren().add(f1.getCircle());
        root.getChildren().add(f2.getCircle());
        Scene scene = new Scene(root, 600, 400);
        scene.setOnMousePressed(this::mousePressed);
        scene.setOnMouseDragged(this::mouseDragged);
        scene.setOnMouseReleased(this::mouseReleased);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Garden Layout");
        primaryStage.show();
    }

    private void mousePressed(MouseEvent event) {
        lastX = event.getSceneX();
        lastY = event.getSceneY();
        selectedItem = null;
        if (f1.getCircle().contains(lastX, lastY)) {
            selectedItem = f1;
        } else if (f2.getCircle().contains(lastX, lastY)) {
            selectedItem = f2;
        } else if (flowerBed.getRectangle().contains(lastX, lastY)) {
            selectedItem = flowerBed;
        }
    }

    private void mouseDragged(MouseEvent event) {
        if (selectedItem != null) {
            double deltaX = event.getSceneX() - lastX;
            double deltaY = event.getSceneY() - lastY;
            selectedItem.move(deltaX, deltaY);
            lastX = event.getSceneX();
            lastY = event.getSceneY();
        }
    }

    private void mouseReleased(MouseEvent event) {
        if (selectedItem instanceof Flower) {
            Flower flower = (Flower) selectedItem;
            if (flower.isInNode(flowerBed)) {
                flowerBed.addFlower(flower);
            }
        }
        selectedItem = null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
