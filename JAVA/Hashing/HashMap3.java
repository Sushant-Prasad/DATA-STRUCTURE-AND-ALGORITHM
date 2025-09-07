package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Title: Find Majority Elements (> n/3 occurrences) using HashMap
 *
 * Problem:
 * - Given an integer array, find all elements that appear more than n/3 times.
 * - n = length of array.
 * - At most, there can be 2 such elements.
 *
 * Approach:
 * - Use a HashMap to count frequencies of each element.
 * - Traverse the map and select elements whose count > n/3.
 * - Convert the result to a primitive int[] and return.
 *
 * Example:
 * Input:  [1, 3, 2, 5, 1, 3, 1, 5, 1]
 * Output: [1]   (since 1 appears 4 times, > 9/3 = 3)
 *
 * ----------------------------
 * Time Complexity Analysis:
 * ----------------------------
 * - Counting frequencies → O(n)
 * - Iterating over HashMap keys → O(k), where k = number of unique elements (k ≤ n)
 * - Copying results into array → O(k)
 * Overall: O(n) in worst case.
 *
 * ----------------------------
 * Space Complexity Analysis:
 * ----------------------------
 * - HashMap stores frequencies → O(k), where k = number of unique elements
 * - Result ArrayList → O(k)
 * - Final int[] result → O(k)
 * Overall: O(n) in worst case.
 */
public class HashMap3 {

  /**
   * Function to find all majority elements (> n/3 frequency).
   * 
   * @param arr input integer array
   * @return array of majority elements
   */
  public static int[] majorityElement(int arr[]) {
    ArrayList<Integer> result = new ArrayList<>();   // store majority elements
    HashMap<Integer, Integer> map = new HashMap<>(); // frequency map

    // Step 1: Count frequency of each element
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    // Step 2: Define threshold for majority
    int threshold = arr.length / 3;

    // Step 3: Traverse keys and check condition
    Set<Integer> keys = map.keySet();
    for (int key : keys) {
      if (map.get(key) > threshold) {
        result.add(key);
      }
    }

    // Step 4: Convert ArrayList<Integer> to int[]
    int[] ans = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      ans[i] = result.get(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };

    // Call the function
    int[] result = majorityElement(nums);

    // Print results (each element in new line)
    System.out.println("Majority elements (> n/3):");
    for (int i : result) {
      System.out.println(i);
    }
  }
}
