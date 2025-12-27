/*
===========================================================
TITLE
===========================================================
Check Whether a Number Is a Power of 2 Using Bit Manipulation

===========================================================
PROBLEM STATEMENT
===========================================================
Given an integer `n`, determine whether it is a **power of 2**.

A number is said to be a power of 2 if it can be expressed as:
2^k where k ≥ 0 (e.g., 1, 2, 4, 8, 16, ...).

Print:
• "number is power of 2"      → if `n` is a power of 2
• "number is not power of 2"  → otherwise

===========================================================
PROBLEM RESOURCE (links)
===========================================================
https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1

===========================================================
INTUITION
===========================================================
A power of 2 has a special binary property:
- It has **exactly one bit set to 1**
- All other bits are 0

Example:
1  → 0001
2  → 0010
4  → 0100
8  → 1000

If we subtract 1 from a power of 2:
- All bits after the single set bit become 1
- AND-ing the number with (n - 1) results in 0

===========================================================
APPROACH
===========================================================
1) Compute `n & (n - 1)`.
2) If the result is 0, then `n` is a power of 2.
3) Otherwise, it is not a power of 2.
4) Print the corresponding message.

===========================================================
EXAMPLE
===========================================================
Input:  n = 8
Binary: 1000

n - 1 = 7 → 0111
n & (n - 1) = 1000 & 0111 = 0000

Output:
number is power of 2

===========================================================
DRY RUN
===========================================================
n = 6
Binary: 110

n - 1 = 5 → 101
n & (n - 1) = 110 & 101 = 100 ≠ 0

Output:
number is not power of 2

===========================================================
KEY POINTS
===========================================================
• Works only for positive integers
• Uses a single bitwise operation
• Very efficient compared to looping or division
• Commonly asked interview trick

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
• For correctness, `n` should be greater than 0
• When n = 0, this logic incorrectly treats it as power of 2
  (edge case can be handled separately if required)
===========================================================
*/

package BitManipulation;

import java.util.*;

public class bit6 {

    // Function to check whether a number is a power of 2
    public static void powerOf2(int n) {

        // Perform bitwise AND of n and (n - 1)
        int x = n & (n - 1);

        // If result is 0, number has only one set bit
        if (x == 0) {
            System.out.println("number is power of 2");
        } else {
            System.out.println("number is not power of 2 ");
        }
    }

    public static void main(String args[]) {

        int n;

        Scanner sc = new Scanner(System.in);

        System.out.println("enter any number");
        n = sc.nextInt(); // Read input number

        // Check if the number is power of 2
        powerOf2(n);
    }
}
