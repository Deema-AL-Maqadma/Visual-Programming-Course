//===========================================================================================================
/** My Name : Deema Mohammed AL-Maqadma
 * ID : 2320230766
 * Final Project : Library Management System
 * Presented to : Eng. Mahmoud Ashour
 *   --->>> GO A HERO !!!
 */
//===========================================================================================================
package Controllers;

import Database.JDBC;
import Models.SecurityUtil;
import Models.User;
import VP_FinalProject.VP_FinalProject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//===========================================================================================================

public class Sign_inController implements Initializable {

    @FXML
    private Button signUp_btn;
    @FXML
    private PasswordField password;
    @FXML
    private Button login_btn;
    @FXML
    private TextField username;
    @FXML
    private CheckBox checkbox_rememberMe;
    @FXML
    private Hyperlink hyperlink_forgetPassword;

    private JDBC jdbc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jdbc = new JDBC();
    }
//===========================================================================================================
    // Message for the user

    private void showDialog(String message) {
        Dialog d = new Dialog();
        d.setTitle(VP_FinalProject.title);
        d.setHeaderText("Warning!");
        d.setContentText(message);
        ButtonType btnOk = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().addAll(btnOk);
        d.showAndWait();
    }
//===========================================================================================================

    @FXML
    private void goToSignUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views_FXML/sign_up.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
//===========================================================================================================

    @FXML
    private void goToChangePassword(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views_FXML/change_password.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
//===========================================================================================================

    private void goToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views_FXML/main.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
//===========================================================================================================

    private void goToUserMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views_FXML/user_main.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
//===========================================================================================================
    // Save The user In USERS Table in Database if sellected rememberMe

    @FXML
    private void saveUser(ActionEvent event) {
        String username = this.username.getText();
        String password = this.password.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showDialog("Username and Password are required!");
            return;
        }
        try {
            User user = new User(username, password);
            jdbc.saveUser(user);
            this.showDialog("User Saved Successfully! ,You can continue");
        } catch (Exception e) {
            showDialog("Error saving user: " + e.getMessage());
        }

    }
//===========================================================================================================

    @FXML
    private void Login(ActionEvent event) throws IOException {
        String username = this.username.getText();
        String password = this.password.getText();
        boolean remember = this.checkbox_rememberMe.isSelected();

        if (username.isEmpty() || password.isEmpty()) {
            this.showDialog("Please Enter Valid Username & Password");
            return;
        }
        if (username.equals("admin") && password.equals("admin")) {
            this.goToMain(event);
            return;
        }
        if (jdbc.checkPassword(username, password)) {
            showDialog("Login successful!");
            this.goToUserMain(event);
        } else {
            showDialog("Invalid username or password.");

        }
        if (remember) {
            this.saveUser(event);
        }

    }

}
//===========================================================================================================
// My Name : Deema Mohammed AL-Maqadma
// ID : 2320230766
