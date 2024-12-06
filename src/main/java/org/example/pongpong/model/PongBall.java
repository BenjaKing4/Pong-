package org.example.pongpong.model;

public class PongBall extends Ball {
    private String color;
    private int xCoordinate;
    private int yCoordinate;
    private double pongBallRadius;



    PongBall(String color, int xCoordinate, int yCoordinate, double pongBallRadius) {
        super(xCoordinate, yCoordinate, pongBallRadius);
        this.color = color;

    }
    @Override
    public void move(int x, int y) {

        var newX = this.getCoordinateX() + x;
        this.setCoordinateX(newX);

        var newY = this.getCoordinateY() + y;
        this.setCoordinateY(newY);
    }

}
