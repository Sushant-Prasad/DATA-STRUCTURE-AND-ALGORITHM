//Activity selection
//TC:- O(n)

package GreedyAlgo;

import java.util.*;

public class GreedyAlgo1 {
  public static void activitySelection(int[] start, int[] end) {
    ArrayList<Integer> ans = new ArrayList<>();
    int n = start.length;
    int count;// counting activity
    //1st activity
    ans.add(0);
    count = 1;
    int lastAct = end[0];
    for (int i = 1; i < n; i++) {
      if (start[i] >= lastAct) {
        //activity selection
        ans.add(i);
        lastAct = end[i];
        count++;
        }
    }
    System.out.println("Maximum task : "+count);
    for (int i = 0; i <ans.size(); i++) {
    System.out.print("A"+ans.get(i) + " ");
    }

  }

  public static void main(String[] args) {
    int start[] = { 1, 3, 0, 5, 8, 5 };
    int end[] = { 2, 4, 6, 7, 9, 9 }; // already sorted
    activitySelection(start, end);

  }

}
