package BitManipulation;

import java.util.*;

public class bit {

    // =========================================================================
    //  TITLE:
    //  Check Whether a Number is Odd or Even using Bit Manipulation
    // =========================================================================
    //
    //  PROBLEM STATEMENT:
    //  ------------------
    //  Given an integer `n`, determine whether the number is ODD or EVEN
    //  using bit manipulation (without using arithmetic operators like %).
    //
    // =========================================================================
    //  INTUITION:
    //  ----------
    //  • Every integer is represented in binary format.
    //  • The Least Significant Bit (LSB) decides the parity of a number:
    //        - If LSB = 1 → the number is ODD
    //        - If LSB = 0 → the number is EVEN
    //
    //  Example:
    //      5  → 101  → LSB = 1 → Odd
    //      6  → 110  → LSB = 0 → Even
    //
    // =========================================================================
    //  APPROACH:
    //  ----------
    //  1. Create a bitmask with value 1 (binary: 0001).
    //  2. Perform bitwise AND between the number and the bitmask.
    //  3. Check the result:
    //        - If (n & 1) == 1 → Odd
    //        - Else → Even
    //
    // =========================================================================
    //  SPECIAL NOTES FOR LOGIC:
    //  ------------------------
    //  • Bitwise AND (&) compares corresponding bits.
    //  • Only the LSB is checked, which is enough to decide odd/even.
    //  • This method is faster and more efficient than using n % 2.
    //
    // =========================================================================
    //  EXAMPLE:
    //  --------
    //      Input:  n = 7
    //      Binary: 111
    //
    //      n & 1 = 1 → Odd number
    //
    // =========================================================================
    //  DRY RUN:
    //  --------
    //      n = 10
    //      Binary of n = 1010
    //
    //      bitmask = 0001
    //      ----------------
    //      n & bitmask = 0000
    //
    //      Result = 0 → Even number
    //
    // =========================================================================
    //  KEY POINTS:
    //  ------------
    //  ✔ Uses bit manipulation instead of arithmetic
    //  ✔ Checks only one bit (LSB)
    //  ✔ Works for all integers
    //  ✔ Very common interview & exam question
    //
    // =========================================================================
    //  TIME COMPLEXITY:
    //      O(1)  (constant time operation)
    //
    //  SPACE COMPLEXITY:
    //      O(1)  (no extra space used)
    //
    // =========================================================================
    public static void oddeven(int n) {

        int bitmask = 1;   // Bitmask to isolate the Least Significant Bit (LSB)

        if ((n & bitmask) == 1) {
            System.out.println("Odd number");
        } else {
            System.out.println("Even number");
        }
    }

    // =========================================================================
    //  MAIN METHOD
    // =========================================================================
    //
    //  • Accepts input from the user
    //  • Calls the oddeven() method
    //
    // =========================================================================
    public static void main(String args[]) {

        int n;

        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.println("Enter any number:");
        n = sc.nextInt();

        // Check whether the number is odd or even
        oddeven(n);
    }
}
