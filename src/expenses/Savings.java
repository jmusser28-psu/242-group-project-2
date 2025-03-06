package expenses;

import util.ByteValidation;
import util.GetCharacter;
import util.DoubleValidation;

public class Savings {
    private double yearlyExpense;
    private double[] monthlyExpense = new double[12];
    private boolean isMonthly;

    private boolean saved;

    public Savings(boolean isMonthly, boolean saved) {
        // Determines if the user is entering monthly or yearly input
        this.isMonthly = isMonthly;
        this.saved = saved;

        // Will go through the process of taking user input if the user chose to save money
        // If not, assigns the variables to 0 so that the program does not crash due to a null object
        if (saved) {
            // Takes in monthly user input if the user decided to enter in monthly expenses individually
            if (isMonthly) {
                System.out.print("Please enter savings for January: ");
                monthlyExpense[0] = DoubleValidation.validate();
                System.out.print("Please enter savings for February: ");
                monthlyExpense[1] =  DoubleValidation.validate();
                System.out.print("Please enter savings for March: ");
                monthlyExpense[2] =  DoubleValidation.validate();
                System.out.print("Please enter savings for April: ");
                monthlyExpense[3] =  DoubleValidation.validate();
                System.out.print("Please enter savings for May: ");
                monthlyExpense[4] =  DoubleValidation.validate();
                System.out.print("Please enter savings for June: ");
                monthlyExpense[5] =  DoubleValidation.validate();
                System.out.print("Please enter savings for July: ");
                monthlyExpense[6] =  DoubleValidation.validate();
                System.out.print("Please enter savings for August: ");
                monthlyExpense[7] =  DoubleValidation.validate();
                System.out.print("Please enter savings for September: ");
                monthlyExpense[8] =  DoubleValidation.validate();
                System.out.print("Please enter savings for October: ");
                monthlyExpense[9] =  DoubleValidation.validate();
                System.out.print("Please enter savings for November: ");
                monthlyExpense[10] =  DoubleValidation.validate();
                System.out.print("Please enter savings for December: ");
                monthlyExpense[11] =  DoubleValidation.validate();
                System.out.println();

                // Sets a temporary variable to determine the monthly expenses
                // Loops through an enhanced for loop to find total monthly expenses during a year
                // Assigns yearlyExpense with monthlyCost combined
                double costCombined = 0;
                for (double elements : monthlyExpense) {
                    costCombined += elements;
                }
                yearlyExpense = costCombined;
            }

            // Takes in user input if the user decided to enter in yearly expenses
            else {
                System.out.print("Please enter a yearly savings amount: ");
                this.yearlyExpense = DoubleValidation.validate();
            }
        }
        else {
            monthlyExpense[0] = 0;
            monthlyExpense[1] = 0;
            monthlyExpense[2] = 0;
            monthlyExpense[3] = 0;
            monthlyExpense[4] = 0;
            monthlyExpense[5] = 0;
            monthlyExpense[6] = 0;
            monthlyExpense[7] = 0;
            monthlyExpense[8] = 0;
            monthlyExpense[9] = 0;
            monthlyExpense[10] = 0;
            monthlyExpense[11] = 0;
            yearlyExpense = 0;
        }
    }

    public double getExpenses() {
        // Determines if the user wanted to enter monthly expenses
        // If the user decided to use monthly inputs, then total the monthly expenses with an enhanced for loop
        // then assign yearlyExpense with the calculated combined cost
        // Else if the user decided to use a yearly input, then the yearly expense does not need to be calculated
        // Finally returns the yearly expense
        if (isMonthly) {
            double combinedCost = 0;
            for (double elements : monthlyExpense) {
                combinedCost += elements;
            }
            yearlyExpense = combinedCost;
        }
        return yearlyExpense;
    }
    public void setExpenses() {
        if (isMonthly) {
            // Determines if the user wanted to enter monthly expenses
            // Displays byte values associated with the months the user may want to modify
            System.out.println("1.) January | 2.) February | 3.) March");
            System.out.println("4.) April | 5.) May | 6.) June");
            System.out.println("7.) July | 8.) August | 9.) September");
            System.out.println("10.) October | 11.) November | 12.) December");

            // Sets up a while loop to take in user input and modify a specific month's value
            // Loops until the user specifies they no longer want to modify anymore values
            // Concludes when the user enters "N" or "n" when prompted whether they want to continue
            boolean done = false;
            while (!done) {
                System.out.print("Please specify a month to modify (1-12): ");
                byte userChoice = ByteValidation.validate();
                userChoice -= 1;
                System.out.print("Please specify a new value: ");
                monthlyExpense[userChoice] = DoubleValidation.validate();

                // Sets a temporary variable to determine the monthly expenses
                // Loops through an enhanced for loop to find total monthly expenses during a year
                // Assigns yearlyExpense with monthlyCost combined
                double costCombined = 0;
                for (double elements : monthlyExpense) {
                    costCombined += elements;
                }
                yearlyExpense = costCombined;

                System.out.print("Would you like to continue (Y/N): ");
                char continueChoice = GetCharacter.get();
                if (continueChoice == 'N' || continueChoice == 'n') {
                    done = true;
                }
                System.out.println();
            }
        }

        // Assigns yearlyExpense with user input
        else {
            System.out.print("Please enter a yearly savings amount: ");
            yearlyExpense = DoubleValidation.validate();
        }

    }
}
