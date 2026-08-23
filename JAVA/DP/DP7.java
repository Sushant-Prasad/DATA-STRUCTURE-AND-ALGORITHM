package DP;

/*
===========================================================
TITLE
===========================================================
Climbing Stairs Using Dynamic Programming (Tabulation)

===========================================================
PROBLEM STATEMENT
===========================================================
You are climbing a staircase with `n` steps.

You can climb either:
• 1 step at a time
• 2 steps at a time

Find the total number of distinct ways to reach the top.

Input:
• int n → number of stairs

Output:
• int → total number of ways to reach the nth stair

Constraints:
• 0 ≤ n ≤ 45

Edge Cases:
• n = 0 → 1 way
• n = 1 → 1 way
• n = 2 → 2 ways

===========================================================
PROBLEM RESOURCE
===========================================================
• https://leetcode.com/problems/climbing-stairs/

===========================================================
INTUITION
===========================================================
To reach stair `i`, there are two possible ways:

1. Reach stair `i - 1` and take 1 step.
2. Reach stair `i - 2` and take 2 steps.

Therefore:

    dp[i] = dp[i - 1] + dp[i - 2]

For `i = 1`, we cannot access `dp[i - 2]` because
that would mean accessing `dp[-1]`.

So we handle `i = 1` separately.

===========================================================
APPROACH
===========================================================
1) Create a DP array of size `n + 1`.
2) Set:
      dp[0] = 1
   because there is one way to reach the starting position:
   take no steps.
3) Traverse from `i = 1` to `n`.
4) If `i == 1`:
      dp[1] = dp[0]
   because there is only one way to reach stair 1.
5) Otherwise:
      dp[i] = dp[i - 1] + dp[i - 2]
6) Return dp[n].

===========================================================
EXAMPLE
===========================================================
Input:
n = 5

DP calculation:

dp[0] = 1
dp[1] = 1
dp[2] = 2
dp[3] = 3
dp[4] = 5
dp[5] = 8

Output:
8

===========================================================
DRY RUN
===========================================================
For n = 5:

Initial:
dp = [1, 0, 0, 0, 0, 0]

i = 1:
i == 1
dp[1] = dp[0] = 1

dp = [1, 1, 0, 0, 0, 0]

i = 2:
dp[2] = dp[1] + dp[0]
      = 1 + 1
      = 2

dp = [1, 1, 2, 0, 0, 0]

i = 3:
dp[3] = dp[2] + dp[1]
      = 2 + 1
      = 3

dp = [1, 1, 2, 3, 0, 0]

i = 4:
dp[4] = dp[3] + dp[2]
      = 3 + 2
      = 5

dp = [1, 1, 2, 3, 5, 0]

i = 5:
dp[5] = dp[4] + dp[3]
      = 5 + 3
      = 8

Final:
dp = [1, 1, 2, 3, 5, 8]

Answer:
dp[5] = 8

===========================================================
KEY POINTS
===========================================================
• This is Bottom-Up Dynamic Programming.
• Tabulation uses iteration instead of recursion.
• dp[i] stores the number of ways to reach stair `i`.
• dp[0] = 1 represents one way to stay at the starting point.
• `i == 1` must be handled separately because dp[i - 2]
  would become dp[-1].
• After i >= 2, the standard recurrence can be used.

Comparison:
• Recursion → O(2^n) time
• Memoization → O(n) time, O(n) space
• Tabulation → O(n) time, O(n) space
• Space Optimized DP → O(n) time, O(1) space

===========================================================
TIME COMPLEXITY
===========================================================
Best Case:
O(n)

Average Case:
O(n)

Worst Case:
O(n)

Justification:
• The loop runs from 1 to n.
• Each iteration performs constant-time operations.
• Therefore, total time complexity is O(n).

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)

• DP array contains n + 1 elements.
• No recursion stack is used.

Auxiliary Space:
O(n)

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• `dp[0] = 1` is important for correctly calculating dp[1].
• The special `i == 1` condition prevents accessing dp[-1].
• For n = 0, the loop does not execute and dp[0] = 1 is returned.
• This implementation safely handles n = 0 without accessing dp[1].
• The DP array can later be optimized to O(1) space because
  each state only depends on the previous two states.
===========================================================
*/

public class DP7 {

  /*
   * Returns the total number of ways to climb n stairs
   * using Dynamic Programming (Tabulation).
   */
  public static int climbStairsTab(int n) {

    // DP array stores the number of ways to reach each stair.
    int[] dp = new int[n + 1];

    // Base case: one way to reach the starting position.
    dp[0] = 1;

    // Build the DP table from stair 1 to stair n.
    for (int i = 1; i <= n; i++) {

      // Stair 1 can only be reached by taking one step.
      if (i == 1) {
        dp[i] = dp[i - 1];
      } else {

        // For other stairs, take either 1 step or 2 steps.
        dp[i] = dp[i - 1] + dp[i - 2];
      }
    }

    // Return the number of ways to reach the nth stair.
    return dp[n];
  }

  public static void main(String[] args) {

    int n = 0;

    System.out.println("Total number of ways using Tabulation: " + climbStairsTab(n));
  }
}