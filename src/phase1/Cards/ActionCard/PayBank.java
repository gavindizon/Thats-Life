package phase1.Cards.ActionCard;

import phase1.Player;
/**
 * implements a PayBank that inherits the ActionCard
 */
public class PayBank extends ActionCard {
    /**
     * access the super class constructor(from ActionCard)
     * @param description description of the card
     *
     * @param toAll a boolean value whether the effect of the card is to all or not
     */

    public PayBank(String description, boolean toAll) {
        super(description, toAll);
    }

    /**
     * player pays the bank given the amount of the card
     *
     * @param players Array of players in the game
     * @param currPlayerIndex current index of the player
     */
    @Override
    public void activate(Player[] players, int currPlayerIndex) {
        System.out.println("activated pay bank");

        players[currPlayerIndex].updateCash(-this.getValue());

        // System.out.println("paid bank");
    }

}
