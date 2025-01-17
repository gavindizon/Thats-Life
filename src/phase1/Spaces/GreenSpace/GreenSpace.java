package phase1.Spaces.GreenSpace;

import phase1.Player;
import phase1.Deck;
import phase1.Spaces.Space;

import java.util.ArrayList;

public abstract class GreenSpace extends Space {

    public GreenSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.type = "Green Space";

    }

    @Override
    public abstract void doAction(Player p, Player[] others, ArrayList<Deck> decks);
}
