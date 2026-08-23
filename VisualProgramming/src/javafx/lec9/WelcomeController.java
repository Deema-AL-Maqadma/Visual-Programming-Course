
package javafx.lec9;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
// التحكم يكون في الكونترولر
public class WelcomeController implements Initializable {

    @FXML
    private Label lbl;
 
   // ميثود همرر لها الداتا واعطيه للليبل الفارغ
    public void masg(String data){
        lbl.setText(data);
        lbl.setTextFill(Color.RED);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
