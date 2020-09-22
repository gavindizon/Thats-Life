package phase1.Spaces;

import java.util.ArrayList;

import phase1.Cards.HouseCard;
import phase1.Player;
import phase1.Deck;

public class BuyHouseSpace extends MagentaSpace implements ChoiceSpace{
    public BuyHouseSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Buy a House";
        this.longDescription = "Your parents don't want you to live with them anymore. You need to buy a house.";

    }

    @Override
    public void doMagentaAction(Player p, ArrayList<Deck> decks, int choice) {

        HouseCard h = (HouseCard) decks.get(2).getCards().get(choice);
        p.setHouse(h);
        p.updateCash(-h.getValue());
        decks.get(2).getCards().remove(choice);


    }

    @Override
    public String[] getChoices(Player p, ArrayList<Deck> decks) {
        String[] choices = new String[decks.get(2).getCards().size()];

        for(int i = 0; i < decks.get(2).getCards().size(); i++){
            HouseCard h = (HouseCard) decks.get(2).getCards().get(i);
            choices[i] = h.getDescription() + ": " + h.getValue();
        }

        return choices;

    }

    }
