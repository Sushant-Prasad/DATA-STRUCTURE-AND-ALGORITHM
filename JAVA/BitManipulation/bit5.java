/*
===========================================================
TITLE
===========================================================
Clear Last i Bits of a Number Using Bit Manipulation

===========================================================
PROBLEM STATEMENT
===========================================================
Given an integer `n` and an integer `i`, clear (set to 0) the
**last i bits** of the number `n`.

Return the new number after clearing those bits.

===========================================================
PROBLEM RESOURCE (links)
===========================================================
https://practice.geeksforgeeks.org/problems/bit-manipulation-1587115620/1

===========================================================
INTUITION
===========================================================
In bit manipulation:
- Clearing a bit means setting it to `0`
- To clear the **last i bits**, we need a bitmask where:
  • Higher bits are `1`
  • Last i bits are `0`

If we AND (`&`) the number with such a mask:
- The last i bits become 0
- All other bits remain unchanged

===========================================================
APPROACH
===========================================================
1) Create a bitmask that has:
   - All 1s on the left
   - i zeros on the right
2) This can be achieved using:
   (~0) << i
3) Perform bitwise AND between `n` and the bitmask.
4) Return the resulting number.

===========================================================
EXAMPLE
===========================================================
Input:
n = 29  (binary: 11101)
i = 2

Bitmask:
(~0) << 2 → 11100

Result:
11101 & 11100 = 11100 (28)

Output:
28

===========================================================
DRY RUN
===========================================================
n = 15  → 00001111
i = 3

Step 1: Create bitmask
~0        → 11111111
(~0) << 3 → 11111000

Step 2: AND operation
00001111
&11111000
----------
00001000 → 8

===========================================================
KEY POINTS
===========================================================
• `~0` represents all bits set to 1
• Left shift (`<<`) introduces zeros on the right
• Bitwise AND clears selected bits
• Efficient and constant-time operation

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
• This method works for any non-negative integer
• Clearing bits does not affect higher-order bits
• Commonly used in low-level and performance-critical code
===========================================================
*/

package BitManipulation;

// clear last i bits
import java.util.Scanner;

public class bit5 {

    // Function to clear the last i bits of number n
    public static int clearLastIBits(int n, int i) {

        // Create a bitmask with all 1s except last i bits as 0
        int bitmask = (~0) << i;

        // AND operation clears the last i bits
        return n & bitmask;
    }

    public static void main(String args[]) {

        int n, i;

        Scanner sc = new Scanner(System.in);

        System.out.println("enter any number");
        n = sc.nextInt(); // Read the number

        System.out.println("enter the no. of bit you want to clear from last");
        i = sc.nextInt(); // Read number of bits to clear

        // Display result after clearing last i bits
        System.out.println("new number is " + clearLastIBits(n, i));
    }
}
