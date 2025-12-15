package Arrays;

// ============================================================================
//  TITLE:
//  Count the Hidden Sequences
//  (LeetCode – Count the Hidden Sequences)
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  You are given an integer array `differences` where
//      differences[i] = hidden[i + 1] - hidden[i].
//
//  You are also given two integers `lower` and `upper` which define
//  the inclusive range [lower, upper] for the values in the hidden array.
//
//  The task is to count how many possible hidden arrays exist
//  that satisfy:
//      • The difference constraints
//      • All values lie within [lower, upper]
//
// ============================================================================
//  INTUITION:
//  ----------
//  Instead of constructing all possible arrays, we observe that:
//  • The hidden array is fully determined once its first element is fixed.
//  • Using prefix sums of differences, we can track the minimum and maximum
//    values the array can reach relative to the starting point.
//  • The valid starting values are those that keep the entire array
//    within the given bounds.
//
// ============================================================================
//  APPROACH:
//  ----------
//  1. Assume hidden[0] = 0 (relative starting point).
//  2. Traverse the `differences` array and build cumulative sum (`curr`).
//  3. Track:
//        • minVal → minimum prefix sum
//        • maxVal → maximum prefix sum
//  4. For the hidden array to be valid:
//        lower ≤ start + minVal
//        start + maxVal ≤ upper
//  5. Count valid starting values using the intersection of these ranges.
//
// ============================================================================
//  MATHEMATICAL DERIVATION:
//  ------------------------
//      start ≥ lower - minVal
//      start ≤ upper - maxVal
//
//  Number of valid starts =
//      (upper - maxVal) - (lower - minVal) + 1
//
// ============================================================================
//  EXAMPLE:
//  --------
//      differences = [1, -3, 4]
//      lower = 1, upper = 6
//
//      Prefix sums: [0, 1, -2, 2]
//      minVal = -2, maxVal = 2
//
//      Valid start range:
//          start ≥ 1 - (-2) = 3
//          start ≤ 6 - 2    = 4
//
//      Total valid arrays = 2
//
// ============================================================================
//  DRY RUN:
//  --------
//      curr = 0
//      d = 1  → curr = 1  → min = 0,  max = 1
//      d = -3 → curr = -2 → min = -2, max = 1
//      d = 4  → curr = 2  → min = -2, max = 2
//
//      Result = (6 - 2) - (1 - (-2)) + 1
//              = 4 - 3 + 1 = 2
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Efficient single-pass solution
//  ✔ No need to build actual arrays
//  ✔ Uses prefix sum and range intersection
//  ✔ Common interview & LeetCode problem
//
// ============================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • Starting point is assumed as 0 for relative calculation
//  • Prefix min and max decide feasibility
//  • Early return if range becomes invalid
//
// ============================================================================
//  TIME COMPLEXITY:  O(n)
//  SPACE COMPLEXITY: O(1)
// ============================================================================
//

public class Array16 {

    // ------------------------------------------------------------------------
    // METHOD NAME: numberOfArrays
    // PURPOSE    : Returns the number of valid hidden arrays
    // ------------------------------------------------------------------------
    public int numberOfArrays(int[] differences, int lower, int upper) {

        int curr = 0;      // Current prefix sum (relative value)
        int minVal = 0;    // Minimum prefix sum
        int maxVal = 0;    // Maximum prefix sum

        // Traverse through differences to build prefix sums
        for (int d : differences) {
            curr += d;
            minVal = Math.min(minVal, curr);
            maxVal = Math.max(maxVal, curr);

            // Early termination if no valid starting point exists
            if ((upper - maxVal) - (lower - minVal) + 1 <= 0) {
                return 0;
            }
        }

        // Total number of valid starting values
        return (upper - maxVal) - (lower - minVal) + 1;
    }

    // ------------------------------------------------------------------------
    // MAIN METHOD (Driver Code)
    // ------------------------------------------------------------------------
    public static void main(String[] args) {

        Array16 obj = new Array16();

        int[] differences = {1, -3, 4};
        int lower = 1;
        int upper = 6;

        int result = obj.numberOfArrays(differences, lower, upper);
        System.out.println("Number of valid arrays: " + result);
    }
}
