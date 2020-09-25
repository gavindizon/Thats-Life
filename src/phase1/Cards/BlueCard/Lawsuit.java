package phase1.Cards.BlueCard;

import phase1.Player;

public class Lawsuit extends BlueCard implements NormalAction {
    double amount;

    public Lawsuit(String description, String career, double amount) {
        super(description, career);
        this.amount = (int) amount;
        this.longDescription = "The player pays the amount indicated on the card. The amount is a multiple of $10000 and [$50000, $150000]. " +
                "The amount is randomly generated and fixed at the start of every game.";
    }

    @Override
    public void activate(Player p, Player[] otherPlayers) {
        Player playerMatched = this.othersMatched(otherPlayers);
        if (this.careerMatches(p.getCareer())) {
            p.updateCash(this.amount);
        } else if (playerMatched != null) {
            playerMatched.updateCash(this.amount);
            p.updateCash(-this.amount);
        } else {
            p.updateCash(-this.amount);
        }
    }

}
