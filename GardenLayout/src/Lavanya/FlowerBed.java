package Lavanya;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class FlowerBed implements iComposite {
    private Rectangle my_rectangle;
    private List<iComposite> children;
    public FlowerBed(double x, double y, double width, double height) {
        my_rectangle = new Rectangle(x, y, width, height);
        my_rectangle.setFill(Color.BROWN);
        my_rectangle.setStroke(Color.BLACK);
        children = new ArrayList<>();
    }

public Rectangle getRectangle() {
        return my_rectangle;
    }

public void addFlower(iComposite flower) {
        children.add(flower);
    }

@Override
public void move(double dx, double dy) {
        my_rectangle.setX(my_rectangle.getX() + dx);
        my_rectangle.setY(my_rectangle.getY() + dy);
        for (iComposite child : children) {
            child.move(dx, dy);
        }
    }

@Override
public boolean isInNode(iComposite gardenEntity) {
        return false;
    }

public List<iComposite> getChildren() {
        return children;
    }
}
