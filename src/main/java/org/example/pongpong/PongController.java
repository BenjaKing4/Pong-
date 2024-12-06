package org.example.pongpong;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PongController {
    public Label topLabel;
    public Label bottomLabel;
    public Label centerLabel;
    public Label leftLabel;
    public Label rightLabel;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}