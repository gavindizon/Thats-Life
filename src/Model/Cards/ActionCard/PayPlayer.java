package Model.Cards.ActionCard;

import Model.Player;
/**
 * implements a PayPlayer that inherits the ActionCard
 */
public class PayPlayer extends ActionCard {
    /**
     * access the super class constructor(from ActionCard)
     * @param description description of the card
     *
     * @param toAll a boolean value whether the effect of the card is to all or not
     */

    public PayPlayer(String description, boolean toAll) {
        super(description, toAll);
    }

    /**
     * Pays a certain player player if the toAll attribute is false and
     * pays all non retired players if true.
     *
     * @param players Array of players in the game
     * @param currPlayerIndex current index of the player
     */
    @Override
    public void activate(Player[] players, int currPlayerIndex) {
        // differentiate choose players and to all from gui
        System.out.println("activated pay player");
        System.out.println(players.length);
        if(this.getToAll()){
            double value = 0;
            for(int i = 0; i < 2; i++){
                if(i != currPlayerIndex && !players[i].getIsRetired()){
                    players[i].updateCash(this.getValue());
                    value += this.getValue();
                }
            }
            players[currPlayerIndex].updateCash(-value);
        }
        else{
            players[0].updateCash(this.getValue());
            players[currPlayerIndex].updateCash(-this.getValue());
        }

    }

}
