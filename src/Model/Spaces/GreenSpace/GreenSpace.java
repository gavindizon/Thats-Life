package Model.Spaces.GreenSpace;

import Model.Spaces.Space;

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
