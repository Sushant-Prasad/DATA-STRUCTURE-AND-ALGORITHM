package Hashing;

import java.util.HashMap;

/*
===========================================================
TITLE
===========================================================
Largest Subarray with Sum = 0

===========================================================
PROBLEM STATEMENT
===========================================================
Given an integer array `arr`, find the length of the
largest contiguous subarray whose sum is exactly 0.

===========================================================
INTUITION
===========================================================
If two prefix sums are equal, then the sum of elements
between those indices is 0.

Why?
Let:
prefixSum[j] = prefixSum[i]
⇒ arr[i+1] + ... + arr[j] = 0

So:
• Track prefix sums
• Store the FIRST occurrence of each prefix sum
• Maximize distance between repeated prefix sums

===========================================================
APPROACH
===========================================================
1) Initialize:
   - `sum` to store prefix sum
   - `length` to store maximum subarray length
   - HashMap: (prefixSum → first index)

2) Traverse array:
   - Add current element to `sum`
   - If `sum == 0`, subarray (0..j) has sum 0
   - If `sum` already exists in map:
       → subarray between previousIndex+1 and j has sum 0
   - Otherwise, store sum with its index

3) Return `length`

===========================================================
EXAMPLE
===========================================================
Input:
arr = [15, -2, 2, -8, 1, 7, 10]

Prefix sums:
15, 13, 15, 7, 8, 15, 25

Repeated prefix sum:
15 at index 0 and index 5

Largest zero-sum subarray:
[-2, 2, -8, 1, 7] → length = 5

===========================================================
TIME COMPLEXITY
===========================================================
O(n)
• Single traversal of array

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
• HashMap stores prefix sums

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Store ONLY the first occurrence of each prefix sum
• This guarantees maximum subarray length
• Works for both positive and negative numbers
===========================================================
*/

public class Hash7 {

    /**
     * Finds the length of the largest subarray with sum = 0.
     *
     * @param arr input integer array
     * @return maximum length of zero-sum subarray
     */
    public static int largestSubarray(int[] arr) {

        // HashMap to store prefixSum → first index
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;     // Prefix sum
        int length = 0;  // Maximum length found

        // Traverse array
        for (int j = 0; j < arr.length; j++) {

            sum += arr[j]; // Update prefix sum

            // Case 1: Entire array from index 0 to j has sum = 0
            if (sum == 0) {
                length = Math.max(length, j + 1);
            }

            // Case 2: Prefix sum seen before → zero-sum subarray exists
            if (map.containsKey(sum)) {
                length = Math.max(length, j - map.get(sum));
            } 
            // Store first occurrence of prefix sum
            else {
                map.put(sum, j);
            }
        }

        return length;
    }

    public static void main(String[] args) {

        int[] arr = {15, -2, 2, -8, 1, 7, 10};

        System.out.println(
            "Length of largest subarray with sum 0: " +
            largestSubarray(arr)
        );

        // Expected Output: 5
    }
}
