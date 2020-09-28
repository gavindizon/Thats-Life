package Model.Spaces.MagentaSpace;

import java.util.ArrayList;
import Model.Player;
import Model.Deck;
import Model.Spaces.ActionSpace;

/**
 * Implements a GetMarriedSpace that extends from the Magenta Space and implements the
 * ActionSpace interface also stores a number that is used to store the randomly generated number
 *
 */
public class GetMarriedSpace extends MagentaSpace implements ActionSpace {
    private int number;
    /**
     * Initializes the path and max num of players based from the inherited constructor
     * assigns the action description and long description
     * @param path
     * @param noOfPlayers
     */
    public GetMarriedSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Just Got Married";
        this.longDescription = "Congratulation You married the love of your life.";

    }

    /**
     * Sets the married status of player to true if not yet set.
     * Also, updates cash based from the randomly rolled number whether it is even or not
     * @param p player
     * @param decks Array of Decks used in magenta
     * @param choice index value of the choice of the player
     */

    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> decks) {
        if(!p.isMarried()){
       //     System.out.println("I just got Married");
            p.setMarried(true);

            if (isEven()) {
       //         System.out.println("Number generated is even");
                for (Player player : others) {
                    if (!p.equals(player) && !player.getIsRetired()) {
                        player.updateCash(-10000);
                        p.updateCash(10000);
                    }
                }
            } else {
             //   System.out.println("Number generated is odd");
                for (Player player : others) {
                    if (!p.equals(player) && !player.getIsRetired()) {
                        player.updateCash(-5000);
                        p.updateCash(5000);
                    }
                }
            }
        }

    }

    /**
     * sets the random number
     *
     * @param number retrieved random number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Returns a boolean value whether the number is even or not
     * @return true if even; false if not
     */
    private boolean isEven() {
        if (this.number % 2 == 0)
            return true;
        else
            return false;
    }
}
