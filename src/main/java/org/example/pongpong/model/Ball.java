package org.example.pongpong.model;

abstract class Ball implements Movable {
    private int coordinateX;
    private int coordinateY;
    private double radius;

    boolean checkCollision(Ball ball, Player player) {
        double closestX = Math.max(player.getCoordinatesX(), Math.min(ball.coordinateX, player.getCoordinatesX() + player.getWidth()));
        double closestY = Math.max(player.getCoordinatesY(), Math.min(ball.coordinateY, player.getCoordinatesY() + player.getHeight()));

        double distanceX = ball.coordinateX - closestX;
        double distanceY = ball.coordinateY - closestY;

        return (distanceX * distanceX + distanceY * distanceY) < (ball.radius * ball.radius);
    }

}
