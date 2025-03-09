package main;

import calculator.CalculateDisposableIncome;
import calculator.EarnedIncome;
import calculator.FilingStatus;
import calculator.TaxBracket;
import expenses.*;
import util.ByteValidation;
import util.GetString;
import util.InformationPrinter;

public class Main {

    public static double finalHoldings(HousingExpenses housingExpenses, UtilitiesExpenses utilitiesExpenses,
                                       FoodExpenses foodExpenses, TravelExpenses travelExpenses,
                                       EntertainmentExpenses entertainmentExpenses, InsuranceExpenses insuranceExpenses,
                                       Retirement retirement, Savings savings, CalculateDisposableIncome calculateDisposableIncome)
    {
        // Method for calculating the final holdings
        // Here as it does not make too much sense to put it in any of the other classes, and is called a few times
        double totalExpenses = (housingExpenses.getExpenses() + utilitiesExpenses.getExpenses() +
                foodExpenses.getExpenses() + travelExpenses.getExpenses() +
                entertainmentExpenses.getExpenses() + insuranceExpenses.getExpenses());
        double totalSavings = retirement.getExpenses() + savings.getExpenses();
        double total = totalExpenses + totalSavings;
        double finalHoldings = (calculateDisposableIncome.getDisposableIncome() - total);
        return finalHoldings;
    }

