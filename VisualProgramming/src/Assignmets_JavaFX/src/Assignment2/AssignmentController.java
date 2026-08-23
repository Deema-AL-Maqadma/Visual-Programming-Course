/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Assignment2;

import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AssignmentController implements Initializable {

    @FXML
    private RadioButton rbtn_Male;
    @FXML
    private RadioButton rbtn_Female;
    @FXML
    private TextField tf_Age;
    @FXML
    private TextField tf_Height;
    @FXML
    private TextField tf_Weight;
    @FXML
    private ComboBox<String> cbox_Activity;
    @FXML
    private Button btn_Calc;
    @FXML
    private Button btn_New;
    @FXML
    private CheckBox checkb_Display;
    @FXML
    private Label bmi_Label;
    @FXML
    private Label bmr_Label;
    @FXML
    private Label tdee_Label;
    @FXML
    private Hyperlink link_Click;
    @FXML
    private ImageView bmi_Image;
    @FXML
    private ToggleGroup gender;
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        bmi_Image.setVisible(false);

        cbox_Activity.getItems().addAll("Sedentary", "Lightly active", "Moderately active", "Mustard active", "Radio active");
    }

    @FXML
    private void btnCalc(ActionEvent event) {
        try {
            int age = Integer.parseInt(tf_Age.getText());
            double weight = Double.parseDouble(tf_Weight.getText());
            double heightCm = Double.parseDouble(tf_Height.getText());
            double heightM = heightCm / 100.0;

            double bmi = weight / (heightM * heightM);
            double bmr;

            if (age < 10 || heightCm < 100 || weight < 30) {
                showDialog("Please enter realistic values:\n-> Age ≥ 10\n-> Height ≥ 100 cm\n-> Weight ≥ 30 kg");
                return;
            }

            if (rbtn_Male.isSelected()) {
                bmr = 5 + (10 * weight) + (6.25 * heightCm) - (5 * age);
            } else if (rbtn_Female.isSelected()) {
                bmr = 161 + (10 * weight) + (6.25 * heightCm) - (5 * age);
            } else {
                showDialog("Please select a gender.");
                return;
            }

            String formatted_bmi = String.format("BMI: %.2f kg/m²", bmi);
            bmi_Label.setText(formatted_bmi);

            String formatted_bmr = String.format("BMR: %.2f kcal/day", bmr);
            bmr_Label.setText(formatted_bmr);

            if (checkb_Display.isSelected()) {
                if (bmi <= 18.5) {
                    Image underWeight = new Image(getClass().getResourceAsStream("/images/underweight.png"));
                    bmi_Image.setImage(underWeight);
                } else if (bmi > 18.5 && bmi <= 24.9) {
                    Image normal = new Image(getClass().getResourceAsStream("/images/normal.png"));
                    bmi_Image.setImage(normal);
                } else if (bmi >= 25 && bmi <= 29.9) {
                    Image overWeight = new Image(getClass().getResourceAsStream("/images/overweight.png"));
                    bmi_Image.setImage(overWeight);
                } else if (bmi >= 30 && bmi <= 34.9) {
                    Image obese = new Image(getClass().getResourceAsStream("/images/obese.png"));
                    bmi_Image.setImage(obese);
                } else {
                    Image extremely_obese = new Image(getClass().getResourceAsStream("/images/extremely obese.png"));
                    bmi_Image.setImage(extremely_obese);
                }
                bmi_Image.setVisible(true);
            } else {
                bmi_Image.setVisible(false);
            }

            double activityFactor = 1.0;
            String activity = cbox_Activity.getValue();

            if (activity != null) {
                switch (activity) {
                    case "Sedentary":
                        activityFactor = 1.2;
                        break;
                    case "Lightly active":
                        activityFactor = 1.375;
                        break;
                    case "Moderately active":
                        activityFactor = 1.55;
                        break;
                    case "Mustard active":
                        activityFactor = 1.725;
                        break;
                    case "Radio active":
                        activityFactor = 1.9;
                        break;
                }

                double tdee = bmr * activityFactor;

                tdee_Label.setText(String.format("TDEE: %.2f kcal/day", tdee));
            } else {
                showDialog("Select activity level");
            }

        } catch (NumberFormatException e) {
            showDialog("Please enter valid numbers.");
        }

    }

    private void showDialog(String message) {
        Dialog<String> d = new Dialog<>();
        d.setTitle("Error");
        d.setHeaderText(null);
        d.setContentText(message);

        ButtonType okBtn = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(okBtn);

        d.showAndWait();
    }

    @FXML
    private void btnNew(ActionEvent event) {
        tf_Age.clear();
        tf_Weight.clear();
        tf_Height.clear();
        bmi_Label.setText("");
        bmr_Label.setText("");
        tdee_Label.setText("");
        gender.selectToggle(null);
        bmi_Image.setVisible(false);
        checkb_Display.setSelected(false);

        cbox_Activity.getSelectionModel().clearSelection();
        
        cbox_Activity.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? cbox_Activity.getPromptText() : item);
            }
        });

        anchorPane.requestFocus();
    }

    @FXML
    private void clickHere(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URI("https://www.tgfitness.com/bmi-bmr-calculator/"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
