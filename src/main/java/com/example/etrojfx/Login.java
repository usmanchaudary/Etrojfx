package com.example.etrojfx;

import com.example.etrojfx.Globals.Global;
import com.example.etrojfx.HelperFunctions.Helpers;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.ArrayList;

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
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(Global.DirectoryPath + "DataFiles\\Users.txt"));
            String line = reader.readLine();
            boolean flag = false;
            while (line != null) {
                String[] users = line.split(" ");
                if(userName.equals(users[1]) && Password.equals(users[2])){
                    flag = true;
                }
                line = reader.readLine();
            }
            if(!flag){
                Helpers.showAlert("username or password is incorrect! ");
                return;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
