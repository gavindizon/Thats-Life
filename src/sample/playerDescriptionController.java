package sample;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import phase1.*;

public class playerDescriptionController {
//    private  Model model = new Model("Tyrone", 9000);
//    private Player p = new Player("Tyrone");

    @FXML private Label name;
    @FXML private Label cash;
    @FXML private Label career;


    public void setCash(int cashEntered, Player p){
        p.updateCash(cashEntered);
        this.cash.setText("$"+p.getCash());
    }

    public void setPlayerDetails(Player p) {
        this.name.setText(p.getName());
        this.cash.setText("$"+p.getCash());
        this.career.setText(p.getCareer());

    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        initPlayers();
//    }

}
