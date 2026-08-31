package DP;

/*
===========================================================
TITLE
===========================================================
0/1 Knapsack Problem Using Dynamic Programming (Memoization)

===========================================================
PROBLEM STATEMENT
===========================================================
You are given `n` items.

Each item has:
• A value (profit)
• A weight

You also have a knapsack with a maximum capacity `W`.

Your task is to select items such that:
• Total weight does not exceed W.
• Total value is maximized.
• Each item can be selected at most once.

This is called the 0/1 Knapsack Problem because every item
has exactly two choices:

• 0 → Do not include the item.
• 1 → Include the item.

Input:
• int[] val → values/profits of items.
• int[] wt → weights of items.
• int W → maximum capacity of the knapsack.
• int n → number of items currently being considered.
• int[][] dp → DP table used for memoization.

Output:
• Maximum possible profit without exceeding capacity W.

Constraints:
• 1 ≤ n ≤ 100
• 1 ≤ wt[i] ≤ W
• 1 ≤ val[i] ≤ 10^6
• Each item can be selected at most once.

Edge Cases:
• W = 0 → maximum profit = 0.
• n = 0 → maximum profit = 0.
• Current item weight > remaining capacity → item cannot be included.
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
   • Add its value to the profit.
   • Reduce the remaining capacity.
   • Move to the previous item.

2) EXCLUDE the item:
   • Do not add its value.
   • Keep the same capacity.
   • Move to the previous item.

If the item fits, calculate both choices and take the maximum.

If the item does not fit, the item must be excluded.

The recursive solution has overlapping subproblems.

For example, the same state can be reached multiple times:

    knapsackMemo(n, W)

Instead of calculating the same state repeatedly, store its
answer in:

    dp[n][W]

The next time the same state occurs, directly return dp[n][W].

This technique is called:

    Memoization = Recursion + Storage

===========================================================
APPROACH
===========================================================
1) Create a 2D DP array.

      dp[n + 1][W + 1]

2) Understand what each dimension represents:

      Row    → Number of items being considered.
      Column → Current remaining capacity.

3) Therefore:

      dp[i][j]

   means:

   "Maximum profit possible using the first `i` items
    with a knapsack capacity of `j`."

4) Initialize every DP cell with -1.

      -1 → State has NOT been calculated yet.

5) Base Cases:

      W == 0 → return 0
      n == 0 → return 0

6) Before calculating a state, check:

      if(dp[n][W] != -1)

   If true, the state has already been calculated.

7) If the current item fits:

      wt[n - 1] <= W

   Calculate:

   INCLUDE:
      val[n - 1] + knapsackMemo(..., W - wt[n - 1], n - 1, dp)

   EXCLUDE:
      knapsackMemo(..., W, n - 1, dp)

8) Store the maximum result:

      dp[n][W] = Math.max(profit1, profit2)

9) If the item does not fit, store the result of excluding it.

===========================================================
EXAMPLE
===========================================================
Input:

val = [15, 14, 10, 45, 30]
wt  = [2,  5,  1,  3,  4]
W = 7

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

Output:
75

===========================================================
DRY RUN
===========================================================
Initial State:

n = 5
W = 7

So the first state is:

    dp[5][7]

Meaning:

"Find the maximum profit using the first 5 items
with capacity 7."

Current Item:

Item 4
Weight = 4
Value = 30

Since:

    4 <= 7

Two choices are possible.

-----------------------------------------------------------
CHOICE 1: INCLUDE ITEM 4
-----------------------------------------------------------

Profit from Item 4:

    30

Remaining Capacity:

    7 - 4 = 3

Remaining Items:

    4

New state:

    dp[4][3]

This state calculates the best profit using the first
4 items with capacity 3.

The best choice here is Item 3:

Item 3:
Weight = 3
Value = 45

Therefore:

    45 + 30 = 75

-----------------------------------------------------------
CHOICE 2: EXCLUDE ITEM 4
-----------------------------------------------------------

Do not take Item 4.

Capacity remains:

    7

Move to previous item:

    n = 4

New state:

    dp[4][7]

This branch explores the best solution without Item 4.

One possible solution is:

Item 0 + Item 2 + Item 3

Weight:

    2 + 1 + 3 = 6

Profit:

    15 + 10 + 45 = 70

Therefore, this branch can produce 70.

-----------------------------------------------------------
FINAL COMPARISON
-----------------------------------------------------------

Include Item 4:
Profit = 75

Exclude Item 4:
Best Profit ≤ 70

Therefore:

    dp[5][7] = max(75, 70)

    dp[5][7] = 75

Final Answer:

    75

===========================================================
KEY POINTS
===========================================================
• Memoization avoids recalculating the same states.
• This converts the exponential recursive solution into
  polynomial time.
• Every state is identified using two variables:

      (n, W)

• `n` tells us how many items are available.
• `W` tells us the remaining capacity.

Important Recurrence:

If the item fits:

    dp[n][W] = max(
        val[n - 1] + dp[n - 1][W - wt[n - 1]],
        dp[n - 1][W]
    )

If the item does not fit:

    dp[n][W] = dp[n - 1][W]

Why `n - 1`?

Because arrays are 0-indexed.

If:

    n = 5

The current item is:

    index = n - 1
    index = 4

So:

    val[n - 1]
    wt[n - 1]

refer to Item 4.

===========================================================
TIME COMPLEXITY
===========================================================
Best Case:
O(n × W)

Average Case:
O(n × W)

Worst Case:
O(n × W)

Justification:
• There are (n + 1) × (W + 1) possible DP states.
• Each state is calculated at most once.
• Each state performs constant-time operations.
• Therefore:

      O(n × W)

Without Memoization:

      O(2^n)

With Memoization:

      O(n × W)

===========================================================
SPACE COMPLEXITY
===========================================================
O(n × W)

DP Table:
• The table contains (n + 1) × (W + 1) cells.
• Therefore, DP space is O(n × W).

Recursion Stack:
• Maximum recursion depth is O(n).

Total:
• DP table → O(n × W)
• Recursion stack → O(n)

Overall:

      O(n × W)

because O(n × W) dominates O(n).

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
DP ARRAY EXPLANATION:

The DP array is 2D because the answer depends on TWO
changing variables:

1) Number of items
2) Remaining capacity

Therefore we need:

    dp[n][W]

rather than a 1D array.

-----------------------------------------------------------
WHY dp[n + 1][W + 1]?
-----------------------------------------------------------

Suppose:

    n = 5
    W = 7

We create:

    int dp[][] = new int[6][8];

Why?

Rows represent number of items:

    0, 1, 2, 3, 4, 5

Therefore:
    n + 1 = 6 rows

Columns represent capacity:

    0, 1, 2, 3, 4, 5, 6, 7

Therefore:
    W + 1 = 8 columns

So:

    dp[6][8]

is required.

-----------------------------------------------------------
WHAT DOES dp[i][j] MEAN?
-----------------------------------------------------------

`dp[i][j]` means:

"Maximum profit that can be obtained using the first
`i` items when the available capacity is `j`."

Example:

    dp[3][5]

means:

"Maximum profit using the first 3 items with capacity 5."

Another example:

    dp[5][7]

means:

"Maximum profit using all 5 items with capacity 7."

-----------------------------------------------------------
WHY INITIALIZE WITH -1?
-----------------------------------------------------------

Initially, we do not know the answer for any state.

Therefore:

    -1 = State not calculated yet

Example:

    dp[5][7] = -1

means:

"The answer for 5 items and capacity 7 has not been
calculated yet."

After calculation:

    dp[5][7] = 75

Now if the same state appears again:

    if(dp[5][7] != -1)

we immediately return:

    75

This prevents repeated recursion.

-----------------------------------------------------------
WHY NOT INITIALIZE WITH 0?
-----------------------------------------------------------

We should not generally use 0 to mean "not calculated"
because 0 can be a valid answer in DP problems.

For example:

    dp[0][5] = 0

is a legitimate answer because there are no items.

Using -1 clearly separates:

    -1 → Not calculated
     0 → Calculated answer is zero

-----------------------------------------------------------
HOW DP STATE CHANGES
-----------------------------------------------------------

When INCLUDING an item:

    n → n - 1
    W → W - wt[n - 1]

When EXCLUDING an item:

    n → n - 1
    W → W

Therefore:

    INCLUDE → dp[n - 1][W - wt[n - 1]]

    EXCLUDE → dp[n - 1][W]

This is the most important state transition in 0/1 Knapsack.

-----------------------------------------------------------
WHY IS THIS CALLED MEMOIZATION?
-----------------------------------------------------------

Memoization means:

    Solve → Store → Reuse

The recursive function solves a state the first time.

Then it stores:

    dp[n][W]

If the same state appears again, it reuses the stored value.

Therefore:

    Recursion + Cache = Memoization

-----------------------------------------------------------
IMPORTANT 0/1 KNAPSACK RULE
-----------------------------------------------------------

When an item is included, move to:

    n - 1

Do NOT keep `n` unchanged.

Why?

Because each item can be used only once.

Using:

    n - 1

removes the current item from future consideration.

If we kept `n` unchanged, the same item could potentially
be selected repeatedly, which would represent a different
problem called Unbounded Knapsack.

-----------------------------------------------------------
ALTERNATIVE APPROACHES
-----------------------------------------------------------
• Pure Recursion → O(2^n)
• Memoization → O(n × W)
• Tabulation → O(n × W)
• Space Optimized Tabulation → O(W)

===========================================================
*/

