package sample;
//import javafx.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import phase1.*;
import phase1.Cards.*;
public class Controller implements Initializable {

//    @FXML
//    private Label cash;

    @FXML private TextField cashEntered;
    @FXML private AnchorPane rootPane;
    @FXML private TextField nameEntered;
    @FXML private Parent[] root;
    @FXML private Button payBtn;
    public FXMLLoader[] playerDesc;
    public FXMLLoader choosePath;

    @FXML private AnchorPane ap;
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
        payBtn.setDisable(true);
    }


    public void gameState(ActionEvent e) throws IOException {

        if(!game.gameOver()){
            playerDescriptionController playerController = (playerDescriptionController) playerDesc[this.playerIndex].<playerDescriptionController>getController();
            playerController.getPlayerPane().setStyle("-fx-background-color:blue");
            Player currPlayer = game.getPlayer(this.playerIndex);

            //PLAYER PAY LOAN BUTTON
            if(currPlayer.getLoan() > 0 && currPlayer.getLoan() <= currPlayer.getCash()){
                System.out.println(currPlayer.getName()+ " Player has loan");
                payBtn.setDisable(false);

                playerDescriptionController finalPlayerController = playerController;
                payBtn.setOnAction(ex->{
                    currPlayer.payLoan();
                    finalPlayerController.setPlayerDetails(currPlayer);
                });
            }
            else{
                System.out.println(currPlayer.getName() + " Player has no loan");

                payBtn.setDisable(true);
            }
            currPlayer.drawCard(game.getActionDeck());

            FXMLLoader card = renderCard();

            cardContainerController cardControl = (cardContainerController) card.<cardContainerController>getController();
            cardControl.setCard(currPlayer.getDrawnCard());



            System.out.println(this.playerIndex);
            activateCard(currPlayer);

         //   addCash(currPlayer, ((ActionCard)currPlayer.getDrawnCard()).getValue());

            playerController.setPlayerDetails(currPlayer);
            turn++;
            this.playerIndex = this.turn % game.getNumPlayers();
            playerController = (playerDescriptionController) playerDesc[this.playerIndex].<playerDescriptionController>getController();
            playerController.getPlayerPane().setStyle("-fx-background-color:pink");
//            playerController.getPlayerPane().setOpacity(0.8);




        }
    }

    private void activateCard(Player currPlayer){

        if(currPlayer.getDrawnCard() instanceof PayPlayer || currPlayer.getDrawnCard() instanceof CollectFromPlayer ){
            System.out.println("Choose players: ");
            int x = activateChoosePlayers();
            System.out.println("Player chosen: " + game.getPlayer(x).toString());
        }else{
            if(currPlayer.getDrawnCard() instanceof CollectFromBank){
                System.out.println("X");
                ((CollectFromBank) currPlayer.getDrawnCard()).activate(currPlayer);
            }else{
                System.out.println("X");
                ((PayBank) currPlayer.getDrawnCard()).activate(currPlayer);

            }
        }
    }

    private int activateChoosePlayers(){
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
        return 0;
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
        this.root = new Parent[game.getNumPlayers()];
        int numPlayers = game.getNumPlayers();
//        this.players = new Player[numPlayers];
        playerDesc = new FXMLLoader[numPlayers];

        for(int i = numPlayers -1; i >= 0; i--)
            initCareers(game.getPlayer(i));

 //       System.out.println("Alakazam");


    }


    public void initCareers(Player p) throws IOException{
        System.out.println(p.getName());
        Popup popup = new Popup();
        FXMLLoader popChoose = new FXMLLoader(getClass().getResource("choosePathPopUp.fxml"));
        Parent root = (Parent) popChoose.load();
        popup.getContent().add(root);
        choosePathPopUpController cpCont = (choosePathPopUpController) popChoose.<choosePathPopUpController>getController();

        Stage stage = (Stage) rootPane.getScene().getWindow();
        popup.show(stage);

        cpCont.getConfirm().setOnAction(e ->{
            System.out.println(cpCont.getValue());
            p.chooseStartingPath(game.getSalaryDeck(), game.getCareerDeck(), cpCont.getValue());
            System.out.println(p.getCareer());
            popup.hide();
            for(int i = 0; i < game.getNumPlayers(); i++){
                playerDesc[i] = new FXMLLoader(getClass().getResource("playerDescription.fxml"));
                try {
                    this.root[i] = (Parent) playerDesc[i].load();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                this.root[i].setLayoutY(125 * i);
                playerDescriptionController playerController = (playerDescriptionController) playerDesc[i].<playerDescriptionController>getController();
                playerController.setPlayerDetails(game.getPlayer(i));
                rootPane.getChildren().addAll(this.root[i]);
            }


            playerDescriptionController playerController = (playerDescriptionController) playerDesc[0].<playerDescriptionController>getController();
            playerController.getPlayerPane().setStyle("-fx-background-color:blue");
            try {
                renderCard();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

    }


}
