package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

//    @FXML
//    private Label cash;

    @FXML private playerDescriptionController playerController;
    @FXML private TextField cashEntered;
    @FXML
    public void addCash(){
        playerController.setCash(Integer.parseInt(cashEntered.getText()));
//        System.out.println("hello");
//        System.out.println(cash.getText());
    }

}