public class DP9 {

  /*
   * Returns the maximum profit using the first `n` items
   * with the given remaining capacity W.
   */
  public static int knapsackMemo(int val[], int wt[], int W, int n, int dp[][]) {

    // Base case: no capacity or no items means no profit.
    if (W == 0 || n == 0)return 0;

    // If this state has already been calculated, return the stored result.
    if(dp[n][W] != -1)return dp[n][W];

    // Check whether the current item can fit in the remaining capacity.
    if(wt[n - 1] <= W){

      // Include the current item and reduce the remaining capacity.
      int profit1 = val[n - 1] + knapsackMemo(val, wt, W - wt[n - 1], n - 1, dp);

      // Exclude the current item and keep the same capacity.
      int profit2 = knapsackMemo(val, wt, W, n - 1, dp);

      // Store and return the maximum profit of both choices.
      dp[n][W] = Math.max(profit1, profit2);

      return dp[n][W];

    }else{

      // Current item cannot fit, so exclude it.
      dp[n][W] = knapsackMemo(val, wt, W, n - 1, dp);

      return dp[n][W];
    }
  }

  public static void main(String[] args) {

    // Values/profits of the five items.
    int val[] = {15, 14, 10, 45, 30};

    // Weights of the five items.
    int wt[] = {2, 5, 1, 3, 4};

    // Maximum weight the knapsack can hold.
    int W = 7;

    // DP table:
    // Rows represent number of items.
    // Columns represent remaining capacity.
    int dp[][] = new int[val.length + 1][W + 1];

    // Initialize every state as -1, meaning "not calculated yet".
    for(int i = 0; i < dp.length; i++){

      for(int j = 0; j < dp[0].length; j++){

        dp[i][j] = -1;
      }
    }

    // Start with all available items and the complete capacity.
    System.out.println("Maximum Profit = " + knapsackMemo(val, wt, W, val.length, dp));
  }
}