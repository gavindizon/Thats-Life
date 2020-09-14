package phase1.Cards;

import phase1.Player;

public abstract class Card {
    String cardType;
    String description;

    // public abstract String getDescription();

    public Card(String cardType) {
        this.cardType = cardType;
    }

    public String cardType() {
        return this.cardType;
    }

    public String getDescription() {
        return this.description;
    }

    // public abstract void activate();

}
