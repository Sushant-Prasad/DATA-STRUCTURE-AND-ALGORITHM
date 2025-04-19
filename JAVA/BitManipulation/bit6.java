package BitManipulation;
import java.util.*;

public class bit6 {
    public static void powerOf2(int n){
       int  x = n & (n-1);
        if(x == 0){
            System.out.println("number is power of 2");
        }
        else{
            System.out.println("number is not power of 2 ");
        }
    }
     public static void main(String args[]){
        int n;
        System.out.println("enter any number");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        powerOf2( n);
    
}
}
