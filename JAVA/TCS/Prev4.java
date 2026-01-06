/*
===========================================================
TITLE
===========================================================
Row with Maximum Number of Filled Parking Spaces

===========================================================
PROBLEM STATEMENT
===========================================================
A parking lot in a mall has R × C parking spaces.

Each parking space can be:
• 0 → Empty
• 1 → Full

The parking lot status is represented as a matrix M[R][C].

Your task is to find the **index of the row (1-based indexing)**
that has the **maximum number of full parking spaces (1’s)**.

If multiple rows have the same maximum number of 1’s,
the **first such row** should be considered.

===========================================================
INPUT FORMAT
===========================================================
• First input  → Integer R (number of rows)
• Second input → Integer C (number of columns)
• Next R × C inputs → Elements of the matrix (0 or 1),
  entered row-wise, each separated by a new line

===========================================================
OUTPUT FORMAT
===========================================================
• Print a single integer representing the **row number (1-based)**
  which has the maximum number of 1’s

===========================================================
CONSTRAINTS
===========================================================
• 1 ≤ R, C
• Matrix elements must be either 0 or 1

===========================================================
INTUITION
===========================================================
To find the row with the maximum number of occupied parking spaces:
• Count the number of 1’s in each row
• Track the row having the highest count

===========================================================
APPROACH
===========================================================
1) Read values of R and C
2) Read the matrix M[R][C]
3) For each row:
   - Count the number of 1’s
4) Keep track of:
   - Maximum count of 1’s seen so far
   - Row index where this maximum occurs
5) Print the row index (1-based)

===========================================================
EXAMPLE 1
===========================================================
Input:
R = 3
C = 3
Matrix:
0 1 0
1 1 0
1 1 1

Output:
3

Explanation:
Row 3 has the maximum number of 1’s (3)

===========================================================
EXAMPLE 2
===========================================================
Input:
R = 4
C = 3
Matrix:
0 1 0
1 1 0
1 0 1
1 1 1

Output:
4

===========================================================
DRY RUN
===========================================================
Row 1 → 1 one
Row 2 → 2 ones
Row 3 → 2 ones
Row 4 → 3 ones → maximum

Answer = 4

===========================================================
KEY POINTS
===========================================================
• Row indexing is 1-based in output
• Simple row-wise counting
• Works for any valid 0/1 matrix

===========================================================
TIME COMPLEXITY
===========================================================
O(R × C)
- Each element of the matrix is visited once

===========================================================
SPACE COMPLEXITY
===========================================================
O(R × C)
- Matrix storage

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• `maxCount` stores the maximum number of 1’s found so far
• `res` stores the row number (1-based index)
• First row with maximum count is retained
===========================================================
*/

package TCS;
import java.util.*;

public class Prev4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of rows
        int r = sc.nextInt();

        // Read number of columns
        int c = sc.nextInt();

        // Matrix to store parking lot status
        int[][] mat = new int[r][c];

        // Read matrix elements
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int maxCount = 0; // Maximum number of 1’s found
        int res = 0;      // Row index with maximum 1’s (1-based)

        // Traverse each row
        for (int i = 0; i < r; i++) {

            int count = 0; // Count of 1’s in current row

            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1)
                    count++;
            }

            // Update result if current row has more 1’s
            if (count > maxCount) {
                maxCount = count;
                res = i + 1; // Convert to 1-based index
            }
        }

        // Print the row number with maximum occupied spaces
        System.out.println(res);
    }
}
