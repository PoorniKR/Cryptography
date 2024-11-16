import java.util.*;

class Euclidean{
    public static int gcd(int a,int b){
        int r1=a;
        int r2=b;
        while(r2>0){
            int q = r1/r2;
            int r = r1-q*r2;
            r1=r2;
            r2=r;
        }     
        return r1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("GCD(a,b):"+gcd(a,b));
        sc.close();
    }
}
