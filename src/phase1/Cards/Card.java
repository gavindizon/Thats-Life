package phase1.Cards;

public abstract class Card {
    String cardType;
    String description;
    String longDescription;

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

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

}
