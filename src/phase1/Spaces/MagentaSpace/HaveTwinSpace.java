package phase1.Spaces.MagentaSpace;

import java.util.ArrayList;
import phase1.Player;
import phase1.Deck;

public class HaveTwinSpace extends MagentaSpace implements NoChoiceSpace{
    public HaveTwinSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Have a Twin";
        this.longDescription = "Congratulations on the Twins vroooo!";

    }

    @Override
    public void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks) {
        System.out.println("I just gave birth");

        if (p.isMarried()) {
            p.addKids(2);
            for (Player other : others)
                if (!p.equals(other))
                    if (other.isMarried() && !other.getIsRetired())
                        p.updateCash(5000 * other.getNumKids());

        }
    }
}
