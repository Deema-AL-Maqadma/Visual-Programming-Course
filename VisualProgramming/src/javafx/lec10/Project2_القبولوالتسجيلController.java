package javafx.lec10;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Project2_القبولوالتسجيلController implements Initializable {

    @FXML
    private TextArea note;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> gender;
    @FXML
    private TableColumn<?, ?> dep;
    @FXML
    private TableColumn<?, ?> level;
    @FXML
    private TableColumn<?, ?> grade;
    @FXML
    private ComboBox<String> depCombo;
    @FXML
    private ImageView choose;
    @FXML
    private Button Choose;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        depCombo.getItems().addAll("علم الحاسوب", "تكنولوجيا المعلومات التطبيقية", "تكنولوجيا الشبكات والهواتف النقالة");

    }

    @FXML
    public void exit() {
        Dialog d = new Dialog();
        d.setTitle(Fxml_test.title);
        d.setHeaderText(" الخروج من التطبيق...");
        d.setContentText("هل تريد بالتاكيد الخروج من التطبيق؟");
        ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType btnNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        d.getDialogPane().getButtonTypes().addAll(btnYes, btnNo);
        if (d.showAndWait().get() == btnYes) {
            Platform.exit();

        }
    }

    @FXML
    public void openImage() {
        FileChooser fc = new FileChooser(); // عشان يفتحلي انه اختار صورة
        fc.setTitle((Fxml_test.title));// عنوان علوي
        fc.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg"));// انواع الملفات المسموح افتحها
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {// يعني اختار الصورة
            String imagePath = selectedFile.toURI().toString();
            choose.setImage(new Image(imagePath));
        }
    }
}
