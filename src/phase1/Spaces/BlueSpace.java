package phase1.Spaces;

import phase1.Player;
import phase1.Deck;
import java.util.ArrayList;
import phase1.Cards.BlueCard;

public class BlueSpace extends Space {
    private String deckType;

    public BlueSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.deckType = "Blue";
    }

    public String getDeckType() {
        return deckType;
    }

    public void doAction(Player p, Player[] others, ArrayList<Deck> blueDeck) {

        BlueCard c = (BlueCard) blueDeck.get(0).drawCard();

        c.activate(p, others);
    }

}
