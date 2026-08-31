package DP;

/*
===========================================================
TITLE
===========================================================
0/1 Knapsack Problem Using Recursion

===========================================================
PROBLEM STATEMENT
===========================================================
You are given `n` items.

Each item has:
• A value (profit)
• A weight

You also have a knapsack with a maximum weight capacity.

Your task is to select items such that:
• Total weight does not exceed the knapsack capacity.
• Total value is maximized.
• Each item can be selected at most once.

This is called the 0/1 Knapsack Problem because every item
has exactly two choices:

• 0 → Do not include the item.
• 1 → Include the item.

Input:
• int[] val → values/profits of items.
• int[] wt → weights of items.
• int capacity → maximum capacity of the knapsack.
• int i → number of items currently being considered.

Output:
• Maximum possible profit without exceeding the capacity.

Constraints:
• 1 ≤ n ≤ 100
• 1 ≤ wt[i] ≤ capacity
• 1 ≤ val[i] ≤ 10^6
• Each item can be selected at most once.

Edge Cases:
• capacity = 0 → maximum profit = 0.
• i = 0 → no items available, so profit = 0.
• Item weight > remaining capacity → item cannot be included.
• All items are too heavy → return 0.

===========================================================
PROBLEM RESOURCE
===========================================================
• https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

===========================================================
INTUITION
===========================================================
For every item, we have two choices:

1) INCLUDE the item:
   • Add its value to the total profit.
   • Reduce the remaining capacity by its weight.
   • Move to the previous item.

2) EXCLUDE the item:
   • Do not add its value.
   • Keep the same capacity.
   • Move to the previous item.

If the item can fit, we calculate both possibilities and
choose the one that gives maximum profit.

If the item cannot fit, we have only one choice:
exclude the item.

The main recurrence is:

    Maximum Profit =
    max(Include Item, Exclude Item)

This recursive solution has overlapping subproblems.
Therefore, it can later be optimized using Memoization
or Tabulation.

===========================================================
APPROACH
===========================================================
1) Start with all `i` items and the given capacity.

2) Check the base condition:
   • If capacity == 0, return 0.
   • If i == 0, return 0.

3) Consider the current item:
      Item index = i - 1

4) Check whether the current item fits:
      wt[i - 1] <= capacity

5) If the item fits, calculate:

   INCLUDE:
      val[i - 1] + knapsack(val, wt, capacity - wt[i - 1], i - 1)

   EXCLUDE:
      knapsack(val, wt, capacity, i - 1)

6) Return the maximum of INCLUDE and EXCLUDE.

7) If the item does not fit:
   • Exclude the item.
   • Move to the previous item.

===========================================================
EXAMPLE
===========================================================
Input:

val = [15, 14, 10, 45, 30]
wt  = [2,  5,  1,  3,  4]
capacity = 7

Items:

Item 0 → Weight = 2, Value = 15
Item 1 → Weight = 5, Value = 14
Item 2 → Weight = 1, Value = 10
Item 3 → Weight = 3, Value = 45
Item 4 → Weight = 4, Value = 30

Optimal Selection:

Item 3 + Item 4

Total Weight:
3 + 4 = 7

Total Value:
45 + 30 = 75

Since the total weight is exactly equal to the capacity,
this is a valid selection.

Output:
75

===========================================================
DRY RUN
===========================================================
Initial Call:

knapsack(val, wt, 7, 5)

Current Item:
Item 4
Weight = 4
Value = 30

Since:
4 <= 7

Two choices:

INCLUDE Item 4:
30 + knapsack(val, wt, 3, 4)

EXCLUDE Item 4:
knapsack(val, wt, 7, 4)

-----------------------------------------------------------
INCLUDE Item 4
-----------------------------------------------------------

Remaining Capacity:
7 - 4 = 3

Now consider Item 3:

Item 3:
Weight = 3
Value = 45

Since:
3 <= 3

Two choices:

INCLUDE Item 3:
45 + knapsack(val, wt, 0, 3)

EXCLUDE Item 3:
knapsack(val, wt, 3, 3)

For INCLUDE Item 3:

Remaining Capacity:
3 - 3 = 0

Therefore:

knapsack(val, wt, 0, 3) = 0

Profit:
45 + 0 = 45

The INCLUDE branch gives a valid profit of 45.

However, the recursion also explores the EXCLUDE branch
and eventually determines the best result for capacity 3.

For the original INCLUDE Item 4 branch:

Item 4 Profit = 30
Item 3 Profit = 45

Total:
30 + 45 = 75

-----------------------------------------------------------
EXCLUDE Item 4
-----------------------------------------------------------

The algorithm also explores solutions without Item 4.

For example:

Item 0 + Item 2 + Item 3

Weight:
2 + 1 + 3 = 6

Profit:
15 + 10 + 45 = 70

Therefore, this is valid but smaller than 75.

-----------------------------------------------------------
FINAL COMPARISON
-----------------------------------------------------------

Include Item 4 branch:
Profit = 75

Best alternative branch:
Profit = 70

Therefore:

Maximum Profit = max(75, 70)

Maximum Profit = 75

===========================================================
KEY POINTS
===========================================================
• This is the classic 0/1 Knapsack problem.
• Every item has exactly two choices: Include or Exclude.
• An item can be selected only once.
• `i - 1` represents the current item's array index because
  `i` represents the number of items being considered.
• `wt[i - 1] <= capacity` checks whether the current item fits.
• `Math.max()` chooses the better of the two valid choices.
• If an item does not fit, it must be excluded.

Important Recurrence:

If the item fits:

    max(
        val[i - 1] + knapsack(val, wt, capacity - wt[i - 1], i - 1),
        knapsack(val, wt, capacity, i - 1)
    )

If the item does not fit:

    knapsack(val, wt, capacity, i - 1)

Important Difference:

0/1 Knapsack:
• Include item → move to `i - 1`.
• This prevents using the same item again.

Unbounded Knapsack:
• Include item → usually keep the same item available.
• Therefore, the recursive state behaves differently.

Alternative Approaches:
• Recursion → O(2^n)
• Memoization → O(n × capacity)
• Tabulation → O(n × capacity)
• Space Optimized Tabulation → O(capacity)

Common Pitfalls:
• Using `i` instead of `i - 1` when accessing arrays.
• Reusing an item in 0/1 Knapsack.
• Forgetting to check whether the item fits.
• Forgetting either the Include or Exclude choice.
• Confusing 0/1 Knapsack with Unbounded Knapsack.

===========================================================
TIME COMPLEXITY
===========================================================
Best Case:
O(2^n)

Average Case:
O(2^n)

Worst Case:
O(2^n)

Justification:
• For every item that fits, the recursion creates two branches:
  Include and Exclude.
• The recursion tree can contain approximately 2^n states.
• Many of these states are recalculated.
• Therefore, the pure recursive solution has exponential
  time complexity.

With Memoization:
O(n × capacity)

With Tabulation:
O(n × capacity)

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)

Auxiliary Space:
O(n)

• No DP array is used in the recursive solution.
• The maximum recursion depth is proportional to the number
  of items.
• Therefore, recursion stack space is O(n).

Input Space:
O(n)

• val[] and wt[] contain n elements.
• Input storage is not counted as auxiliary space.

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• `i` represents the number of items currently available.
• Therefore, the current item's array index is `i - 1`.
• When an item is included, capacity becomes:
      capacity - wt[i - 1]
• When an item is excluded, capacity remains unchanged.
• In both cases, `i` becomes `i - 1` because the current item
  cannot be considered again.
• `capacity == 0` means no additional item can be included.
• `i == 0` means there are no items left.
• If an item is too heavy, only the Exclude choice is possible.
• The recursion explores all possible valid combinations.
• `Math.max()` ensures that the combination with maximum
  profit is returned.
• The main limitation of this solution is repeated calculation
  of the same subproblems.
• Memoization solves this repeated-work problem by storing
  previously calculated states.
===========================================================
*/

