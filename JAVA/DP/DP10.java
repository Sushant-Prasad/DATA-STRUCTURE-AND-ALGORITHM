package DP;

/*
===========================================================
TITLE
===========================================================
0/1 Knapsack Problem Using Dynamic Programming (Tabulation)

===========================================================
PROBLEM STATEMENT
===========================================================
You are given `n` items.

Each item has:
• A value (profit)
• A weight

You also have a knapsack with maximum capacity `W`.

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

Output:
• Maximum possible profit without exceeding capacity W.

Constraints:
• 1 ≤ n ≤ 100
• 1 ≤ wt[i] ≤ W
• 1 ≤ val[i] ≤ 10^6
• Each item can be selected at most once.

Edge Cases:
• W = 0 → maximum profit = 0.
• No items → maximum profit = 0.
• Current item is too heavy → it must be excluded.
• All items are too heavy → maximum profit = 0.

===========================================================
PROBLEM RESOURCE
===========================================================
• https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

===========================================================
INTUITION
===========================================================
The recursive solution has two choices for every item:

1) INCLUDE the item
2) EXCLUDE the item

Instead of using recursion, Tabulation solves the smaller
subproblems first and stores their answers in a 2D DP table.

The DP table stores:

    dp[i][j]

Meaning:

"Maximum profit that can be obtained using the first `i`
items with a knapsack capacity of `j`."

The table is filled from smaller states to larger states.

===========================================================
APPROACH
===========================================================
1) Find the number of items:

      n = val.length

2) Create a 2D DP table:

      dp[n + 1][W + 1]

3) Rows represent the number of items being considered.

      i = 0 → no items
      i = 1 → first item
      i = 2 → first two items
      ...
      i = n → all items

4) Columns represent the knapsack capacity.

      j = 0 → capacity 0
      j = 1 → capacity 1
      ...
      j = W → full capacity

5) Initialize the first row and first column with 0.

   Why?

   • With 0 items → profit is 0.
   • With capacity 0 → profit is 0.

6) For every item and capacity, determine whether the current
   item can fit.

      w <= j

7) If the item fits, calculate two choices:

   INCLUDE:
      v + dp[i - 1][j - w]

   EXCLUDE:
      dp[i - 1][j]

8) Store the maximum:

      dp[i][j] = Math.max(profit1, profit2)

9) If the item does not fit:

      dp[i][j] = dp[i - 1][j]

10) After filling the complete table, the answer is:

      dp[n][W]

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
DP TABLE
===========================================================
The table has:

    n + 1 = 6 rows
    W + 1 = 8 columns

Therefore:

    dp[6][8]

Rows represent items:

    Row 0 → 0 items
    Row 1 → Item 0
    Row 2 → Items 0,1
    Row 3 → Items 0,1,2
    Row 4 → Items 0,1,2,3
    Row 5 → All 5 items

Columns represent capacity:

    0  1  2  3  4  5  6  7

The final cell:

    dp[5][7]

means:

"Maximum profit using all 5 items with capacity 7."

Therefore:

    dp[5][7] = 75

===========================================================
DRY RUN
===========================================================
Consider:

    i = 5
    j = 7

Current item:

    Item 4

Because:

    i - 1 = 4

we access:

    val[4] = 30
    wt[4] = 4

So:

    v = 30
    w = 4

Check:

    w <= j

    4 <= 7

The item fits.

-----------------------------------------------------------
INCLUDE ITEM 4
-----------------------------------------------------------

If Item 4 is included:

Profit from current item:

    v = 30

Remaining capacity:

    j - w
    7 - 4
    = 3

We need the best profit using previous items
with capacity 3:

    dp[i - 1][j - w]

    dp[4][3]

Suppose this gives:

    dp[4][3] = 45

Therefore:

    profit1 = 30 + 45
            = 75

-----------------------------------------------------------
EXCLUDE ITEM 4
-----------------------------------------------------------

If Item 4 is excluded:

Capacity remains:

    j = 7

We move to previous items:

    dp[i - 1][j]

    dp[4][7]

This represents the best profit without Item 4.

This branch gives a smaller result.

-----------------------------------------------------------
FINAL DECISION
-----------------------------------------------------------

The algorithm compares:

    profit1 = 75
    profit2 = dp[4][7]

and stores the larger value:

    dp[5][7] = Math.max(profit1, profit2)

The final answer is:

    dp[5][7] = 75

===========================================================
KEY POINTS
===========================================================
• Tabulation is a Bottom-Up Dynamic Programming technique.
• It does not use recursion.
• Smaller subproblems are solved first.
• Every DP state is stored in the table.
• Each state depends on the previous row.
• Every item has two choices: Include or Exclude.
• An item can be selected only once.

Important Recurrence:

If the item fits:

    dp[i][j] = Math.max(
        v + dp[i - 1][j - w],
        dp[i - 1][j]
    )

If the item does not fit:

    dp[i][j] = dp[i - 1][j]

===========================================================
SPECIAL NOTES ABOUT DP ARRAY
===========================================================

WHY IS dp[][] 2D?

The answer depends on TWO changing variables:

1) Number of items
2) Capacity

Therefore we need:

    dp[i][j]

where:

    i = number of items
    j = current capacity

A single-dimensional array would not directly represent
both states.

-----------------------------------------------------------
WHY dp[n + 1][W + 1]?
-----------------------------------------------------------

Suppose:

    n = 5
    W = 7

We need rows for:

    0, 1, 2, 3, 4, 5

Total:

    6 rows = n + 1

We need columns for:

    0, 1, 2, 3, 4, 5, 6, 7

Total:

    8 columns = W + 1

Therefore:

    new int[n + 1][W + 1]

becomes:

    new int[6][8]

-----------------------------------------------------------
WHY IS ROW 0 ZERO?
-----------------------------------------------------------

Row 0 means:

    No items are available.

Therefore maximum profit is always 0.

So:

    dp[0][j] = 0

for every capacity j.

-----------------------------------------------------------
WHY IS COLUMN 0 ZERO?
-----------------------------------------------------------

Column 0 means:

    Knapsack capacity = 0

No item can be placed inside a knapsack with zero capacity.

Therefore:

    dp[i][0] = 0

for every number of items i.

===========================================================
SPECIAL NOTES ABOUT i AND i - 1
===========================================================

This is one of the most important parts of the code.

-----------------------------------------------------------
WHAT DOES `i` REPRESENT?
-----------------------------------------------------------

`i` represents the NUMBER OF ITEMS being considered.

For example:

    i = 5

means:

"Consider the first 5 items."

Those items have array indexes:

    0, 1, 2, 3, 4

Therefore, the current item is:

    i - 1 = 4

-----------------------------------------------------------
WHY val[i - 1]?
-----------------------------------------------------------

The DP row is 1-based in terms of item count, but the
Java array is 0-based.

For example:

    i = 1

means we are considering the first item.

The first item is stored at:

    val[0]

Therefore:

    val[i - 1]

For i = 1:

    val[1 - 1]
    val[0]

For i = 5:

    val[5 - 1]
    val[4]

So:

    v = val[i - 1]

gets the current item's value.

Similarly:

    w = wt[i - 1]

gets the current item's weight.

-----------------------------------------------------------
WHY dp[i - 1]?
-----------------------------------------------------------

When considering the current item, the previous row represents
solutions that do NOT use the current item.

Therefore:

    dp[i - 1]

means:

"Use only the previous `i - 1` items."

For example:

    dp[5][7]

is calculating the answer using Item 4.

The previous row:

    dp[4][...]

contains answers using only Items 0, 1, 2 and 3.

This is exactly what we need after making a decision about
Item 4.

-----------------------------------------------------------
WHY dp[i - 1][j - w]?
-----------------------------------------------------------

This is the INCLUDE case.

Suppose:

    i = 5
    j = 7
    w = 4

If we include Item 4:

    Current Profit = 30

Remaining capacity:

    j - w
    7 - 4
    = 3

We cannot use Item 4 again because this is 0/1 Knapsack.

Therefore, we move to the previous row:

    i - 1 = 4

So:

    dp[i - 1][j - w]

becomes:

    dp[4][3]

Meaning:

"Best profit using previous 4 items with remaining
capacity 3."

-----------------------------------------------------------
WHY dp[i - 1][j]?
-----------------------------------------------------------

This is the EXCLUDE case.

If we do not select the current item:

    Capacity remains j.

But the current item is no longer considered.

Therefore:

    dp[i - 1][j]

Example:

    dp[4][7]

means:

"Best profit using the previous 4 items with capacity 7."

===========================================================
WHY RETURN dp[n][W]?
===========================================================
This is the most important final DP concept.

The entire DP table contains answers to different subproblems.

The final problem asks:

"Using ALL `n` items, what is the maximum profit with
the FULL capacity `W`?"

The corresponding DP state is:

    dp[n][W]

Therefore we return:

    return dp[n][W];

For this example:

    n = 5
    W = 7

So:

    return dp[5][7];

And:

    dp[5][7] = 75

Therefore the answer is:

    75

-----------------------------------------------------------
WHY NOT return dp[0][0]?
-----------------------------------------------------------

`dp[0][0]` means:

"No items and zero capacity."

Its answer is obviously:

    0

That is only a base case, not the answer to our original
problem.

-----------------------------------------------------------
WHY NOT return dp[n][0]?
-----------------------------------------------------------

`dp[n][0]` means:

"Use all items but capacity is zero."

No item can be selected.

Therefore:

    dp[n][0] = 0

Again, this is not our original problem.

-----------------------------------------------------------
WHY dp[n][W] IS THE FINAL ANSWER
-----------------------------------------------------------

Original problem:

    Items available = n
    Capacity = W

DP representation:

    dp[number of items][capacity]

Therefore:

    dp[n][W]

is exactly the original problem.

This is a general DP principle:

    Final DP State = State representing the original problem

===========================================================
TIME COMPLEXITY
===========================================================
O(n × W)

Reason:

The DP table contains:

    (n + 1) × (W + 1)

states.

For every state, we perform constant-time operations:

• Access array values.
• Calculate include profit.
• Calculate exclude profit.
• Use Math.max().

Therefore:

    O(n × W)

Unlike recursion, there is no repeated calculation.

===========================================================
SPACE COMPLEXITY
===========================================================
O(n × W)

The 2D DP table contains:

    (n + 1) × (W + 1)

elements.

Therefore auxiliary space is:

    O(n × W)

This can later be optimized to:

    O(W)

using a 1D DP array.

===========================================================
TABULATION VS MEMOIZATION
===========================================================
Memoization:
• Top-Down approach.
• Uses recursion.
• Starts from the original problem.
• Stores calculated states.
• Uses recursion stack.

Tabulation:
• Bottom-Up approach.
• Does not use recursion.
• Starts from base cases.
• Builds the complete table.
• No recursion stack is required.

Both have:

    Time → O(n × W)

Standard Memoization Space:

    O(n × W) + O(n) recursion stack

Tabulation Space:

    O(n × W)

===========================================================
IMPORTANT OBSERVATIONS
===========================================================
• `i` is the number of items being considered.
• `i - 1` is the current item's array index.
• `j` is the current capacity.
• `j - w` is the remaining capacity after including
  the current item.
• `dp[i - 1][j - w]` represents the INCLUDE choice.
• `dp[i - 1][j]` represents the EXCLUDE choice.
• `dp[n][W]` represents the answer to the original problem.
• `n + 1` rows are required because row 0 represents zero items.
• `W + 1` columns are required because column 0 represents
  zero capacity.
• The first row and first column are base cases.
• Since this is 0/1 Knapsack, the INCLUDE choice always
  moves to the previous row.
===========================================================
*/

