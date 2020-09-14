package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import phase1.*;
public class Controller implements Initializable {

//    @FXML
//    private Label cash;

    @FXML private playerDescriptionController playerController;
    @FXML private TextField cashEntered;
    @FXML private AnchorPane rootPane;
    private Player[] players;

    public Controller(){
        players = new Player[2];
        players[0] = new Player("Tyrone");
        players[1] = new Player("Gavin");
    }


    public void addCash(){
        playerController.setCash(Integer.parseInt(cashEntered.getText()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initPlayers();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void initPlayers() throws IOException {


        for(int i = 0; i < 1; i++){
            AnchorPane pane = FXMLLoader.load(getClass().getResource("playerDescription.fxml"));
            pane.setLayoutY(150 * i);
            rootPane.getChildren().addAll(pane);

        }


    }
}
