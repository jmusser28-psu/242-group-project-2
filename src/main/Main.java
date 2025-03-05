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
        InsuranceExpenses insuranceExpenses = null;

        int userChoice = 0;
        boolean run = true;
        while (run) {
            if (isFirstTime) {
                System.out.println("---Initial Setup---");
                System.out.print("Would you like to enter yearly or monthly data? ");
                String choice = GetString.get();
                boolean isValid = false;
                while (!isValid) {
                    if (choice.equalsIgnoreCase("Monthly")) {
                        isMonthly = true;
                        isValid = true;
                    }
                    else if (choice.equalsIgnoreCase("Yearly")) {
                        isMonthly = false;
                        isValid = true;
                    }
                    else {
                        System.out.print("Invalid choice, please enter a valid option: ");
                        choice = GetString.get();
                    }
                }

                housingExpenses = new HousingExpenses(isMonthly);
                utilitiesExpenses = new UtilitiesExpenses(isMonthly);
                foodExpenses = new FoodExpenses(isMonthly);
                travelExpenses = new TravelExpenses(isMonthly);
                entertainmentExpenses = new EntertainmentExpenses(isMonthly);
                insuranceExpenses = new InsuranceExpenses(isMonthly);
                isFirstTime = false;
            }

            else {
                System.out.println("---Banking Program---");
                System.out.println("\t0.) Quit");
                System.out.println("\t1.) List Expenses");
                System.out.println("\t2.) Set Expenses");
                System.out.println("\t3.) Set Income");
                System.out.println("\t4.) Set Filing Status");
                System.out.println("\t5.) Calculate Tax Amount Owed");
                System.out.println("\t6.) Reset Program");
                System.out.print("What would you like to do? ");
                userChoice = ByteValidation.validate();
                if (userChoice == 0) {
                    run = false;
                }

                else if (userChoice == 1) {
                    double totalExpenses = (housingExpenses.getExpenses() + utilitiesExpenses.getExpenses() +
                            foodExpenses.getExpenses() + travelExpenses.getExpenses() +
                            entertainmentExpenses.getExpenses() + insuranceExpenses.getExpenses());
                    System.out.printf("Housing Expenses: $%.2f\n", housingExpenses.getExpenses());
                    System.out.printf("Utilities Expenses: $%.2f\n", utilitiesExpenses.getExpenses());
                    System.out.printf("Food Expenses: $%.2f\n", foodExpenses.getExpenses());
                    System.out.printf("Travel Expenses: $%.2f\n", travelExpenses.getExpenses());
                    System.out.printf("Entertainment Expenses: $%.2f\n", entertainmentExpenses.getExpenses());
                    System.out.printf("Insurance Premiums: $%.2f\n", insuranceExpenses.getExpenses());
                    System.out.printf("Total Expenses: $%.2f\n", totalExpenses);
                }

                else if (userChoice == 2) {
                    System.out.println("Expenses");
                    System.out.println("\t1.) Housing Expenses");
                    System.out.println("\t2.) Utilities Expenses");
                    System.out.println("\t3.) Food Expenses");
                    System.out.println("\t4.) Travel Expenses");
                    System.out.println("\t5.) Entertainment Expenses");
                    System.out.println("\t6.) Insurance Premiums");
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
                    else if (userChoice == 6) {
                        insuranceExpenses.setExpenses();
                    }
                    else {
                        System.out.printf("Invalid choice %d\n", userChoice);
                    }
                }

                else if (userChoice == 3) {

                }

                else if (userChoice == 4) {

                }

                else if (userChoice == 5) {

                }

                else if (userChoice == 6) {
                    housingExpenses = null;
                    utilitiesExpenses = null;
                    foodExpenses = null;
                    travelExpenses = null;
                    entertainmentExpenses = null;
                    insuranceExpenses = null;
                    isFirstTime = true;
                }

                else {
                    System.out.printf("Invalid option, %d\n", userChoice);
                    System.out.println();
                }

            }
        }

    }
}
