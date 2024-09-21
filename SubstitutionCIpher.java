import java.util.*;

public class SubstitutionCipher {
    public static void main(String[] args) {
        String allLetters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String substitution = "1wertyuiopasdfghjk4zxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

        char[][] cipherMatrix = new char[2][allLetters.length()];

        for (int i = 0; i < allLetters.length(); i++) {
            cipherMatrix[0][i] = allLetters.charAt(i);
        }

        for (int i = 0; i < allLetters.length(); i++) {
            cipherMatrix[1][i] = substitution.charAt(i);
        }

        System.out.println("Cipher Matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < allLetters.length(); j++) {
                System.out.print(cipherMatrix[i][j] + " ");
            }
            System.out.println();
        }

Scanner s = new Scanner(System.in);
System.out.println("Enter a plain text:");
        String plainText = s.nextLine();

        if (isValidPassword(plainText)) {
            System.out.println("The entered plain text is a valid password.");
        } else {
            System.out.println("The entered plain text is NOT a valid password.");
        }

        StringBuilder cipherText = new StringBuilder();

        for (char c : plainText.toCharArray()) {
            int index = allLetters.indexOf(c);
            if (index != -1) {
                cipherText.append(cipherMatrix[1][index]);
            } else {
                cipherText.append(c);
            }
        }

        System.out.println("Cipher Text is: " + cipherText);

        StringBuilder decryptedText = new StringBuilder();

        for (char c : cipherText.toString().toCharArray()) {
            int index = -1;
            for (int i = 0; i < allLetters.length(); i++) {
                if (cipherMatrix[1][i] == c) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                decryptedText.append(cipherMatrix[0][index]);
            } else {
                decryptedText.append(c);             }
        }

        System.out.println("Recovered plain text: " + decryptedText);
    }
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}