package phase1.Cards.BlueCard;

import phase1.Game;
import phase1.Player;

public class ComputerRepair extends BlueCard implements RandomAction {
    public ComputerRepair(String description, String career) {
        super(description, career);
    }

    @Override
    public void activate(Player p, Player[] otherPlayers, int number) {
        Player playerMatched = this.othersMatched(otherPlayers);
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

    }
}
