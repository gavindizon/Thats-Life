package phase1.Spaces.GreenSpace;

import phase1.Player;
import phase1.Deck;
import phase1.Spaces.Space;

import java.util.ArrayList;
/**
 * implements an abstract GreenSpace that inherits from Space
 */

public abstract class GreenSpace extends Space {
    /**
     * initializes the Green Space given the path and the number of players in the game
     *
     * @param path name of the path of the space initialized
     * @param noOfPlayers number of players in the game
     */

    public GreenSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.type = "Green Space";

    }
}
