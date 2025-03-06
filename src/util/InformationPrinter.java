package util;

import expenses.*;

public class InformationPrinter {
    public static boolean firstRun() {
        System.out.println("---Initial Setup---");
        System.out.print("Would you like to enter yearly or monthly data? ");
        String choice = GetString.get();
        boolean isValid = false;
        boolean isMonthly = false;
        while (!isValid) {
            if (choice.equalsIgnoreCase("Monthly")) {
                isMonthly = true;
                isValid = true;
            } else if (choice.equalsIgnoreCase("Yearly")) {
                isMonthly = false;
                isValid = true;
            } else {
                System.out.print("Invalid choice, please enter a valid option: ");
                choice = GetString.get();
            }
        }
        return isMonthly;
    }

    public static void printMenu() {
        System.out.println("---Banking Program---");
        System.out.println("\t0.) Quit");
        System.out.println("\t1.) List Expenses");
        System.out.println("\t2.) Set Expenses");
        System.out.println("\t3.) Set Income");
        System.out.println("\t4.) Set Filing Status");
        System.out.println("\t5.) Calculate Tax Amount Owed");
        System.out.println("\t6.) Reset Program");
        System.out.print("What would you like to do? ");
    }
    public static void listExpenses(HousingExpenses housingExpenses, UtilitiesExpenses utilitiesExpenses,
                                    FoodExpenses foodExpenses, TravelExpenses travelExpenses,
                                    EntertainmentExpenses entertainmentExpenses, InsuranceExpenses insuranceExpenses)
    {
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
    public static void modifyExpenses(HousingExpenses housingExpenses, UtilitiesExpenses utilitiesExpenses,
                                      FoodExpenses foodExpenses, TravelExpenses travelExpenses,
                                      EntertainmentExpenses entertainmentExpenses, InsuranceExpenses insuranceExpenses)
    {
        byte userChoice = 0;
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
}
