/*
===========================================================
TITLE
===========================================================
Clear a Range of Bits (from i to j) Using Bit Manipulation

===========================================================
PROBLEM STATEMENT
===========================================================
Given an integer `n` and two integers `i` and `j`,
clear (set to 0) all bits in the range **i to j (inclusive)**.

Bit positions are **0-based**, starting from the least significant bit (LSB).

Return the new number after clearing the specified range of bits.

===========================================================
PROBLEM RESOURCE (links)
===========================================================
https://practice.geeksforgeeks.org/problems/bit-manipulation-1587115620/1

===========================================================
INTUITION
===========================================================
To clear bits in a specific range:
- We need a **bitmask** that has:
  • 0s in the range [i, j]
  • 1s everywhere else

When we perform:
    n & bitmask
all bits in the range [i, j] become 0,
and the remaining bits stay unchanged.

===========================================================
APPROACH
===========================================================
1) Create a mask `a` with:
   - All 1s before bit position (j + 1)
   - 0s from j downwards
   → achieved using: `(~0) << (j + 1)`

2) Create a mask `b` with:
   - 1s in positions [0, i-1]
   - 0s elsewhere
   → achieved using: `(1 << i) - 1`

3) Combine both masks using OR (`|`):
   - This creates a final mask with 0s only in range [i, j]

4) AND the number `n` with the final mask to clear the range.

===========================================================
EXAMPLE
===========================================================
Input:
n = 31  (binary: 11111)
i = 1, j = 3

Step 1:
a = (~0) << 4 → 11110000
b = (1 << 1) - 1 → 00000001

bitmask = a | b → 11110001

Result:
11111
&11110001
---------
10001 → 17

Output:
17

===========================================================
DRY RUN
===========================================================
n = 63 → 00111111
i = 2, j = 4

a = (~0) << 5 → 11100000
b = (1 << 2) - 1 → 00000011

bitmask = 11100011

n & bitmask:
00111111
&11100011
---------
00100011 → 35

===========================================================
KEY POINTS
===========================================================
• Uses bitmasking to clear a specific bit range
• No loops required (constant-time operation)
• Bit positions are 0-based
• Very efficient and commonly used technique

===========================================================
TIME COMPLEXITY
===========================================================
O(1)

===========================================================
SPACE COMPLEXITY
===========================================================
O(1)

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• `(~0)` represents all bits set to 1
• Left shift introduces 0s on the right
• OR (`|`) combines upper and lower masks
• AND (`&`) clears the selected bit range
===========================================================
*/

package BitManipulation;
import java.util.*;

public class bit8 {

    // Function to clear bits from position i to j (inclusive)
    public static int clearRangeOfBits(int n, int i, int j) {

        // Mask with 1s before j+1 and 0s after
        int a = (~0) << (j + 1);

        // Mask with 1s before i and 0s after
        int b = (1 << i) - 1;

        // Combined mask with 0s in range [i, j]
        int bitmask = a | b;

        // Clear bits in range [i, j]
        return n & bitmask;
    }

    public static void main(String args[]) {

        int n, i, j;
        Scanner sc = new Scanner(System.in);

        System.out.println("enter any number");
        n = sc.nextInt(); // Input number

        System.out.println("enter the range ");
        i = sc.nextInt(); // Starting bit position
        j = sc.nextInt(); // Ending bit position

        // Print result after clearing bits
        System.out.println("new number is " + clearRangeOfBits(n, i, j));
    }
}
