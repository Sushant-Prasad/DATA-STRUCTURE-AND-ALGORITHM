package Arrays;
// max subarray sum using prefix subarray
// ime complesicity is O(n^2)
import java.util.*;
public class array10{
    public static void MaximumSum(int a[],int n)
{
    int i,j,CurrentSum=0;
    int MaxSum= Integer.MIN_VALUE;
    int prefix[]=new int[n];
    prefix[0]=a[0];
    for(i=1;i<n;i++){
        prefix[i] = prefix[i-1]+a[i];

    }

    for(i=0;i<n;i++){ // for stating point
        for(j=i;j<n;j++){
            if(i==0){
               CurrentSum= prefix[j]; 
            } //for ending point
            else{
            CurrentSum= prefix[j]-prefix[i-1];
            }
        }
    if(MaxSum<CurrentSum){
    MaxSum = CurrentSum;
    
}
        }
        System.out.println("max sum is "+MaxSum);
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
    
   MaximumSum(a,n);

    
}
}