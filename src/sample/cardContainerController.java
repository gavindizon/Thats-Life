package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import phase1.Cards.*;

public class cardContainerController {
    @FXML Label cardTitle;
    @FXML Label cardType;
    @FXML Label cardDescription;

    public void setCard(Card c){
        this.cardType.setText(c.cardType());
        this.cardTitle.setText(c.getDescription());
    }

}
