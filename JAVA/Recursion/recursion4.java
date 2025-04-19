package Recursion;
//print sum of first n natuiral number
// TC:- O(n)
// SC:- O(n)
public class recursion4 {
     public static int calcSum(int n){
        if(n==1){
           
            return 1;
        }
       int result =n+calcSum( n-1);
   return result;
    
    }
    public static void main(String args[]){
        int n = 4;
    System.out.println(calcSum(n));
    }
    
}
