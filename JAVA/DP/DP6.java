package DP;

import java.util.Arrays;

/*
===========================================================
TITLE
===========================================================
Climbing Stairs Using Dynamic Programming (Memoization)

===========================================================
PROBLEM STATEMENT
===========================================================
You are climbing a staircase with `n` steps.

You can climb either:
• 1 step at a time
• 2 steps at a time

Your task is to find the total number of distinct ways to
reach the top of the staircase.

Since the recursive solution recalculates the same
subproblems multiple times, optimize it using
**Dynamic Programming (Memoization).**

Input:
• int n → number of stairs

Output:
• int → total number of distinct ways

Constraints:
• 0 ≤ n ≤ 45

Edge Cases:
• n = 0 → 1 way (already at the top)
• n = 1 → 1 way
• n < 0 → 0 ways (invalid path)

===========================================================
PROBLEM RESOURCE
===========================================================
• https://leetcode.com/problems/climbing-stairs/

===========================================================
INTUITION
===========================================================
The recursive relation is:

    ways(n) = ways(n-1) + ways(n-2)

The problem contains **overlapping subproblems**.

Example:
climbStairs(5) repeatedly calculates:
• climbStairs(3)
• climbStairs(2)
• climbStairs(1)

Instead of solving them again and again, store the
result in a DP array and reuse it whenever needed.

This technique is called **Memoization (Top-Down DP).**

===========================================================
APPROACH (TOP-DOWN DP / MEMOIZATION)
===========================================================
1) Create a DP array of size (n + 1).
2) Initialize every element with -1.
3) Base Cases:
   • n == 0 → return 1
   • n < 0 → return 0
4) Before solving a state, check:
      if(dp[n] != -1)
         return dp[n];
5) Otherwise calculate:
      dp[n] = ways(n-1) + ways(n-2)
6) Store the answer in dp[] and return it.

===========================================================
EXAMPLE
===========================================================
Input:
n = 5

Output:
8

Ways:
1+1+1+1+1
1+1+1+2
1+1+2+1
1+2+1+1
2+1+1+1
1+2+2
2+1+2
2+2+1

===========================================================
DRY RUN
===========================================================
Input:
n = 5

Initial DP Array:
[-1, -1, -1, -1, -1, -1]

Call:
climbStairsMemo(5)

Step 1:
Compute dp[2]
dp[2] = 2

DP:
[-1, -1, 2, -1, -1, -1]

Step 2:
Compute dp[3]
dp[3] = 3

DP:
[-1, -1, 2, 3, -1, -1]

Step 3:
Compute dp[4]
dp[4] = 5

DP:
[-1, -1, 2, 3, 5, -1]

Step 4:
Compute dp[5]
dp[5] = 8

Final DP Array:
[-1, -1, 2, 3, 5, 8]

Return:
8

===========================================================
KEY POINTS
===========================================================
• Memoization = Recursion + Caching
• Each subproblem is solved only once
• Eliminates repeated recursive calls
• Much faster than normal recursion
• Uses Top-Down approach

Comparison:

Normal Recursion:
• Time → O(2^n)

Memoization:
• Time → O(n)

Tabulation:
• Time → O(n)
• No recursion used

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
• Every state (0 to n) is computed only once.
• After computation, values are directly returned
  from the DP array.

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)

Breakdown:
• DP Array → O(n)
• Recursive Call Stack → O(n)

Total Auxiliary Space = O(n)

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Always initialize DP array with -1.
• -1 indicates that the state has not been computed.
• Do NOT use 0 for initialization because 0 can be
  a valid answer in many DP problems.
• Memoization is called **Top-Down DP** because the
  solution starts from the main problem and breaks
  it into smaller subproblems.
• This approach is ideal when recursion is easy to
  write but repeated calculations need to be avoided.
===========================================================
*/

public class DP6 {

  /*
   * Returns the total number of ways to climb n stairs
   * using Dynamic Programming (Memoization).
   */
  public static int climbStairsMemo(int n, int[] dp) {

    // Base Case:
    // Reached exactly the top.
    if (n == 0)return 1;

    // Base Case:
    // Invalid path.
    if (n < 0)return 0;

    // If already calculated, return stored answer.
    if (dp[n] != -1)return dp[n];

    // Compute and store the answer.
    dp[n] = climbStairsMemo(n - 1, dp) + climbStairsMemo(n - 2, dp);

    return dp[n];
  }

  public static void main(String[] args) {

    int n = 5;

    // DP array to store computed answers.
    int[] dp = new int[n + 1];

    // Initialize all values as "not calculated".
    Arrays.fill(dp, -1);

    System.out.println("Total number of ways using Memoization: " + climbStairsMemo(n, dp));
  }
}