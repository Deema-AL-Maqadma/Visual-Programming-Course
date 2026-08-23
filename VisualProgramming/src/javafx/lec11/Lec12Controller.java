package javafx.lec11;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Lec12Controller implements Initializable {

    @FXML
    private TableColumn<Student, Integer> id;
    @FXML
    private TableColumn<Student, String> fn;
    @FXML
    private TableColumn<Student, String> ln;
    @FXML
    private TableColumn<Student, String> mob;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfFn;
    @FXML
    private TextField tfLn;
    @FXML
    private TextField tfMob;
    @FXML
    private Button add_btn;
    @FXML
    private Button edit_btn;
    @FXML
    private Button delete_btn;
    @FXML
    private TableView<Student> table;

    int index;
    ObservableList<Student> list;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // يلي ما عندوبنادي عليه داخل الانشيالايز
        createStudent();
        fill_table();
    }

    private void createStudent() {
        ArrayList<Student> list_student = new ArrayList<>();
        list_student.add(new Student(1, "Deema", "Mohammed", "AL-Maqadma"));
        list_student.add(new Student(2, "Omar", "Mohammed", "AL-Hour"));
        list_student.add(new Student(3, "Eman", "Mohammed", "AL-Haj"));
        list_student.add(new Student(4, "Ali", "Mohammed", "AL-Qasem"));
        list = FXCollections.observableArrayList(list_student);

    }

    private void fill_table() {
        table.setItems(list);
        id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        fn.setCellValueFactory(new PropertyValueFactory<Student, String>("fn"));
        ln.setCellValueFactory(new PropertyValueFactory<Student, String>("ln"));
        mob.setCellValueFactory(new PropertyValueFactory<Student, String>("mobile"));
    }

    @FXML // عند التاشير بالماوس
    private void getSelecteed() {
        index = table.getSelectionModel().getSelectedIndex();
        if (index < -1) {
            return;
        }
        tfid.setText(id.getCellData(index).toString());
        tfFn.setText(fn.getCellData(index).toString());
        tfLn.setText(ln.getCellData(index).toString());
        tfMob.setText(mob.getCellData(index).toString());
    }

    @FXML
    private void addStudent(ActionEvent event) {
        list.add(getData());
    }

    @FXML
    private void editStudent(ActionEvent event) {
        list.set(index, getData());

    }

    private Student getData() {
        Integer id = Integer.parseInt((tfid.getText()));
        String fn = tfFn.getText();
        String ln = tfLn.getText();
        String mob = tfMob.getText();
        return new Student(id, fn, ln, mob);

    }

    @FXML
    private void deleteStudent(ActionEvent event) {
        if (index <= -1) {
            return;
        }
        table.getItems().remove(index);
        index = -1;
        tfFn.clear();
        tfLn.clear();
        tfMob.clear();
        tfid.clear();
    }

}
