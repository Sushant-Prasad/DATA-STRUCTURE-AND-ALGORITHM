package Arrays;

// ============================================================================
//  TITLE:
//  Trapping Rain Water Problem
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given an array representing heights of bars,
//  where width of each bar is fixed,
//  calculate the total amount of water that can be trapped
//  between the bars after raining.
//
// ============================================================================
//  INTUITION:
//  ----------
//  Water trapped at any index depends on the minimum of:
//      • Maximum height to the left
//      • Maximum height to the right
//  minus the height of the current bar.
//
// ============================================================================
//  APPROACH (PREFIX MAX METHOD):
//  -----------------------------
//  1. Precompute left maximum boundary for each index.
//  2. Precompute right maximum boundary for each index.
//  3. For each bar:
//        waterLevel = min(leftMax, rightMax)
//        trappedWater += (waterLevel - height[i]) * width
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Heights: [4, 2, 0, 6, 3, 2, 5]
//      Width  : 1
//
//      Trapped Water = 10 units
//
// ============================================================================
//  DRY RUN:
//  --------
//      a = [4, 2, 0, 6, 3, 2, 5]
//
//      maxLeft  = [4, 4, 4, 6, 6, 6, 6]
//      maxRight = [6, 6, 6, 6, 5, 5, 5]
//
//      Index 1 → min(4,6) - 2 = 2
//      Index 2 → min(4,6) - 0 = 4
//      Index 4 → min(6,5) - 3 = 2
//      Total trapped water = 10
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Uses prefix maximum technique
//  ✔ Avoids recalculating boundaries
//  ✔ Efficient and widely used solution
//
// ============================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • No water trapped at first and last bar
//  • Width multiplies the trapped water at each index
//  • Extra arrays are used for optimization
//
// ============================================================================
//  TIME COMPLEXITY:  O(n)
//  SPACE COMPLEXITY: O(n)
// ============================================================================
//

import java.util.*;

public class array12 {

    // ------------------------------------------------------------------------
    // METHOD NAME: trappedwater
    // PURPOSE    : Calculates total trapped rain water
    // ------------------------------------------------------------------------
    public static int trappedwater(int a[], int n, int width) {

        int i;
        int waterlevel;
        int TrappedWater = 0;

        // Step 1: Calculate left maximum boundary
        int maxLeft[] = new int[n];
        maxLeft[0] = a[0];

        for (i = 1; i < n; i++) {
            maxLeft[i] = Math.max(a[i], maxLeft[i - 1]);
        }

        // Step 2: Calculate right maximum boundary
        int maxRight[] = new int[n];
        maxRight[n - 1] = a[n - 1];

        for (i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(a[i], maxRight[i + 1]);
        }

        // Step 3: Calculate trapped water
        for (i = 0; i < n; i++) {
            waterlevel = Math.min(maxLeft[i], maxRight[i]);
            TrappedWater += (waterlevel - a[i]) * width;
        }

        return TrappedWater;
    }

    // ------------------------------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------------------------------
    public static void main(String args[]) {

        int i, n, width;
        int a[] = new int[50];

        Scanner sc = new Scanner(System.in);

        // Input size of array
        System.out.println("Enter size of array:");
        n = sc.nextInt();

        // Input heights of bars
        System.out.println("Enter the elements of array:");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Input width of each bar
        System.out.println("Enter width of each bar:");
        width = sc.nextInt();

        // Calculate and print trapped water
        System.out.println("Total trapped water is " + trappedwater(a, n, width));

        sc.close();
    }
}
