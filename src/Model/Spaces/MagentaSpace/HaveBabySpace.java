package Model.Spaces.MagentaSpace;

import java.util.ArrayList;
import Model.Player;
import Model.Deck;
import Model.Spaces.ActionSpace;
/**
 * Implements a HaveaBabySpace that extends from the Magenta Space and implements the
 * ActionSpace interface
 *
 */

public class HaveBabySpace extends MagentaSpace implements ActionSpace {
    /**
     * Initializes the path and max num of players based from the inherited constructor
     * assigns the action description and long description
     * @param path
     * @param noOfPlayers
     */

    public HaveBabySpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Have a Baby";
        this.longDescription = "Congratulations on the Baby vroooo!";

    }

    /**
     * 1 is added to the number of kids of the player and player collects 5k for
     * every kids of the other players if married, else no effect.
     *
     * @param p current player
     * @param others other players in the game
     * @param decks ArrayList of Decks used in MagentaSpaces
     *
     */
    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> decks) {
        System.out.println("I just gave birth");

        if (p.isMarried()) {
            p.addKids(1);
            for (Player other : others)
                if (!p.equals(other))
                    if (other.isMarried() && !other.getIsRetired())
                        p.updateCash(5000 * other.getNumKids());

        }
    }
}
