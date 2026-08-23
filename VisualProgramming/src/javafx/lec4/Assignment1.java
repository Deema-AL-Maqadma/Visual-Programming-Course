// Student Name => Ahmed Mohammed Al-Farani
// Student ID => 1320236338
package javafx.lec4;

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
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Assignment1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label lbl1 = new Label("Coffee Order Form");
        lbl1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        lbl1.setAlignment(Pos.CENTER);
        lbl1.setTextFill(Color.web("#6F4E37"));
        lbl1.setCursor(Cursor.TEXT);

        Label lbl2 = new Label("Customer Name: ");
        lbl2.setTooltip(new Tooltip("Customer Name"));
        lbl2.setFont(Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 12));
        lbl2.setTextFill(Color.web("#4B2E2B"));
        lbl2.setCursor(Cursor.TEXT);

        TextField tf1 = new TextField();
        tf1.setFocusTraversable(false);
        tf1.setPromptText("Enter Your Name");
        tf1.setTooltip(new Tooltip("Customer Name"));
        tf1.setStyle("-fx-background-color: #F5F5F5; -fx-border-color: #D2B48C; -fx-text-fill: #555555;");

        Label lbl3 = new Label("Phone Number: ");
        lbl3.setTooltip(new Tooltip("Phone Number"));
        lbl3.setFont(Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 12));
        lbl3.setTextFill(Color.web("#4B2E2B"));
        lbl3.setCursor(Cursor.TEXT);

        TextField tf2 = new TextField();
        tf2.setFocusTraversable(false);
        tf2.setPromptText("Enter Your Number");
        tf2.setTooltip(new Tooltip("Phone Number"));
        tf2.setStyle("-fx-background-color: #F5F5F5; -fx-border-color: #D2B48C; -fx-text-fill: #555555;");

        Label lbl4 = new Label("Coffee Type: ");
        lbl4.setTooltip(new Tooltip("Coffee Type"));
        lbl4.setFont(Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 12));
        lbl4.setTextFill(Color.web("#4B2E2B"));
        lbl4.setCursor(Cursor.TEXT);

        TextField tf3 = new TextField();
        tf3.setFocusTraversable(false);
        tf3.setPromptText("Choose Coffee Type");
        tf3.setTooltip(new Tooltip("Coffee Type"));
        tf3.setStyle("-fx-background-color: #F5F5F5; -fx-border-color: #D2B48C; -fx-text-fill: #555555;");

        Label lbl5 = new Label("Cup Size");
        lbl5.setTooltip(new Tooltip("Coffee Type"));
        lbl5.setFont(Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 12));
        lbl5.setTextFill(Color.web("#4B2E2B"));
        lbl5.setCursor(Cursor.TEXT);

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

        ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        Label lbl6 = new Label("Extars");
        lbl6.setTooltip(new Tooltip("Coffee Type"));
        lbl6.setFont(Font.font("Verdana", FontWeight.BLACK, FontPosture.REGULAR, 12));
        lbl6.setTextFill(Color.web("#4B2E2B"));
        lbl6.setCursor(Cursor.TEXT);

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

        Button btn1 = new Button("OK");
        btn1.setFont(new Font("Arial", 18));
        btn1.setTextFill(Color.WHITE);
        btn1.setBackground(new Background(new BackgroundFill(Color.web("#4E342E"), new CornerRadii(5), Insets.EMPTY)));
        btn1.setCursor(Cursor.HAND);
        btn1.setPrefWidth(150);

        Button btn2 = new Button("Cancel");
        btn2.setFont(new Font("Arial", 18));
        btn2.setTextFill(Color.WHITE);
        btn2.setBackground(new Background(new BackgroundFill(Color.web("#A1887F"), new CornerRadii(5), Insets.EMPTY)));
        btn2.setCursor(Cursor.HAND);
        btn2.setPrefWidth(150);

        Label lbl7 = new Label();
        lbl7.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(12);
        root.setVgap(10);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #F5F5DC; -fx-border-color: Beige; -fx-border-width: 2px;");

        root.add(lbl1, 0, 0, 2, 1);
        GridPane.setHalignment(lbl1, HPos.CENTER);

        root.add(lbl2, 0, 2);
        root.add(tf1, 1, 2);

        root.add(lbl3, 0, 3);
        root.add(tf2, 1, 3);

        root.add(lbl4, 0, 4);
        root.add(tf3, 1, 4);

        root.add(lbl5, 0, 6);
        root.add(rb1, 1, 6);
        root.add(rb2, 1, 7);
        root.add(rb3, 1, 8);

        root.add(lbl6, 0, 10);
        root.add(cb1, 1, 10);
        root.add(cb2, 1, 11);
        root.add(cb3, 1, 12);
        root.add(cb4, 1, 13);

//        root.add(btn1, 1, 14);
//        root.add(btn2, 2, 14);
        HBox hb = new HBox(5, btn1, btn2);
        hb.setAlignment(Pos.CENTER);
        root.add(hb, 1, 15);

        root.add(lbl7, 1, 17);

        btn1.setOnAction(e -> {
            if (tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty()) {
                lbl7.setTextFill(Color.web("#B22222"));
                lbl7.setText("Please fill in all required fields.");
            } else {
                String size = "Not Selected";

                if (rb1.isSelected()) {
                    size = "Small";
                } else if (rb2.isSelected()) {
                    size = "Medium";
                } else if (rb3.isSelected()) {
                    size = "Large";
                }

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
                lbl7.setTextFill(Color.web("#2E8B57"));
                lbl7.setText("The coffee order was placed successfully!\nSize: " + size + "\nExtras: " + extras);

            }
        }
        );

        btn2.setOnAction(e -> {
            tf1.clear();
            tf2.clear();
            tf3.clear();

            rb1.setSelected(false);
            rb2.setSelected(false);
            rb3.setSelected(false);

            cb1.setSelected(false);
            cb2.setSelected(false);
            cb3.setSelected(false);
            cb4.setSelected(false);

            lbl7.setText("");
        });

        Scene s = new Scene(root, 600, 600, Color.web("#F5F5DC"));

        stage.setScene(s);
        stage.show();
        stage.setTitle("Coffee Order Form");
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.setAlwaysOnTop(true);
    }
}

// Student Name => Ahmed Mohammed Al-Farani
// Student ID => 1320236338
