package Arrays;
import java.util.*;
public class Array {
    public static void main(String args[]){
    int marks[]= new int[50];
    System.out.println("enter marks");
    Scanner sc = new Scanner(System.in);
    marks[0]=sc.nextInt();
     marks[1]=sc.nextInt();
      marks[2]=sc.nextInt();
       System.out.println("phy :"+marks[0]);
        System.out.println("math :"+marks[1]);
         System.out.println("chem :"+marks[2]);
         sc.close();
    }
    
}
