package org.example.pongpong;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.pongpong.model.PongModel;

public class PongController {
    public Label topLabel;
    public Label bottomLabel;
    public Label centerLabel;
    public Label leftLabel;
    public Label rightLabel;
    public Button playPause;
    private PongModel model= new PongModel();

    public PongModel getModel() {
        return model;
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void playPauseButtonClick() {
        model.enableDisablePlayPauseButton();

    }

}
