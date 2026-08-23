package javafx.lec6;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Lec6P2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle c = new Circle(260, 290, 200, Color.RED);
        c.setStroke(Color.BLACK); // لوضع اطار للشكل
        c.setStrokeWidth(6);//لتخميل الشكل

        // ==================  1  =======================
        FillTransition ft = new FillTransition(Duration.seconds(2), c, Color.CORAL, Color.BLUE);
        ft.setShape(c);//الشكل يلي هعملو انميشن
        ft.setFromValue(Color.CORAL);//الون المتغير من
        ft.setToValue(Color.BLUE);//الى
        ft.setDuration(Duration.seconds(2));//الوقت للتغيير
        ft.setCycleCount(-1);//ليستمر في التغير
        ft.setAutoReverse(true);//للتحول بشكل انسيابي
        //ft.play();//لكي تنفذ

        //====================  2  =============================
        FadeTransition fd = new FadeTransition(Duration.seconds(2), c);
        fd.setNode(c);//الشكل يلي هعملو انميشن
        fd.setFromValue(1);//الون المتغير من ياخذ قيم عددية
        fd.setToValue(0);//الى
        fd.setDuration(Duration.seconds(2));//الوقت للتغيير
        fd.setCycleCount(-1);//ليستمر في التغير
        fd.setAutoReverse(true);//للتحول بشكل انسيابي
        fd.setDelay(Duration.seconds(3));//ليبدا التنفيذ يعد ثلاث ثواني
        fd.play();//لكي تنفذ

        Group root = new Group(c);
        Scene s = new Scene(root, 500, 500);
        stage.setScene(s);
        stage.show();
    }

}
