//===========================================================================================================
/** My Name : Deema Mohammed AL-Maqadma
 * ID : 2320230766
 * Assignment2 : Body Mass Index
 * Presented to : Eng. Mahmoud Ashour
 *   --->>> GO A HERO !!!
 */
//===========================================================================================================
package vp_assignment2;

import java.io.IOException;
import java.util.Locale;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class VP_Assignment2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Locale.setDefault(new Locale("en", "US"));// لاظهار القيم العددية بالانجلش
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("BMI_Ass2.fxml"));
            Scene s = new Scene(root);

            // Action on Scene when pressed ESCAPE
            s.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.ESCAPE) {
                    Dialog d = new Dialog();
                    d.setTitle("---> Body Mass Index");
                    d.setHeaderText("Exit?");
                    d.setContentText("Are you sure to exit?");

                    ButtonType yes_btn = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                    ButtonType no_btn = new ButtonType("No", ButtonBar.ButtonData.NO);

                    d.getDialogPane().getButtonTypes().addAll(no_btn, yes_btn);
                    // validation
                    if (d.showAndWait().get() == yes_btn) {
                        stage.close();
                    }
                }
            });
            stage.setScene(s);
            stage.setTitle("---> Body Mass Index");
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
// My Name : Deema Mohammed AL-Maqadma
// ID : 2320230766
