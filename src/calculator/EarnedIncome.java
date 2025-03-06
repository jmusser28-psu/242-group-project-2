package calculator;
import util.DoubleValidation;

public class EarnedIncome {
    private double income;
    public EarnedIncome() {
        System.out.print("Enter your current income: ");
        double userIncome = DoubleValidation.validate();
        this.income = userIncome;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome() {
        System.out.println("Enter a new income: ");
        double userIncome = DoubleValidation.validate();
        this.income = userIncome;
    }
}
