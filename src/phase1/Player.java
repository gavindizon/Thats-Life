package phase1;

import java.util.Scanner;
import phase1.Cards.*;

/**
 * Implements a Player that has a name, their current cash, the latest
 * <b>ActionCard</b> drawn from the deck, a boolean value which determines if he
 * is retired, and a <b>CareerCard</b> which consist of the details of his
 * career
 */

public class Player {
    private String name;
    private double cash;
    private ActionCard drawnCard;
    private boolean isRetired;
    private CareerCard career;
    private SalaryCard salaryCard;
    private int spaceTracker;
    private boolean isMarried;
    private boolean hasDegree;
    private int numKids;
    private int loan;
    private HouseCard house;


    /**
     * Initializes the player object with the given career. The starting cash value
     * is 20000.
     * 
     * @param career career card picked by the player
     */
    /*
     * public Player() { // do { // if (this.name != null) //
     * System.out.print("Enter valid name: "); // this.name = scanner.nextLine(); //
     * } while (!nameValid(this.name));
     * 
     * this.career = career; this.cash = 20000; this.spaceTracker = 0; this.numKids
     * = 0; }
     */

    /**
     * Initializes the player object. The starting cash value is 20000. The default
     * career given is a racecar driver.
     * 
     */
    public Player(String name) {
        // do {
        // if (this.name != null)
        // System.out.print("Enter valid name: ");
        // name = scanner.nextLine();
        // } while (!nameValid(this.name));
        this.name = name;
        this.career = new CareerCard("Server", 5, false); // set as default career
        this.cash = 20000;
        this.spaceTracker = 0;
        this.loan = 0;
        this.hasDegree = false;
    }

    public void addKids(int num) {
        this.numKids += num;
    }

    public int getNumKids() {
        return numKids;
    }

    public void setMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the string representation of the career.
     * 
     * @return the string representation of the career.
     */
    public String getCareer() {
        return this.career.getCareerName();
    }

    public CareerCard getCareerCard() {
        return this.career;
    }

    public void setCareer(CareerCard career) {
        this.career = career;
    }

    public SalaryCard getSalaryCard() {
        return this.salaryCard;
    }

    public void setSalaryCard(SalaryCard salaryCard){
        this.salaryCard = salaryCard;
    }

    /**
     * Returns the player's name
     * 
     * @return the player's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the player's current cash
     * 
     * @return the player's current cash
     */
    public double getCash() {
        return this.cash;
    }

    /**
     * Updates the cash of the player given a value.
     * 
     * @param cash the amount of cash added or subtracted to the total cash.
     */
    public int getSpaceTracker() {
        return spaceTracker;
    }

    public double getLoan() {
        return loan * 25000;
    }

    public Card getDrawnCard() {
        return drawnCard;
    }

    public void updateCash(double cash) {
        if (this.cash + cash >= 0)
            this.cash += cash;
        else {
            loanFromBank();
            this.cash += 20000;
            updateCash(cash);
        }
    }
    public boolean isHasDegree() {
        return hasDegree;
    }

    public void setHasDegree(boolean hasDegree) {
        this.hasDegree = hasDegree;
    }


    private void loanFromBank() {
        System.out.println("Insufficient Funds Loaning $20000 from the Bank");

        this.loan++;
    }

    public void chooseStartingPath(Deck salary, Deck career, int decision) {

        if (decision == 1) {
            this.cash += 40000;
            this.career.setCareerName("Student");
            this.teleportToSpace(12);
        } else {
            this.salaryCard = (SalaryCard) salary.drawCard();
            this.career = (CareerCard) career.drawCard();

            while (this.career.isDegreeRequired()) {
                career.addCardBack(this.career);
                career.shuffleDeck();
                this.career = (CareerCard) career.drawCard();
            }
        }
    }

    public void payLoan() {
        int cnt = 0;
        while (this.cash >= 25000 && this.loan > 0) {
            this.cash -= 25000;
            this.loan--;
            cnt++;
        }
        if (this.loan > 0) {
            System.out.println(this.name + " was only able to pay $" + (cnt * 25000));
        } else
            System.out.println("Outstanding loan was payed successfully");
    }

    public void updateCareer(CareerCard career) {
        this.career = career;

    }

    public void updateSalary(SalaryCard salary) {
        this.salaryCard = salary;
    }

    public void updateSpaceTracker() {
        this.spaceTracker++;
    }

