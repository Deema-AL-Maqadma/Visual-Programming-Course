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
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//===========================================================================================================

public class MainController implements Initializable {

    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_title;
    @FXML
    private TextField tf_author;
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
    private TableView<Book> table;
    @FXML
    private TableColumn<Book, Integer> col_id;
    @FXML
    private TableColumn<Book, String> col_title;
    @FXML
    private TableColumn<Book, String> col_author;
    @FXML
    private TableColumn<Book, String> col_genre;
    private TextField tf_search;
    @FXML
    private Button btn_profile;
    @FXML
    private Button btn_save;
    @FXML
    private Button btn_delet;
    @FXML
    private Button btn_new;
    @FXML
    private Button btn_exit;
    @FXML
    private Button btn_search;
    @FXML
    private AnchorPane pane;
//===========================================================================================================
    private ObservableList<Book> list;
    private JDBC jdbc;
//===========================================================================================================

    public MainController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox_genre.getItems().addAll("Book", "Novel", "Story", "Magazine", "Article", "Poem");
        jdbc = new JDBC();
        setupTable();
        loadBooks();
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

    private void setupTable() {
        // إعداد الأعمدة وربطها بالخصائص
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));

    }
//===========================================================================================================

    private void loadBooks() {
        list = jdbc.getAllBooks();
        table.setItems(list);
    }
//===========================================================================================================

    private Book getData() {
        int id = Integer.parseInt(tf_id.getText());
        String title = tf_title.getText();
        String auther = tf_author.getText();
        String genre = comboBox_genre.getSelectionModel().getSelectedItem();
        return new Book(id, title, auther, genre);
    }
//===========================================================================================================

    // Action on Upload Book Cover button
    @FXML
    private void ChoosePhoto(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle((VP_FinalProject.title));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
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
    private void goToProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views_FXML/personal_profile.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
//===========================================================================================================

    @FXML
    private void goToExit(ActionEvent event) throws IOException {
        jdbc.closeConnection(); // close the Database
        Parent root = FXMLLoader.load(getClass().getResource("/Views_FXML/exit.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
//===========================================================================================================
    // Action on Search button

    @FXML
    private void search(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Search Book");
        dialog.setHeaderText("Enter Book ID");
        dialog.setContentText("ID:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(idStr -> {
            try {
                int id = Integer.parseInt(idStr);
                Book book = jdbc.searchBook(id);
                if (book != null) {
                    tf_id.setText(String.valueOf(book.getId()));
                    tf_title.setText(book.getTitle());
                    tf_author.setText(book.getAuthor());
                    comboBox_genre.setValue(book.getGenre());
                } else {
                    this.showDialog("Book Not Found!");
                }
            } catch (Exception e) {
                showDialog("Please enter a valid number for ID!");
            }
        });
    }
//===========================================================================================================
    // Action on Save button

    @FXML
    private void saveBook(ActionEvent event) {
        try {
            Book book = this.getData();
            jdbc.addBook(book);
            list.add(book);
            this.showDialog("Saved Successfully! ,You can continue");
            this.clear(event);
        } catch (Exception e) {
            showDialog("Error saving book: " + e.getMessage());
        }
    }
//=========================================================================================================== 
    // Action on Delete button

    @FXML
    private void deleteBook(ActionEvent event) {
        Book selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                jdbc.deleteBook(selected.getId());
                list.remove(selected);
                this.showDialog("Deleted Successfully! ,You can continue");
                this.clear(event);
            } catch (Exception e) {
                showDialog("Please select a book to delete");
            }
        }
    }
//===========================================================================================================
    // Action on New button

    @FXML
    private void clear(ActionEvent event) {
        tf_id.setText(null);
        tf_title.setText(null);
        tf_author.setText(null);
        comboBox_genre.setValue(null);
        comboBox_genre.getSelectionModel().clearSelection();
        checkBox_cheched.setSelected(false);
        imageView.setImage(null);
        // to prevent focus on combobox
        comboBox_genre.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? comboBox_genre.getPromptText() : item);
            }
        });

        pane.requestFocus();// to cancel focus on item on the pane
    }
//===========================================================================================================
    // Action on Mouse Clicked

    @FXML
    private void getSelecteed(MouseEvent event) {
        Book selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            tf_id.setText(String.valueOf(selected.getId()));
            tf_title.setText(selected.getTitle());
            tf_author.setText(selected.getAuthor());
            comboBox_genre.setValue(selected.getGenre());
        }
    }
}
//===========================================================================================================
// My Name : Deema Mohammed AL-Maqadma
// ID : 2320230766
