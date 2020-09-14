package phase1.Spaces;

import java.util.ArrayList;
import phase1.Player;
import phase1.Deck;

public class BuyHouseSpace extends MagentaSpace {
    public BuyHouseSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
    }

    public void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks) {
        System.out.println("I just bought a house");
    }

}
