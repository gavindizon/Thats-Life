package Model;

import Model.Cards.*;

/**
 * Implements a Player that has a <b>name</b>, their current <b>cash</b>, the latest
 * <b>ActionCard</b> or <b>BlueCard</b> drawn from the deck, a boolean value which determines if user
 * is retired, <b>CareerCard</b> which consist of the details of user's career, <b>SalaryCard</b> which consists
 * of the details of the user's salary, <b>spaceTracker</b> which is the current position of the player, a boolean value
 * of <b>married</b> and <b>college degree</b>, the <b>number of kids</b>, the <b>number of times loaned</b>
 * in the bank, the <b>number of raises</b> they got, and a <b>HouseCard</b>.
 *
 */

public class Player{
    private String name;
    private double cash;
    private Card drawnCard;
    private boolean isRetired;
    private CareerCard career;
    private SalaryCard salaryCard;
    private int spaceTracker;
    private boolean isMarried;
    private boolean hasDegree;
    private int numKids;
    private int loan;
    private int payRaiseCnt;
    private HouseCard house;


    /**
     * Initializes the player object. The starting cash value is 20000. The default
     * career given is a Server.
     *
     * @param name player name
     */
    public Player(String name) {
        this.name = name;
        this.career = new CareerCard("Server", 5, false); // set as default career
        this.cash = 20000;
        this.spaceTracker = 0;
        this.loan = 0;
        this.hasDegree = false;
    }

    public void setPayRaiseCnt(int payRaiseCnt) {
        this.payRaiseCnt = payRaiseCnt;
    }

    public int getPayRaiseCnt() {
        return payRaiseCnt;
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

    /**
     * Returns the career card of the player.
     *
     * @return the career card of the player.
     */
    public CareerCard getCareerCard() {
        return this.career;
    }

    public void setCareer(CareerCard career) {
        this.career = career;
        this.setPayRaiseCnt(0);
    }

    /**
     * Returns the salary card of the player.
     *
     * @return the salary card of the player.
     */

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
     * Returns the player's space index
     *
     * @return the player's space index
     */
    public int getSpaceTracker() {
        return spaceTracker;
    }

    /**
     * Returns the player's the cash value of the times the player loaned.
     *
     * @return the player's the cash value of the times the player loaned.
     */

    public double getLoan() {
        return loan * 25000;
    }

    /**
     * Returns the player's drawn Action Card whenever player lands at orange.
     *
     * @return the player's drawn Action Card whenever player lands at orange.
     */
    public Card getDrawnCard() {
        return drawnCard;
    }

    /**
     * Updates the cash of the player given a value. If the cash to be combined will equal to the negative value.
     * It calls the loanFromBank function and recursively calls itself.
     *
     * @param cash the amount of cash added or subtracted to the total cash.
     */
    public void updateCash(double cash) {
        if (this.cash + cash >= 0)
            this.cash += cash;
        else {
            if(!this.isRetired){
                loanFromBank();
                this.cash += 20000;
                updateCash(cash);
            }
        }
    }


    /**
     * Sets the boolean value of the player's degree
     *
     * @param hasDegree boolean value whether the player has or does not have a degree
     */

    public void setHasDegree(boolean hasDegree) {
        this.hasDegree = hasDegree;
    }

    /**
     * returns a boolean value of the player's degree
     *
     * @return player's boolean value of hasDegree
     */

    public boolean isHasDegree() {
        return hasDegree;
    }

    /**
     * helper function called by the updateCash() function that lets players loan
     * 20000 from the bank if they lack money.
     *
     */
    private void loanFromBank() {
        System.out.println("Insufficient Funds Loaning $20000 from the Bank");

        this.loan++;
    }


    /**
     * Initializes whether the player picks the career or college path.
     * If he chooses career, he draws from the career and salary deck.
     * On the other hand, if he chooses the college he loans 40k
     * but this will not be reflected to his money since
     * this is already allotted for his degree.
     *
     * @param salary Deck of Salary Cards
     * @param career Deck of Career Cards
     * @param decision int value of the players choice
     */
    public void chooseStartingPath(Deck salary, Deck career, int decision) {

        boolean gotCareer= false;
        if (decision == 1) {
            this.setLoan(2);
            this.career.setCareerName("Student");
            this.salaryCard = null;
            this.teleportToSpace(12);

        } else {
            this.salaryCard = (SalaryCard) salary.drawCard(salary.getCards().size() - 1);
            for(int i = career.getCards().size() - 1; i >= 0 && !gotCareer; i--){
                CareerCard c = (CareerCard) career.getCards().get(i);
                if(!c.isDegreeRequired()){
                    this.career = (CareerCard) career.drawCard(i);
                    gotCareer = true;
                }

            }

        }
    }
    /**
     * Sets the times that player loaned. Used in chooseStartingPath to automatically
     * automatically set player loan to 2 times which is equivalent to player borrowing
     * money 40k which translates to 50k loan for their degree
     *
     * @param loan the times the player loaned
     */
    public void setLoan(int loan) {
        this.loan = loan;
    }

    /**
     * pays the highest possible value of the multiple of 25000
     * that the player can pay.
     *
     */
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

    /**
     * increments the current space of the player by one
     */
    public void updateSpaceTracker() {
        this.spaceTracker++;
    }

    /**
     * sets the current space of the player given a number
     *
     * @param space index of the space
     */
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
     * Sets the retirement status of the player to true or false
     * and placement to identify what their benefits will be in the
     * after being set to retire.
     * 
     * @param isRetired true if the player is retired, false if not.
     * @param place the placement of the player.
     *
     */
    public void setToRetire(boolean isRetired, int place) {
        this.isRetired = isRetired;
        endGameResult(place);
    }

    /**
     * computes the retirement benefits of the player which requires the placement
     * of the player.
     *
     * @param place
     */
    private void endGameResult(int place){

            switch(place){
                case 1:
                    updateCash(100000);
                    System.out.println("Gets First Place");
                    break;
                case 2:
                    updateCash(50000);
                    System.out.println("Gets Second Place");

                    break;
                case 3:
                    updateCash(20000);
                    System.out.println("Gets Third Place");
                    break;
                default:
                    break;
            }
            System.out.println(this.name + " money after placement is " + this.cash);

            updateCash(10000 * getNumKids());

            if(this.house != null){
                updateCash(this.house.getValue());
            }
            if(this.loan > 0){
                System.out.println("Payinh loan " + this.name );
                setCash(this.cash - getLoan());
                System.out.println(this.cash);
                this.setLoan(0);
            }
        }

    /**
     * Sets the value of the cash of the player
     *
     * @param cash cash value
     */
    public void setCash(double cash) {
        this.cash = cash;
    }

    /**
     * Lets player draw from a deck (used in Action and Blue).
     * The drawn card will be set as the current card drawn by the player.
     *
     * @param deck deck of cards
     */
    public void drawCard(Deck deck) {
        Card c = deck.drawCard();
        this.drawnCard = c;
    }

    /**
     * Returns the current house of the player
     *
     * @return the house card
     */
    public HouseCard getHouse() {
        return house;
    }

    /**
     * Sets the house of the current player
     *
     * @param house house card
     */
    public void setHouse(HouseCard house) {
        this.house = house;
        System.out.println(getHouse().getDescription());
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

    /**
     * Returns a String value of the player's name and cash. Used for debugging.
     *
     * @return a String that consists of the player's name and their current cash.
     *
     */
    @Override
    public String toString() {
        return this.name + "$: " + this.cash;
    }

}