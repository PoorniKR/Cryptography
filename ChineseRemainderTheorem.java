import java.util.Scanner;

public class ChineseRemainderTheorem {

    static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return -1; 
    }

    static int chineseRemainder(int[] a, int[] m) {
        int prod = 1;
        for (int mod : m) {
            prod *= mod;
        }

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            int ni = prod / m[i];
            int xi = modInverse(ni, m[i]);
            result += a[i] * xi * ni;
        }

        return result % prod;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of equations: ");
        int n = scanner.nextInt();

        int[] a = new int[n];
        int[] m = new int[n];
        System.out.println("Enter the values for a (remainders):");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "]: ");
            a[i] = scanner.nextInt();
        }
        System.out.println("Enter the values for m (moduli):");
        for (int i = 0; i < n; i++) {
            System.out.print("m[" + i + "]: ");
            m[i] = scanner.nextInt();
        }
        int result = chineseRemainder(a, m);

        System.out.println("Equations:");
        for (int i = 0; i < n; i++) {
            System.out.println("x ≡ " + a[i] + " (mod " + m[i] + ")");
        }
       
        System.out.println("The solution x is: " + result);
       
        scanner.close();
    }
}
