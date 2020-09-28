package Model.Cards.BlueCard;

import Model.Player;

/**
 * implements ComputerRepair which inherits from the BlueCard and
 * implements the RandomAction Interface
 *
 */
public class ComputerRepair extends BlueCard implements RandomAction {

    /**
     * Calls the super class constructor (BlueCard) and initializes
     * the ComputerRepair given description and career
     * @param description String description
     * @param career String career
     */

    public ComputerRepair(String description, String career) {
        super(description, career);
        this.longDescription = "The player presses for a random number. He pays $5000 if the number is even, and $10000 if the " +
                "number is odd";
    }

    /**
     * the random number generated checks is first checked to be odd or even
     * if odd the amount is set to 5000, on the other hand, 10000 if even
     *
     * if it matches the career of the player the player collects 15k.
     * if it matches the career of the other player the player pays the amount to the other player.
     * if it doesn't match player pays the bank by the amount.
     *
     * @param p
     * @param otherPlayers
     * @param number
     */

    @Override
    public void activate(Player p, Player[] otherPlayers, int number) {
        Player playerMatched = this.othersMatched(otherPlayers);
        System.out.println(number);

        double amount;
        if (number % 2 == 0) {
            amount = 5000;
        } else {
            amount = 10000;
        }

        if (this.careerMatches(p.getCareer())) {
            p.updateCash(15000);
        } else if (playerMatched != null) {
            playerMatched.updateCash(amount);
            p.updateCash(-amount);
        } else {
            p.updateCash(-amount);
        }

    }
}
