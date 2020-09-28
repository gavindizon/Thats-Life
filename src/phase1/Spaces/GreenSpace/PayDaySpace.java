package phase1.Spaces.GreenSpace;

import phase1.Player;
import phase1.Deck;
import phase1.Spaces.ActionSpace;

import java.util.ArrayList;

public class PayDaySpace extends GreenSpace implements ActionSpace {

    public PayDaySpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Pay Day Space";
        this.longDescription = "Collect your salary!";
    }

    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> decks) {

        if(p.getSalaryCard() != null)
            p.updateCash(p.getSalaryCard().getSalary());
    }

}
