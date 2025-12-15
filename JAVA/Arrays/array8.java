package Arrays;

// ============================================================================
//  TITLE:
//  Print All Subarrays of an Array
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given an array of integers, print all possible subarrays of the array.
//  A subarray is a contiguous part of the array.
//
// ============================================================================
//  INTUITION:
//  ----------
//  A subarray is defined by two indices:
//      - Starting index (i)
//      - Ending index (j)
//  For every possible start index, we generate all valid end indices
//  and print elements between them.
//
// ============================================================================
//  APPROACH:
//  ----------
//  1. Use three nested loops:
//      • Outer loop (i) → starting index
//      • Middle loop (j) → ending index
//      • Inner loop (k) → prints elements from i to j
//  2. Print each subarray in a new line.
//
// ============================================================================
//  IMPORTANT FORMULA:
//  ------------------
//  Total number of subarrays of size n:
//          n(n + 1) / 2
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Input Array : [1, 2, 3]
//
//      Subarrays:
//      [1]
//      [1, 2]
//      [1, 2, 3]
//
//      [2]
//      [2, 3]
//
//      [3]
//
// ============================================================================
//  DRY RUN:
//  --------
//      a = [10, 20, 30], n = 3
//
//      i = 0
//        j = 0 → [10]
//        j = 1 → [10, 20]
//        j = 2 → [10, 20, 30]
//
//      i = 1
//        j = 1 → [20]
//        j = 2 → [20, 30]
//
//      i = 2
//        j = 2 → [30]
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Subarrays are contiguous elements
//  ✔ Order of elements is preserved
//  ✔ Three nested loops are required for printing
//  ✔ Blank lines improve output readability
//
// ============================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • Inner loop prints elements from index i to j
//  • Middle loop ensures valid ending points
//  • Outer loop controls starting point
//
// ============================================================================
//  TIME COMPLEXITY:  O(n³)
//  SPACE COMPLEXITY: O(1)
// ============================================================================
//

import java.util.*;

public class array8 {

    // ------------------------------------------------------------------------
    // METHOD NAME: subarrays
    // PURPOSE    : Prints all possible subarrays of the given array
    // ------------------------------------------------------------------------
    public static void subarrays(int a[], int n) {

        int i, j, k;

        // Outer loop → starting index of subarray
        for (i = 0; i < n; i++) {

            // Middle loop → ending index of subarray
            for (j = i; j < n; j++) {

                // Inner loop → prints elements between i and j
                for (k = i; k <= j; k++) {
                    System.out.print(a[k] + " ");
                }

                // New line after each subarray
                System.out.println();
            }

            // Blank line after each starting index
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

        // Print all subarrays
        System.out.println("Subarrays are:");
        subarrays(a, n);

        sc.close();
    }
}
