package BitManipulation;

import java.util.Scanner;

public class bit2 {

    // =========================================================================
    //  TITLE:
    //  Get the i-th Bit of a Number using Bit Manipulation
    // =========================================================================
    //
    //  PROBLEM STATEMENT:
    //  ------------------
    //  Given an integer `n` and a bit position `i`,
    //  determine whether the i-th bit of `n` is 0 or 1.
    //
    //  Note:
    //  • Bit positions are counted from right to left.
    //  • Indexing starts from 0 (0th bit is the LSB).
    //
    // =========================================================================
    //  INTUITION:
    //  ----------
    //  • Every number is stored in binary form.
    //  • To check a specific bit, we isolate that bit using a bitmask.
    //
    // =========================================================================
    //  APPROACH:
    //  ----------
    //  1. Create a bitmask by left-shifting 1 by `i` positions.
    //         bitmask = 1 << i
    //
    //  2. Perform bitwise AND between `n` and the bitmask.
    //
    //  3. If the result is:
    //        • 0 → the i-th bit is 0
    //        • non-zero → the i-th bit is 1
    //
    // =========================================================================
    //  SPECIAL NOTES FOR LOGIC:
    //  ------------------------
    //  • (1 << i) sets only the i-th bit to 1.
    //  • Bitwise AND (&) helps us check whether that bit is set in `n`.
    //  • Indexing starts from 0 (important for exams & interviews).
    //
    // =========================================================================
    //  EXAMPLE:
    //  --------
    //      n = 10
    //      Binary representation = 1010
    //
    //      i = 1
    //      1st bit (from right) = 1
    //
    // =========================================================================
    //  DRY RUN:
    //  --------
    //      n = 10  → 1010
    //      i = 2
    //
    //      bitmask = 1 << 2 = 0100
    //
    //      n & bitmask = 1010 & 0100 = 0000
    //
    //      Result = 0 → 2nd bit is 0
    //
    // =========================================================================
    //  KEY POINTS:
    //  ------------
    //  ✔ Uses bitwise left shift (<<)
    //  ✔ Uses bitwise AND (&)
    //  ✔ Constant-time operation
    //  ✔ Very common DSA & interview question
    //
    // =========================================================================
    //  TIME COMPLEXITY:
    //      O(1)
    //
    //  SPACE COMPLEXITY:
    //      O(1)
    //
    // =========================================================================
    public static void getIthBit(int n, int i) {

        // Create bitmask by shifting 1 to the i-th position
        int bitmask = 1 << i;   // indexing starts from 0

        // Check if the i-th bit is 0 or 1
        if ((n & bitmask) == 0) {
            System.out.println(i + "th bit is 0");
        } else {
            System.out.println(i + "th bit is 1");
        }
    }

    // =========================================================================
    //  MAIN METHOD
    // =========================================================================
    //
    //  • Takes input from the user
    //  • Calls getIthBit() method
    //
    // =========================================================================
    public static void main(String args[]) {

        int n, i;

        Scanner sc = new Scanner(System.in);

        // Input number
        System.out.println("Enter any number:");
        n = sc.nextInt();

        // Input bit position
        System.out.println("Enter the position of bit you want to know:");
        i = sc.nextInt();

        // Get i-th bit of the number
        getIthBit(n, i);
    }
}
