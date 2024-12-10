package org.example.pongpong.model;

public class PongPlayer extends Player {

    public static final int FIELD_WIDTH = 800;
    public static final int FIELD_HEIGHT = 600;

    public PongPlayer(int coordinatesX, int coordinatesY, int width, int height, int health) {
        super(coordinatesX, coordinatesY, width, height, health);
    }

    @Override
    public void move(int x, int y) {
        // Ignore x-axis movement
        int newCoordinatesY = getCoordinatesY() + y;

        // Ensure the player stays within the field on the y-axis
        if (newCoordinatesY < 0) newCoordinatesY = 0;
        if (newCoordinatesY + getHeight() > FIELD_HEIGHT) newCoordinatesY = FIELD_HEIGHT - getHeight();

        // Update only the y-coordinate
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
}