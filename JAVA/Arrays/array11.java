package Arrays;

// ============================================================================
//  TITLE:
//  Maximum Subarray Sum using Kadane’s Algorithm
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given an array of integers (may contain negative numbers),
//  find the maximum sum of a contiguous subarray.
//
// ============================================================================
//  INTUITION:
//  ----------
//  If the current subarray sum becomes negative, it will reduce
//  the sum of any future subarray.
//  Hence, we discard it and start a new subarray from the next element.
//
// ============================================================================
//  APPROACH (KADANE’S ALGORITHM):
//  -----------------------------
//  1. Maintain two variables:
//        • cs → current subarray sum
//        • ms → maximum subarray sum found so far
//  2. Traverse the array:
//        • Add current element to cs
//        • If cs becomes negative, reset it to 0
//        • Update ms as max(ms, cs)
//  3. ms stores the maximum subarray sum.
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Input Array : [-2, 1, -3, 4, -1, 2, 1, -5, 4]
//      Maximum Subarray Sum = 6
//      Subarray = [4, -1, 2, 1]
//
// ============================================================================
//  DRY RUN:
//  --------
//      a = [1, -2, 3, 4]
//
//      i=0 → cs=1  → ms=1
//      i=1 → cs=-1 → reset cs=0 → ms=1
//      i=2 → cs=3  → ms=3
//      i=3 → cs=7  → ms=7
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Works in single pass
//  ✔ Optimal solution for maximum subarray problem
//  ✔ Handles mixed positive and negative numbers
//
// ============================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • Standard Kadane fails for all-negative arrays
//  • Optimized version initializes ms = nums[0]
//    to correctly handle all-negative cases
//  • cs can temporarily become negative but is reset
//
// ============================================================================
//  TIME COMPLEXITY:  O(n)
//  SPACE COMPLEXITY: O(1)
// ============================================================================
//

import java.util.*;

public class array11 {

    // ------------------------------------------------------------------------
    // METHOD NAME: maxSubArray
    // PURPOSE    : Optimized Kadane’s Algorithm
    //              Handles arrays with all negative values
    // ------------------------------------------------------------------------
    public static int maxSubArray(int[] nums) {

        int n = nums.length;
        int cs = 0;           // current sum
        int ms = nums[0];     // maximum sum (handles all-negative arrays)

        for (int i = 0; i < n; i++) {

            // Reset current sum if it becomes negative
            if (cs < 0) {
                cs = 0;
            }

            // Add current element
            cs += nums[i];

            // Update maximum sum
            ms = Math.max(cs, ms);
        }

        return ms;
    }

    // ------------------------------------------------------------------------
    // METHOD NAME: kadanes
    // PURPOSE    : Standard Kadane’s Algorithm (educational version)
    // ------------------------------------------------------------------------
    public static void kadanes(int a[], int n) {

        int cs = 0;
        int ms = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            cs = cs + a[i];

            // Reset current sum if negative
            if (cs < 0) {
                cs = 0;
            }

            // Update maximum sum
            ms = Math.max(cs, ms);
        }

        System.out.println("Maximum sum is " + ms);
    }

    // ------------------------------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------------------------------
    public static void main(String args[]) {

        // Example array with all negative values
        int a[] = { -5, -7, -3 };

        // Calling optimized Kadane’s Algorithm
        System.out.println("Maximum Subarray Sum:");
        System.out.println(maxSubArray(a));
    }
}
