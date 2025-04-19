package Arrays;
//maximum subarray sum
// time comlexity = O(n^3) which is very bad
import java.util.*;
public class array9{
    public static void MaximumSum(int a[],int n)
{
    int i,j,k,CurrentSum=0;
    int MaxSum= Integer.MIN_VALUE;
    for(i=0;i<n;i++){ // for stating point
        for(j=i;j<n;j++){ //for ending point
            CurrentSum=0;
            for(k=i;k<=j;k++){ 

        
            CurrentSum=CurrentSum+a[k];
        }
        System.out.print(CurrentSum+" ");
    if(MaxSum<CurrentSum){
    MaxSum = CurrentSum;
    
}
        }
    }
    System.out.println("\nMax sum is "+MaxSum);
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

