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
import javafx.scene.control.RadioButton;
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

//    @FXML private TextField cashEntered;
@FXML private AnchorPane rootPane;
    @FXML private AnchorPane boardPane;
//    @FXML private TextField nameEntered;
    @FXML private Parent[] root;
    @FXML private Button payBtn;
    @FXML private Button drawBtn;
    public FXMLLoader[] playerDesc;
    @FXML private boardController boardController;
    @FXML private Label txtUpdates;
    @FXML private AnchorPane ap;
    private Game game;
    private int turn = 0;
    private int playerIndex = 0;
    private String chosenPlayerName;

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
//            playerController.getPlayerPane().setStyle("-fx-background-color:blue");
            updatePlayerCardColor();
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

            txtUpdates.setText(currPlayer.getName() + " spinned for "+ game.move(currPlayer));
            boardController.updateBoardState(game);

            currPlayer.drawCard(game.getActionDeck());

            FXMLLoader card = renderCard();

            cardContainerController cardControl = (cardContainerController) card.<cardContainerController>getController();
            cardControl.setCard(currPlayer.getDrawnCard());

            activateCard(currPlayer);
            updatePlayerDetails();

            turn++;
            this.playerIndex = this.turn % game.getNumPlayers();
//            playerController = (playerDescriptionController) playerDesc[this.playerIndex].<playerDescriptionController>getController();


        }
    }
    
    private void updatePlayerDetails(){
        playerDescriptionController playerController;
        // update every player details
        for(int i = 0; i < game.getNumPlayers(); i++){
            playerController = (playerDescriptionController) playerDesc[i].<playerDescriptionController>getController();
            playerController.setPlayerDetails(game.getPlayer(i));
            System.out.println(game.getPlayer(i).toString());
        }
    }

    private void updatePlayerCardColor(){
        playerDescriptionController playerController;
        // update every player details
        for(int i = 0; i < game.getNumPlayers(); i++){
            playerController = (playerDescriptionController) playerDesc[i].<playerDescriptionController>getController();

            if(i == this.playerIndex){
                playerController.getPlayerPane().setStyle("-fx-background-color:blue");
            }
            else{
                playerController.getPlayerPane().setStyle("-fx-background-color:pink");
            }
        }
    }

    private void activateCard(Player currPlayer) throws IOException {
//        Player[] = game.getPlayers();
        ActionCard drawnCard = (ActionCard)currPlayer.getDrawnCard();
        if(drawnCard instanceof PayPlayer || drawnCard instanceof CollectFromPlayer){
            if(drawnCard.getToAll()){
                drawnCard.activate(game.getPlayers(), this.playerIndex);
            } else{
                System.out.println("Choose Player: ");
                choosePlayers(drawnCard, currPlayer);

            }
        }
        else{
            drawnCard.activate(game.getPlayers(), this.playerIndex);
        }

    }

    private void choosePlayers(ActionCard drawnCard, Player currPlayer) throws IOException {
        String playerName = "";
        Popup popup = new Popup();
        FXMLLoader choose = new FXMLLoader(getClass().getResource("choosePlayerPopUp.fxml"));
        Parent root = (Parent) choose.load();
        popup.getContent().add(root);
        choosePlayerPopUpController cpCont = (choosePlayerPopUpController) choose.<choosePlayerPopUpController>getController();
        cpCont.generateChoices(game.getPlayers(), currPlayer);
        Stage stage = (Stage) rootPane.getScene().getWindow();
        popup.show(stage);


        //confirm button action
        cpCont.getConfirm().setOnAction(e->{
            RadioButton[] radios;
            radios = cpCont.getRadios();
            for(RadioButton r : radios){
                if(r.isSelected()){
                        System.out.println(r.getText());
                        setName(r.getText());
                        Player[] temp = new Player[2];
                        int otherPlayerIndex = game.getPlayerByName(this.chosenPlayerName);
                        System.out.println("Chosen player: " + this.chosenPlayerName);
                        temp[0] = game.getPlayer(otherPlayerIndex) ;
                        temp[1] = currPlayer;
                        try{
                            drawnCard.activate(temp, 1);
                        } catch (Exception x){
                            System.out.println("error" + drawnCard.getDescription());
                        }
                        popup.hide();
                        updatePlayerDetails();


                }
            }
        });
    }



    private String getChosenPlayerName(){
        return this.chosenPlayerName;
    }

    private void setName(String s){
        this.chosenPlayerName = s;
    }

    private void doSomething(Player p){
        System.out.println(p.getName());
    }


    private FXMLLoader renderCard() throws IOException {
        FXMLLoader card = new FXMLLoader(getClass().getResource("cardContainer.fxml"));
        Parent root = (Parent) card.load();
        root.setLayoutY(450);
        rootPane.getChildren().addAll(root);

        return card;
    }



    public void initPlayers(String[] players) throws IOException{

        game = new Game (players.length, players);
        boardController.initSpaceColor(game);

        this.root = new Parent[game.getNumPlayers()];
        int numPlayers = game.getNumPlayers();
//        this.players = new Player[numPlayers];
        playerDesc = new FXMLLoader[numPlayers];

        for(int i = numPlayers -1; i >= 0; i--)
            initCareers(game.getPlayer(i));



    }


    public void initCareers(Player p) throws IOException{
        System.out.println(p.getName());
        Popup popup = new Popup();
        FXMLLoader popChoose = new FXMLLoader(getClass().getResource("choosePathPopUp.fxml"));
        Parent root = (Parent) popChoose.load();
        popup.getContent().add(root);
        choosePathPopUpController cpCont = (choosePathPopUpController) popChoose.<choosePathPopUpController>getController();
        cpCont.setPlayerText(p);

        Stage stage = (Stage) rootPane.getScene().getWindow();
        popup.show(stage);

        cpCont.getConfirm().setOnAction(e ->{
            System.out.println(cpCont.getValue());

            p.chooseStartingPath(game.getSalaryDeck(), game.getCareerDeck(), cpCont.getValue());
            game.initializeStart(p);
            boardController.updateBoardState(game);

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


//            playerDescriptionController playerController = (playerDescriptionController) playerDesc[0].<playerDescriptionController>getController();
//            playerController.getPlayerPane().setStyle("-fx-background-color:blue");
            try {
                renderCard();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            updatePlayerCardColor();
        });
    }


}
