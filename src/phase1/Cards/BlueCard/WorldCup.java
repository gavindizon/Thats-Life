package phase1.Cards.BlueCard;

import phase1.Player;

/**
 * implements WorldCup which inherits the BlueCard and implements
 * the NormalAction interface
 */

public class WorldCup extends BlueCard implements NormalAction {

    /**
     * Calls the super class constructor (BlueCard) and initializes
     * the ComputerRepair given description and career
     * @param description String description
     * @param career String career
     */

    public WorldCup(String description, String career) {
        super(description, career);
        this.longDescription = "The player pays number of players ×5000.";
    }

    /**
     *
     * The user collects $15000 if it matches with his career.
     * If it matches with another player's career, the user pays number of players ×
     * 5000 to the owner of the career. Otherwise, if no match, the user pays number
     * of players × 5000 to the bank.
     *
     * @param p
     * @param otherPlayers
     */
    @Override
    public void activate(Player p, Player[] otherPlayers) {
        Player playerMatched = this.othersMatched(otherPlayers);
        double multiplier = 5000;
        double amount = otherPlayers.length * multiplier;
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
