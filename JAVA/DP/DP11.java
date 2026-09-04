package DP;

import java.util.Arrays;

/*
===========================================================
TITLE
===========================================================
0/1 Knapsack Problem Using Space-Optimized Tabulation

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
The normal Tabulation approach uses a 2D DP table:

    dp[i][j]

where:

    i = number of items being considered
    j = current knapsack capacity

The state represents:

"Maximum profit that can be obtained using the first `i`
items with a knapsack capacity of `j`."

For every item, we have two choices:

1) INCLUDE the item
2) EXCLUDE the item

If the item fits:

    include = value + dp[i - 1][j - weight]
    exclude = dp[i - 1][j]

Therefore:

    dp[i][j] = Math.max(include, exclude)

Important observation:

To calculate the current row `i`, we only need values
from the previous row `i - 1`.

We do NOT need all the older rows.

Therefore, instead of storing:

    dp[n + 1][W + 1]

we can store only:

    prev[W + 1]
    curr[W + 1]

This reduces space complexity from:

    O(n × W)

to:

    O(W)

The DP logic remains the same.

Only the way the DP states are stored is optimized.

===========================================================
APPROACH
===========================================================
1) Find the number of items:

    n = val.length

2) Create two 1D arrays:

    int curr[] = new int[W + 1];
    int prev[] = new int[W + 1];

3) `prev[]` represents the previous row of the original
   2D DP table.

4) `curr[]` represents the current row of the original
   2D DP table.

5) Initialize `prev[]` with 0.

Why?

The first row of the original DP table represents:

    0 items

With no items, maximum profit is always 0.

6) Process every item:

    for(int i = 1; i < n + 1; i++)

7) Reset the current row:

    Arrays.fill(curr, 0);

8) Process every capacity:

    for(int j = 1; j < W + 1; j++)

9) Get the current item's value and weight:

    v = val[i - 1]
    w = wt[i - 1]

10) Check whether the current item fits:

    w <= j

11) If the item fits, calculate two choices.

INCLUDE:

    v + prev[j - w]

EXCLUDE:

    prev[j]

12) Store the maximum:

    curr[j] = Math.max(profit1, profit2);

13) If the item does not fit:

    curr[j] = prev[j];

14) After the COMPLETE current row has been calculated:

    prev = curr.clone();

This makes the current row the previous row for the
next item.

15) After all items have been processed:

    return prev[W];

`prev[W]` represents the final answer.

===========================================================
WHAT CHANGED FROM DP10 TABULATION?
===========================================================
DP10 uses a complete 2D DP table:

    dp[i][j]

For example:

    dp[0][...]
    dp[1][...]
    dp[2][...]
    dp[3][...]
    dp[4][...]
    dp[5][...]

All rows are stored in memory.

The important observation is:

    dp[i][j]

only depends on:

    dp[i - 1][...]

Therefore, once we move from one item to the next, older
rows are no longer required.

So DP11 replaces:

    dp[n + 1][W + 1]

with:

    prev[W + 1]
    curr[W + 1]

The relationship becomes:

    DP10:

        dp[i][j]

    DP11:

        curr[j] ← prev[j - w]

The recurrence does NOT change.

Only the storage is optimized.

===========================================================
DP10 vs DP11
===========================================================
DP10:

    int dp[][] = new int[n + 1][W + 1];

    dp[i][j]

Stores every row.

Space:

    O(n × W)

DP11:

    int curr[] = new int[W + 1];
    int prev[] = new int[W + 1];

Stores only two rows.

Space:

    O(W)

Time remains:

    O(n × W)

Therefore, DP11 is a SPACE OPTIMIZATION of DP10.

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

    Maximum Profit = 75

===========================================================
DRY RUN
===========================================================
Initially:

    prev = [0, 0, 0, 0, 0, 0, 0, 0]

===========================================================
ITEM 0
===========================================================

Item 0:

    value = 15
    weight = 2

After processing all capacities:

    curr = [0, 0, 15, 15, 15, 15, 15, 15]

Now:

    prev = curr.clone();

Therefore:

    prev = [0, 0, 15, 15, 15, 15, 15, 15]

===========================================================
ITEM 1
===========================================================

Item 1:

    value = 14
    weight = 5

At capacity 7:

    INCLUDE:

        14 + prev[7 - 5]
        14 + prev[2]
        = 14 + 15
        = 29

    EXCLUDE:

        prev[7]
        = 15

Therefore:

    curr[7] = Math.max(29, 15)
            = 29

After the complete row:

    prev = curr.clone();

===========================================================
ITEM 2
===========================================================

Item 2:

    value = 10
    weight = 1

For every capacity, the algorithm compares:

    INCLUDE:
        10 + prev[j - 1]

    EXCLUDE:
        prev[j]

The better result is stored in:

    curr[j]

After the complete row:

    prev = curr.clone();

===========================================================
ITEM 3
===========================================================

Item 3:

    value = 45
    weight = 3

At capacity 7:

    INCLUDE:

        45 + prev[7 - 3]
        45 + prev[4]

    EXCLUDE:

        prev[7]

The algorithm stores whichever profit is larger.

After completing the row:

    prev = curr.clone();

===========================================================
ITEM 4
===========================================================

Item 4:

    value = 30
    weight = 4

At capacity 7:

    INCLUDE:

        30 + prev[7 - 4]
        30 + prev[3]

The best previous solution for capacity 3 contains
Item 3 with profit 45.

Therefore:

    profit1 = 30 + 45
            = 75

The exclude option is smaller.

Therefore:

    curr[7] = 75

After the complete row:

    prev = curr.clone();

Finally:

    prev[7] = 75

Therefore:

    return prev[W]

    return prev[7]

    = 75

===========================================================
KEY POINTS
===========================================================
• DP11 is a space-optimized version of DP10.
• DP10 uses a 2D array.
• DP11 uses two 1D arrays.
• The recurrence remains the same.
• Only the DP storage is optimized.
• `prev[]` represents the previous row.
• `curr[]` represents the current row.
• `prev = curr.clone()` moves the completed current row
  into the previous-row state.
• `return prev[W]` is equivalent to `return dp[n][W]`
  from the 2D solution.
• Time complexity remains O(n × W).
• Space complexity improves from O(n × W) to O(W).

===========================================================
SPECIAL NOTES ABOUT DP ARRAY
===========================================================

WHY DOES DP10 USE A 2D ARRAY?

The original state has two changing variables:

    i = number of items
    j = capacity

Therefore:

    dp[i][j]

is required to represent every state.

However, when we inspect the recurrence:

    dp[i][j] = Math.max(
        v + dp[i - 1][j - w],
        dp[i - 1][j]
    )

we notice that the current row only uses:

    i - 1

Therefore, older rows are unnecessary.

Instead of storing:

    dp[0]
    dp[1]
    dp[2]
    ...
    dp[n]

we only keep:

    prev
    curr

This is the main space optimization.

===========================================================
SPECIAL NOTES ABOUT prev[] AND curr[]
===========================================================

`prev[]`:

    Represents the previous row.

It contains the answers calculated using the previous
set of items.

`curr[]`:

    Represents the current row.

It contains the answers after considering the current item.

The flow is:

    prev
      ↓
    calculate
      ↓
    curr
      ↓
    clone
      ↓
    prev
      ↓
    next item

Therefore:

    prev → previous item
    curr → current item

===========================================================
SPECIAL NOTES ABOUT prev = curr.clone()
===========================================================

This statement:

    prev = curr.clone();

means:

    "The current row is completely calculated.
     Make it the previous row for the next item."

It MUST be placed after the inner `j` loop.

Correct:

    for(each item) {

      for(each capacity) {
        calculate curr[j];
      }

      prev = curr.clone();
    }

Incorrect:

    for(each item) {

      for(each capacity) {
        calculate curr[j];

        prev = curr.clone();
      }
    }

Why?

One complete `curr[]` array represents one complete DP row.

Therefore, the complete row must be calculated first.

Only then should it become `prev[]`.

Also, `clone()` is important.

If we wrote:

    prev = curr;

then both variables would refer to the SAME array.

Future changes to `curr` would also change `prev`.

Using:

    curr.clone();

creates a separate copy.

Therefore:

    prev = curr.clone();

preserves the previous row independently.

===========================================================
SPECIAL NOTES ABOUT Arrays.fill(curr, 0)
===========================================================

`curr[]` is reused for every item.

Therefore:

    Arrays.fill(curr, 0);

resets it before calculating the next row.

This makes:

    curr[]

represent only the current item's DP row.

`prev[]` is not reset because it contains the previous
completed row that is required for the calculation.

===========================================================
HOW TO SEE THAT DP CAN BE OPTIMIZED
===========================================================

Whenever you have a 2D DP:

    dp[i][j]

do not immediately try to convert it into 1D.

First inspect the recurrence.

Ask:

    "Which previous rows are required to calculate
     the current row?"

For example:

    dp[i][j] depends on dp[i - 1][...]

Only the previous row is required.

Therefore:

    2D DP
       ↓
    Previous Row + Current Row
       ↓
    1D row arrays

This gives:

    O(n × W) → O(W)

space optimization.

This is a general Dynamic Programming optimization pattern.

===========================================================
SPECIAL NOTES ABOUT return STATEMENT
===========================================================

In DP10, the final statement is:

    return dp[n][W];

Why?

Because:

    n = all items
    W = full capacity

Therefore:

    dp[n][W]

represents the original problem.

In DP11, the complete 2D table no longer exists.

Instead, after processing all items:

    prev[]

contains the final row.

Therefore:

    dp[n][W]

is represented by:

    prev[W]

So we write:

    return prev[W];

For this example:

    n = 5
    W = 7

DP10:

    return dp[5][7];

DP11:

    return prev[7];

Both return:

    75

The state has not changed.

Only its storage location has changed.

===========================================================
WHY NOT return curr[W]?
===========================================================

At the end of every item:

    prev = curr.clone();

Therefore, after the final iteration:

    prev

contains the final completed row.

`curr` still contains the same values at that moment,
so `curr[W]` would also contain the answer in this
implementation.

However:

    prev[W]

is conceptually clearer because `prev` is explicitly
the final completed row after the last clone operation.

It also directly represents:

    dp[n][W]

from the original 2D solution.

Therefore:

    return prev[W];

is preferred.

===========================================================
TIME COMPLEXITY
===========================================================

Outer loop:

    O(n)

Inner loop:

    O(W)

`curr.clone()`:

    O(W)

It is performed once for every item:

    O(n × W)

Therefore total time complexity:

    O(n × W)

Best Case:

    O(n × W)

Average Case:

    O(n × W)

Worst Case:

    O(n × W)

Space optimization does NOT reduce the time complexity.

It reduces only the amount of memory required.

===========================================================
SPACE COMPLEXITY
===========================================================

DP10 uses:

    dp[n + 1][W + 1]

Therefore:

    O(n × W)

DP11 uses:

    prev[W + 1]
    curr[W + 1]

Therefore:

    O(W) + O(W)

    O(2W)

Ignoring constants:

    O(W)

Auxiliary Space:

    O(W)

Recursion Stack:

    O(1)

because this is an iterative Tabulation solution.

===========================================================
SPECIAL NOTES
===========================================================

1) DP11 does NOT change the recurrence.

The recurrence is still:

    INCLUDE:
        v + previous state

    EXCLUDE:
        previous state

2) The optimization is possible because the current
   row depends only on the previous row.

3) `prev[]` and `curr[]` are easier to understand than
   a single-array optimization because they directly
   correspond to the two rows of DP10.

4) A further optimization can reduce the solution from
   TWO arrays to ONE array.

That version requires careful traversal of capacities
from RIGHT TO LEFT for 0/1 Knapsack.

5) Two-array approach:

    curr[j] = v + prev[j - w]

The current row reads only from the previous row.

Therefore, left-to-right traversal is safe.

6) Single-array approach:

    dp[j] = v + dp[j - w]

Here the same array is both the current and previous state.

Therefore, right-to-left traversal is required to prevent
using the same item more than once.

7) This is an important DP optimization pattern:

    First:
        Build correct 2D DP.

    Then:
        Inspect dependencies.

    Then:
        Remove unnecessary rows.

    Finally:
        Optimize space if possible.

8) Always understand the 2D DP solution first before
   applying space optimization.

9) The final answer always comes from the state representing
   the original problem.

For DP10:

    dp[n][W]

For DP11:

    prev[W]

10) Integer overflow:

If values can become larger than the range of `int`,
use `long[]` and `long` variables.

===========================================================
*/

