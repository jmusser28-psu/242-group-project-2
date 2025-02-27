package expenses;

import java.util.Scanner;

public class TravelExpenses {
    private double yearlyExpense;
    private double[] monthlyExpense = new double[12];
    private boolean isMonthly;

    private Scanner scnr = new Scanner(System.in);

    public TravelExpenses(boolean isMonthly) {
        this.isMonthly = isMonthly;
        if (isMonthly) {
            System.out.print("Please enter spending for January: ");
            monthlyExpense[0] =  scnr.nextDouble();
            System.out.print("Please enter spending for February: ");
            monthlyExpense[1] =  scnr.nextDouble();
            System.out.print("Please enter spending for March: ");
            monthlyExpense[2] =  scnr.nextDouble();
            System.out.print("Please enter spending for April: ");
            monthlyExpense[3] =  scnr.nextDouble();
            System.out.print("Please enter spending for May: ");
            monthlyExpense[4] =  scnr.nextDouble();
            System.out.print("Please enter spending for June: ");
            monthlyExpense[5] =  scnr.nextDouble();
            System.out.print("Please enter spending for July: ");
            monthlyExpense[6] =  scnr.nextDouble();
            System.out.print("Please enter spending for August: ");
            monthlyExpense[7] =  scnr.nextDouble();
            System.out.print("Please enter spending for September: ");
            monthlyExpense[8] =  scnr.nextDouble();
            System.out.print("Please enter spending for October: ");
            monthlyExpense[9] =  scnr.nextDouble();
            System.out.print("Please enter spending for November: ");
            monthlyExpense[10] =  scnr.nextDouble();
            System.out.print("Please enter spending for December: ");
            monthlyExpense[11] =  scnr.nextDouble();

            for (double elements : monthlyExpense) {
                yearlyExpense += elements;
            }
        }
        else {
            System.out.print("Please enter a yearly spending: ");
            this.yearlyExpense = scnr.nextDouble();
        }

    }

    public double getExpenses() {
        if (isMonthly) {
            for (double elements : monthlyExpense) {
                yearlyExpense += elements;
            }
        }
        return yearlyExpense;
    }
    public void setExpenses(double expenses) {
        if (isMonthly) {
            System.out.println("1.) January");
            System.out.println("2.) February");
            System.out.println("3.) March");
            System.out.println("4.) April");
            System.out.println("5.) May");
            System.out.println("6.) June");
            System.out.println("7.) July");
            System.out.println("8.) August");
            System.out.println("9.) September");
            System.out.println("10.) October");
            System.out.println("11.) November");
            System.out.println("12.) December");

            System.out.print("Please specify a month to modify (1-12): ");
            byte userChoice = scnr.nextByte();
            userChoice -= 1;
            monthlyExpense[userChoice] = scnr.nextDouble();

            for (double elements : monthlyExpense) {
                yearlyExpense += elements;
            }
        }
        else {
            yearlyExpense = scnr.nextDouble();
        }

    }
}
