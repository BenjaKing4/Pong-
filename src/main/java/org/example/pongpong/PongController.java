package org.example.pongpong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.example.pongpong.model.*;

import javafx.event.ActionEvent;

public class PongController {

    private PongPlayer player1;
    private PongPlayer player2;
    @FXML
    private Rectangle player1Paddle;
    @FXML
    private Rectangle player2Paddle;
    private Circle ball;  // The ball for the game

    private boolean movingUp1 = false;
    private boolean movingDown1 = false;
    private boolean movingUp2 = false;
    private boolean movingDown2 = false;
    private double paddleSpeed = 5.0;

    private Timeline movementTimeline;
    private Timeline ballMovementTimeline;

    @FXML
    private Label topLabel;
    @FXML
    private Label bottomLabel;
    @FXML
    private Label leftLabel;
    @FXML
    private Label rightLabel;
    @FXML
    private Label centerLabel;
    @FXML
    private Label player2HealthLabel;

    private Game game;
    private PongModel model;

    public PongModel getModel() {
        return model;
    }

    public PongController() {
        this.model = new PongModel();
        this.game = new PongGame(player1, player2);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void updateUI() {
        // Update UI components for player scores, health, and game status
        topLabel.setText("Player 1 Score: " + game.getPlayer1Score());
        bottomLabel.setText("Player 2 Score: " + game.getPlayer2Score());
        leftLabel.setText("Player 1 Lives: " + game.getPlayer1().getHealth());
        rightLabel.setText("Player 2 Lives: " + game.getPlayer2().getHealth());

        // Check for game status and display appropriate messages
        if (game.isPlayer1Winner()) {
            centerLabel.setText("Player 1 Wins!");
        } else if (game.isPlayer2Winner()) {
            centerLabel.setText("Player 2 Wins!");
        } else if (game.isDraw()) {
            centerLabel.setText("It's a Draw!");
        } else {
            centerLabel.setText("Game in Progress...");
        }

        if (player2HealthLabel != null) {
            player2HealthLabel.setText("Player 2 Health: " + game.getPlayer2().getHealth());
        }
    }

    @FXML
    public void initialize() {
        // Initialize player1 and player2
        player1 = new PongPlayer(50, 100, 10, 100, 3);
        player2 = new PongPlayer(700, 100, 10, 100, 3);

        // Initialize paddles and ball
        player1Paddle = new Rectangle(50, 100, 10, 100);  // Example size
        player2Paddle = new Rectangle(700, 100, 10, 100); // Example size
        ball = new Circle(15); // Ball with radius of 15

        // Set initial ball position
        ball.setCenterX(375);
        ball.setCenterY(200);

        // Bind paddle's movement to the player's coordinates
        player1Paddle.xProperty().bind(player1.coordinatesXProperty());
        player1Paddle.yProperty().bind(player1.coordinatesYProperty());

        player2Paddle.xProperty().bind(player2.coordinatesXProperty());
        player2Paddle.yProperty().bind(player2.coordinatesYProperty());

        // Request focus on the scene
        player1Paddle.requestFocus();  // Request focus on player1 paddle or any node

        // Set up key event listeners for player 1 and player 2
        player1Paddle.setOnMouseClicked(event -> {
            if (player1Paddle.getScene() != null) {
                player1Paddle.getScene().setOnKeyPressed(this::handleKeyPressPlayer1);
                player1Paddle.getScene().setOnKeyReleased(this::handleKeyReleasePlayer1);
            }
        });

        player2Paddle.setOnMouseClicked(event -> {
            if (player2Paddle.getScene() != null) {
                player2Paddle.getScene().setOnKeyPressed(this::handleKeyPressPlayer2);
                player2Paddle.getScene().setOnKeyReleased(this::handleKeyReleasePlayer2);
            }
        });

        // Set up a Timeline to move the paddles
        movementTimeline = new Timeline(new KeyFrame(Duration.millis(10), this::updatePaddlePosition));
        movementTimeline.setCycleCount(Timeline.INDEFINITE);  // Infinite loop
        movementTimeline.play();
    }

    private void handleKeyPressPlayer1(KeyEvent event) {
        System.out.println("Key pressed for Player 1: " + event.getCode()); // Debugging line
        switch (event.getCode()) {
            case W:
                movingUp1 = true;
                break;
            case S:
                movingDown1 = true;
                break;
        }
    }

    // Handle key release events for player 1 (W and S keys)
    private void handleKeyReleasePlayer1(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                movingUp1 = false;
                break;
            case S:
                movingDown1 = false;
                break;
        }
    }

    private void handleKeyPressPlayer2(KeyEvent event) {
        System.out.println("Key pressed for Player 2: " + event.getCode()); // Debugging line
        switch (event.getCode()) {
            case UP:
                movingUp2 = true;
                break;
            case DOWN:
                movingDown2 = true;
                break;
        }
    }

    // Handle key release events for player 2 (Up and Down arrow keys)
    private void handleKeyReleasePlayer2(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                movingUp2 = false;
                break;
            case DOWN:
                movingDown2 = false;
                break;
        }
    }

    // Update paddle positions for both players
    private void updatePaddlePosition(ActionEvent event) {
        movePaddle(player1Paddle, movingUp1, movingDown1);
        movePaddle(player2Paddle, movingUp2, movingDown2);
    }

    private void movePaddle(Rectangle paddle, boolean movingUp, boolean movingDown) {
        if (movingUp) {
            paddle.setY(paddle.getY() - paddleSpeed);
        }
        if (movingDown) {
            paddle.setY(paddle.getY() + paddleSpeed);
        }

        // Prevent paddles from going out of bounds (adjust as needed)
        double minY = 0;
        double maxY = 400; // Example maximum Y value
        if (paddle.getY() < minY) {
            paddle.setY(minY);
        } else if (paddle.getY() > maxY) {
            paddle.setY(maxY);
        }
    }

    public void restButtonClick() {
        model.setGameRest();
    }

    public void quitButtonClick() {
        model.exitGame();
    }

    public void playPauseButtonClick() {
        model.enableDisablePlayPauseButton();
    }
}
