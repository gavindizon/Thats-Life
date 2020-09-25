package phase1.Cards.BlueCard;

import phase1.Player;

public class F1Race extends BlueCard implements NormalAction {
    public F1Race(String description, String career) {
        super(description, career);
    }

    @Override
    public void activate(Player p, Player[] otherPlayers) {
        Player playerMatched = this.othersMatched(otherPlayers);
        double amount = (int) p.getSalaryCard().getSalary() * 0.10;
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
