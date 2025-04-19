//Max length chain of pairs
// TC:- O(nlogn)
package GreedyAlgo;

import java.util.*;

public class GreedyAlgo5 {
  public static int longestChain(int[][] pairs) {
    int chainCount = 1;
    int n = pairs.length;
    Arrays.sort(pairs, Comparator.comparingDouble(o -> (o[1])));
    int lastChain = pairs[0][1];
    for (int i = 1; i < n; i++) {
      if (pairs[i][0] > lastChain) {
        chainCount++;
        lastChain = pairs[i][1];

      }

    }
    return chainCount;

  }

  public static void main(String[] args) {
    int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
    System.out.println(longestChain(pairs));

  }

}
