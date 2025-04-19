package BitManipulation;
import java.util.Scanner;

public class bit2 {
       public static void getIthBit(int n, int i){
        int bitmask = 1<<i; // indexing starts from 0th position.
        if((n&bitmask)==0){
            System.out.println(i+"th bit is 0");
        }
        else{
            System.out.println(i+"th bit is 1");
        }

    }  
       public static void main(String args[]){
        int n,i;
        System.out.println("enter any number");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("enter the position of bit you want to know ");
          i = sc.nextInt();
        getIthBit( n, i);

    }
    
}
