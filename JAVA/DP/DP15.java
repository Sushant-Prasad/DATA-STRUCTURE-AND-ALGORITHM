package DP;

import java.util.Arrays;

/*
===========================================================
TITLE
===========================================================
Unbounded Knapsack Problem Using Space-Optimized Tabulation

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
• Each item can be selected MULTIPLE TIMES.

This is called the Unbounded Knapsack Problem because
there is no restriction on how many times an item can be
selected.

Unlike 0/1 Knapsack:

    0/1 Knapsack:
        Each item can be selected at most once.

    Unbounded Knapsack:
        Each item can be selected any number of times.

-----------------------------------------------------------
INPUT
-----------------------------------------------------------

int[] val
    Array containing the values/profits of the items.

int[] wt
    Array containing the weights of the items.

int W
    Maximum capacity of the knapsack.

-----------------------------------------------------------
OUTPUT
-----------------------------------------------------------

Return the maximum possible profit without exceeding
capacity W.

-----------------------------------------------------------
CONSTRAINTS
-----------------------------------------------------------

• Number of values and weights should be the same.
• Item weights should be positive.
• W represents the maximum knapsack capacity.
• Every item can be selected multiple times.

-----------------------------------------------------------
EDGE CASES
-----------------------------------------------------------

• W = 0 → maximum profit = 0.
• No items → maximum profit = 0.
• Item weight > W → item cannot be selected for that capacity.
• Item weight = 0 should generally be avoided because an
  item with positive value could be selected infinitely many
  times.

===========================================================
PROBLEM RESOURCE
===========================================================

• GeeksforGeeks:
  https://www.geeksforgeeks.org/problems/unbounded-knapsack/1

===========================================================
INTUITION
===========================================================

The Unbounded Knapsack problem is based on two choices:

1) INCLUDE the current item.
2) EXCLUDE the current item.

The important difference is that an item can be selected
multiple times.

Therefore, after including the current item, we do NOT
remove the current item from consideration.

This is why the INCLUDE case uses:

    v + curr[j - w]

instead of:

    v + prev[j - w]

The current row is used again so that the same item can
be selected multiple times.

-----------------------------------------------------------
INCLUDE
-----------------------------------------------------------

If:

    w <= j

the current item can fit inside the current capacity.

The profit from including it is:

    v + curr[j - w]

Here:

    v       = value of current item
    j - w   = remaining capacity
    curr[]  = current row

Using curr[] is what allows the current item to be reused.

-----------------------------------------------------------
EXCLUDE
-----------------------------------------------------------

If we do not select the current item, we move to the
previous row:

    prev[j]

This means the current item is completely excluded.

-----------------------------------------------------------
FINAL RECURRENCE
-----------------------------------------------------------

If:

    w <= j

then:

    curr[j] = Math.max(
        v + curr[j - w],
        prev[j]
    );

Otherwise:

    curr[j] = prev[j];

===========================================================
APPROACH
===========================================================

1) Find the number of available items:

       int n = val.length;

2) Create two 1D DP arrays:

       prev[W + 1]
       curr[W + 1]

3) `prev[]` represents the previous row of the original
   2D DP table.

4) `curr[]` represents the current row.

5) Initialize `prev[]` with 0.

   This represents the row where zero items are available.

6) Process every item using:

       for(int i = 1; i < n + 1; i++)

7) Reset `curr[]` before calculating the new row.

8) Process every capacity using:

       for(int j = 1; j < W + 1; j++)

9) Get the current item's value and weight:

       int v = val[i - 1];
       int w = wt[i - 1];

10) If the item fits:

       w <= j

    calculate:

       Include:
           v + curr[j - w]

       Exclude:
           prev[j]

11) Store the maximum of the two choices.

12) After the entire current row is calculated:

       prev = curr.clone();

13) After all items are processed:

       return prev[W];

===========================================================
EXAMPLE
===========================================================

Input:

    val = {15, 14, 10, 45, 30}
    wt  = {2, 5, 1, 3, 4}
    W = 7

Items:

    Item 0 → Weight = 2, Value = 15
    Item 1 → Weight = 5, Value = 14
    Item 2 → Weight = 1, Value = 10
    Item 3 → Weight = 3, Value = 45
    Item 4 → Weight = 4, Value = 30

Because this is Unbounded Knapsack, an item can be
selected multiple times.

An optimal selection is:

    Item 3 + Item 3 + Item 2

Total weight:

    3 + 3 + 1 = 7

Total value:

    45 + 45 + 10 = 100

Therefore:

    Maximum Profit = 100

===========================================================
DP TABLE
===========================================================

The original 2D DP solution would contain:

    n + 1 rows
    W + 1 columns

For:

    n = 5
    W = 7

the conceptual table contains:

    6 rows
    8 columns

Rows represent the number of items being considered:

    Row 0 → 0 items
    Row 1 → Item 0
    Row 2 → Items 0, 1
    Row 3 → Items 0, 1, 2
    Row 4 → Items 0, 1, 2, 3
    Row 5 → All 5 items

Columns represent capacity:

    0  1  2  3  4  5  6  7

However, DP15 does NOT store this entire table.

Instead, it stores only:

    prev[] → previous row
    curr[] → current row

Therefore:

    Space = O(W)

instead of:

    Space = O(n × W)

===========================================================
DRY RUN
===========================================================

Consider the item:

    value = 45
    weight = 3

-----------------------------------------------------------
CAPACITY = 3
-----------------------------------------------------------

The item fits because:

    3 <= 3

Include the item:

    45 + curr[3 - 3]

    = 45 + curr[0]

    = 45

Therefore:

    curr[3] = 45

-----------------------------------------------------------
CAPACITY = 6
-----------------------------------------------------------

The same item can be selected again.

Include:

    45 + curr[6 - 3]

    = 45 + curr[3]

Since:

    curr[3] = 45

we get:

    45 + 45 = 90

Therefore:

    curr[6] = 90

This demonstrates why we use:

    curr[j - w]

instead of:

    prev[j - w]

The current row already contains the result of selecting
the same item once, so it can use that result again.

-----------------------------------------------------------
CAPACITY = 7
-----------------------------------------------------------

For capacity 7:

    Include Item 3:

    45 + curr[7 - 3]

    = 45 + curr[4]

At capacity 4, the value-10, weight-1 item can contribute
additional profit.

Therefore:

    curr[7] = 100

One optimal combination is:

    Item 3 + Item 3 + Item 2

Weight:

    3 + 3 + 1 = 7

Value:

    45 + 45 + 10 = 100

===========================================================
KEY POINTS
===========================================================

• This is Unbounded Knapsack.
• Items can be selected multiple times.
• The solution uses Bottom-Up Tabulation.
• Only two DP rows are stored.
• `prev[]` represents the previous row.
• `curr[]` represents the current row.
• `i` represents the number of items being considered.
• `j` represents the current capacity.
• `i - 1` is used to access the current item in the
  0-indexed Java array.

Most Important Recurrence:

    Include:

        v + curr[j - w]

    Exclude:

        prev[j]

Therefore:

    curr[j] = Math.max(
        v + curr[j - w],
        prev[j]
    );

===========================================================
SPECIAL NOTES ABOUT DP ARRAY
===========================================================

In the original 2D solution:

    dp[i][j]

means:

    "Maximum profit using the first i items with
     capacity j."

DP15 removes the first dimension from storage.

Instead:

    prev[j]

represents:

    dp[i - 1][j]

and:

    curr[j]

represents:

    dp[i][j]

Therefore, the 2D recurrence:

    dp[i][j] = Math.max(
        v + dp[i][j - w],
        dp[i - 1][j]
    );

becomes:

    curr[j] = Math.max(
        v + curr[j - w],
        prev[j]
    );

This is the key space optimization.

===========================================================
SPECIAL NOTES ABOUT i AND i - 1
===========================================================

The outer loop is:

    for(int i = 1; i < n + 1; i++)

Here `i` represents the number of items being considered.

Therefore:

    i = 1 → first item
    i = 2 → first two items
    i = 3 → first three items
    ...
    i = n → all items

But Java arrays are 0-indexed.

Therefore:

    i = 1 → val[0]
    i = 2 → val[1]
    i = 3 → val[2]

Hence:

    val[i - 1]

and:

    wt[i - 1]

are used.

-----------------------------------------------------------
WHY DOES THE OUTER LOOP START FROM 1?
-----------------------------------------------------------

The conceptual DP table contains row 0.

Row 0 means:

    No items are available.

The answer for row 0 is already known:

    0

This is represented by the initialized `prev[]` array.

Therefore, there is no need to process row 0.

The first actual item is processed at:

    i = 1

-----------------------------------------------------------
WHY IS IT `i < n + 1`?
-----------------------------------------------------------

This is equivalent to:

    i <= n

For example, if:

    n = 5

then:

    i < 6

allows:

    i = 1, 2, 3, 4, 5

Therefore all 5 items are processed.

===========================================================
SPECIAL NOTES ABOUT j
===========================================================

The inner loop is:

    for(int j = 1; j < W + 1; j++)

Here `j` represents the current knapsack capacity.

For example:

    j = 1 → capacity 1
    j = 2 → capacity 2
    j = 3 → capacity 3
    ...
    j = W → capacity W

-----------------------------------------------------------
WHY DOES j START FROM 1?
-----------------------------------------------------------

Capacity 0 is already a base case.

For capacity 0:

    Maximum profit = 0

Therefore, there is no need to calculate it again.

The first meaningful capacity is:

    j = 1

-----------------------------------------------------------
WHY IS IT `j < W + 1`?
-----------------------------------------------------------

This is equivalent to:

    j <= W

Therefore, the loop includes the actual maximum capacity W.

If:

    W = 7

then:

    j = 1, 2, 3, 4, 5, 6, 7

===========================================================
SPECIAL NOTES ABOUT INCLUDE CASE
===========================================================

The most important line in DP15 is:

    int profit1 = v + curr[j - w];

Why is `curr[]` used?

Because this is Unbounded Knapsack.

After selecting the current item, we are still allowed
to select that same item again.

Example:

    Current item:
        value = 45
        weight = 3

At capacity 6:

    profit1 = 45 + curr[3]

The value `curr[3]` may already contain:

    45

from selecting the same item once.

Therefore:

    45 + 45 = 90

The item has been selected twice.

This would NOT be possible if we used `prev[j - w]`
in the same way.

===========================================================
SPECIAL NOTES ABOUT 0/1 VS UNBOUNDED KNAPSACK
===========================================================

This is the most important comparison.

-----------------------------------------------------------
0/1 KNAPSACK
-----------------------------------------------------------

Each item can be selected only once.

Include:

    v + prev[j - w]

Why?

After selecting the current item, we move to the previous
row, which excludes the current item from further selection.

-----------------------------------------------------------
UNBOUNDED KNAPSACK
-----------------------------------------------------------

Each item can be selected multiple times.

Include:

    v + curr[j - w]

Why?

We remain in the current row, so the current item is still
available for selection.

-----------------------------------------------------------
SPACE-OPTIMIZED FORM
-----------------------------------------------------------

0/1 Knapsack:

    curr[j] = Math.max(
        v + prev[j - w],
        prev[j]
    );

Unbounded Knapsack:

    curr[j] = Math.max(
        v + curr[j - w],
        prev[j]
    );

The difference is:

    prev[j - w]

versus:

    curr[j - w]

This single change allows repeated use of the current item.

===========================================================
SPECIAL NOTES ABOUT curr = curr.clone()
===========================================================

After calculating the complete current row:

    prev = curr.clone();

is executed.

`clone()` creates a separate copy of the array.

Therefore:

    prev

gets the values of:

    curr

without becoming the same array reference.

If we wrote:

    prev = curr;

then both variables would refer to the same array.

That would cause problems because changing `curr`
would also affect `prev`.

Therefore:

    prev = curr.clone();

is used.

-----------------------------------------------------------
WHY IS clone() AFTER THE INNER LOOP?
-----------------------------------------------------------

The complete current row must first be calculated.

Therefore:

    for(int j = 1; j < W + 1; j++)

must finish completely.

Only then should:

    prev = curr.clone();

execute.

This ensures that `prev` represents the complete current
row before moving to the next item.

===========================================================
SPECIAL NOTES ABOUT Arrays.fill()
===========================================================

The same `curr[]` array is reused for every item.

Therefore, before calculating a new row:

    Arrays.fill(curr, 0);

is used.

This resets all values to 0.

Without resetting the array, old values from the previous
current row could remain.

===========================================================
SPECIAL NOTES ABOUT WHY TWO ARRAYS ARE ENOUGH
===========================================================

The original 2D recurrence depends only on:

    previous row
    current row

For Unbounded Knapsack:

    dp[i][j]

depends on:

    dp[i][j - w]
    dp[i - 1][j]

The first dependency belongs to the current row.

The second dependency belongs to the previous row.

Therefore, we only need:

    curr[]
    prev[]

There is no need to store all n rows.

This reduces space from:

    O(n × W)

to:

    O(W)

while keeping the time complexity:

    O(n × W)

===========================================================
SPECIAL NOTES ABOUT RETURN VALUE
===========================================================

The original 2D solution returns:

    dp[n][W]

In DP15, the complete 2D table is not stored.

After the final item is processed:

    prev

represents the final row.

Therefore:

    prev[W]

is equivalent to:

    dp[n][W]

So we return:

    return prev[W];

This represents:

    Maximum profit using all n items
    with capacity W.

===========================================================
TIME COMPLEXITY
===========================================================

There are:

    n

items.

For every item, we process:

    W

capacities.

Therefore:

    Time Complexity = O(n × W)

Each DP state takes constant time.

===========================================================
SPACE COMPLEXITY
===========================================================

We use only two arrays:

    prev[W + 1]
    curr[W + 1]

Therefore:

    Space Complexity = O(W)

This is a space optimization from the original:

    O(n × W)

to:

    O(W)

===========================================================
SPECIAL NOTES
===========================================================

1. DP15 is the space-optimized version of Unbounded
   Knapsack Tabulation.

2. The original 2D DP table requires:

       O(n × W)

   space.

3. DP15 requires only:

       O(W)

   space.

4. `prev[]` represents the previous DP row.

5. `curr[]` represents the current DP row.

6. `i` represents the number of items being considered.

7. `i - 1` gives the current item's Java array index.

8. `j` represents the current capacity.

9. `j - w` represents the remaining capacity after
   including the current item.

10. The INCLUDE case is:

        v + curr[j - w]

11. The EXCLUDE case is:

        prev[j]

12. `curr[j - w]` is used because items can be reused.

13. `prev[j]` is used because exclusion removes the
    current item from consideration.

14. `prev = curr.clone()` moves the completed current row
    into the previous-row array.

15. `Arrays.fill(curr, 0)` resets the reused current array.

16. Final answer:

        prev[W]

17. Time Complexity:

        O(n × W)

18. Space Complexity:

        O(W)

===========================================================
*/

