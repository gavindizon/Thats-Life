package phase1.Spaces;

import java.util.ArrayList;
import phase1.Player;
import phase1.Deck;
import phase1.Spaces.MagentaSpace.*;

public abstract class Space {
    private String path;
    private ArrayList<Player> players;
    private boolean junctionStart;
    protected String type; //
    protected String actionDescription; //
    protected String longDescription; //

    public Space(String path, int noOfPlayers) {
        this.players = new ArrayList<>(noOfPlayers);
        this.path = path;
        this.junctionStart = false;
    }

    public void setJunctionStart(boolean junctionStart) {
        this.junctionStart = junctionStart;
    }

    public boolean isJunctionStart() {
        return junctionStart;
    }

    public String getType() {
        return type;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getPath() {
        return path;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public abstract void doAction(Player p, Player[] others, ArrayList<Deck> decks);


      public String identifySpace() {
          if (this instanceof OrangeSpace) return "Orange";
          else if (this instanceof MagentaSpace){
              if(this instanceof GraduationSpace)
                  return "Graduation Space";
              else if(this instanceof CollegeCareerChoiceSpace)
                  return "College Career Choice Space";
              else if(this instanceof GetMarriedSpace)
                  return "Get Married Space";
              else if(this instanceof WhichPathSpace)
                  return "Junction";
              else
                  return "Magenta";

          }
          else if (this instanceof BlueSpace) return "Blue";
          else return "Green";

      }


}
