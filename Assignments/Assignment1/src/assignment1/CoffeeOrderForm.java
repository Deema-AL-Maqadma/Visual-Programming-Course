/** My Name : Deema Mohammed AL-Maqadma
 * ID : 2320230766
 * Assignment1 : CoffeeOrderForm
 * Presented to : Eng. Mahmoud Ashour
 *   --->>> GO A HERO !!!
 */
package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CoffeeOrderForm extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        // ------>>> Title Label <<<------
        Label title_lbl = new Label("Coffee Order Form");
        title_lbl.setFont(Font.font("Script MT Bold", FontWeight.BOLD, FontPosture.ITALIC, 70));
        title_lbl.setTextFill(Color.valueOf("#5D4037"));
        title_lbl.setAlignment(Pos.CENTER);
        title_lbl.setCursor(Cursor.OPEN_HAND);

        // ------>>> All other Lables <<<------
        Label lbl1 = new Label("Customer Name: ");
        lbl1.setTooltip(new Tooltip("Customer Name"));
        lbl1.setFont(Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 20));
        lbl1.setTextFill(Color.web("#4B2E2B"));
        lbl1.setCursor(Cursor.CLOSED_HAND);

        Label lbl2 = new Label("Phone Number: ");
        lbl2.setTooltip(new Tooltip("Phone Number"));
        lbl2.setFont(Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 20));
        lbl2.setTextFill(Color.web("#4B2E2B"));
        lbl2.setCursor(Cursor.CLOSED_HAND);

        Label lbl3 = new Label("Coffee Type: ");
        lbl3.setTooltip(new Tooltip("Coffee Type"));
        lbl3.setFont(Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 20));
        lbl3.setTextFill(Color.web("#4B2E2B"));
        lbl3.setCursor(Cursor.CLOSED_HAND);

        Label lbl4 = new Label("Cup Size");
        lbl4.setTooltip(new Tooltip("Coffee Type"));
        lbl4.setFont(Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 20));
        lbl4.setTextFill(Color.web("#4B2E2B"));
        lbl4.setCursor(Cursor.CLOSED_HAND);

        Label lbl5 = new Label("Extars");
        lbl5.setTooltip(new Tooltip("Coffee Type"));
        lbl5.setFont(Font.font("Verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
        lbl5.setTextFill(Color.web("#4B2E2B"));
        lbl5.setCursor(Cursor.CLOSED_HAND);

        Label lbl6 = new Label();
        lbl6.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        lbl6.setMinHeight(60);
        lbl6.setPrefWidth(350);
        lbl6.setWrapText(true);
        

        // ------>>> Text Fields <<<------
        TextField tf1 = new TextField();
        tf1.setFocusTraversable(false);
        tf1.setPromptText("Enter Your Name");
        tf1.setTooltip(new Tooltip("Customer Name"));
        tf1.setBorder(new Border(new BorderStroke(Color.web("#D2B48C"), BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(3))));

        TextField tf2 = new TextField();
        tf2.setFocusTraversable(false);
        tf2.setPromptText("Enter Your Number");
        tf2.setTooltip(new Tooltip("Phone Number"));
        tf2.setBorder(new Border(new BorderStroke(Color.web("#D2B48C"), BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(3))));

        TextField tf3 = new TextField();
        tf3.setFocusTraversable(false);
        tf3.setPromptText("Choose Coffee Type");
        tf3.setTooltip(new Tooltip("Coffee Type"));
        tf3.setBorder(new Border(new BorderStroke(Color.web("#D2B48C"), BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(3))));

        // ------>>> Radio Buttons <<<------
        RadioButton rb1 = new RadioButton("Small");
        rb1.setFont(new Font("Arial", 12));
        rb1.setTextFill(Color.BLACK);
        rb1.setFocusTraversable(false);
        rb1.setPadding(new Insets(0, 150, 0, 0));
        rb1.setCursor(Cursor.HAND);

        RadioButton rb2 = new RadioButton("Medium");
        rb2.setFont(new Font("Arial", 12));
        rb2.setTextFill(Color.BLACK);
        rb2.setFocusTraversable(false);
        rb2.setPadding(new Insets(0, 150, 0, 0));
        rb2.setCursor(Cursor.HAND);

        RadioButton rb3 = new RadioButton("Large");
        rb3.setFont(new Font("Arial", 12));
        rb3.setTextFill(Color.BLACK);
        rb3.setFocusTraversable(false);
        rb3.setPadding(new Insets(0, 150, 0, 0));
        rb3.setCursor(Cursor.HAND);

        // ------>>> Toggle Group to add all Radio Buttons <<<------
        ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        // ------>>> Check Boxes <<<------
        CheckBox cb1 = new CheckBox("Suger");
        cb1.setFont(new Font("Arial", 12));
        cb1.setTextFill(Color.BLACK);
        cb1.setFocusTraversable(false);
        cb1.setPadding(new Insets(0, 150, 0, 0));
        cb1.setCursor(Cursor.HAND);

        CheckBox cb2 = new CheckBox("Milk");
        cb2.setFont(new Font("Arial", 12));
        cb2.setTextFill(Color.BLACK);
        cb2.setFocusTraversable(false);
        cb2.setPadding(new Insets(0, 150, 0, 0));
        cb2.setCursor(Cursor.HAND);

        CheckBox cb3 = new CheckBox("Whipped Cream");
        cb3.setFont(new Font("Arial", 12));
        cb3.setTextFill(Color.BLACK);
        cb3.setFocusTraversable(false);
        cb3.setPadding(new Insets(0, 150, 0, 0));
        cb3.setCursor(Cursor.HAND);

        CheckBox cb4 = new CheckBox("Vanilla");
        cb4.setFont(new Font("Arial", 12));
        cb4.setTextFill(Color.BLACK);
        cb4.setFocusTraversable(false);
        cb4.setPadding(new Insets(0, 150, 0, 0));
        cb4.setCursor(Cursor.HAND);

        // ------>>> Buttons <<<------
        Button btn1 = new Button("OK");
        btn1.setFont(new Font("Arial", 18));
        btn1.setTextFill(Color.WHITE);
        btn1.setBackground(new Background(new BackgroundFill(Color.web("#4E342E"), new CornerRadii(5), Insets.EMPTY)));
        btn1.setBorder(new Border(new BorderStroke(Color.web("#D2B48C"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(3))));
        btn1.setCursor(Cursor.HAND);
        btn1.setPrefWidth(150);

        Button btn2 = new Button("Cancel");
        btn2.setFont(new Font("Arial", 18));
        btn2.setTextFill(Color.WHITE);
        btn2.setBackground(new Background(new BackgroundFill(Color.web("#A1887F"), new CornerRadii(5), Insets.EMPTY)));
        btn2.setBorder(new Border(new BorderStroke(Color.web("#D2B48C"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(3))));
        btn2.setCursor(Cursor.HAND);
        btn2.setPrefWidth(150);

        // ------>>> GridPane Layout <<<------
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(20));
        root.setBackground(new Background(new BackgroundFill(Color.BEIGE, new CornerRadii(0), Insets.EMPTY)));
        root.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(8), new BorderWidths(7))));

        // ------>>> Adding All UI control to the GridPane Layout <<<------
        root.add(title_lbl, 0, 0, 2, 1);
        GridPane.setHalignment(title_lbl, HPos.CENTER);

        root.add(lbl1, 0, 3);
        root.add(tf1, 1, 3);

        root.add(lbl2, 0, 4);
        root.add(tf2, 1, 4);

        root.add(lbl3, 0, 5);
        root.add(tf3, 1, 5);

        root.add(lbl4, 0, 7);
        root.add(rb1, 1, 7);
        root.add(rb2, 1, 8);
        root.add(rb3, 1, 9);

        root.add(lbl5, 0, 11);
        root.add(cb1, 1, 11);
        root.add(cb2, 1, 12);
        root.add(cb3, 1, 13);
        root.add(cb4, 1, 14);

        root.add(lbl6, 1, 18);

        // GridPane for OK & Cancel Buttons
        GridPane btn_GridPane = new GridPane();
        btn_GridPane.add(btn1, 0, 2);
        btn_GridPane.add(btn2, 1, 2);
        root.add(btn_GridPane, 1, 16);

        // ------>>> The Action of OK button <<<------
        btn1.setOnAction(e -> {
            if (tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty()) {
                lbl6.setTextFill(Color.web("#B22222"));
                lbl6.setText("Please fill in all required fields.");
            } else {
                String size = "Not Selected";

                if (rb1.isSelected()) {
                    size = "Small";
                } else if (rb2.isSelected()) {
                    size = "Medium";
                } else if (rb3.isSelected()) {
                    size = "Large";
                }
                List<String> selectedExtras = new ArrayList<>();

                if (cb1.isSelected()) {
                    selectedExtras.add("Sugar");
                }
                if (cb2.isSelected()) {
                    selectedExtras.add("Milk");
                }
                if (cb3.isSelected()) {
                    selectedExtras.add("Whipped Cream");
                }
                if (cb4.isSelected()) {
                    selectedExtras.add("Vanilla");
                }

                String extrasText = String.join(", ", selectedExtras);
                // يجمعهم بفاصلة ومسافة
               lbl6.setText("The coffee order was placed successfully!\n"
                        + "Size: " + size + "\n"
                        + "Extras: " + extrasText);
          
            }
        }
        );
        // حل اخر 
                // ------>>> The Action of OK button <<<------
        btn1.setOnAction(e -> {
            if (tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty()) {
                lbl6.setTextFill(Color.web("#B22222"));
                lbl6.setText("Please fill in all required fields.");
            } else {
                String size = "Not Selected";

                if (rb1.isSelected()) {
                    size = "Small";
                } else if (rb2.isSelected()) {
                    size = "Medium";
                } else if (rb3.isSelected()) {
                    size = "Large";
                }

                // او من خلال StringBuilder
                StringBuilder extras = new StringBuilder();
                if (cb1.isSelected()) {
                    extras.append("Sugar, ");
                }
                if (cb2.isSelected()) {
                    extras.append("Milk, ");
                }
                if (cb3.isSelected()) {
                    extras.append("Whipped Cream, ");
                }
                if (cb4.isSelected()) {
                    extras.append("Vanilla, ");
                }
                if (extras.length() > 0) {
                    extras.setLength(extras.length() - 2);
                }
                // او من خلال استخدام Stresm
//                String extras = Stream.of(cb1, cb2, cb3, cb4)
//                        .filter(CheckBox::isSelected) // تصفية فقط المختارة
//                        .map(CheckBox::getText) // تحويل إلى نص الخيار
//                        .collect(Collectors.joining(", ")); // جمع النتائج مفصولة بفواصل
                lbl6.setTextFill(Color.web("#2E8B57"));
                lbl6.setText("The coffee order was placed successfully!\nSize: " + size + "\nExtras: " + extras);

            }
        }
        );

        // ------>>> The Action of Cancle button <<<------
        btn2.setOnAction(e -> {
            // مسح الحقول
            tf1.clear();
            tf2.clear();
            tf3.clear();
            // او من خلال استخدام Stresm
            // Stream.of(tf1, tf2, tf3)
            //.forEach(TextField::clear);

            rb1.setSelected(false);
            rb2.setSelected(false);
            rb3.setSelected(false);

            cb1.setSelected(false);
            cb2.setSelected(false);
            cb3.setSelected(false);
            cb4.setSelected(false);

            lbl6.setText("");
        });

        Scene s = new Scene(root, 700, 700, Color.web("#F5F5DC"));

        stage.setScene(s);
        stage.show();
        stage.setTitle("--->>> Coffee Order Form : ");
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.setAlwaysOnTop(true);

    }

}
// My Name : Deema Mohammed AL-Maqadma
// ID : 2320230766
