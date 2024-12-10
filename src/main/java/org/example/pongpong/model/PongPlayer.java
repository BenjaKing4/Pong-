package org.example.pongpong.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PongPlayer extends Player {

    public static final int FIELD_WIDTH = 800;
    public static final int FIELD_HEIGHT = 600;

    private IntegerProperty coordinatesX;

    @Override
    public int getCoordinatesY() {
        return coordinatesY.get();
    }

    public IntegerProperty coordinatesYProperty() {
        return coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY.set(coordinatesY);
    }

    private IntegerProperty coordinatesY;


    @Override
    public int getCoordinatesX() {
        return coordinatesX.get();
    }

    public IntegerProperty coordinatesXProperty() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX.set(coordinatesX);
    }

    public PongPlayer(int coordinatesX, int coordinatesY, int width, int height, int health) {
        super(coordinatesX, coordinatesY, width, height, health, 0);  // Default score as 0
        this.coordinatesX = new SimpleIntegerProperty(coordinatesX);
        this.coordinatesY = new SimpleIntegerProperty(coordinatesY);
    }
    // Getter for coordinatesXProperty
    //public IntegerProperty coordinatesXProperty() {
      //  return new SimpleIntegerProperty(getCoordinatesX());
    //}

    // Getter for coordinatesYProperty
    // public IntegerProperty coordinatesYProperty() {
      //  return new SimpleIntegerProperty(getCoordinatesY());
    //}

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
