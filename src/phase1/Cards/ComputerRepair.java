package phase1.Cards;

import java.util.Scanner;
import phase1.Player;

public class ComputerRepair extends BlueCard {
    public ComputerRepair(String description, String career) {
        super(description, career);
    }

    @Override
    public void activate(Player p, Player[] otherPlayers) {
        Player playerMatched = this.othersMatched(otherPlayers);
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter to generate a number");
        sc.nextLine();
        int number = (int) (Math.random() * 9);
        System.out.println(number);

        double amount;
        if (number % 2 == 0) {
            amount = 5000;
        } else {
            amount = 10000;
        }

        if (this.careerMatches(p.getCareer())) {
            p.updateCash(amount);
        } else if (playerMatched != null) {
            playerMatched.updateCash(amount);
            p.updateCash(-amount);
        } else {
            p.updateCash(-amount);
        }

        sc.close();
    }
}
