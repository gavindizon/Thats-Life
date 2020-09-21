package phase1.Cards;

public class SalaryCard extends Card {
    private double salary;
    private double tax;
    private double raiseValue;

    public SalaryCard(double salary, double tax, double raiseValue) {
        super("Salary Card");
        this.salary = salary;
        this.tax = tax;
        this.raiseValue = raiseValue;
    }

    public double getSalary() {
        return this.salary;
    }

    public double getTax() {
        return this.tax;
    }

    public void raiseSalary() {
        this.salary += this.raiseValue;
        raiseTax();
    }

    private void raiseTax() {
        this.tax += 2000;
    }

    @Override
    public String toString(){
        return  "Salary: " + this.salary + "Raise Value: " + this.raiseValue + "Tax: " + this.tax;
    }


}
