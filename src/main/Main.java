package main;

import expenses.*;
import util.ByteValidation;
import util.*;

public class Main {

    public static void main(String[] args) {
        boolean isFirstTime = true;
        boolean isMonthly = false;
        byte userChoice = 0;

        HousingExpenses housingExpenses = null;
        UtilitiesExpenses utilitiesExpenses = null;
        FoodExpenses foodExpenses = null;
        TravelExpenses travelExpenses = null;
        EntertainmentExpenses entertainmentExpenses = null;
        InsuranceExpenses insuranceExpenses = null;

        boolean run = true;
        while (run) {
            if (isFirstTime) {
                isMonthly = InformationPrinter.firstRun();

                housingExpenses = new HousingExpenses(isMonthly);
                utilitiesExpenses = new UtilitiesExpenses(isMonthly);
                foodExpenses = new FoodExpenses(isMonthly);
                travelExpenses = new TravelExpenses(isMonthly);
                entertainmentExpenses = new EntertainmentExpenses(isMonthly);
                insuranceExpenses = new InsuranceExpenses(isMonthly);
                isFirstTime = false;
            }

            else {
                InformationPrinter.printMenu();
                userChoice = ByteValidation.validate();

                if (userChoice == 0) {
                    run = false;
                }

                else if (userChoice == 1) {
                    InformationPrinter.listExpenses(housingExpenses, utilitiesExpenses, foodExpenses,
                            travelExpenses, entertainmentExpenses, insuranceExpenses);
                }

                else if (userChoice == 2) {
                    InformationPrinter.modifyExpenses(housingExpenses, utilitiesExpenses, foodExpenses,
                            travelExpenses, entertainmentExpenses, insuranceExpenses);
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
