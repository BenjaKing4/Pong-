package org.example.pongpong.model;

public abstract class Player implements Movable {
    private int coordinatesX;
    private int coordinatesY;
    private int width;
    private int height;
    private int health;

    Player(int coordinatesX, int coordinatesY, int width, int height, int health) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.width = width;
        this.height = height;
        this.health = health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

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