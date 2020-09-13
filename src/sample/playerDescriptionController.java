package sample;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class playerDescriptionController implements Initializable {
    private  Model model = new Model("Tyrone", 9000);
    @FXML private Label name;
    @FXML private Label cash;

    private void init(){
        this.name.setText(this.model.getName());
        this.cash.setText("$"+ this.model.getCash());
    }

    public void setCash(int cashEntered){
        this.model.updateCash(cashEntered);
        this.cash.setText("$"+this.model.getCash());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
    }

}
