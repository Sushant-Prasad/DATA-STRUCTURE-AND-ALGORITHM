/*
===========================================================
TITLE
===========================================================
Maximum Length Chain of Pairs using Greedy Algorithm

===========================================================
PROBLEM STATEMENT
===========================================================
You are given an array of pairs, where each pair consists of
two integers (a, b).

A pair (a, b) can be chained after another pair (c, d) if:
b < c

Your task is to find the **maximum length of a chain**
that can be formed using these pairs.

===========================================================
PROBLEM RESOURCE (links)
===========================================================
https://www.geeksforgeeks.org/maximum-length-chain-of-pairs-dp-20/

===========================================================
INTUITION
===========================================================
This problem is similar to the **Activity Selection Problem**.

Key observation:
• To form the longest chain, we should always choose the pair
  that finishes earliest (smallest ending value).

Why?
• Choosing the earliest ending pair leaves more room to
  attach future pairs.
• This greedy choice ensures the maximum number of pairs.

===========================================================
APPROACH
===========================================================
1) Sort all pairs based on their second element (ending value).
2) Select the first pair as part of the chain.
3) Traverse remaining pairs:
   - If the starting value of the current pair is greater than
     the ending value of the last selected pair, include it.
4) Count how many pairs are selected.

===========================================================
EXAMPLE
===========================================================
Input:
pairs = { {5,24}, {39,60}, {5,28}, {27,40}, {50,90} }

After Sorting by second element:
{5,24}, {5,28}, {27,40}, {39,60}, {50,90}

Valid Chain:
{5,24} → {27,40} → {50,90}

Output:
3

===========================================================
DRY RUN
===========================================================
Initial pair selected: {5,24}
lastChain = 24, count = 1

{5,28}  → 5 <= 24 → Cannot select
{27,40} → 27 > 24 → Select → count = 2, lastChain = 40
{39,60} → 39 <= 40 → Cannot select
{50,90} → 50 > 40 → Select → count = 3

===========================================================
KEY POINTS
===========================================================
• Sorting by ending value is crucial
• Greedy strategy guarantees optimal chain length
• Similar logic to activity selection
• Only strict inequality (>) is allowed for chaining

===========================================================
TIME COMPLEXITY
===========================================================
O(n log n)
- Sorting the pairs dominates the time

===========================================================
SPACE COMPLEXITY
===========================================================
O(1)
- Sorting done in-place (ignoring input storage)

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• `pairs[i][0]` → start of pair
• `pairs[i][1]` → end of pair
• `lastChain` tracks the end of last selected pair
• First pair is always selected after sorting
===========================================================
*/

package GreedyAlgo;

import java.util.*;

public class GreedyAlgo5 {

    // Function to find maximum length chain of pairs
    public static int longestChain(int[][] pairs) {

        int chainCount = 1;           // At least one pair can be selected
        int n = pairs.length;

        // Step 1: Sort pairs based on second element (ending value)
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        // Step 2: Select first pair
        int lastChain = pairs[0][1];  // End value of last selected pair

        // Step 3: Traverse remaining pairs
        for (int i = 1; i < n; i++) {

            // If current pair can be chained
            if (pairs[i][0] > lastChain) {

                chainCount++;               // Increase chain length
                lastChain = pairs[i][1];   // Update last selected end
            }
        }

        return chainCount; // Maximum chain length
    }

    public static void main(String[] args) {

        int pairs[][] = {
            {5, 24},
            {39, 60},
            {5, 28},
            {27, 40},
            {50, 90}
        };

        // Print maximum chain length
        System.out.println(longestChain(pairs));
    }
}
