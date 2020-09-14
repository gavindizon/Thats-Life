package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class SettingsController {
    @FXML
    private TextField txtfield1;
    @FXML
    private TextField txtfield2;
    @FXML
    private TextField txtfield3;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button updateBtn;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    private String tempName;
    private String tempName2;
    private String tempName3;


    public SettingsController(){
    }


    @FXML
    private void initialize() throws IOException {
    }

    public void retrieveData(String name1, String name2, String name3){
        txtfield1.setText(name1);
        txtfield2.setText(name2);
        txtfield3.setText(name3);
        tempName = name1;
        tempName2 = name2;
        tempName3 = name3;
    }

    public void toMenu(ActionEvent e){
        Stage stage = (Stage) updateBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));

        if(e.getTarget() == cancelBtn){
            try {
                Parent root = (Parent) loader.load();
                Scene play = new Scene(root);
                stage.setScene(play);
                stage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            MenuController mc = loader.<MenuController>getController();
            mc.updateFromSettings(tempName, tempName2, tempName3);

        }
        else{
            try {
                Parent root = (Parent) loader.load();
                Scene play = new Scene(root);
                stage.setScene(play);
                stage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            MenuController mc = loader.<MenuController>getController();
            mc.updateFromSettings(txtfield1.getText(), txtfield2.getText(), txtfield3.getText());
        }


}
}
