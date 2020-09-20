package phase1.Spaces;


import java.util.ArrayList;
import phase1.Player;
import phase1.Deck;

public class GraduationSpace extends MagentaSpace{
    public GraduationSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
    }

    @Override
    public void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks) {
            p.setHasDegree(true);
        }
    }

