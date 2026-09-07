package DP;

import java.util.Arrays;

/*
===========================================================
TITLE
===========================================================

DP21 - Longest Common Subsequence (LCS) using
       Space-Optimized Tabulation with Two Arrays


===========================================================
PROBLEM STATEMENT
===========================================================

Given two strings s1 and s2, find the length of their
Longest Common Subsequence (LCS).

A subsequence is a sequence that can be obtained from a
string by deleting some characters without changing the
relative order of the remaining characters.

The characters of the subsequence do NOT need to be
contiguous.

Example:

s1 = "abcdge"
s2 = "abedg"

One possible LCS is:

"abdg"

Therefore, the answer is:

4


-----------------------------------------------------------
INPUT
-----------------------------------------------------------

Two strings:

s1
s2


-----------------------------------------------------------
OUTPUT
-----------------------------------------------------------

Return the length of the Longest Common Subsequence
between s1 and s2.


-----------------------------------------------------------
CONSTRAINTS
-----------------------------------------------------------

1. s1 and s2 may have different lengths.

2. The strings may contain repeated characters.

3. The strings may contain no common characters.

4. Empty strings are valid inputs.


-----------------------------------------------------------
EDGE CASES
-----------------------------------------------------------

1. If s1 is empty:

   LCS length = 0


2. If s2 is empty:

   LCS length = 0


3. If both strings are empty:

   LCS length = 0


4. If there are no common characters:

   LCS length = 0


5. If both strings are identical:

   LCS length = length of the string.


===========================================================
PROBLEM RESOURCE
===========================================================

Problem:

Longest Common Subsequence

Commonly known as:

LCS

The problem can be solved using Dynamic Programming
because the problem contains:

1. Overlapping subproblems.
2. Optimal substructure.


===========================================================
INTUITION
===========================================================

We compare the characters of s1 and s2 one by one.

Suppose:

s1[i - 1]
s2[j - 1]

are the current characters being compared.


-----------------------------------------------------------
CASE 1: CURRENT CHARACTERS ARE EQUAL
-----------------------------------------------------------

If:

s1[i - 1] == s2[j - 1]

then this character can be included in the LCS.

Therefore:

dp[i][j] = dp[i - 1][j - 1] + 1


Why?

Because after matching these two characters, we move
diagonally and solve the problem for the remaining
characters.


-----------------------------------------------------------
CASE 2: CURRENT CHARACTERS ARE DIFFERENT
-----------------------------------------------------------

If:

s1[i - 1] != s2[j - 1]

then both characters cannot be included together as the
same matching character.

We have two choices:

1. Ignore the current character of s1.

   dp[i - 1][j]


2. Ignore the current character of s2.

   dp[i][j - 1]


Therefore:

dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])


===========================================================
APPROACH
===========================================================

We normally use a 2D DP table:

dp[i][j]

where:

dp[i][j] = LCS length between the first i characters
           of s1 and the first j characters of s2.


-----------------------------------------------------------
2D DP RECURRENCE
-----------------------------------------------------------

If characters match:

dp[i][j] = dp[i - 1][j - 1] + 1


If characters do not match:

dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])


-----------------------------------------------------------
SPACE OPTIMIZATION
-----------------------------------------------------------

To calculate the current DP row, we only need:

1. The previous row.
2. The current row.

We do NOT need the complete 2D DP table.

Therefore, instead of:

dp[n + 1][m + 1]

we use two arrays:

prev[m + 1]
curr[m + 1]


-----------------------------------------------------------
MEANING OF prev
-----------------------------------------------------------

prev[j] represents:

dp[i - 1][j]

That is, the result from the previous row.


-----------------------------------------------------------
MEANING OF curr
-----------------------------------------------------------

curr[j] represents:

dp[i][j]

That is, the result currently being calculated for the
current row.


-----------------------------------------------------------
WHY DO WE NEED TWO ARRAYS?
-----------------------------------------------------------

For:

s1[i - 1] == s2[j - 1]

we need:

dp[i - 1][j - 1]

which is:

prev[j - 1]


For:

s1[i - 1] != s2[j - 1]

we need:

dp[i - 1][j]

which is:

prev[j]

and:

dp[i][j - 1]

which is:

curr[j - 1]

Therefore, both the previous row and current row are
required.


===========================================================
EXAMPLE
===========================================================

Given:

s1 = "abcdge"
s2 = "abedg"


Characters of s1:

a b c d g e

Characters of s2:

a b e d g


One possible LCS is:

a b d g

Therefore:

LCS length = 4


===========================================================
DP TABLE
===========================================================

For understanding, the complete 2D DP table would look
like this:

             ""   a   b   e   d   g
         ""   0   0   0   0   0   0
          a   0   1   1   1   1   1
          b   0   1   2   2   2   2
          c   0   1   2   2   2   2
          d   0   1   2   2   3   3
          g   0   1   2   2   3   4
          e   0   1   2   3   3   4


The final answer is:

dp[6][5] = 4


However, our program does NOT store this complete
2D table.

It stores only:

prev = previous row
curr = current row


===========================================================
DRY RUN
===========================================================

s1 = "abcdge"
s2 = "abedg"


-----------------------------------------------------------
i = 1
s1[i - 1] = 'a'
-----------------------------------------------------------

Compare 'a' with characters of s2.

j = 1:

'a' == 'a'

curr[1] = prev[0] + 1
        = 0 + 1
        = 1


j = 2:

'a' != 'b'

curr[2] = max(prev[2], curr[1])
        = max(0, 1)
        = 1


j = 3:

'a' != 'e'

curr[3] = max(prev[3], curr[2])
        = max(0, 1)
        = 1


The current row becomes:

curr = [0, 1, 1, 1, 1, 1]

Then:

prev = curr.clone()


-----------------------------------------------------------
i = 2
s1[i - 1] = 'b'
-----------------------------------------------------------

Compare 'b' with s2.

When:

'b' == 'b'

we use:

curr[j] = prev[j - 1] + 1

This produces:

curr = [0, 1, 2, 2, 2, 2]


Then:

prev = curr.clone()


-----------------------------------------------------------
i = 3
s1[i - 1] = 'c'
-----------------------------------------------------------

There is no 'c' in s2.

Therefore, no new matching character is added.

The row becomes:

curr = [0, 1, 2, 2, 2, 2]


-----------------------------------------------------------
i = 4
s1[i - 1] = 'd'
-----------------------------------------------------------

When:

'd' == 'd'

we add 1 to the diagonal value.

The row becomes:

curr = [0, 1, 2, 2, 3, 3]


-----------------------------------------------------------
i = 5
s1[i - 1] = 'g'
-----------------------------------------------------------

When:

'g' == 'g'

we add 1 to the diagonal value.

The row becomes:

curr = [0, 1, 2, 2, 3, 4]


-----------------------------------------------------------
i = 6
s1[i - 1] = 'e'
-----------------------------------------------------------

When:

'e' == 'e'

we obtain:

curr[3] = prev[2] + 1
        = 2 + 1
        = 3

The final row becomes:

curr = [0, 1, 2, 3, 3, 4]


After the final iteration:

prev = curr.clone()


Therefore:

prev[m] = prev[5] = 4


Final Answer:

4


===========================================================
KEY POINTS
===========================================================

1. LCS stands for Longest Common Subsequence.

2. A subsequence does not need to be contiguous.

3. The relative order of characters must remain unchanged.

4. If characters match:

   curr[j] = prev[j - 1] + 1


5. If characters do not match:

   curr[j] = max(prev[j], curr[j - 1])


6. prev represents the previous DP row.

7. curr represents the current DP row.

8. Only two rows are required.

9. Therefore, the 2D DP table can be space optimized.

10. The final answer is stored at:

    prev[m]


===========================================================
SPECIAL NOTES ABOUT DP ARRAY
===========================================================

The arrays are created as:

int prev[] = new int[m + 1];
int curr[] = new int[m + 1];


-----------------------------------------------------------
WHY m + 1?
-----------------------------------------------------------

The extra position represents the empty string.

For example, if:

m = 5

then:

curr[0]

represents the LCS with an empty second string.

Therefore:

curr[0] = 0


The remaining positions represent:

curr[1]
curr[2]
...
curr[m]


-----------------------------------------------------------
WHY DOES curr[0] REMAIN 0?
-----------------------------------------------------------

When the second string has zero characters, the LCS
length is always zero.

Therefore:

dp[i][0] = 0


The Java arrays are automatically initialized with zero,
so curr[0] is initially 0.

After that, every calculated row also keeps curr[0]
as 0 because the value is never modified.


===========================================================
SPECIAL NOTES ABOUT prev AND curr
===========================================================

Initially:

prev = [0, 0, 0, 0, 0, 0]

This represents the DP row for:

i = 0

which means the first string contains zero characters.


For every new character of s1:

1. Calculate the complete curr row.
2. Copy curr into prev.
3. Move to the next character of s1.


The important statement is:

prev = curr.clone();


-----------------------------------------------------------
WHY clone()?
-----------------------------------------------------------

clone() creates a separate array containing the same
values.

After:

prev = curr.clone();

both arrays contain the same values, but they are
different array objects.

This allows curr to be modified during the next iteration
without changing prev.


===========================================================
SPECIAL NOTES ABOUT i AND i - 1
===========================================================

The loops start from:

i = 1
j = 1


because index 0 represents the empty-string case.


-----------------------------------------------------------
WHY s1.charAt(i - 1)?
-----------------------------------------------------------

The DP index starts from 1, but Java string indexing
starts from 0.

Therefore:

i = 1  -> s1.charAt(0)
i = 2  -> s1.charAt(1)
i = 3  -> s1.charAt(2)


So:

s1.charAt(i - 1)

gives the actual character corresponding to DP row i.


Similarly:

s2.charAt(j - 1)

gives the actual character corresponding to DP column j.


===========================================================
SPECIAL NOTES ABOUT THE LCS RECURRENCE
===========================================================

-----------------------------------------------------------
WHEN CHARACTERS MATCH
-----------------------------------------------------------

Code:

curr[j] = prev[j - 1] + 1;


Meaning:

dp[i][j] = dp[i - 1][j - 1] + 1


We move diagonally because both current characters are
used as one common character.


-----------------------------------------------------------
WHEN CHARACTERS DO NOT MATCH
-----------------------------------------------------------

Code:

curr[j] = Math.max(prev[j], curr[j - 1]);


Meaning:

dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])


We check both possibilities:

1. Remove/ignore the current character of s1.

2. Remove/ignore the current character of s2.

Then choose the larger LCS length.


===========================================================
SPECIAL NOTES ABOUT clone()
===========================================================

The statement:

prev = curr.clone();


is important because prev and curr need to represent
different DP rows.

Suppose:

prev = [0, 1, 2, 2, 3, 4]
curr = [0, 1, 2, 3, 3, 4]


After:

prev = curr.clone();


we get:

prev = [0, 1, 2, 3, 3, 4]

curr = [0, 1, 2, 3, 3, 4]

but they are still separate arrays.

Therefore, changing curr later does not modify prev.


===========================================================
WHY RETURN prev[m]?
===========================================================

After processing all characters of s1:

i = n


The last calculated row represents:

dp[n][j]


The final column represents all characters of s2:

j = m


Therefore:

prev[m]

represents:

dp[n][m]


which is the LCS length of the complete strings:

s1 and s2.


===========================================================
TIME COMPLEXITY
===========================================================

There are:

n rows

and:

m columns


Therefore, the total number of DP states is:

n × m


Each state requires constant work.

Therefore:

Time Complexity = O(n × m)


===========================================================
SPACE COMPLEXITY
===========================================================

We do not store:

dp[n + 1][m + 1]


Instead, we store only:

prev[m + 1]
curr[m + 1]


Therefore:

Space Complexity = O(m)


This is a major improvement over the normal 2D
tabulation approach, which requires:

O(n × m)


===========================================================
SPECIAL NOTES
===========================================================

1. This implementation is a space-optimized version of
   LCS tabulation.

2. The complete 2D DP table is not stored.

3. Only the previous row and current row are stored.

4. prev[j] represents the previous row value.

5. curr[j - 1] represents the current row's previous
   column value.

6. prev[j - 1] represents the diagonal value.

7. Matching characters use the diagonal value:

   prev[j - 1] + 1


8. Non-matching characters use:

   max(prev[j], curr[j - 1])


9. clone() is used so that prev and curr remain separate
   arrays.

10. The final answer is:

    prev[m]


11. Time Complexity:

    O(n × m)


12. Space Complexity:

    O(m)


13. For:

    s1 = "abcdge"
    s2 = "abedg"

    Output:

    4

===========================================================
*/

