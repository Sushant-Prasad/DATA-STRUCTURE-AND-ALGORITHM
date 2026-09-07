package DP;

/*
===========================================================
TITLE
===========================================================

DP20 - Longest Common Subsequence (LCS) Using Tabulation


===========================================================
PROBLEM STATEMENT
===========================================================

Given two strings s1 and s2, find the length of their
Longest Common Subsequence (LCS).

A subsequence is a sequence that can be obtained by deleting
zero or more characters from a string without changing the
relative order of the remaining characters.

The characters in a subsequence do not need to be continuous.

For example:

    String = "abcde"

Valid subsequences:

    "ace"
    "abd"
    "abcde"

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

One Longest Common Subsequence is:

    "abdg"

Therefore:

    Output = 4


-------------------------
Constraints
-------------------------

    1. s1 and s2 can have different lengths.

    2. Both strings can contain multiple characters.

    3. The DP table contains a state for every combination
       of prefixes of the two strings.


-------------------------
Edge Cases
-------------------------

    1. If either string is empty, LCS length = 0.

    2. If both strings are empty, LCS length = 0.

    3. If the current characters are equal, include the
       character in the LCS.

    4. If the current characters are different, consider
       both possible choices.


===========================================================
PROBLEM RESOURCE
===========================================================

Longest Common Subsequence:

https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1


===========================================================
INTUITION
===========================================================

We compare characters from both strings and build the answer
from smaller subproblems.

Instead of solving the problem recursively, we create a
2D DP table.

Each cell stores the LCS length for a particular pair of
prefixes of the two strings.

The table is filled from smaller subproblems to larger
subproblems.

This is called:

    TABULATION

or:

    BOTTOM-UP DYNAMIC PROGRAMMING


===========================================================
DP STATE
===========================================================

The DP state is:

    dp[i][j]


It represents:

    The length of the LCS between the first i characters
    of s1 and the first j characters of s2.


For example:

    dp[4][3]

means:

    LCS of the first 4 characters of s1
    and the first 3 characters of s2.


The complete table has:

    (n + 1) x (m + 1)

cells.


===========================================================
APPROACH
===========================================================

We create:

    int dp[][] = new int[n + 1][m + 1];


The rows represent prefixes of s1.

The columns represent prefixes of s2.


We then fill the table from:

    i = 1 to n

and:

    j = 1 to m


For every cell dp[i][j], compare:

    s1.charAt(i - 1)
    s2.charAt(j - 1)


There are two cases.


-----------------------------------------------------------
CASE 1: Characters are equal
-----------------------------------------------------------

If:

    s1.charAt(i - 1) == s2.charAt(j - 1)

then the current character is common to both strings.

Therefore, it contributes 1 to the LCS.

The remaining problem is:

    dp[i - 1][j - 1]


So:

    dp[i][j] = dp[i - 1][j - 1] + 1


-----------------------------------------------------------
CASE 2: Characters are different
-----------------------------------------------------------

If:

    s1.charAt(i - 1) != s2.charAt(j - 1)

then both current characters cannot be included together.

We consider two possibilities:

    1. Ignore the current character of s1.

       dp[i - 1][j]


    2. Ignore the current character of s2.

       dp[i][j - 1]


Take the maximum:

    dp[i][j] =
        Math.max(
            dp[i - 1][j],
            dp[i][j - 1]
        )


===========================================================
BASE CASE
===========================================================

If:

    i = 0

then s1 contains zero characters.

There cannot be a common subsequence containing any
characters.

Therefore:

    dp[0][j] = 0


Similarly, if:

    j = 0

then s2 contains zero characters.

Therefore:

    dp[i][0] = 0


Java automatically initializes an int array with 0.

The code explicitly represents these base cases using:

    dp[i][0] = 0
    dp[0][i] = 0


===========================================================
EXAMPLE
===========================================================

Given:

    s1 = "abcdge"
    s2 = "abedg"


Lengths:

    n = 6
    m = 5


Therefore:

    dp = new int[7][6]


The rows represent:

    0, 1, 2, 3, 4, 5, 6


The columns represent:

    0, 1, 2, 3, 4, 5


One possible LCS is:

    "abdg"


Therefore:

    LCS length = 4


===========================================================
DP TABLE
===========================================================

For:

    s1 = "abcdge"
    s2 = "abedg"


The completed DP table is:

          ""   a   b   e   d   g
      ""   0   0   0   0   0   0
       a   0   1   1   1   1   1
       b   0   1   2   2   2   2
       c   0   1   2   2   2   2
       d   0   1   2   2   3   3
       g   0   1   2   2   3   4
       e   0   1   2   3   3   4


The final cell is:

    dp[6][5] = 4


Therefore:

    LCS = 4


===========================================================
DRY RUN
===========================================================

Initial:

    s1 = "abcdge"
    s2 = "abedg"


-----------------------------------------------------------
i = 1, j = 1
-----------------------------------------------------------

Compare:

    s1.charAt(0) = 'a'
    s2.charAt(0) = 'a'


Characters are equal.

Therefore:

    dp[1][1] = dp[0][0] + 1
             = 0 + 1
             = 1


-----------------------------------------------------------
i = 1, j = 2
-----------------------------------------------------------

Compare:

    'a' and 'b'

Characters are different.

Therefore:

    dp[1][2] =
        max(
            dp[0][2],
            dp[1][1]
        )

    = max(0, 1)
    = 1


-----------------------------------------------------------
i = 2, j = 2
-----------------------------------------------------------

Compare:

    s1.charAt(1) = 'b'
    s2.charAt(1) = 'b'


Characters are equal.

Therefore:

    dp[2][2] = dp[1][1] + 1
             = 1 + 1
             = 2


The LCS is now:

    "ab"


-----------------------------------------------------------
i = 4, j = 4
-----------------------------------------------------------

Compare:

    s1.charAt(3) = 'd'
    s2.charAt(3) = 'd'


Characters are equal.

Therefore:

    dp[4][4] = dp[3][3] + 1


The character 'd' contributes 1 to the LCS.


-----------------------------------------------------------
i = 5, j = 5
-----------------------------------------------------------

Compare:

    s1.charAt(4) = 'g'
    s2.charAt(4) = 'g'


Characters are equal.

Therefore:

    dp[5][5] = dp[4][4] + 1


The character 'g' contributes 1.

Eventually, the final answer becomes:

    dp[6][5] = 4


One LCS is:

    "abdg"


===========================================================
KEY POINTS
===========================================================

1. LCS stands for Longest Common Subsequence.

2. A subsequence does not need to be continuous.

3. The relative order of characters must remain unchanged.

4. dp[i][j] represents the LCS length between the first
   i characters of s1 and the first j characters of s2.

5. If characters are equal:

       dp[i][j] = dp[i - 1][j - 1] + 1

6. If characters are different:

       dp[i][j] =
           Math.max(
               dp[i - 1][j],
               dp[i][j - 1]
           )

7. The first row and first column represent cases where
   one string has zero characters.

8. Therefore, the first row and first column contain 0.

9. The answer is stored at:

       dp[n][m]


===========================================================
SPECIAL NOTES ABOUT DP ARRAY
===========================================================

The DP array is:

    int dp[][]


Its dimensions are:

    [n + 1][m + 1]


The extra row and column represent the empty-string cases.


-----------------------------------------------------------
Rows
-----------------------------------------------------------

The row index i represents:

    First i characters of s1


For example:

    i = 3

means:

    First 3 characters of s1.


-----------------------------------------------------------
Columns
-----------------------------------------------------------

The column index j represents:

    First j characters of s2


For example:

    j = 2

means:

    First 2 characters of s2.


Therefore:

    dp[i][j]

represents the LCS length between these two prefixes.


===========================================================
SPECIAL NOTES ABOUT i AND i - 1
===========================================================

The loop starts from:

    i = 1


because:

    i = 0

represents the base case where s1 contains zero characters.


Similarly:

    j = 1

is used because:

    j = 0

represents the base case where s2 contains zero characters.


Java String indexing starts from 0.

Therefore, when the DP index is i, the corresponding
character in s1 is:

    s1.charAt(i - 1)


Similarly, the corresponding character in s2 is:

    s2.charAt(j - 1)


For example:

    i = 1

corresponds to:

    s1.charAt(0)


And:

    j = 1

corresponds to:

    s2.charAt(0)


===========================================================
SPECIAL NOTES ABOUT i - 1 AND j - 1
===========================================================

When characters match:

    s1.charAt(i - 1) == s2.charAt(j - 1)


we use:

    dp[i - 1][j - 1]


Why?

Because both current characters are included in the LCS.

Therefore, we move diagonally to the state representing
the remaining prefixes.


The recurrence becomes:

    dp[i][j] = dp[i - 1][j - 1] + 1


===========================================================
SPECIAL NOTES ABOUT NON-MATCHING CHARACTERS
===========================================================

When:

    s1.charAt(i - 1) != s2.charAt(j - 1)


we cannot directly include both characters.

Therefore, we check two possibilities.


OPTION 1:

Ignore the current character of s1:

    dp[i - 1][j]


OPTION 2:

Ignore the current character of s2:

    dp[i][j - 1]


Then select the larger result:

    dp[i][j] =
        Math.max(
            dp[i - 1][j],
            dp[i][j - 1]
        )


===========================================================
SPECIAL NOTES ABOUT TABULATION
===========================================================

Tabulation is a BOTTOM-UP approach.

The DP table starts with the smallest subproblems.

Then larger subproblems are calculated using already
calculated smaller subproblems.

For example:

    dp[i][j]

depends on:

    dp[i - 1][j - 1]
    dp[i - 1][j]
    dp[i][j - 1]


Therefore, these cells must already be calculated before
dp[i][j] is calculated.


This is why the table is filled from:

    top -> bottom

and:

    left -> right.


===========================================================
SPECIAL NOTES ABOUT THE TWO LOOPS
===========================================================

Outer loop:

    for(int i = 1; i < n + 1; i++)


This is equivalent to:

    for(int i = 1; i <= n; i++)


It processes every character of s1.


Inner loop:

    for(int j = 1; j < m + 1; j++)


This is equivalent to:

    for(int j = 1; j <= m; j++)


It processes every character of s2.


For every combination of i and j, one DP state is calculated.


===========================================================
WHY RETURN dp[n][m]?
===========================================================

The complete strings are represented by:

    n = s1.length()
    m = s2.length()


Therefore:

    dp[n][m]

represents:

    LCS of the complete s1
    and complete s2.


Hence:

    return dp[n][m];


For this example:

    dp[6][5] = 4


Therefore:

    Output = 4


===========================================================
TIME COMPLEXITY
===========================================================

There are:

    (n + 1) * (m + 1)

DP states.

Each state takes O(1) time to calculate.

Therefore:

    Time Complexity = O(n * m)


===========================================================
SPACE COMPLEXITY
===========================================================

The DP table has:

    (n + 1) * (m + 1)

cells.

Therefore:

    Space Complexity = O(n * m)


===========================================================
SPECIAL NOTES
===========================================================

1. This solution uses TABULATION.

2. Tabulation is a BOTTOM-UP Dynamic Programming approach.

3. The DP table stores LCS answers for smaller prefixes.

4. dp[i][j] represents the LCS length between the first i
   characters of s1 and the first j characters of s2.

5. Matching characters use the diagonal state:

       dp[i - 1][j - 1]

6. Non-matching characters use the top and left states:

       dp[i - 1][j]
       dp[i][j - 1]

7. The first row and first column contain 0.

8. The final answer is:

       dp[n][m]

9. Time Complexity:

       O(n * m)

10. Space Complexity:

       O(n * m)

11. The DP table can be further space-optimized because each
    state depends only on the previous row and the current row.

*/


