package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import phase1.*;
public class Controller implements Initializable {

//    @FXML
//    private Label cash;

    @FXML private TextField cashEntered;
    @FXML private AnchorPane rootPane;
    private Player[] players;

    public Controller(){

    }


    public void addCash(){
        //    playerController.setCash(Integer.parseInt(cashEntered.getText()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initPlayers(String[] players) throws IOException{
        this.players = new Player[players.length];

        for(int i = 0; i < players.length; i++)
            this.players[i] = new Player(players[i]);

        for(int i = 0; i < players.length; i++){
            FXMLLoader playerDesc = new FXMLLoader(getClass().getResource("playerDescription.fxml"));
            Parent root = (Parent) playerDesc.load();

            root.setLayoutY(150 * i);
            playerDescriptionController playerController = (playerDescriptionController) playerDesc.<playerDescriptionController>getController();
            playerController.setName(players[i]);
            rootPane.getChildren().addAll(root);
        }

    }

}
