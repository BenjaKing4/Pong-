package org.example.pongpong.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Player {
    private IntegerProperty healthProperty;

    private int coordinatesX;
    private int coordinatesY;
    private int width;
    private int height;

    public Player(int coordinatesX, int coordinatesY, int width, int height, int health) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.width = width;
        this.height = height;
        this.healthProperty = new SimpleIntegerProperty(health);  // Initialize health property
    }

    public abstract void move(int x, int y);

    public IntegerProperty getHealthProperty() {
        return healthProperty; // Return health property
    }

    public int getHealth() {
        return healthProperty.get();  // Get the current health value
    }

    public void setHealth(int health) {
        healthProperty.set(health);  // Set the health value
    }

    // Getter and Setter for coordinates and size
    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
