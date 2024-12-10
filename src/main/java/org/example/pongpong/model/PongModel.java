package org.example.pongpong.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class PongModel {

    private int scoreP1 = 0;
    private int scoreP2 = 0;

    private StringProperty p1Score = new SimpleStringProperty("Score: 0");
    private StringProperty p2Score = new SimpleStringProperty("Score: 0");
    private StringProperty playPauseButton = new SimpleStringProperty("Start");
    private GameState gameState = GameState.PAUSE;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }



    public String getPlayPauseButton() {
        return playPauseButton.get();
    }

    public StringProperty playPauseButtonProperty() {
        return playPauseButton;
    }

    public void setPlayPauseButton(String playPauseButton) {
        this.playPauseButton.set(playPauseButton);
    }


    public String getP1Score() {
        return p1Score.get();
    }

    public StringProperty p1ScoreProperty() {
        return p1Score;
    }

    public void setP1Score(String p1Score) {
        this.p1Score.set(p1Score);
    }

    public String getP2Score() {
        return p2Score.get();
    }

    public StringProperty p2ScoreProperty() {
        return p2Score;
    }

    public void setP2Score(String p2Score) {
        this.p2Score.set(p2Score);
    }

    public void enableDisablePlayPauseButton(){
        switch(playPauseButton.get()){
            case "Start" -> {
                playPauseButton.set("Pause");
                setGameState(GameState.IN_PROGRESS);
                // Replace with spawn pongball
                System.out.println("Ball Created");

            }
            case "Pause" -> {
                playPauseButton.set("Play");
                setGameState(GameState.PAUSE);
            }
            case "Play" -> {
                playPauseButton.set("Pause");
                setGameState(GameState.IN_PROGRESS);
            }
        }

    }

    public void setGameRest() {
        setGameState(GameState.RESET);
        playPauseButton.set("Start");
        System.out.println("Game Rest Method");
    }

    public void exitGame() {
        System.out.println("Exit Game");
        System.exit(0);
    }
}