package javafx.lec10;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fxml_test extends Application {

    public static String title = "القبول والتسجيل";

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Project2_القبول والتسجيل.fxml"));;
            Scene s = new Scene(root);
            stage.setScene(s);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }

    }

}
