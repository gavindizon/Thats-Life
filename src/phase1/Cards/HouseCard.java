package phase1.Cards;

public class HouseCard extends Card{
    private String description;
    private int value;

    public HouseCard(String description, int value) {
        super("House Card");
        this.description = description;
        this.value = value;
    }


    public String getDescription() {
        return description;
    }

    public int getValue(){
        return value;
    }
}
