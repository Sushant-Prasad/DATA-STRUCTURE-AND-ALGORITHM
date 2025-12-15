package Arrays;

// ============================================================================
//  TITLE:
//  Maximum Subarray Sum using Prefix Sum Technique
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given an array of integers, find the maximum sum of all
//  possible contiguous subarrays using the Prefix Sum method.
//
// ============================================================================
//  INTUITION:
//  ----------
//  Instead of recalculating the sum of every subarray repeatedly,
//  we precompute prefix sums.
//  Prefix sum at index i stores the sum of elements from 0 to i.
//  This allows subarray sum calculation in O(1) time.
//
// ============================================================================
//  APPROACH (PREFIX SUM):
//  ---------------------
//  1. Create a prefix array where:
//         prefix[i] = prefix[i-1] + a[i]
//  2. Use two loops to choose starting index (i) and ending index (j).
//  3. Calculate subarray sum using:
//         - prefix[j]              if i == 0
//         - prefix[j] - prefix[i-1] otherwise
//  4. Update MaxSum whenever a larger sum is found.
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Input Array : [-2, 1, -3, 4, -1, 2, 1, -5, 4]
//
//      Prefix Array: [-2, -1, -4, 0, -1, 1, 2, -3, 1]
//
//      Maximum Subarray Sum = 6   → [4, -1, 2, 1]
//
// ============================================================================
//  DRY RUN:
//  --------
//      a = [1, 2, 3], n = 3
//
//      Prefix Array:
//      prefix[0] = 1
//      prefix[1] = 3
//      prefix[2] = 6
//
//      i=0, j=2 → CurrentSum = prefix[2] = 6
//      i=1, j=2 → CurrentSum = prefix[2] - prefix[0] = 5
//
//      MaxSum = 6
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Reduces time complexity from O(n³) to O(n²)
//  ✔ Subarray sum calculation in constant time
//  ✔ Extra array used for optimization
//
// ============================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • Special case when i == 0 must be handled separately
//  • MaxSum initialized to Integer.MIN_VALUE
//    to support all-negative arrays
//  • Prefix array stores cumulative sums
//
// ============================================================================
//  TIME COMPLEXITY:  O(n²)
//  SPACE COMPLEXITY: O(n)
// ============================================================================
//

import java.util.*;

public class array10 {

    // ------------------------------------------------------------------------
    // METHOD NAME: MaximumSum
    // PURPOSE    : Finds maximum subarray sum using prefix sum technique
    // ------------------------------------------------------------------------
    public static void MaximumSum(int a[], int n) {

        int i, j;
        int CurrentSum = 0;
        int MaxSum = Integer.MIN_VALUE;

        // Create prefix sum array
        int prefix[] = new int[n];
        prefix[0] = a[0];

        for (i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + a[i];
        }

        // Calculate all subarray sums using prefix array
        for (i = 0; i < n; i++) {           // starting index
            for (j = i; j < n; j++) {       // ending index

                if (i == 0) {
                    CurrentSum = prefix[j];
                } else {
                    CurrentSum = prefix[j] - prefix[i - 1];
                }

                // Update maximum sum
                if (MaxSum < CurrentSum) {
                    MaxSum = CurrentSum;
                }
            }
        }

        // Print maximum subarray sum
        System.out.println("Max sum is " + MaxSum);
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

        // Find maximum subarray sum
        MaximumSum(a, n);

        sc.close();
    }
}
