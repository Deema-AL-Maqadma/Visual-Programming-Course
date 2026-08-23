package javafx.lec7;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;//لاستيراد جميع المطلوب بشكل اسرع
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Lec7p1 extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        
        Label lbl = new Label("ComboBox");
        //طريقة لخرى للاضافة داخل الليست
        ArrayList<String> arraylist = new ArrayList<>();
        arraylist.add("Deema");
        arraylist.add("Omar");
        arraylist.add("Ali");
        arraylist.add("Osama");
        arraylist.add("Moaz");
        ObservableList<String> list = FXCollections.observableArrayList(arraylist);
        ComboBox cb = new ComboBox(list);//قائمة منسدلة
        cb.setFocusTraversable(false);// لالغاء الفوكس عنها
        //cb.setValue(arraylist.get(3));
        cb.setValue(arraylist.get(arraylist.size()-1));// لتحديد العنصر الاخير
        //for (int i = 0; i < 10; i++) {
        //   cb.getItems().addAll(i);
        //}
        //cb.setValue(5);//لوضع قيمة افتراضية من القائمة  بشكل اولي
        
        ComboBox cb2 = new ComboBox();
        cb2.getItems().addAll("Deema", "Ali", "Omar");
        cb2.setEditable(true);//لجعلها قابلة للتعديل
        cb2.setDisable(true);// لجعلها غير مفعلة
        cb2.setVisible(false);// لاخفائها بشكل كامل اي لن تظهر عندي
        VBox root = new VBox(25, lbl, cb, cb2);
        Scene s = new Scene(root, 500, 500);
        stage.setScene(s);
        stage.show();
    }
    
}
