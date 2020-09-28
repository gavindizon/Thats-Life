package Model.Cards;

/**
 * implements the SalaryCard which inherits from the Card
 * has a salary, tax, and raise value.
 */
public class SalaryCard extends Card {
    private double salary;
    private double tax;
    private double raiseValue;

    /**
     * Calls the super constructor class (Card) and
     * initializes the Salary Card given the salary, tax, and
     * raise value
     * @param salary double value of salary
     * @param tax double value of tax
     * @param raiseValue double value of raiseValue
     */

    public SalaryCard(double salary, double tax, double raiseValue) {
        super("Salary Card");
        this.salary = salary;
        this.tax = tax;
        this.raiseValue = raiseValue;
    }

    /**
     * Returns the salary value
     *
     * @return salary value
     */
    public double getSalary() {
        return this.salary;
    }
    /**
     * Returns the tax value
     *
     * @return tax value
     */

    public double getTax() {
        return this.tax;
    }

    /**
     * raises the salary value and tax value
     * which is triggered by the GreenSpace
     */
    public void raiseSalary() {
        this.salary += this.raiseValue;
        raiseTax();
    }

    /**
     * raises the tax value called in raiseSalary() method
     */
    private void raiseTax() {
        this.tax += 2000;
    }

    /**
     * Returns a String Value of the Salary, Raise Value, and Tax combined
     *
     * @return String value of the salary, raise value, and tax combined
     */
    @Override
    public String toString(){
        return  "Salary: " + this.salary + "Raise Value: " + this.raiseValue + "Tax: " + this.tax;
    }


}
