package Model.Spaces;

import java.util.ArrayList;
import Model.Player;

/**
 * implements an abstract Space which consists of the path, the players inside the space,
 * a boolean value which determines whether the space is a junction, The String of the
 * type, action description, and long description of the space.
 */
public abstract class Space {
    private String path;
    private ArrayList<Player> players;
    private boolean junctionStart;
    protected String type; //
    protected String actionDescription; //
    protected String longDescription; //


    /**
     * Initializes the space given a string path and the max number of players in the space
      * @param path String path
     * @param noOfPlayers int number of players
     */
    public Space(String path, int noOfPlayers) {
        this.players = new ArrayList<>(noOfPlayers);
        this.path = path;
        this.junctionStart = false;
    }

    /**
     * set's whether the space is a junction or not
     * @param junctionStart boolean value of junction
     */
    public void setJunctionStart(boolean junctionStart) {
        this.junctionStart = junctionStart;
    }

    /**
     * Returns whether the space is the start of the junction or not
     *
     * @return whether the space is the start of the junction or not
     */
    public boolean isJunctionStart() {
        return junctionStart;
    }

    /**
     * Returns the type
     *
     * @return String value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the description of the action of the space
     * @return String actionDescription
     */
    public String getActionDescription() {
        return actionDescription;
    }

    /**
     * Returns a long description of the space of the space
     * @return String longDescription
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * Returns the path where the space is located
     * @return String path
     */
    public String getPath() {
        return path;
    }

    /**
     * Returns the list of players in the space
     * @return ArrayList of Players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }



}
