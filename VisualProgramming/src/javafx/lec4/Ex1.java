// Sum 0f numbers

package javafx.lec4;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
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

public class Ex1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label lbl = new Label("Number1");
        lbl.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 30));
        lbl.setTooltip(new Tooltip("Number1"));// رسالة توضيح عند وضع المؤشر
        lbl.setTextFill(Color.BLUE);
        lbl.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(7), BorderWidths.DEFAULT)));

        Label lbl2 = new Label("Number2");
        lbl2.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 30));
        lbl2.setTooltip(new Tooltip("Number2"));// رسالة توضيح عند وضع المؤشر
        lbl2.setTextFill(Color.BLUE);
        lbl2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(7), BorderWidths.DEFAULT)));

        Label lbl_result = new Label("");
        lbl_result.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 25));
        lbl_result.setTooltip(new Tooltip("Result"));// رسالة توضيح عند وضع المؤشر
        lbl_result.setTextFill(Color.BLUE);


        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        tf1.setPromptText("Enter Number1");
        tf2.setPromptText("Enter Number2");
        tf1.setFocusTraversable(false);
        tf2.setFocusTraversable(false);

        HBox hb = new HBox(20, lbl, tf1);
        HBox hb2 = new HBox(20, lbl2, tf2);
        hb.setAlignment(Pos.CENTER);
        hb2.setAlignment(Pos.CENTER);

        Button btn = new Button("Sum");
        btn.setTextFill(Color.WHEAT);
        btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 25));
        btn.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(7), BorderWidths.DEFAULT)));
        btn.setTooltip(new Tooltip("Enter"));// رسالة توضيح عند وضع المؤشر
        btn.setCursor(Cursor.HAND);//لتغيير شكل الماوس عند النقر على الزر
        btn.setBackground(new Background(new BackgroundFill(Color.BLACK,new CornerRadii(16),Insets.EMPTY)));
        // Action
        btn.setOnAction(e -> {
            if (tf1.getText().equals("") || tf2.getText().equals("")) {
                lbl_result.setText("Enter the numbers firstly");
                lbl_result.setTextFill(Color.RED);
            } else {
                int n1 = Integer.parseInt(tf1.getText());
                int n2 = Integer.parseInt(tf2.getText());
                int sum = n1 + n2;
                lbl_result.setText(n1+" + "+n2+" = " +sum );
                lbl_result.setTextFill(Color.GREEN);

            }
        });
        
        
        Separator sp = new Separator();
        Separator sp2 = new Separator();

        VBox root = new VBox(25, hb, hb2,sp, btn,sp2,lbl_result);
        root.setAlignment(Pos.CENTER);// وضعهم في المنتصف
        root.setBackground(Background.EMPTY);

        Scene s = new Scene(root, 500, 500, Color.PEACHPUFF);

        stage.setScene(s);
        stage.setTitle("--->>> Calculate");
        stage.show();
        stage.setResizable(false);
    }

}
