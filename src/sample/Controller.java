package sample;
//import javafx.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import phase1.*;
import phase1.Cards.*;
public class Controller implements Initializable {

//    @FXML
//    private Label cash;

    @FXML private TextField cashEntered;
    @FXML private AnchorPane rootPane;
    @FXML private TextField nameEntered;
    @FXML private Parent[] root;
    public FXMLLoader[] playerDesc;


    private Game game;
    private int turn = 0;
    private int playerIndex = 0;


//    private Player[] players;

    public Controller(){
    }


    @FXML
    public void addCash(Player p, double cash ) throws IOException {

        playerDescriptionController playerController = (playerDescriptionController) playerDesc[playerIndex].<playerDescriptionController>getController();
        playerController.setCash(cash,p);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void gameState(ActionEvent e) throws IOException {

        if(!game.gameOver()){
            playerDescriptionController playerController = (playerDescriptionController) playerDesc[this.playerIndex].<playerDescriptionController>getController();
            playerController.getPlayerPane().setStyle("-fx-background-color:pink");
            Player currPlayer = game.getPlayer(this.playerIndex);
            currPlayer.drawCard(game.getActionDeck());

            FXMLLoader card = renderCard();

            cardContainerController cardControl = (cardContainerController) card.<cardContainerController>getController();
            cardControl.setCard(currPlayer.getDrawnCard());

            System.out.println(this.playerIndex);
            activateCard(currPlayer);

            addCash(currPlayer, ((ActionCard)currPlayer.getDrawnCard()).getValue());

            turn++;
            this.playerIndex = this.turn % game.getNumPlayers();
            playerController = (playerDescriptionController) playerDesc[this.playerIndex].<playerDescriptionController>getController();
            playerController.getPlayerPane().setStyle("-fx-background-color:blue");
//            playerController.getPlayerPane().setOpacity(0.8);


        }
    }

    private void activateCard(Player currPlayer){
//        if(currPlayer.getDrawnCard() instanceof PayPlayer){
            System.out.println("Choose players: ");
            activateChoosePlayers();
//            System.out.println("Player chosen: " + game.getPlayer(x).toString());
//        }
    }

    private void activateChoosePlayers(){
        for (int i = 0; i < game.getNumPlayers(); i++){
            if(i != this.playerIndex){
                playerDescriptionController playerController = (playerDescriptionController) playerDesc[i].<playerDescriptionController>getController();
//                index = i;
                root[i].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
//                    int x = i;
                    @Override
                    public void handle(MouseEvent e) {
                        String name = playerController.getName().getText();
                        Player p = game.getPlayerByName(name);

                        //TODO: search player by name @see game
                        if(p != null){
                            System.out.println("xD");
                            doSomething(p);
//                            index = i;
//                            return i;
                        }
                    }

                });
            }

        }

    }
    private void doSomething(Player p){
        System.out.println(p.getName());
    }


    private FXMLLoader renderCard() throws IOException {
        FXMLLoader card = new FXMLLoader(getClass().getResource("cardContainer.fxml"));
        Parent root = (Parent) card.load();
        root.setLayoutY(400);
        rootPane.getChildren().addAll(root);

        return card;
    }



    public void initPlayers(String[] players) throws IOException{
        game = new Game (players.length, players);
        root = new Parent[game.getNumPlayers()];
        int numPlayers = game.getNumPlayers();
//        this.players = new Player[numPlayers];
        playerDesc = new FXMLLoader[numPlayers];

//        for(int i = 0; i < numPlayers; i++)
//            this.players[i] = new Player(players[i]);

        for(int i = 0; i < numPlayers; i++){
            playerDesc[i] = new FXMLLoader(getClass().getResource("playerDescription.fxml"));
            root[i] = (Parent) playerDesc[i].load();

            root[i].setLayoutY(150 * i);
            playerDescriptionController playerController = (playerDescriptionController) playerDesc[i].<playerDescriptionController>getController();
            playerController.setPlayerDetails(game.getPlayer(i));
            rootPane.getChildren().addAll(root[i]);


        }
        playerDescriptionController playerController = (playerDescriptionController) playerDesc[0].<playerDescriptionController>getController();
        playerController.getPlayerPane().setStyle("-fx-background-color:blue");
        renderCard();


    }

}
