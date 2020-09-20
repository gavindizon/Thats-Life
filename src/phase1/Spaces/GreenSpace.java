package phase1.Spaces;

import phase1.Player;
import phase1.Deck;
import java.util.ArrayList;

public abstract class GreenSpace extends Space {

    public GreenSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
    }

    @Override
    public abstract void doAction(Player p, Player[] others, ArrayList<Deck> decks);
}
