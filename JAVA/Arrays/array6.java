package Arrays;
//reverse of array
import java.util.*;
public class array6 {
     public static void main(String args[]){
    int i,n,first,last;
    int a[]=new int[50];
    System.out.println("enter size of array");
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    System.out.println("enter elements of array :");
    for(i=0;i<n;i++){
        a[i]= sc.nextInt();

    }
    for(first=0,last=n-1;first<last;first++,last--){
        int temp = a[last];
        a[last]=a[first];
        a[first]=temp;
    }
    System.out.println("reversed array is ");
    for(i=0;i<n;i++){
        System.out.println(a[i]);
    }
    
     }
    }
