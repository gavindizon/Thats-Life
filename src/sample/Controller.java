package sample;
//import javafx.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import phase1.*;
import phase1.Cards.ActionCard.ActionCard;
import phase1.Cards.ActionCard.CollectFromPlayer;
import phase1.Cards.ActionCard.PayPlayer;
import phase1.Cards.BlueCard.BlueCard;
import phase1.Cards.BlueCard.NormalAction;
import phase1.Cards.BlueCard.RandomAction;
import phase1.Cards.Card;

public class Controller implements Initializable {

//    @FXML
//    private Label cash;

    @FXML private AnchorPane rootPane;
    @FXML private AnchorPane gameScreen;
    @FXML private Parent[] root;
    @FXML private Button payBtn;
    @FXML private Button exitBtn;

    public FXMLLoader[] playerDesc;

    @FXML private boardController boardController;
    @FXML private Label txtUpdates;

    private AnchorPane overlay = new AnchorPane();

    private VBox descPlayers = new VBox();
    private FXMLLoader card;
    private Game game;
    private int turn = 0;
    private int playerIndex = 0;
    private String chosenPlayerName;

//    private Player[] players;

    public Controller(){
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        payBtn.setDisable(true);
        overlay.setTranslateZ(2);
        overlay.prefHeight(1024);
        overlay.prefWidth(768);
        overlay.setMinHeight(768);
        overlay.setMinWidth(1024);
        overlay.setStyle("-fx-background-color: rgba(0,0,0,0.7); -fx-opacity: 1");

    }


    public void gameState(ActionEvent e) throws IOException {

        if(!game.gameOver()){
            playerDescriptionController playerController = (playerDescriptionController) playerDesc[this.playerIndex].<playerDescriptionController>getController();
//            playerController.getPlayerPane().setStyle("-fx-background-color:blue");
            updatePlayerCardColor();
            Player currPlayer = game.getPlayer(this.playerIndex);

            if(!currPlayer.getIsRetired()){
                //PLAYER PAY LOAN BUTTON
                if(currPlayer.getLoan() > 0 && currPlayer.getLoan() <= currPlayer.getCash()){
//                    System.out.println(currPlayer.getName()+ " Player has loan");
                    payBtn.setDisable(false);

                    playerDescriptionController finalPlayerController = playerController;
                    payBtn.setOnAction(ex->{
                        currPlayer.payLoan();
                        finalPlayerController.setPlayerDetails(currPlayer);
                    });
                }
                else{
//                    System.out.println(currPlayer.getName() + " Player has no loan");

                    payBtn.setDisable(true);
                }

                txtUpdates.setText(currPlayer.getName() + " spinned for "+ game.move(currPlayer));
                boardController.updateBoardState(game);
                boardController.boardAction(game, this.playerIndex, this);

                card = renderCard();

                try{
                    cardContainerController cardControl = (cardContainerController) card.<cardContainerController>getController();
                    cardControl.setCard(currPlayer.getDrawnCard(), game.getSpaces()[currPlayer.getSpaceTracker()]);
//                    System.out.println(currPlayer.getDrawnCard().getDescription());
                } catch (Exception ex){
                    System.out.println("error");
                }

                updatePlayerDetails();

            }

            turn++;
            this.playerIndex = this.turn % game.getNumPlayers();


        }else{
            endGame();
        }
    }
    
    private void updatePlayerDetails(){
        playerDescriptionController playerController;
        // update every player details
        for(int i = 0; i < game.getNumPlayers(); i++){
            playerController = (playerDescriptionController) playerDesc[i].<playerDescriptionController>getController();
            playerController.setPlayerDetails(game.getPlayer(i));
//            System.out.println(game.getPlayer(i).toString());
        }
    }

    private void updatePlayerCardColor(){
        playerDescriptionController playerController;
        // update every player details
        for(int i = 0; i < game.getNumPlayers(); i++){
            playerController = (playerDescriptionController) playerDesc[i].<playerDescriptionController>getController();

            if(i == this.playerIndex){
                playerController.getPlayerPane().setStyle("-fx-background-color:blue; -fx-border-color: #FFF; -fx-border-width: 2;");
            }
            else{
                playerController.getPlayerPane().setStyle("-fx-background-color:pink");
            }
        }
    }

