package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private loginMadel loginmodel = new loginMadel();
    @FXML
    private Label dbStatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnLogin;
    @FXML
    private Label loginStatus;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.loginmodel.isDatabaseConnection()){
            this.dbStatus.setText("Connected to BD.");
        }else {
            this.dbStatus.setText("Not Connect to DB.");
        }

    }//initialize
    @FXML
    public  void Login(ActionEvent event){
        try {
            if (this.loginmodel.isLogin(this.username.getText(),this.password.getText())){
                double stage = this.btnLogin.getScene().getWidth();
                stage.close();
                adminDashBoard();
            }else {
                loginStatus.setText("Your username or password is invalid.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void adminDashBoard() {
        JOptionPane.showMessageDialog(null,
                "welcome to our System.");

    }
}//class