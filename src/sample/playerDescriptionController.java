package sample;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import phase1.*;

public class playerDescriptionController implements Initializable {
//    private  Model model = new Model("Tyrone", 9000);
    private Player p = new Player("Tyrone");

    @FXML private Label name;
    @FXML private Label cash;
    @FXML private Label career;


    public void initPlayers(){
        this.name.setText(this.p.getName());
        this.cash.setText("$"+ this.p.getCash());
        this.career.setText(this.p.getCareer());
    }

    public void setCash(int cashEntered){
        p.updateCash(cashEntered);
        this.cash.setText("$"+this.p.getCash());
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initPlayers();
    }

}
