//Indian Coins
package GreedyAlgo;
import java.util.*;

public class GreedyAlgo6 {
  public static int minNote(int[] coins , int ammount){
    int note=0;
    int n = coins.length;
    // int a[][]= new int[n][2];
    // for(int i=0;i<n;i++){
    //   a[i][0]=i;
    // }
    Arrays.sort(coins);
    ArrayList<Integer> ans = new ArrayList<>();
    for(int i=n-1;i>=0;i--){
      if(ammount>=coins[i]){
        while(ammount>=coins[i]){
        note++;
        ans.add(coins[i]);
        ammount =ammount-coins[i];
        }
      }

    }
    System.out.println(ans);
    return note;
  }
  public static void main(String[] args) {
    int coins[] = {1,2,5,10,20,50,100,500,2000};
    int value=590;
   System.out.println( minNote(coins , value));

    
  }
   
}
