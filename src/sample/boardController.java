package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Popup;
import javafx.stage.Stage;
import phase1.Game;
import phase1.Player;
import phase1.Spaces.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class boardController {

    @FXML
    List<TextFlow> spacesView;

    private int choice;


    public void initialize(){
        int count = 1;
        Label label = new Label("Label");

        for(TextFlow space : spacesView){
            space.setStyle("-fx-border-color: #FFF; -fx-background-color: #000;");
            for(int j = 0; j < 3; j++){
                label = (Label) space.getChildren().get(j);
                label.setText("");
            }
        }
    }

    public void initSpaceColor(Game game){
        int i = 0;
        for(TextFlow spaceView: spacesView){
            Space space = game.getSpace(i);
            if(space instanceof OrangeSpace){
                spaceView.setStyle("-fx-border-color: #FFF; -fx-background-color: #FFBC3A;");
            }else if(space instanceof MagentaSpace){
                spaceView.setStyle("-fx-border-color: #FFF; -fx-background-color: #FF00FF;");
            }else if(space instanceof GreenSpace){
                spaceView.setStyle("-fx-border-color: #FFF; -fx-background-color: #008000;");
            }else{
                spaceView.setStyle("-fx-border-color: #FFF; -fx-background-color: #ADD8E6;");
            }
            i++;
        }
    }

    public void updateBoardState(Game game){
        Label label;
        int i = 0;
        for(TextFlow spaceView : spacesView){

            Space space = game.getSpace(i);
            for(int j = 0; j < game.getNumPlayers(); j++){
                label = (Label) spaceView.getChildren().get(j);
                label.setStyle("-fx-text-fill:blue; -fx-font-weight:bold");

                try{
                    label.setText(space.getPlayers().get(j).getName());
                }catch(Exception e){
                    label.setText("");
                }
            }
            i++;
        }
    }


    public void boardAction(Game game, int currPlayerIndex, Controller gameControl) throws IOException {
        Space currSpace = game.getSpace(game.getPlayer(currPlayerIndex).getSpaceTracker());
        Player currPlayer = game.getPlayer(currPlayerIndex);
        if(currSpace instanceof OrangeSpace){
            currSpace.doAction(currPlayer, game.getPlayers(), game.getDecks(currSpace));
            System.out.println(currPlayer.getDrawnCard().getDescription());
            try{
                gameControl.activateCard(currPlayer);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(currSpace instanceof MagentaSpace){
            MagentaSpace magentaSpace = (MagentaSpace) currSpace;
            String choices[];
            if(magentaSpace instanceof ChoiceSpace){
                choices = ((ChoiceSpace) magentaSpace).getChoices(currPlayer, game.getDecks(currSpace));
                // TODO CollegeCareerChoice should pick 2 times, 1 for career, 1 for salary
                if((ChoiceSpace) magentaSpace instanceof CollegeCareerChoiceSpace){
                    String[] choice1 = Arrays.copyOfRange(choices, 0, 2);
                    String[] choice2 = Arrays.copyOfRange(choices, 2, choices.length);
                    System.out.println("xxx" + choice2[0]);
                    choosePath(currPlayer, gameControl.getRootPane(), choice2, magentaSpace, game);
                    choosePath(currPlayer, gameControl.getRootPane(), choice1, magentaSpace, game);

                } else{
                    choosePath(currPlayer, gameControl.getRootPane(), choices, magentaSpace, game);
//                    magentaSpace
                }

            } else{
                ((NoChoiceSpace) magentaSpace).doMagentaAction(currPlayer, game.getPlayers(), game.getDecks(magentaSpace));
            }
        } else {
            currSpace.doAction(currPlayer, game.getPlayers(), game.getDecks(currSpace));
        }
    }


    private void choosePath(Player p, AnchorPane rootPane, String[] choices,
                           MagentaSpace magentaSpace, Game game) throws IOException {
        // TODO: pop up and return value to do action
        Popup popup = new Popup();
        FXMLLoader popChoose = new FXMLLoader(getClass().getResource("choosePathPopUp.fxml"));
        Parent root = (Parent) popChoose.load();
        popup.getContent().add(root);
        choosePathPopUpController cpCont = (choosePathPopUpController) popChoose.<choosePathPopUpController>getController();
        cpCont.setPlayerText(p);
        cpCont.setChoice(choices[0], choices[1]);
        Stage stage = (Stage) rootPane.getScene().getWindow();
        popup.show(stage);

        cpCont.getConfirm().setOnAction(e->{
//            ((NoChoiceSpace) magentaSpace).doMagentaAction(p, game.getPlayers(), game.getDecks(magentaSpace));
            popup.hide();
            if (cpCont.opt1.isSelected()){
                setChoice(1);
            } else{
                setChoice(2);
            }
            ((ChoiceSpace) magentaSpace).doMagentaAction(p, game.getDecks(magentaSpace), this.choice );

        });

    }

    private void setChoice(int value){
        this.choice = value;
    }



}
