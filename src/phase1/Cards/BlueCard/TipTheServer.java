package phase1.Cards.BlueCard;

import java.util.Scanner;
import phase1.Player;
/**
 * implements TipTheServer which inherits from the BlueCard and
 * implements the RandomAction Interface
 *
 */

public class TipTheServer extends BlueCard implements RandomAction{

    /**
     * Calls the super class constructor (BlueCard) and initializes
     * the TipTheSever given description and career
     * @param description String description
     * @param career String career
     */



    public TipTheServer(String description, String career) {
        super(description, career);
        this.longDescription = "The player presses for a random number. He pays generated number ×1000.";
    }


    /**
     *
     * The user collects $15000 if it matches with his career. On the other hand,
     * A random number is generated and user pays generated number ×1000 to the owner of the career.
     * If it doesn't find a match. A random number is generated and user pays generated number ×1000 to the bank
     *
     * @param p player
     * @param otherPlayers other players in the game
     * @param number random number generated
     */



    @Override
    public void activate(Player p, Player[] otherPlayers, int number) {
        double tip = number * 1000;
        System.out.println(tip);
        Player playerMatched = this.othersMatched(otherPlayers);
        if (this.careerMatches(p.getCareer())) {
            p.updateCash(15000);
        } else if (playerMatched != null) {
            playerMatched.updateCash(tip);
            p.updateCash(-tip);
        } else {
            p.updateCash(-tip);
        }
    }

}
