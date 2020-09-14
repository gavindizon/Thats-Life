package phase1.Spaces;

import phase1.Player;
import phase1.Deck;
import java.util.ArrayList;

public class PayRaiseSpace extends GreenSpace {

    public PayRaiseSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
    }

    public void doAction(Player p, Player[] others, ArrayList<Deck> decks) {
        p.getSalaryCard().raiseSalary();
        p.updateCash(p.getSalaryCard().getSalary());
    }

}
