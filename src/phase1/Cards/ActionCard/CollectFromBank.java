package phase1.Cards.ActionCard;

import phase1.Player;

public class CollectFromBank extends ActionCard {

    public CollectFromBank(String description, boolean toAll) {
        super(description, toAll);
    }

    @Override
    public void activate(Player[] players, int currPlayerIndex) {
        System.out.println("activated collect from bank");

        players[currPlayerIndex].updateCash(this.getValue());
    }

}
