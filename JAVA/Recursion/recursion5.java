package Recursion;
//print nth fibonacci number
public class recursion5 {
    public static int fibo(int n){
        if(n==0){
            return 0;
        }
        else if(n==1){
        return 1;
        }
        int fibN = fibo(n-1) + fibo(n-2);
        return fibN;
    
    }
    public static void main(String args[]){
        int n = 5;
        System.out.println(fibo(n));;
   
    }
    
}
