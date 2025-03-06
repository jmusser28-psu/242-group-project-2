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
                calculateDisposableIncome = new CalculateDisposableIncome(earnedIncome.getIncome(),
                        taxBracket.calculateTaxAmount());

                double totalExpenses = (housingExpenses.getExpenses() + utilitiesExpenses.getExpenses() +
                        foodExpenses.getExpenses() + travelExpenses.getExpenses() +
                        entertainmentExpenses.getExpenses() + insuranceExpenses.getExpenses());
                double totalSavings = retirement.getExpenses() + savings.getExpenses();
                double total = totalExpenses + totalSavings;
               finalHoldings = (calculateDisposableIncome.getDisposableIncome() - total);

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

                isFirstTime = false;
            }

            else {
                InformationPrinter.printMenu();
                userChoice = ByteValidation.validate();

                if (userChoice == 0) {
                    run = false;

                    double totalExpenses = (housingExpenses.getExpenses() + utilitiesExpenses.getExpenses() +
                            foodExpenses.getExpenses() + travelExpenses.getExpenses() +
                            entertainmentExpenses.getExpenses() + insuranceExpenses.getExpenses());
                    double totalSavings = retirement.getExpenses() + savings.getExpenses();
                    double total = totalExpenses + totalSavings;
                    finalHoldings = (calculateDisposableIncome.getDisposableIncome() - total);

                    System.out.printf("Your final holdings are: $%.2f\n", finalHoldings);
                     if (finalHoldings >= 0) {
                     System.out.println("You are financially good");
                     }
                     else {
                     System.out.println("You are not financially good");
                     System.out.println("Consider getting another job");
                     }
                    System.out.println("Good bye");

                }

                else if (userChoice == 1) {
                    InformationPrinter.listExpenses(housingExpenses, utilitiesExpenses, foodExpenses,
                            travelExpenses, entertainmentExpenses, insuranceExpenses, retirement, savings);
                }

                else if (userChoice == 2) {
                    InformationPrinter.modifyExpenses(housingExpenses, utilitiesExpenses, foodExpenses,
                            travelExpenses, entertainmentExpenses, insuranceExpenses, retirement, savings);
                }

                else if (userChoice == 3) {
                    earnedIncome.setIncome();
                }

                else if (userChoice == 4) {
                    filingStatus.setStatus();
                }

                else if (userChoice == 5) {
                    System.out.println(taxBracket.calculateTaxAmount());
                }

                else if (userChoice == 6) {
                    calculateDisposableIncome.getDisposableIncome();
                }
                else if (userChoice == 7) {
                    double totalExpenses = (housingExpenses.getExpenses() + utilitiesExpenses.getExpenses() +
                            foodExpenses.getExpenses() + travelExpenses.getExpenses() +
                            entertainmentExpenses.getExpenses() + insuranceExpenses.getExpenses());
                    double totalSavings = retirement.getExpenses() + savings.getExpenses();
                    double total = totalExpenses + totalSavings;
                    finalHoldings = (calculateDisposableIncome.getDisposableIncome() - total);
                }

                else if (userChoice == 8) {
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
