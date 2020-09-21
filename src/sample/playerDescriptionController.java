package sample;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import phase1.*;
import phase1.Cards.*;


public class playerDescriptionController {
//    private  Model model = new Model("Tyrone", 9000);
//    private Player p = new Player("Tyrone");

    @FXML private Label name;
    @FXML private Label cash;
    @FXML private Label loan;
    @FXML private Label career;

    @FXML private ImageView married;
    @FXML private ImageView kids;
    @FXML private ImageView degree;

    @FXML private AnchorPane playerPane;


    public void setCash(double cash, Player p){
//        p.updateCash(c.getValue());
//        c.activate();
        this.cash.setText("$"+p.getCash());
    }


    public AnchorPane getPlayerPane(){
        return this.playerPane;
    }

    public void setPlayerDetails(Player p) {
        this.name.setText(p.getName());
        this.cash.setText("Cash: $"+p.getCash());
        this.loan.setText("Loan :$" +p.getLoan());
        this.career.setText(p.getCareer());

        if(p.isMarried())
            married.setStyle("-fx-opacity: 1;");

        if(p.isHasDegree())
            degree.setStyle("-fx-opacity: 1;");

        if(p.getNumKids() > 0)
            kids.setStyle("-fx-opacity: 1;");

    }
    public Label getName(){
        return this.name;
    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        initPlayers();
//    }

}
