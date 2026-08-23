/** My Name : Deema Mohammed AL-Maqadma
 * ID : 2320230766
 * Assignment2 : Body Mass Index
 * Presented to : Eng. Mahmoud Ashour
 *   --->>> GO A HERO !!!
 */
package vp_assignment2;

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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BMI_Ass2Controller implements Initializable {

    @FXML
    private ToggleGroup tg1;
    @FXML
    private TextField age;
    @FXML
    private TextField length;
    @FXML
    private TextField weight;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Button calc_btn;
    @FXML
    private Button new_btn;
    @FXML
    private CheckBox displayImage;
    @FXML
    private Label weightStatus;
    @FXML
    private Label calories;
    @FXML
    private ImageView imageView;
    @FXML
    private Pane pane;
    @FXML
    private Label tdee;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageView.setVisible(false);
        // Add items to comboBox
        comboBox.getItems().addAll("Sedentary", "Lightly active", "Moderately active", "Mustard active", "Padio active(Non-stop)");

    }

    // Validation If all input Entered
    public boolean IsValid() {
        if (age.getText().trim().length() == 0
                || length.getText().trim().length() == 0
                || weight.getText().trim().length() == 0
                || tg1.getSelectedToggle() == null
                || comboBox.getItems() == null) {
            weightStatus.setText("⚠️ Please fill out all feilds firstly!");
            calories.setText(""); // تنظيف الحقل الآخر حتى لا يظهر مع التحذير
            return false;
        }
        return true;
    }

    // Action on Calc button
    @FXML
    private void calculate(ActionEvent event) {
        double multiplier = 1.0;
        try {
            if (IsValid()) {
                int age = Integer.parseInt(this.age.getText());
                double lengthCm = Double.parseDouble(length.getText());
                double weightKg = Double.parseDouble(weight.getText());
                String gender = ((RadioButton) tg1.getSelectedToggle()).getText();
                String activity = comboBox.getSelectionModel().getSelectedItem();

                // حساب BMI
                double lengthM = lengthCm / 100.0;
                double bmi = weightKg / (lengthM * lengthM);

                if (age < 10 || lengthCm < 100 || weightKg < 30) {
                    showDialog("Please enter realistic values:\n-> Age ≥ 10\n-> Height ≥ 100 cm\n-> Weight ≥ 30 kg");
                    return;
                }

                // حساب BMR بناءً على النوع
                double bmr = 0;
                if (gender.equals("Male")) {
                    bmr = 88.362 + (13.397 * weightKg) + (4.799 * lengthM) - (5.677 * age);
                } else if (gender.equals("Female")) {
                    bmr = 447.593 + (9.247 * weightKg) + (3.098 * lengthM) - (4.330 * age);
                }

                // تحديد معامل النشاط
                if (activity.equals("Sedentary")) {
                    multiplier = 1.2;
                } else if (activity.equals("Lightly Active")) {
                    multiplier = 1.375;
                } else if (activity.equals("Moderately Active")) {
                    multiplier = 1.55;
                } else if (activity.equals("Mustard Active")) {
                    multiplier = 1.725;
                } else if (activity.equals("Radio Active")) {
                    multiplier = 1.9;
                }
                double tdee_value = bmr * multiplier;

                // تحديد حالة الوزن حسب BMI
                String formatted_weightStatus = "";
                if (bmi < 18.5) {
                    formatted_weightStatus = "Underweight";
                } else if (bmi < 25) {
                    formatted_weightStatus = "Normal weight";
                } else if (bmi < 30) {
                    formatted_weightStatus = "Overweight";
                } else if (bmi < 35) {
                    formatted_weightStatus = "Obesity class I";
                } else if (bmi < 40) {
                    formatted_weightStatus = "Obesity class II";
                } else {
                    formatted_weightStatus = "Obesity class III";
                }

                // إخراج النتائج
                formatted_weightStatus = String.format("BMI: %.2f kg/m²", bmi);
                weightStatus.setText(formatted_weightStatus);
                String formatted_calories = String.format("BMR: %.2f kcal/day", bmr);
                calories.setText(formatted_calories);
                tdee.setText(String.format("TDEE: %.2f kcal/day", tdee_value));

                // Action on display Image checkBox
                if (displayImage.isSelected()) {
                    String gender_type = ((RadioButton) tg1.getSelectedToggle()).getText();
                    String imagePath = "";

                    if (gender_type.equals("Male")) {
                        if (bmi < 18.5) {
                            imagePath = "/images/m_underweight.png";
                        } else if (bmi < 25) {
                            imagePath = "/images/m_normal.png";
                        } else if (bmi < 30) {
                            imagePath = "/images/m_overweight.png";
                        } else {
                            imagePath = "/images/m_obese.png";
                        }
                    } else { // Female
                        if (bmi < 18.5) {
                            imagePath = "/images/f_underweight.jpg";
                        } else if (bmi < 25) {
                            imagePath = "/images/f_normal.jpg";
                        } else if (bmi < 30) {
                            imagePath = "/images/f_overweight.jpg";
                        } else {
                            imagePath = "/images/f_obese.jpg";
                        }
                    }

                    imageView.setImage(new Image(getClass().getResourceAsStream(imagePath)));
                    imageView.setVisible(true);
                } else {
                    imageView.setVisible(false);
                }

            } else {
                showDialog("Select activity level");
            }

        } catch (Exception e) {
            showDialog("Please enter valid numbers.");
        }

    }

    // Action on New button
    @FXML
    private void clear(ActionEvent event) {
        age.setText(null);
        length.setText(null);
        weight.setText(null);
        weightStatus.setText(null);
        calories.setText(null);
        tdee.setText(null);
        tg1.getSelectedToggle().setSelected(false);
        comboBox.setValue(null);
        displayImage.setSelected(false);
        imageView.setImage(null);
        comboBox.getSelectionModel().clearSelection();
        // to prevent focus on combobox
        comboBox.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? comboBox.getPromptText() : item);
            }
        });

        pane.requestFocus();// to cancel focus on item on the pane
    }

    // Action on Click Here! button
    @FXML
    private void Hyperlink(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URI("https://www.google.com"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // for checking on the items 
    private void showDialog(String message) {
        Dialog<String> d = new Dialog<>();
        d.setTitle("Error");
        d.setHeaderText(null);
        d.setContentText(message);

        ButtonType okBtn = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(okBtn);

        d.showAndWait();
    }

}
// My Name : Deema Mohammed AL-Maqadma
// ID : 2320230766
