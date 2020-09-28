package phase1.Spaces.GreenSpace;

import phase1.Player;
import phase1.Deck;
import phase1.Spaces.ActionSpace;

import java.util.ArrayList;
/**
 * Implements a PayRaiseSpace that inherits from GreenSpace and implements
 * the ActionSpace interface
 *
 */

public class PayRaiseSpace extends GreenSpace implements ActionSpace {

    /**
     * Initializes the path and max num of players based from the inherited constructor
     * assigns the action description and long description
     * @param path
     * @param noOfPlayers
     */
    public PayRaiseSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Pay Raise Space";
        this.longDescription = "Congratulations!, you just received a raise and got paid.";

    }

    /**
     * Raises the Salary of the player if he has a salary card and the player's current pay raise count
     * is not equal to the max pay raise of his job otherwise, he only collects his salary money.
     * @param p
     * @param others
     * @param decks
     */
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