public class DP10 {

  /*
   * Returns the maximum profit that can be obtained using
   * 0/1 Knapsack with the given values, weights and capacity.
   */
  public static int knapsackTab(int val[], int wt[], int W) {

    // Number of available items.
    int n = val.length;

    // Create DP table where rows represent items and columns represent capacity.
    int dp[][] = new int[n + 1][W + 1];

    // Initialize column 0: capacity 0 means maximum profit is always 0.
    for(int i = 0; i < dp.length; i++){
      dp[i][0] = 0;
    }

    // Initialize row 0: zero items means maximum profit is always 0.
    for(int j = 0; j < dp[0].length; j++){
      dp[0][j] = 0;
    }

    // Build the DP table from smaller problems to larger problems.
    for(int i = 1; i < n + 1; i++){

      // Process every possible capacity from 1 to W.
      for(int j = 1; j < W + 1; j++){

        // Current item's array index is i - 1 because arrays are 0-indexed.
        int v = val[i - 1];

        // Current item's weight is also located at index i - 1.
        int w = wt[i - 1];

        // Check whether the current item can fit in the current capacity.
        if(w <= j){

          // Include current item: add its value and use remaining capacity j - w.
          int profit1 = v + dp[i - 1][j - w];

          // Exclude current item: keep the same capacity and use previous items.
          int profit2 = dp[i - 1][j];

          // Store the better choice in the current DP state.
          dp[i][j] = Math.max(profit1, profit2);

        }else{

          // Current item cannot fit, so copy the answer from the previous row.
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    // dp[n][W] represents the original problem: all n items and full capacity W.
    return dp[n][W];
  }

  public static void main(String[] args) {

    // Values/profits of the five items.
    int val[] = {15, 14, 10, 45, 30};

    // Weights of the five items.
    int wt[] = {2, 5, 1, 3, 4};

    // Maximum weight the knapsack can hold.
    int W = 7;

    // Calculate and print the maximum possible profit.
    System.out.println("Maximum Profit = " + knapsackTab(val, wt, W));
  }
}