package phase1.Cards.BlueCard;

import phase1.Player;

/**
 * Blue card interface for normal blue cards.
 */
public interface NormalAction {
    /**
     * Executes action to be done by a specific blue card.
     * @param p current player.
     * @param otherPlayers list of other players inside the game.
     */
    void activate(Player p, Player[] otherPlayers);
}
