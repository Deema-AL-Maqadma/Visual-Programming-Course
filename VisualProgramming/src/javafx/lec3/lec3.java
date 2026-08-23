
package javafx.lec3;

import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class lec3 extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        
        Label lbl = new Label("Label 1");
        lbl.setTranslateX(5); // لاني بتعامل مع قروب لازم احدد مكان الاجداثيات
        lbl.setTranslateY(80);
        
        Text text = new Text("Text 1");// نص لكنه عبارة عن شكل
        text.setTranslateX(120); // لاني بتعامل مع قروب لازم احدد مكان الاجداثيات
        text.setTranslateY(40);
        
        TextArea ta = new TextArea();// مربع نص للادخال لكن حجمه اكبر
        ta.setWrapText(true); // لينزل سطر عند انتهاء المساحة الموجودة
        ta.setPrefSize(150, 120);//لتحديد الطول والعرض يعني حجمها
        ta.setPromptText("Enter your message:");// لوضع نص توضيحي للادخال
        ta.setFocusTraversable(false);// لالغاء التركيز على الادخال
        ta.setTranslateX(65); // لاني بتعامل مع قروب لازم احدد مكان الاجداثيات
        ta.setTranslateY(30);
        
        Button btn = new Button("Click here!");
        ta.setTranslateX(40); // لاني بتعامل مع قروب لازم احدد مكان الاجداثيات
        ta.setTranslateY(60);
        
        Image image = new Image(getClass().getResourceAsStream("download.jpg"));// بتنشئ الصورة تضاف مرة واحدة ويمكن عرضهاداخل اكثر من ايمجفيو
        ImageView iv = new ImageView(image);// تستخدم لعرض الصورة المخزنة
        iv.setFitHeight(120);//لاعطاء الحجم
        iv.setFitWidth(80);
        iv.setTranslateX(140); // لاني بتعامل مع قروب لازم احدد مكان الاجداثيات
        iv.setTranslateY(160);
        
                
        Group root = new Group(lbl,text,ta,btn,iv);// حاوية تجمع البيانات فوق بعضها بتعامل مع الاحداثيات للتحكم في اماكنها
        
        
        Scene s = new Scene(root,400,400);
        //s.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);// لجعل الواجهة الناتجة من اليمين لليسار بالعربي يعني
        
        stage.setScene(s);
        stage.setTitle("---->>> Page (1) : ");
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.show();
        
        
    }
    
}
