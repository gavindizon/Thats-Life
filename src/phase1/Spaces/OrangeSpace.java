package phase1.Spaces;

import phase1.Player;
import phase1.Deck;

import java.util.ArrayList;

public class OrangeSpace extends Space implements ActionSpace{
    private String deckType;

    public OrangeSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.deckType = "Action";
        this.type = "Orange Space";
        this.actionDescription = "Draw from Action Deck";
//        this.longDescription = "Card drawn is ";
    }

    public String getDeckType() {
        return deckType;
    }

    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> actionDeck) {
        p.drawCard(actionDeck.get(0));

    }

}
