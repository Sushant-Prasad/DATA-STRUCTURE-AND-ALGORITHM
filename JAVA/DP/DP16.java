package DP;

/*
===========================================================
TITLE
===========================================================
Rod Cutting Problem Using Dynamic Programming (Tabulation)

===========================================================
PROBLEM STATEMENT
===========================================================

You are given a rod of length `L`.

For different possible piece lengths, the corresponding
prices are given.

Your task is to cut the rod into pieces such that the
TOTAL PRICE is maximized.

Each available piece length can be used MULTIPLE TIMES.

Therefore, the Rod Cutting Problem is a variation/type of
the Unbounded Knapsack Problem.

-----------------------------------------------------------
INPUT
-----------------------------------------------------------

int[] length
    Contains the available lengths of the rod pieces.

int[] price
    Contains the price corresponding to each length.

int L
    Total length of the original rod.

Example:

    length = {1, 2, 3, 4, 5, 6, 7, 8}

    price = {1, 5, 8, 9, 10, 17, 17, 20}

    L = 8

This means:

    Length 1 → Price 1
    Length 2 → Price 5
    Length 3 → Price 8
    Length 4 → Price 9
    Length 5 → Price 10
    Length 6 → Price 17
    Length 7 → Price 17
    Length 8 → Price 20

-----------------------------------------------------------
OUTPUT
-----------------------------------------------------------

Return the maximum price that can be obtained by cutting
the rod into pieces.

For the given example:

    Maximum Price = 22

One optimal cutting is:

    2 + 2 + 2 + 2

Price:

    5 + 5 + 5 + 5 = 20

Another optimal cutting is:

    2 + 6

Price:

    5 + 17 = 22

Therefore:

    Maximum Price = 22

-----------------------------------------------------------
CONSTRAINTS
-----------------------------------------------------------

• `length[]` and `price[]` should have the same size.
• Each length represents an available piece length.
• Each piece length can be used multiple times.
• The total length of selected pieces must not exceed L.

-----------------------------------------------------------
EDGE CASES
-----------------------------------------------------------

• L = 0 → maximum price = 0.
• No available pieces → maximum price = 0.
• A piece length greater than L cannot be selected.
• A length can be selected multiple times.

===========================================================
PROBLEM RESOURCE
===========================================================

• GeeksforGeeks:
  https://www.geeksforgeeks.org/problems/rod-cutting0840/1

===========================================================
INTUITION
===========================================================

Rod Cutting can be understood as a form of the
Unbounded Knapsack Problem.

In Unbounded Knapsack:

    weight → piece length
    value  → piece price
    capacity → total rod length

Therefore:

    wt[] → length[]
    val[] → price[]
    W    → L

-----------------------------------------------------------
UNBOUNDED KNAPSACK CONNECTION
-----------------------------------------------------------

For every available rod length, we have two choices:

1) INCLUDE the piece.
2) EXCLUDE the piece.

If we INCLUDE a piece of length:

    length[i - 1]

we add its price:

    price[i - 1]

and reduce the remaining rod length.

The important part is that the same piece length can
be selected again.

Therefore, the INCLUDE case uses the SAME ROW:

    price[i - 1] + dp[i][j - length[i - 1]]

This is exactly the same idea as Unbounded Knapsack:

    value + dp[i][j - weight]

-----------------------------------------------------------
EXCLUDE
-----------------------------------------------------------

If we do not use the current piece length:

    dp[i - 1][j]

We move to the previous row.

===========================================================
APPROACH
===========================================================

1) Find the number of available piece lengths:

       int n = length.length;

2) Create a 2D DP table:

       int dp[][] = new int[n + 1][L + 1];

3) Rows represent the available piece lengths.

4) Columns represent the rod length/capacity.

5) Initialize row 0 with 0.

   With zero available piece lengths, maximum price is 0.

6) Initialize column 0 with 0.

   A rod of length 0 gives price 0.

7) Process every piece length.

8) For every piece length, process every possible
   rod length from 1 through L.

9) If the current piece can fit:

       length[i - 1] <= j

   calculate two choices.

   INCLUDE:

       price[i - 1] + dp[i][j - length[i - 1]]

   EXCLUDE:

       dp[i - 1][j]

10) Store the maximum:

       dp[i][j] = Math.max(include, exclude);

11) If the piece cannot fit:

       dp[i][j] = dp[i - 1][j];

12) After filling the complete table:

       return dp[n][L];

===========================================================
EXAMPLE
===========================================================

Given:

    length = {1, 2, 3, 4, 5, 6, 7, 8}

    price = {1, 5, 8, 9, 10, 17, 17, 20}

    L = 8

The available pieces are:

    Length 1 → Price 1
    Length 2 → Price 5
    Length 3 → Price 8
    Length 4 → Price 9
    Length 5 → Price 10
    Length 6 → Price 17
    Length 7 → Price 17
    Length 8 → Price 20

An optimal solution is:

    Length 2 + Length 6

Total length:

    2 + 6 = 8

Total price:

    5 + 17 = 22

Therefore:

    Maximum Price = 22

===========================================================
DP TABLE
===========================================================

The DP table contains:

    n + 1 rows
    L + 1 columns

Here:

    n = 8
    L = 8

Therefore:

    9 rows
    9 columns

Rows represent available piece lengths:

    Row 0 → No piece lengths
    Row 1 → Length 1
    Row 2 → Lengths 1, 2
    Row 3 → Lengths 1, 2, 3
    ...
    Row 8 → All available lengths

Columns represent rod lengths:

    0  1  2  3  4  5  6  7  8

The final state:

    dp[8][8]

means:

    "Maximum price obtainable using all available
     piece lengths for a rod of length 8."

Therefore:

    dp[8][8] = 22

===========================================================
DRY RUN
===========================================================

Consider:

    length = 2
    price = 5

-----------------------------------------------------------
ROD LENGTH = 2
-----------------------------------------------------------

The piece fits because:

    2 <= 2

Include:

    5 + dp[i][2 - 2]

    = 5 + dp[i][0]

    = 5

Therefore:

    dp[i][2] = 5

-----------------------------------------------------------
ROD LENGTH = 4
-----------------------------------------------------------

The same length-2 piece can be selected again.

Include:

    5 + dp[i][4 - 2]

    = 5 + dp[i][2]

Since:

    dp[i][2] = 5

we get:

    5 + 5 = 10

Therefore:

    dp[i][4] = 10

This represents:

    2 + 2

-----------------------------------------------------------
ROD LENGTH = 6
-----------------------------------------------------------

Again, the length-2 piece can be reused:

    5 + dp[i][4]

    = 5 + 10

    = 15

Therefore:

    dp[i][6] = 15

This represents:

    2 + 2 + 2

This repeated use demonstrates why Rod Cutting is
an Unbounded Knapsack problem.

===========================================================
KEY POINTS
===========================================================

• Rod Cutting is a variation/type of Unbounded Knapsack.

• Piece length behaves like weight.

• Piece price behaves like value/profit.

• Total rod length behaves like knapsack capacity.

Therefore:

    length → weight
    price  → value
    L      → capacity

-----------------------------------------------------------
UNBOUNDED PROPERTY
-----------------------------------------------------------

A particular piece length can be used multiple times.

For example, if:

    length = 2

we can cut:

    2
    2 + 2
    2 + 2 + 2
    2 + 2 + 2 + 2

as long as the total length does not exceed L.

-----------------------------------------------------------
RECURRENCE
-----------------------------------------------------------

If:

    length[i - 1] <= j

then:

    dp[i][j] = Math.max(
        price[i - 1] + dp[i][j - length[i - 1]],
        dp[i - 1][j]
    );

Otherwise:

    dp[i][j] = dp[i - 1][j];

===========================================================
SPECIAL NOTES ABOUT DP ARRAY
===========================================================

The DP state is:

    dp[i][j]

where:

    i = number of available piece lengths
    j = current rod length

Meaning:

    dp[i][j]

represents the maximum price obtainable using the first
i available piece lengths for a rod of length j.

For example:

    dp[3][7]

means:

    "Maximum price obtainable using the first 3 available
     piece lengths for a rod of length 7."

-----------------------------------------------------------
WHY IS THE DP ARRAY 2D?
-----------------------------------------------------------

There are two changing variables:

1) Number of available piece lengths.
2) Current rod length.

Therefore:

    dp[i][j]

is required.

===========================================================
SPECIAL NOTES ABOUT i AND i - 1
===========================================================

The outer loop is:

    for(int i = 1; i < n + 1; i++)

Here `i` represents the number of piece lengths currently
being considered.

Therefore:

    i = 1 → first piece length
    i = 2 → first two piece lengths
    i = 3 → first three piece lengths
    ...
    i = n → all piece lengths

However, Java arrays are 0-indexed.

Therefore:

    length[i - 1]

and:

    price[i - 1]

are used.

For example:

    i = 1

means the first piece.

The first piece is:

    length[0]
    price[0]

Therefore:

    i - 1 = 0

===========================================================
SPECIAL NOTES ABOUT WHY INCLUDE USES dp[i][j - length[i - 1]]
===========================================================

This is the MOST IMPORTANT concept in Rod Cutting.

The INCLUDE expression is:

    price[i - 1] + dp[i][j - length[i - 1]]

Notice that the row remains:

    i

It does NOT become:

    i - 1

Why?

Because the same piece length can be used again.

This makes Rod Cutting an Unbounded Knapsack problem.

-----------------------------------------------------------
EXAMPLE
-----------------------------------------------------------

Suppose:

    current piece length = 2
    current piece price  = 5

At rod length:

    j = 6

If we include a length-2 piece:

    Remaining length = 6 - 2
                     = 4

So:

    5 + dp[i][4]

If dp[i][4] already contains another use of the
length-2 piece, we can use it again.

Therefore:

    2 + 2 + 2

is possible.

-----------------------------------------------------------
0/1 KNAPSACK
-----------------------------------------------------------

In 0/1 Knapsack:

    value + dp[i - 1][j - weight]

The row changes to:

    i - 1

because the current item cannot be used again.

-----------------------------------------------------------
UNBOUNDED KNAPSACK / ROD CUTTING
-----------------------------------------------------------

In Unbounded Knapsack:

    value + dp[i][j - weight]

The row remains:

    i

because the current item can be reused.

Therefore, Rod Cutting follows the Unbounded Knapsack
recurrence.

===========================================================
SPECIAL NOTES ABOUT EXCLUDE CASE
===========================================================

The EXCLUDE case is:

    dp[i - 1][j]

This means:

    Do not use the current piece length.

We move to the previous row because the current piece
length is completely removed from consideration.

Therefore:

    INCLUDE → same row
    EXCLUDE → previous row

This is exactly the structure of Unbounded Knapsack.

===========================================================
SPECIAL NOTES ABOUT i < n + 1
===========================================================

The loop:

    for(int i = 1; i < n + 1; i++)

is equivalent to:

    for(int i = 1; i <= n; i++)

If:

    n = 8

then i becomes:

    1, 2, 3, 4, 5, 6, 7, 8

Therefore, all 8 available piece lengths are processed.

Row 0 is reserved for the base case:

    No available piece lengths.

===========================================================
SPECIAL NOTES ABOUT j < L + 1
===========================================================

The loop:

    for(int j = 1; j < L + 1; j++)

is equivalent to:

    for(int j = 1; j <= L; j++)

If:

    L = 8

then j becomes:

    1, 2, 3, 4, 5, 6, 7, 8

Therefore, the complete rod length range is processed.

Column 0 is reserved for the base case:

    Rod length = 0

===========================================================
SPECIAL NOTES ABOUT BASE CASES
===========================================================

Column 0:

    dp[i][0] = 0

Reason:

    A rod of length 0 has no material to cut.

Therefore maximum price is 0.

Row 0:

    dp[0][j] = 0

Reason:

    No piece lengths are available.

Therefore no profit can be generated.

===========================================================
SPECIAL NOTES ABOUT ROD CUTTING AS UNBOUNDED KNAPSACK
===========================================================

Rod Cutting can be directly mapped to Unbounded Knapsack.

-----------------------------------------------------------
ROD CUTTING
-----------------------------------------------------------

    length[] → available piece sizes
    price[]  → value/profit
    L        → total rod length

-----------------------------------------------------------
UNBOUNDED KNAPSACK
-----------------------------------------------------------

    wt[] → item weights
    val[] → item values
    W    → knapsack capacity

Therefore:

    length ≈ weight
    price  ≈ value
    L      ≈ capacity

The recurrence is also the same.

Rod Cutting:

    price[i - 1] + dp[i][j - length[i - 1]]

Unbounded Knapsack:

    value[i - 1] + dp[i][j - weight[i - 1]]

The same-row dependency proves the unbounded nature.

===========================================================
SPECIAL NOTES ABOUT RETURN VALUE
===========================================================

The final state is:

    dp[n][L]

Why?

Because the original problem asks:

    "What is the maximum price obtainable using all
     available piece lengths for a rod of total length L?"

Therefore:

    i = n
    j = L

So:

    dp[n][L]

represents exactly the original problem.

===========================================================
TIME COMPLEXITY
===========================================================

There are:

    n

available piece lengths.

For every piece length, we process:

    L

possible rod lengths.

Therefore:

    Time Complexity = O(n × L)

===========================================================
SPACE COMPLEXITY
===========================================================

The DP table contains:

    (n + 1) × (L + 1)

states.

Therefore:

    Space Complexity = O(n × L)

This can later be optimized to:

    O(L)

using the same space-optimization idea used for
Unbounded Knapsack.

===========================================================
SPECIAL NOTES
===========================================================

1. Rod Cutting is a variation/type of Unbounded Knapsack.

2. Each rod piece length can be used multiple times.

3. `length[]` acts like `wt[]`.

4. `price[]` acts like `val[]`.

5. `L` acts like knapsack capacity `W`.

6. Include case:

       price[i - 1] + dp[i][j - length[i - 1]]

7. Exclude case:

       dp[i - 1][j]

8. The INCLUDE case stays in the same row because the
   current piece length can be reused.

9. The EXCLUDE case moves to the previous row because
   the current piece length is not used.

10. `i - 1` is used to convert the 1-based DP item index
    into the 0-based Java array index.

11. `j - length[i - 1]` represents the remaining rod length
    after making the current cut.

12. `dp[n][L]` is the final answer.

13. Time Complexity:

        O(n × L)

14. Space Complexity:

        O(n × L)

15. The space-optimized version can reduce space to:

        O(L)

===========================================================
*/

