package calculator;

public class CalculateDisposableIncome {
    private double income;
    private double taxAmount;

    public CalculateDisposableIncome(double income, double taxAmount) {
        this.income = income;
        this.taxAmount = taxAmount;
    }
    public double getDisposableIncome() {
        return (income - taxAmount);
    }
}
