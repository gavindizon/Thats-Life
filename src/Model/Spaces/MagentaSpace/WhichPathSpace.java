package Model.Spaces.MagentaSpace;

import java.util.ArrayList;

import Model.Player;
import Model.Deck;
/**
 * implements a WhichPathSpace that inherits MagentaSpace and implements
 * ChoiceSpace interface
 */

public class WhichPathSpace extends MagentaSpace implements ChoiceSpace{

    /**
     * Initializes the path and max num of players based from the inherited constructor
     * assigns the action description and long description
     * @param path
     * @param noOfPlayers
     */

    public WhichPathSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Which Path";
        this.longDescription = "Choose from two different paths you want to take.";

    }

    /**
     * Teleports player to a certain space depending on the choice
     * @param p current player
     * @param decks ArrayList of Decks in a Magenta Space
     * @param choice choice of player
     */
    @Override
    public void doMagentaAction(Player p, ArrayList<Deck> decks, int choice){
        if(p.getSpaceTracker() == 38){
            if(choice == 1){
                p.teleportToSpace(39);
            } else{
                p.teleportToSpace(48);
            }
        } else{
            if(choice == 1){
                p.teleportToSpace(71);
            } else{
                p.teleportToSpace(81);
            }
        }

//        System.out.println("choice");
    }
    /**
     * Gets the array of string of choices to be shown to the user
     *
     * @param p current player
     * @param decks used in Magenta Spaces
     * @return String of choices available
     */
    @Override
    public String[] getChoices(Player p, ArrayList<Deck> decks){
        String[] s = new String[2];
        s[1] = "Main";
        if(p.getSpaceTracker() == 38){
            s[0] = "Change career";
        } else{
            s[0] = "Start a Family";
        }
        return s;
    }

}
