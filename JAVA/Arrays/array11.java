package Arrays;
//max sum of subarray using kadanes algorithm
// time complexicity is O(n)
import java.util.*;

public class array11 {
    //---------Optimized code-----------------
    // it can take array with all -ve number
        public static  int maxSubArray(int[] nums) {
            int n=nums.length;
            int cs = 0;// current sum
            int ms=nums[0];// maximum sum
            for(int i=0;i<n;i++){
                if(cs<0){
                    cs=0;
                }
                cs+=nums[i]; // cs can take -ve number too;
                
                ms =Math.max(cs,ms);
            }
            return ms;
            
        }
    public static void kadanes(int a[],int n){
        int i;
        int cs=0;
        int ms = Integer.MIN_VALUE;
        for(i=0;i<n;i++){
            cs= cs + a[i];
        
        if(cs<0){
            cs=0;
        }
    
        ms = Math.max(cs,ms);
    }
        System.out.println("Maximum sum is "+ms);

    }
     public static void main(String args[]){
    // int i,n;
    // int a[]=new int[50];
    // System.out.println("enter size of array");
    // Scanner sc = new Scanner(System.in);
    // n = sc.nextInt();
    // System.out.println("enter elements of array :");
    // for(i=0;i<n;i++){
    //     a[i]= sc.nextInt();

    // }
    int a[]={-5,-7,-3};
    
//    kadanes(a,n);
   System.out.println();
   System.out.println(maxSubArray(a));
   

    
}
}
