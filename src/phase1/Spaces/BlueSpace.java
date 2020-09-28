package phase1.Spaces;

import phase1.Player;
import phase1.Deck;
import java.util.ArrayList;
import phase1.Cards.BlueCard.BlueCard;

/**
 * implements a BlueSpace that inherits from Space and implement the
 * ActionSpace interface
 */


public class BlueSpace extends Space implements ActionSpace {
    private String deckType;

    /**
     * initializes the Blue Space given the path and the number of players in the game
     *
     * @param path name of the path of the space initialized
     * @param noOfPlayers number of players in the game
     */
    public BlueSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.deckType = "Blue";
        this.type = "Blue";
        this.actionDescription = "Draw Card from Blue Deck";

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
     * Player draws from the BLUE card
     *
     * @param p player on the space
     * @param others other player of the game
     * @param actionDeck deck of BLUE cards
     */
    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> blueDeck) {
        p.drawCard(blueDeck.get(0));

    }

}
