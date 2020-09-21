package phase1.Spaces;

import phase1.Player;
import phase1.Deck;
import java.util.ArrayList;

public class PayDaySpace extends GreenSpace {

    public PayDaySpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Pay Day Space";
        this.longDescription = "Collect your salary!";
    }

    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> decks) {
        p.updateCash(p.getSalaryCard().getSalary());
    }

}
