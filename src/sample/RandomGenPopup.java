package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import phase1.Game;


public class RandomGenPopup {
    @FXML private Button spinButt;
    @FXML private Button doneButt;

    public int generateNum(){
        int number = Game.spinWheel();
        return number;
    }

    public Button getSpinButt() {
        return spinButt;
    }

    public Button getDoneButt(){
        return this.doneButt;
    }

}
