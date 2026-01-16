/*
===========================================================
TITLE
===========================================================
Chocola Problem (Minimum Cost to Cut Chocolate)

===========================================================
PROBLEM STATEMENT
===========================================================
You are given a chocolate bar of size (m × n).

You need to make:
• Vertical cuts (vc[])
• Horizontal cuts (hc[])

Each cut has a cost.
The cost of a cut is multiplied by the number of pieces
in the perpendicular direction.

Your task is to find the **minimum total cost** required
to cut the chocolate into individual pieces.

===========================================================
INTUITION
===========================================================
This is a classic **Greedy Problem**.

Key idea:
• Always perform the most expensive cut first
• Why?
  Because a higher cost cut will be multiplied by fewer pieces
  if done early, minimizing total cost.

Hence:
• Sort both vertical and horizontal cuts in descending order
• At each step, choose the larger cost cut

===========================================================
APPROACH
===========================================================
1) Sort vertical and horizontal cut cost arrays in descending order
2) Maintain:
   - hp → number of horizontal pieces
   - vp → number of vertical pieces
3) Use two pointers to iterate over both arrays
4) At each step:
   - Pick the larger cut cost
   - Add cost × number of opposite pieces
   - Increment piece count
5) Add remaining cuts (if any)
6) Return total cost

===========================================================
EXAMPLE
===========================================================
Vertical cuts:   [2, 1, 3, 1, 4]
Horizontal cuts: [4, 1, 2]

Sorted (desc):
vc = [4, 3, 2, 1, 1]
hc = [4, 2, 1]

Apply greedy cuts to minimize total cost.

===========================================================
TIME COMPLEXITY
===========================================================
O(n log n)
• Sorting dominates the complexity

===========================================================
SPACE COMPLEXITY
===========================================================
O(1)
• No extra space apart from variables

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Always pick the maximum cost cut first
• Cost is multiplied by number of opposite pieces
• Use Integer[] instead of int[] to use reverseOrder()
===========================================================
*/

package GreedyAlgo;

import java.util.*;

public class GreedyAlgo8 {

    public static int minCost(Integer[] vc, Integer[] hc) {

        // Sort vertical and horizontal cuts in descending order
        Arrays.sort(vc, Collections.reverseOrder());
        Arrays.sort(hc, Collections.reverseOrder());

        int cost = 0;

        int v = 0, h = 0;        // pointers for vc and hc arrays
        int hp = 1, vp = 1;      // horizontal pieces & vertical pieces

        // Process cuts greedily
        while (v < vc.length && h < hc.length) {

            // Choose horizontal cut if its cost is higher or equal
            if (vc[v] <= hc[h]) {

                // Horizontal cut cost multiplied by vertical pieces
                cost += vp * hc[h];
                hp++;   // horizontal pieces increase
                h++;    // move horizontal cut pointer

            } else {

                // Vertical cut cost multiplied by horizontal pieces
                cost += hp * vc[v];
                vp++;   // vertical pieces increase
                v++;    // move vertical cut pointer
            }
        }

        // Remaining horizontal cuts
        while (h < hc.length) {
            cost += vp * hc[h];
            hp++;
            h++;
        }

        // Remaining vertical cuts
        while (v < vc.length) {
            cost += hp * vc[v];
            vp++;
            v++;
        }

        return cost;
    }

    public static void main(String[] args) {

        Integer vc[] = {2, 1, 3, 1, 4}; // vertical cuts
        Integer hc[] = {4, 1, 2};       // horizontal cuts

        System.out.println(minCost(vc, hc));
    }
}
