
package javafx.lec9;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Project1_LoginPageController implements Initializable {

    // ID for text field & button
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private Button btnLogin;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    // ميثود يتم تنفذها عند الضغط على الزر دون الحاجة لكتابة الاكشن فقط اكتب شو بدي يعمل وهينفذ لحاله
    @FXML
    private void btn_test () throws IOException{
        // انشات ستيج جديدة وحملت الملف الجديد عشان الواجهة الجديدة تظهر عندي
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
        Parent root = loader.load();
        WelcomeController c = loader.getController(); //حملت الملف على الصفحة عندي الان الوصول لها من اللود والكنترولر هيحمل ملف البرمجة تبع هاي الواجهة 
        c.masg(tf1.getText());// ارسال المسج للميثود المطلوبة
        stage.setScene(new Scene(root));
        stage.show();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // عملية التحقق من الادخال فالنص المدخل داخل الحقل Validation
//        if(tf1.getText().equals("deema")&&tf2.getText().equals("deema")){
//            btnLogin.setText("Done!");//تغيير النص المكتوب على الزر بعد التحقق يعني التحقق قبل تنفيذ عملية معينة
//        
    }
//        tf1.setText("Test");
//        tf2.setText("Data");
//        System.out.println("Test Data ...");
    }
    
