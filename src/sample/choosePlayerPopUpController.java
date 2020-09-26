package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import phase1.Player;

public class choosePlayerPopUpController {
    @FXML private HBox radioCont;
    @FXML private Button confirm;
    @FXML private RadioButton[] radios;
    @FXML private ToggleGroup group = new ToggleGroup();
    @FXML private Label textLabel;

    public void generateChoices(Player[] players, Player currPlayer){
        radios = new RadioButton[players.length - 1];
        RadioButton radio;
        int i = 0;
        System.out.println("PLAYER LENGTH: " + players.length);
        for(Player p : players){
            if (!p.equals(currPlayer) && !p.getIsRetired()) {
                radio = new RadioButton();
                radio.setText(p.getName());
                radio.setToggleGroup(group);
//                radio.insets(0, 0, 0, i * 8);
//                radio.setLayoutX(i * 150);
                radioCont.getChildren().addAll(radio);
                radios[i] = radio;
                i++;
            }
        }
    }

    public void generateChoices(String[] choices){
        radios = new RadioButton[choices.length];
        RadioButton radio;

        if(choices[1] != null){
            for(int i = 0 ; i < 2; i++){
                if(choices[i] != null){
                    radio = new RadioButton();
                    radio.setText(choices[i]);
                    radio.setToggleGroup(group);

                    radioCont.getChildren().addAll(radio);
                    radios[i] = radio;
                }
            }

        } else{
            Label label = new Label(choices[0]);
            radioCont.getChildren().add(label);
        }
    }

    public Label getTextLabel() {
        return textLabel;
    }

    public RadioButton[] getRadios() {
        return radios;
    }

    public Button getConfirm() {
        return confirm;
    }

    public HBox getRadioCont() {
        return radioCont;
    }
}
