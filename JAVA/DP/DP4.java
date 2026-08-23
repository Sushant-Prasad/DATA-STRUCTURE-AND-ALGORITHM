package DP;

/*
====================================================================
                 DYNAMIC PROGRAMMING (DP)
====================================================================

TOPICS COVERED:

    1. Which DP approach is more efficient?
    2. Memoization vs Tabulation
    3. Top-Down vs Bottom-Up
    4. Why DP improves recursion
    5. Seven important DP concepts / patterns
    6. How to identify each pattern
    7. Important examples under each pattern


====================================================================
                    PART 1 — WAYS OF DP
====================================================================

There are two major ways to implement Dynamic Programming:

    1. MEMOIZATION  → TOP-DOWN
    2. TABULATION   → BOTTOM-UP


--------------------------------------------------------------------
                    1. MEMOIZATION
--------------------------------------------------------------------

Memoization is a Top-Down DP approach.

The idea is:

    Start with the main/final problem
              ↓
        Use recursion
              ↓
       Reach smaller states
              ↓
       Calculate the answer
              ↓
       Store the answer
              ↓
       Reuse it if needed


Example:

    fibonacci(5)

The recursion starts from:

    F(5)

and moves toward smaller problems:

    F(5)
      ↓
    F(4), F(3)
      ↓
    smaller states


IMPORTANT:

Memoization is basically:

    RECURSION + STORAGE


The storage is usually a:

    1D DP array
    2D DP array
    HashMap
    or another suitable data structure.


--------------------------------------------------------------------
                    2. TABULATION
--------------------------------------------------------------------

Tabulation is a Bottom-Up DP approach.

The idea is:

    Start with the smallest/base cases
              ↓
       Calculate next state
              ↓
       Calculate next state
              ↓
       Continue upward
              ↓
       Reach the final answer


Example:

    Fibonacci:

        F(0) = 0
        F(1) = 1

        F(2) = F(1) + F(0)
        F(3) = F(2) + F(1)
        F(4) = F(3) + F(2)
        ...


IMPORTANT:

Tabulation is basically:

    ITERATION + DP TABLE


Usually, a loop is used instead of recursion.


====================================================================
             PART 2 — WHICH ONE IS MORE EFFICIENT?
====================================================================

There is NO universally more efficient approach.

For the same DP problem, Memoization and Tabulation often have
the SAME Big-O time complexity.

For example, Fibonacci:

    Normal Recursion:
        Time → O(2^n)

    Memoization:
        Time → O(n)

    Tabulation:
        Time → O(n)


Therefore:

    Memoization → O(n)
    Tabulation  → O(n)

Both are much better than the simple recursive solution.


--------------------------------------------------------------------
                    THEN WHICH ONE IS BETTER?
--------------------------------------------------------------------

It depends on the problem.

TABULATION is often preferred when:

    - Most/all DP states need to be calculated.
    - The order of states is easy to determine.
    - We want to avoid recursion.
    - We want to avoid recursion-stack overhead.
    - We want easier space optimization.

MEMOIZATION is often preferred when:

    - The problem naturally follows recursion.
    - The recursive solution is easy to derive.
    - Only some states may actually be required.
    - We want to convert an existing recursive solution
      into DP quickly.


IMPORTANT:

    Tabulation is NOT always more efficient.

A problem may have many possible states, but the final answer
may require only a small subset of those states.

In that situation:

    Memoization can avoid calculating unnecessary states.


====================================================================
                 PART 3 — FIBONACCI EXAMPLE
====================================================================

We will use Fibonacci to understand both approaches.

Fibonacci:

    0, 1, 1, 2, 3, 5, 8, 13, ...

Formula:

    F(n) = F(n - 1) + F(n - 2)

Base cases:

    F(0) = 0
    F(1) = 1


The important observation is:

    F(5)
       |
       +-------------+
       |             |
      F(4)          F(3)
      /  \          /  \
    F(3) F(2)     F(2) F(1)


Notice:

    F(3) is repeated.
    F(2) is repeated.

Therefore:

    OVERLAPPING SUBPROBLEMS


Instead of calculating the same state repeatedly:

    Calculate once
          ↓
    Store the answer
          ↓
    Reuse the answer


This is the main idea behind DP.


====================================================================
                  PART 4 — MEMOIZATION
====================================================================

Memoization = Top-Down DP

The DP array stores answers of already solved states.

For Fibonacci:

    dp[n]

means:

    Fibonacci value of n.

For example:

    dp[5] = 5


The basic algorithm is:

    1. Check base case.
    2. Check whether answer is already stored.
    3. If stored → return it.
    4. Otherwise calculate the smaller states.
    5. Store the result.
    6. Return the result.


--------------------------------------------------------------------
                    JAVA CODE
--------------------------------------------------------------------
*/

