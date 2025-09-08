package Hashing;

import java.util.HashMap;

/**
 * Title: Largest Subarray with Sum = 0
 *
 * Problem:
 * - Given an integer array, find the length of the largest subarray whose sum is 0.
 *
 * Approach:
 * 1. Use a variable `sum` to store the prefix sum as we traverse the array.
 * 2. Maintain a HashMap that stores (prefixSum → firstIndex where it appeared).
 * 3. If the prefix sum becomes 0 at index j, then the subarray (0..j) has sum 0.
 * 4. If the same prefix sum is seen again at index j, then subarray between
 *    (previousIndex+1 .. j) has sum 0. Its length = j - previousIndex.
 * 5. Keep track of the maximum length found.
 *
 * Example:
 * Input:  [15, -2, 2, -8, 1, 7, 10]
 * Output: 5
 * Explanation: Largest zero-sum subarray is [-2, 2, -8, 1, 7]
 *
 * ----------------------------
 * Time Complexity:
 * ----------------------------
 * - O(n), single pass through the array
 *
 * ----------------------------
 * Space Complexity:
 * ----------------------------
 * - O(n), for storing prefix sums in HashMap
 */
public class Hash7 {

  /**
   * Function to find the length of the largest subarray with sum = 0.
   * 
   * @param arr input array
   * @return length of largest subarray with sum 0
   */
  public static int largestSubarray(int arr[]) {
    HashMap<Integer, Integer> map = new HashMap<>(); // prefixSum -> firstIndex
    int sum = 0;
    int length = 0;

    for (int j = 0; j < arr.length; j++) {
      sum += arr[j];

      // Case 1: If prefix sum is 0, subarray from 0..j has sum = 0
      if (sum == 0) {
        length = Math.max(length, j + 1);
      }

      // Case 2: If prefix sum seen before, subarray between indices has sum 0
      if (map.containsKey(sum)) {
        length = Math.max(length, j - map.get(sum));
      } else {
        // Store first occurrence of this prefix sum
        map.put(sum, j);
      }
    }
    return length;
  }

  public static void main(String[] args) {
    int arr[] = {15, -2, 2, -8, 1, 7, 10};
    System.out.println("Length of largest subarray with sum 0: " + largestSubarray(arr));
    // Expected output: 5
  }
}
