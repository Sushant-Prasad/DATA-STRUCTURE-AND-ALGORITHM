package DP;

/*
===========================================================
TITLE
===========================================================

Unbounded Knapsack Problem Using Dynamic Programming (Tabulation)

===========================================================
PROBLEM STATEMENT
===========================================================

Given:

    val[] = values/profits of items
    wt[]  = weights of items
    W     = maximum capacity of the knapsack

Find the maximum profit that can be obtained without exceeding
the capacity W.

In Unbounded Knapsack, an item can be selected MULTIPLE TIMES.

This is the major difference between:

    0/1 Knapsack
    Unbounded Knapsack

In 0/1 Knapsack:

    Each item can be selected at most once.

In Unbounded Knapsack:

    Each item can be selected any number of times.

-----------------------------------------------------------
INPUT
-----------------------------------------------------------

val[] = array containing the value/profit of every item.

wt[] = array containing the weight of every item.

W = maximum capacity of the knapsack.

Example:

    val = {15, 14, 10, 45, 30}
    wt  = {2, 5, 1, 3, 4}
    W = 7

-----------------------------------------------------------
OUTPUT
-----------------------------------------------------------

Return the maximum profit that can be obtained without
exceeding capacity W.

For the given example:

    Maximum Profit = 100

Because item with:

    value = 10
    weight = 1

can be selected 7 times:

    10 + 10 + 10 + 10 + 10 + 10 + 10 = 70

However, item:

    value = 45
    weight = 3

can be selected twice:

    45 + 45 = 90

And the best combination is:

    45 + 45 + 10 = 100

Total weight:

    3 + 3 + 1 = 7

Therefore:

    Maximum Profit = 100

-----------------------------------------------------------
CONSTRAINTS
-----------------------------------------------------------

1. Number of values and weights should be the same.

2. Every weight should be positive.

3. W represents the maximum capacity.

4. Items can be selected multiple times.

5. An item can be selected again after being selected once.

-----------------------------------------------------------
EDGE CASES
-----------------------------------------------------------

1. W = 0

   Maximum profit is 0 because the knapsack has no capacity.

2. Empty item array

   Maximum profit is 0.

3. Item weight greater than W

   That item cannot be selected for the current capacity.

4. Item weight = 0

   This should generally be avoided because an item with
   zero weight and positive value could be selected infinitely
   many times.

===========================================================
PROBLEM RESOURCE
===========================================================

• GeeksforGeeks:
  https://www.geeksforgeeks.org/problems/unbounded-knapsack/1

===========================================================
INTUITION
===========================================================

For every item and every capacity, we have two choices:

1. INCLUDE the current item.
2. EXCLUDE the current item.

-----------------------------------------------------------
INCLUDE
-----------------------------------------------------------

If:

    w <= j

we can include the current item.

The profit obtained from including it is:

    v + dp[i][j - w]

Notice:

    dp[i]

is used instead of:

    dp[i - 1]

This is the most important part of Unbounded Knapsack.

Why?

Because after selecting the current item once, we are still
allowed to select the SAME item again.

Therefore, we remain in row i.

-----------------------------------------------------------
EXCLUDE
-----------------------------------------------------------

If we do not select the current item, we move to the previous
row:

    dp[i - 1][j]

This means:

    Ignore the current item completely.

-----------------------------------------------------------
FINAL RECURRENCE
-----------------------------------------------------------

If:

    w <= j

then:

    dp[i][j] = Math.max(
        v + dp[i][j - w],
        dp[i - 1][j]
    );

Otherwise:

    dp[i][j] = dp[i - 1][j];

===========================================================
APPROACH
===========================================================

Step 1:
-------
Find the number of available items.

    int n = val.length;

Step 2:
-------
Create a DP table:

    int dp[][] = new int[n + 1][W + 1];

Rows represent items.

Columns represent capacities.

-----------------------------------------------------------
DP STATE
-----------------------------------------------------------

    dp[i][j]

means:

    Maximum profit that can be obtained using the first
    i items with a knapsack capacity of j.

For example:

    dp[3][7]

means:

    Maximum profit using the first 3 items when the
    capacity is 7.

-----------------------------------------------------------
STEP 3: BASE CASE
-----------------------------------------------------------

If capacity is 0:

    dp[i][0] = 0

because no item can be selected.

If zero items are available:

    dp[0][j] = 0

because there are no items from which profit can be obtained.

Java initializes int arrays with 0 automatically, but the
base cases are explicitly initialized in this program for
clarity.

-----------------------------------------------------------
STEP 4: PROCESS EVERY ITEM
-----------------------------------------------------------

The outer loop is:

    for(int i = 1; i < n + 1; i++)

Here:

    i = 1 -> first item
    i = 2 -> first two items
    ...
    i = n -> all items

-----------------------------------------------------------
STEP 5: PROCESS EVERY CAPACITY
-----------------------------------------------------------

The inner loop is:

    for(int j = 1; j < W + 1; j++)

Here j represents the current capacity.

For every item, we calculate the best profit for every
capacity from 1 through W.

-----------------------------------------------------------
STEP 6: GET CURRENT ITEM
-----------------------------------------------------------

    int v = val[i - 1];

    int w = wt[i - 1];

The DP index i starts from 1, but Java arrays start from 0.

Therefore:

    i = 1 -> val[0], wt[0]
    i = 2 -> val[1], wt[1]
    i = 3 -> val[2], wt[2]

Hence:

    i - 1

is required.

-----------------------------------------------------------
STEP 7: INCLUDE OR EXCLUDE
-----------------------------------------------------------

If:

    w <= j

the current item can fit.

Include:

    profit1 = v + dp[i][j - w]

Exclude:

    profit2 = dp[i - 1][j]

Take the maximum:

    dp[i][j] = Math.max(profit1, profit2);

If:

    w > j

the current item cannot fit.

Therefore:

    dp[i][j] = dp[i - 1][j];

-----------------------------------------------------------
STEP 8: RETURN ANSWER
-----------------------------------------------------------

After processing all items and all capacities:

    return dp[n][W];

This represents:

    Maximum profit using all available items
    with capacity W.

===========================================================
EXAMPLE
===========================================================

Given:

    val = {15, 14, 10, 45, 30}
    wt  = {2, 5, 1, 3, 4}
    W = 7

Items:

    Item 1:
        value = 15
        weight = 2

    Item 2:
        value = 14
        weight = 5

    Item 3:
        value = 10
        weight = 1

    Item 4:
        value = 45
        weight = 3

    Item 5:
        value = 30
        weight = 4

Since this is Unbounded Knapsack, items can be reused.

One optimal selection is:

    Item 4 + Item 4 + Item 3

Weights:

    3 + 3 + 1 = 7

Values:

    45 + 45 + 10 = 100

Therefore:

    Maximum Profit = 100

===========================================================
DRY RUN
===========================================================

Consider Item 4:

    value = 45
    weight = 3

When capacity becomes 3:

    dp[4][3]

We can include Item 4:

    45 + dp[4][0]

    = 45 + 0

    = 45

So:

    dp[4][3] = 45

-----------------------------------------------------------
CAPACITY = 6
-----------------------------------------------------------

Now:

    dp[4][6]

Include Item 4:

    45 + dp[4][3]

Since:

    dp[4][3] = 45

we get:

    45 + 45 = 90

Therefore:

    dp[4][6] = 90

This means Item 4 was used twice.

-----------------------------------------------------------
CAPACITY = 7
-----------------------------------------------------------

Now:

    dp[4][7]

Include Item 4:

    45 + dp[4][4]

At capacity 4, Item 3 with:

    value = 10
    weight = 1

can be used repeatedly.

So:

    dp[4][4] = 55

Therefore:

    45 + 55 = 100

Hence:

    dp[4][7] = 100

One possible selection:

    Item 4 -> weight 3, value 45
    Item 4 -> weight 3, value 45
    Item 3 -> weight 1, value 10

Total:

    Weight = 7
    Profit = 100

===========================================================
KEY POINTS
===========================================================

1. This is an Unbounded Knapsack problem.

2. Items can be selected multiple times.

3. Every item has two choices:

       Include
       Exclude

4. Include recurrence:

       v + dp[i][j - w]

5. Exclude recurrence:

       dp[i - 1][j]

6. The most important difference from 0/1 Knapsack is:

   0/1 Knapsack:

       v + dp[i - 1][j - w]

   Unbounded Knapsack:

       v + dp[i][j - w]

7. Using dp[i][j - w] allows the current item to be
   selected again.

8. Using dp[i - 1][j] for exclusion means the current item
   is completely ignored.

===========================================================
SPECIAL NOTES ABOUT DP ARRAY
===========================================================

The DP table has:

    n + 1 rows

and:

    W + 1 columns

Why?

Because we need to represent:

    0 items through n items

and:

    capacity 0 through W

Therefore:

    dp[n + 1][W + 1]

is required.

-----------------------------------------------------------
MEANING OF dp[i][j]
-----------------------------------------------------------

    dp[i][j]

means:

    Maximum profit using the first i items with capacity j.

For example:

    dp[3][5]

means:

    Maximum profit using the first 3 items
    with capacity 5.

===========================================================
SPECIAL NOTES ABOUT i AND i - 1
===========================================================

The outer loop is:

    for(int i = 1; i < n + 1; i++)

The DP row starts from 1 because row 0 represents
the base case of using zero items.

Therefore:

    i = 1 -> first item
    i = 2 -> second item
    ...
    i = n -> nth item

But Java arrays use 0-based indexing.

Therefore:

    val[i - 1]
    wt[i - 1]

are used.

Example:

    i = 1

then:

    val[i - 1]
    = val[0]

which is the first item.

===========================================================
SPECIAL NOTES ABOUT WHY INCLUDE USES dp[i][j - w]
===========================================================

This is the MOST IMPORTANT concept in Unbounded Knapsack.

The include expression is:

    int profit1 = v + dp[i][j - w];

Notice that the row remains:

    i

It does NOT become:

    i - 1

Why?

Because the current item can be used again.

-----------------------------------------------------------
EXAMPLE
-----------------------------------------------------------

Suppose:

    current item:
        value = 45
        weight = 3

Capacity:

    j = 7

If we select this item once, remaining capacity is:

    7 - 3 = 4

So:

    profit1 = 45 + dp[i][4]

The important part is:

    dp[i][4]

not:

    dp[i - 1][4]

Because dp[i][4] is allowed to use the current item
again.

Therefore, the current item can appear multiple times.

-----------------------------------------------------------
0/1 KNAPSACK
-----------------------------------------------------------

In 0/1 Knapsack:

    profit1 = v + dp[i - 1][j - w];

After selecting the item, we move to row i - 1.

That means:

    The current item cannot be selected again.

-----------------------------------------------------------
UNBOUNDED KNAPSACK
-----------------------------------------------------------

In Unbounded Knapsack:

    profit1 = v + dp[i][j - w];

We remain in row i.

That means:

    The current item is still available.

Therefore:

    Current item can be selected again.

===========================================================
SPECIAL NOTES ABOUT dp[i][j - w] VS dp[i - 1][j - w]
===========================================================

This single difference determines whether the problem is
0/1 Knapsack or Unbounded Knapsack.

-----------------------------------------------------------
0/1 KNAPSACK
-----------------------------------------------------------

    v + dp[i - 1][j - w]

Meaning:

    Select current item once,
    then move to previous items.

Current item is no longer available.

-----------------------------------------------------------
UNBOUNDED KNAPSACK
-----------------------------------------------------------

    v + dp[i][j - w]

Meaning:

    Select current item,
    then continue with the same set of items.

Current item remains available.

Therefore:

    dp[i][j - w]

allows repeated selection.

===========================================================
SPECIAL NOTES ABOUT WHY EXCLUDE USES dp[i - 1][j]
===========================================================

The exclude expression is:

    int profit2 = dp[i - 1][j];

This means:

    Do not use the current item at all.

Therefore, we move to the previous row.

Example:

    i = 4

means we are considering Item 4.

If we exclude Item 4, we can only use:

    Items 1, 2 and 3

Therefore:

    dp[i - 1][j]

is correct.

===========================================================
SPECIAL NOTES ABOUT THE TWO LOOPS
===========================================================

The outer loop:

    for(int i = 1; i < n + 1; i++)

processes every item.

The inner loop:

    for(int j = 1; j < W + 1; j++)

processes every capacity.

Therefore:

    i -> item dimension

    j -> capacity dimension

The DP table is built from smaller subproblems to larger
subproblems.

-----------------------------------------------------------
WHY START i FROM 1?
-----------------------------------------------------------

Row 0 represents:

    zero items

and is already initialized as 0.

Therefore, actual items begin from:

    i = 1

-----------------------------------------------------------
WHY START j FROM 1?
-----------------------------------------------------------

Column 0 represents:

    capacity = 0

and is already initialized as 0.

Therefore, actual capacities begin from:

    j = 1

-----------------------------------------------------------
WHY USE n + 1?
-----------------------------------------------------------

The condition:

    i < n + 1

is equivalent to:

    i <= n

Therefore, all n items are processed.

-----------------------------------------------------------
WHY USE W + 1?
-----------------------------------------------------------

The condition:

    j < W + 1

is equivalent to:

    j <= W

Therefore, capacity W is also processed.

===========================================================
SPECIAL NOTES ABOUT BASE CASES
===========================================================

For:

    dp[i][0]

capacity is 0.

Therefore:

    dp[i][0] = 0

regardless of how many items are available.

For:

    dp[0][j]

there are zero items.

Therefore:

    dp[0][j] = 0

regardless of the capacity.

These are the base cases of the DP table.

===========================================================
SPECIAL NOTES ABOUT int ARRAY INITIALIZATION
===========================================================

Java automatically initializes every element of an int array
to 0.

Therefore:

    int dp[][] = new int[n + 1][W + 1];

already contains zeros.

The explicit initialization loops:

    for(int i = 0; i < dp.length; i++)
        dp[i][0] = 0;

and:

    for(int j = 0; j < dp[0].length; j++)
        dp[0][j] = 0;

are therefore not technically necessary.

They are kept here because they make the DP base cases
explicit and easier to understand while studying.

===========================================================
TIME COMPLEXITY
===========================================================

There are:

    n

items.

For every item, we calculate:

    W

capacities.

Therefore:

    Time Complexity = O(n × W)

===========================================================
SPACE COMPLEXITY
===========================================================

The DP table contains:

    (n + 1) × (W + 1)

values.

Therefore:

    Space Complexity = O(n × W)

===========================================================
SPECIAL NOTES
===========================================================

1. Unbounded Knapsack allows unlimited reuse of items.

2. The include case uses:

       dp[i][j - w]

3. The exclude case uses:

       dp[i - 1][j]

4. The most important difference from 0/1 Knapsack is
   the row used in the include case.

5. 0/1 Knapsack:

       dp[i - 1][j - w]

6. Unbounded Knapsack:

       dp[i][j - w]

7. Same row i means:

       Current item can be reused.

8. Previous row i - 1 means:

       Current item is no longer considered.

9. i represents the number of items being considered.

10. j represents the current knapsack capacity.

11. arr[i - 1] is used because Java arrays are 0-indexed
    while DP item indexing starts from 1.

12. The final answer is:

       dp[n][W]

13. Time complexity:

       O(n × W)

14. Space complexity:

       O(n × W)

===========================================================
*/