public class DP20 {

  public static int lcsTab(String s1, String s2) {

    // Store the lengths of the two input strings.
    int n = s1.length();
    int m = s2.length();

    /*
     * Create the DP table.
     *
     * There are n + 1 rows and m + 1 columns because row 0
     * and column 0 represent the empty-string cases.
     */
    int dp[][] = new int[n + 1][m + 1];

    /*
     * Base case:
     *
     * dp[i][0] represents the LCS between the first i
     * characters of s1 and an empty s2.
     *
     * Therefore, the LCS length is 0.
     */
    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = 0;
    }

    /*
     * Base case:
     *
     * dp[0][j] represents the LCS between an empty s1
     * and the first j characters of s2.
     *
     * Therefore, the LCS length is 0.
     */
    for (int i = 0; i < m + 1; i++) {
      dp[0][i] = 0;
    }

    /*
     * Fill the DP table from top to bottom and from left to
     * right.
     *
     * i represents the number of characters considered from s1.
     *
     * j represents the number of characters considered from s2.
     */
    for (int i = 1; i < n + 1; i++) {

      for (int j = 1; j < m + 1; j++) {

        /*
         * Java String indexes start from 0.
         *
         * Therefore:
         *
         * i -> DP position
         * i - 1 -> actual String index
         *
         * Similarly:
         *
         * j -> DP position
         * j - 1 -> actual String index
         */
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

          /*
           * The current characters are equal.
           *
           * Include this common character in the LCS and move
           * diagonally to the previous state.
           */
          dp[i][j] = dp[i - 1][j - 1] + 1;

        } else {

          /*
           * The current characters are different.
           *
           * We have two choices:
           *
           * 1. Ignore the current character of s1:
           *       dp[i - 1][j]
           *
           * 2. Ignore the current character of s2:
           *       dp[i][j - 1]
           *
           * Take the maximum of the two possibilities.
           */
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    /*
     * dp[n][m] represents the LCS length between the complete
     * strings s1 and s2.
     */
    return dp[n][m];
  }

  public static void main(String[] args) {

    // First input string.
    String s1 = "abcdge";

    // Second input string.
    String s2 = "abedg";

    /*
     * Calculate the LCS length of the complete strings.
     *
     * The method builds the entire DP table and returns the
     * value stored in dp[n][m].
     */
    System.out.println(lcsTab(s1, s2));
  }
}