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
            System.out.println();

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
            yearlyExpense = 0;
            for (double elements : monthlyExpense) {
                yearlyExpense += elements;
            }
        }
        return yearlyExpense;
    }
    public void setExpenses() {
        if (isMonthly) {
            System.out.println("1.) January | 2.) February | 3.) March");
            System.out.println("4.) April | 5.) May | 6.) June");
            System.out.println("7.) July | 8.) August | 9.) September");
            System.out.println("10.) October | 11.) November | 12.) December");


            boolean done = false;

            while (!done) {
                System.out.print("Please specify a month to modify (1-12): ");
                byte userChoice = scnr.nextByte();
                userChoice -= 1;
                System.out.print("Please specify a new value: ");
                monthlyExpense[userChoice] = scnr.nextDouble();

                yearlyExpense = 0;
                for (double elements : monthlyExpense) {
                    yearlyExpense += elements;
                }
                scnr.nextLine();

                System.out.print("Would you like to continue (Y/N): ");
                char continueChoice = scnr.nextLine().charAt(0);
                if (continueChoice == 'N' || continueChoice == 'n') {
                    done = true;
                }
            }
        }
        else {
            yearlyExpense = scnr.nextDouble();
        }

    }
}
