import java.util.*;
import java.util.Scanner; 

public class RowTransposition {

    public static void main(String args[]) {
        String key;
        String message;
        String encryptedMessage;
        int x = 0;
        int y = 0;

        System.out.print("Type your Key : ");
        Scanner scan = new Scanner(System.in);
        key = scan.nextLine();
        System.out.println("Your Key is " + key);
        System.out.print("Type your Message : ");
        message = scan.nextLine();
        System.out.println("Your Message is " + message);
        int msgchar = message.length();
        int keycahr = key.length();

        if (!((msgchar % keycahr) == 0)) {

            do {
                message = message + "x";
                msgchar = message.length();
            } while (!((msgchar % keycahr) == 0));

        }

        encryptedMessage = "";

        char temp[][] = new char[key.length()][message.length()];
        char msg[] = message.toCharArray();
        x = 0;
        y = 0;
        for (int i = 0; i < msg.length; i++) {
            temp[x][y] = msg[i];
            if (x == (key.length() - 1)) {
                x = 0;
                y = y + 1;
            } else {
                x++;
            }
        }
        char t[] = new char[key.length()];
        t = key.toCharArray();
        Arrays.sort(t);

        for (int j = 0; j < y; j++) {
            for (int i = 0; i < key.length(); i++) {
                System.out.print(temp[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < key.length(); i++) {
                int pos = 0;
                for (pos = 0; pos < t.length; pos++) {
                    if (key.charAt(i) == t[pos]) {
                        break;
                    }
                }
                System.out.print(temp[pos][j]);
                encryptedMessage += temp[pos][j];
            }
            System.out.println();
        }

        System.out.println("Encrypted Message:"+encryptedMessage);
        System.exit(0);
    }
}