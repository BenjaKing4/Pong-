package org.example.pongpong.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PongPlayer extends Player {

    public static final int FIELD_WIDTH = 800;
    public static final int FIELD_HEIGHT = 600;

    public PongPlayer(int coordinatesX, int coordinatesY, int width, int height, int health) {
        super(coordinatesX, coordinatesY, width, height, health, 0);  // Default score as 0

    }

    @Override
    public void move(int x, int y) {
        int newCoordinatesY = getCoordinatesY() + y;

        if (newCoordinatesY < 0) newCoordinatesY = 0;
        if (newCoordinatesY + getHeight() > FIELD_HEIGHT) newCoordinatesY = FIELD_HEIGHT - getHeight();

        setCoordinatesY(newCoordinatesY);
    }

    @Override
    public String toString() {
        return "PongPlayer{" +
                "coordinatesX=" + getCoordinatesX() +
                ", coordinatesY=" + getCoordinatesY() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", health=" + getHealth() +
                '}';
    }


    // Getter for healthProperty
    public IntegerProperty getHealthProperty() {
        return new SimpleIntegerProperty(getHealth());
    }
}
