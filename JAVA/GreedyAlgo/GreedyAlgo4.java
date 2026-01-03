/*
===========================================================
TITLE
===========================================================
Minimum Absolute Difference Pair Sum using Greedy Algorithm

===========================================================
PROBLEM STATEMENT
===========================================================
You are given two integer arrays `a[]` and `b[]` of equal length.

Your task is to pair elements from `a` with elements from `b`
(one-to-one pairing) such that the **sum of absolute differences**
of all pairs is minimized.

Absolute Difference of a pair (x, y) is:
|x − y|

===========================================================
PROBLEM RESOURCE (links)
===========================================================
https://www.geeksforgeeks.org/minimum-sum-absolute-difference-pairs-two-arrays/

===========================================================
INTUITION
===========================================================
To minimize the total absolute difference:
• Pair the smallest element of `a` with the smallest element of `b`
• Pair the second smallest with second smallest, and so on

Why this works:
- Sorting both arrays aligns similar-sized values together
- Any cross pairing would increase the absolute difference

This greedy strategy guarantees the minimum possible sum.

===========================================================
APPROACH
===========================================================
1) Sort array `a`.
2) Sort array `b`.
3) Traverse both arrays together.
4) For each index `i`, add |a[i] − b[i]| to the sum.
5) Return the final sum.

===========================================================
EXAMPLE
===========================================================
Input:
a = [4, 1, 8, 7]
b = [2, 3, 6, 5]

After Sorting:
a = [1, 4, 7, 8]
b = [2, 3, 5, 6]

Pairs:
(1,2), (4,3), (7,5), (8,6)

Sum:
|1−2| + |4−3| + |7−5| + |8−6|
= 1 + 1 + 2 + 2 = 6

===========================================================
DRY RUN
===========================================================
i = 0 → |1 - 2| = 1 → sum = 1
i = 1 → |4 - 3| = 1 → sum = 2
i = 2 → |7 - 5| = 2 → sum = 4
i = 3 → |8 - 6| = 2 → sum = 6

Final Answer = 6

===========================================================
KEY POINTS
===========================================================
• Arrays must be of equal length
• Sorting is essential for greedy correctness
• One-to-one pairing only
• Simple and efficient solution

===========================================================
TIME COMPLEXITY
===========================================================
O(n log n)
- Sorting both arrays

===========================================================
SPACE COMPLEXITY
===========================================================
O(1)
- Sorting done in-place (ignoring recursion stack)

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Pairing mismatched sizes increases total difference
• Greedy choice (sorted pairing) is optimal
• Works only when pairing count is equal
===========================================================
*/

package GreedyAlgo;

import java.util.*;

public class GreedyAlgo4 {

    // Function to compute minimum sum of absolute differences
    public static int minSum(int[] a, int[] b) {

        // Sort both arrays to align closest values
        Arrays.sort(a);
        Arrays.sort(b);

        int sum = 0; // Stores total absolute difference

        // Traverse both arrays and add absolute differences
        for (int i = 0; i < a.length; i++) {
            sum = sum + Math.abs(a[i] - b[i]);
        }

        return sum; // Final minimum sum
    }

    public static void main(String[] args) {

        int[] a = {4, 1, 8, 7};
        int[] b = {2, 3, 6, 5};

        // Print minimum absolute difference sum
        System.out.println(minSum(a, b));
    }
}
