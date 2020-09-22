package phase1.Spaces;

import java.util.ArrayList;

import phase1.Cards.BlueCard;
import phase1.Cards.HouseCard;
import phase1.Player;
import phase1.Deck;

public class BuyHouseSpace extends MagentaSpace implements NoChoiceSpace{
    public BuyHouseSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Buy a House";
        this.longDescription = "Your parents don't want you to live with them anymore. You need to buy a house.";

    }

    @Override
    public void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks) {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXx");
        HouseCard h = (HouseCard) decks.get(2).drawCard();
        p.setHouse(h);

    }

}
