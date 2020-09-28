package Model.Cards.ActionCard;

import Model.Player;

/**
 * implements a CollectFromBank that inherits the ActionCard
 */
public class CollectFromBank extends ActionCard {

    /**
     * access the super class constructor(from ActionCard)
     * @param description description of the card
     *
     * @param toAll a boolean value whether the effect of the card is to all or not
     */
    public CollectFromBank(String description, boolean toAll) {
        super(description, toAll);
    }
    /**
     * player collects from the bank given the amount of the card
     *
     * @param players Array of players in the game
     * @param currPlayerIndex current index of the player
     */

    @Override
    public void activate(Player[] players, int currPlayerIndex) {
        //System.out.println("activated collect from bank");

        players[currPlayerIndex].updateCash(this.getValue());
    }

}