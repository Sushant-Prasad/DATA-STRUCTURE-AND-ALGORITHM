package Recursion;
// factorial of n;
// TC:- O(n)
// SC:- O(n)
public class recursion3 {
    public static int factorial(int n){
        if(n==0){
           
            return 1;
        }
       int result =n* factorial( n-1);
   return result;
    
    }
    public static void main(String args[]){
        int n = 7;
    System.out.println(factorial(n));
    }
    
}
