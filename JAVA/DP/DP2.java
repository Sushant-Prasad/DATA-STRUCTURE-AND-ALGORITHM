package DP;

/*
===========================================================
TITLE
===========================================================
Fibonacci using Dynamic Programming (Tabulation - Bottom Up)

===========================================================
PROBLEM STATEMENT
===========================================================
Given an integer n, compute the nth Fibonacci number.

Fibonacci sequence:
F(0) = 0
F(1) = 1
F(n) = F(n-1) + F(n-2)  for n ≥ 2

Input:
• int n

Output:
• nth Fibonacci number

Constraints:
• 0 ≤ n ≤ 45 (for int safety)
• For larger n, use long or BigInteger

Edge Cases:
• n = 0 → return 0
• n = 1 → return 1

===========================================================
PROBLEM RESOURCE
===========================================================
• https://leetcode.com/problems/fibonacci-number/

===========================================================
INTUITION
===========================================================
• Fibonacci has overlapping subproblems
• Instead of recursion, build solution from base cases upward
• Start from smallest values and compute larger values step-by-step
• Avoid recursion overhead and stack space

===========================================================
APPROACH (BOTTOM-UP DP / TABULATION)
===========================================================
1) Create dp[] array of size n+1
2) Initialize base cases:
     dp[0] = 0
     dp[1] = 1
3) Iterate from i = 2 to n:
     dp[i] = dp[i-1] + dp[i-2]
4) Return dp[n]

===========================================================
EXAMPLE
===========================================================
Input:
n = 5

Computation:
dp[0] = 0
dp[1] = 1
dp[2] = 1
dp[3] = 2
dp[4] = 3
dp[5] = 5

Output:
5

===========================================================
DRY RUN
===========================================================
n = 5

Initial dp:
[0, 1, 0, 0, 0, 0]

i = 2 → dp[2] = dp[1] + dp[0] = 1
[0, 1, 1, 0, 0, 0]

i = 3 → dp[3] = dp[2] + dp[1] = 2
[0, 1, 1, 2, 0, 0]

i = 4 → dp[4] = dp[3] + dp[2] = 3
[0, 1, 1, 2, 3, 0]

i = 5 → dp[5] = dp[4] + dp[3] = 5
[0, 1, 1, 2, 3, 5]

Return dp[5] = 5

===========================================================
KEY POINTS
===========================================================
• Tabulation builds solution from smallest subproblems
• No recursion → no stack overhead
• Generally faster than memoization in practice
• Requires knowledge of dependency order
• Works when smaller states are known before larger ones

Comparison:
Memoization (Top-Down):
   - Recursion + cache
   - Easier to write for complex problems
Tabulation (Bottom-Up):
   - Iterative
   - More efficient in most cases

===========================================================
TIME COMPLEXITY
===========================================================
Best Case: O(n)
Average Case: O(n)
Worst Case: O(n)

Justification:
• Single loop from 2 to n

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
• dp array of size n+1

Note:
Can be optimized to O(1) space using two variables

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Base cases must be initialized before loop
• Loop must start from 2
• Ensure dp array size is n+1
• This is iterative DP (no recursion)
• Space optimization possible:
     Use two variables instead of full array
===========================================================
*/

public class DP2 {

    /*
     * Returns nth Fibonacci number using tabulation
     */
    public static int fib(int n, int dp[]) {

        // Base cases
        dp[0] = 0;
        dp[1] = 1;

        // Build solution bottom-up
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5;

        // DP array for storing computed values
        int dp[] = new int[n + 1];

        System.out.println(fib(n, dp));
    }
}