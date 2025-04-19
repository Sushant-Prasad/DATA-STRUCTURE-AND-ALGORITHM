package Recursion;
//print x^n;
//TC:- O(n) which is not good
public class recursion9 {
    public static int power(int x,int n){
        if(n==0){
           
            return 1;
        }
       int result =x*power(x,n-1);
   return result;
    
    }
    public static void main(String args[]){
        int x =2;
        int n = 10;
    System.out.println(power(x,n));
    }
    
}