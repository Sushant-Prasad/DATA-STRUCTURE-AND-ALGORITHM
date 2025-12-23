package BitManipulation;

import java.util.*;

/*
 ============================================================================
 TITLE:
 ------
 Clear the i-th Bit of a Number using Bit Manipulation

 ============================================================================
 PROBLEM STATEMENT:
 ------------------
 Given an integer `n` and an index `i`, clear (set to 0) the i-th bit of `n`
 and return the new number.

 • Bit indexing starts from 0 (LSB is the 0th bit).

 ============================================================================
 PROBLEM RESOURCE:
 -----------------
 https://www.geeksforgeeks.org/clear-kth-bit-in-a-number/

 ============================================================================
 INTUITION:
 ----------
 • To clear a bit, we need to force that bit position to 0.
 • AND (`&`) with 0 clears a bit.
 • AND (`&`) with 1 keeps a bit unchanged.
 • So, we create a bitmask that has:
     - 0 at position i
     - 1 at all other positions

 ============================================================================
 APPROACH:
 ----------
 1. Create a bitmask by:
      (1 << i)          → sets only the i-th bit to 1
      ~(1 << i)         → flips bits, making i-th bit = 0, others = 1
 2. Perform AND operation:
      n & bitmask
 3. This clears the i-th bit of `n`.

 ============================================================================
 EXAMPLE:
 --------
 n = 10  → binary: 1010
 i = 1

 1 << 1        → 0010
 ~(1 << 1)     → 1101

 n & bitmask:
  1010
& 1101
 ------
  1000  → 8

 Output = 8

 ============================================================================
 DRY RUN:
 --------
 Input:
   n = 10
   i = 1

 Step 1:
   bitmask = ~(1 << 1)
            = ~(0010)
            = 1101

 Step 2:
   n & bitmask
   1010 & 1101 = 1000

 Result:
   8

 ============================================================================
 KEY POINTS:
 ------------
 ✔ Bit indexing starts from 0
 ✔ AND with 0 clears a bit
 ✔ AND with 1 preserves a bit
 ✔ Bitmask is the core idea

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(1)
 (Bitwise operations are constant time)

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(1)
 (No extra space used)

 ============================================================================
 SPECIAL NOTES FOR LOGIC :
 --------------------------
 • (1 << i) creates a number with only the i-th bit set
 • ~(1 << i) flips all bits → i-th bit becomes 0
 • n & bitmask clears exactly the i-th bit and keeps others unchanged
 ============================================================================
*/

public class bit4 {

    /*
     PURPOSE:
     --------
     Clears the i-th bit of integer n and returns the updated number.

     PARAMETERS:
     -----------
     n → original number
     i → bit position to clear (0-based index)

     RETURNS:
     --------
     Integer value after clearing the i-th bit
    */
    public static int clearIthBit(int n, int i) {

        // Create bitmask with 0 at i-th position and 1 elsewhere
        int bitmask = ~(1 << i); // indexing starts from 0

        // AND operation clears the i-th bit
        return n & bitmask;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Input number
        System.out.println("Enter any number:");
        int n = sc.nextInt();

        // Input bit position
        System.out.println("Enter the position of bit you want to clear:");
        int i = sc.nextInt();

        // Output result
        System.out.println("New number is: " + clearIthBit(n, i));
    }
}
