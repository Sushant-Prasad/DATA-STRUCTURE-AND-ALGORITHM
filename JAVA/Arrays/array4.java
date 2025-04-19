package Arrays;
//lagest number in array
import java.util.*;
public class array4 { 
    public static void main(String args[]){
    int i,n,max,min;
    int a[]=new int[50];
    System.out.println("enter size of array");
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    System.out.println("enter elements of array :");
    for(i=0;i<n;i++){
        a[i]= sc.nextInt();

    }
    max = Integer.MIN_VALUE;// MINUS INFNITY
    min = Integer.MAX_VALUE;//PLUS INFINITY
    for(i=0;i<n;i++){
        if(max<a[i]){
            max=a[i];

        }
          if(min>a[i]){
            min=a[i];

        }
    }
    System.out.println("largest number is "+max);
System.out.println("smalest number is "+min);
}

    
}
