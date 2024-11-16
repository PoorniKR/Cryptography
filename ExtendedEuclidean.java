import java.util.*;

public class ExtendedEuclidean {
    public static int gcd(int a,int b,int st[]){
        int r1=a;
        int r2=b;
        int s1=1,s2=0,t1=0,t2=1;
        while(r2>0){
            int q=r1/r2;
            int r=r1-q*r2;
            r1=r2;
            r2=r;
            int s = s1-q*s2;
            s1=s2;
            s2=s;
            int t = t1-q*t2;
            t1=t2;
            t2=t;
        }
        st[0]=s1;
        st[1]=t1;
        return r1;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a = sc.nextInt();    
        int b = sc.nextInt();    
        int res[] = new int[2];
        System.out.println("Extended Euclidean GCD:"+gcd(a,b,res));
        int s = res[0];
        int t = res[1];
        int gcd = (s * a)+(t*b);
        System.out.println("GCD thru s and t:"+gcd);
    }
}
