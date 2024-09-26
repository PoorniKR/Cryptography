import java.util.Scanner;

public class EulerTheorem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base (a): ");
        int base = scanner.nextInt();
        System.out.print("Enter the exponent (b): ");
        int exponent = scanner.nextInt();
        System.out.print("Enter the modulus (n): ");
        int mod = scanner.nextInt();
        
        int phi = phi(mod);
        System.out.println("φ(" + mod + ") = " + phi);

        int reducedExponent = exponent % phi;
        long result = modularExponentiation(base, reducedExponent, mod);
        System.out.println(base + "^" + exponent + " mod " + mod + " = " + result);
        
        scanner.close();
    }

    public static long modularExponentiation(int base, int exponent, int mod) {
        long result = 1;
        long baseMod = base % mod;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * baseMod) % mod;
            }
            exponent >>= 1; 
            baseMod = (baseMod * baseMod) % mod; 
        }
        return result;
    }
    public static int phi(int n) {
        if (n <= 1) return n; 
        if (isPrime(n)) {
            return n - 1;
        }

        int originalN = n;
        int result = n;
        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p; 
            }
        }
        if (n > 1) {
            result -= result / n; 
        }
        
        return result; 
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false; 
        }
        return true; 
    }
}
