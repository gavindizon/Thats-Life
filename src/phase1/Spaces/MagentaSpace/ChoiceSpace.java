package phase1.Spaces.MagentaSpace;

import phase1.Deck;
import phase1.Player;

import java.util.ArrayList;

public interface ChoiceSpace {

    String[] getChoices(Player p, ArrayList<Deck> decks);
    void doMagentaAction(Player p, ArrayList<Deck> decks, int choice);
}
