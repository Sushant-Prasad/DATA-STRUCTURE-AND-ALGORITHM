package Arrays;
import java.util.*;

public class array13 {
    public static int BuyandSellStocks(int a[], int n){
        int BuyingPrice = Integer.MAX_VALUE;
        int MaxProfit=0;
        for(int i=0;i<n;i++){
            if(BuyingPrice<a[i]){
              int   profit = a[i]-BuyingPrice;
              MaxProfit = Math.max(MaxProfit,profit);
            }
            else{
                BuyingPrice = a[i];
            }
            
        }
        return MaxProfit;
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
        System.out.println(" Maximum profit is "+ BuyandSellStocks(a,n));


    }
    
}

