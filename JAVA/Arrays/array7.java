package Arrays;

// ============================================================================
//  TITLE:
//  Print All Possible Pairs in an Array
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given an array of integers, print all possible unique pairs
//  (a[i], a[j]) such that i < j.
//
// ============================================================================
//  INTUITION:
//  ----------
//  To form pairs, each element should be paired with every element
//  that comes after it in the array.
//  This avoids duplicate pairs and self-pairing.
//
// ============================================================================
//  APPROACH:
//  ----------
//  1. Use two nested loops.
//  2. Outer loop selects the first element of the pair.
//  3. Inner loop selects the second element starting from (i + 1).
//  4. Print each pair in the form (a[i], a[j]).
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Input Array : [1, 2, 3]
//      Output Pairs:
//      (1,2)
//      (1,3)
//      (2,3)
//
// ============================================================================
//  DRY RUN:
//  --------
//      a = [10, 20, 30], n = 3
//
//      i = 0 → j = 1 → (10,20)
//             j = 2 → (10,30)
//
//      i = 1 → j = 2 → (20,30)
//
//      i = 2 → no valid j
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Each pair is unique
//  ✔ No duplicate or reverse pairs
//  ✔ i < j ensures valid pairing
//  ✔ Simple nested loop logic
//
// ============================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • Inner loop always starts from i + 1
//  • Extra line after each outer iteration improves readability
//  • Works for any array size >= 2
//
// ============================================================================
//  TIME COMPLEXITY:  O(n²)
//  SPACE COMPLEXITY: O(1)
// ============================================================================
//

import java.util.*;

public class array7 {

    // ------------------------------------------------------------------------
    // METHOD NAME: Pairing
    // PURPOSE    : Prints all possible unique pairs in the array
    // ------------------------------------------------------------------------
    public static void Pairing(int a[], int n) {

        int i, j;

        // Outer loop selects first element of the pair
        for (i = 0; i < n; i++) {

            // Inner loop selects second element of the pair
            for (j = i + 1; j < n; j++) {
                System.out.println("(" + a[i] + "," + a[j] + ")");
            }

            // Print blank line after each outer iteration
            System.out.println();
        }
    }

    // ------------------------------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------------------------------
    public static void main(String args[]) {

        int i, n;
        int a[] = new int[50];

        Scanner sc = new Scanner(System.in);

        // Input size of array
        System.out.println("Enter size of array:");
        n = sc.nextInt();

        // Input array elements
        System.out.println("Enter elements of array:");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Print all possible pairs
        System.out.println("Pairs are:");
        Pairing(a, n);

        sc.close();
    }
}
