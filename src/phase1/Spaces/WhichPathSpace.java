package phase1.Spaces;

import java.util.ArrayList;
import java.util.Scanner;
import phase1.Player;
import phase1.Deck;

public class WhichPathSpace extends MagentaSpace implements ChoiceSpace{
    Scanner sc = new Scanner(System.in);
    int chosenPath;

    public WhichPathSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
    }

//    public void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks) {
//        System.out.println("So anong pipiliin natin?");
//
//        if (p.getSpaceTracker() == 38) {
//            System.out.println("Choose Path: ");
//            System.out.println("[1] - Change Career");
//            System.out.println("[2] - Main");
//            chosenPath = Integer.parseInt(sc.nextLine());
//            if (chosenPath == 1) {
//                p.teleportToSpace(39);
//            } else {
//                p.teleportToSpace(48);
//            }
//        } else {
//            System.out.println("Choose Path: ");
//            System.out.println("[1] - Start a Family");
//            System.out.println("[2] - Main");
//            chosenPath = Integer.parseInt(sc.nextLine());
//            if (chosenPath == 1) {
//                p.teleportToSpace(71);
//            } else {
//                p.teleportToSpace(81);
//            }
//
//        }
//
//    }

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
        System.out.println("choice");
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
