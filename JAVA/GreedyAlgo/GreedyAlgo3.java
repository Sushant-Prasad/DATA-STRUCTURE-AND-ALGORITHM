/*
===========================================================
TITLE
===========================================================
Fractional Knapsack Problem using Greedy Algorithm

===========================================================
PROBLEM STATEMENT
===========================================================
You are given:
• `weight[]` → weights of items
• `value[]`  → values of items
• `maxWeight` → maximum capacity of the knapsack

You can take:
• The **whole item**, or
• A **fraction of an item**

Your task is to **maximize the total profit/value** that can be
put into the knapsack without exceeding its capacity.

===========================================================
PROBLEM RESOURCE (links)
===========================================================
https://www.geeksforgeeks.org/fractional-knapsack-problem/

===========================================================
INTUITION
===========================================================
To maximize profit:
• Prefer items with **higher value-to-weight ratio**
• Take the most “valuable per unit weight” item first

This greedy choice works because:
- Taking a fraction of an item is allowed
- There is no benefit in skipping a higher ratio item for a lower one

===========================================================
APPROACH
===========================================================
1) Compute value/weight ratio for each item.
2) Store items in a 2D array along with their original indices.
3) Sort items based on ratio in ascending order.
4) Traverse from highest ratio to lowest:
   - If capacity allows, take the full item.
   - Otherwise, take the fractional part that fits.
5) Stop once the knapsack is full.

===========================================================
EXAMPLE
===========================================================
weight = [10, 20, 30]
value  = [60, 100, 120]
capacity = 50

Ratios:
Item 0 → 6
Item 1 → 5
Item 2 → 4

Pick order:
Item 0 → Item 1 → Fraction of Item 2

Maximum Profit = 240

===========================================================
DRY RUN
===========================================================
Initial capacity = 50

Pick Item 0:
weight = 10, value = 60
capacity = 40, profit = 60

Pick Item 1:
weight = 20, value = 100
capacity = 20, profit = 160

Pick fraction of Item 2:
ratio = 4
profit += 4 × 20 = 80
capacity = 0

Final Profit = 240

===========================================================
KEY POINTS
===========================================================
• Sorting by value/weight ratio is essential
• Fractional selection makes greedy optimal
• Different from 0/1 Knapsack (DP-based)
• Works only because fractions are allowed

===========================================================
TIME COMPLEXITY
===========================================================
O(n log n)
- Sorting items based on ratio

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
- Extra 2D array to store ratios

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Ratio is stored as integer here (value / weight)
  → may cause precision loss for some inputs
• For higher accuracy, double ratio is preferred
• Loop runs from highest ratio to lowest
===========================================================
*/

package GreedyAlgo;

import java.util.*;

public class GreedyAlgo3 {

    // Function to calculate maximum profit using fractional knapsack
    public static int knapsack(int[] weight, int[] value, int maxWeight) {

        int profit = 0;              // Stores total profit
        int capacity = maxWeight;    // Remaining capacity of knapsack
        int n = value.length;

        // ratio[i][0] = item index
        // ratio[i][1] = value/weight ratio
        int ratio[][] = new int[n][2];

        // Step 1: Calculate value-to-weight ratio
        for (int i = 0; i < n; i++) {
            ratio[i][0] = i;                       // Store index
            ratio[i][1] = value[i] / weight[i];    // Integer ratio
        }

        // Step 2: Sort items based on ratio (ascending)
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        // Step 3: Pick items from highest ratio to lowest
        for (int i = n - 1; i >= 0; i--) {

            int index = ratio[i][0]; // Original item index

            // If full item can be taken
            if (capacity >= weight[index]) {
                profit += value[index];
                capacity -= weight[index];
            } else {
                // Take fractional part of the item
                profit += ratio[i][1] * capacity;
                capacity = 0;
                break; // Knapsack is full
            }
        }

        return profit; // Maximum achievable profit
    }

    public static void main(String[] args) {

        int[] weight = { 10, 20, 30 };
        int[] value  = { 60, 100, 120 };
        int maxWeight = 50;

        // Print maximum profit
        System.out.println(knapsack(weight, value, maxWeight));
    }
}
