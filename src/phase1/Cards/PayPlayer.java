package phase1.Cards;

import java.util.Scanner;
import phase1.Player;

public class PayPlayer extends ActionCard {

    public PayPlayer(String description, boolean toAll) {
        super(description, toAll);
    }

    // @Override
    public void activate(Player p, Player[] otherPlayers) {
        if (this.getToAll()) {
            for (Player player : otherPlayers) {
                if (!p.equals(player) == true) {
                    player.updateCash(this.getValue());
                    p.updateCash(-this.getValue());
                }
            }
        } else {
            int i = 0;
            int currPlayerIndex = 0;
            int chosenPlayer = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose a player");
            for (Player player : otherPlayers) {
                if (!p.equals(player) == true) {
                    System.out.printf("[%d] - Player %d\n", i + 1, i + 1);
                } else {
                    currPlayerIndex = i;
                }
                i++;
            }
            do {
                try {
                    System.out.print("Enter : ");
                    chosenPlayer = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Player not found");
                }
            } while (currPlayerIndex == chosenPlayer - 1 || chosenPlayer < 1 || chosenPlayer > i);
            otherPlayers[chosenPlayer - 1].updateCash(this.getValue());
            p.updateCash(-this.getValue());
        }

    }

}
