package DP;

/*
===========================================================
TITLE
===========================================================

DP19 - Longest Common Subsequence (LCS) Using Memoization


===========================================================
PROBLEM STATEMENT
===========================================================

Given two strings s1 and s2, find the length of their
Longest Common Subsequence (LCS).

A subsequence is a sequence that can be obtained by deleting
some characters from a string without changing the relative
order of the remaining characters.

The characters of a subsequence do not need to be continuous.

For example:

    String = "abcde"

    "ace" is a subsequence.

But:

    "aec"

is not a subsequence because the relative order of the
characters has changed.


-------------------------
Input
-------------------------

Two strings:

    s1
    s2

Example:

    s1 = "abcdge"
    s2 = "abedg"


-------------------------
Output
-------------------------

Return the length of the Longest Common Subsequence.

For:

    s1 = "abcdge"
    s2 = "abedg"

One LCS is:

    "abdg"

Therefore:

    Output = 4


-------------------------
Constraints
-------------------------

    1. s1 and s2 can have different lengths.

    2. The strings can contain multiple characters.

    3. The DP table contains a state for every combination
       of prefixes of the two strings.


-------------------------
Edge Cases
-------------------------

    1. If n == 0, the LCS length is 0.

    2. If m == 0, the LCS length is 0.

    3. If both strings are empty, the LCS length is 0.

    4. If the current characters are equal, they are included
       in the LCS.

    5. If the current characters are different, both possible
       choices are considered.


===========================================================
PROBLEM RESOURCE
===========================================================

Longest Common Subsequence:

https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1


===========================================================
INTUITION
===========================================================

We compare the last characters of the currently considered
parts of the two strings.

The function:

    lcsMemo(s1, s2, n, m, dp)

represents the LCS length between:

    First n characters of s1

and:

    First m characters of s2


There are two main cases.


-----------------------------------------------------------
CASE 1: Characters are equal
-----------------------------------------------------------

If:

    s1.charAt(n - 1) == s2.charAt(m - 1)

then the current character can be included in the LCS.

Therefore:

    LCS = 1 + LCS of the remaining characters

So:

    dp[n][m] =
        lcsMemo(n - 1, m - 1) + 1


Both n and m decrease because both matching characters have
already been included.


-----------------------------------------------------------
CASE 2: Characters are different
-----------------------------------------------------------

If:

    s1.charAt(n - 1) != s2.charAt(m - 1)

then both characters cannot be included together.

We have two possibilities:

    1. Ignore the last character of s2.

       lcsMemo(n, m - 1)


    2. Ignore the last character of s1.

       lcsMemo(n - 1, m)


We calculate both possibilities and take the maximum.


===========================================================
APPROACH
===========================================================

This solution uses:

    Recursion + Memoization


The recursive solution breaks the problem into smaller
subproblems.

However, the same subproblem can occur multiple times.

To avoid recalculating the same state, we store its answer
inside:

    dp[n][m]


The process is:

    1. Check the base case.

    2. Check whether dp[n][m] has already been calculated.

    3. If it has been calculated, return the stored answer.

    4. Compare the current characters.

    5. If they are equal:
           Store 1 + smaller LCS result.

    6. If they are different:
           Store the maximum of the two possible results.

    7. Return dp[n][m].


===========================================================
DP STATE
===========================================================

The state is:

    dp[n][m]


It represents:

    The length of the LCS between the first n characters
    of s1 and the first m characters of s2.


For example:

    dp[4][3]

means:

    LCS of the first 4 characters of s1
    and the first 3 characters of s2.


The DP table therefore has:

    (s1.length() + 1)
    x
    (s2.length() + 1)

states.


===========================================================
DP TABLE INITIALIZATION
===========================================================

The DP table is created using:

    int dp[][] = new int[s1.length() + 1][s2.length() + 1];


The +1 is required because we also need states where:

    n = 0

or:

    m = 0


For:

    s1 = "abcdge"
    s2 = "abedg"

we have:

    s1.length() = 6
    s2.length() = 5

Therefore:

    dp = new int[7][6]


The indexes are:

    Rows    -> 0 to 6
    Columns -> 0 to 5


===========================================================
WHY INITIALIZE WITH -1?
===========================================================

Java automatically initializes an int array with:

    0


However, 0 is a valid LCS answer.

For example:

    LCS("", "abc") = 0


Therefore, we cannot use 0 to represent:

    "State has not been calculated."


Instead, every state is initialized with:

    -1


The meaning becomes:

    -1 -> State not calculated yet.

     0 -> State calculated and LCS length is 0.

     1 -> State calculated and LCS length is 1.

     2 -> State calculated and LCS length is 2.

    ...


===========================================================
EXAMPLE
===========================================================

Given:

    s1 = "abcdge"
    s2 = "abedg"


The strings are:

    s1 = a b c d g e
         0 1 2 3 4 5

    s2 = a b e d g
         0 1 2 3 4


One Longest Common Subsequence is:

    a b d g

Therefore:

    LCS length = 4


The DP table initially contains -1 for every state.

Conceptually:

          m ->  0   1   2   3   4   5

      n
      0        -1  -1  -1  -1  -1  -1
      1        -1  -1  -1  -1  -1  -1
      2        -1  -1  -1  -1  -1  -1
      3        -1  -1  -1  -1  -1  -1
      4        -1  -1  -1  -1  -1  -1
      5        -1  -1  -1  -1  -1  -1
      6        -1  -1  -1  -1  -1  -1


===========================================================
DRY RUN
===========================================================

Initial function call:

    lcsMemo(
        "abcdge",
        "abedg",
        6,
        5,
        dp
    )


-----------------------------------------------------------
Step 1
-----------------------------------------------------------

Current characters:

    s1.charAt(6 - 1)
    = s1.charAt(5)
    = 'e'


    s2.charAt(5 - 1)
    = s2.charAt(4)
    = 'g'


They are different.

Therefore:

    dp[6][5] =
        max(
            lcsMemo(6, 4),
            lcsMemo(5, 5)
        )


-----------------------------------------------------------
Step 2
-----------------------------------------------------------

The recursion continues by reducing either n or m.

Whenever two current characters are equal, the function
reduces both n and m.

For example:

    'd' == 'd'


Then:

    dp[n][m] =
        lcsMemo(n - 1, m - 1, dp) + 1


The matching character contributes:

    +1


Similarly:

    'g' == 'g'

also contributes:

    +1


Eventually, the recursion finds the common subsequence:

    "abdg"

Therefore:

    LCS length = 4


===========================================================
MEMOIZATION WORKING
===========================================================

Suppose a particular state is calculated:

    dp[3][2] = 2


Later, another recursive path needs the same state:

    lcsMemo(s1, s2, 3, 2, dp)


The function first checks:

    if(dp[3][2] != -1)


Since:

    dp[3][2] = 2

the condition is true.

Therefore:

    return dp[3][2];


The state does not need to be calculated again.

This avoids repeated recursive work.


===========================================================
KEY POINTS
===========================================================

1. LCS stands for Longest Common Subsequence.

2. A subsequence does not have to be continuous.

3. The relative order of characters must remain unchanged.

4. The state:

       dp[n][m]

   represents the LCS length between the first n characters
   of s1 and the first m characters of s2.

5. -1 means that the state has not been calculated yet.

6. If dp[n][m] is not -1, its stored answer is returned.

7. If the current characters match:

       dp[n][m] =
           lcsMemo(n - 1, m - 1, dp) + 1

8. If the current characters do not match:

       dp[n][m] =
           Math.max(
               lcsMemo(n, m - 1, dp),
               lcsMemo(n - 1, m, dp)
           )

9. Memoization prevents the same state from being solved
   repeatedly.

10. There are approximately:

        n * m

    different states.


===========================================================
SPECIAL NOTES ABOUT DP ARRAY
===========================================================

The DP array is:

    int dp[][]


Its dimensions are:

    [s1.length() + 1][s2.length() + 1]


The first dimension represents the number of characters
considered from s1.

The second dimension represents the number of characters
considered from s2.


Therefore:

    dp[n][m]

stores the LCS answer for the current state.


-----------------------------------------------------------
Why -1?
-----------------------------------------------------------

The DP table is initialized with -1 because 0 is a valid
answer.

Therefore:

    -1 -> Not calculated

     0 -> Calculated LCS length is 0

    >0 -> Calculated LCS length is positive


===========================================================
SPECIAL NOTES ABOUT n AND m
===========================================================

Here:

    n = number of characters currently considered from s1

    m = number of characters currently considered from s2


They represent the size of the current subproblem.

They are not direct Java String indexes.


For example:

    n = 6

means:

    Consider the first 6 characters of s1.


The last character among those 6 characters is located at:

    index = n - 1


Therefore:

    s1.charAt(n - 1)


Similarly:

    s2.charAt(m - 1)


===========================================================
SPECIAL NOTES ABOUT n - 1 AND m - 1
===========================================================

Java uses 0-based indexing.

Therefore:

    s1.charAt(n - 1)

gets the last character among the first n characters.

Similarly:

    s2.charAt(m - 1)


When the characters match:

    n - 1
    m - 1

are passed to the recursive call because both current
characters have been included in the LCS.


When the characters are different, only one value decreases
at a time:

    lcsMemo(n, m - 1, dp)

or:

    lcsMemo(n - 1, m, dp)


This represents ignoring one of the two current characters.


===========================================================
SPECIAL NOTES ABOUT THE BASE CASE
===========================================================

The base condition is:

    if(m == 0 || n == 0) return 0;


If n becomes 0, there are no characters left from s1.

If m becomes 0, there are no characters left from s2.

In either situation, a common subsequence cannot contain any
characters.

Therefore:

    LCS = 0


===========================================================
SPECIAL NOTES ABOUT MATCHING CHARACTERS
===========================================================

When:

    s1.charAt(n - 1) == s2.charAt(m - 1)


the character is common to both strings.

Therefore, it contributes 1 to the LCS.

The remaining problem becomes:

    lcsMemo(n - 1, m - 1, dp)


So:

    dp[n][m] =
        lcsMemo(n - 1, m - 1, dp) + 1


The result is stored in dp[n][m] so that it can be reused
later.


===========================================================
SPECIAL NOTES ABOUT NON-MATCHING CHARACTERS
===========================================================

When:

    s1.charAt(n - 1) != s2.charAt(m - 1)


we cannot directly include both characters.

Therefore, we consider two possibilities.


OPTION 1:

Remove the last character of s2:

    lcsMemo(n, m - 1, dp)


OPTION 2:

Remove the last character of s1:

    lcsMemo(n - 1, m, dp)


Then:

    dp[n][m] =
        Math.max(option1, option2)


The larger result represents the longer common subsequence.


===========================================================
SPECIAL NOTES ABOUT MEMOIZATION CHECK
===========================================================

This statement is the key part of memoization:

    if(dp[n][m] != -1) return dp[n][m];


Initially:

    dp[n][m] = -1


Therefore, the state must be calculated.

After calculating the state:

    dp[n][m] = answer


If the same state is encountered again:

    dp[n][m] != -1


Therefore, the stored answer is returned immediately.


This prevents unnecessary recalculation.


===========================================================
SPECIAL NOTES ABOUT DP TABLE INITIALIZATION
===========================================================

The nested loops initialize every state:

    for(int i = 0; i < dp.length; i++)

and:

    for(int j = 0; j < dp[0].length; j++)


For every combination of i and j:

    dp[i][j] = -1;


This means every state initially has the status:

    "Not calculated yet."


The base cases where n == 0 or m == 0 do not need to be
explicitly stored as 0 because the recursive function directly
returns 0 when it reaches them.


===========================================================
TIME COMPLEXITY
===========================================================

There are:

    (n + 1) * (m + 1)

possible states.

Each state is calculated at most once because of memoization.

The work performed for each state is O(1), apart from
recursive calls that are themselves memoized.

Therefore:

    Time Complexity = O(n * m)


===========================================================
SPACE COMPLEXITY
===========================================================

The DP table requires:

    O(n * m)

space.

The recursive calls also use the call stack.

The maximum recursion depth is approximately:

    O(n + m)


Therefore, the total space can be represented as:

    O(n * m) + O(n + m)


The dominant term is:

    O(n * m)


Therefore:

    Space Complexity = O(n * m)


===========================================================
SPECIAL NOTES
===========================================================

1. This solution uses TOP-DOWN Dynamic Programming.

2. Memoization stores the result of each calculated state.

3. dp[n][m] represents the LCS length for the first n
   characters of s1 and the first m characters of s2.

4. -1 represents an uncalculated state.

5. If the characters match, both n and m decrease.

6. If the characters do not match, either n or m decreases.

7. The matching recurrence is:

       1 + lcsMemo(n - 1, m - 1, dp)

8. The non-matching recurrence is:

       Math.max(
           lcsMemo(n, m - 1, dp),
           lcsMemo(n - 1, m, dp)
       )

9. The final function call uses:

       n = s1.length()
       m = s2.length()

10. The final returned value is the LCS length.

11. Time Complexity:

        O(n * m)

12. Space Complexity:

        O(n * m)

*/