    public void activateCard(Player currPlayer) throws IOException {
//        Player[] = game.getPlayers();
        Card drawnCard = currPlayer.getDrawnCard();

        if(drawnCard instanceof ActionCard){
            ActionCard actionCard = (ActionCard) drawnCard;
            if(drawnCard instanceof PayPlayer || drawnCard instanceof CollectFromPlayer){
                if(actionCard.getToAll()){
                    actionCard.activate(game.getPlayers(), this.playerIndex);
                } else{
                    System.out.println("Choose Player: ");
                    choosePlayers(actionCard, currPlayer);

                }
            }
            else{
                actionCard.activate(game.getPlayers(), this.playerIndex);
            }
        } else if(drawnCard instanceof BlueCard){
            BlueCard blueCard = (BlueCard) drawnCard;
            if(blueCard instanceof RandomAction){
                generateRandomNum(blueCard, currPlayer);
            } else if (blueCard instanceof NormalAction){
                ((NormalAction) blueCard).activate(currPlayer, game.getPlayers());
            }
        }

    }

    private void generateRandomNum(BlueCard blueCard, Player currPlayer) throws IOException {
        Popup popup = new Popup();
        gameScreen.getChildren().add(overlay);
        try{

            FXMLLoader random = new FXMLLoader(getClass().getResource("randomGenPopup.fxml"));
            Parent root = (Parent) random.load();
            popup.getContent().add(root);
            Stage stage = (Stage) rootPane.getScene().getWindow();
            popup.show(stage);

            RandomGenPopup randomGenPopup = (RandomGenPopup) random.<RandomGenPopup>getController();

            randomGenPopup.getSpinButt().setOnAction(event->{
                randomGenPopup.getSpinButt().setText(Integer.toString(Game.spinWheel()));
                randomGenPopup.getSpinButt().setDisable(true);
            });

            randomGenPopup.getDoneButt().setOnAction(event->{
                int randomNum = Integer.parseInt(randomGenPopup.getSpinButt().getText());
                ((RandomAction)blueCard).activate(currPlayer, game.getPlayers(), randomNum);
                popup.hide();
                gameScreen.getChildren().remove(overlay);

            });
//            popup.hide();
        }catch(IOException e){
            e.printStackTrace();
        }

    }




    private void choosePlayers(ActionCard drawnCard, Player currPlayer) throws IOException {
        String playerName = "";
        Popup popup = new Popup();
        choosePlayerPopUpController cpCont = initPopup(popup);
        if(!gameScreen.getChildren().contains(overlay))
            gameScreen.getChildren().add(overlay);
            cpCont.getTextLabel().setText("Choose Player: ");
        cpCont.generateChoices(game.getPlayers(), currPlayer);

        RadioButton[] radios;
        radios = cpCont.getRadios();
        if(radios[0] != null){
            cpCont.getConfirm().setOnAction(e->{
                for(RadioButton r : radios){
                    if(r.isSelected()){
                            System.out.println(r.getText());
                            setName(r.getText());
                            Player[] temp = new Player[2];
                            int otherPlayerIndex = game.getPlayerByName(this.chosenPlayerName);
                            temp[0] = game.getPlayer(otherPlayerIndex) ;
                            temp[1] = currPlayer;
                            try{
                                drawnCard.activate(temp, 1);
                            } catch (Exception x){
                                System.out.println("error" + drawnCard.getDescription());
                            }
                            gameScreen.getChildren().remove(overlay);
                            popup.hide();
                            updatePlayerDetails();
                    }
                }
            });
        } else{
            gameScreen.getChildren().remove(overlay);
            popup.hide();
        }
    }



    private String getChosenPlayerName(){
        return this.chosenPlayerName;
    }

    private void setName(String s){
        this.chosenPlayerName = s;
    }


    private FXMLLoader renderCard() throws IOException {
        FXMLLoader card = new FXMLLoader(getClass().getResource("cardContainer.fxml"));
        Parent root = (Parent) card.load();
        root.setLayoutY(525);
        rootPane.getChildren().addAll(root);

        return card;
    }



