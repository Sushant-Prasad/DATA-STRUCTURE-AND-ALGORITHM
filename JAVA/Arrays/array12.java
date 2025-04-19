package Arrays;
//water trapping
import java.util.*;
public class array12 {
    public static int trappedwater(int a[],int n, int width){
        int i,waterlevel,TrappedWater=0;
        //calculate left max boundry
        int maxLeft[]= new int[n];
        maxLeft[0] = a[0];
        for(i=1;i<n;i++){
            maxLeft[i]= Math.max(a[i],maxLeft[i-1]);
        }
        //calculate right max boundry
        int maxRight[]= new int[n];
        maxRight[n-1]=a[n-1];
        for(i=(n-2);i>=0;i--){
            maxRight[i]= Math.max(a[i],maxRight[i+1]);
        } 
        //loop for water-level and trapped water
     for(i=0;i<n;i++){
        waterlevel = Math.min(maxLeft[i],maxRight[i]);
        TrappedWater = TrappedWater + ((waterlevel-a[i])*width);
    }
    return TrappedWater;

    }
    public static void main(String args[]){
        int i,n,width;
        int a[]= new int[50];
        System.out.println("enter size of array ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("Enter the elements of array ");
        for(i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println("enter width of each bar ");
        width = sc.nextInt();
        System.out.println(" total trapped water is "+trappedwater(a,n,width));


    }
    
}
