package DP;

/*
===========================================================
TITLE
===========================================================
Target Sum Subset Problem Using Dynamic Programming (Tabulation)

===========================================================
PROBLEM STATEMENT
===========================================================
You are given an array of positive integers.

You are also given a target sum.

Your task is to determine whether it is possible to select
some elements from the array such that their total sum is
exactly equal to the given target sum.

Each element can be selected at most once.

This means every element has exactly two choices:

• 0 → Do not include the element.
• 1 → Include the element.

Input:
• int[] arr → array containing positive integers.
• int sum → target sum that we want to achieve.

Output:
• true → If a subset exists whose sum is exactly equal to sum.
• false → If no such subset exists.

Constraints:
• Each element can be selected at most once.
• Target sum must be non-negative.
• The array may contain multiple elements with the same value.

Edge Cases:
• sum = 0 → answer is always true because the empty subset
  has sum 0.
• Empty array with sum = 0 → true.
• Empty array with sum > 0 → false.
• If all elements are greater than sum → false.
• If a valid subset exists → true.

===========================================================
PROBLEM RESOURCE
===========================================================
• https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

===========================================================
INTUITION
===========================================================
The problem asks:

"Can we select some elements whose total sum is exactly
equal to the target sum?"

For every element, we have two choices:

1) INCLUDE the element
2) EXCLUDE the element

This makes the problem similar to the 0/1 Knapsack problem.

However, there is an important difference.

In 0/1 Knapsack:

    We maximize PROFIT.

In Target Sum Subset:

    We only need to determine whether a TARGET SUM
    is possible.

Therefore, instead of storing an integer maximum profit,
we store a boolean value.

The DP state is:

    dp[i][j]

Meaning:

"Can we form sum `j` using the first `i` elements?"

Therefore:

    dp[i][j] = true

means a subset exists using the first `i` elements
whose sum is exactly `j`.

And:

    dp[i][j] = false

means no such subset exists.

===========================================================
APPROACH
===========================================================
1) Find the number of elements:

    n = arr.length

2) Create a 2D boolean DP table:

    boolean dp[][] = new boolean[n + 1][sum + 1];

3) Rows represent the number of elements being considered.

    i = 0 → no elements
    i = 1 → first element
    i = 2 → first two elements
       ...
    i = n → all elements

4) Columns represent the target sum being considered.

    j = 0 → target sum 0
    j = 1 → target sum 1
       ...
    j = sum → original target sum

5) Initialize column 0 as true.

    dp[i][0] = true

Why?

Because sum 0 can always be achieved by selecting
nothing.

The empty subset has sum 0.

6) For every element and every target sum, determine
   whether the current element can help form that sum.

7) Get the current element:

    int v = arr[i - 1];

8) Check whether:

    v <= j

If the current element is smaller than or equal to
the current target j, we have two choices.

INCLUDE:

    dp[i - 1][j - v]

EXCLUDE:

    dp[i - 1][j]

9) INCLUDE means:

"Select the current element."

If the current element has value v, then after selecting
it, we need to form:

    j - v

using the previous elements.

Therefore:

    dp[i - 1][j - v]

10) EXCLUDE means:

"Do not select the current element."

Therefore, we simply check whether the previous elements
could already form j:

    dp[i - 1][j]

11) If either choice is possible:

    dp[i][j] = true

12) If the current element is too large:

    v > j

then it cannot be included.

Therefore:

    dp[i][j] = dp[i - 1][j]

13) After filling the table, return:

    dp[n][sum]

===========================================================
MEANING OF dp[i][j]
===========================================================
This is the most important concept in this problem.

    dp[i][j]

means:

"Is it possible to create sum `j` using the first `i`
elements of the array?"

The value stored in this cell is BOOLEAN:

    true
    false

Example:

    dp[3][7] = true

means:

"Using the first 3 elements, it is possible to create
a subset whose sum is exactly 7."

It does NOT mean:

"Maximum sum is 7."

It specifically means:

"Is sum 7 possible?"

===========================================================
MEANING OF i
===========================================================
`i` represents the NUMBER OF ELEMENTS being considered.

For example:

    i = 3

means:

"Consider the first 3 elements."

If:

    arr = {4, 2, 7, 1, 3}

then:

    i = 3

means we are considering:

    {4, 2, 7}

The current element is located at:

    arr[i - 1]

Therefore:

    arr[3 - 1]
    arr[2]
    = 7

===========================================================
WHY arr[i - 1]?
===========================================================
The DP row uses a 1-based representation of the number
of elements:

    i = 1 → first element
    i = 2 → first two elements
    i = 3 → first three elements

But Java arrays are 0-indexed:

    arr[0] → first element
    arr[1] → second element
    arr[2] → third element

Therefore:

    current element = arr[i - 1]

For example:

    i = 1

    arr[i - 1]
    arr[0]

For:

    i = 5

    arr[i - 1]
    arr[4]

===========================================================
MEANING OF j
===========================================================
`j` represents the TARGET SUM currently being checked.

For example:

    j = 10

means:

"Can we form a subset whose sum is exactly 10?"

The algorithm checks every possible sum:

    1, 2, 3, ..., sum

until it reaches the original target.

===========================================================
INCLUDE AND EXCLUDE
===========================================================
Suppose:

    arr[i - 1] = v

and current target is:

    j

There are two possibilities.

-----------------------------------------------------------
INCLUDE
-----------------------------------------------------------

Select the current element.

Current element contributes:

    v

Remaining sum:

    j - v

Therefore we check:

    dp[i - 1][j - v]

If this is true, then:

    v + (j - v) = j

So the target j can be formed.

-----------------------------------------------------------
EXCLUDE
-----------------------------------------------------------

Do not select the current element.

The target remains:

    j

Therefore we check:

    dp[i - 1][j]

If this is true, then the previous elements can already
form j.

-----------------------------------------------------------
FINAL DECISION
-----------------------------------------------------------

If either choice works:

    dp[i][j] = true

Conceptually:

    dp[i][j] =
        INCLUDE OR EXCLUDE

===========================================================
EXAMPLE
===========================================================
Input:

    arr = [4, 2, 7, 1, 3]
    sum = 10

We need to determine:

"Is there a subset whose sum is exactly 10?"

Possible subset:

    7 + 3 = 10

Therefore the answer is:

    true

Output:

    true

===========================================================
DRY RUN
===========================================================
Initial array:

    arr = {4, 2, 7, 1, 3}

Target:

    sum = 10

Initial DP table:

    dp[6][11]

Rows:

    0 → no elements
    1 → 4
    2 → 4,2
    3 → 4,2,7
    4 → 4,2,7,1
    5 → 4,2,7,1,3

Columns:

    0 1 2 3 4 5 6 7 8 9 10

Column 0 is initialized to true:

    dp[i][0] = true

because sum 0 can always be formed using an empty subset.

-----------------------------------------------------------
i = 1
-----------------------------------------------------------

Current element:

    arr[0] = 4

For:

    j = 4

The element fits:

    4 <= 4

INCLUDE:

    dp[0][4 - 4]
    dp[0][0]

    = true

Therefore:

    dp[1][4] = true

This means:

"Using the first element {4}, we can form sum 4."

-----------------------------------------------------------
i = 2
-----------------------------------------------------------

Current element:

    arr[1] = 2

For:

    j = 6

INCLUDE:

    dp[1][6 - 2]
    dp[1][4]

    = true

Therefore:

    dp[2][6] = true

This represents:

    4 + 2 = 6

-----------------------------------------------------------
i = 3
-----------------------------------------------------------

Current element:

    arr[2] = 7

For:

    j = 7

INCLUDE:

    dp[2][7 - 7]
    dp[2][0]

    = true

Therefore:

    dp[3][7] = true

This represents selecting:

    {7}

-----------------------------------------------------------
i = 5
-----------------------------------------------------------

Current element:

    arr[4] = 3

Target:

    j = 10

The element fits:

    3 <= 10

INCLUDE:

    dp[4][10 - 3]
    dp[4][7]

    = true

Therefore:

    dp[5][10] = true

This corresponds to:

    7 + 3 = 10

Finally:

    dp[n][sum]

    dp[5][10]

    = true

Therefore:

    return true

===========================================================
KEY POINTS
===========================================================
• Target Sum Subset is a Dynamic Programming problem.
• It is solved using Include/Exclude choices.
• Each element can be selected at most once.
• Therefore, it follows the 0/1 selection pattern.
• `dp[i][j]` stores a boolean instead of a maximum profit.
• `true` means the target sum j is possible.
• `false` means the target sum j is not possible.
• `dp[i][0] = true` because sum 0 can always be formed
  using the empty subset.
• `arr[i - 1]` represents the current element.
• `j - v` represents the remaining sum after including
  the current element.
• The final answer is `dp[n][sum]`.
• No recursion is required because this is Bottom-Up
  Tabulation.

===========================================================
SIMILARITY WITH 0/1 KNAPSACK
===========================================================
Target Sum Subset and 0/1 Knapsack have a very similar
Dynamic Programming structure.

Both problems:

• Process elements one by one.
• Give each element an Include/Exclude choice.
• Allow each item/element to be used at most once.
• Use a 2D DP table.
• Use `i` to represent the number of elements/items.
• Use `j` to represent a capacity or target.
• Use `i - 1` to access the current array element.
• Use the previous row when including an element.
• Use the previous row when excluding an element.
• Use Bottom-Up Tabulation.
• Have O(n × W) style time complexity.

The structural pattern is:

    Current State
          |
      /       \
    Include   Exclude
       |         |
 Previous Row  Previous Row

This is why Target Sum Subset is closely related to
0/1 Knapsack.

===========================================================
DIFFERENCE FROM 0/1 KNAPSACK
===========================================================

The biggest difference is WHAT the DP stores.

-----------------------------------------------------------
0/1 KNAPSACK
-----------------------------------------------------------

Goal:

    MAXIMIZE PROFIT

DP state:

    dp[i][j]

means:

"Maximum profit using the first i items with capacity j."

Therefore:

    dp[i][j]

is an INTEGER.

Example:

    dp[i][j] = 75

means maximum profit is 75.

-----------------------------------------------------------
TARGET SUM SUBSET
-----------------------------------------------------------

Goal:

    CHECK WHETHER A SUM IS POSSIBLE

DP state:

    dp[i][j]

means:

"Can we form sum j using the first i elements?"

Therefore:

    dp[i][j]

is BOOLEAN.

Example:

    dp[i][j] = true

means sum j is possible.

-----------------------------------------------------------
RECURRENCE DIFFERENCE
-----------------------------------------------------------

0/1 Knapsack:

    dp[i][j] = Math.max(
        v + dp[i - 1][j - w],
        dp[i - 1][j]
    )

Target Sum Subset:

    dp[i][j] =
        dp[i - 1][j - v]
        OR
        dp[i - 1][j]

Knapsack uses:

    Math.max()

because it wants the BEST PROFIT.

Target Sum Subset uses:

    OR

because it only needs to know whether AT LEAST ONE
valid subset exists.

===========================================================
SPECIAL NOTES ABOUT DP ARRAY
===========================================================

WHY IS dp[][] 2D?

There are two changing variables:

1) Number of elements
2) Target sum

Therefore:

    dp[i][j]

is used.

Here:

    i = number of elements considered
    j = target sum currently being checked

-----------------------------------------------------------
WHY boolean[][]?
-----------------------------------------------------------

The problem does not ask:

"How much is the maximum profit?"

It asks:

"Is the target sum possible?"

Therefore only two states are required:

    true
    false

Hence:

    boolean dp[][]

is used.

-----------------------------------------------------------
WHY dp[n + 1][sum + 1]?
-----------------------------------------------------------

Suppose:

    n = 5
    sum = 10

Rows required:

    0, 1, 2, 3, 4, 5

Total:

    n + 1 = 6 rows

Columns required:

    0, 1, 2, ..., 10

Total:

    sum + 1 = 11 columns

Therefore:

    new boolean[n + 1][sum + 1]

becomes:

    new boolean[6][11]

===========================================================
SPECIAL NOTES ABOUT dp[i][j]
===========================================================

Always read:

    dp[i][j]

as:

"Using the first `i` elements, can we make sum `j`?"

For example:

    dp[3][7] = true

means:

"Using the first 3 elements, sum 7 is possible."

It does NOT mean:

    "The third element is 7."

The `i` and `j` values describe the DP STATE.

===========================================================
SPECIAL NOTES ABOUT dp[i - 1][j - v]
===========================================================

This represents the INCLUDE choice.

Suppose:

    i = 5
    j = 10
    v = 3

If we include the current element 3:

    Remaining sum = 10 - 3
                  = 7

Therefore:

    dp[i - 1][j - v]

becomes:

    dp[4][7]

Meaning:

"Can the previous 4 elements create sum 7?"

If yes:

    7 + 3 = 10

Therefore sum 10 is possible.

===========================================================
SPECIAL NOTES ABOUT dp[i - 1][j]
===========================================================

This represents the EXCLUDE choice.

If the current element is not selected:

    target remains j

Therefore:

    dp[i - 1][j]

is checked.

For example:

    dp[4][10]

means:

"Can the previous 4 elements create sum 10?"

If yes, we do not need the current element.

===========================================================
SPECIAL NOTES ABOUT i - 1
===========================================================

The DP row uses:

    i = number of elements

but the array uses:

    0-based indexing

Therefore:

    current element = arr[i - 1]

For example:

    i = 1
    arr[i - 1]
    arr[0]

means the first element.

Similarly:

    i = 5
    arr[i - 1]
    arr[4]

means the fifth element.

===========================================================
SPECIAL NOTES ABOUT dp[i][0] = true
===========================================================

This is an important difference from thinking only
about normal numeric DP.

We set:

    dp[i][0] = true

for every i.

Why?

Because sum 0 is always possible.

We simply select no elements:

    {}

Sum:

    0

Therefore:

    dp[i][0] = true

This represents the empty subset.

===========================================================
SPECIAL NOTES ABOUT THE FINAL RETURN
===========================================================

The original problem asks:

"Using ALL elements, can we create the target sum?"

All elements:

    n

Target:

    sum

Therefore the final DP state is:

    dp[n][sum]

Hence:

    return dp[n][sum];

For this example:

    n = 5
    sum = 10

Therefore:

    return dp[5][10];

Since:

    dp[5][10] = true

the method returns:

    true

The final DP state always represents the ORIGINAL
PROBLEM that we were asked to solve.

===========================================================
SPECIAL NOTES ABOUT 0/1 NATURE
===========================================================

Each element can be selected only once.

That is why the INCLUDE state uses:

    i - 1

instead of:

    i

For example:

    dp[i - 1][j - v]

means:

"After selecting the current element, solve the remaining
sum using only the PREVIOUS elements."

This prevents the same element from being selected again.

This is the same important 0/1 property that appears
in the 0/1 Knapsack problem.

===========================================================
TIME COMPLEXITY
===========================================================

Let:

    n = number of elements
    sum = target sum

Outer loop:

    O(n)

Inner loop:

    O(sum)

Therefore:

    O(n × sum)

Best Case:

    O(n × sum)

Average Case:

    O(n × sum)

Worst Case:

    O(n × sum)

Every DP state is processed once.

===========================================================
SPACE COMPLEXITY
===========================================================

The DP table contains:

    (n + 1) × (sum + 1)

boolean values.

Therefore:

    O(n × sum)

Auxiliary Space:

    O(n × sum)

Recursion Stack:

    O(1)

because this solution uses iterative Tabulation.

This problem can also be space optimized to:

    O(sum)

using a 1D boolean DP array.

===========================================================
SPECIAL NOTES
===========================================================
1) TARGET SUM SUBSET is closely related to 0/1 KNAPSACK.

2) Both use:

    Include / Exclude

3) Both ensure that an element/item is used at most once.

4) The biggest difference is the objective.

    0/1 Knapsack:
        Maximize profit.

    Target Sum Subset:
        Determine whether a target sum is possible.

5) Therefore, the DP data type changes:

    Knapsack:
        int[][]

    Target Sum Subset:
        boolean[][]

6) The operation also changes:

    Knapsack:
        Math.max()

    Target Sum Subset:
        OR

7) In Target Sum Subset:

    true = target is possible
    false = target is impossible

8) In 0/1 Knapsack:

    dp[i][j] = maximum profit

9) The most important state to remember:

    dp[i][j]

    "Can I form sum j using the first i elements?"

10) The final answer is:

    dp[n][sum]

11) The INCLUDE state:

    dp[i - 1][j - v]

12) The EXCLUDE state:

    dp[i - 1][j]

13) The base case:

    dp[i][0] = true

because the empty subset can always create sum 0.

14) A useful way to identify this DP pattern:

    If the problem asks:

    "Can I select some elements to achieve exactly
     a target?"

    and each element can be used at most once,

    think:

        0/1 Knapsack Pattern
              +
        Boolean DP

15) The standard progression is:

    Recursion
        ↓
    Memoization
        ↓
    Tabulation
        ↓
    Space Optimization

16) First understand the 2D DP clearly before attempting
    1D space optimization.
*/

