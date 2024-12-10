package org.example.pongpong.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Player {
    private IntegerProperty healthProperty;
    private IntegerProperty scoreProperty;  // Add a score property

    private int coordinatesX;
    private int coordinatesY;
    private int width;
    private int height;

    public Player(int coordinatesX, int coordinatesY, int width, int height, int health, int score) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.width = width;
        this.height = height;
        this.healthProperty = new SimpleIntegerProperty(health);  // Initialize health property
        this.scoreProperty = new SimpleIntegerProperty(score);  // Initialize score property
    }

    public abstract void move(int x, int y);

    // Getter and Setter for health
    public IntegerProperty getHealthProperty() {
        return healthProperty;
    }

    public int getHealth() {
        return healthProperty.get();
    }

    public void setHealth(int health) {
        healthProperty.set(health);
    }

    // Getter and Setter for score
    public IntegerProperty getScoreProperty() {
        return scoreProperty;
    }

    public int getScore() {
        return scoreProperty.get();
    }

    public void setScore(int score) {
        scoreProperty.set(score);
    }

    // Method to increase score
    public void increaseScore() {
        scoreProperty.set(scoreProperty.get() + 1);  // Increment score by 1
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
