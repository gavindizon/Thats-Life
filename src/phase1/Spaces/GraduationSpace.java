package phase1.Spaces;


import java.util.ArrayList;
import phase1.Player;
import phase1.Deck;

public class GraduationSpace extends MagentaSpace implements NoChoiceSpace {
    public GraduationSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Just Graduated";
        this.longDescription = "You finished college and finally graduated. You earned your degree.";

    }

    @Override
    public void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks) {
            p.setHasDegree(true);
    }
}

