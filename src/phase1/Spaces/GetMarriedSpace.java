package phase1.Spaces;

import java.util.ArrayList;
import phase1.Player;
import phase1.Deck;

public class GetMarriedSpace extends MagentaSpace {
    public GetMarriedSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
    }

    public void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks) {
        System.out.println("I just got Married");
        p.setMarried(true);

        if (isEven()) {
            System.out.println("Number generated is even");
            for (Player player : others) {
                if (!p.equals(player) == true) {
                    player.updateCash(-10000);
                    p.updateCash(10000);
                }
            }
        } else {
            System.out.println("Number generated is even");
            for (Player player : others) {
                if (!p.equals(player) == true) {
                    player.updateCash(-5000);
                    p.updateCash(5000);
                }
            }
        }
    }

    private boolean isEven() {
        if ((int) (Math.random() * (9 - 1 + 1) + 1) % 2 == 0)
            return true;
        else
            return false;
    }
}
