
package javafx.lec8;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fxml_test extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception  {
        Parent root = FXMLLoader.load(getClass().getResource("FirstSB.fxml"));
        
        Scene s = new Scene(root);
        stage.setScene(s);
        stage.show();
    }
    
}
