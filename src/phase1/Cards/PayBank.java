package phase1.Cards;

import phase1.Player;

public class PayBank extends ActionCard {

    public PayBank(String description, boolean toAll) {
        super(description, toAll);
    }

    // @Override
    public void activate(Player p) {
        p.updateCash(-this.getValue());

        // System.out.println("paid bank");
    }

}
