package Arrays;
import java.util.*;
// count sort

public class array15 {
    public static void countsort(int a[], int n){
        int i;
        //find the largest number and create a count array of (largest+1) size.
        int largest = Integer.MIN_VALUE;
        for(i = 0; i<n;i++){
        largest = Math.max(largest,a[i]);
        }
        int count[]= new int[largest+1];
        // count the frequency of every number of Original array
        for(i=0;i <n;i++){
            count[a[i]]++;

        }
        //sorting
        // i:- count array;    j:- original array;
        int j=0;
        for(i=0;j<count.length;i++){
            while(count[i]>0){
                a[j] = i;
                j++;
                count[i]--;
            }
            
        }for(i=0;i<n;i++){
        System.out.println(a[i]+"");
        }
    }
    public static void selectionsort(int a[],int n){
        int i,j;
        for(i=0;i<n-1;i++){
            int minPos = i;
            for(j=i+1;j<n;j++){
                if(a[minPos]>a[j]){
                    minPos = j;
                }

            }
            //swap
            int temp = a[minPos];
            a[minPos] =a[i];
            a[i] = temp;

        }
        for(i=0;i<n;i++){
        System.out.print(a[i]+" ");
    }
}
        public static void main(String args[]){
        int i,n;
        int a[]= new int[50];
        System.out.println("enter size of array ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("Enter the elements of array ");
        for(i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println(" sorted array is ");
        countsort(a,n);
 }
    
}
