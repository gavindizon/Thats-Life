package Model.Spaces;

import Model.Deck;
import Model.Player;

import java.util.ArrayList;

/**
 * interface for spaces that does not need to pick any choices.
 */

public interface ActionSpace {

    /**
     *Executes the action to be done by a specific space
     * @param p current player.
     * @param others list of other players in the game.
     * @param decks arraylist of decks needed by the player ie blue deck for blue space.
     */
    void doAction(Player p, Player[] others, ArrayList<Deck> decks);
}
