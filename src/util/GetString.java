package util;

import java.util.Scanner;
public class GetString {

    private static Scanner scnr = new Scanner(System.in);

    public static String get() {
        // Here so that we do not need to create or call a scanner in individual classes
        String returnValue = scnr.nextLine();

        return returnValue;
    }
}
