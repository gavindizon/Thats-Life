package phase1.Cards;

import phase1.Player;

public class SalaryTaxDue extends BlueCard {

    public SalaryTaxDue(String description, String career) {
        super(description, career);
    }

    @Override
    public void activate(Player p, Player[] otherPlayers) {
        Player playerMatched = this.othersMatched(otherPlayers);
        double playerTax = p.getSalaryCard().getTax();
        if (this.careerMatches(p.getCareer())) {
            p.updateCash(playerTax);
        } else if (playerMatched != null) {
            playerMatched.updateCash(playerTax);
            p.updateCash(-playerTax);
        } else {
            p.updateCash(-playerTax);
        }
    }
}
