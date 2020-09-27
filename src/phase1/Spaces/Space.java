package phase1.Spaces;

import java.util.ArrayList;
import phase1.Player;
import phase1.Deck;
import phase1.Spaces.MagentaSpace.*;

public abstract class Space {
    private String path;
    private ArrayList<Player> players;
    private boolean junctionStart;
    protected String type; //
    protected String actionDescription; //
    protected String longDescription; //

    public Space(String path, int noOfPlayers) {
        this.players = new ArrayList<>(noOfPlayers);
        this.path = path;
        this.junctionStart = false;
    }

    public void setJunctionStart(boolean junctionStart) {
        this.junctionStart = junctionStart;
    }

    public boolean isJunctionStart() {
        return junctionStart;
    }

    public String getType() {
        return type;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getPath() {
        return path;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }



}
