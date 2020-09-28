package phase1;

import phase1.Cards.*;
import phase1.Cards.ActionCard.ActionCard;
import phase1.Cards.BlueCard.BlueCard;

/**
 * Implements a Player that has a name, their current cash, the latest
 * <b>ActionCard</b> drawn from the deck, a boolean value which determines if he
 * is retired, and a <b>CareerCard</b> which consist of the details of his
 * career
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

    public CareerCard getCareerCard() {
        return this.career;
    }

    public void setCareer(CareerCard career) {
        this.career = career;
        this.setPayRaiseCnt(0);
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


    public int getSpaceTracker() {
        return spaceTracker;
    }

    public double getLoan() {
        return loan * 25000;
    }

    public Card getDrawnCard() {
        return drawnCard;
    }

    /**
     * Updates the cash of the player given a value.
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

    public void setLoan(int loan) {
        this.loan = loan;
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
    public void setToRetire(boolean isRetired, int place) {
        this.isRetired = isRetired;
        endGameResult(place);
    }
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
//            payLoan();
//            System.out.println(this.name + " money after loan " + this.cash);

            if(this.loan > 0){
                System.out.println("Payinh loan " + this.name );
                setCash(this.cash - getLoan());
                System.out.println(this.cash);
                this.setLoan(0);
            }
        }


    public void setCash(double cash) {
        this.cash = cash;
    }


    // Career Deck & Salary Deck
    public void drawCard(Deck deck) {
        Card c = deck.drawCard();
        this.drawnCard = c;
    }

    public HouseCard getHouse() {
        return house;
    }

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

    @Override
    public String toString() {
        return this.name + "$: " + this.cash;
    }


}