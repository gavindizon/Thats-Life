package phase1.Cards;

import phase1.Player;

public abstract class BlueCard extends Card {

    private String description;
    private String career;

    public BlueCard(String description, String career) {
        super("Blue Card");
        this.description = description;
        this.career = career;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCareer() {
        return this.career;
    }

    public boolean careerMatches(String career) {
        return this.career.equals(career);
    }

    public Player othersMatched(Player[] otherPlayers) {
        for (int i = 0; i < otherPlayers.length; i++) {
            if (otherPlayers[i].getCareer().equals(this.career))
                return otherPlayers[i];
        }
        return null;

        // for(String c : otherPlayers.getCareer())
        // return this.career(equals)
    }

    public abstract void activate(Player p, Player[] otherPlayers);

}
