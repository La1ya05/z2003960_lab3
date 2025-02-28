package Lavanya;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Flower implements iComposite {
    private Circle circle;
    private boolean movable;

    public Flower(Point2D position, Color color, boolean movable) {
        this.movable = movable;
        circle = new Circle();
        circle.setCenterX(position.getX());
        circle.setCenterY(position.getY());
        circle.setRadius(15);
        circle.setFill(color);
        circle.setStroke(Color.BLACK);
    }

    public Circle getCircle() {
        return circle;
    }

    @Override
    public void move(double dx, double dy) {
        if (movable) {
            circle.setCenterX(circle.getCenterX() + dx);
            circle.setCenterY(circle.getCenterY() + dy);
        }
    }

    @Override
    public boolean isInNode(iComposite gardenEntity) {
        if (gardenEntity instanceof FlowerBed) {
            FlowerBed bed = (FlowerBed) gardenEntity;
            return bed.getRectangle().contains(circle.getCenterX(), circle.getCenterY());
        }
        return false;
    }
}
