package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import phase1.Player;

public class ChooseHouseController {

    @FXML
    private Button confirm;

    private ToggleGroup choicePicker = new ToggleGroup();

    @FXML VBox choices;

    @FXML
    Label textHeading;

    public ChooseHouseController(){
    }


    public void initialize() {
    }

    public void setChoice(String[] choices){

        for(int i = 0; i < choices.length; i++){
            RadioButton radBtn = new RadioButton(choices[i]);
            if(i == 0)
                radBtn.setSelected(true);
            radBtn.setToggleGroup(choicePicker);
            radBtn.setUserData(i);
            this.choices.getChildren().add(radBtn);
            // HBox choiceContainer = (HBox) this.choices.getChildren().get(i);
        }

    }

    public ToggleGroup getChoicePicker() {
        return choicePicker;
    }

    public Button getConfirm() {
        return confirm;
    }


    public void setPlayerText(Player p){
        textHeading.setText("Choose house for: " + p.getName());
    }

}
