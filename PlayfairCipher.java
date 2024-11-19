import java.util.*
;
public class PlayfairCipher {
    private char[][] keyTable;
    private static final int grid_dimension = 5;
    private static final char APPEND = 'X';

    public PlayfairCipher(String key) {
        keyTable = generateKeyTable(key);
    }

    private char[][] generateKeyTable(String key) {
        char[][] table = new char[grid_dimension][grid_dimension];
        boolean[] used = new boolean[26];
        int row = 0, col = 0;
        for (char ch : key.toUpperCase().toCharArray()) {
            if (ch == 'J') ch = 'I';
            if (!used[ch - 'A']) {
                table[row][col] = ch;
                used[ch - 'A'] = true;
                col++;
                if (col == grid_dimension) {
                    row++;
                    col = 0;
                }
            }
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (ch == 'J') continue;
            if (!used[ch - 'A']) {
                table[row][col] = ch;
                used[ch - 'A'] = true;
                col++;
                if (col == grid_dimension) {
                    row++;
                    col = 0;
                }
            }
        }

        return table;
    }

    public void displayKeyTable() {
        System.out.println("Key Table:");
        for (int i = 0; i < grid_dimension; i++) {
            for (int j = 0; j < grid_dimension; j++) {
                System.out.print(keyTable[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String encrypt(String plaintext) {
        plaintext = preprocess(plaintext);
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i += 2) {
            char ch1 = plaintext.charAt(i);
            char ch2 = plaintext.charAt(i + 1);
            int[] pos1 = findPosition(ch1);
            int[] pos2 = findPosition(ch2);

            if (pos1[0] == pos2[0]) {
                ciphertext.append(keyTable[pos1[0]][(pos1[1] + 1) % grid_dimension]);
                ciphertext.append(keyTable[pos2[0]][(pos2[1] + 1) % grid_dimension]);
            } else if (pos1[1] == pos2[1]) {
                ciphertext.append(keyTable[(pos1[0] + 1) % grid_dimension][pos1[1]]);
                ciphertext.append(keyTable[(pos2[0] + 1) % grid_dimension][pos2[1]]);
            } else {
                ciphertext.append(keyTable[pos1[0]][pos2[1]]);
                ciphertext.append(keyTable[pos2[0]][pos1[1]]);
            }
        }
        return ciphertext.toString();
    }

    public String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i += 2) {
            char ch1 = ciphertext.charAt(i);
            char ch2 = ciphertext.charAt(i + 1);
            int[] pos1 = findPosition(ch1);
            int[] pos2 = findPosition(ch2);

            if (pos1[0] == pos2[0]) {
                plaintext.append(keyTable[pos1[0]][(pos1[1] + grid_dimension - 1) % grid_dimension]);
                plaintext.append(keyTable[pos2[0]][(pos2[1] + grid_dimension - 1) % grid_dimension]);
            } else if (pos1[1] == pos2[1]) {
                plaintext.append(keyTable[(pos1[0] + grid_dimension - 1) % grid_dimension][pos1[1]]);
                plaintext.append(keyTable[(pos2[0] + grid_dimension - 1) % grid_dimension][pos2[1]]);
            } else {
                plaintext.append(keyTable[pos1[0]][pos2[1]]);
                plaintext.append(keyTable[pos2[0]][pos1[1]]);
            }
        }
        return postprocess(plaintext.toString());
    }

    private String preprocess(String text) {
        StringBuilder sb = new StringBuilder(text.toUpperCase().replaceAll("[^A-Z]", ""));
        for (int i = 1; i < sb.length(); i += 2) {
            if (sb.charAt(i) == sb.charAt(i - 1)) {
                sb.insert(i, APPEND);
            }
        }
        if (sb.length() % 2 != 0) {
            sb.append(APPEND);
        }
        return sb.toString();
    }

    private String postprocess(String text) {
        return text.replace(APPEND, ' ').trim();
    }

    private int[] findPosition(char ch) {
        for (int i = 0; i < grid_dimension; i++) {
            for (int j = 0; j < grid_dimension; j++) {
                if (keyTable[i][j] == ch) return new int[]{i, j};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plaintext = scanner.nextLine();
        String key = scanner.nextLine();
        PlayfairCipher cipher = new PlayfairCipher(key);

        cipher.displayKeyTable(); 
        String ciphertext = cipher.encrypt(plaintext);
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Ciphertext: " + ciphertext);

        String decryptedText = cipher.decrypt(ciphertext);
        System.out.println("Decrypted text: " + decryptedText);
        scanner.close();
    }
}
