package util;

import java.util.Scanner;
public class DoubleValidation {

    private static Scanner scnr = new Scanner(System.in);

    public static double validate() {
        double returnValue = 0;
        boolean valid = false;
        while (!valid) {
            if (scnr.hasNextDouble()) {
                returnValue = scnr.nextDouble();
                scnr.nextLine();
                valid = true;
            }
            else {
                System.out.print("Error, Please Enter a Valid Numerical Value: ");
                scnr.nextLine();
            }
        }

        return returnValue;
    }
}