public class DP8 {

  /*
   * Returns the maximum profit that can be obtained using
   * the first `i` items within the given capacity.
   */
  public static int knapsack(int val[], int wt[], int capacity, int i) {

    // Base case: no capacity or no items means no profit.
    if (capacity == 0 || i == 0)return 0;

    // Check whether the current item can fit in the remaining capacity.
    if (wt[i - 1] <= capacity) {

      // Include the current item and reduce the remaining capacity.
      int profit1 = val[i - 1] + knapsack(val, wt, capacity - wt[i - 1], i - 1);

      // Exclude the current item and keep the same capacity.
      int profit2 = knapsack(val, wt, capacity, i - 1);

      // Return the choice that produces maximum profit.
      return Math.max(profit1, profit2);

    } else {

      // Current item is too heavy, so it must be excluded.
      return knapsack(val, wt, capacity, i - 1);
    }
  }

  public static void main(String[] args) {

    // Values/profits of the five items.
    int val[] = {15, 14, 10, 45, 30};

    // Weights of the five items.
    int wt[] = {2, 5, 1, 3, 4};

    // Maximum weight the knapsack can hold.
    int capacity = 7;

    // Start with all available items.
    System.out.println("Maximum Profit = " + knapsack(val, wt, capacity, val.length));
  }
}