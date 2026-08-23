package DP;
/*
============================================================
                    DYNAMIC PROGRAMMING
============================================================

Dynamic Programming (DP) is an algorithmic technique used
to solve problems by solving smaller subproblems and storing
their results so that the same subproblem does not need to
be solved repeatedly.

DP is commonly useful when a problem has:

    1. OVERLAPPING SUBPROBLEMS
    2. OPTIMAL SUBSTRUCTURE

A simple way to remember DP:

    Solve → Store → Reuse


IMPORTANT:

DP is often called "optimized recursion" because a recursive
solution can be optimized by storing the answers of repeated
subproblems.

However:

    Recursion != DP

DP can be implemented using:

    1. Memoization  → Top-Down DP
    2. Tabulation   → Bottom-Up DP
*/


public class DP3 {

    /*
    ============================================================
                    OVERLAPPING SUBPROBLEMS
    ============================================================

    A problem has overlapping subproblems when the same
    smaller problem is solved multiple times.

    Example:

        Fibonacci:

            F(n) = F(n - 1) + F(n - 2)

        F(5)
          |
          +---- F(4)
          |      |
          |      +---- F(3)
          |             |
          |             +---- F(2)
          |
          +---- F(3)
                 |
                 +---- F(2)

    Notice:

        F(3) appears multiple times.
        F(2) appears multiple times.

    Therefore, the same subproblems are being calculated again.

    This is called:

        OVERLAPPING SUBPROBLEMS

    DP solves this problem by storing the result of a
    subproblem after calculating it.
    */


    /*
    ============================================================
                    OPTIMAL SUBSTRUCTURE
    ============================================================

    A problem has optimal substructure when the optimal
    solution of a bigger problem can be constructed using
    optimal solutions of smaller subproblems.

    Simple idea:

        BIG PROBLEM
             ↓
        Smaller Problems
             ↓
        Best smaller answers
             ↓
        Best overall answer

    For example, if a problem asks for the minimum cost,
    the minimum solution for the larger state can often be
    constructed using minimum solutions of smaller states.

    NOTE:

    "Optimal problem" is a useful clue for identifying DP,
    but not every DP problem is necessarily an optimization
    problem.

    DP can also be used for:

        - Counting
        - Decision / Feasibility
        - Computing values
    */


    /*
    ============================================================
                    FIBONACCI RECURSION
    ============================================================

    Fibonacci sequence:

        0, 1, 1, 2, 3, 5, 8, 13, ...

    Formula:

        F(n) = F(n - 1) + F(n - 2)

    Base cases:

        F(0) = 0
        F(1) = 1

    ------------------------------------------------------------

    The recursive solution is:

        fibonacci(n)
            |
            +---- fibonacci(n - 1)
            |
            +---- fibonacci(n - 2)

    There are two branches at every non-base state.

    This creates a recursion tree.

    Because many states are repeated, the recursive solution
    performs unnecessary calculations.

    Time Complexity:

        O(2^n)

    This is where DP can improve the solution.
    */


    /*
    ============================================================
                    DP STATE
    ============================================================

    A DP STATE represents one smaller subproblem.

    For Fibonacci:

        dp[n]

    represents:

        The Fibonacci value of n.

    Therefore:

        dp[0] = F(0)
        dp[1] = F(1)
        dp[2] = F(2)
        ...

    The state is simply:

        n


    ============================================================
                    STATE TRANSITION
    ============================================================

    Fibonacci formula:

        F(n) = F(n - 1) + F(n - 2)

    Therefore:

        dp[n] = dp[n - 1] + dp[n - 2]

    This formula tells us how to calculate the current
    state using previously calculated states.
    */


    /*
    ============================================================
                    MEMOIZATION
    ============================================================

    Memoization is:

        TOP-DOWN DYNAMIC PROGRAMMING

    It uses:

        Recursion + DP Array

    General process:

        1. Call the recursive function.
        2. Check whether the answer is already stored.
        3. If stored, return it.
        4. Otherwise calculate the answer.
        5. Store the answer.
        6. Return the answer.

    ------------------------------------------------------------

    DP ARRAY:

        dp[n]

    Initially:

        -1 = answer has not been calculated.

    Example:

        dp = [-1, -1, -1, -1, -1]

    After calculation:

        dp = [0, 1, 1, 2, 3]

    Now if F(3) is required again:

        Do NOT calculate it again.

        Simply return:

            dp[3]

    ------------------------------------------------------------

    TIME COMPLEXITY:

        Each state is calculated only once.

        Number of states = n

        Therefore:

            O(n)

    SPACE COMPLEXITY:

        DP array       → O(n)
        Recursion stack → O(n)

        Overall:

            O(n)
    */


    static int fibonacci(int n, int[] dp) {

        /*
        ========================================================
                        BASE CASE
        ========================================================

        These are the smallest known Fibonacci values.

            F(0) = 0
            F(1) = 1

        The recursion stops here.
        */

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }


        /*
        ========================================================
                    CHECK OVERLAPPING SUBPROBLEM
        ========================================================

        If dp[n] already contains an answer, then this state
        has already been solved.

        Therefore, we reuse the stored answer.

        This is the main idea behind MEMOIZATION.
        */

        if (dp[n] != -1) {

            return dp[n];
        }


        /*
        ========================================================
                        STATE TRANSITION
        ========================================================

        Fibonacci formula:

            F(n) = F(n - 1) + F(n - 2)

        Therefore:

            dp[n] = dp[n - 1] + dp[n - 2]

        But instead of directly using dp[n - 1] and dp[n - 2],
        we recursively calculate them if they are not already
        stored.
        */

        int previous = fibonacci(n - 1, dp);

        int beforePrevious = fibonacci(n - 2, dp);


        /*
        ========================================================
                    STORE THE CALCULATED ANSWER
        ========================================================

        We have now calculated:

            F(n - 1)
            F(n - 2)

        Therefore:

            F(n) = F(n - 1) + F(n - 2)

        Store the result in dp[n].

        This prevents the same state from being calculated
        repeatedly.
        */

        dp[n] = previous + beforePrevious;


        /*
        Return the calculated and stored answer.
        */

        return dp[n];
    }


    /*
    ============================================================
                    MAIN METHOD
    ============================================================

    Program execution starts from:

        main()
    */

    public static void main(String[] args) {

        /*
        ========================================================
                            INPUT
        ========================================================
        */

        int n = 7;


        /*
        ========================================================
                        CREATE DP ARRAY
        ========================================================

        We need n + 1 positions because we need:

            dp[0] ... dp[n]

        For n = 7:

            dp = [-1, -1, -1, -1, -1, -1, -1, -1]

        -1 means:

            "This state has not been calculated yet."

        Arrays.fill() is used to fill every position with -1.

        Since Arrays belongs to java.util package, we can either
        import it or use the fully qualified class name.
        */

        int[] dp = new int[n + 1];

        java.util.Arrays.fill(dp, -1);


        /*
        ========================================================
                        CALL MEMOIZED FUNCTION
        ========================================================

        We start with:

            fibonacci(7)

        The function recursively solves smaller states.

        Whenever a state has already been solved, its stored
        answer is reused.
        */

        int answer = fibonacci(n, dp);


        /*
        ========================================================
                            OUTPUT
        ========================================================
        */

        System.out.println("Fibonacci = " + answer);

        // Output:
        // Fibonacci = 13
    }
}