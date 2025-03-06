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
        double totalExpenses = (housingExpenses.getExpenses() + utilitiesExpenses.getExpenses() +
                foodExpenses.getExpenses() + travelExpenses.getExpenses() +
                entertainmentExpenses.getExpenses() + insuranceExpenses.getExpenses());
        double totalSavings = retirement.getExpenses() + savings.getExpenses();
        double total = totalExpenses + totalSavings;
        double finalHoldings = (calculateDisposableIncome.getDisposableIncome() - total);
        return finalHoldings;
    }

    public static void main(String[] args) {
        boolean isFirstTime = true;
        boolean isMonthly = false;
        byte userChoice = 0;
        double finalHoldings = 0;

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

        boolean run = true;
        while (run) {
            if (isFirstTime) {
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
                System.out.println();
                InformationPrinter.printMenu();
                userChoice = ByteValidation.validate();

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

                else if (userChoice == 1) {
                    System.out.println();
                    InformationPrinter.listExpenses(housingExpenses, utilitiesExpenses, foodExpenses,
                            travelExpenses, entertainmentExpenses, insuranceExpenses, retirement, savings);
                }

                else if (userChoice == 2) {
                    System.out.println();
                    InformationPrinter.modifyExpenses(housingExpenses, utilitiesExpenses, foodExpenses,
                            travelExpenses, entertainmentExpenses, insuranceExpenses, retirement, savings);
                }

                else if (userChoice == 3) {
                    System.out.println();
                    earnedIncome.setIncome();
                    taxBracket.setIncome(earnedIncome.getIncome());
                    taxBracket.calculateTaxBracket();
                    calculateDisposableIncome.setIncome(earnedIncome.getIncome());
                    calculateDisposableIncome.setTaxAmount(taxBracket.calculateTaxAmount());
                    calculateDisposableIncome.getDisposableIncome();
                }

                else if (userChoice == 4) {
                    System.out.println();
                    filingStatus.setStatus();
                    taxBracket.setStatus(filingStatus.getStatus());
                    taxBracket.calculateTaxBracket();
                }

                else if (userChoice == 5) {
                    System.out.println();
                    System.out.printf("You have a %.2f%% tax rate\n", taxBracket.calculateTaxBracket());
                    System.out.printf("You owe $%.2f in taxes\n", taxBracket.calculateTaxAmount());
                }

                else if (userChoice == 6) {
                    System.out.println();
                    System.out.printf("You earned $%.2f in disposable income\n", calculateDisposableIncome.getDisposableIncome());
                }
                else if (userChoice == 7) {
                    System.out.println();
                    finalHoldings = finalHoldings(housingExpenses, utilitiesExpenses, foodExpenses, travelExpenses,
                            entertainmentExpenses, insuranceExpenses, retirement, savings, calculateDisposableIncome);
                    System.out.printf("You have $%.2f left after spending\n", finalHoldings);
                }

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

                else {
                    System.out.printf("Invalid option, %d\n", userChoice);
                    System.out.println();
                }

            }
        }

    }
}