public class DP15 {

  public static int unboundedKnapsackOpt(int val[], int wt[], int W) {

    // Number of available items.
    int n = val.length;

    // Current row of the optimized DP table.
    int curr[] = new int[W + 1];

    // Previous row of the optimized DP table.
    int prev[] = new int[W + 1];

    // With zero items, maximum profit for every capacity is 0.
    Arrays.fill(prev, 0);

    // Process every item.
    // i represents the number of items currently being considered.
    // i starts from 1 because row 0 is the base case.
    for(int i = 1; i < n + 1; i++) {

      // Reset curr[] because the same array is reused for every item.
      Arrays.fill(curr, 0);

      // Process every possible capacity from 1 through W.
      for(int j = 1; j < W + 1; j++) {

        // Get the current item's value.
        // i - 1 converts the 1-based DP item index into
        // the 0-based Java array index.
        int v = val[i - 1];

        // Get the current item's weight.
        int w = wt[i - 1];

        // Check whether the current item can fit in capacity j.
        if(w <= j) {

          // Include the current item.
          // curr[j - w] is used instead of prev[j - w]
          // because the current item can be selected again.
          int profit1 = v + curr[j - w];

          // Exclude the current item.
          // Move to the previous row because the current
          // item is not used.
          int profit2 = prev[j];

          // Store the maximum profit between include and exclude.
          curr[j] = Math.max(profit1, profit2);

        } else {

          // Current item cannot fit, so exclude it.
          curr[j] = prev[j];
        }
      }

      // The complete current row is now calculated.
      // Copy it into prev for processing the next item.
      prev = curr.clone();
    }

    // After all items are processed, prev represents the final row.
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
    System.out.println("Maximum Profit = " + unboundedKnapsackOpt(val, wt, W));
  }
}