package phase1.Cards.BlueCard;

import phase1.Player;

/**
 * implements F1Race which inherits the BlueCard and implements
 * the NormalAction interface
 */
public class F1Race extends BlueCard implements NormalAction {

    /**
     * Calls the super class constructor (BlueCard) and initializes
     * the F1Race given description and career
     * @param description String description
     * @param career String career
     */

    public F1Race(String description, String career) {
        super(description, career);
        this.longDescription = "The player pays 10% of his current salary.\n";
    }

    @Override
    public void activate(Player p, Player[] otherPlayers) {
        Player playerMatched = this.othersMatched(otherPlayers);
        double amount = (int) p.getSalaryCard().getSalary() * 0.10;
        if (this.careerMatches(p.getCareer())) {
            p.updateCash(15000);
        } else if (playerMatched != null) {
            playerMatched.updateCash(amount);
            p.updateCash(-amount);
        } else {
            p.updateCash(-amount);
        }
    }
}
