package javafx.lec3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class lec3A extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image(getClass().getResourceAsStream("photo_2025-06-09_19-09-26.jpg"));    // إنشاء الصورة

        ImageView iv = new ImageView(image); // عشان يتعرف على مسار الصورة يعني عشان تاخذ الصورة
        iv.setFitHeight(60);    // طول الصورة
        iv.setFitWidth(80);     // عرض الصورة
        iv.setTranslateX(160);      // تحديد أبعاد الصورة بالسينات
        iv.setTranslateY(170);      // تحديد أبعاد الصورة بالصادات

        TextArea ta = new TextArea();
        ta.setPrefSize(280, 170);   // بتلخذ طول وعرض المنطقة
        ta.setWrapText(true);   // عشان لما اكتب اشي بالمنطقة ينزل يطر ما يضله مكمل كل السطر
        ta.setTranslateX(160);      // تحديد أبعاد المنطقة بالسينات
        ta.setTranslateY(170);      // تحديد أبعاد المنطقة بالصادات

        Text t1 = new Text("Text: JavaFX 1");   // عبارة عن نص ولكن هو شكل يتبع مع ال Shap
        t1.setTranslateX(180);      // تحديد ابعاد العنصر بالسينات
        t1.setTranslateY(200);      // تحديد ابعاد العنصر بالصادات

        Text t2 = new Text("Text: JavaFX 2");   // عبارة عن نص ولكن هو شكل يتبع مع ال Shap
        t2.setTranslateX(220);      // تحديد ابعاد العنصر بالسينات
        t2.setTranslateY(250);      // تحديد ابعاد العنصر بالصادات

        Label lbl = new Label("Label: JavaFX 1");
        lbl.setTranslateX(30);      // تحديد ابعاد العنصر بالسينات
        lbl.setTranslateY(50);      // تحديد ابعاد العنصر بالصادات
        Label lbl2 = new Label("Label: JavaFX 2");
        lbl2.setTranslateX(60);     // تحديد ابعاد العنصر بالسينات
        lbl2.setTranslateY(90);     // تحديد ابعاد العنصر بالصادات
        Label lbl3 = new Label("Label: JavaFX 3");
        lbl3.setTranslateX(120);    // تحديد ابعاد العنصر بالسينات
        lbl3.setTranslateY(160);    // تحديد ابعاد العنصر بالصادات

        Group root = new Group(lbl, lbl2, lbl3, t1, t2, iv);    // بجمع كل العناصر بس بحطهم كلهم فوق بعض ولازم تضطر انك تبعدهم عن بعض

        Scene s = new Scene(root, 720, 410);

        stage.setTitle("lec 4"); // عنوان شاشة العرض
        stage.setScene(s);  // عشان أوضع سين للستيج
        stage.setMaximized(false); // بتقدر تكبر شاشة العرض
        stage.setResizable(false); // التكبير والتصغير في شاشة العرض
        stage.show(); // عشان أظهر الشاشة
        stage.setAlwaysOnTop(true); // عشان لو ضغطت خارج الشاشة تضلها الشاشة شغالة
    }
}
