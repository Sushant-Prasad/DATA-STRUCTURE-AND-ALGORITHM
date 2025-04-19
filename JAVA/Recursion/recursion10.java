package Recursion;

    //optimized code for print x^n;
//TC:- O(logn)
public class recursion10 {
    public static int optimizedPower(int x,int n){
        if(n==0){
            return 1;
        }
       int halfPower = optimizedPower(x,n/2);
       int halfPowerSq = halfPower*halfPower;
       if(n%2 != 0){
        halfPowerSq = x*halfPowerSq;
       }
       return halfPowerSq;

    
    }
    public static void main(String args[]){
        int x =2;
        int n = 5;
    System.out.println(optimizedPower(x,n));
    }
    
}
