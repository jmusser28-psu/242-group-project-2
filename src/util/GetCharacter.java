package util;

import java.util.Scanner;
public class GetCharacter {

    private static Scanner scnr = new Scanner(System.in);

    public static char get() {
        // Here as a shortcut to getting the first character of a string
        char returnValue = GetString.get().charAt(0);

        return returnValue;
    }
}
