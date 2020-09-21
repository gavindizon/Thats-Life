package phase1.Spaces;

import phase1.Deck;
import phase1.Player;
import java.util.ArrayList;

public abstract class MagentaSpace extends Space {

    public MagentaSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.type = "Magenta Space";
    }


     public void doAction(Player p, Player[] others, ArrayList<Deck> decks){
         System.out.println();
     }


}
