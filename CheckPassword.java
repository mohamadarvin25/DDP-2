/*
Name : Mohamad Arvin Fadriansya
NPM : 2006596996
Desc. : Program ini akan mengecek apakah password yang dibuat valid atau tidak
*/

import java.util.Scanner;

public class CheckPassword {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan sebuah password: ");
        String password = input.nextLine();
        if (isValidPassword(password)) {
            System.out.println("kata " + password + " adalah password yang valid.");
        } else {
            System.out.println("kata " + password + " adalah bukan password yang valid.");
        }
    }

    public static boolean isValidPassword(String password) {
        int countLetter = 0;
        int countNumeric = 0;
        if (lengthPassword(password)) {
            for (int i = 0; i < password.length(); i++) {
                if (isLetter(password.charAt(i))) {
                    countLetter++;
                } else if (isNumeric(password.charAt(i))) {
                    countNumeric++;
                } else {
                    return false;
                }

            }

            return (countNumeric >= 3 && countLetter <= 7);

        } else {
            return false;
        }

    }

    public static boolean lengthPassword(String password) {
        if (password.length() != 10) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isLetter(char character) {
        character = Character.toUpperCase(character);
        return (character >= 'A' && character <= 'Z');

    }

    public static boolean isNumeric(char character) {
        return (character >= '0' && character <= '9');
    }

}
