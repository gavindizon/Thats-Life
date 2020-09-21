package phase1.Spaces;

import java.util.ArrayList;
import phase1.Player;
import phase1.Deck;

public class HaveTwinSpace extends MagentaSpace implements NoChoiceSpace{
    public HaveTwinSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
    }

    @Override
    public void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks) {
        System.out.println("I just gave birth");

        if (p.isMarried()) {
            p.addKids(2);
            for (Player other : others)
                if (!p.equals(other))
                    if (other.isMarried())
                        p.updateCash(5000 * other.getNumKids());

        }
    }
}
