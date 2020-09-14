package phase1.Cards;

import phase1.Player;

public class WorldCup extends BlueCard {
    public WorldCup(String description, String career) {
        super(description, career);
    }

    @Override
    public void activate(Player p, Player[] otherPlayers) {
        Player playerMatched = this.othersMatched(otherPlayers);
        double multiplier = 5000;
        double amount = otherPlayers.length * multiplier;
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
