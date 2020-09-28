package Model.Cards.BlueCard;

import Model.Player;
/**
 * implements SkiAccident which inherits the BlueCard and implements
 * the NormalAction interface
 */

public class SkiAccident extends BlueCard implements NormalAction {

    /**
     * Calls the super class constructor (BlueCard) and initializes
     * the SkiAccident given description and career
     * @param description String description
     * @param career String career
     */

    public SkiAccident(String description, String career) {
        super(description, career);
        this.longDescription = "The player pays $10000.";
    }

    /**
     *
     * The user collects $15000 if it matches with his career.
     * On the other hand, if it matches with another player.
     * the user pays $10000 to the player who is the owner of the career
     * Otherwise, the user pays $10000 to the bank.
     *
     * @param p current player
     * @param otherPlayers
     */
    @Override
    public void activate(Player p, Player[] otherPlayers) {
        Player playerMatched = this.othersMatched(otherPlayers);
        double amount = 10000;
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
