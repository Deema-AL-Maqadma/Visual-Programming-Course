package javafx.lec7;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Lec7p2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label lbl = new Label("Slider");

        Slider slider = new Slider(0,100,50);//خط قيم متحرك
        //slider.setMin(0);// لتحديد البداية
        //slider.setMax(100);// لتحدبد النهاية
        //slider.setValue(50);// القيمة يلي يكون عندها
        slider.setShowTickLabels(true);// لاظهار القيم
        slider.setShowTickMarks(true);// لاظهار الاشارات
        slider.setOrientation(Orientation.VERTICAL);//لجعله يظهر بشكل طولي 
        
        VBox root = new VBox(25,lbl, slider);
        Scene s = new Scene(root, 500, 500);
        stage.setScene(s);
        stage.show();
    }

}
