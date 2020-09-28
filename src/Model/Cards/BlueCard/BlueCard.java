package Model.Cards.BlueCard;

import Model.Cards.Card;
import Model.Player;

/**
 * an abstract class, BlueCard which inherits the Card
 * also has a description and career String
 */
public abstract class BlueCard extends Card {

    private String description;
    private String career;

    /**
     * Calls the super class constructor of Card
     * and initializes the BlueCard given
     * the description and career
     *
     * @param description String description
     * @param career String career
     */
    public BlueCard(String description, String career) {
        super("Blue Card");
        this.description = description;
        this.career = career;
    }

    /**
     * returns the value of the description
     *
     * @return String description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * returns the value of the career
     *
     * @return String career
     */
    public String getCareer() {
        return this.career;
    }

    /**
     * Checks whether the career of the player matches with
     * the career of the Blue Card
     *
     * returns true if it matches, false otherwise
     *
     * @param career String career
     * @return boolean true if matches, false otherwise
     */
    public boolean careerMatches(String career) {
        return this.career.equals(career);
    }

    /**
     * Looks for the other player that matches with the
     * career, and returns the player. If no match, returns null
     *
     * @param otherPlayers
     * @return null if no match, player if matcher
     */
    public Player othersMatched(Player[] otherPlayers) {
        for (int i = 0; i < otherPlayers.length; i++) {
            if (otherPlayers[i].getCareer().equals(this.career) && !otherPlayers[i].getIsRetired())
                return otherPlayers[i];
        }
        return null;
        
    }


}
