package Arrays;
// leanear search in array
import java.util.*;
public class array3 {
   public static void main(String args[]){
    int i,n,value;
    int flag=1;
    int a[]=new int[50];
    System.out.println("enter size of array");
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    System.out.println("enter elements of array :");
    for(i=0;i<n;i++){
        a[i]= sc.nextInt();

    }
    System.out.println("enter the value you want to search");
    value = sc.nextInt();
    for(i=0;i<n;i++){
         if(a[i]==value){
            flag = 0;
            break;
         }
        }

           if(flag == 0){
            System.out.println(value+" is present and position is "+(i+1));
           }
           else{
            System.out.println(value+" is not present");
           }
           sc.close();
    

   } 
}
