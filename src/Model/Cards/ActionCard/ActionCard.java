package Model.Cards.ActionCard;

import Model.Cards.Card;
import Model.Player;

/**
 * implements an Action Card that has a description a cash value and a type. It
 * also has a boolean toAll which sets whether the cash value will be
 * distributed to all.
 */

public abstract class ActionCard extends Card {
    private boolean toAll;
    private double value;

    /**
     * Creates an action card object with the specified type
     * 
     * @param description description of the card
     *
     * @param toAll a boolean value whether the effect of the card is to all or not
     *
     */
    public ActionCard(String description, boolean toAll) {
        super("Action Card");
        this.description = description;
        this.toAll = toAll;
        this.value = 1000 * ((int) (Math.random() * 9) + 1); // multiply 100 to a number (1-100)
        setLongDescription();
    }

    /**
     * returns the description of the action card
     * 
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * returns the cash value of the action card
     * 
     * @return value
     */

    public double getValue() {
        return this.value;
    }

    /**
     * returns whether the boolean toAll of the action card
     * 
     * @return toAll
     */

    public boolean getToAll() {
        return this.toAll;
    }

    public void setLongDescription() {
        if (this instanceof PayBank) {
            this.longDescription = "Pay the Bank $" + this.value;
        } else if (this instanceof PayPlayer) {
            if (this.toAll)
                this.longDescription = "Pay each player $" + this.value;
            else
                this.longDescription = "Pay a player $" + this.value;
        } else if (this instanceof CollectFromBank) {
            this.longDescription = "Collect $" + this.value + " from the Bank";
        } else {
            if (this.toAll)
                this.longDescription = "Collect $" + this.value + " from each player";
            else
                this.longDescription = "Collect $" + this.value + " from a player";
        }

    }

    /**
     * abstract method that activates the effect of the card
     * @param players Array of players in the game
     * @param currPlayerIndex current index of the player
     */
    public abstract void activate(Player[] players, int currPlayerIndex);
}