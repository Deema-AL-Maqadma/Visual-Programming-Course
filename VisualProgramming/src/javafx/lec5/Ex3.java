package javafx.lec5;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Ex3 extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) {
        // حاوية تضيفا العناصر في الشبكة حسب الاحداثيات
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);

        Label lbl = new Label("WELCOME!");
        lbl.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 18));
        Label lbl1 = new Label("UserName");
        Label lbl2 = new Label("Password");
        TextField tf = new TextField();
        TextField tf2 = new TextField();
        tf.setFocusTraversable(false);
        tf2.setFocusTraversable(false);
        Button btn = new Button("Login");
        btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 18));

        root.add(lbl, 0, 0); // للعنوان
        root.add(lbl1, 0, 1);// الاسم
        root.add(tf, 1, 1);// ادخال الاسم
        root.add(lbl2, 0, 2);// كلمة المرور
        root.add(tf2, 1, 2);// ادخال كلمة المرور
        root.add(btn, 2, 3);
        Scene s = new Scene(root, 500, 500);
        stage.setScene(s);
        stage.show();

    }

}
