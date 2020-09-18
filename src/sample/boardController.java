package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;
import phase1.Game;
import phase1.Spaces.*;

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
                try{
                    label.setText(space.getPlayers().get(j).getName());
                }catch(Exception e){
                    label.setText("");
                }
            }
            i++;
    }
}}
