package phase1.Spaces.MagentaSpace;


import java.util.ArrayList;
import phase1.Player;
import phase1.Deck;
import phase1.Spaces.ActionSpace;

public class GraduationSpace extends MagentaSpace implements ActionSpace {
    public GraduationSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Just Graduated";
        this.longDescription = "You finished college and finally graduated. You earned your degree.";

    }

    @Override
    public void doAction(Player p, Player[] others, ArrayList<Deck> decks) {
            p.setHasDegree(true);
    }
}

