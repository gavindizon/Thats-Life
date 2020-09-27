package phase1.Spaces;

import phase1.Player;
import phase1.Deck;
import java.util.ArrayList;
import phase1.Cards.BlueCard.BlueCard;

public class BlueSpace extends Space implements ActionSpace {
    private String deckType;

    public BlueSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.deckType = "Blue";
        this.type = "Blue";
        this.actionDescription = "Draw Card from Blue Deck";

    }

    public String getDeckType() {
        return deckType;
    }

    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> blueDeck) {
        p.drawCard(blueDeck.get(0));

    }

}
