package calculator;

public class CalculateDisposableIncome {
    private double income;
    private double taxAmount;

    public CalculateDisposableIncome(double income, double taxAmount) {
        // Sets income and tax amount
        this.income = income;
        this.taxAmount = taxAmount;
    }
    public void setIncome(double income) {
        // Sets income
        this.income = income;
    }
    public void setTaxAmount(double taxAmount) {
        // Sets tax amount
        this.taxAmount = taxAmount;
    }
    public double getDisposableIncome() {
        // Calculates disposable income
        return (income - taxAmount);
    }
}
