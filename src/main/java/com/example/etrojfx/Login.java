package com.example.etrojfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.PrivateKey;

public class Login {
    public TextField tfName;
    public PasswordField pass;
    public Button Login;
    public Button CreateNowBtn;
    private Stage stage;
    @FXML
    protected void loginBtnAction(ActionEvent event) throws IOException {
        String userName = tfName.getText();
        String Password = pass.getText();

        System.out.println("login button "+userName +" "+Password);

        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("Home.fxml"));
        stage = (Stage) Login.getScene().getWindow();

        Scene scene = new Scene(fxmlLoader.load());
        //stage.setTitle("ETRO Clothing");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void CreateNowBtn(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("Register.fxml"));
        stage = (Stage) CreateNowBtn.getScene().getWindow();

        Scene scene = new Scene(fxmlLoader.load());
        //stage.setTitle("ETRO Clothing");
        stage.setScene(scene);
        stage.show();

       //welcomeText.setText("Welcome to JavaFX Application!");
    }
}
