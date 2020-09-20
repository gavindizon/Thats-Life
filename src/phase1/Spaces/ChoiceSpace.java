package phase1.Spaces;

import phase1.Deck;
import phase1.Player;

import java.util.ArrayList;

public interface ChoiceSpace {

    String[] getChoices(Player p, ArrayList<Deck> decks);
    void choiceAction(Player p, ArrayList<Deck> decks, int choice);
}
