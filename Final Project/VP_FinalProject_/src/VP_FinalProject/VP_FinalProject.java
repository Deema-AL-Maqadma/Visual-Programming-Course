//===========================================================================================================
/** My Name : Deema Mohammed AL-Maqadma
 * ID : 2320230766
 * Final Project : Library Management System
 * Presented to : Eng. Mahmoud Ashour
 *   --->>> GO A HERO !!!
 * YouTube Video : https://youtu.be/HJiMvpnaI3A?si=FJ1-URD8MvU3FEOQ
مناقشة Final Project 
Library Management System 
ديمه محمدأحمد المقادمه
 */
//===========================================================================================================
package VP_FinalProject;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
//===========================================================================================================

public class VP_FinalProject extends Application {

    public static String title = "Library Management System";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Views_FXML/sign_in.fxml"));
            Scene s = new Scene(root);
            stage.setScene(s);
            stage.setTitle("---> Final Project");
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
//===========================================================================================================
// My Name : Deema Mohammed AL-Maqadma
// ID : 2320230766
