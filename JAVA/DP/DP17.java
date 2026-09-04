package DP;

import java.util.Arrays;

/*
===========================================================
TITLE
===========================================================

DP17 - Rod Cutting Using Space-Optimized Tabulation

Rod Cutting is a type / variation of the Unbounded Knapsack
problem.

The main difference is that instead of "weight" and "value",
we have:

    length[] -> length of each available rod piece
    price[]  -> price of each available rod piece
    L        -> total length of the original rod

Because a rod piece can be used multiple times, this is an
UNBOUNDED problem.


===========================================================
PROBLEM STATEMENT
===========================================================

Given:

    length[] = lengths of available rod pieces
    price[]  = price corresponding to each rod piece
    L        = total length of the rod

We need to cut the rod into pieces such that:

    1. The total length of selected pieces is exactly
       or at most L.
    2. A piece length can be selected multiple times.
    3. The total obtainable price is maximum.

Return the maximum price that can be obtained.

-------------------------
Input
-------------------------

    int length[] -> available piece lengths
    int price[]  -> price of each piece
    int L         -> total rod length

Example:

    length[] = {1, 2, 3, 4, 5, 6, 7, 8}
    price[]  = {1, 5, 8, 9, 10, 17, 17, 20}
    L = 8


-------------------------
Output
-------------------------

    Maximum obtainable price = 22


-------------------------
Constraints
-------------------------

    1. length[] and price[] have the same size.
    2. Each length represents an available rod piece size.
    3. A rod piece can be used multiple times.
    4. L represents the total available rod length.
    5. Length and price values are non-negative.


-------------------------
Edge Cases
-------------------------

    1. If L = 0:
       Maximum price = 0.

    2. If there are no available pieces:
       Maximum price = 0.

    3. If a piece is longer than the current rod length:
       That piece cannot be used for that capacity.

    4. Since this is Unbounded Knapsack, the same piece can
       be selected multiple times.


===========================================================
PROBLEM RESOURCE
===========================================================

Rod Cutting is a classic Dynamic Programming problem and is
a variation of Unbounded Knapsack.

Problem:
https://www.geeksforgeeks.org/problems/rod-cutting0840/1


===========================================================
INTUITION
===========================================================

For every available rod piece and every possible rod length,
we have two choices:

    1. INCLUDE the current piece
    2. EXCLUDE the current piece

We calculate the profit from both choices and select the
maximum.

The important point is:

    Rod Cutting is UNBOUNDED.

Therefore, if we INCLUDE the current piece, we are allowed
to use the SAME piece again.

That is why the INCLUDE case uses the CURRENT row:

    price[i - 1] + curr[j - length[i - 1]]

Instead of:

    price[i - 1] + prev[j - length[i - 1]]

Using curr[] allows the same piece to be selected again.


===========================================================
APPROACH
===========================================================

We first solve the normal 2D DP problem conceptually.

    dp[i][j]

means:

    Maximum price obtainable using the first i available
    piece lengths with a rod capacity of j.

For every state dp[i][j], we consider the current piece.

Let:

    v = price[i - 1]
    w = length[i - 1]

Because Java arrays are 0-indexed but DP rows are treated
as 1-indexed:

    i -> number of available pieces considered
    i - 1 -> actual Java array index


-------------------------
CASE 1: INCLUDE
-------------------------

If:

    w <= j

the current piece can fit.

Since this is UNBOUNDED Knapsack, the same piece can be used
again.

Therefore:

    include = v + curr[j - w]

Notice:

    curr[j - w]

NOT:

    prev[j - w]

The current row is used because the current piece can be
taken repeatedly.


-------------------------
CASE 2: EXCLUDE
-------------------------

We do not take the current piece.

Therefore:

    exclude = prev[j]

This means we use the answer from the previous row, where
the current piece is not available.


-------------------------
FINAL DECISION
-------------------------

Take the better option:

    curr[j] = Math.max(include, exclude)


===========================================================
EXAMPLE
===========================================================

Consider:

    length[] = {1, 2, 3, 4, 5, 6, 7, 8}

    price[]  = {1, 5, 8, 9, 10, 17, 17, 20}

    L = 8


Some possible cuts are:

    8
    Price = 20

    6 + 2
    Price = 17 + 5 = 22

    4 + 4
    Price = 9 + 9 = 18

    3 + 3 + 2
    Price = 8 + 8 + 5 = 21

Therefore:

    Maximum Price = 22


One optimal solution is:

    Length 6 -> Price 17
    Length 2 -> Price 5

    Total Length = 6 + 2 = 8
    Total Price  = 17 + 5 = 22


===========================================================
DP TABLE CONCEPT
===========================================================

The original 2D DP table would have:

    Rows    -> number of available piece lengths
    Columns -> rod lengths from 0 to L

For example:

        j ->  0   1   2   3   ...   8
    i
    0
    1
    2
    3
    ...
    8

Meaning:

    dp[i][j]

    = Maximum price using the first i piece lengths
      for rod length j.


However, each row only depends on:

    1. Previous row -> prev[]
    2. Current row  -> curr[]

Therefore, storing the complete 2D table is unnecessary.

We only store two rows.


===========================================================
SPACE OPTIMIZATION
===========================================================

Original DP:

    int dp[][] = new int[n + 1][L + 1];

Space:

    O(n * L)

But each row only needs:

    Previous row
    Current row

Therefore:

    int prev[] = new int[L + 1];
    int curr[] = new int[L + 1];

Space becomes:

    O(L)


===========================================================
DRY RUN
===========================================================

Example:

    length[] = {1, 2, 3, 4, 5, 6, 7, 8}
    price[]  = {1, 5, 8, 9, 10, 17, 17, 20}
    L = 8


Initially:

    prev[] = {0, 0, 0, 0, 0, 0, 0, 0, 0}

This represents:

    No available pieces.

Therefore, maximum price is 0 for every capacity.


-----------------------------------------------------------
i = 1
-----------------------------------------------------------

Current piece:

    length[0] = 1
    price[0]  = 1

For j = 1:

    include = 1 + curr[1 - 1]
            = 1 + curr[0]
            = 1

    exclude = prev[1]
            = 0

    curr[1] = max(1, 0)
            = 1

For j = 2:

    include = 1 + curr[2 - 1]
            = 1 + curr[1]
            = 2

This demonstrates the UNBOUNDED property.

The length-1 piece can be used again.

Therefore:

    curr[2] = 2

Similarly:

    curr[3] = 3
    curr[4] = 4
    ...
    curr[8] = 8


After completing the row:

    prev = curr.clone();


-----------------------------------------------------------
i = 2
-----------------------------------------------------------

Current piece:

    length[1] = 2
    price[1]  = 5

For j = 2:

    include = 5 + curr[0]
            = 5

    exclude = prev[2]
            = 2

    curr[2] = 5


For j = 4:

    include = 5 + curr[2]
            = 5 + 5
            = 10

The same length-2 piece can be used again.

Therefore:

    curr[4] = 10


This is the key difference between 0/1 Knapsack and
Unbounded Knapsack.


-----------------------------------------------------------
Final Result
-----------------------------------------------------------

After processing all available lengths:

    prev[8] = 22

Therefore:

    Maximum obtainable price = 22


===========================================================
KEY POINTS
===========================================================

1. Rod Cutting is a variation of Unbounded Knapsack.

2. The same rod piece can be used multiple times.

3. length[] behaves like the weight array.

4. price[] behaves like the value array.

5. L behaves like the knapsack capacity.

6. curr[] represents the current DP row.

7. prev[] represents the previous DP row.

8. INCLUDE uses:

       price[i - 1] + curr[j - length[i - 1]]

9. EXCLUDE uses:

       prev[j]

10. curr[] must be reset before calculating every new row.

11. clone() is used so that prev[] and curr[] remain
    independent arrays.

12. The final answer is:

       prev[L]


===========================================================
SPECIAL NOTES ABOUT DP ARRAY
===========================================================

We use two 1D arrays:

    prev[]
    curr[]


-------------------------
prev[]
-------------------------

prev[] represents the previous row of the original
2D DP table.

For example:

    prev[j]

means:

    Maximum price obtainable using the previously processed
    pieces for rod length j.


-------------------------
curr[]
-------------------------

curr[] represents the current row of the original
2D DP table.

For example:

    curr[j]

means:

    Maximum price obtainable using the current piece and
    all previously processed pieces for rod length j.


-------------------------
Why Arrays.fill()?
-------------------------

The same curr[] array is reused for every iteration.

Therefore, before calculating a new row:

    Arrays.fill(curr, 0);

This resets all values.

Without resetting curr[], old values from the previous
iteration could remain in the current row.


===========================================================
SPECIAL NOTES ABOUT i AND i - 1
===========================================================

The DP loop uses:

    for(int i = 1; i < n + 1; i++)

This is equivalent to:

    for(int i = 1; i <= n; i++)


Why start from 1?

Because row 0 represents:

    No available pieces.

That is the base case.


But Java arrays are 0-indexed.

Therefore:

    i = 1 -> length[0], price[0]
    i = 2 -> length[1], price[1]
    i = 3 -> length[2], price[2]

Hence:

    length[i - 1]
    price[i - 1]


The same concept appears in:

    price[i - 1] + curr[j - length[i - 1]]


===========================================================
SPECIAL NOTES ABOUT UNBOUNDED KNAPSACK
===========================================================

This is the most important concept in this problem.

For 0/1 Knapsack:

    INCLUDE:
    value + prev[remainingCapacity]

because the current item can be used only once.

For Unbounded Knapsack:

    INCLUDE:
    value + curr[remainingCapacity]

because the current item can be used again.


Therefore:

    0/1 Knapsack
    -> previous row for INCLUDE

    Unbounded Knapsack
    -> current row for INCLUDE


In this problem:

    price[i - 1] + curr[j - length[i - 1]]

allows the same rod length to be selected repeatedly.


===========================================================
SPECIAL NOTES ABOUT curr = prev.clone()
===========================================================

At the end of every outer loop:

    prev = curr.clone();


This means:

    The completed current row becomes the previous row
    for the next iteration.


Why clone()?

Because:

    prev = curr;

would make both variables point to the SAME array.

Then modifying curr[] would also modify prev[].

Using:

    prev = curr.clone();

creates an independent copy.


Flow:

    Current row calculated
           |
           v
       curr[]
           |
           | clone()
           v
       prev[]
           |
           v
    Next iteration


===========================================================
SPECIAL NOTES ABOUT THE LOOPS
===========================================================

Outer loop:

    for(int i = 1; i < n + 1; i++)

Processes each available rod piece length.


Inner loop:

    for(int j = 1; j < L + 1; j++)

Processes every possible rod length from:

    1 to L


Why:

    j < L + 1

instead of:

    j <= L

Both are equivalent.

For example, if:

    L = 8

then:

    j < 9

means:

    j = 1, 2, 3, 4, 5, 6, 7, 8


===========================================================
SPECIAL NOTES ABOUT BASE CASE
===========================================================

When the rod length is 0:

    Maximum price = 0

because no positive-length piece can be cut from a rod of
length 0.

Therefore:

    prev[0] = 0

and:

    curr[0] = 0

This is initialized because Java initializes integer arrays
to 0 by default, and curr[] is also reset using:

    Arrays.fill(curr, 0);


===========================================================
WHY RETURN prev[L]?
===========================================================

The original 2D DP solution would return:

    dp[n][L]

because:

    n = all available pieces
    L = complete rod length

In the optimized version, the final row is stored in:

    prev[]

Therefore:

    dp[n][L]

is represented by:

    prev[L]

Hence:

    return prev[L];


===========================================================
TIME COMPLEXITY
===========================================================

There are:

    n

rows and:

    L

possible rod lengths.

Therefore:

    Time Complexity = O(n * L)


===========================================================
SPACE COMPLEXITY
===========================================================

We use only two arrays:

    prev[L + 1]
    curr[L + 1]

Therefore:

    Space Complexity = O(L)


This improves the original 2D DP space:

    O(n * L)

to:

    O(L)


===========================================================
SPECIAL NOTES
===========================================================

1. This is a space-optimized version of Rod Cutting.

2. Rod Cutting is a variation of Unbounded Knapsack.

3. The most important recurrence is:

       include = price[i - 1]
               + curr[j - length[i - 1]]

4. The use of curr[] in INCLUDE is what allows unlimited
   reuse of the current rod piece.

5. EXCLUDE always comes from:

       prev[j]

6. curr[] must be reset for every new row.

7. clone() is required when moving curr[] into prev[].

8. The final answer is stored at:

       prev[L]

9. Time Complexity:

       O(n * L)

10. Space Complexity:

       O(L)

*/