public class DP4 {

    /*
    ================================================================
                     FIBONACCI — MEMOIZATION
    ================================================================

    This is a Top-Down DP solution.

    The recursive function starts from the required state and
    moves toward smaller states.

    Example:

        fibonacci(5)

    calls:

        fibonacci(4)
        fibonacci(3)

    and so on.

    The DP array prevents repeated calculations.
    */

    static int fibonacciMemoization(int n, int[] dp) {

        /*
        ------------------------------------------------------------
                            BASE CASE
        ------------------------------------------------------------

        Fibonacci has two base cases:

            F(0) = 0
            F(1) = 1
        */

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }


        /*
        ------------------------------------------------------------
                    CHECK IF STATE IS ALREADY SOLVED
        ------------------------------------------------------------

        -1 means:

            "This state has not been calculated yet."

        If dp[n] is not -1, then we already calculated F(n).

        Therefore, return the stored result.

        This is how Memoization removes repeated calculations.
        */

        if (dp[n] != -1) {
            return dp[n];
        }


        /*
        ------------------------------------------------------------
                         STATE TRANSITION
        ------------------------------------------------------------

        Fibonacci formula:

            F(n) = F(n - 1) + F(n - 2)

        Therefore:

            dp[n] = dp[n - 1] + dp[n - 2]

        We recursively calculate the smaller states.
        */

        int first = fibonacciMemoization(n - 1, dp);

        int second = fibonacciMemoization(n - 2, dp);


        /*
        ------------------------------------------------------------
                         STORE THE ANSWER
        ------------------------------------------------------------

        Store the result in dp[n].

        If F(n) is required again later, we can directly return
        dp[n] instead of calculating it again.
        */

        dp[n] = first + second;

