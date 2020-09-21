package phase1.Spaces;

import phase1.Deck;
import phase1.Player;

import java.util.ArrayList;

public interface NoChoiceSpace {
    void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks);
}