public class DP16 {

  public static int rodCutting(int length[], int price[], int L) {

    // Number of available rod piece lengths.
    int n = length.length;

    // Create the 2D DP table.
    // Rows represent available piece lengths.
    // Columns represent the current rod length.
    int dp[][] = new int[n + 1][L + 1];

    // Initialize row 0.
    // With zero available piece lengths, maximum price is 0.
    for(int i = 0; i < n + 1; i++) {
      dp[0][i] = 0;
    }

    // Initialize column 0.
    // A rod of length 0 gives maximum price 0.
    for(int i = 0; i < n + 1; i++) {
      dp[i][0] = 0;
    }

    // Process every available piece length.
    // i represents the number of piece lengths being considered.
    for(int i = 1; i < n + 1; i++) {

      // Process every possible rod length from 1 through L.
      for(int j = 1; j < L + 1; j++) {

        // Check whether the current piece length can fit
        // inside the current rod length.
        if(length[i - 1] <= j) {

          // INCLUDE the current piece.
          // Same row i is used because the piece can be
          // selected multiple times.
          int include = price[i - 1] + dp[i][j - length[i - 1]];

          // EXCLUDE the current piece.
          // Move to the previous row because this piece
          // is not considered.
          int exclude = dp[i - 1][j];

          // Store the better choice.
          dp[i][j] = Math.max(include, exclude);

        } else {

          // Current piece cannot fit, so exclude it.
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    // dp[n][L] represents the maximum price obtainable
    // using all available piece lengths for rod length L.
    return dp[n][L];
  }

  public static void main(String[] args) {

    // Available rod piece lengths.
    int length[] = {1, 2, 3, 4, 5, 6, 7, 8};

    // Price corresponding to each available piece length.
    int price[] = {1, 5, 8, 9, 10, 17, 17, 20};

    // Total length of the original rod.
    int rodlength = 8;

    // Calculate and print the maximum obtainable price.
    System.out.println("Maximum obtainable price = "+rodCutting(length, price, rodlength));
  }
}