package javafx.lec6;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // =========== Line ===============
        Line line = new Line(20, 0, 180, 0);
        //يمكن اضافتهم عن طؤيق الكونستركتر بالترتيب
        //line.setStartX(20);
        //line.setStartY(80);
        //line.setEndX(120);
        //line.setEndY(200);
        line.setStroke(Color.BLUE);//لاعطاء اللون
        line.setStrokeWidth(4);// لتغيير الحجم للعرض للخط

        // =========== Rectangle ===============
        Rectangle rec = new Rectangle(160, 80, 200, 120);
        //يمكن اضافتهم عن طؤيق الكونستركتر بالترتيب
        //rec.setX(160);
        //rec.setY(80);
        //rec.setWidth(200);
        //rec.setHeight(120);
        rec.setFill(Color.RED);// لتلوين الشكل
        rec.setStroke(Color.BLACK); // لوضع اطار للشكل
        rec.setStrokeWidth(6);//لتخميل الشكل

        // =========== Circle ===============
        Circle c = new Circle(260, 290, 200, Color.RED);
        //c.setCenterX(260);
        //c.setCenterY(290);
        //c.setRadius(200);
        //c.setFill(Color.RED);
        c.setStroke(Color.BLACK); // لوضع اطار للشكل
        c.setStrokeWidth(6);//لتخميل الشكل

        // =========== Ellipse ===============
        Ellipse e = new Ellipse(160, 290, 150, 60);
        //e.setCenterX(260);
        //e.setCenterY(290);
        //e.setRadiusX(150);
        //e.setRadiusY(100);
        e.setFill(Color.RED);
        e.setStroke(Color.BLACK); // لوضع اطار للشكل
        e.setStrokeWidth(6);//لتخميل الشكل

        // =========== Polygon ===============
        Polygon p = new Polygon();
        p.getPoints().addAll(
                100.0, 200.0,
                200.0, 50.0,
                300.0, 200.0
        );
        p.setFill(Color.RED);
        p.setStroke(Color.BLACK); // لوضع اطار للشكل
        p.setStrokeWidth(6);//لتخميل الشكل

        // =========== Polyline ===============
        Polyline pl = new Polyline();
        pl.getPoints().addAll(
                100.0, 200.0,
                200.0, 50.0,
                300.0, 200.0
        );
        pl.setFill(Color.RED);
        pl.setStroke(Color.BLACK); // لوضع اطار للشكل
        pl.setStrokeWidth(6);//لتخميل الشكل

        
        
        Group root = new Group(pl);
        Scene s = new Scene(root, 500, 500);
        stage.setScene(s);
        stage.show();
    }

}