    public void initPlayers(String[] players) throws IOException{

        game = new Game (players.length, players);
        boardController.initSpaceColor(game);

        this.root = new Parent[game.getNumPlayers()];
        int numPlayers = game.getNumPlayers();
        playerDesc = new FXMLLoader[numPlayers];
        rootPane.getChildren().add(descPlayers);
       // gameScreen.getChildren().add(overlay);


        System.out.println(gameScreen.getChildren().toString());
        for(int i = numPlayers -1; i >= 0; i--){
            initCareers(game.getPlayer(i), i);
        }
    }
    public void initCareers(Player p, int count) throws IOException{
        String[] choices = new String[]{"Career", "College"};
        System.out.println(p.getName());

        Popup popup = new Popup();

        choosePlayerPopUpController cpCont = initPopup(popup);

        cpCont.getTextLabel().setText("Choose path for: " + p.getName());
        cpCont.generateChoices(choices);

        cpCont.getConfirm().setOnAction(e ->{
            descPlayers.getChildren().clear();
            RadioButton[] radio = cpCont.getRadios();
            for(int i = 0; i < radio.length; i++){
                if(radio[i].isSelected()){
//                    System.out.println(radio[i].isSelected());
                    p.chooseStartingPath(game.getSalaryDeck(), game.getCareerDeck(), i);
                }
            }

            game.initializeStart(p);
            boardController.updateBoardState(game);

            System.out.println(p.getCareer());
            popup.hide();

            for(int i = 0; i < game.getNumPlayers(); i++){
                playerDesc[i] = new FXMLLoader(getClass().getResource("playerDescription.fxml"));
                //                try {
//                    this.root[i] = (Parent) playerDesc[i].load();
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//
//                this.root[i].setLayoutY(125 * i);
                try {
                    descPlayers.getChildren().add((Parent) playerDesc[i].load());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                playerDescriptionController playerController = (playerDescriptionController) playerDesc[i].<playerDescriptionController>getController();
                playerController.setPlayerDetails(game.getPlayer(i));
            }


            try {
                card = renderCard();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            updatePlayerCardColor();
            if(count == game.getNumPlayers() - 1)
                gameScreen.getChildren().remove(overlay);
        //    System.out.println(gameScreen.getChildren().toString());


        });


    }

    public AnchorPane getRootPane() {
        return rootPane;
    }

    private choosePlayerPopUpController initPopup(Popup popup) throws IOException {
        try{
            FXMLLoader popChoose = new FXMLLoader(getClass().getResource("choosePlayerPopUp.fxml"));
            Parent root = (Parent) popChoose.load();
            popup.getContent().add(root);
            choosePlayerPopUpController cpCont = (choosePlayerPopUpController) popChoose.<choosePlayerPopUpController>getController();
            Stage stage = (Stage) rootPane.getScene().getWindow();

            if(!(gameScreen.getChildren().contains(overlay)))
                gameScreen.getChildren().add(overlay);

            popup.show(stage);
            return cpCont;

        } catch (IOException e){
            System.out.println("FXML File not found");
            e.printStackTrace();
        }
        return null;

    }

    public void exit(ActionEvent ae) {
        Stage stage = (Stage)  exitBtn.getScene().getWindow();
        FXMLLoader menu = new FXMLLoader(getClass().getResource("menu.fxml"));

            try {
                Parent root = (Parent) menu.load();
                Scene play = new Scene(root);
                stage.setScene(play);
                stage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            MenuController mc = menu.<MenuController>getController();

            if(game.getNumPlayers() == 2)
                mc.updateFromGame(game.getPlayer(0).getName(), game.getPlayer(1).getName());
            else
                mc.updateFromGame(game.getPlayer(0).getName(), game.getPlayer(1).getName(), game.getPlayer(2).getName());
    }

    public void endGame() throws IOException{
        Popup popup = new Popup();

        updatePlayerDetails();
        game.rankPlayers();

            FXMLLoader random = new FXMLLoader(getClass().getResource("endGame.fxml"));
            Parent root = (Parent) random.load();
            popup.getContent().add(root);
            Stage stage = (Stage) rootPane.getScene().getWindow();
            popup.show(stage);

            endGameController egc = (endGameController) random.<endGameController>getController();
            egc.listResult(game.getPlayers());
            egc.endBtn.setOnAction(e ->{
                popup.hide();
                exit(e);
        });



    }


}
