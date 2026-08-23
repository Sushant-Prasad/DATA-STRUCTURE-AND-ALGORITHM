package DP;

/*
===========================================================
TITLE
===========================================================
Climbing Stairs Using Recursion

===========================================================
PROBLEM STATEMENT
===========================================================
You are climbing a staircase with `n` steps.

You can climb either:
• 1 step at a time
• 2 steps at a time

Your task is to find the total number of distinct ways to reach
the top of the staircase.

Input:
• int n → number of stairs

Output:
• int → total number of distinct ways to reach the nth stair

Constraints:
• 0 ≤ n ≤ 45

Edge Cases:
• n = 0 → 1 way (do nothing)
• n = 1 → 1 way
• n = 2 → 2 ways: (1+1), (2)

===========================================================
PROBLEM RESOURCE
===========================================================
• https://leetcode.com/problems/climbing-stairs/

===========================================================
INTUITION
===========================================================
To reach stair `n`, the last move can only be:

1) A 1-step move:
   → We must have been at stair `n-1`

2) A 2-step move:
   → We must have been at stair `n-2`

Therefore:

    ways(n) = ways(n-1) + ways(n-2)

This is the same recurrence as Fibonacci.

The recursive solution directly follows this relationship.

===========================================================
APPROACH
===========================================================
1) If n == 0:
   - Return 1
   - There is one valid way: take no steps

2) If n < 0:
   - Return 0
   - This represents an invalid path

3) Otherwise:
   - Calculate ways by taking 1 step:
       climbStairs(n - 1)
   - Calculate ways by taking 2 steps:
       climbStairs(n - 2)
   - Add both results

Formula:

    climbStairs(n)
    = climbStairs(n-1) + climbStairs(n-2)

===========================================================
EXAMPLE
===========================================================
Input:
n = 5

Possible ways:

1 + 1 + 1 + 1 + 1
1 + 1 + 1 + 2
1 + 1 + 2 + 1
1 + 2 + 1 + 1
2 + 1 + 1 + 1
1 + 2 + 2
2 + 1 + 2
2 + 2 + 1

Total ways = 8

Output:
8

===========================================================
DRY RUN
===========================================================
For n = 3:

climbStairs(3)
→ climbStairs(2) + climbStairs(1)

climbStairs(2)
→ climbStairs(1) + climbStairs(0)
→ 1 + 1
→ 2

climbStairs(1)
→ 1

Therefore:

climbStairs(3)
→ 2 + 1
→ 3

Output:
3

For n = 5:

climbStairs(5)
→ climbStairs(4) + climbStairs(3)

climbStairs(4)
→ climbStairs(3) + climbStairs(2)

climbStairs(3)
→ climbStairs(2) + climbStairs(1)

Repeated subproblems such as:
• climbStairs(3)
• climbStairs(2)
• climbStairs(1)

are calculated multiple times.

This repeated work is why the basic recursive solution
has exponential time complexity.

===========================================================
KEY POINTS
===========================================================
• This problem has the same recurrence as Fibonacci
• Each stair can be reached from either n-1 or n-2
• `n == 0` returns 1 because reaching exactly the top is
  considered one valid way
• `n < 0` returns 0 because such a path is invalid

Important DP Observation:
• This recursive solution contains overlapping subproblems
• The same values are calculated repeatedly
• Therefore, this problem can be optimized using Dynamic Programming

Better Approaches:
• Memoization → O(n) time, O(n) space
• Tabulation → O(n) time, O(n) space
• Space optimized DP → O(n) time, O(1) space

===========================================================
TIME COMPLEXITY
===========================================================
Best Case:
O(1)
• For n = 0 or n = 1, recursion stops immediately

Average Case:
O(2^n)

Worst Case:
O(2^n)

Justification:
• Each call creates up to two recursive calls
• Many subproblems are calculated repeatedly
• The recursion tree grows exponentially

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)

• No additional data structure is used
• Recursion call stack can reach depth `n`
• Therefore, auxiliary stack space is O(n)

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• `n == 0` must return 1, not 0
• Returning 1 for n == 0 allows valid combinations to be
  counted correctly
• `n < 0` represents an invalid path and returns 0
• This recursive solution is useful for understanding the
  recurrence but is inefficient for large n
• Memoization can eliminate repeated calculations
• The recurrence is:

      f(n) = f(n-1) + f(n-2)

• This is essentially the Fibonacci pattern shifted by one position
===========================================================
*/

public class DP5 {

    /*
     * Recursive function to calculate the number of ways
     * to climb n stairs.
     */
    public static int climbStairs(int n) {

        // Base case:
        // Reaching exactly 0 stairs means one valid way.
        if (n == 0)
            return 1;

        // Base case:
        // Negative stairs represent an invalid path.
        if (n < 0)
            return 0;

        // Two choices:
        // 1. Take one step
        // 2. Take two steps
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {

        int n = 5;

        // Calculate and print total number of ways
        System.out.println("Total number of ways : " + climbStairs(n));
    }
}