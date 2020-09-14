package phase1.Spaces;

import phase1.Deck;
import phase1.Player;
import java.util.ArrayList;

public abstract class MagentaSpace extends Space {
    private String deckType;

    public MagentaSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
    }

    public String getDeckType() {
        return deckType;
    }

    public void doAction(Player p, Player[] others, ArrayList<Deck> decks) {
        System.out.println("M");
        doMagentaAction(p, others, decks);

    }

    public abstract void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks);

}
