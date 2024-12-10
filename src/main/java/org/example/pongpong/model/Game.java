package org.example.pongpong.model;

public class Game implements GameLogic {
    private final Player player1;
    private final Player player2;

    // Constructor to accept two player instances
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean isPlayer1Winner() {
        return player2.getHealth() <= 0; // Player 1 wins if Player 2's health is 0 or less
    }

    @Override
    public boolean isPlayer2Winner() {
        return player1.getHealth() <= 0; // Player 2 wins if Player 1's health is 0 or less
    }

    @Override
    public boolean isDraw() {
        return player1.getHealth() <= 0 && player2.getHealth() <= 0; // Both lose health at the same time
    }

    @Override
    public boolean isWinningCondition(Player player1, Player player2) {
        return player1.getHealth() > 0 && player2.getHealth() <= 0;
    }

    @Override
    public boolean isDrawCondition(Player player1, Player player2) {
        return player1.getHealth() <= 0 && player2.getHealth() <= 0;
    }

    @Override
    public GameState checkGameState(Player player1, Player player2) {
        if (isDrawCondition(player1, player2)) {
            return GameState.DRAW;
        } else if (player1.getHealth() > 0 && player2.getHealth() <= 0) {
            return GameState.PLAYER1;
        } else if (player2.getHealth() > 0 && player1.getHealth() <= 0) {
            return GameState.PLAYER2;
        }
        return GameState.WIN; // Default state (in progress)
    }

    // Method to update players' health
    public void updateHealth(int player1HealthLost, int player2HealthLost) {
        player1.setHealth(player1.getHealth() - player1HealthLost);
        player2.setHealth(player2.getHealth() - player2HealthLost);
    }

    // Method to get the current game state
    public GameState getCurrentGameState() {
        if (isDraw()) {
            return GameState.DRAW;
        } else if (isPlayer1Winner()) {
            return GameState.PLAYER1;
        } else if (isPlayer2Winner()) {
            return GameState.PLAYER2;
        }
        return GameState.WIN; // Default case (game in progress)
    }

    // Returns Player 1's current health as a score
    public String getPlayer1Score() {
        return "Player 1 Health: " + player1.getHealth();
    }

    // Returns Player 2's current health as a score
    public String getPlayer2Score() {
        return "Player 2 Health: " + player2.getHealth();
    }

    // Get Player 1 instance
    public Player getPlayer1() {
        return player1;
    }

    // Get Player 2 instance
    public Player getPlayer2() {
        return player2;
    }
}
