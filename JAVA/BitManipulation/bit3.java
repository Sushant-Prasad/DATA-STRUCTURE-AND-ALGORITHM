package BitManipulation;

import java.util.Scanner;

public class bit3 {

    // =========================================================================
    //  TITLE:
    //  Set the i-th Bit of a Number using Bit Manipulation
    // =========================================================================
    //
    //  PROBLEM STATEMENT:
    //  ------------------
    //  Given an integer `n` and a bit position `i`,
    //  set the i-th bit of `n` to 1 and return the new number.
    //
    //  Note:
    //  • Bit positions are 0-indexed (0th bit is the LSB).
    //
    // =========================================================================
    //  INTUITION:
    //  ----------
    //  • To set a bit means to make that bit equal to 1.
    //  • We can achieve this using a bitmask where only the i-th bit is set.
    //  • Bitwise OR (|) is used because:
    //        - 1 | 0 = 1
    //        - 1 | 1 = 1
    //
    // =========================================================================
    //  APPROACH:
    //  ----------
    //  1. Create a bitmask by left-shifting 1 by `i` positions.
    //         bitmask = 1 << i
    //
    //  2. Perform bitwise OR between `n` and the bitmask.
    //
    //         newNumber = n | bitmask
    //
    //  3. Return the updated number.
    //
    // =========================================================================
    //  SPECIAL NOTES FOR LOGIC:
    //  ------------------------
    //  • (1 << i) ensures only the i-th bit is set to 1.
    //  • OR operation guarantees the i-th bit becomes 1
    //    without affecting other bits.
    //  • If the bit is already 1, the number remains unchanged.
    //
    // =========================================================================
    //  EXAMPLE:
    //  --------
    //      n = 10  →  Binary: 1010
    //      i = 1
    //
    //      bitmask = 1 << 1 = 0010
    //
    //      n | bitmask = 1010 | 0010 = 1010
    //
    //      Result = 10
    //
    // =========================================================================
    //  DRY RUN:
    //  --------
    //      n = 8  →  1000
    //      i = 2
    //
    //      bitmask = 1 << 2 = 0100
    //
    //      n | bitmask = 1000 | 0100 = 1100
    //
    //      New number = 12
    //
    // =========================================================================
    //  KEY POINTS:
    //  ------------
    //  ✔ Uses bitwise left shift (<<)
    //  ✔ Uses bitwise OR (|)
    //  ✔ Very fast and efficient
    //  ✔ Common bit manipulation interview question
    //
    // =========================================================================
    //  TIME COMPLEXITY:
    //      O(1)
    //
    //  SPACE COMPLEXITY:
    //      O(1)
    //
    // =========================================================================
    public static int setIthBit(int n, int i) {

        int bitmask = 1 << i;   // Create bitmask with i-th bit set
        return n | bitmask;     // Set i-th bit using OR
    }

    // =========================================================================
    //  MAIN METHOD
    // =========================================================================
    //
    //  • Takes input from the user
    //  • Calls setIthBit() method
    //
    // =========================================================================
    public static void main(String args[]) {

        int n, i;

        Scanner sc = new Scanner(System.in);

        // Input number
        System.out.println("Enter any number:");
        n = sc.nextInt();

        // Input bit position
        System.out.println("Enter the position of bit you want to set:");
        i = sc.nextInt();

        // Output updated number
        System.out.println("New number is: " + setIthBit(n, i));
    }
}
