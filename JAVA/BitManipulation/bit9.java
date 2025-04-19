package BitManipulation;
import java.util.*;

public class bit9 {
    public static int fastExpo(int n,int p){
        int ans = 1;
        while(p>0){
            if((p&1)!=0){ // checking LSB is 1 or not
                ans= ans*n;
             }
             n =n*n;
             p = p>>1;
        }
        return ans;
    }
    public static void main(String args[]){
        int n,p;
        System.out.println("enter any number");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("enter power ");
          p = sc.nextInt();
          System.out.println("result is "+fastExpo(n,p));
    
}
}
