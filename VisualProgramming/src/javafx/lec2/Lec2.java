
package javafx.lec2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Lec2 extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        
        //  نص يظهر على الشاشة
        Label lbl = new Label("UserName");
        Label lbl2 = new Label();
        lbl2.setText("PassWord");
        // لتغير حجم ولون النص المخزن في lable
        lbl.setFont(new Font("Arial",20));
        lbl2.setFont(new Font("Arial",20));
        lbl.setTextFill(Color.RED);
        lbl2.setTextFill(Color.RED);
        
        // لاظهار مربع النص للادخال بجانب النص المكتوب
        TextField  tf_user = new TextField();//يظهر الادخال كما هو
        PasswordField ps_pass = new PasswordField();// يخفي الادخال ويظهر نقاط
        // لوضع الخط الفاهي النص التوضيحي للادخال المطلوب مكان الادخال وعند الضغط عليه يختفي
        tf_user.setPromptText("Enter Username");
        ps_pass.setPromptText("Enter Password");
        // حتى لا يظهر المؤشر على مربع الادخال والغي الفوكس للمؤشر
        tf_user.setFocusTraversable(false);
        ps_pass.setFocusTraversable(false);

        
        
        //لاضافة النص ومربع الادخال بجانب بعضهم نخزنهم داخل حاوية صف
        HBox hb_user = new HBox(lbl,tf_user);
        HBox hb_pass = new HBox(lbl2,ps_pass);
        //لوضع مسافة بين العناصر
        hb_user.setSpacing(25);
        hb_pass.setSpacing(25);
        // لوضع النص في المنتصف
        hb_user.setAlignment(Pos.CENTER);
        hb_pass.setAlignment(Pos.CENTER);
        
        
        // لوضع مربع صح تحت كلمة المرور
        CheckBox cb = new CheckBox();
        cb.setText("Remember me!");
        cb.setFont(new Font("Arial",12));
        cb.setTextFill(Color.BLUE);
        cb.setFocusTraversable(false);
        
        //لوضع الخط الفاصل بين البوكس والزر
        Separator sp = new Separator();
        Separator sp2 = new Separator();



        // زر 
        Button btn = new Button("Login");
        // لتغيير لون وحجم الكلام للزر
        btn.setFont(new Font("Arial",20));
        btn.setTextFill(Color.CYAN);
        // لعمل خلفية للزر
        btn.setBackground(new Background(new BackgroundFill(Color.BLACK,new CornerRadii(16),Insets.EMPTY)));
        

        // البوكس يلي هضيف الاشاياء بداخله بشكل عمودي
        VBox root = new VBox(20);//  القيمة الرقمية للمسافة بين العناصر تكون اول ارقيمنت ولو بدي اضيف العناصر من الكونستركتر تكون بعدها
        
        // لاضافة الخصائص داخله اما عن طريق Constructor,add(),addAll()
        root.getChildren().addAll(hb_user,hb_pass,cb,sp,btn,sp2);//بضيف النود بالترتيب
        root.setAlignment(Pos.CENTER);// لوضع محنويات الروت في المنتصف
        root.setBackground(Background.EMPTY);//بلغي خلفية الروت حتى تظهر لون خلفية  السين

        // يمكن اعطيها قيمة واحدة او ثلاث قيم للابعاد واخر شي للون الشاشة الظاهرة
        Scene s = new Scene(root,720,410,Color.PEACHPUFF);
        stage.setScene(s);
        stage.setTitle("--->>> Login :");//لاعطاء عنوان او اسم للواجهة الناتجة
        stage.setResizable(false);//للتحكم في التكبير والتصغير
        stage.setMaximized(false);//لتكبير الشاشة لاكبر حجم
        stage.setAlwaysOnTop(true);//لجعل الشاشة الناتجة دائما في القمة
        stage.show();// لعرض الشاشة الناتجة
        

  
    
    
    
    
    
    
}
}
