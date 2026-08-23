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
import Models.User;
import VP_FinalProject.VP_FinalProject;
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
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
//===========================================================================================================

public class Sign_upController implements Initializable {

    @FXML
    private PasswordField password;
    @FXML
    private Button login_btn;
    @FXML
    private TextField username;
    @FXML
    private Hyperlink hyperlink_sigmIn;
    @FXML
    private TextField fullname;

    private JDBC jdbc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jdbc = new JDBC();
        //يتفاعل مع كل تغيير لحظي في النص
        username.textProperty().addListener((obs, oldText, newText) -> {
            if (newText.length() >= 3 && jdbc.isUsernameExists(newText)) {
                username.setStyle("-fx-border-color: red;"+"-fx-border-width: 5;");
                Tooltip tooltip = new Tooltip("Username already taken!");
                username.setTooltip(tooltip);
            } else {
                username.setStyle(null);
                username.setTooltip(null);
            }
        });
    }
//===========================================================================================================
    // Message for the user

    private void showDialog(String message) {
        Dialog d = new Dialog();
        d.setTitle(VP_FinalProject.title);
        d.setHeaderText("Notice!");
        d.setContentText(message);
        ButtonType btnOk = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().addAll(btnOk);
        d.showAndWait();
    }

//===========================================================================================================    
    private void saveUserToList(ActionEvent event) {
        String fullname = this.fullname.getText();
        String username = this.username.getText();
        String password = this.password.getText();

        if (fullname.isEmpty() || username.isEmpty() || password.isEmpty()) {
            showDialog("Fullname, Username and Password are required!");
            return;
        }
        try {
            User user = new User(fullname, username, password);
            jdbc.ListUsers(user);
            this.showDialog("User Added To List Users Successfully! ,You can continue");
        } catch (Exception e) {
            showDialog("Error List user: " + e.getMessage());
        }

    }
//===========================================================================================================

    @FXML
    private void goToSignIn(ActionEvent event) throws IOException {
        this.saveUserToList(event);
        Parent root = FXMLLoader.load(getClass().getResource("/Views_FXML/sign_in.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
//===========================================================================================================
// My Name : Deema Mohammed AL-Maqadma
// ID : 2320230766
