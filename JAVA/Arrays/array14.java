package Arrays;
import java.util.*;
//insertionsort
//bubblesort
//selectionsort

public class array14 {
       public static void insertionsort(int a[],int n){
        int i;
        for(i = 1;i<n; i++){
            int curr = a[i];
           int prev = i-1;
           while(prev>=0 && a[prev]> curr){
            a[prev+1]=a[prev];
            prev--;
           }
           a[prev+1]=curr; 
        }
        for(i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
       }
    public static void bubblesort(int a[],int n){
    int temp;
    for(int turns=0;turns<n-1;turns++){
        for(int j=0;j<n-1-turns;j++){
            if(a[j]>a[j+1]){
                //swapping
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
            }
        }
    }
    for(int i=0;i<n;i++){
    System.out.print(a[i]+" ");
    }
}
   public static void selectionsort(int a[],int n){
        int i,j;
        for(i=0;i<n-1;i++){
            int minPos = i;
            for(j=i+1;j<n;j++){
                if(a[minPos]>a[j]){
                    // > will be replaced by < for descending sorted array

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
        insertionsort(a,n);
 }
    
}

