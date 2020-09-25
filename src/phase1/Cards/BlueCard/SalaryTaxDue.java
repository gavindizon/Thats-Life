package phase1.Cards.BlueCard;

import phase1.Player;

public class SalaryTaxDue extends BlueCard implements NormalAction {

    public SalaryTaxDue(String description, String career) {
        super(description, career);
        this.longDescription = "The player pays the tax due for on his current salary.";
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
