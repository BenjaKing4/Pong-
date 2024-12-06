package org.example.pongpong;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PongController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}