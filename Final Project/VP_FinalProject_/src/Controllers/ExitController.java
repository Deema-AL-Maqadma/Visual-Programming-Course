//===========================================================================================================
/** My Name : Deema Mohammed AL-Maqadma
 * ID : 2320230766
 * Final Project : Library Management System
 * Presented to : Eng. Mahmoud Ashour
 *   --->>> GO A HERO !!!
 */
//===========================================================================================================
package Controllers;

import VP_FinalProject.VP_FinalProject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
//===========================================================================================================

public class ExitController implements Initializable {

    @FXML
    private Button btn_exit;
    @FXML
    private AnchorPane exit_css;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
//===========================================================================================================

    @FXML
    private void exitProgram(ActionEvent event) {
        Dialog d = new Dialog();
        d.setTitle(VP_FinalProject.title);
        d.setHeaderText("Exitting The Program");
        d.setContentText("Are you sure to exit the Library ?");
        ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType btnNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        d.getDialogPane().getButtonTypes().addAll(btnYes, btnNo);
        if (d.showAndWait().get() == btnYes) {
            Platform.exit();

        }
    }

}
//===========================================================================================================
// My Name : Deema Mohammed AL-Maqadma
// ID : 2320230766
