package util;

import java.util.Scanner;
public class GetString {

    private static Scanner scnr = new Scanner(System.in);

    public static String get() {
        String returnValue = scnr.nextLine();

        return returnValue;
    }
}
