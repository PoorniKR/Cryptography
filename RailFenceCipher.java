import java.util.Scanner;

public class RailFenceCipher {
    public static String encrypt(String message, int rails) {
        char[][] railFence = new char[rails][message.length()];
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < message.length(); j++) {
                railFence[i][j] = '.';
            }
        }
        int row = 0;
        boolean down = true;
        for (int i = 0; i < message.length(); i++) {
            railFence[row][i] = message.charAt(i);
            if (row == 0) {
                down = true;
            } else if (row == rails - 1) {
                down = false;
            }
            if (down) {
                row++;
            } else {
                row--;
            }
        }
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < message.length(); j++) {
                if (railFence[i][j] != '.') {
                    encryptedMessage.append(railFence[i][j]);
                }
            }
        }
        return encryptedMessage.toString();
    }

    public static String decrypt(String encryptedMessage, int rails) {
        char[][] railFence = new char[rails][encryptedMessage.length()];
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < encryptedMessage.length(); j++) {
                railFence[i][j] = '.';
            }
        }
        int row = 0;
        boolean down = true;
        for (int i = 0; i < encryptedMessage.length(); i++) {
            railFence[row][i] = 'X';
            if (row == 0) {
                down = true;
            } else if (row == rails - 1) {
                down = false;
            }
            if (down) {
                row++;
            } else {
                row--;
            }
        }
        int index = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < encryptedMessage.length(); j++) {
                if (railFence[i][j] == 'X') {
                    railFence[i][j] = encryptedMessage.charAt(index++);
                }
            }
        }
        StringBuilder decryptedMessage = new StringBuilder();
        row = 0;
        down = true;
        for (int i = 0; i < encryptedMessage.length(); i++) {
            decryptedMessage.append(railFence[row][i]);
            if (row == 0) {
                down = true;
            } else if (row == rails - 1) {
                down = false;
            }
            if (down) {
                row++;
            } else {
                row--;
            }
        }
        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the message to encrypt: ");
        String message = scanner.nextLine();
        System.out.print("Enter the number of rails: ");
        int rails = scanner.nextInt();
        String encryptedMessage = encrypt(message, rails);
        System.out.println("Encrypted message: " + encryptedMessage);
        String decryptedMessage = decrypt(encryptedMessage, rails);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}