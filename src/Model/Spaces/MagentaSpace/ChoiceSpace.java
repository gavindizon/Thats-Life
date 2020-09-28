package Model.Spaces.MagentaSpace;

import Model.Deck;
import Model.Player;

import java.util.ArrayList;

/**
 * Interface for spaces that requires to choose from the top 2 cards of the deck.
 *
 */
public interface ChoiceSpace {


    /**
     * Generates choices taken from the top two cards in a specific deck.
     * @param p current player
     * @param decks arraylist of decks needed by the player ie career deck and salary deck for choose career path.
     * @return a String array of choices from the top two cards in a specific deck.
     */
    String[] getChoices(Player p, ArrayList<Deck> decks);

    /**
     * Executes the action to be done by a specific space
     * @param p current player
     * @param decks arraylist of decks needed by the player ie career deck and salary deck for choose career path.
     * @param choice the number of the chosen card of the player: 1 if the top card, 2 if the card below the top card.
     */
    void doMagentaAction(Player p, ArrayList<Deck> decks, int choice);
}