    public void teleportToSpace(int space) {
        this.spaceTracker = space;
    }

    /**
     * Returns true if the player is retired, false if not.
     * 
     * @return true if the player is retired, false if not.
     */
    public boolean getIsRetired() {
        return this.isRetired;
    }

    /**
     * Sets the retirement status of the player to true or false.
     * 
     * @param isRetired true if the player is retired, false if not.
     */
    public void setToRetire(boolean isRetired) {
        this.isRetired = isRetired;
    }

    /**
     * Player draws a card from the action card deck and updates it changes based on
     * the type of card. The player's total cash will be updated based on the type
     * of card.
     * 
     * Type will either be 1 (collect from the bank), 2 (pay the bank), 3 (Collect
     * from the player), or 4 (pay player).
     * 
     * @param deck         chosen deck of cards
     * @param otherPlayers array of other players
     */
    /*
     * public void drawCard(Deck deck, Player[] otherPlayers, Space space) {
     * 
     * // // Card d; // if (space instanceof OrangeSpace) { // // Action Card Action
     * // // d = DrawFromActionDeck(); // // this.drawnCard = (ActionCard) d; // //
     * actionCardEffect(otherPlayers);
     * 
     * // } else if (space instanceof MagentaSpace) { // // Magenta Space Action //
     * // magentaAction();
     * 
     * // } else if (space instanceof BlueSpace) { // // Blue Action
     * 
     * // // blueAction(); similar to Orange // // this.salary = d; // //
     * this.career = a;
     * 
     * // } else { // // Green - Pay Day or Pay Raise Action // // greenAction(); //
     * }
     * 
     * /* Card c = deck.drawCard(); if (c instanceof ActionCard) { this.drawnCard =
     * (ActionCard) c; actionCardEffect(otherPlayers); } else if (c instanceof
     * BlueCard) {
     * 
     * } else if (c instanceof SalaryCard) {
     * 
     * } }
     */
    // Career Deck & Salary Deck
    public void drawCard(Deck deck) {
        Card c = deck.drawCard();
        this.drawnCard = (ActionCard) c;
        // this.drawnCard.activate();
        // if (c instanceof SalaryCard)
        // this.salary = (SalaryCard) c;
        // else
        // this.career = (CareerCard) c;
    }

    public HouseCard getHouse() {
        return house;
    }

    public void setHouse(HouseCard house) {
        this.house = house;
        System.out.println(getHouse().getDescription());
    }



    private void blueCardEffect(BlueCard c, Player[] otherPlayers) {
        double cash;
        if (c.careerMatches(this.career.getCareerName())) { // if same career in the card
            cash = 15000.00;
            updateCash(cash);
        }
        /*
         * Pwede ata to inheritance per career switch(c.getDescription()){ Player p =
         * c.othersMatched(otherPlayers); case "Lawsuit": if(p != null){
         * p.updateCash(500); // to be changed sa value daw ng card updateCash(-500); }
         * else{ updateCash(-500); // pays the bank pero change pa rin to value ng card
         * } break; case "Salary Tax Due": if(p != null){ p.updateCash(500); // to be
         * changed sa value tax due of current player updateCash(-500); } else{
         * updateCash(-500); // pays the bank pero to be changed sa value tax due of
         * current player } break; case "Tip the Server": // cash = Math.random() if(p
         * != null){ p.updateCash(500); // to be changed sa random number x 1000
         * updateCash(-500); } else{ updateCash(-500); // pays the bank pero to be
         * changed sa random number x 1000 } }
         */
    }

    /**
     * Checks if the user input is valid. The user input will only be valid if it
     * contains at least one alphanumeric character and if the String doesn't
     * contain all whitespaces.
     * 
     * @param name name entered by the player.
     * @return true if name is valid; false otherwise
     */

    private boolean nameValid(String name) {
        boolean checkWhiteSpaceOnly = name.trim().isEmpty();
        boolean checkAlphaNumeric = name != null && name.matches("^[a-zA-Z0-9]*$");
        return !checkWhiteSpaceOnly && checkAlphaNumeric;
    }

    /**
     * Compares two player objects and returns true if their name and amount of cash
     * are equal, false if not.
     * 
     * @return true if their name and amount of cash are equal, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        Player anotherPlayer = (Player) obj;
        return anotherPlayer.getName().equals(this.name) && anotherPlayer.getCash() == this.cash;
    }

    @Override
    public String toString() {
        return this.name + "$: " + this.cash;
    }

}