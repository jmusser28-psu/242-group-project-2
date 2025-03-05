package util;

import java.util.Scanner;
public class CharacterValidation {

    private static Scanner scnr = new Scanner(System.in);

    public static char validate() {
        char returnValue = StringValidation.validate().charAt(0);

        return returnValue;
    }
}
