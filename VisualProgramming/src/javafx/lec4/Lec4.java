
package javafx.lec4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Lec4 extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)  {
        Label lbl = new Label("Welcome To Magic World!");
        lbl.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 35));
        lbl.setTooltip(new Tooltip("Enjoy"));// رسالة توضيح عند وضع المؤشر
        lbl.setTextFill(Color.rgb(223,120, 45));// لون حسب الدرجات التالية
        lbl.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID,new CornerRadii(7), BorderWidths.DEFAULT)));
        
        Button btn = new Button("Login");
        btn.setTextFill(Color.WHEAT);
        btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 25));
        btn.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(7), BorderWidths.DEFAULT)));
        btn.setTooltip(new Tooltip("Enter"));// رسالة توضيح عند وضع المؤشر
        btn.setCursor(Cursor.HAND);//لتغيير شكل الماوس عند النقر على الزر
        btn.setBackground(new Background(new BackgroundFill(Color.BLACK,new CornerRadii(16),Insets.EMPTY)));
        
        
        
        ToggleButton tgbtn = new ToggleButton("ON");// زر يشتغل او يطفي
        tgbtn.setFocusTraversable(false);
        
        RadioButton rbtn = new RadioButton("Maile");
        RadioButton rbtn2 = new RadioButton("Femaile");
        ToggleGroup tgroup = new ToggleGroup();
        tgroup.getToggles().addAll(rbtn,rbtn2);
        HBox hb = new HBox(rbtn,rbtn2);
        hb.setAlignment(Pos.CENTER);
        
        VBox root = new VBox(25,lbl,hb,tgbtn,btn);
        root.setAlignment(Pos.CENTER);// وضعهم في المنتصف
       
        
        
        Scene s = new Scene(root,500,500);
        
        stage.setScene(s);
        stage.setTitle("--->>> ENTER");
        stage.show();
        stage.setResizable(false);
    }
    
}
