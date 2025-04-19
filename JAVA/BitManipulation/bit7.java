package BitManipulation;
import java.util.*;

public class bit7 {
    public static int countSetBit(int n){
        int count = 0;
        while(n>0){
         if((n&1)!= 0){ // checking LSB is 1 or not
                count++;
            }
            n = n>>1;
        }
        return count;
    
    }
     public static void main(String args[]){
        int n;
        System.out.println("enter any number");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("number of setbit is "+countSetBit(n));
    
}
}
