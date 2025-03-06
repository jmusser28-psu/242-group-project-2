package calculator;

public class CalculateDisposableIncome {
    private double income;
    private double taxAmount;

    public CalculateDisposableIncome(double income, double taxAmount) {
        this.income = income;
        this.taxAmount = taxAmount;
    }
    public void setIncome(double income) {
        this.income = income;
    }
    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }
    public double getDisposableIncome() {
        return (income - taxAmount);
    }
}
