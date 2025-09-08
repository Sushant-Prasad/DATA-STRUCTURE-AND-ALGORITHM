package Hashing;

import java.util.HashSet;

/**
 * Title: Count Distinct Elements
 *
 * Problem:
 * - Given an array of integers, find the number of distinct (unique) elements.
 *
 * Approach:
 * - Use a HashSet to store elements from the array.
 * - Since HashSet does not allow duplicates, only unique elements remain.
 * - Return the size of the HashSet.
 *
 * Example:
 * Input:  [4, 3, 2, 5, 6, 7, 3, 4, 2, 1]
 * Output: 7
 * Explanation: Distinct elements are {1,2,3,4,5,6,7}
 *
 * ----------------------------
 * Time Complexity:
 * ----------------------------
 * - Inserting each element into HashSet → O(1) average per element
 * - For n elements → O(n) average case
 * - Worst case (if many hash collisions) → O(n^2), but very rare
 *
 * ----------------------------
 * Space Complexity:
 * ----------------------------
 * - HashSet stores unique elements
 * - In worst case, all n elements are distinct → O(n)
 */
public class Hash4 {

  /**
   * Function to count distinct elements in an array.
   *
   * @param arr input array of integers
   * @return number of distinct elements
   */
  public static int distinctElement(int arr[]) {
    HashSet<Integer> set = new HashSet<>();

    // Add all elements to HashSet (duplicates ignored)
    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
    }

    // Size of HashSet = number of distinct elements
    return set.size();
  }

  public static void main(String[] args) {
    int num[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
    System.out.println("Number of distinct elements: " + distinctElement(num));
  }
}
