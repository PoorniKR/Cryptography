public class RSA {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int p = 3;
        int q = 7;

        int n = p * q;

        int phi = (p - 1) * (q - 1);

        int e = 2;
        while (gcd(e, phi) != 1) {
            e++;
        }

        int d = 0;
        for (int k = 1; k < phi; k++) {
            if ((1 + k * phi) % e == 0) {
                d = (1 + k * phi) / e;
                break;
            }
        }

        int msg = 12;
        System.out.println("Message data = " + msg);

        int c = (int) (Math.pow(msg, e) % n);
        System.out.println("Encrypted data = " + c);

        int m = (int) (Math.pow(c, d) % n);
        System.out.println("Original Message Sent = " + m);
    }
}
