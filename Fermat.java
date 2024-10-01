import java.util.*;

public class Fermat {
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    static int power(int x, int y, int m) {
        if (y == 0)
            return 1;
        int p = power(x, y / 2, m) % m;
        p = (p * p) % m;

        return (y % 2 == 0) ? p : (x * p) % m;
    }

    static int fermatModularExponentiation(int a, int e, int m) {
        return power(a, e, m);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter base (a): ");
        int a = s.nextInt();
        System.out.print("Enter exponent (e): ");
        int e = s.nextInt();
        System.out.print("Enter modulus (m): ");
        int m = s.nextInt();
        
        int result = fermatModularExponentiation(a, e, m);
        System.out.println(a + "^" + e + " mod " + m + " = " + result);
    }
}
