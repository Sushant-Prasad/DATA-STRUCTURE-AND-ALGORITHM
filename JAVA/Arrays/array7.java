package Arrays;
//every possible pairs in an array
import java.util.*;
public class array7 {
    public static void Pairing(int a[],int n)
{
    int i,j;
    for(i=0;i<n;i++){
        for(j=i+1;j<n;j++){
            System.out.println("("+a[i]+","+a[j]+")");
        }
        System.out.println();
    }

}     public static void main(String args[]){
    int i,n;
    int a[]=new int[50];
    System.out.println("enter size of array");
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    System.out.println("enter elements of array :");
    for(i=0;i<n;i++){
        a[i]= sc.nextInt();

    }
    System.out.println("pairs are :");
    Pairing(a,n);
    
}
}
