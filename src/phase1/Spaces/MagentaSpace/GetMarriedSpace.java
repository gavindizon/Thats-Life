package phase1.Spaces.MagentaSpace;

import java.util.ArrayList;
import phase1.Player;
import phase1.Deck;
import phase1.Spaces.ActionSpace;

public class GetMarriedSpace extends MagentaSpace implements ActionSpace {
    private int number;

    public GetMarriedSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Just Got Married";
        this.longDescription = "Congratulation You married the love of your life.";

    }

    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> decks) {
        if(!p.isMarried()){
            System.out.println("I just got Married");
            p.setMarried(true);

            if (isEven()) {
                System.out.println("Number generated is even");
                for (Player player : others) {
                    if (!p.equals(player) && !player.getIsRetired()) {
                        player.updateCash(-10000);
                        p.updateCash(10000);
                    }
                }
            } else {
                System.out.println("Number generated is odd");
                for (Player player : others) {
                    if (!p.equals(player) && !player.getIsRetired()) {
                        player.updateCash(-5000);
                        p.updateCash(5000);
                    }
                }
            }
        }

    }

    public void setNumber(int number) {
        this.number = number;
    }

    private boolean isEven() {
        if (this.number % 2 == 0)
            return true;
        else
            return false;
    }
}
