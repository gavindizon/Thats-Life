package Model.Spaces.MagentaSpace;


import java.util.ArrayList;
import Model.Player;
import Model.Deck;
import Model.Spaces.ActionSpace;
/**
 * Implements a Graduation Space that extends from the Magenta Space and implements the
 * ActionSpace interface.
 *
 */
public class GraduationSpace extends MagentaSpace implements ActionSpace {

    /**
     * Initializes the path and max num of players based from the inherited constructor
     * assigns the action description and long description
     * @param path
     * @param noOfPlayers
     */

    public GraduationSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Just Graduated";
        this.longDescription = "You finished college and finally graduated. You earned your degree.";

    }

    /**
     * Sets the player degree to true
     * @param p player
     * @param others other players
     * @param decks all decks used in magenta space
     */
    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> decks) {
            p.setHasDegree(true);
    }
}

