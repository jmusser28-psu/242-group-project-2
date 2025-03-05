package main;

import expenses.TravelExpenses;
import util.ByteValidation;
import util.StringValidation;

public class Main {
    public static void main(String[] args) {
        boolean isFirstTime = true;
        boolean isMonthly = false;

        TravelExpenses travelExpenses = null;

        int userChoice = 0;
        while (!(userChoice == -1)) {
            if (isFirstTime) {
                System.out.print("Would you like to enter yearly or monthly data: ");
                String choice = StringValidation.validate();
                if (choice.equalsIgnoreCase("Monthly")) {
                    isMonthly = true;
                }
                System.out.print("Please enter travel expenses: ");
                System.out.println();
                travelExpenses = new TravelExpenses(isMonthly);
                isFirstTime = false;
            }
            else {
                System.out.println("---Banking Program---");
                System.out.println("1.) list expenses");
                System.out.println("2.) set expenses");
                System.out.print("What would you like to do? ");
                userChoice = ByteValidation.validate();
                if (userChoice == 1) {
                    System.out.printf("Housing Expenses:\t%.2f\n", travelExpenses.getExpenses());
                    System.out.printf("Utilities Expenses:\t%.2f\n", travelExpenses.getExpenses());
                    System.out.printf("Food Expenses:\t%.2f\n", travelExpenses.getExpenses());
                    System.out.printf("Travel Expenses:\t%.2f\n", travelExpenses.getExpenses());
                    System.out.printf("Entertainment Expenses:\t%.2f\n", travelExpenses.getExpenses());
                }
                if (userChoice == 2) {
                    travelExpenses.setExpenses();
                }

            }
        }


    }
}
