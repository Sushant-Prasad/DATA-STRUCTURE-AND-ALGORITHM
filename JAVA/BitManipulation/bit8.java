package BitManipulation;
import java.util.*;

public class bit8 {
    public static int  clearRangeOfBits(int n,int i,int j){
        int a = (~0)<<(j+1); // 111100000000
        int b = (1<<i)-1;
        int bitmask = a|b;
        return n&bitmask;
    }
     public static void main(String args[]){
        int n,i,j;
        System.out.println("enter any number");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("enter the range ");
          i = sc.nextInt();
           j = sc.nextInt();
        System.out.println("new number is "+clearRangeOfBits( n, i,j));

    }
}
