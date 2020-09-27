package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import phase1.Player;

public class ShowInfoController {

    @FXML
    private Label sm_playername;
    @FXML private Label sm_career;
    @FXML private Label sm_cash;
    @FXML private Label sm_loan;
    @FXML private Label sm_salary;
    @FXML private Label sm_tax;
    @FXML private Label sm_payraiseCnt;
    @FXML private Label sm_married;
    @FXML private Label sm_kidsCnt;
    @FXML private Label sm_houseVal;
    @FXML private Label sm_degree;
    @FXML private Label sm_retired;


    public void setAdditionalInfo(Player p){
        sm_playername.setText(p.getName());
        sm_cash.setText("Cash: $" + p.getCash());
        sm_loan.setText("Loan: $" + p.getLoan());
        sm_career.setText("Career: " + p.getCareer());
        if(p.getSalaryCard() != null){
            sm_salary.setText("Salary: $" + p.getSalaryCard().getSalary());
            sm_tax.setText("Tax: $" + p.getSalaryCard().getTax());
        }else{
            sm_salary.setText("Salary: $" + 0);
            sm_tax.setText("Tax: $" + 0);

        }

        if(p.getCareerCard() != null)
            sm_payraiseCnt.setText("Pay Raise: " + (p.getPayRaiseCnt()) + "/" + (p.getCareerCard().getMaxPayRaise()));
        else
            sm_payraiseCnt.setText("Pay Raise: " + "-");

        sm_married.setText("Civil Status: " + (p.isMarried() ? "Married" : "Single"));
        sm_kidsCnt.setText("Number of Kids: " + p.getNumKids());
        sm_retired.setText("Retired: " + (p.getIsRetired() ? "Yes" : "No"));
        sm_degree.setText("College Graduate: " + (p.isHasDegree() ? "Yes" : "No"));
        if(p.getHouse() != null){
            sm_houseVal.setText("House Value: $" + p.getHouse().getValue());
        }else{
            sm_houseVal.setText("House Value: " + 0);
        }
    }


}
