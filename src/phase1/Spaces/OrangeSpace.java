package phase1.Spaces;

import phase1.Player;
import phase1.Deck;
import phase1.Cards.ActionCard;
import phase1.Cards.CollectFromBank;
import phase1.Cards.CollectFromPlayer;
import phase1.Cards.PayBank;
import phase1.Cards.PayPlayer;

import java.util.ArrayList;

public class OrangeSpace extends Space {
    private String deckType;

    public OrangeSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.deckType = "Action";
    }

    public String getDeckType() {
        return deckType;
    }

    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> actionDeck) {
        p.drawCard(actionDeck.get(0));

    }

}
