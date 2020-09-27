package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import phase1.Game;
import phase1.Player;

public class choosePathPopUpController {

    @FXML private AnchorPane rootPane;

    private int value;

    @FXML
    RadioButton opt1;
    @FXML
    RadioButton opt2;

    @FXML
    private Button confirm;

    @FXML
    Label textHeading;

    public choosePathPopUpController(){
    }

//
//    public void initialize() {
//        opt1.setSelected(true);
//        value = 1;
//    }
//
//    public void setChoice(String opt1, String opt2){
//        this.opt1.setText(opt1);
//        this.opt2.setText(opt2);
//
//    }
//
//    @FXML
//    public void choose(ActionEvent e){
//        System.out.println("Hello");
//        if(e.getTarget() == confirm && opt1.isSelected())
//            value = 1;
//        else
//            value = 2;
//
//    }
//
//    public Button getConfirm() {
//        return confirm;
//    }
//
//    @FXML public void isPathA(){
//        if(opt2.isSelected())
//            opt2.setSelected(false);
//        value = 1;
//    }
//    @FXML public void isPathB(){
//        if(opt1.isSelected())
//            opt1.setSelected(false);
//
//        value = 2;
//    }
//    public int getValue() {
//        return value;
//    }
//
//    public void setPlayerText(Player p){
//            textHeading.setText("Choose path for: " + p.getName());
//    }

}
