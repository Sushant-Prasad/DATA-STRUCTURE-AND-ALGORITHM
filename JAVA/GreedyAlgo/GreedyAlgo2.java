//Activity selection(end array  is not sorted)
//TC:- O(nlogn)

package GreedyAlgo;

import java.util.*;

public class GreedyAlgo2 {
  public static void activitySelection(int[] start, int[] end) {
    //before sorting make a 2D array for storing index of starting array
    int Activity[][] = new int[start.length][3];
    for(int i=0;i<start.length;i++){
      Activity[i][0]=i; 
      Activity[i][1]=start[i];
      Activity[i][2]=end[i];

    }
    //sort 2darray

    Arrays.sort(Activity,Comparator.comparingDouble(o->o[2]));// Lemda function
    ArrayList<Integer> ans = new ArrayList<>();
    int n = start.length;
    int count;// counting activity
    //1st activity
    ans.add(Activity[0][0]); // first col is for index
    count = 1;
    int lastAct = Activity[0][2]; // 3rd col for end
    for (int i = 1; i < n; i++) {
      if (Activity[i][1] >= lastAct) { // 2nd col for start
        //activity selection
        ans.add(Activity[i][0]);
        lastAct = Activity[i][2];
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
    int end[] = { 2, 4, 6, 7, 9, 9 };
    activitySelection(start, end);

  }

}

