package phase1.Spaces;

import java.util.ArrayList;
import java.util.Scanner;
import phase1.Player;
import phase1.Deck;

public class WhichPathSpace extends MagentaSpace {
    Scanner sc = new Scanner(System.in);
    int chosenPath;

    public WhichPathSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
    }

    public void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks) {
        System.out.println("So anong pipiliin natin?");

        if (p.getSpaceTracker() == 0) {
            System.out.println("Choose Path: ");
            System.out.println("[1] - College");
            System.out.println("[2] - Career");
            chosenPath = Integer.parseInt(sc.nextLine());
            if (chosenPath == 1) {
                p.teleportToSpace(12);
            } else {
                p.teleportToSpace(1);
            }
        } else if (p.getSpaceTracker() == 38) {
            System.out.println("Choose Path: ");
            System.out.println("[1] - Change Career");
            System.out.println("[2] - Main");
            chosenPath = Integer.parseInt(sc.nextLine());
            if (chosenPath == 1) {
                p.teleportToSpace(39);
            } else {
                p.teleportToSpace(48);
            }
        } else {
            System.out.println("Choose Path: ");
            System.out.println("[1] - Start a Family");
            System.out.println("[2] - Main");
            chosenPath = Integer.parseInt(sc.nextLine());
            if (chosenPath == 1) {
                p.teleportToSpace(71);
            } else {
                p.teleportToSpace(81);
            }

        }

    }

}
