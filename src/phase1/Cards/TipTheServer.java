package phase1.Cards;

import java.util.Scanner;
import phase1.Player;

public class TipTheServer extends BlueCard {
    public TipTheServer(String description, String career) {
        super(description, career);
    }

    @Override
    public void activate(Player p, Player[] otherPlayers) {
        // System.out.println("Tip server");
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter to generate a number");
        sc.nextLine();
        double tip = (int) (Math.random() * 9) * 1000;
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
        sc.close();
    }

}
