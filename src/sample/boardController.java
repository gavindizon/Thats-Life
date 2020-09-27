package sample;


import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;
import phase1.Game;
import phase1.Player;
import phase1.Spaces.*;
import phase1.Spaces.GreenSpace.GreenSpace;
import phase1.Spaces.GreenSpace.PayDaySpace;
import phase1.Spaces.GreenSpace.PayRaiseSpace;
import phase1.Spaces.MagentaSpace.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class boardController {

    @FXML
    List<VBox> spacesView;


    public void initialize(){
        int count = 1;
        Label label = new Label("Label");

        for(VBox space : spacesView){
            space.setStyle("-fx-border-color: #FFF; -fx-background-color: #000;");
            for(int j = 0; j < 3; j++){
                label = (Label) space.getChildren().get(j);
                label.setText("");

            }
        }
    }

    public void initSpaceColor(Game game){
        int i = 0;

        for(VBox spaceView: spacesView){

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
        int i = 0;
        for(VBox spaceView : spacesView){

            Space space = game.getSpace(i);
                spaceView.getChildren().clear();
                for(int j = 0; j < game.getNumPlayers(); j++){
                    Label label = new Label();
                    try{
                        label.setText(space.getPlayers().get(j).getName());
                    }catch(Exception e){
                        label.setText("");
                    }
                    label.setStyle("-fx-text-fill:blue; -fx-font-weight:bold");
                    label.setMaxHeight(50);
                    label.setTextAlignment(TextAlignment.CENTER);
                    label.setWrapText(true);
                    label.setMaxWidth(45);


                    spaceView.getChildren().add(j, label);
                }
                i++;
        }

        i = 0;
        for(VBox spaceView : spacesView){
            ImageView imgContainer = new ImageView();
            Image img = null;

            Space space = game.getSpace(i);
            if((space instanceof GreenSpace || space instanceof MagentaSpace) && space.getPlayers().size() == 0) {
                spaceView.getChildren().clear();
                spaceView.setAlignment(Pos.CENTER);
                //spaceView.setMaxWidth(45);
                spaceView.maxWidth(10);
                spaceView.setMaxHeight(51);

            /*    Label label = new Label();

                label.setStyle("-fx-text-fill:white; -fx-font-weight:bold; -fx-font-size: 10px");
                label.setMaxHeight(50);
                label.setText(space.getActionDescription());
                label.setTextAlignment(TextAlignment.CENTER);
                label.setWrapText(true);
                label.setMaxWidth(45);
                if(space instanceof GraduationSpace)
                    label.setText("Finished College");
            */
                if (space instanceof GraduationSpace) {
                    img = new Image(getClass().getResourceAsStream("/assets/graduate_icon.png"));
                } else if (space instanceof GetMarriedSpace) {
                    img = new Image(getClass().getResourceAsStream("/assets/married_icon.png"));
                } else if (space instanceof JobSearchSpace) {
                    img = new Image(getClass().getResourceAsStream("/assets/jobsearch_icon.png"));
                } else if (space instanceof CollegeCareerChoiceSpace) {
                    img = new Image(getClass().getResourceAsStream("/assets/cc_icon.png"));
                } else if (space instanceof BuyHouseSpace) {
                    img = new Image(getClass().getResourceAsStream("/assets/house_icon.png"));
                } else if (space instanceof WhichPathSpace) {
                    img = new Image(getClass().getResourceAsStream("/assets/whichpath_icon.png"));
                } else if (space instanceof PayRaiseSpace) {
                    img = new Image(getClass().getResourceAsStream("/assets/payraise_icon.png"));
                } else if (space instanceof PayDaySpace) {
                    img = new Image(getClass().getResourceAsStream("/assets/payday_icon.png"));
                } else {
                    img = new Image(getClass().getResourceAsStream("/assets/kids_icon.png"));
                }

                imgContainer.setImage(img);

                imgContainer.setFitWidth(44);

                spaceView.getChildren().add(imgContainer);
            }
            i++;
        }

    }


    public void boardAction(Game game, int currPlayerIndex, Controller gameControl) throws IOException {
        Space currSpace = game.getSpace(game.getPlayer(currPlayerIndex).getSpaceTracker());
        Player currPlayer = game.getPlayer(currPlayerIndex);
        if(currSpace instanceof OrangeSpace || currSpace instanceof BlueSpace){
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
                if(magentaSpace instanceof CollegeCareerChoiceSpace){
                    String[] choice1 = Arrays.copyOfRange(choices, 0, 2);
                    String[] choice2 = Arrays.copyOfRange(choices, 2, 4);
                    if (!choices[0].equalsIgnoreCase("No careers available")){
                        choosePath(currPlayer, gameControl.getRootPane(), choice2, magentaSpace, game);
                        choosePath(currPlayer, gameControl.getRootPane(), choice1, magentaSpace, game);
                    } else {
                        choosePath(currPlayer, gameControl.getRootPane(), choice1, magentaSpace, game);
                    }


                }else if(magentaSpace instanceof BuyHouseSpace){
                    chooseHouse(currPlayer, gameControl.getRootPane(), choices, magentaSpace, game);

                }else{
                    choosePath(currPlayer, gameControl.getRootPane(), choices, magentaSpace, game);

                }

            } else{
                ((NoChoiceSpace) magentaSpace).doMagentaAction(currPlayer, game.getPlayers(), game.getDecks(magentaSpace));
            }
        } else {
            currSpace.doAction(currPlayer, game.getPlayers(), game.getDecks(currSpace));
        }
    }


    private void choosePath(Player p, AnchorPane rootPane, String[] choices,
                           MagentaSpace magentaSpace, Game game) throws IOException{
        // TODO: pop up and return value to do action
        Popup popup = new Popup();
        try{
            choosePlayerPopUpController cpCont = initPopup(popup, rootPane);
            cpCont.getTextLabel().setText("Choose path for: " + p.getName());
            System.out.println("xxx"+ choices[1]);
            cpCont.generateChoices(choices);
            cpCont.getConfirm().setOnAction(e->{
                popup.hide();
                RadioButton[] radio = cpCont.getRadios();
                try{
                    for(int i = 0; i < radio.length; i++){
                        if(radio[i].isSelected() && !radio[i].getText().equalsIgnoreCase("No careers available")){
                            ((ChoiceSpace) magentaSpace).doMagentaAction(p, game.getDecks(magentaSpace), i + 1);
                            if(magentaSpace instanceof JobSearchSpace){
                                if (i == 1 && choices[0].equalsIgnoreCase("Retain job")){
                                    String[] choice1 = new String[]{choices[2], choices[3]};
                                    try{
                                        choosePath(p, rootPane, choice1, magentaSpace, game);
                                    }catch (Exception m){
                                        System.out.println("x");
                                    }
                                }
                            }
                        }

                    }
                } catch(NullPointerException d){
                    System.out.println("hello world");
                }

            });
        }catch (Exception e){
            System.out.println("FXML File not found");
            e.printStackTrace();
        }
    }



    private void chooseHouse(Player p, AnchorPane rootPane, String[] choices,
                            MagentaSpace magentaSpace, Game game) throws IOException {
        // TODO: pop up and return value to do action
        Popup popup = new Popup();
        FXMLLoader popChoose = new FXMLLoader(getClass().getResource("chooseHouse.fxml"));
        Parent root = (Parent) popChoose.load();
        popup.getContent().add(root);
        chooseHouseController chCont = (chooseHouseController) popChoose.<chooseHouseController>getController();
        chCont.setPlayerText(p);
        chCont.setChoice(choices);
        Stage stage = (Stage) rootPane.getScene().getWindow();
        popup.show(stage);

        chCont.getConfirm().setOnAction(e ->{
            popup.hide();

            RadioButton selectedRadioButton = (RadioButton) chCont.getChoicePicker().getSelectedToggle();

            ((ChoiceSpace) magentaSpace).doMagentaAction(p, game.getDecks(magentaSpace), (int) selectedRadioButton.getUserData());
        });

    }


    private choosePlayerPopUpController initPopup(Popup popup, AnchorPane rootPane) throws IOException{
        try{
            FXMLLoader popChoose = new FXMLLoader(getClass().getResource("choosePlayerPopUp.fxml"));
            Parent root = (Parent) popChoose.load();
            popup.getContent().add(root);
            choosePlayerPopUpController cpCont = (choosePlayerPopUpController) popChoose.<choosePlayerPopUpController>getController();
            Stage stage = (Stage) rootPane.getScene().getWindow();
            popup.show(stage);
            return cpCont;

        } catch (IOException e){
            System.out.println("FXML File not found");
            e.printStackTrace();
        }
        return null;

    }



}
