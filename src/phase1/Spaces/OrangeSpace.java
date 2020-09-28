package phase1.Spaces;

import phase1.Player;
import phase1.Deck;

import java.util.ArrayList;

/**
 * Implements an Orange Space which inherits the Space and implements the ActionSpace
 */
public class OrangeSpace extends Space implements ActionSpace{
    private String deckType;

    /**
     * initializes the Orange Space given the path and the number of players in the game
     *
     * @param path name of the path of the space initialized
     * @param noOfPlayers number of players in the game
     */
    public OrangeSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.deckType = "Action";
        this.type = "Orange Space";
        this.actionDescription = "Draw from Action Deck";
    }

    /**
     * Returns the String of the type of deck
     *
     * @return String of the type of deck
     */
    public String getDeckType() {
        return deckType;
    }

    /**
     * Player draws from the action card
     *
     * @param p player on the space
     * @param others other player of the game
     * @param actionDeck deck of action cards
     */
    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> actionDeck) {
        p.drawCard(actionDeck.get(0));

    }

}
