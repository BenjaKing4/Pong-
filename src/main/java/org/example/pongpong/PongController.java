package org.example.pongpong;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import org.example.pongpong.model.*;
import javafx.scene.input.MouseEvent;
import org.example.pongpong.model.PongModel;
import org.example.pongpong.model.Game;
import org.example.pongpong.model.Player;
import org.example.pongpong.model.PongPlayer;

public class PongController {
    public Label topLabel;
    public Label bottomLabel;
    public Label centerLabel;
    public Label leftLabel;
    public Label rightLabel;
    public Button playPause;
    public Button restButton;
    private PongModel model= new PongModel();

    @FXML
    private Label player1HealthLabel;  // Use JavaFX Label
    @FXML
    private Rectangle player1Paddle = new Rectangle();

    private PongPlayer player1;
    private PongPlayer player2;
    private Game game;

    public PongModel getModel() {
        return model;
    }

    public void playPauseButtonClick() {
        model.enableDisablePlayPauseButton();
    }

    // Method to set the game instance
    public void setGame(Game game) {
        this.game = game;
    }

    // Update UI elements based on the current game state
    public void updateUI() {
        topLabel.setText("Player 1 Score: " + game.getPlayer1Score());
        bottomLabel.setText("Player 2 Score: " + game.getPlayer2Score());
        leftLabel.setText("Player 1 Lives: " + game.getPlayer1().getHealth());
        rightLabel.setText("Player 2 Lives: " + game.getPlayer2().getHealth());

        if (game.isPlayer1Winner()) {
            centerLabel.setText("Player 1 Wins!");
        } else if (game.isPlayer2Winner()) {
            centerLabel.setText("Player 2 Wins!");
        } else if (game.isDraw()) {
            centerLabel.setText("It's a Draw!");
        } else {
            centerLabel.setText("Game in Progress...");
        }
    }

    public void initialize() {
        // Initialize player1 and player2 as PongPlayer
        player1 = new PongPlayer(50, 100, 10, 100, 3);
        player2 = new PongPlayer(100, 100, 10, 100, 3);

        // Initialize the game instance with the players
        setGame(new Game(player1, player2) {
            @Override
            public boolean isWinningCondition(Player player1, Player player2) {
                return false;
            }

            @Override
            public boolean isDrawCondition(Player player1, Player player2) {
                return false;
            }

            @Override
            public GameState checkGameState(Player player1, Player player2) {
                return null;
            }
        });

        // Bind health and paddle position
        player1HealthLabel.textProperty().bind(player1.getHealthProperty().asString("Health: %d"));
        player1Paddle.xProperty().bind(player1.coordinatesXProperty());
        player1Paddle.yProperty().bind(player1.coordinatesYProperty());

        System.out.println(player1.coordinatesXProperty().get());

        System.out.println("Game initialized!");
        System.out.println(game.getPlayer1Score());
        System.out.println(game.getPlayer2Score());
    }

    public void restButtonClick() {
        model.setGameRest();
    }
}
