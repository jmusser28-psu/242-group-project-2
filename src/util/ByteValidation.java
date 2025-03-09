package util;

import java.util.Scanner;
public class ByteValidation {

    private static Scanner scnr = new Scanner(System.in);

    public static byte validate() {
        // Verifies that an input is actually a byte value
        byte returnValue = 0;
        boolean valid = false;
        while (!valid) {
            if (scnr.hasNextByte()) {
                returnValue = scnr.nextByte();
                scnr.nextLine();
                valid = true;
            }
            else {
                System.out.print("Error, Please Enter a Valid Value: ");
                scnr.nextLine();
            }
        }

        return returnValue;
    }
}
