package Model.Spaces.MagentaSpace;

import java.util.ArrayList;

import Model.Cards.HouseCard;
import Model.Player;
import Model.Deck;

/**
 * implements a BuyHouseSpace that implements the ChoiceSpace and inherits the
 * Magenta Space
 */
public class BuyHouseSpace extends MagentaSpace implements ChoiceSpace{

    /**
     * Initializes the path and max num of players based from the inherited constructor
     * assigns the action description and long description
     * @param path
     * @param noOfPlayers
     */

    public BuyHouseSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Buy a House";
        this.longDescription = "Your parents don't want you to live with them anymore. You need to buy a house.";
    }
    /**
     * Assigns the house chosen by the player. and updates the players cash
     * @param p player
     * @param decks Array of Decks used in magenta
     * @param choice index value of the choice of the player
     */

    @Override
    public void doMagentaAction(Player p, ArrayList<Deck> decks, int choice) {

        HouseCard h = (HouseCard) decks.get(2).getCards().get(choice);
        p.setHouse(h);
        p.updateCash(-h.getValue());
        decks.get(2).getCards().remove(choice);


    }

    /**
     * Gets the array of string of choices to be shown to the user
     *
     * @param p current player
     * @param decks used in Magenta Spaces
     * @return String of choices available
     */
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
