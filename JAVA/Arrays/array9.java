package Arrays;

// ============================================================================
//  TITLE:
//  Maximum Subarray Sum (Brute Force Approach)
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given an array of integers, find the maximum sum among
//  all possible contiguous subarrays.
//
// ============================================================================
//  INTUITION:
//  ----------
//  A subarray is a contiguous part of the array.
//  To find the maximum subarray sum using brute force,
//  we calculate the sum of every possible subarray
//  and track the maximum sum encountered.
//
// ============================================================================
//  APPROACH (BRUTE FORCE):
//  ----------------------
//  1. Use three nested loops:
//      • Outer loop (i) → starting index of subarray
//      • Middle loop (j) → ending index of subarray
//      • Inner loop (k) → calculates sum from i to j
//  2. For each subarray, calculate CurrentSum.
//  3. Compare CurrentSum with MaxSum and update MaxSum.
//  4. Print the final maximum subarray sum.
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Input Array : [-2, 1, -3, 4, -1, 2, 1, -5, 4]
//
//      Subarray [4, -1, 2, 1] → Sum = 6 (Maximum)
//
// ============================================================================
//  DRY RUN:
//  --------
//      a = [1, 2, 3], n = 3
//
//      i=0
//        j=0 → sum = 1  → MaxSum = 1
//        j=1 → sum = 3  → MaxSum = 3
//        j=2 → sum = 6  → MaxSum = 6
//
//      i=1
//        j=1 → sum = 2
//        j=2 → sum = 5
//
//      i=2
//        j=2 → sum = 3
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Considers all possible subarrays
//  ✔ Guarantees correct result
//  ✔ Inefficient for large inputs
//  ✔ Helps understand subarray concept clearly
//
// ============================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • CurrentSum must be reset for every new subarray
//  • MaxSum initialized to Integer.MIN_VALUE
//    to handle arrays with all negative numbers
//  • Printing CurrentSum helps in understanding flow
//
// ============================================================================
//  TIME COMPLEXITY:  O(n³)  (Very inefficient)
//  SPACE COMPLEXITY: O(1)
// ============================================================================
//

import java.util.*;

public class array9 {

    // ------------------------------------------------------------------------
    // METHOD NAME: MaximumSum
    // PURPOSE    : Finds and prints the maximum subarray sum using brute force
    // ------------------------------------------------------------------------
    public static void MaximumSum(int a[], int n) {

        int i, j, k;
        int CurrentSum = 0;
        int MaxSum = Integer.MIN_VALUE;

        // Outer loop → starting index
        for (i = 0; i < n; i++) {

            // Middle loop → ending index
            for (j = i; j < n; j++) {

                CurrentSum = 0;

                // Inner loop → calculate sum from i to j
                for (k = i; k <= j; k++) {
                    CurrentSum = CurrentSum + a[k];
                }

                // Print sum of current subarray
                System.out.print(CurrentSum + " ");

                // Update maximum sum if needed
                if (MaxSum < CurrentSum) {
                    MaxSum = CurrentSum;
                }
            }
        }

        // Print final maximum subarray sum
        System.out.println("\nMax sum is " + MaxSum);
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
