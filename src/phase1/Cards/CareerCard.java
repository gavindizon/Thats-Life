package phase1.Cards;

/**
 * implements a Career Card that has the name of the career, the maximum pay
 * raise, and a boolean type which determines whether the career needs a degree
 * or not.
 * 
 */

public class CareerCard extends Card {
    private String careerName;
    private final int MAX_PAY_RAISE;
    private boolean degreeRequired;

    /**
     * Creates a careerName card object and initializes the different contents of
     * the card: name, max pay raise, or if a degree is required.
     * 
     * 
     * @param careerName     name of the careerName.
     * @param payRaise       number of times that a given careerName can have a pay
     *                       raise.
     * @param degreeRequired true if the careerNameName requires to have a degree,
     *                       false if not.
     */
    public CareerCard(String careerName, int payRaise, boolean degreeRequired) {
        super("Career Card");
        this.careerName = careerName;
        this.MAX_PAY_RAISE = payRaise;
        this.degreeRequired = degreeRequired;
    }

    /**
     * Returns the career name.
     * 
     * @return career name
     */
    public String getCareerName() {
        return this.careerName;
    }

    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }

    public boolean isDegreeRequired() {
        return degreeRequired;
    }

    /**
     * Returns the maximum pay raise.
     * 
     * @return maximum pay raise
     */
    public int getMaxPayRaise() {
        return this.MAX_PAY_RAISE;
    }

    /**
     * Returns true if the career requires a degree, false if not.
     * 
     * @return true if the career requires a degree, false if not.
     */

    public boolean getDegreeRequired() {
        return this.degreeRequired;
    }

    public void activate() {
        System.out.println();
    }
}