package phase1.Cards.BlueCard;

import phase1.Player;

/**
 * implements SalaryTaxDue which inherits the BlueCard and implements
 * the NormalAction interface
 */
public class SalaryTaxDue extends BlueCard implements NormalAction {

    /**
     * Calls the super class constructor (BlueCard) and initializes
     * the SalaryTaxDue given description and career
     * @param description String description
     * @param career String career
     */

    public SalaryTaxDue(String description, String career) {
        super(description, career);
        this.longDescription = "The player pays the tax due for on his current salary.";
    }

    /**
     *
     * The user collects $15000 if it matches with his career
     * on the other hand, if the card matches with another players career,
     * the user pays the tax due for on his current salary to the owner of the career
     * otherwise, the user pays the tax due for on his current salary to the bank
     *
     * @param p current players
     * @param otherPlayers other players
     */
    @Override
    public void activate(Player p, Player[] otherPlayers) {
        Player playerMatched = this.othersMatched(otherPlayers);
        double playerTax = p.getSalaryCard().getTax();
        if (this.careerMatches(p.getCareer())) {
            p.updateCash(15000);
        } else if (playerMatched != null) {
            playerMatched.updateCash(playerTax);
            p.updateCash(-playerTax);
        } else {
            p.updateCash(-playerTax);
        }
    }
}
