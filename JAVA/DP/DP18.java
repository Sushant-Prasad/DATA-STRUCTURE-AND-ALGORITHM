package DP;

/*
===========================================================
TITLE
===========================================================

Longest Common Subsequence (LCS) Using Recursion


===========================================================
PROBLEM STATEMENT
===========================================================

Given two strings:

    s1
    s2

Find the length of the Longest Common Subsequence (LCS)
between the two strings.

A subsequence is a sequence that can be obtained from a
string by deleting some characters without changing the
relative order of the remaining characters.

The selected characters do NOT need to be continuous.

For example:

    String = "abcde"

    "ace" is a subsequence.

But:

    "aec" is NOT a subsequence

because the relative order of characters is changed.


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

The LCS is:

    "abdg"

Therefore:

    Output = 4


-------------------------
Constraints
-------------------------

    1. Both strings may contain lowercase or uppercase
       characters depending on the problem requirements.

    2. The length of the strings can be large.

    3. The recursive solution may have exponential time
       complexity for large strings.


-------------------------
Edge Cases
-------------------------

    1. If either string is empty, LCS length = 0.

    2. If both strings are empty, LCS length = 0.

    3. If both current characters are equal, they can be
       included in the LCS.

    4. If the current characters are different, we have to
       explore both possibilities.


===========================================================
PROBLEM RESOURCE
===========================================================

Longest Common Subsequence:

https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1


===========================================================
INTUITION
===========================================================

We compare the characters at the current positions of both
strings.

The function:

    lcs(s1, s2, n, m)

considers:

    first n characters of s1
    first m characters of s2

We compare:

    s1.charAt(n - 1)
    s2.charAt(m - 1)


There are two main cases.


-----------------------------------------------------------
CASE 1: Characters are equal
-----------------------------------------------------------

If:

    s1.charAt(n - 1) == s2.charAt(m - 1)

then this character can be part of the LCS.

Therefore:

    LCS = 1 + LCS of the remaining characters

So:

    lcs(n, m)
    = lcs(n - 1, m - 1) + 1


The indices are reduced because both matching characters
have already been included.


-----------------------------------------------------------
CASE 2: Characters are different
-----------------------------------------------------------

If:

    s1.charAt(n - 1) != s2.charAt(m - 1)

then both characters cannot be included together.

We have two choices:

    1. Ignore the last character of s2.
    2. Ignore the last character of s1.

Therefore:

    lcs(n, m)
    = max(
        lcs(n, m - 1),
        lcs(n - 1, m)
      )


We take the maximum because we want the longest possible
common subsequence.


===========================================================
APPROACH
===========================================================

The recursive function uses:

    n = number of characters considered from s1
    m = number of characters considered from s2

At every recursive call:

    n - 1
    m - 1

means we are moving one character backward in the respective
string.

The recursion follows these rules:

    If n == 0 OR m == 0:
        return 0

    If last characters are equal:
        return 1 + lcs(n - 1, m - 1)

    Otherwise:
        return max(
            lcs(n, m - 1),
            lcs(n - 1, m)
        )


===========================================================
EXAMPLE
===========================================================

Given:

    s1 = "abcdge"
    s2 = "abedg"


Index positions:

    s1:

        a b c d g e
        0 1 2 3 4 5


    s2:

        a b e d g
        0 1 2 3 4


The LCS is:

    "abdg"


Characters:

    a -> common
    b -> common
    d -> common
    g -> common

Therefore:

    LCS length = 4


===========================================================
DRY RUN
===========================================================

Initial call:

    lcs("abcdge", "abedg", 6, 5)


Compare:

    s1.charAt(5) = 'e'
    s2.charAt(4) = 'g'

They are different.

Therefore:

    lcs(6, 5)
    =
    max(
        lcs(6, 4),
        lcs(5, 5)
    )


-----------------------------------------------------------
One branch
-----------------------------------------------------------

Consider:

    lcs(6, 4)

Compare:

    s1.charAt(5) = 'e'
    s2.charAt(3) = 'd'

Different again.

The recursion continues by removing one character from
either string.


Eventually, matching characters are found.


For example:

    'd' == 'd'

Then:

    lcs(n, m)
    = 1 + lcs(n - 1, m - 1)


Similarly:

    'g' == 'g'

contributes:

    +1


The recursion eventually finds:

    "abdg"

Therefore:

    LCS = 4


===========================================================
RECURSION TREE CONCEPT
===========================================================

When the characters are different, the function creates
TWO recursive calls:

                    lcs(n, m)
                    /       \
                   /         \
          lcs(n, m-1)     lcs(n-1, m)


This causes many overlapping recursive calls.

For example, the same state such as:

    lcs(3, 2)

may be calculated multiple times through different paths.

This repeated work is the main reason the recursive solution
has exponential time complexity.


===========================================================
KEY POINTS
===========================================================

1. LCS stands for Longest Common Subsequence.

2. A subsequence does not have to be continuous.

3. The relative order of selected characters must remain the
   same.

4. If the current characters match:

       lcs(n, m) = 1 + lcs(n - 1, m - 1)

5. If the current characters do not match:

       lcs(n, m) = max(
           lcs(n, m - 1),
           lcs(n - 1, m)
       )

6. If either string becomes empty:

       LCS = 0

7. This recursive solution has overlapping subproblems.

8. Memoization can be used to avoid recalculating the same
   states.

9. Tabulation can further convert the solution into an
   iterative DP solution.


===========================================================
SPECIAL NOTES ABOUT n AND m
===========================================================

Here:

    n = number of characters considered from s1
    m = number of characters considered from s2

They are NOT directly Java array indexes.

For example:

    n = 6

means:

    Consider the first 6 characters of s1.

Since Java String indexing starts from 0, the last character
among those 6 characters is:

    s1.charAt(n - 1)

Therefore:

    s1.charAt(6 - 1)
    = s1.charAt(5)


Similarly:

    s2.charAt(m - 1)


===========================================================
SPECIAL NOTES ABOUT charAt(n - 1)
===========================================================

The expression:

    s1.charAt(n - 1)

gets the last character among the first n characters of s1.

Why n - 1?

Because Java uses 0-based indexing.

For example:

    s1 = "abcd"

Indexes:

    a -> 0
    b -> 1
    c -> 2
    d -> 3

If:

    n = 4

then the last character is:

    index = n - 1
          = 4 - 1
          = 3

Therefore:

    s1.charAt(n - 1)

returns:

    'd'


===========================================================
SPECIAL NOTES ABOUT THE BASE CASE
===========================================================

The base condition is:

    if(m == 0 || n == 0) return 0;

If either string has zero characters available, there cannot
be a common subsequence containing any character.

For example:

    lcs("abc", "", 3, 0)

returns:

    0

Similarly:

    lcs("", "abc", 0, 3)

returns:

    0


===========================================================
SPECIAL NOTES ABOUT RECURSION
===========================================================

When characters match:

    lcs(n - 1, m - 1)

is called.

Both n and m decrease because both matching characters are
already included.


When characters do not match:

    lcs(n, m - 1)

and:

    lcs(n - 1, m)

are called.

Only one string is reduced in each recursive branch because
we are testing which character should be ignored.


===========================================================
WHY Math.max() IS USED
===========================================================

When:

    s1.charAt(n - 1) != s2.charAt(m - 1)

we cannot take both characters together.

Therefore, we try both possibilities:

    Option 1:
    Remove the last character from s2.

        lcs(n, m - 1)


    Option 2:
    Remove the last character from s1.

        lcs(n - 1, m)


Both possibilities may produce different LCS lengths.

Therefore:

    Math.max(
        lcs(n, m - 1),
        lcs(n - 1, m)
    )

selects the longer subsequence.


===========================================================
OVERLAPPING SUBPROBLEMS
===========================================================

The recursive solution calculates the same states multiple
times.

For example:

    lcs(4, 3)

may be reached through different recursive paths.

Therefore, the same subproblem can be solved repeatedly.

This is called:

    Overlapping Subproblems


This makes the simple recursive solution inefficient.

Dynamic Programming solves this problem using:

    1. Memoization
    2. Tabulation


===========================================================
TIME COMPLEXITY
===========================================================

In the worst case, when characters frequently do not match,
each state creates two recursive calls.

Therefore, the time complexity is approximately:

    O(2^(n + m))

This is exponential.

The recursive solution is therefore not efficient for large
strings.


===========================================================
SPACE COMPLEXITY
===========================================================

The maximum recursion depth is approximately:

    O(n + m)

because each recursive call decreases n or m.

Therefore:

    Space Complexity = O(n + m)

This space is due to the recursion call stack.


===========================================================
SPECIAL NOTES
===========================================================

1. This is the pure recursive solution for LCS.

2. It does not use a DP array.

3. It has overlapping subproblems.

4. Its time complexity is exponential.

5. Memoization can store previously calculated LCS states.

6. Tabulation can solve the problem in:

       O(n * m)

   time and:

       O(n * m)

   space.

7. The most important recurrence is:

       If characters match:

       lcs(n, m)
       = 1 + lcs(n - 1, m - 1)


       If characters do not match:

       lcs(n, m)
       = max(
           lcs(n, m - 1),
           lcs(n - 1, m)
       )

*/


public class DP18 {

  public static int lcs(String s1, String s2, int n, int m) {

    // Base case: if either string has no characters left, LCS is 0.
    if (m == 0 || n == 0) return 0;

    /*
     * If the last characters of the two currently considered
     * strings are equal, include that character in the LCS.
     *
     * n - 1 and m - 1 remove the matching characters from
     * further consideration.
     */
    if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
      return lcs(s1, s2, n - 1, m - 1) + 1;
    } else {

      /*
       * If the last characters are different, we cannot include
       * both of them together.
       *
       * We try both possibilities:
       *
       * 1. Ignore the last character of s2.
       * 2. Ignore the last character of s1.
       *
       * Math.max() selects the longer common subsequence.
       */
      return Math.max(lcs(s1, s2, n, m - 1), lcs(s1, s2, n - 1, m));
    }
  }

  public static void main(String[] args) {

    // First input string.
    String s1 = "abcdge";

    // Second input string.
    String s2 = "abedg";

    /*
     * Initially, n and m contain the complete lengths of
     * the two strings.
     *
     * The recursive function gradually decreases n and m
     * until one of them becomes 0.
     */
    System.out.println(lcs(s1, s2, s1.length(), s2.length()));
  }
}