package org.example.pongpong.model;

public abstract class Game implements GameLogic {
    private final Player player1;
    private final Player player2;
    private int player1Score;  // Add score variable for player1
    private int player2Score;  // Add score variable for player2

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Score = 0; // Initialize score
        this.player2Score = 0; // Initialize score
    }

    @Override
    public boolean isPlayer1Winner() {
        return player2.getHealthProperty().get() <= 0; // Player 1 wins if Player 2's health is 0 or less
    }

    @Override
    public boolean isPlayer2Winner() {
        return player1.getHealthProperty().get() <= 0; // Player 2 wins if Player 1's health is 0 or less
    }


    @Override
    public boolean isDraw() {
        return player1.getHealthProperty().get() <= 0 && player2.getHealthProperty().get() <= 0;
    }


    @Override
    public GameState getCurrentGameState() {
        if (isDraw()) return GameState.DRAW;
        if (isPlayer1Winner()) return GameState.PLAYER1;
        if (isPlayer2Winner()) return GameState.PLAYER2;
        return GameState.WIN; // Default case: game in progress
    }

    // Update players' health using healthProperty
    public void updateHealth(int player1HealthLost, int player2HealthLost) {
        player1.getHealthProperty().set(player1.getHealth() - player1HealthLost); // Set new health for player1
        player2.getHealthProperty().set(player2.getHealth() - player2HealthLost); // Set new health for player2
    }


    // Generalized score retrieval
    public String getPlayerScore(Player player) {
        return "Health: " + player.getHealth();
    }

    // Expose players for UI bindings
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    // Changed methods to return String representation of score
    public String getPlayer1Score() {
        return "Player 1 Score: " + player1Score;
    }

    public String getPlayer2Score() {
        return "Player 2 Score: " + player2Score;
    }

    // Methods to increment scores
    public void incrementPlayer1Score() {
        player1Score++;
    }

    public void incrementPlayer2Score() {
        player2Score++;
    }
}
