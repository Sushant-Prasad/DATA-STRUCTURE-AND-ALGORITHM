package DP;

/*
===========================================================
TITLE
===========================================================
Fibonacci using Dynamic Programming (Memoization - Top Down)

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
• 0 ≤ n ≤ 45 (to avoid integer overflow in int)
• For larger n, long or BigInteger should be used

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
• Recursive solution recomputes same values repeatedly
• Example:
     fib(5) calls fib(4) and fib(3)
     fib(4) again calls fib(3)
• This causes exponential time complexity

Dynamic Programming solves this by:
• Storing already computed values
• Reusing stored results instead of recomputing

===========================================================
APPROACH (TOP-DOWN DP / MEMOIZATION)
===========================================================
1) Create dp[] array of size n+1
2) Base cases:
     if n == 0 or n == 1 → return n
3) Before computing fib(n):
     check if dp[n] already calculated
4) If not:
     compute fib(n-1) + fib(n-2)
     store result in dp[n]
5) Return dp[n]

===========================================================
EXAMPLE
===========================================================
Input:
n = 5

Output:
5

Fibonacci Series:
0 1 1 2 3 5

===========================================================
DRY RUN
===========================================================
Call fib(5)

fib(5)
→ fib(4) + fib(3)

fib(4)
→ fib(3) + fib(2)

fib(3)
→ fib(2) + fib(1)

fib(2)
→ fib(1) + fib(0)
→ 1 + 0 = 1   (store dp[2] = 1)

fib(3)
→ dp[2] + 1
→ 1 + 1 = 2   (store dp[3] = 2)

fib(4)
→ dp[3] + dp[2]
→ 2 + 1 = 3   (store dp[4] = 3)

fib(5)
→ dp[4] + dp[3]
→ 3 + 2 = 5   (store dp[5] = 5)

Final Answer = 5

===========================================================
KEY POINTS
===========================================================
• Memoization avoids repeated calculations
• Converts exponential recursion O(2^n)
  into linear time O(n)
• dp[] array stores intermediate results
• Base case is crucial
• Works when problem has:
   - Overlapping subproblems
   - Optimal substructure

Alternative Approaches:
• Bottom-up DP (Tabulation)
• Space optimized iterative approach

===========================================================
TIME COMPLEXITY
===========================================================
Best Case: O(n)
Average Case: O(n)
Worst Case: O(n)

Justification:
• Each Fibonacci value computed only once
• dp[] prevents repeated recursion

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
• dp array
• Recursion stack depth up to n

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• dp[n] != 0 check works because Fibonacci
  values (except F(0)) are positive
• For problems where valid result can be 0,
  use dp initialized with -1
• Top-down DP = recursion + memoization
• Bottom-up DP = iterative tabulation
===========================================================
*/

public class DP1 {

    /*
     * Returns nth Fibonacci number using memoization
     */
    public static int fib(int n, int dp[]) {

        // Base case
        if (n == 0 || n == 1)
            return n;

        // If already computed, return stored value
        if (dp[n] != 0) {
            return dp[n];
        }

        // Compute and store result
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5;

        // DP array to store computed Fibonacci values
        int dp[] = new int[n + 1];

        System.out.println(fib(n, dp));
    }
}