        return dp[n];
    }


    /*
    ================================================================
                     FIBONACCI — TABULATION
    ================================================================

    This is a Bottom-Up DP solution.

    Instead of starting from F(n), we start from the base cases:

        F(0)
        F(1)

    Then build:

        F(2)
        F(3)
        F(4)
        ...
        F(n)

    No recursion is required.
    */

    static int fibonacciTabulation(int n) {

        /*
        ------------------------------------------------------------
                         HANDLE BASE CASE
        ------------------------------------------------------------
        */

        if (n == 0) {
            return 0;
        }


        /*
        ------------------------------------------------------------
                         CREATE DP TABLE
        ------------------------------------------------------------

        dp[i] represents:

            Fibonacci value of i.
        */

        int[] dp = new int[n + 1];


        /*
        ------------------------------------------------------------
                            BASE CASES
        ------------------------------------------------------------
        */

        dp[0] = 0;
        dp[1] = 1;


        /*
        ------------------------------------------------------------
                      BUILD DP TABLE BOTTOM-UP
        ------------------------------------------------------------

        Formula:

            dp[i] = dp[i - 1] + dp[i - 2]

        Execution:

            dp[2] = dp[1] + dp[0]
            dp[3] = dp[2] + dp[1]
            dp[4] = dp[3] + dp[2]
            ...

        Finally:

            dp[n] = answer
        */

        for (int i = 2; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


    /*
    ================================================================
                    SPACE-OPTIMIZED DP
    ================================================================

    In Fibonacci, dp[i] only depends on:

        dp[i - 1]
        dp[i - 2]

    Therefore, we do not actually need the complete DP array.

    We only need two variables.

    Normal Tabulation:

        Space → O(n)

    Space Optimized:

        Space → O(1)

    Time remains:

        O(n)
    */

    static int fibonacciSpaceOptimized(int n) {

        if (n == 0) {
            return 0;
        }

        /*
        previous = F(n - 2)
        current  = F(n - 1)
        */

        int previous = 0;
        int current = 1;


        /*
        ------------------------------------------------------------
                        BUILD NEXT VALUE
        ------------------------------------------------------------

        next = previous + current

        Then move the variables forward.
        */

        for (int i = 2; i <= n; i++) {

            int next = previous + current;

            previous = current;
            current = next;
        }

        return current;
    }


    public static void main(String[] args) {

        int n = 10;


        /*
        ============================================================
                       MEMOIZATION CALL
        ============================================================

        Create the DP array.

        Java initializes an int array with 0.

        But 0 is a valid Fibonacci answer.

        Therefore, we use -1 to represent:

            "Not calculated yet."
        */

        int[] dp = new int[n + 1];

        java.util.Arrays.fill(dp, -1);

        int memoizationAnswer =
                fibonacciMemoization(n, dp);


        /*
        ============================================================
                       TABULATION CALL
        ============================================================
        */

        int tabulationAnswer =
                fibonacciTabulation(n);


        /*
        ============================================================
                    SPACE-OPTIMIZED CALL
        ============================================================
        */

        int optimizedAnswer =
                fibonacciSpaceOptimized(n);


        /*
        ============================================================
                            OUTPUT
        ============================================================
        */

        System.out.println("Memoization = " + memoizationAnswer);
        // Output: Memoization = 55

        System.out.println("Tabulation = " + tabulationAnswer);
        // Output: Tabulation = 55

        System.out.println("Space Optimized = " + optimizedAnswer);
        // Output: Space Optimized = 55
    }
}


/*
====================================================================
              PART 5 — MEMOIZATION VS TABULATION
====================================================================

MEMOIZATION
------------

    Type:
        Top-Down

    Uses:
        Recursion + DP storage

    Starts from:
        Required/final state

    Recursion stack:
        YES

    Time:
        Usually O(number of states × transition cost)

    Advantage:
        Can avoid calculating states that are never required.

    Disadvantage:
        Uses recursion stack and has function-call overhead.


TABULATION
----------

    Type:
        Bottom-Up

    Uses:
        Iteration + DP table

    Starts from:
        Base states

    Recursion stack:
        NO

    Time:
        Usually O(number of states × transition cost)

    Advantage:
        No recursion stack and often easier to optimize.

    Disadvantage:
        May calculate states that are not actually needed.


SPACE-OPTIMIZED TABULATION
--------------------------

    If the current state depends only on a few previous states,
    we may not need the complete DP table.

    Example:

        Fibonacci:

            dp[i] depends only on:
                dp[i - 1]
                dp[i - 2]

    Therefore:

        Space → O(1)


====================================================================
                       FINAL COMPARISON
====================================================================

| Feature              | Memoization       | Tabulation       |
|----------------------|-------------------|------------------|
| Approach             | Top-Down          | Bottom-Up        |
| Uses recursion       | Yes               | No               |
| Uses DP table        | Yes               | Yes              |
| Starts from          | Final state       | Base states      |
| Call stack            | Yes               | No               |
| Time complexity      | Usually same      | Usually same     |
| Unnecessary states   | Can skip          | May calculate    |
| Easy from recursion  | Yes               | Requires order   |
| Stack overflow risk  | Possible          | No recursion     |
| Space optimization   | Sometimes         | Often easier     |


====================================================================
                    WHICH ONE SHOULD YOU USE?
====================================================================

There is no universal winner.

Use MEMOIZATION when:

    Recursive thinking is natural
    AND
    You may not need every state.

Use TABULATION when:

    The order of states is clear
    AND
    Most states are required
    AND
    You want to avoid recursion.

Use SPACE OPTIMIZATION when:

    The current state depends only on a limited number of
    previous states.


IMPORTANT:

    First learn:

        Recursion
            ↓
        Memoization
            ↓
        Tabulation
            ↓
        Space Optimization

This progression makes DP much easier to understand.


====================================================================
              PART 6 — SEVEN IMPORTANT DP PATTERNS
====================================================================

The seven major patterns shown in the reference material are:

    1. Fibonacci
    2. 0/1 Knapsack
    3. Unbounded Knapsack
    4. LCS (Longest Common Subsequence)
    5. Kadane's Algorithm
    6. Catalan Number
    7. DP on Grid (2D Arrays)


====================================================================
                  PATTERN 1 — FIBONACCI
====================================================================

MAIN IDEA:

    Current state depends on previous states.

Typical recurrence:

    dp[i] = dp[i - 1] + dp[i - 2]


IMPORTANT PROBLEMS:

    1. Fibonacci
    2. Climbing Stairs
    3. Number Factors
    4. Minimum Jumps to Reach the End
    5. Minimum Jumps with Cost
    6. House Thief / House Robber


HOW TO IDENTIFY:

Look for a problem where the current answer depends on a small
number of previous states.

Typical structure:

        dp[i]
        /   \
    dp[i-1] dp[i-2]


====================================================================
                  PATTERN 2 — 0/1 KNAPSACK
====================================================================

MAIN IDEA:

Every item can be selected:

    0 times
    OR
    1 time

The item cannot be selected repeatedly.

The major decision is:

              ITEM
             /    \
          TAKE    DON'T TAKE


IMPORTANT PROBLEMS:

    1. 0/1 Knapsack
    2. Subset Sum
    3. Equal Subset Sum Partition
    4. Minimum Subset Sum Difference
    5. Count of Subset Sum
    6. Target Sum


IMPORTANT CLUE:

    TAKE
      OR
    DON'T TAKE

and each item can generally be used only once.


====================================================================
               PATTERN 3 — UNBOUNDED KNAPSACK
====================================================================

MAIN IDEA:

An item can be selected multiple times.

Difference:

    0/1 Knapsack:
        Item → maximum once

    Unbounded Knapsack:
        Item → unlimited times


IMPORTANT PROBLEMS:

    1. Rod Cutting
    2. Coin Change
    3. Minimum Coin Change
    4. Maximum Ribbon Cut


IMPORTANT CLUE:

Words such as:

    Unlimited
    Repeatedly
    Infinite supply
    Can use multiple times

are strong signals for the Unbounded Knapsack family.


====================================================================
                 PATTERN 4 — LCS
              LONGEST COMMON SUBSEQUENCE
====================================================================

LCS is commonly used when comparing TWO sequences/strings.

SUBSEQUENCE means:

    Elements maintain their relative order,
    but they do not need to be adjacent.

Example:

    "ABCDE"

    "ACE"

is a subsequence.


MAIN IDEA:

Compare two elements/characters.

If they match:

    Use the match.

If they don't match:

    Consider skipping one side.


IMPORTANT PROBLEMS:

    1. Longest Common Subsequence
    2. Longest Common Substring
    3. Edit Distance
    4. Box Stacking
    5. Longest Increasing Subsequence
    6. Longest Bitonic Subsequence
    7. Subsequence Pattern Matching
    8. Minimum Add/Delete to Convert One String to Another


IMPORTANT CLUE:

    TWO STRINGS / TWO SEQUENCES
              +
       COMPARE ELEMENTS
              +
         MATCH / SKIP

Think about the LCS family.


====================================================================
                PATTERN 5 — KADANE'S ALGORITHM
====================================================================

Kadane's Algorithm is commonly used to find:

    Maximum Sum Subarray

The important word is:

    SUBARRAY

A subarray must be:

    CONTIGUOUS


MAIN DECISION:

At every element:

    Continue the current subarray

                    OR

    Start a new subarray


Typical transition:

    currentSum =
        max(array[i],
            currentSum + array[i])


IMPORTANT CLUE:

    Maximum
      +
    Sum
      +
    Contiguous Subarray

Think:

    Kadane's Algorithm


IMPORTANT NOTE:

Kadane's algorithm is closely related to DP because the best
subarray ending at the current position depends on the previous
state.

It can be implemented with:

    Time  → O(n)
    Space → O(1)


====================================================================
                  PATTERN 6 — CATALAN NUMBER
====================================================================

Catalan numbers occur in many counting/combinatorial problems.

Catalan sequence:

    1, 1, 2, 5, 14, 42, ...


The recurrence is:

    C(n) =
        Σ [ C(i) × C(n - 1 - i) ]

for:

    i = 0 to n - 1


IMPORTANT PROBLEMS:

    1. Number of BSTs
    2. Number of valid parenthesizations
    3. Convex Polygons
    4. Disjoint Chords
    5. Catalan Triangulation
    6. Mountain Ranges
    7. Dyck Words


IMPORTANT CLUE:

When a counting problem asks for the number of valid structures
and the problem can be divided around a particular position,
Catalan numbers may be involved.


====================================================================
                    PATTERN 7 — GRID DP
====================================================================

Grid DP is used when the problem is represented as:

    2D Array
    Matrix
    Grid


Example:

        [ ][ ][ ]
        [ ][ ][ ]
        [ ][ ][ ]


A cell generally depends on neighboring cells.

For example, if movement is:

    RIGHT
    DOWN

then:

                 Current
                 /     \
              DOWN     RIGHT


A common state is:

    dp[i][j]

which represents the answer for cell:

    (i, j)


IMPORTANT PROBLEMS:

    1. Unique Paths
    2. Minimum Path Sum
    3. Maximum Path problems
    4. Grid traversal/counting problems


COMMON TRANSITION FOR COUNTING:

    dp[i][j] =
        dp[i - 1][j] + dp[i][j - 1]


COMMON TRANSITION FOR MINIMUM COST:

    dp[i][j] =
        grid[i][j]
        +
        min(
            dp[i - 1][j],
            dp[i][j - 1]
        )


IMPORTANT CLUE:

    2D Grid
       +
    Restricted Movement
       +
    Count / Minimum / Maximum

Think:

    GRID DP


====================================================================
                SEVEN PATTERNS — QUICK SUMMARY
====================================================================

1. FIBONACCI
   -------------------------------------------------------------
   Pattern:
       Previous states

   Typical:
       dp[i - 1], dp[i - 2]

   Examples:
       Fibonacci
       Climbing Stairs
       House Robber


2. 0/1 KNAPSACK
   -------------------------------------------------------------
   Pattern:
       TAKE / DON'T TAKE

   Item:
       Used at most once

   Examples:
       Subset Sum
       Equal Partition
       Target Sum


3. UNBOUNDED KNAPSACK
   -------------------------------------------------------------
   Pattern:
       TAKE / DON'T TAKE

   Item:
       Can be reused

   Examples:
       Coin Change
       Rod Cutting


4. LCS
   -------------------------------------------------------------
   Pattern:
       MATCH / SKIP

   Input:
       Two strings/sequences

   Examples:
       LCS
       Edit Distance


5. KADANE
   -------------------------------------------------------------
   Pattern:
       CONTINUE / RESTART

   Input:
       Array

   Goal:
       Maximum contiguous subarray sum


6. CATALAN
   -------------------------------------------------------------
   Pattern:
       SPLIT + COMBINE

   Goal:
       Count valid structures

   Examples:
       BSTs
       Parenthesization
       Polygon triangulation


7. GRID DP
   -------------------------------------------------------------
   Pattern:
       MOVE BETWEEN STATES

   Input:
       2D Grid

   Examples:
       Unique Paths
       Minimum Path Sum


====================================================================
             HOW TO IDENTIFY THE DP PATTERN
====================================================================

When you receive a new DSA problem, ask:

    QUESTION 1:

    Is the problem based on previous states?

        → Fibonacci pattern


    QUESTION 2:

    Do I have:

        TAKE / DON'T TAKE

    and each item can be used only once?

        → 0/1 Knapsack


    QUESTION 3:

    Do I have:

        TAKE / DON'T TAKE

    but items can be reused?

        → Unbounded Knapsack


    QUESTION 4:

    Am I comparing two strings/sequences?

        → LCS family


    QUESTION 5:

    Am I finding the maximum sum of a contiguous subarray?

        → Kadane's Algorithm


    QUESTION 6:

    Am I counting valid structures formed by splitting a
    problem into left and right parts?

        → Catalan


    QUESTION 7:

    Is the problem represented using a 2D grid/matrix?

        → Grid DP


====================================================================
                    IMPORTANT DP FORMULA
====================================================================

Do NOT memorize the formula first.

For every DP problem, identify:

    1. STATE
    2. CHOICES
    3. BASE CASE
    4. STATE TRANSITION
    5. OVERLAPPING SUBPROBLEMS
    6. OPTIMAL SUBSTRUCTURE
    7. DP APPROACH


The general thought process is:

            PROBLEM
               ↓
        Find smaller problem
               ↓
          Identify state
               ↓
        Identify choices
               ↓
        Write recurrence
               ↓
         Check repeated states
               ↓
        Apply Memoization
               ↓
        Convert to Tabulation
               ↓
       Optimize the space if possible


====================================================================
                         KEY POINTS
====================================================================

1. DP has two major approaches:

       Memoization
       Tabulation

2. Memoization is Top-Down DP.

3. Tabulation is Bottom-Up DP.

4. Neither is universally more efficient.

5. Both can have the same Big-O time complexity.

6. Memoization can avoid calculating states that are never
   required.

7. Tabulation avoids recursion and recursion-stack usage.

8. Tabulation is often easier to space-optimize.

9. Memoization is often easier to derive directly from a
   recursive solution.

10. Fibonacci is the basic DP pattern.

11. 0/1 Knapsack follows TAKE / DON'T TAKE.

12. Unbounded Knapsack allows repeated use of items.

13. LCS deals with two sequences/strings and often uses
    MATCH / SKIP decisions.

14. Kadane's Algorithm deals with maximum contiguous
    subarray sum.

15. Catalan problems commonly involve counting valid structures.

16. Grid DP generally works with 2D states such as dp[i][j].

17. The most important DP skill is identifying the state and
    transition rather than memorizing formulas.


====================================================================
                     QUICK MEMORY TRICK
====================================================================

Remember the seven patterns:

    F → Fibonacci
        Previous states

    K → 0/1 Knapsack
        Take / Don't Take

    U → Unbounded Knapsack
        Take / Don't Take + Reuse

    L → LCS
        Match / Skip

    K → Kadane
        Continue / Restart

    C → Catalan
        Split / Combine

    G → Grid
        Neighboring cells


The overall DP journey:

    RECURSION
        ↓
    OVERLAPPING SUBPROBLEMS
        ↓
    MEMOIZATION
        ↓
    TABULATION
        ↓
    SPACE OPTIMIZATION


====================================================================
                  FINAL TAKEAWAY
====================================================================

Do not think:

    "I need to memorize 7 DP formulas."

Instead think:

    "Which pattern does this problem follow?"

Then identify:

    STATE
      ↓
    CHOICES
      ↓
    TRANSITION
      ↓
    BASE CASE
      ↓
    REPEATED STATES
      ↓
    DP

That is the core skill required to solve Dynamic Programming
problems.
*/
