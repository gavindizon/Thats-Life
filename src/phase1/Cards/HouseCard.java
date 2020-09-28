package phase1.Cards;

/**
 * implements a HouseCard that inherits the Card
 * has a description and value
 */
public class HouseCard extends Card{
    private String description;
    private int value;

    /**
     * Calls the super class constructor (Card) and
     * Initializes a house given the description and value
     * @param description
     * @param value
     */
    public HouseCard(String description, int value) {
        super("House Card");
        this.description = description;
        this.value = value;
    }

    /**
     * Returns the value of the String description
     *
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the value of the house
     *
     * @return int value
     */
    public int getValue(){
        return value;
    }
}