public class DP12 {

  public static boolean targetSumSubset(int arr[], int sum) {

    // Number of elements in the array.
    int n = arr.length;

    // dp[i][j] means whether sum j can be formed using the first i elements.
    boolean dp[][] = new boolean[n + 1][sum + 1];

    // Sum 0 is always possible by selecting no elements.
    for(int i = 0; i < n + 1; i++) {
      dp[i][0] = true;
    }

    // Build the DP table from smaller problems to larger problems.
    for(int i = 1; i < n + 1; i++) {

      // Check every possible target sum from 1 to the required sum.
      for(int j = 1; j < sum + 1; j++) {

        // Current element's value.
        int v = arr[i - 1];

        // Check whether the current element can be included.
        if(v <= j && dp[i - 1][j - v] == true) {
          dp[i][j] = true; // Include current element.
        }

        // Check whether the target can already be formed without
        // including the current element.
        if(dp[i - 1][j]) {
          dp[i][j] = true; // Exclude current element.
        }
      }
    }

    // dp[n][sum] represents whether the original target can be formed
    // using all available elements.
    return dp[n][sum];
  }

  public static void main(String[] args) {

    // Array containing the available elements.
    int arr[] = {4, 2, 7, 1, 3};

    // Target sum that we want to form.
    int sum = 10;

    // Calculate and print whether the target sum is possible.
    System.out.println(targetSumSubset(arr, sum));
  }
}