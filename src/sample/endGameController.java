package sample;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import phase1.Player;

import java.util.ArrayList;

public class endGameController {

    @FXML
    VBox vbox;

    @FXML
    Button endBtn;

    public void listResult(Player[] players){

        for(int i = 0 ; i < players.length; i++){
            Label label = new Label();
            label.prefWidth(377);
            label.prefHeight(24);
            label.setAlignment(Pos.CENTER);

            label.setText((i + 1) + " " + players[i].getName() + " - $" +players[i].getCash());
            label.setStyle("-fx-font-size: 16px; -fx-text-fill: #FFF;");
            vbox.getChildren().add(label);
        }

        Label win = new Label();
        win.prefWidth(377);
        win.prefHeight(24);
        win.setMaxWidth(377);
        win.setAlignment(Pos.CENTER);
        win.setText("Congratulation, " + players[0].getName() +"! You have won the game.");
        win.setWrapText(true);
        win.setStyle("-fx-font-size: 24px; -fx-text-fill: #FFF;");
        vbox.getChildren().add(win);

    }

}
