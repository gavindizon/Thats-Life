package phase1.Cards.BlueCard;

import java.util.Scanner;
import phase1.Player;

public class TipTheServer extends BlueCard implements RandomAction{
    public TipTheServer(String description, String career) {
        super(description, career);
    }

    @Override
    public void activate(Player p, Player[] otherPlayers, int number) {
        double tip = number * 1000;
        System.out.println(tip);
        Player playerMatched = this.othersMatched(otherPlayers);
        if (this.careerMatches(p.getCareer())) {
            p.updateCash(tip);
        } else if (playerMatched != null) {
            playerMatched.updateCash(tip);
            p.updateCash(-tip);
        } else {
            p.updateCash(-tip);
        }
    }

}
