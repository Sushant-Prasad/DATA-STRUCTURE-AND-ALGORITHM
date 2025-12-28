/*
===========================================================
TITLE
===========================================================
Count Number of Set Bits (1s) in an Integer Using Bit Manipulation

===========================================================
PROBLEM STATEMENT
===========================================================
Given an integer `n`, count the total number of **set bits**
(1s) present in its binary representation.

A set bit is a bit whose value is 1.

===========================================================
PROBLEM RESOURCE (links)
===========================================================
https://practice.geeksforgeeks.org/problems/set-bits0143/1

===========================================================
INTUITION
===========================================================
Every integer is internally represented in binary form.

Key idea:
- The **least significant bit (LSB)** of a number can be checked using:
  `n & 1`
- If LSB is 1, then the number has a set bit.
- By right-shifting the number (`n >> 1`), we move to the next bit.

By repeatedly checking the LSB and shifting, we can count all set bits.

===========================================================
APPROACH
===========================================================
1) Initialize a counter `count` to 0.
2) While `n` is greater than 0:
   - Check if the LSB is set using `(n & 1)`
   - If yes, increment `count`
   - Right shift `n` by 1 to process the next bit
3) Return the final count.

===========================================================
EXAMPLE
===========================================================
Input:
n = 13

Binary representation:
13 → 1101

Set bits:
1, 1, 1 → total = 3

Output:
3

===========================================================
DRY RUN
===========================================================
n = 10 → binary: 1010

Iteration 1:
n = 10 → (n & 1) = 0 → count = 0
n >> 1 → 5

Iteration 2:
n = 5 → (n & 1) = 1 → count = 1
n >> 1 → 2

Iteration 3:
n = 2 → (n & 1) = 0 → count = 1
n >> 1 → 1

Iteration 4:
n = 1 → (n & 1) = 1 → count = 2
n >> 1 → 0

Loop ends → return 2

===========================================================
KEY POINTS
===========================================================
• `(n & 1)` checks the least significant bit
• Right shift (`>>`) moves to the next bit
• Works only for non-negative integers
• Simple and easy-to-understand approach

===========================================================
TIME COMPLEXITY
===========================================================
O(log n)
- Number of iterations equals number of bits in `n`

===========================================================
SPACE COMPLEXITY
===========================================================
O(1), constant extra space

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• For faster counting, Brian Kernighan’s algorithm can be used
• This approach is beginner-friendly and interview-safe
===========================================================
*/

package BitManipulation;

import java.util.*;

public class bit7 {

    // Function to count number of set bits in an integer
    public static int countSetBit(int n) {

        int count = 0; // Stores number of set bits

        // Loop until all bits are processed
        while (n > 0) {

            // Check if least significant bit is set
            if ((n & 1) != 0) {
                count++;
            }

            // Right shift to check next bit
            n = n >> 1;
        }

        return count; // Return total set bits
    }

    public static void main(String args[]) {

        int n;
        Scanner sc = new Scanner(System.in);

        System.out.println("enter any number");
        n = sc.nextInt(); // Read input

        // Print number of set bits
        System.out.println("number of setbit is " + countSetBit(n));
    }
}
