package phase1.Spaces.MagentaSpace;

import phase1.Deck;
import phase1.Player;
import phase1.Spaces.Space;

import java.util.ArrayList;

/**
 * An abstract class that inherits the Space
 */
public abstract class MagentaSpace extends Space {

    /**
     * Initializes the path and max num of players based from the inherited constructor
     * assigns the string type to magenta space
     * @param path
     * @param noOfPlayers
     */
    public MagentaSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.type = "Magenta Space";
    }

}
