import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiffieHellman {
    public static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n % 2 == 0) {
            factors.add(2);
            while (n % 2 == 0) {
                n /= 2;
            }
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                factors.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 2) {
            factors.add(n);
        }
        return factors;
    }
    public static boolean isPrimitiveRoot(int candidate, int n) {
        int phi = n - 1;
        List<Integer> factors = primeFactors(phi);

        for (int factor : factors) {
            if (modularExponentiation(candidate, phi / factor, n) == 1) {
                return false;
            }
        }
        return true;
    }
    public static int findPrimitiveRoot(int n) {
        for (int i = 2; i < n; i++) {
            if (isPrimitiveRoot(i, n)) {
                return i;
            }
        }
        return -1; 
    }
    public static int modularExponentiation(int base, int exponent, int mod) {
        int result = 1;
        base = base % mod; 

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            exponent = exponent >> 1; 
            base = (base * base) % mod;
        }

        return result;
    }

    public static void main(String[] args) {
        int xa, xb, ya, yb, a, q, ka, kb;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of Q (prime number)");
        q = sc.nextInt();
        a = findPrimitiveRoot(q);
        if (a == -1) {
            System.out.println("No primitive root found for q. Exiting.");
            return;
        }
        System.out.println("Primitive root modulo " + q + " is: " + a);
        System.out.println("Enter first private key (xa): ");
        xa = sc.nextInt();
        System.out.println("Enter second private key (xb): ");
        xb = sc.nextInt();
        ya = modularExponentiation(a, xa, q);
        yb = modularExponentiation(a, xb, q);

        System.out.println("Public values: ");
        System.out.println("ya = " + ya + ", yb = " + yb);
        ka = modularExponentiation(yb, xa, q);
        kb = modularExponentiation(ya, xb, q);

        System.out.println("Shared keys: ");
        System.out.println("ka = " + ka + ", kb = " + kb);

        if (ka == kb) {
            System.out.println("Key exchanged successfully. Shared key is: " + ka);
        } else {
            System.out.println("Key exchange failed.");
        }

        sc.close();
    }
}
