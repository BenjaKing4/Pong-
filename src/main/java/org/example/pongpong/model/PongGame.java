package org.example.pongpong.model;

public class PongGame extends Game {
    public PongGame(Player player1, Player player2) {
        super(player1, player2); // Initialize the parent Game class with the players
    }

    @Override
    public boolean isWinningCondition(Player player1, Player player2) {
        // Define the winning condition for the game
        // For example, Player 1 wins if their score reaches 5 points
        if (player1.getScore() >= 5) {
            return true;  // Player 1 wins
        } else if (player2.getScore() >= 5) {
            return true;  // Player 2 wins
        }
        return false; // No winner yet
    }

    @Override
    public boolean isDrawCondition(Player player1, Player player2) {
        // Define the draw condition
        // For example, the game ends in a draw if both players have the same score at the end
        if (player1.getScore() == player2.getScore() && player1.getScore() >= 3) {
            return true;  // It's a draw
        }
        return false; // No draw
    }

    @Override
    public GameState checkGameState(Player player1, Player player2) {
        // Check the current state of the game
        if (isWinningCondition(player1, player2)) {
            if (isPlayer1Winner()) {
                return GameState.PLAYER1_WIN;  // Player 1 wins
            } else {
                return GameState.PLAYER2_WIN; // Player 2 wins
            }
        } else if (isDrawCondition(player1, player2)) {
            return GameState.DRAW; // It's a draw
        }
        return GameState.IN_PROGRESS; // Game is still ongoing
    }
}
