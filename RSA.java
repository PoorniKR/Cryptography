import java.io.*;
import java.math.*;
import java.util.*;

public class RSA {
    public static double gcd(double a,double h){
        double temp;
        while(true){
            temp = a%h;
            if(temp==0){
                return h;
            }
            a=h;
            h=temp;
        }
    }    
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the prime no p and q:");
        double p = scan.nextDouble();
        double q = scan.nextDouble();
        double n = p * q;
        System.out.println("Enter e:");
        double e = scan.nextDouble();
        double phi = (p - 1) * (q - 1);
        while (e < phi) {
            if (gcd(e, phi) == 1)
                break;
            else
                e++;
        }
        double k = Math.pow(e,-1);
        double d = k % e;
        System.out.println("Enter message:");
        double msg = scan.nextDouble();

        System.out.println("Message data = " + msg);
        double c = Math.pow(msg, e);
        c = c % n;
        System.out.println("Encrypted data = " + c);
        double m = Math.pow(c, d);
        m = m % n;
        System.out.println("Original Message Sent = " + m);
    }
}
