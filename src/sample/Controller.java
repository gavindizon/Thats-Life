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
    @FXML private TextField nameEntered;
    public FXMLLoader[] playerDesc;
    private Player[] players;

    public Controller(){
    }


    @FXML
    public void addCash() throws IOException {
        int i = 0;
        for(Player p : players){
            if(p.getName().equals(nameEntered.getText())){
                System.out.println(p.getName());
                System.out.println(p.getCash());
                playerDescriptionController playerController = (playerDescriptionController) playerDesc[i].<playerDescriptionController>getController();
                playerController.setCash(Integer.parseInt(cashEntered.getText()), p);
            }
            i++;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initPlayers(String[] players) throws IOException{
        this.players = new Player[players.length];
        playerDesc = new FXMLLoader[players.length];

        for(int i = 0; i < players.length; i++)
            this.players[i] = new Player(players[i]);

        for(int i = 0; i < players.length; i++){
            playerDesc[i] = new FXMLLoader(getClass().getResource("playerDescription.fxml"));
            Parent root = (Parent) playerDesc[i].load();

            root.setLayoutY(150 * i);
            playerDescriptionController playerController = (playerDescriptionController) playerDesc[i].<playerDescriptionController>getController();
            playerController.setPlayerDetails(this.players[i]);
            rootPane.getChildren().addAll(root);
        }

    }

}
