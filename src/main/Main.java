package main;

import java.util.Scanner;
import expenses.TravelExpenses;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Would you like to enter yearly or monthly data: ");
        String choice = scnr.nextLine();
        TravelExpenses travelExpenses = null;
        if (choice.equalsIgnoreCase("Monthly")) {
            travelExpenses = new TravelExpenses(true);
        }
        else {
            travelExpenses = new TravelExpenses(false);
        }
        travelExpenses.setExpenses();
        System.out.println(travelExpenses.getExpenses());

    }
}
