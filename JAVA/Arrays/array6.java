package Arrays;

// ============================================================================
//  TITLE:
//  Reverse of an Array using Two-Pointer Technique
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given an array of integers, reverse the elements of the array
//  in place without using any extra array.
//
// ============================================================================
//  INTUITION:
//  ----------
//  The first element should be swapped with the last element,
//  the second with the second last, and so on.
//  This can be efficiently done using two pointers.
//
// ============================================================================
//  APPROACH:
//  ----------
//  1. Read the size of the array and its elements.
//  2. Initialize two pointers:
//        - first → starting index (0)
//        - last  → ending index (n - 1)
//  3. Swap elements at first and last.
//  4. Move first forward and last backward.
//  5. Continue until first < last.
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Input Array : [1, 2, 3, 4, 5]
//      Output Array: [5, 4, 3, 2, 1]
//
// ============================================================================
//  DRY RUN:
//  --------
//      a = [1, 2, 3, 4, 5], n = 5
//
//      first=0, last=4 → swap 1 & 5 → [5, 2, 3, 4, 1]
//      first=1, last=3 → swap 2 & 4 → [5, 4, 3, 2, 1]
//      stop when first >= last
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Array is reversed in-place
//  ✔ No extra array is used
//  ✔ Two-pointer technique is efficient
//  ✔ Works for both even and odd sized arrays
//
// ============================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • Loop runs only till half of the array
//  • Temporary variable is used for safe swapping
//  • Condition first < last avoids double swapping
//
// ============================================================================
//  TIME COMPLEXITY:  O(n)
//  SPACE COMPLEXITY: O(1)
// ============================================================================
//

import java.util.*;

public class array6 {

    // ------------------------------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------------------------------
    public static void main(String args[]) {

        int i, n, first, last;
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

        // Reverse the array using two-pointer technique
        for (first = 0, last = n - 1; first < last; first++, last--) {
            int temp = a[last];
            a[last] = a[first];
            a[first] = temp;
        }

        // Print reversed array
        System.out.println("Reversed array is:");
        for (i = 0; i < n; i++) {
            System.out.println(a[i]);
        }

        sc.close();
    }
}
