package DP;

/*
===========================================================
TITLE
===========================================================
Target Sum Subset using Space-Optimized Tabulation

===========================================================
PROBLEM STATEMENT
===========================================================

Given an array of integers and a target sum, determine whether
there exists a subset of the array whose elements add up to
exactly the target sum.

Each element can be used at most once.

Input:
------
arr[] = array of available elements
sum   = target sum that we want to form

Output:
-------
Return true if some subset of the array can form the target sum.
Otherwise, return false.

Example:
--------
arr = {4, 2, 7, 1, 3}
sum = 10

Possible subset:
4 + 2 + 1 + 3 = 10

Therefore:
true

Constraints:
------------
1. Each element can be selected at most once.
2. Target sum must be non-negative.
3. The DP array size depends on the target sum.

Edge Cases:
-----------
1. sum = 0
   The answer is always true because the empty subset
   can form sum 0.

2. Empty array
   Only sum = 0 can be formed.

3. No possible subset
   Return false.

===========================================================
PROBLEM RESOURCE
===========================================================

• https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

===========================================================
INTUITION
===========================================================

For every element, we have two choices:

1. INCLUDE the current element.
2. EXCLUDE the current element.

Suppose:

    current element = v
    current target = j

If v <= j, we can include v.

After including v, the remaining sum becomes:

    j - v

So:

    curr[j] = prev[j - v]

If we exclude v, the answer comes directly from the
previous row:

    curr[j] = prev[j]

Therefore:

    curr[j] = include OR exclude

This is the same include/exclude logic used in
0/1 Knapsack.

===========================================================
APPROACH
===========================================================

Step 1:
-------
Find the number of elements.

    int n = arr.length;

Step 2:
-------
Create two boolean arrays of size sum + 1.

    curr[] -> current DP row
    prev[] -> previous DP row

Step 3:
-------
Initialize:

    prev[0] = true;

This means that sum 0 is possible before processing
any element.

The empty subset can always create sum 0.

Step 4:
-------
Process every element using the outer loop:

    for(int i = 1; i < n + 1; i++)

Step 5:
-------
For each element, check every target from 1 to sum:

    for(int j = 1; j < sum + 1; j++)

Step 6:
-------
Get the current element:

    int v = arr[i - 1];

Step 7:
-------
If the current element can fit into the current target:

    if(v <= j && prev[j - v] == true)

then include the current element.

Step 8:
-------
Check whether the current target was already possible
without using the current element:

    if(prev[j])

This represents exclusion.

Step 9:
-------
After completely constructing the current row, copy it
into prev:

    prev = curr.clone();

Now prev represents the DP results after processing
the current element.

Step 10:
-------
After all elements are processed:

    return prev[sum];

This gives whether the target sum can be formed using
all elements.

===========================================================
EXAMPLE
===========================================================

Input:

    arr = {4, 2, 7, 1, 3}
    sum = 10

One valid subset is:

    4 + 2 + 1 + 3 = 10

Therefore the output is:

    true

===========================================================
DRY RUN
===========================================================

Initial:

    prev[0] = true

This means:

    sum 0 -> possible

-----------------------------------------------------------
PROCESS ELEMENT 4
-----------------------------------------------------------

Current element:

    v = 4

For j = 1, 2, 3:

    4 > j

So 4 cannot be included.

For j = 4:

    prev[4 - 4]
    prev[0] = true

Therefore:

    curr[4] = true

This means sum 4 can be formed using element 4.

-----------------------------------------------------------
PROCESS ELEMENT 2
-----------------------------------------------------------

Current element:

    v = 2

Using 2:

    sum 2 becomes possible.

Since sum 4 was already possible:

    sum 4 remains possible.

Also:

    4 + 2 = 6

Therefore sum 6 becomes possible.

-----------------------------------------------------------
PROCESS ELEMENT 7
-----------------------------------------------------------

Current element:

    v = 7

Using 7:

    sum 7 becomes possible.

Using previously possible sums:

    7 + 2 = 9
    7 + 4 = 11

But 11 is greater than the target 10.

Therefore:

    7 and 9 become possible.

-----------------------------------------------------------
PROCESS ELEMENT 1
-----------------------------------------------------------

Current element:

    v = 1

Previously possible:

    9

Therefore:

    9 + 1 = 10

So:

    curr[10] = true

The target sum 10 can now be formed.

One possible subset is:

    4 + 2 + 1 + 3

The algorithm continues processing the remaining
element 3, but once the final row is constructed,
sum 10 remains possible.

Final result:

    true

===========================================================
KEY POINTS
===========================================================

1. This is a 0/1 subset problem.

   Every element can either be:

       included

   or

       excluded

   but cannot be used multiple times.

2. The DP state answers a YES/NO question.

   Therefore we use:

       boolean

   instead of:

       int

3. prev[] represents the previous DP row.

4. curr[] represents the current DP row.

5. clone() is important.

       prev = curr.clone();

   creates an independent copy.

   If we wrote:

       prev = curr;

   both variables would refer to the same array.

6. The algorithm reduces space from:

       O(n × sum)

   to:

       O(sum)

===========================================================
SPECIAL NOTES ABOUT DP ARRAY
===========================================================

In the original 2D DP solution:

    dp[i][j]

means:

    Can we form sum j using the first i elements?

For example:

    dp[3][7]

means:

    Can we form sum 7 using the first 3 elements?

In this optimized version, we remove the first dimension
from storage.

Instead:

    prev[j]

represents the previous row.

    curr[j]

represents the current row.

Therefore:

    prev[j]

means the answer before considering the current element.

    curr[j]

means the answer after considering the current element.

===========================================================
SPECIAL NOTES ABOUT i AND i - 1
===========================================================

The outer loop uses:

    i = 1

through:

    i = n

because the DP conceptually contains n + 1 rows.

Rows represent:

    i = 0 -> using 0 elements
    i = 1 -> using 1 element
    i = 2 -> using 2 elements
    ...
    i = n -> using all n elements

However, the Java array is 0-indexed.

Therefore:

    arr[0] -> first element
    arr[1] -> second element
    arr[2] -> third element

So when:

    i = 1

the current element must be:

    arr[0]

When:

    i = 2

the current element must be:

    arr[1]

Therefore:

    arr[i - 1]

is used.

This is why:

    int v = arr[i - 1];

is necessary.

===========================================================
SPECIAL NOTES ABOUT WHY THE OUTER LOOP STARTS FROM 1
===========================================================

The loop is:

    for(int i = 1; i < n + 1; i++)

There are two important reasons.

-----------------------------------------------------------
REASON 1: i = 0 REPRESENTS THE BASE CASE
-----------------------------------------------------------

In the original 2D DP table:

    dp[0][0] = true

This represents:

    Using 0 elements, we can form sum 0.

For positive sums:

    dp[0][j] = false

because no elements are available to form a positive sum.

In the optimized version, this base-case row is represented
by:

    prev[0] = true

Therefore, we do not need to process i = 0.

The first actual element is processed when:

    i = 1

-----------------------------------------------------------
REASON 2: i REPRESENTS THE NUMBER OF ELEMENTS PROCESSED
-----------------------------------------------------------

The value of i is not directly an array index.

Instead:

    i = 1 -> process first element
    i = 2 -> process second element
    i = 3 -> process third element

But Java array indexes start from 0.

Therefore:

    arr[i - 1]

is used to access the correct element.

===========================================================
SPECIAL NOTES ABOUT WHY THE OUTER LOOP USES i < n + 1
===========================================================

The condition:

    i < n + 1

is equivalent to:

    i <= n

because:

    i < n + 1

means:

    i <= n

So the loop processes:

    i = 1, 2, 3, ..., n

This means every element of the array is processed exactly once.

For example, if:

    n = 5

then:

    for(int i = 1; i < n + 1; i++)

becomes:

    for(int i = 1; i < 6; i++)

Therefore i becomes:

    1, 2, 3, 4, 5

These correspond to:

    arr[0]
    arr[1]
    arr[2]
    arr[3]
    arr[4]

===========================================================
SPECIAL NOTES ABOUT WHY THE INNER LOOP STARTS FROM 1
===========================================================

The inner loop is:

    for(int j = 1; j < sum + 1; j++)

Here j represents the target sum currently being checked.

We start from:

    j = 1

because target sum 0 is already handled by the base case:

    prev[0] = true

There is no need to repeatedly calculate sum 0.

For example:

    j = 1 -> check whether sum 1 is possible
    j = 2 -> check whether sum 2 is possible
    j = 3 -> check whether sum 3 is possible
    ...
    j = sum -> check target sum

===========================================================
SPECIAL NOTES ABOUT WHY THE INNER LOOP USES j < sum + 1
===========================================================

The condition:

    j < sum + 1

is equivalent to:

    j <= sum

Therefore the loop processes:

    j = 1, 2, 3, ..., sum

If:

    sum = 10

then:

    for(int j = 1; j < sum + 1; j++)

becomes:

    for(int j = 1; j < 11; j++)

Therefore j becomes:

    1, 2, 3, 4, 5, 6, 7, 8, 9, 10

So the target sum 10 is included.

If we wrote:

    j < sum

then j would stop at:

    sum - 1

and the actual target sum would never be checked.

===========================================================
SPECIAL NOTES ABOUT n + 1 AND sum + 1
===========================================================

The expressions:

    n + 1

and:

    sum + 1

come from the structure of the original DP table.

The original 2D DP table has:

    n + 1 rows
    sum + 1 columns

Why?

Because we need to represent:

    0 elements through n elements

and:

    sum 0 through sum

Therefore:

    rows    = n + 1
    columns = sum + 1

Even though DP13 stores only two rows, the same indexing
logic from the 2D DP solution is preserved.

===========================================================
SPECIAL NOTES ABOUT curr[] RESET
===========================================================

One important improvement should be made to the current code.

Since curr[] is reused for every iteration of i, it should
be reset before processing the next element.

Otherwise, true values from the previous current row can
remain inside curr[].

Therefore, before the inner loop, we should use:

    Arrays.fill(curr, false);

This ensures curr[] represents only the current row.

The required import is:

    import java.util.Arrays;

===========================================================
TIME COMPLEXITY
===========================================================

There are:

    n

elements.

For every element, we check:

    sum

possible target values.

Therefore:

    Time Complexity = O(n × sum)

===========================================================
SPACE COMPLEXITY
===========================================================

We use only two arrays:

    prev[sum + 1]
    curr[sum + 1]

Therefore:

    Space Complexity = O(sum)

This is an improvement over the normal 2D DP solution:

    O(n × sum)

===========================================================
SPECIAL NOTES
===========================================================

1. DP13 is a space-optimized version of Target Sum Subset.

2. The original 2D DP uses:

       dp[n + 1][sum + 1]

3. DP13 uses:

       prev[sum + 1]
       curr[sum + 1]

4. The outer loop starts at 1 because row 0 represents
   the base case.

5. The inner loop starts at 1 because target 0 is already
   initialized using:

       prev[0] = true

6. n + 1 and sum + 1 are used because the DP conceptually
   includes index 0.

7. i represents the number of elements being considered,
   while arr[i - 1] accesses the actual Java array element.

8. j represents the current target sum.

9. prev[j - v] represents the include case.

10. prev[j] represents the exclude case.

11. clone() creates an independent copy of curr[].

12. curr[] should be reset before each new outer-loop
    iteration because the same array is reused.

13. The final answer is:

       prev[sum]

14. The solution runs in:

       O(n × sum) time

    and uses:

       O(sum) space.

===========================================================
*/