public class DP19 {

  public static int lcsMemo(String s1, String s2, int n, int m, int dp[][]) {

    // Base case: if either string has no characters left, LCS is 0.
    if (m == 0 || n == 0) return 0;

    /*
     * Check whether the current state has already been calculated.
     *
     * A value other than -1 means that the answer is already
     * stored in dp[n][m], so no further recursive calculation
     * is required for this state.
     */
    if (dp[n][m] != -1) return dp[n][m];

    /*
     * If the current characters are equal, include the matching
     * character in the LCS.
     *
     * Both n and m are reduced because both current characters
     * have been included.
     */
    if (s1.charAt(n - 1) == s2.charAt(m - 1)) {

      /*
       * Calculate the LCS of the remaining characters and add 1
       * for the current matching character.
       *
       * Store the result in dp[n][m] so that the same state can
       * be reused without recalculating it.
       */
      dp[n][m] = lcsMemo(s1, s2, n - 1, m - 1, dp) + 1;

      // Return the calculated and stored result.
      return dp[n][m];

    } else {

      /*
       * The current characters are different, so we consider
       * two possibilities:
       *
       * 1. Ignore the last character of s2.
       * 2. Ignore the last character of s1.
       *
       * The larger result gives the longest common subsequence.
       */
      dp[n][m] = Math.max(
          lcsMemo(s1, s2, n, m - 1, dp),
          lcsMemo(s1, s2, n - 1, m, dp)
      );

      // Return the calculated and stored result.
      return dp[n][m];
    }
  }

  public static void main(String[] args) {

    // First input string.
    String s1 = "abcdge";

    // Second input string.
    String s2 = "abedg";

    /*
     * Create the memoization table.
     *
     * One extra row and one extra column are required to
     * represent states where n == 0 or m == 0.
     */
    int dp[][] = new int[s1.length() + 1][s2.length() + 1];

    /*
     * Java initializes integer arrays with 0.
     *
     * Since 0 is a valid LCS result, we use -1 to represent
     * a state that has not been calculated yet.
     */
    for (int i = 0; i < dp.length; i++) {

      for (int j = 0; j < dp[0].length; j++) {

        // Mark the current state as not calculated.
        dp[i][j] = -1;
      }
    }

    /*
     * Start the recursive memoization process using the complete
     * lengths of both strings.
     *
     * s1.length() represents n.
     * s2.length() represents m.
     */
    System.out.println(lcsMemo(s1, s2, s1.length(), s2.length(), dp));
  }
}