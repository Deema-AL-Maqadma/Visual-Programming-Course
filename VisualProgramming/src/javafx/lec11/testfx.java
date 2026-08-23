package javafx.lec11;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testfx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override

    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Lec12.fxml"));
            Scene s = new Scene(root);
            stage.setScene(s);
            stage.setTitle("---> Student");
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }

    }
}