public class DP14 {

  /*
   * Returns the maximum profit that can be obtained using
   * Unbounded Knapsack with the given values, weights and capacity.
   */
  public static int unboundedKnapsackTab(int val[], int wt[], int W) {

    // Number of available items.
    int n = val.length;

    // Create DP table.
    // Rows represent number of items considered.
    // Columns represent knapsack capacity.
    int dp[][] = new int[n + 1][W + 1];

    // Initialize column 0.
    // Capacity 0 always gives maximum profit 0.
    for(int i = 0; i < dp.length; i++) {
      dp[i][0] = 0;
    }

    // Initialize row 0.
    // With zero items, maximum profit is 0 for every capacity.
    for(int j = 0; j < dp[0].length; j++) {
      dp[0][j] = 0;
    }

    // Process every item.
    // i represents the number of items currently available.
    for(int i = 1; i < n + 1; i++) {

      // Process every capacity from 1 through W.
      for(int j = 1; j < W + 1; j++) {

        // Get the current item's value.
        // i starts from 1, so i - 1 gives the Java array index.
        int v = val[i - 1];

        // Get the current item's weight.
        // i - 1 converts the DP index into the Java array index.
        int w = wt[i - 1];

        // Check whether the current item can fit into capacity j.
        if(w <= j) {

          // Include the current item.
          // dp[i][j - w] keeps the same row i because this is
          // Unbounded Knapsack and the current item can be reused.
          int profit1 = v + dp[i][j - w];

          // Exclude the current item.
          // Move to the previous row because the current item
          // is not used at all.
          int profit2 = dp[i - 1][j];

          // Store the better result between include and exclude.
          dp[i][j] = Math.max(profit1, profit2);

        } else {

          // Current item cannot fit, so exclude it automatically.
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    // Return the maximum profit using all items and capacity W.
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
    System.out.println("Maximum Profit = " + unboundedKnapsackTab(val, wt, W));
  }
}