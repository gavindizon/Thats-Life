package phase1.Cards;

import phase1.Player;

public class CollectFromBank extends ActionCard {

    public CollectFromBank(String description, boolean toAll) {
        super(description, toAll);
    }

    // @Override
    public void activate(Player p) {
        p.updateCash(this.getValue());
    }

}
