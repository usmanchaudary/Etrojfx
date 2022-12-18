package com.example.etrojfx.HelperFunctions;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Helpers {
    public Parent GetScene(ActionEvent event, Button btn, String MarkupName) throws IOException {
        Stage stage = (Stage) btn.getScene().getWindow();
        return FXMLLoader.load(getClass().getResource(MarkupName));
    }
}
