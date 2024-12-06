package org.example.pongpong.model;

abstract class Ball implements Movable {
    private int coordinateX;
    private int coordinateY;
    private double radius;

    Ball(int coordinateX, int coordinateY, double radius) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.radius = radius;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    boolean checkCollision(Ball ball, Player player) {
        double closestX = Math.max(player.getCoordinatesX(), Math.min(ball.coordinateX, player.getCoordinatesX() + player.getWidth()));
        double closestY = Math.max(player.getCoordinatesY(), Math.min(ball.coordinateY, player.getCoordinatesY() + player.getHeight()));

        double distanceX = ball.coordinateX - closestX;
        double distanceY = ball.coordinateY - closestY;

        return (distanceX * distanceX + distanceY * distanceY) < (ball.radius * ball.radius);
    }

}
