package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;
import phase1.Game;
import phase1.Player;
import phase1.Spaces.*;

import java.io.IOException;
import java.util.List;


public class boardController {

    @FXML
    List<TextFlow> spacesView;


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
            try{
                gameControl.activateCard(currPlayer);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(currSpace instanceof MagentaSpace){
            MagentaSpace m = (MagentaSpace) currSpace;
            if(m instanceof CollegeCareerChoiceSpace || m instanceof WhichPathSpace){
                System.out.println("hello world");
            } else{
                System.out.println("hi");
            }

//            m.doAction(currPlayer, game.getPlayers(), game.getDecks(currSpace));
        } else {
            currSpace.doAction(currPlayer, game.getPlayers(), game.getDecks(currSpace));
        }
    }


    private int choosePath(){
        // TODO: pop up and return value to do action
        return 0 ;
    }



}
