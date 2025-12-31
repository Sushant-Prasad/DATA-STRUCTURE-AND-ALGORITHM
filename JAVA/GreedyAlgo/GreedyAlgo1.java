/*
===========================================================
TITLE
===========================================================
Activity Selection Problem using Greedy Algorithm

===========================================================
PROBLEM STATEMENT
===========================================================
You are given two arrays:
• `start[]` → start time of activities
• `end[]`   → end time of activities

Each activity takes place in a single room, and only one activity
can be performed at a time.

Your task is to **select the maximum number of non-overlapping
activities** such that no two selected activities overlap in time.

Assumption:
• Activities are already sorted according to their end times.

===========================================================
PROBLEM RESOURCE (links)
===========================================================
https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo/

===========================================================
INTUITION
===========================================================
To maximize the number of activities:
• Always select the activity that finishes earliest
• This leaves maximum room for future activities

This greedy choice works because:
- Choosing the earliest finishing activity minimizes conflicts
- Once selected, the remaining problem is reduced optimally

===========================================================
APPROACH
===========================================================
1) Select the first activity (earliest ending).
2) Keep track of the end time of the last selected activity.
3) Traverse remaining activities:
   - If the start time of the current activity is ≥ last selected
     activity’s end time, select it.
4) Count selected activities and store their indices.

===========================================================
EXAMPLE
===========================================================
Input:
start = [1, 3, 0, 5, 8, 5]
end   = [2, 4, 6, 7, 9, 9]

Selected Activities:
A0 → A1 → A3 → A4

Output:
Maximum task : 4

===========================================================
DRY RUN
===========================================================
Activity 0: (1,2) → Selected
Activity 1: (3,4) → 3 ≥ 2 → Selected
Activity 2: (0,6) → 0 < 4 → Rejected
Activity 3: (5,7) → 5 ≥ 4 → Selected
Activity 4: (8,9) → 8 ≥ 7 → Selected
Activity 5: (5,9) → 5 < 9 → Rejected

===========================================================
KEY POINTS
===========================================================
• End times must be sorted
• Greedy choice is optimal
• Works only when activities are sorted by end time
• Simple and efficient solution

===========================================================
TIME COMPLEXITY
===========================================================
O(n)
- Single traversal of activities

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
- To store selected activity indices

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• First activity is always selected
• `lastAct` tracks the end time of the last selected activity
• Activity is selected only if it does not overlap
===========================================================
*/

package GreedyAlgo;

import java.util.*;

public class GreedyAlgo1 {

    // Function to perform activity selection
    public static void activitySelection(int[] start, int[] end) {

        ArrayList<Integer> ans = new ArrayList<>(); // Stores selected activity indices
        int n = start.length;

        int count; // Counts number of selected activities

        // Step 1: Select the first activity (earliest finishing)
        ans.add(0);
        count = 1;

        int lastAct = end[0]; // End time of last selected activity

        // Step 2: Traverse remaining activities
        for (int i = 1; i < n; i++) {

            // Check if current activity does not overlap
            if (start[i] >= lastAct) {

                // Select activity
                ans.add(i);
                lastAct = end[i]; // Update last selected activity end time
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
        int end[]   = { 2, 4, 6, 7, 9, 9 }; // Already sorted by end time

        // Call activity selection
        activitySelection(start, end);
    }
}
