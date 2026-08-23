
package javafx.lec9;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Fxml_test extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent test = FXMLLoader.load(getClass().getResource("Project1_loginPage.fxml"));// انشاء Parent
        Scene s = new Scene(test); // بتاخدParent فلازم انشىء واحد اولا 
        // نعمل اكشن على سين
        s.setOnKeyPressed(e-> {
            if(e.getCode()==KeyCode.ESCAPE){
                //System.out.println("Done!"); 
                Dialog d = new Dialog();// الواجهي يلي هتنعرض عندي في حال الضغط على زر معين
                d.setTitle("Final_Project"); // العنوان العلوي
                d.setHeaderText("Exit?");// العنوان الرئيسي
                d.setContentText("Are you sure?");// المحتوى الداخلي
                
                
                // الازرار التي ساختار واحدة منها عند ظهور الواجهة
                ButtonType btnYes = new ButtonType("Yes",ButtonBar.ButtonData.YES);
                ButtonType btnNo = new ButtonType("No",ButtonBar.ButtonData.NO);
                
                d.getDialogPane().getButtonTypes().addAll(btnYes, btnNo); //اضافة الازرار للواجهة
                // validation
                if(d.showAndWait().get()==btnYes){
                    stage.close();
                    Platform.exit();
                }
            }
            if(e.getCode()==KeyCode.F){
                TextInputDialog tid = new TextInputDialog();// حقل ادخال في الواجهة الظاهرة
                tid.setTitle("Test");
                tid.setHeaderText("Find?");
                tid.setContentText("Enter your student name");
                
                tid.getEditor().setPromptText("Enter student name");//للوصول للحقل وكنابة توضيح للادخال
                tid.showAndWait();
                System.out.println("The Name : "+tid.getEditor().getText());// للوصول للحقل واستخراج النص المخزن داخله
                
                
                
            }
        });
        stage.setScene(s);
        stage.show();
        
    }
    
}
