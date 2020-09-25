package phase1.Cards;

public abstract class Card {
    protected String cardType;
    protected String description;
    protected String longDescription;

    // public abstract String getDescription();

    public Card(String cardType) {
        this.cardType = cardType;
    }

    public Card(String cardType, String description, String longDescription){
        this.cardType = cardType;
        this.description = description;
        this.longDescription = longDescription;
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
