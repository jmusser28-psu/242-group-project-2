package expenses;

import util.ByteValidation;
import util.GetCharacter;
import util.DoubleValidation;

import java.util.Scanner;

public class TravelExpenses {
    private double yearlyExpense;
    private double[] monthlyExpense = new double[12];
    private boolean isMonthly;

    private static Scanner scnr = new Scanner(System.in);

    public TravelExpenses(boolean isMonthly) {
        // Determines if the user is entering monthly or yearly input
        this.isMonthly = isMonthly;

        // Takes in monthly user input if the user decided to enter in monthly expenses individually
        if (isMonthly) {
            System.out.print("Please enter spending for January: ");
            monthlyExpense[0] = DoubleValidation.validate();
            System.out.print("Please enter spending for February: ");
            monthlyExpense[1] =  DoubleValidation.validate();
            System.out.print("Please enter spending for March: ");
            monthlyExpense[2] =  DoubleValidation.validate();
            System.out.print("Please enter spending for April: ");
            monthlyExpense[3] =  DoubleValidation.validate();
            System.out.print("Please enter spending for May: ");
            monthlyExpense[4] =  DoubleValidation.validate();
            System.out.print("Please enter spending for June: ");
            monthlyExpense[5] =  DoubleValidation.validate();
            System.out.print("Please enter spending for July: ");
            monthlyExpense[6] =  DoubleValidation.validate();
            System.out.print("Please enter spending for August: ");
            monthlyExpense[7] =  DoubleValidation.validate();
            System.out.print("Please enter spending for September: ");
            monthlyExpense[8] =  DoubleValidation.validate();
            System.out.print("Please enter spending for October: ");
            monthlyExpense[9] =  DoubleValidation.validate();
            System.out.print("Please enter spending for November: ");
            monthlyExpense[10] =  DoubleValidation.validate();
            System.out.print("Please enter spending for December: ");
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
            System.out.print("Please enter a yearly spending: ");
            this.yearlyExpense = DoubleValidation.validate();
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
            }
        }

        // Assigns yearlyExpense with user input
        else {
            yearlyExpense = DoubleValidation.validate();
        }

    }
}
