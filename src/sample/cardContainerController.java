package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import phase1.Cards.*;
import phase1.Spaces.*;
import phase1.Spaces.GreenSpace.GreenSpace;
import phase1.Spaces.MagentaSpace.MagentaSpace;

public class cardContainerController {
    @FXML Label cardTitle;
    @FXML Label cardType;
    @FXML Label cardDescription;
    @FXML VBox margins;
    @FXML AnchorPane container;
    public void setCard(Card c, Space s){
        if(s instanceof OrangeSpace){
            container.setStyle("-fx-background-color: #FFBC3A;");
            margins.setStyle("-fx-background-color: #FFBC3A;");
        }else if(s instanceof MagentaSpace){
            container.setStyle("-fx-background-color: #FF00FF;");
            margins.setStyle("-fx-background-color: #FF00FF;");
        }else if(s instanceof GreenSpace){
            container.setStyle("-fx-background-color: #008000;");
            margins.setStyle("-fx-background-color: #008000;");
        }else{
            container.setStyle("-fx-background-color: #ADD8E6;");
            margins.setStyle("-fx-background-color: #ADD8E6;");
        }

        if(s instanceof OrangeSpace || s instanceof BlueSpace){
            cardTitle.setText(c.getDescription());
            cardType.setText(s.getType());
            cardDescription.setText(c.getDescription() + " - " + c.getLongDescription());

        }else{
            cardTitle.setText(s.getActionDescription());
            cardType.setText(s.getType());
            cardDescription.setText(s.getLongDescription());
        }




    }

}
