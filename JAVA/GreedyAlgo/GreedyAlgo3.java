//Fractional knapsack
//TC:- O(nlogn)
package GreedyAlgo;

import java.util.*;

public class GreedyAlgo3 {
  public static int knapsack(int[] weight, int[] value, int maxWeight) {
    int profit = 0;
    int capacity = maxWeight;
    int n = value.length;
    int ratio[][] = new int[n][2];
    for (int i = 0; i < n; i++) {
      ratio[i][0] = i; // for index
      ratio[i][1] = value[i]/weight[i];//for ratio
      
    }
    // ascending order
    Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

    for (int i = n - 1; i >= 0; i--) { // reverse loop
      int index = ratio[i][0];
      if (capacity >= weight[index]) {
        profit = profit + value[index];
        capacity = capacity - weight[index];

      } else {
        // fractional knapsack
        profit += ratio[i][1] *capacity; // value *capacity
        capacity=0;
        break;
      }

    }

    return profit;
  }

  public static void main(String[] args) {
    int[] weight = { 10, 20, 30 };
    int[] value = { 60, 100, 120 };
    int maxWeight = 50;
    System.out.println(knapsack(weight, value, maxWeight));

  }
}
