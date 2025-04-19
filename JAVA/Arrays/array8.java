package Arrays;
//subarrays
// total subarray = (n(n+1))/2
import java.util.*;
public class array8 {
    public static void subarrays(int a[],int n)
{
    int i,j,k;
    for(i=0;i<n;i++){ // for stating point
        for(j=i;j<n;j++){ //for ending point
            for(k=i;k<=j;k++){ //for printing elements between starting and ending
    // for(end=n;end>0;end--){
    // for(i=0;i<end;i++){
    //for(j=i;j<end;j++){
        
            System.out.print(a[k]+" ");     
        }
        System.out.println();
    }
    System.out.println();
}

}   
  public static void main(String args[]){
    int i,n;
    int a[]=new int[50];
    System.out.println("enter size of array");
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    System.out.println("enter elements of array :");
    for(i=0;i<n;i++){
        a[i]= sc.nextInt();

    }
    System.out.println("subarrays  are :");
    subarrays(a,n);
    }
}

