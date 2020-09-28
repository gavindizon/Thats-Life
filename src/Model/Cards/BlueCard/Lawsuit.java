package Model.Cards.BlueCard;

import Model.Player;

/**
 * implements Lawsuit which inherits the BlueCard and implements
 * the NormalAction interface also has an amount attribute
 */

public class Lawsuit extends BlueCard implements NormalAction {
    double amount;
    /**
     * Calls the super class constructor (BlueCard) and initializes
     * the Lawsuit given description and career
     * @param description String description
     * @param career String career
     */

    public Lawsuit(String description, String career, double amount) {
        super(description, career);
        this.amount = (int) amount;
        this.longDescription = "The player pays the amount indicated on the card. The amount is a multiple of $10000 and [$50000, $150000]. " +
                "The amount is randomly generated and fixed at the start of every game.";
    }

    /**
     *
     * The user collects $15000 if it matches with his career.
     * The user pays the amount randomly generated ranging [$50000, $150000] to the owner of the career if it matches
     * with another player's career
     * The user pays the amount randomly generated ranging [$50000, $150000] to the bank if it doesnt match with
     * any of the player
     *
     * @param p current player
     * @param otherPlayers other players
     */

    @Override
    public void activate(Player p, Player[] otherPlayers) {
        Player playerMatched = this.othersMatched(otherPlayers);
        if (this.careerMatches(p.getCareer())) {
            p.updateCash(15000);
        } else if (playerMatched != null) {
            playerMatched.updateCash(this.amount);
            p.updateCash(-this.amount);
        } else {
            p.updateCash(-this.amount);
        }
    }

}
