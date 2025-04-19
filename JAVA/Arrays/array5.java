package Arrays;
//binary search
import java.util.*;
public class array5 {
    public static void BinarySearch(int a[],int key, int n){
    int start=0,end =n-1,mid;
    while(start <= end){
        mid = (start +end)/2;
    if(a[mid] == key){
        System.out.println("the index of key "+mid);
        break;
    }
    else if(a[mid]<key){
        start = mid+1;
    }
    else if(a[mid]>key){
        end = mid - 1;
    }
    else{

    System.out.println("number is not found");
    }


    }
}
    public static void main(String args[]){
    int i,n,key;
    int a[]=new int[50];
    System.out.println("enter size of array");
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    System.out.println("enter elements of array :");
    for(i=0;i<n;i++){
        a[i]= sc.nextInt();

    }
    System.out.println("enter key");
    key = sc.nextInt();
    BinarySearch(a,key,n);
    
    }
}
