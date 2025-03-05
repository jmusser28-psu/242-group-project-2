package main;

import expenses.*;
import util.ByteValidation;
import util.GetString;

public class Main {
    public static void main(String[] args) {
        boolean isFirstTime = true;
        boolean isMonthly = false;

        HousingExpenses housingExpenses = null;
        UtilitiesExpenses utilitiesExpenses = null;
        FoodExpenses foodExpenses = null;
        TravelExpenses travelExpenses = null;
        EntertainmentExpenses entertainmentExpenses = null;

        int userChoice = 0;
        boolean run = true;
        while (!run) {
            if (isFirstTime) {
                System.out.print("Would you like to enter yearly or monthly data? ");
                String choice = GetString.get();
                if (choice.equalsIgnoreCase("Monthly")) {
                    isMonthly = true;
                }
                housingExpenses = new HousingExpenses(isMonthly);
                utilitiesExpenses = new UtilitiesExpenses(isMonthly);
                foodExpenses = new FoodExpenses(isMonthly);
                travelExpenses = new TravelExpenses(isMonthly);
                entertainmentExpenses = new EntertainmentExpenses(isMonthly);
                isFirstTime = false;
            }
            else {
                System.out.println("---Banking Program---");
                System.out.println("1.) List Expenses");
                System.out.println("2.) Set Expenses");
                System.out.println("3.) ");
                System.out.print("What would you like to do? ");
                userChoice = ByteValidation.validate();
                if (userChoice == 1) {
                    double totalExpenses = (housingExpenses.getExpenses() + utilitiesExpenses.getExpenses() +
                            foodExpenses.getExpenses() + travelExpenses.getExpenses() + entertainmentExpenses.getExpenses());
                    System.out.printf("Housing Expenses: $%.2f\n", housingExpenses.getExpenses());
                    System.out.printf("Utilities Expenses: $%.2f\n", utilitiesExpenses.getExpenses());
                    System.out.printf("Food Expenses: $%.2f\n", foodExpenses.getExpenses());
                    System.out.printf("Travel Expenses: $%.2f\n", travelExpenses.getExpenses());
                    System.out.printf("Entertainment Expenses: $%.2f\n", entertainmentExpenses.getExpenses());
                    System.out.printf("Total Expenses: $%.2f\n", totalExpenses);
                    System.out.println();
                }
                else if (userChoice == 2) {
                    System.out.println("What expense would you like to modify?");
                    System.out.println("1.) Housing Expenses");
                    System.out.println("2.) Utilities Expenses");
                    System.out.println("3.) Food Expenses");
                    System.out.println("4.) Travel Expenses");
                    System.out.println("5.) Entertainment Expenses");
                    System.out.print("What would you like to do? ");
                    userChoice = ByteValidation.validate();
                    if (userChoice == 1) {
                        housingExpenses.setExpenses();
                    }
                    else if (userChoice == 2) {
                        utilitiesExpenses.setExpenses();
                    }
                    else if (userChoice == 3) {
                        foodExpenses.setExpenses();
                    }
                    else if (userChoice == 4) {
                        travelExpenses.setExpenses();
                    }
                    else if (userChoice == 5) {
                        entertainmentExpenses.setExpenses();
                    }
                    else {
                        System.out.printf("Invalid choice %d\n", userChoice);
                    }
                }
                else if (userChoice == 3) {


                }

            }
        }


    }
}
