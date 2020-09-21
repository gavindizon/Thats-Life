package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import phase1.Cards.*;
import phase1.Spaces.*;

public class cardContainerController {
    @FXML Label cardTitle;
    @FXML Label cardType;
    @FXML Label cardDescription;
    @FXML VBox margins;
    @FXML AnchorPane container;
    public void setCard(Card c, Space s){
        if(s instanceof OrangeSpace){
            this.cardType.setText(c.cardType());
            this.cardTitle.setText(c.getDescription());
            this.cardDescription.setText(c.getLongDescription());
            container.setStyle("-fx-background-color: #FFBC3A;");
            margins.setStyle("-fx-background-color: #FFBC3A;");
        }else if(s instanceof MagentaSpace){
            this.cardType.setText("Magenta Space");
            this.cardTitle.setText("Magenta Type Space");
            this.cardDescription.setText("Magenta Action");
            container.setStyle("-fx-background-color: #FF00FF;");
            margins.setStyle("-fx-background-color: #FF00FF;");
        }else if(s instanceof GreenSpace){
            this.cardType.setText("Green Space");
            if(s instanceof PayDaySpace){
                this.cardTitle.setText("Pay Day");
                this.cardDescription.setText("Collect your salary!");
            }
            else{
                this.cardDescription.setText("Pay Raise");
                this.cardDescription.setText("A raise is given to the player together with his salary.");
            }

            container.setStyle("-fx-background-color: #008000;");
            margins.setStyle("-fx-background-color: #008000;");
        }else{
            container.setStyle("-fx-background-color: #ADD8E6;");
            margins.setStyle("-fx-background-color: #ADD8E6;");
        }
    }

}
