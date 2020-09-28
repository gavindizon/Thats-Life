package Model.Spaces.GreenSpace;

import Model.Player;
import Model.Deck;
import Model.Spaces.ActionSpace;

import java.util.ArrayList;

/**
 * Implements a PayDaySpace that inherits from GreenSpace and implements
 * the ActionSpace interface
 *
 */
public class PayDaySpace extends GreenSpace implements ActionSpace {


    /**
     * Initializes the path and max num of players based from the inherited constructor
     * assigns the action description and long description
     * @param path
     * @param noOfPlayers
     */
    public PayDaySpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Pay Day Space";
        this.longDescription = "Collect your salary!";
    }
    /**
     * If the player has a salary card, player collects their salary money
     * @param p
     * @param others
     * @param decks
     */

    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> decks) {
        if(p.getSalaryCard() != null)
            p.updateCash(p.getSalaryCard().getSalary());
    }

}
