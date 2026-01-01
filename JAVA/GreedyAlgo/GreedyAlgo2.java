/*
===========================================================
TITLE
===========================================================
Activity Selection Problem (End Time Not Sorted)
Using Greedy Algorithm with Sorting

===========================================================
PROBLEM STATEMENT
===========================================================
You are given two arrays:
• `start[]` → start times of activities
• `end[]`   → end times of activities

Each activity requires exclusive use of a single resource,
so no two selected activities can overlap.

Unlike the basic version, **the activities are NOT sorted
by end time**.

Your task is to select the **maximum number of non-overlapping
activities**.

===========================================================
PROBLEM RESOURCE (links)
===========================================================
https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo/

===========================================================
INTUITION
===========================================================
The greedy strategy still applies:
• Always select the activity that finishes earliest

But since the end times are not sorted:
• We must first sort activities based on their end time
• While sorting, we must preserve original activity indices

===========================================================
APPROACH
===========================================================
1) Create a 2D array `Activity[][]` where:
   - Activity[i][0] → original index
   - Activity[i][1] → start time
   - Activity[i][2] → end time
2) Sort the 2D array based on end time (ascending).
3) Select the first activity (earliest end time).
4) Traverse remaining activities:
   - If start time ≥ last selected activity’s end time,
     select the activity.
5) Count and print selected activities.

===========================================================
EXAMPLE
===========================================================
Input:
start = [1, 3, 0, 5, 8, 5]
end   = [2, 4, 6, 7, 9, 9]

After Sorting by end time:
(1,2), (3,4), (0,6), (5,7), (8,9), (5,9)

Selected Activities:
A0 → A1 → A3 → A4

===========================================================
DRY RUN
===========================================================
First selected: (1,2)
Next (3,4) → 3 ≥ 2 → Selected
Next (0,6) → 0 < 4 → Rejected
Next (5,7) → 5 ≥ 4 → Selected
Next (8,9) → 8 ≥ 7 → Selected
Next (5,9) → 5 < 9 → Rejected

Maximum tasks = 4

===========================================================
KEY POINTS
===========================================================
• Sorting by end time is mandatory
• Original indices are preserved using a 2D array
• Greedy choice ensures optimal solution
• Works for both sorted and unsorted inputs

===========================================================
TIME COMPLEXITY
===========================================================
O(n log n)
- Sorting activities by end time

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
- Extra 2D array and list to store selected activities

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Comparator sorts based on end time (3rd column)
• First selected activity always has the minimum end time
• Start time is compared with `lastAct` to avoid overlap
===========================================================
*/

package GreedyAlgo;

import java.util.*;

public class GreedyAlgo2 {

    // Function to perform activity selection when end times are not sorted
    public static void activitySelection(int[] start, int[] end) {

        // Step 1: Create a 2D array to store:
        // [original index, start time, end time]
        int Activity[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            Activity[i][0] = i;        // Original index
            Activity[i][1] = start[i]; // Start time
            Activity[i][2] = end[i];   // End time
        }

        // Step 2: Sort activities based on end time
        Arrays.sort(Activity, Comparator.comparingDouble(o -> o[2])); // Lambda function

        ArrayList<Integer> ans = new ArrayList<>(); // Stores selected activity indices
        int n = start.length;

        int count; // Counts selected activities

        // Step 3: Select first activity (earliest ending)
        ans.add(Activity[0][0]);  // Store original index
        count = 1;

        int lastAct = Activity[0][2]; // End time of last selected activity

        // Step 4: Traverse remaining activities
        for (int i = 1; i < n; i++) {

            // Check for non-overlapping condition
            if (Activity[i][1] >= lastAct) {

                // Select activity
                ans.add(Activity[i][0]);
                lastAct = Activity[i][2];
                count++;
            }
        }

        // Output results
        System.out.println("Maximum task : " + count);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }

    public static void main(String[] args) {

        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[]   = { 2, 4, 6, 7, 9, 9 };

        // Call activity selection
        activitySelection(start, end);
    }
}
