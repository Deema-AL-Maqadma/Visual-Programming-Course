
package Assignment2;

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


public class BMI extends Application{

    public static String title = "BMI";
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent rooot = FXMLLoader.load(getClass().getResource("Assignment.2.fxml"));
        
        Scene s = new Scene(rooot);
        
        s.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                Dialog d = new Dialog();
                d.setTitle("Exit Confirmation");
                d.setHeaderText(null);
                d.setContentText("Are You Sure You Want To Exit!");

                ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                ButtonType btnNo = new ButtonType("No", ButtonBar.ButtonData.NO);

                d.getDialogPane().getButtonTypes().addAll(btnYes, btnNo);

                if (d.showAndWait().get() == btnYes) {
                    Platform.exit();
                }
            }
        });
        
        stage.setScene(s);
        stage.setTitle(title);
        stage.show();
    }
}