import java.util.Arrays;

public class DP13 {

  public static boolean targetSumSubsetOpt(int arr[], int sum) {

    // Number of elements in the array.
    int n = arr.length;

    // curr[] represents the current row of the original 2D DP table.
    boolean curr[] = new boolean[sum + 1];

    // prev[] represents the previous row of the original 2D DP table.
    boolean prev[] = new boolean[sum + 1];

    // Sum 0 is always possible using an empty subset.
    prev[0] = true;

    // i represents the number of elements being considered.
    // i starts from 1 because row 0 is the base case.
    // i <= n is written as i < n + 1.
    for(int i = 1; i < n + 1; i++) {

      // Reset curr[] because the same array is reused for every row.
      Arrays.fill(curr, false);

      // j represents the target sum currently being checked.
      // j starts from 1 because sum 0 is already handled by prev[0].
      for(int j = 1; j < sum + 1; j++) {

        // arr is 0-indexed, while i represents the 1-based DP row.
        // Therefore, arr[i - 1] gives the current element.
        int v = arr[i - 1];

        // Include the current element if its value does not exceed j
        // and the remaining sum j - v was possible in the previous row.
        if(v <= j && prev[j - v]) {
          curr[j] = true;
        }

        // Exclude the current element if j was already possible
        // using the elements from the previous row.
        if(prev[j]) {
          curr[j] = true;
        }
      }

      // Move the current row into prev for the next element.
      // clone() creates an independent copy of curr[].
      prev = curr.clone();
    }

    // After all elements are processed, prev represents the final row.
    // prev[sum] tells whether the target sum can be formed.
    return prev[sum];
  }

  public static void main(String[] args) {

    // Array containing the available elements.
    int arr[] = {4, 2, 7, 1, 3};

    // Target sum that we want to form.
    int sum = 10;

    // Calculate and print whether the target sum is possible.
    System.out.println(targetSumSubsetOpt(arr, sum));
  }
}