public class DP21 {
  public static int lcsTab(String s1, String s2) {

    // Store the lengths of the two input strings.
    int n = s1.length();
    int m = s2.length();

    /*
     * prev stores the results of the previous DP row.
     *
     * curr stores the results of the current DP row.
     *
     * We need m + 1 positions because index 0 represents
     * the case where the second string has zero characters.
     */
    int prev[] = new int[m + 1];
    int curr[] = new int[m + 1];

    /*
     * Initialize the previous row with 0.
     *
     * Java arrays are already initialized with 0, so this
     * statement is not strictly necessary, but it makes
     * the DP initialization explicit.
     */
    Arrays.fill(prev, 0);

    /*
     * Process every character of s1.
     *
     * i represents the number of characters considered
     * from s1.
     */
    for (int i = 1; i < n + 1; i++) {

      /*
       * Process every character of s2.
       *
       * j represents the number of characters considered
       * from s2.
       */
      for (int j = 1; j < m + 1; j++) {

        /*
         * Compare the current characters.
         *
         * i - 1 and j - 1 are used because Java string
         * indexing starts from 0 while DP indexing starts
         * from 1.
         */
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

          /*
           * The current characters are equal.
           *
           * Include this common character in the LCS.
           *
           * prev[j - 1] represents the diagonal state:
           *
           * dp[i - 1][j - 1]
           *
           * Therefore:
           *
           * curr[j] = prev[j - 1] + 1
           */
          curr[j] = prev[j - 1] + 1;

        } else {

          /*
           * The current characters are different.
           *
           * Two possibilities exist:
           *
           * 1. Ignore the current character of s1:
           *
           *    prev[j]
           *
           *    This represents dp[i - 1][j].
           *
           *
           * 2. Ignore the current character of s2:
           *
           *    curr[j - 1]
           *
           *    This represents dp[i][j - 1].
           *
           *
           * Take the maximum of both possibilities.
           */
          curr[j] = Math.max(prev[j], curr[j - 1]);
        }
      }

      /*
       * The current row has now been completely calculated.
       *
       * Copy the current row into prev so that it becomes
       * the previous row for the next iteration of i.
       *
       * clone() creates a separate array, so future changes
       * to curr do not modify prev.
       */
      prev = curr.clone();
    }

    /*
     * After processing all characters:
     *
     * prev[m] represents dp[n][m].
     *
     * Therefore, it contains the LCS length of the complete
     * strings s1 and s2.
     */
    return prev[m];
  }

  public static void main(String[] args) {

    // First input string.
    String s1 = "abcdge";

    // Second input string.
    String s2 = "abedg";

    /*
     * Calculate the LCS length of the complete strings.
     *
     * The method uses only two DP rows instead of storing
     * the complete 2D DP table.
     */
    System.out.println(lcsTab(s1, s2));
  }
}