public class DP17 {

  public static int rodCutting(int length[], int price[], int L) {

    // Number of available rod piece lengths.
    // DP uses i = 1 to n, while Java arrays use index 0 to n - 1.
    int n = length.length;

    // curr[j] stores the maximum price for rod length j
    // using the current piece and previously processed pieces.
    int curr[] = new int[L + 1];

    // prev[j] stores the maximum price for rod length j
    // using only the previously processed pieces.
    int prev[] = new int[L + 1];

    // Base case:
    // With zero available pieces, maximum obtainable price is 0
    // for every possible rod length.
    Arrays.fill(prev, 0);

    // Process each available rod piece.
    // i represents the number of pieces considered so far.
    for (int i = 1; i < n + 1; i++) {

      // curr[] is reused for every row, so reset it before
      // calculating the new current DP row.
      Arrays.fill(curr, 0);

      // j represents the current rod length / capacity.
      for (int j = 1; j < L + 1; j++) {

        // Java arrays are 0-indexed, while DP rows start from 1.
        // Therefore, the current piece is at index i - 1.
        if (length[i - 1] <= j) {

          // INCLUDE:
          // Take the current rod piece.
          //
          // Because Rod Cutting is Unbounded Knapsack,
          // the same piece can be used again.
          //
          // Therefore, use curr[j - length[i - 1]]
          // from the SAME row.
          int include = price[i - 1] + curr[j - length[i - 1]];

          // EXCLUDE:
          // Do not use the current rod piece.
          // Use the result from the previous row.
          int exclude = prev[j];

          // Choose the option that gives maximum price.
          curr[j] = Math.max(include, exclude);

        } else {

          // Current piece is longer than the available rod length,
          // so it cannot be included.
          //
          // Therefore, carry forward the previous-row answer.
          curr[j] = prev[j];
        }
      }

      // The current row is now completely calculated.
      // Make an independent copy so that prev[] represents
      // the completed current row in the next iteration.
      //
      // clone() is important because:
      // prev = curr;
      // would make both variables refer to the same array.
      prev = curr.clone();
    }

    // Equivalent to dp[n][L] in the original 2D DP solution.
    // After processing all pieces, prev[] contains the final DP row.
    // Therefore, prev[L] contains the maximum price for the
    // complete rod length L.
    return prev[L];
  }

  public static void main(String[] args) {

    // Available rod piece lengths.
    int length[] = {1, 2, 3, 4, 5, 6, 7, 8};

    // Price corresponding to each available piece length.
    int price[] = {1, 5, 8, 9, 10, 17, 17, 20};

    // Total length of the original rod.
    int rodlength = 8;

    // Call the Rod Cutting function and print the maximum
    // obtainable price.
    System.out.println("Maximum obtainable price = " + rodCutting(length, price, rodlength));
  }
}