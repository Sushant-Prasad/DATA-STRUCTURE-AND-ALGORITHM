package BitManipulation;
// clear last i bits
import java.util.Scanner;
public class bit5 {
       public static int clearLastIBits(int n, int i){
        int bitmask = (~0)<<i; 
        return n & bitmask;   
 }  
       public static void main(String args[]){
        int n,i;
        System.out.println("enter any number");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("enter the no. of  bit you want to clear from last ");
          i = sc.nextInt();
        System.out.println("new number is "+clearLastIBits( n, i));

    }
    
    
}

