package Hashing;

import java.util.HashMap;

/**
 * Title: Count Subarrays with Sum = k
 *
 * Problem:
 * - Given an integer array arr[] and an integer k,
 *   find the total number of subarrays whose sum equals k.
 *
 * Approach:
 * 1. Use a prefix sum (`sum`) to store cumulative sum while traversing the array.
 * 2. Maintain a HashMap that stores:
 *    (prefixSum → frequency of occurrences so far).
 * 3. At each index j:
 *    - Compute sum = sum + arr[j].
 *    - If (sum - k) exists in map, it means there are subarrays ending at j
 *      with sum = k. Add its frequency to the answer.
 *    - Update the map with the current prefix sum.
 * 4. Initialize map with (0 → 1) because a prefix sum equal to k
 *    can directly form a valid subarray from index 0.
 *
 * Example:
 * Input:  arr = [10, 2, -2, -20, 10], k = -10
 * Output: 3
 * Explanation:
 *   Subarrays with sum -10 are:
 *   [10, 2, -2, -20], [2, -2, -20, 10], [-20, 10]
 *
 * ----------------------------
 * Time Complexity:
 * ----------------------------
 * - O(n), single traversal of array
 *
 * ----------------------------
 * Space Complexity:
 * ----------------------------
 * - O(n), for storing prefix sums in HashMap
 */
public class Hash8 {

  /**
   * Function to count subarrays with sum = k.
   * 
   * @param arr input array
   * @param k   target sum
   * @return number of subarrays with sum = k
   */
  public static int countSubarray(int arr[], int k) {
    HashMap<Integer, Integer> map = new HashMap<>(); // prefixSum -> frequency
    int sum = 0, ans = 0;

    // Initial entry: prefix sum 0 occurs once
    map.put(0, 1);

    for (int j = 0; j < arr.length; j++) {
      sum += arr[j];

      // Check if (sum - k) exists in map → subarray with sum k found
      if (map.containsKey(sum - k)) {
        ans += map.get(sum - k);
      }

      // Update frequency of current prefix sum
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return ans;
  }

  public static void main(String[] args) {
    int arr[] = {10, 2, -2, -20, 10};
    int k = -10;

    System.out.println("Count of subarrays with sum " + k + ": " + countSubarray(arr, k));
    // Expected output: 3
  }
}
