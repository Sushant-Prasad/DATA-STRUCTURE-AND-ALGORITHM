//minimum absolute difference pairs
//TC:-O(nlogn)
package GreedyAlgo;
import java.util.*;

public class GreedyAlgo4 {
  public static int minSum(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);
    int sum = 0;
    for(int i =0;i<a.length;i++){
      sum = sum +  Math.abs(a[i]-b[i]);
    }
   
    return sum;
  }

  public static void main(String[] args) {
    int[] a = {4,1,8,7};
    int[] b = {2,3,6,5};
    System.out.println(minSum(a,b));
    
  }

}
