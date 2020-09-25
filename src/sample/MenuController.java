package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.security.jgss.GSSUtil;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import phase1.Player;


public class MenuController {

    public Button opt0;
    public Button opt1;
    public Button opt2;

    public String player1;
    public String player2;
    public String player3;
    // location and resources will be automatically injected by the FXML loader
    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    public MenuController() {
    }

    @FXML
    private void initialize()
    {
        player1 = "Gavin";
        player2 = "Tyrone";
        player3 = "Shirley";
    }



    @FXML

    public void menuOptions(ActionEvent e) throws IOException {
        Stage stage = (Stage) opt0.getScene().getWindow();

        if(e.getTarget() == opt0){
            FXMLLoader game = new FXMLLoader(getClass().getResource("sample.fxml"));
            try {
                Parent root = (Parent) game.load();
                Scene play = new Scene(root);
                stage.setScene(play);
                stage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Controller controller = game.<Controller>getController();
            String[] players = {player1, player2};
            controller.initPlayers(players);

        }
        else if(e.getTarget() == opt1){
            FXMLLoader game = new FXMLLoader(getClass().getResource("sample.fxml"));
            try {
                Parent root = (Parent) game.load();
                Scene play = new Scene(root);
                stage.setScene(play);
                stage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Controller controller = game.<Controller>getController();
            String[] players = {player1, player2, player3};
            controller.initPlayers(players);
        }

        else if(e.getTarget() == opt2){
            FXMLLoader settings = new FXMLLoader(getClass().getResource("settings.fxml"));
            try {
                Parent root = (Parent) settings.load();
                Scene play = new Scene(root);
                stage.setScene(play);
                stage.show();
                Stage stage2 = (Stage) opt2.getScene().getWindow();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            SettingsController settingsController = settings.<SettingsController>getController();
            settingsController.retrieveData(player1, player2, player3);
        }
        else
            stage.close();
    }

    public void updateFromSettings(String name1, String name2, String name3){

        player1 = name1;
        player2 = name2;
        player3 = name3;

    }


    public void updateFromGame(String name1, String name2, String name3){
        player1 = name1;
        player2 = name2;
        player3 = name3;
    }

    public void updateFromGame(String name1, String name2){
        player1 = name1;
        player2 = name2;
    }

}
