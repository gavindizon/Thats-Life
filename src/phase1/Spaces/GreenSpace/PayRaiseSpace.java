package phase1.Spaces.GreenSpace;

import phase1.Player;
import phase1.Deck;
import phase1.Spaces.ActionSpace;

import java.util.ArrayList;

public class PayRaiseSpace extends GreenSpace implements ActionSpace {

    public PayRaiseSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Pay Raise Space";
        this.longDescription = "Congratulations!, you just received a raise and got paid.";

    }
    
    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> decks) {
        if(p.getSalaryCard() != null){
            if(p.getPayRaiseCnt() < p.getCareerCard().getMaxPayRaise()){
                p.getSalaryCard().raiseSalary();
                p.setPayRaiseCnt(p.getPayRaiseCnt() + 1);
            }else{
                System.out.println("Pay raise count is at max");
            }

            p.updateCash(p.getSalaryCard().getSalary());
        }
    }

}
