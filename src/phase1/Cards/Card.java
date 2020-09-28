package phase1.Cards;

/**
 * an abstract class, Card that has a cardtype, description and long description
 */
public abstract class Card {
    protected String cardType;
    protected String description;
    protected String longDescription;

    /**
     * assigns the type of card given the string
     *
     * @param cardType Type of card
     */
    public Card(String cardType) {
        this.cardType = cardType;
    }

    /**
     * assigns the type of card, description, long description given the corresponding String
     *
     * @param cardType  Type of card
     * @param description description of card
     * @param longDescription a longer description of card
     */
    public Card(String cardType, String description, String longDescription){
        this.cardType = cardType;
        this.description = description;
        this.longDescription = longDescription;
    }

    /**
     * returns the type of card of the card
     *
     * @return cardType
     */
    public String cardType() {
        return this.cardType;
    }

    /**
     * returns the description of the card
     *
     * @return descriptionCard
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the longer description of the card given the string
     *
     * @param longDescription String of the long description to be set
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     * returns the value of the longDescription String
     *
     * @return long description String
     */
    public String getLongDescription() {
        return longDescription;
    }

}
