package phase1.Cards;

import phase1.Player;

public class PayBank extends ActionCard {

    public PayBank(String description, boolean toAll) {
        super(description, toAll);
    }

    @Override
    public void activate(Player[] players, int currPlayerIndex) {
        System.out.println("activated pay bank");

        players[currPlayerIndex].updateCash(-this.getValue());

        // System.out.println("paid bank");
    }

}
