package BitManipulation;
import java.util.*;
public class bit {
    public static void oddeven(int n){
        int bitmask = 1;
        if((n&bitmask)==1){
            System.out.println("Odd number");
        }
        else{
            System.out.println("Even number");
        }

    }
    public static void main(String args[]){
        int n,i;
        System.out.println("enter any number");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("enter the position of bit");
          i = sc.nextInt();
        oddeven(n);
        getIthBit( n, i);

    }
    
}
