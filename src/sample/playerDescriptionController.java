package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
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
    @FXML private ImageView house;

    FXMLLoader loader = new FXMLLoader(getClass().getResource("showInfo.fxml"));



    private Player p;


    @FXML private AnchorPane playerPane;



    public void setCash(double cash, Player p){
        this.cash.setText("$"+p.getCash());
    }


    public AnchorPane getPlayerPane(){
        return this.playerPane;
    }

    public void setPlayerDetails(Player p) {
        this.p = p;
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
        if(p.getHouse() != null)
            house.setStyle("-fx-opacity: 1;");



    }
    public Label getName(){
        return this.name;
    }

    public void showMore(ActionEvent actionEvent) {

        Popup popup = new Popup();
        FXMLLoader sm = new FXMLLoader(getClass().getResource("showInfo.fxml"));
        Parent root = null;
        try {
            root = (Parent) sm.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showInfoController showInfoCont = (showInfoController) sm.<showInfoController>getController();

        popup.getContent().add(root);
        Stage stage = (Stage) playerPane.getScene().getWindow();
        popup.show(stage);
        showInfoCont.setAdditionalInfo(this.p);


        popup.setAutoHide(true);
    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        initPlayers();
//    }

}
