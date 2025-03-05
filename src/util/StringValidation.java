package util;

import java.util.Scanner;
public class StringValidation {

    private static Scanner scnr = new Scanner(System.in);

    public static String validate() {
        boolean valid = false;
        String returnValue = scnr.nextLine();

        while (!valid) {
            if (returnValue.isBlank()) {
                System.out.println("Error, please enter a valid value");
            }
            else {
                valid = true;
            }
        }

        return returnValue;
    }
}
