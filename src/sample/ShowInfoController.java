package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import phase1.Player;

public class ShowInfoController {

    @FXML
    private Label smPlayerName;
    @FXML private Label smCareer;
    @FXML private Label smCash;
    @FXML private Label smLoan;
    @FXML private Label smSalary;
    @FXML private Label smTax;
    @FXML private Label smPayRaiseCnt;
    @FXML private Label smMarried;
    @FXML private Label smKidsCnt;
    @FXML private Label smHouseVal;
    @FXML private Label smDegree;
    @FXML private Label smRetired;


    public void setAdditionalInfo(Player p){
        smPlayerName.setText(p.getName());
        smCash.setText("Cash: $" + p.getCash());
        smLoan.setText("Loan: $" + p.getLoan());
        smCareer.setText("Career: " + p.getCareer());
        if(p.getSalaryCard() != null){
            smSalary.setText("Salary: $" + p.getSalaryCard().getSalary());
            smTax.setText("Tax: $" + p.getSalaryCard().getTax());
        }else{
            smSalary.setText("Salary: $" + 0);
            smTax.setText("Tax: $" + 0);

        }

        if(p.getCareerCard() != null)
            smPayRaiseCnt.setText("Pay Raise: " + (p.getPayRaiseCnt()) + "/" + (p.getCareerCard().getMaxPayRaise()));
        else
            smPayRaiseCnt.setText("Pay Raise: " + "-");

        smMarried.setText("Civil Status: " + (p.isMarried() ? "Married" : "Single"));
        smKidsCnt.setText("Number of Kids: " + p.getNumKids());
        smRetired.setText("Retired: " + (p.getIsRetired() ? "Yes" : "No"));
        smDegree.setText("College Graduate: " + (p.isHasDegree() ? "Yes" : "No"));
        if(p.getHouse() != null){
            smHouseVal.setText("House Value: $" + p.getHouse().getValue());
        }else{
            smHouseVal.setText("House Value: " + 0);
        }
    }


}
