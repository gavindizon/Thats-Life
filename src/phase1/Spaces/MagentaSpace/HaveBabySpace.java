package phase1.Spaces.MagentaSpace;

import java.util.ArrayList;
import phase1.Player;
import phase1.Deck;

public class HaveBabySpace extends MagentaSpace implements NoChoiceSpace {
    public HaveBabySpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Have a Baby";
        this.longDescription = "Congratulations on the Baby vroooo!";

    }

    @Override
    public void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks) {
        System.out.println("I just gave birth");

        if (p.isMarried()) {
            p.addKids(1);
            for (Player other : others)
                if (!p.equals(other))
                    if (other.isMarried() && !other.getIsRetired())
                        p.updateCash(5000 * other.getNumKids());

        }
    }
}
