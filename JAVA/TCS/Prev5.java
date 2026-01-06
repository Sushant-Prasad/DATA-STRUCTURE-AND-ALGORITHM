/*
===========================================================
TITLE
===========================================================
Maximum Number of Guests on Cruise at Any Time

===========================================================
PROBLEM STATEMENT
===========================================================
A party is organized on a cruise for a limited time `T` hours.

You are given:
• An array `E[]` where E[i] represents the number of guests
  entering the cruise at the i-th hour.
• An array `L[]` where L[i] represents the number of guests
  leaving the cruise at the i-th hour.

Your task is to find the **maximum number of guests present
on the cruise at any given instance during the T hours**.

===========================================================
INPUT FORMAT
===========================================================
• First input  → Integer T (number of hours)
• Second input → T integers representing array E[]
                (each element separated by a new line)
• Third input  → T integers representing array L[]
                (each element separated by a new line)

===========================================================
OUTPUT FORMAT
===========================================================
• Print a single positive integer representing the
  maximum number of guests present on the cruise
  at any time during T hours.

===========================================================
CONSTRAINTS
===========================================================
• 1 ≤ T ≤ 25
• 0 ≤ E[i] ≤ 500
• 0 ≤ L[i] ≤ 500

===========================================================
INTUITION
===========================================================
At any hour:
Current guests = Total entered so far − Total exited so far

So, if we:
• Maintain cumulative sum of entries
• Maintain cumulative sum of exits
• Compute the difference at each hour

The maximum difference gives the maximum guests present
at any instance.

===========================================================
APPROACH
===========================================================
1) Read integer T
2) Read array E[] of size T
3) Read array L[] of size T
4) Convert E[] into prefix sum (total entries till each hour)
5) Convert L[] into prefix sum (total exits till each hour)
6) For each hour:
   - Calculate current guests = E[i] − L[i]
   - Track the maximum value
7) Print the maximum number of guests

===========================================================
EXAMPLE 1
===========================================================
Input:
T = 5
E = [7, 0, 5, 1, 3]
L = [1, 2, 1, 3, 4]

Guests per hour:
Hour 1 → 7 - 1 = 6
Hour 2 → 7 - 3 = 4
Hour 3 → 12 - 4 = 8
Hour 4 → 13 - 7 = 6
Hour 5 → 16 - 11 = 5

Output:
8

===========================================================
EXAMPLE 2
===========================================================
Input:
T = 4
E = [3, 5, 2, 0]
L = [0, 2, 4, 4]

Guests per hour:
Hour 1 → 3
Hour 2 → 6
Hour 3 → 4
Hour 4 → 0

Output:
6

===========================================================
DRY RUN
===========================================================
E prefix: [7, 7, 12, 13, 16]
L prefix: [1, 3, 4, 7, 11]

Differences:
[6, 4, 8, 6, 5]

Maximum = 8

===========================================================
KEY POINTS
===========================================================
• Prefix sum technique simplifies tracking
• No negative guest count considered
• Output is always a non-negative integer
• Efficient and easy to implement

===========================================================
TIME COMPLEXITY
===========================================================
O(T)
- Single traversal of arrays

===========================================================
SPACE COMPLEXITY
===========================================================
O(1)
- Uses input arrays only (in-place prefix sums)

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• E[i] stores cumulative entries after prefix sum
• L[i] stores cumulative exits after prefix sum
• Maximum of (E[i] − L[i]) is the answer
===========================================================
*/

package TCS;
import java.util.*;

public class Prev5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of hours
        int t = sc.nextInt();

        // Array to store number of guests entering each hour
        int[] E = new int[t];
        for (int i = 0; i < t; i++)
            E[i] = sc.nextInt();

        // Array to store number of guests leaving each hour
        int[] L = new int[t];
        for (int i = 0; i < t; i++)
            L[i] = sc.nextInt();

        int sumEntry = 0;
        int sumExit = 0;

        // Convert E and L into prefix sums
        for (int i = 0; i < t; i++) {
            sumEntry += E[i];
            E[i] = sumEntry;

            sumExit += L[i];
            L[i] = sumExit;
        }

        int maxGuests = 0;

        // Find maximum difference between entries and exits
        for (int i = 0; i < t; i++) {
            int currentGuests = E[i] - L[i];
            maxGuests = Math.max(maxGuests, currentGuests);
        }

        // Print maximum guests present at any instance
        System.out.println(maxGuests);
    }
}
