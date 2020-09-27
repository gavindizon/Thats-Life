package phase1.Spaces.MagentaSpace;

import phase1.Deck;
import phase1.Player;
import phase1.Spaces.Space;

import java.util.ArrayList;

public abstract class MagentaSpace extends Space {

    public MagentaSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.type = "Magenta Space";
    }


//     public void doAction(Player p, Player[] others, ArrayList<Deck> decks){
//         System.out.println();
//     }


}
