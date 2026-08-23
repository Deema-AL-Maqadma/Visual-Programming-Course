package javafx.lec1;

import javafx.application.Application; //1
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class lec1 extends Application { //2

    public static void main(String[] args) {
        launch(args); //4(life sycle JavaFX) lunch->init->start->stop

    }

    @Override //3 لازم اعمل implementation للميثود start لانها abstract method
    public void start(Stage stage) {// object from Stage class هي الاساسية
        Button btn = new Button(); //object (ui control)
        btn.setText("DEEMA AL-MAQADMA");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello Deema ^_^");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn); // للاضافة داخل pane بستخدم هاي الميثود
        /*
        Button btn2 = new Button(); //object (ui control)
        root.getChildren().addAll(btn, btn2);
         */
        Scene s = new Scene(root, 720, 410);
        stage.setScene(s);
        stage.setTitle("Visual Programming");
        stage.show();//ضرورية حتى تظهر الواجهة

    }

}
