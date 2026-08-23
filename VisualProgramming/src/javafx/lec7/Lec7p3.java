package javafx.lec7;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;//لاستيراد جميع المطلوب بشكل اسرع
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Lec7p3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Label lbl = new Label("ComboBox");
//        lbl.setStyle("-fx-font-size:25px;");//قبل التعليمة بكتب -fx-;
//        lbl.setId("lbl");//كرقم الهوية مخصص له بحيث اقدر اعطيه خصائص خاصة فيه
//        lbl.getStyleClass().add("red");//لاعطاء خصائص عامة لاكثر من واحد

        Label lbl2 = new Label("ComboBox2");
//        lbl2.setStyle("-fx-font-size:25px;");//قبل التعليمة بكتب -fx-;
//        lbl2.setId("lbl2");//كرقم الهوية مخصص له بحيث اقدر اعطيه خصائص خاصة فيه
//        lbl2.getStyleClass().add("red");//لاعطاء خصائص عامة لاكثر من واحد

        Button btn = new Button("Login");
//        btn.getStyleClass().add("red");//لاعطاء خصائص عامة لاكثر من واحد

//        btn.setStyle("-fx-font-weight:bold;" // لتغميق الخط
//        +"-fx-font-size:32px;");// لتكبير حجم الخط



        VBox root = new VBox(25, lbl,btn,lbl2);
        root.setPadding(new Insets(20));
        Scene s = new Scene(root, 500, 500);
        s.getStylesheets().add("/styles/style.css");//عرفت المشروع على الستايل عندي
        stage.setScene(s);
        stage.show();
    }

}
