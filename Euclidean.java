import java.util.*;

public class Euclidean {
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a:");
        int a = s.nextInt();
        System.out.println("Enter b:");
        int b = s.nextInt();
        int g = gcd(a,b);
        System.out.println("GCD(" + a + " , " + b
                           + ") = " + g);
    }
}
