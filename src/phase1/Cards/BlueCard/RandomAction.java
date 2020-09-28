package phase1.Cards.BlueCard;

import phase1.Player;

/**
 * Interface for blue cards that have random number generator.
 *
 */
public interface RandomAction {

    /**
     * Executes action to be done by a specific blue card.
     * @param p current player.
     * @param otherPlayers list of other players in the game.
     * @param randomNum random number spun by the current player.
     */
    void activate(Player p, Player[] otherPlayers, int randomNum);

}
