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
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
//===========================================================================================================

public class Change_passwordController implements Initializable {

    @FXML
    private Button change_btn;
    @FXML
    private PasswordField new_password;
    @FXML
    private PasswordField confirm_password;
    @FXML
    private PasswordField current_password;

    private JDBC jdbc;
//===========================================================================================================

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jdbc = new JDBC();
    }
//===========================================================================================================
    // message for user

    private void showDialog(String message) {
        Dialog d = new Dialog();
        d.setTitle(VP_FinalProject.title);
        d.setHeaderText("Notice");
        d.setContentText(message);
        ButtonType btnOk = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().addAll(btnOk);
        d.showAndWait();
    }

//===========================================================================================================  
    private void goToSignIn(ActionEvent event) throws IOException {
        this.showDialog("Changed Successfully!");
        Parent root = FXMLLoader.load(getClass().getResource("/Views_FXML/sign_in.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
//===========================================================================================================

    @FXML
    private void changePassword(ActionEvent event) throws IOException {
        String currentPassword = current_password.getText();
        String newPassword = new_password.getText();
        String confirmPassword = confirm_password.getText();

        if (currentPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            showDialog("Please fill in all fields!");
            return;
        }
        String hashedCurrent = SecurityUtil.hashPassword(currentPassword);
        // البحث عن المستخدم في الجداول
        String username = jdbc.findUsernameByPassword(hashedCurrent);
        if (username == null) {
            showDialog("Current password not found!");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            showDialog("New password and confirmation do not match!");
            return;
        }
        String hashedNew = SecurityUtil.hashPassword(newPassword);
        boolean updatedList = jdbc.updatePasswordInTable("list_users", username, hashedNew);
        boolean updatedUsers = jdbc.updatePasswordInTable("users", username, hashedNew);

        if (updatedList || updatedUsers) {
            showDialog("Password changed successfully for user: " + username);
            current_password.clear();
            new_password.clear();
            confirm_password.clear();
            this.goToSignIn(event);
        } else {
            showDialog("Failed to update password.");
        }
    }
}

//===========================================================================================================
// My Name : Deema Mohammed AL-Maqadma
// ID : 2320230766
