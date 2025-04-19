package BitManipulation;
import java.util.Scanner;
public class bit3 {
       public static int setIthBit(int n, int i){
        int bitmask = 1<<i; // indexing starts from 0th position.
        return n|bitmask;
        

    }  
       public static void main(String args[]){
        int n,i;
        System.out.println("enter any number");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("enter the position of bit you want to set ");
          i = sc.nextInt();
        System.out.println("new number is "+setIthBit( n, i));

    }
    
    
}
