package phase1.Cards.BlueCard;

import phase1.Player;

public class Lawsuit extends BlueCard implements NormalAction {
    double amount;

    public Lawsuit(String description, String career, double amount) {
        super(description, career);
        this.amount = amount;
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
