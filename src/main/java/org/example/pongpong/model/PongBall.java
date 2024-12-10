package org.example.pongpong.model;

public class PongBall extends Ball {
    private String color;
    private int xCoordinate;
    private int yCoordinate;
    private int xVelocity;
    private int yVelocity;
    private double pongBallRadius;



    PongBall(String color, int xCoordinate, int yCoordinate, int xVelocity, int yVelocity, double pongBallRadius) {
        super(xCoordinate, yCoordinate, pongBallRadius);
        this.color = color;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;

    }
    @Override
    public void move(int x, int y) {

        var newX = this.getCoordinateX() + xVelocity;
        this.setCoordinateX(newX);

        var newY = this.getCoordinateY() + yVelocity;
        this.setCoordinateY(newY);

        // Kontrollerar kollision med kanter
        if (newY < 0 || newY > y){
            yVelocity *= -1;
        }

        if (newX < 0 || newX > x){
            // Förhindra studs på vänster och höger kant
            xVelocity = 0;
            yVelocity = 0;
        }
        setCoordinateX(newX);
        setCoordinateY(newY);
    }

}
