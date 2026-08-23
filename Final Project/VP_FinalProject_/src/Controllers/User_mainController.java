//===========================================================================================================
/** My Name : Deema Mohammed AL-Maqadma
 * ID : 2320230766
 * Final Project : Library Management System
 * Presented to : Eng. Mahmoud Ashour
 *   --->>> GO A HERO !!!
 */
//===========================================================================================================
package Controllers;

import Database.JDBC;
import Models.Book;
import VP_FinalProject.VP_FinalProject;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//===========================================================================================================

public class User_mainController implements Initializable {

    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_title;
    @FXML
    private TextField tf_auther;
    @FXML
    private CheckBox checkBox_cheched;
    @FXML
    private ComboBox<String> comboBox_genre;
    @FXML
    private TextArea ta_notes;
    @FXML
    private Button btn_upload;
    @FXML
    private ImageView imageView;
    @FXML
    private Hyperlink link_contact;
    @FXML
    private Button btn_save;
    @FXML
    private Button btn_exit;
    @FXML
    private VBox pane;

//===========================================================================================================
    private JDBC jdbc;
//===========================================================================================================

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox_genre.getItems().addAll("Book", "Novel", "Story", "Magazine", "Article", "Poem");
        jdbc = new JDBC();

    }
//===========================================================================================================    
    // message for user

    private void showDialog(String message) {
        Dialog d = new Dialog();
        d.setTitle(VP_FinalProject.title);
        d.setHeaderText("Notice");
        d.setContentText(message);
        ButtonType btnOk = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().addAll(btnOk);
        d.showAndWait();
    }
//===========================================================================================================

    // Action on Upload Book Cover button
    @FXML
    private void ChoosePhoto(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle((VP_FinalProject.title));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            String imagePath = selectedFile.toURI().toString();
            imageView.setImage(new Image(imagePath));
        }
    }
//===========================================================================================================

    // Action on Contact Here! button
    @FXML
    private void HyperLink(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URI("https://www.google.com"));
        } catch (Exception ex) {
            showDialog("Error opening link: " + ex.getMessage());
        }
    }
//===========================================================================================================

    @FXML
    private void goToExit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views_FXML/exit.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
//===========================================================================================================  

    @FXML
    private void save(ActionEvent event) {
        try {
            int id = Integer.parseInt(tf_id.getText());
            String title = tf_title.getText();
            String author = tf_auther.getText();
            String genre = comboBox_genre.getSelectionModel().getSelectedItem();

            Book book = new Book(id, title, author, genre);
            jdbc.addBook(book);
            showDialog("Saved Successfully!,You can continue");
            clearFields();
        } catch (Exception e) {
            showDialog("Error saving book: " + e.getMessage());
        }
    }
//===========================================================================================================

    private void clearFields() {
        tf_id.setText(null);
        tf_title.setText(null);
        tf_auther.setText(null);
        ta_notes.setText(null);
        comboBox_genre.setValue(null);
        checkBox_cheched.setSelected(false);
        imageView.setImage(null);
        pane.requestFocus();// to cancel focus on item on the pane

    }

}
//===========================================================================================================
// My Name : Deema Mohammed AL-Maqadma
// ID : 2320230766
