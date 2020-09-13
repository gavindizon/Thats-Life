package sample;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MenuController {

    public Button opt0;
    public Button opt1;
    public Button opt2;
    // location and resources will be automatically injected by the FXML loader
    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    public MenuController(){}

    @FXML
    private void initialize()
    {
    }


    @FXML
    public void menuOptions(ActionEvent e){
        Stage stage = (Stage) opt2.getScene().getWindow();
        if(e.getTarget() == opt0)
            initNames(2);
        else if(e.getTarget() == opt1)
            initNames(3);
        else
            stage.close();
    }

    private void initNames(int numOfPlayers){
        //fxmlloader
        

    }


}
