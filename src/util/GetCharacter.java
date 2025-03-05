package util;

import java.util.Scanner;
public class GetCharacter {

    private static Scanner scnr = new Scanner(System.in);

    public static char get() {
        char returnValue = GetString.get().charAt(0);

        return returnValue;
    }
}
