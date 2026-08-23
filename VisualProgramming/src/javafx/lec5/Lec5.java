package javafx.lec5;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Lec5 extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) {
        // حاوية تضيف صف وعمود حسب مساحة الواجهة
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        for (int i =1 ;i<=10;i++){
            Button btn = new Button("Button "+i);
            root.getChildren().add(btn);
        }
        Scene s = new Scene(root,400,250);
        stage.setScene(s);
        stage.show();

    }

}
