package phase1.Spaces;

import java.util.ArrayList;
import java.util.Scanner;
import phase1.Player;
import phase1.Deck;

public class WhichPathSpace extends MagentaSpace implements ChoiceSpace{

    public WhichPathSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Which Path";
        this.longDescription = "Choose from two different paths you want to take.";

    }

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
