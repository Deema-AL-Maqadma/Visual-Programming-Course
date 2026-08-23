package javafx.lec5;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Ex2 extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) {
        // حاوية تضيف حسب الابعاد الخمسة يمين يسار قاعدة قمة مركز
        BorderPane root = new BorderPane();
        
        VBox left = new VBox(25);
        for (int i = 1; i <= 5; i++) {
            Button btn = new Button("Button " + i);
            left.getChildren().add(btn);
        }
        
        VBox right = new VBox(25);
        for (int i = 6; i <= 10; i++) {
            Button btn = new Button("Button " + i);
            right.getChildren().add(btn);
        }
        TextField tf = new TextField();
        TextField tf2 = new TextField();
        Label lbl = new Label("JavaFX");
        lbl.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 26));

        root.setLeft(left);
        root.setRight(right);
        root.setBottom(tf);
        root.setTop(tf2);
        root.setCenter(lbl);

        Scene s = new Scene(root, 500, 500);
        stage.setScene(s);
        stage.show();

    }

}