public class DP11 {

  public static int knapsackOpt(int val[], int wt[], int W) {

    // Number of available items.
    int n = val.length;

    // Current row of the optimized DP table.
    int curr[] = new int[W + 1];

    // Previous row of the optimized DP table.
    int prev[] = new int[W + 1];

    // With zero items, maximum profit for every capacity is 0.
    Arrays.fill(prev, 0);

    // Build the optimized DP table from smaller problems to larger problems.
    for (int i = 1; i < n + 1; i++) {

      // Reset the current row before calculating the next item's states.
      Arrays.fill(curr, 0);

      // Process every possible capacity.
      for (int j = 1; j < W + 1; j++) {

        // Get the current item's value.
        int v = val[i - 1];

        // Get the current item's weight.
        int w = wt[i - 1];

        // Check whether the current item can fit in capacity j.
        if (w <= j) {

          // Include current item and use previous-row result
          // for the remaining capacity j - w.
          int profit1 = v + prev[j - w];

          // Exclude current item and use previous-row result
          // for the same capacity j.
          int profit2 = prev[j];

          // Store the better choice in the current row.
          curr[j] = Math.max(profit1, profit2);

        } else {

          // If the item cannot fit, use the previous-row result.
          curr[j] = prev[j];
        }
      }

      // The complete current row is now calculated.
      // Copy it into prev for processing the next item.
      prev = curr.clone();
    }

    // After all items are processed, prev represents the final DP row.
    // prev[W] is equivalent to dp[n][W] in the original 2D solution.
    return prev[W];
  }

  public static void main(String[] args) {

    // Values/profits of the five items.
    int val[] = {15, 14, 10, 45, 30};

    // Weights of the five items.
    int wt[] = {2, 5, 1, 3, 4};

    // Maximum weight the knapsack can hold.
    int W = 7;

    // Calculate and print the maximum possible profit.
    System.out.println("Maximum Profit = " + knapsackOpt(val, wt, W));
  }
}