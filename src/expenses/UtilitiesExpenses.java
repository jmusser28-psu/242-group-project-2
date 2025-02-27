package expenses;

public class UtilitiesExpenses {
    private double yearlyExpense;
    private double monthlyExpense;


    public UtilitiesExpenses(double monthlyExpense, boolean isMonthly) {
        if (isMonthly) {
            this.yearlyExpense = monthlyExpense * 12;
        }
        else {
            this.yearlyExpense = monthlyExpense;
        }

    }

    public double getYearlyExpenses() {
        return yearlyExpense;
    }
    public void setYearlyExpenses(double expenses) {
        yearlyExpense = expenses;
    }

}