    public static void main(String[] args) {
        // Declares variables needed for program execution
        // User choice scope should be outside of loops so that it can be stored and used by different loop iterations
        boolean isFirstTime = true;
        boolean isMonthly = false;
        byte userChoice = 0;
        double finalHoldings = 0;

        // Sets all objects initially to null
        HousingExpenses housingExpenses = null;
        UtilitiesExpenses utilitiesExpenses = null;
        FoodExpenses foodExpenses = null;
        TravelExpenses travelExpenses = null;
        EntertainmentExpenses entertainmentExpenses = null;
        InsuranceExpenses insuranceExpenses = null;
        Savings savings = null;
        Retirement retirement = null;
        EarnedIncome earnedIncome = null;
        TaxBracket taxBracket = null;
        FilingStatus filingStatus = null;
        CalculateDisposableIncome calculateDisposableIncome = null;

        // Loop to keep the program running until the user quits
        boolean run = true;
        while (run) {
            if (isFirstTime) {
                // Determines whether expenses and savings will be entered as monthly or yearly values
                // Gathers expenses based on the user's choice and user input
                // Makes calculations to display to the user later
                isMonthly = InformationPrinter.firstRun();

                earnedIncome = new EarnedIncome();
                filingStatus = new FilingStatus();

                housingExpenses = new HousingExpenses(isMonthly);
                utilitiesExpenses = new UtilitiesExpenses(isMonthly);
                foodExpenses = new FoodExpenses(isMonthly);
                travelExpenses = new TravelExpenses(isMonthly);
                entertainmentExpenses = new EntertainmentExpenses(isMonthly);
                insuranceExpenses = new InsuranceExpenses(isMonthly);
                retirement = new Retirement(isMonthly);
                taxBracket = new TaxBracket(filingStatus.getStatus(), earnedIncome.getIncome());
                taxBracket.calculateTaxBracket();
                calculateDisposableIncome = new CalculateDisposableIncome(earnedIncome.getIncome(),
                        taxBracket.calculateTaxAmount());

                boolean valid = false;
                boolean saved = false;
                System.out.print("Would you like to enter savings? ");
                while (!valid) {
                    String answer = GetString.get();
                    if (answer.equalsIgnoreCase("Yes")) {
                        valid = true;
                        saved = true;
                    }
                    else if (answer.equalsIgnoreCase("No")) {
                        valid = true;
                    }
                    else {
                        System.out.print("Please enter a valid answer: ");
                    }
                }

                savings = new Savings(isMonthly, saved);

                finalHoldings = finalHoldings(housingExpenses, utilitiesExpenses, foodExpenses, travelExpenses,
                        entertainmentExpenses, insuranceExpenses, retirement, savings, calculateDisposableIncome);

                isFirstTime = false;
            }

            else {
                // Runs the regular print menu which gives the user choices on what they would like to do
                // Collects the user choice and calls the class associated with the choice
                System.out.println();
                InformationPrinter.printMenu();
                userChoice = ByteValidation.validate();

                // Quits the program and prints recommendation
                if (userChoice == 0) {
                    System.out.println();
                    run = false;

                    finalHoldings = finalHoldings(housingExpenses, utilitiesExpenses, foodExpenses, travelExpenses,
                            entertainmentExpenses, insuranceExpenses, retirement, savings, calculateDisposableIncome);

                    System.out.printf("Your final holdings are: $%.2f\n", finalHoldings);
                     if (finalHoldings >= 0) {
                     System.out.println("You are financially well");
                     }
                     else {
                     System.out.println("You are not financially well");
                     System.out.println("Consider getting another job");
                     }
                    System.out.println("Good bye");

                }

                // Prints expense and saving information
                else if (userChoice == 1) {
                    System.out.println();
                    InformationPrinter.listExpenses(housingExpenses, utilitiesExpenses, foodExpenses,
                            travelExpenses, entertainmentExpenses, insuranceExpenses, retirement, savings);
                }

                // Updates expenses and savings
                else if (userChoice == 2) {
                    System.out.println();
                    InformationPrinter.modifyExpenses(housingExpenses, utilitiesExpenses, foodExpenses,
                            travelExpenses, entertainmentExpenses, insuranceExpenses, retirement, savings);
                }

                // Sets income and updates classes that are affected by the change in income
                else if (userChoice == 3) {
                    System.out.println();
                    earnedIncome.setIncome();
                    taxBracket.setIncome(earnedIncome.getIncome());
                    taxBracket.calculateTaxBracket();
                    calculateDisposableIncome.setIncome(earnedIncome.getIncome());
                    calculateDisposableIncome.setTaxAmount(taxBracket.calculateTaxAmount());
                    calculateDisposableIncome.getDisposableIncome();
                }

                // Sets filing status and updates classes that are affected by the change in status
                else if (userChoice == 4) {
                    System.out.println();
                    filingStatus.setStatus();
                    taxBracket.setStatus(filingStatus.getStatus());
                    taxBracket.calculateTaxBracket();
                }

                // Calculates and prints tax bracket and tax amount owed
                else if (userChoice == 5) {
                    System.out.println();
                    System.out.printf("You have a %.2f%% tax rate\n", taxBracket.calculateTaxBracket());
                    System.out.printf("You owe $%.2f in taxes\n", taxBracket.calculateTaxAmount());
                }

                // Calculates and prints disposable income
                else if (userChoice == 6) {
                    System.out.println();
                    System.out.printf("You earned $%.2f in disposable income\n", calculateDisposableIncome.getDisposableIncome());
                }

                // Calculate final withholding
                else if (userChoice == 7) {
                    System.out.println();
                    finalHoldings = finalHoldings(housingExpenses, utilitiesExpenses, foodExpenses, travelExpenses,
                            entertainmentExpenses, insuranceExpenses, retirement, savings, calculateDisposableIncome);
                    System.out.printf("You have $%.2f left after spending\n", finalHoldings);
                }

                // Sets all objects to null, updates isFirstTime to true and effectively resets the program
                else if (userChoice == 8) {
                    System.out.println();
                    housingExpenses = null;
                    utilitiesExpenses = null;
                    foodExpenses = null;
                    travelExpenses = null;
                    entertainmentExpenses = null;
                    insuranceExpenses = null;
                    retirement = null;
                    taxBracket = null;
                    filingStatus = null;
                    calculateDisposableIncome = null;
                    savings = null;
                    isFirstTime = true;
                }

                // Informs the user they made an invalid choice
                else {
                    System.out.printf("Invalid option, %d\n", userChoice);
                    System.out.println();
                }

            }
        }

    }
}
