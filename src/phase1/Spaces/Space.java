package phase1.Spaces;

import java.util.ArrayList;
import phase1.Player;
import phase1.Deck;

public abstract class Space {
    private String path;
    private ArrayList<Player> players;

    public Space(String path, int noOfPlayers) {
        this.players = new ArrayList<>(noOfPlayers);
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public abstract void doAction(Player p, Player[] others, ArrayList<Deck> decks);

    /*
     * public String identifySpace() { if (this instanceof OrangeSpace) return
     * "Orange"; else if (this instanceof MagentaSpace) return "Magenta"; else if
     * (this instanceof BlueSpace) return "Blue"; else return "Green"; }
     */

}
