package Hashing;

import java.util.HashSet;

/**
 * Title: Union and Intersection of Two Arrays using HashSet
 *
 * Problem:
 * - Given two arrays arr1[] and arr2[], find:
 *   1. Union → all distinct elements present in either array.
 *   2. Intersection → all distinct elements present in both arrays.
 *
 * Approach:
 * 1. Union:
 *    - Insert all elements of arr1 and arr2 into a HashSet.
 *    - Since HashSet does not allow duplicates, it automatically gives unique union.
 *
 * 2. Intersection:
 *    - Insert all elements of arr1 into a HashSet.
 *    - Traverse arr2, if an element exists in the set → add to intersection.
 *    - Remove it from the set to avoid duplicates in intersection result.
 *
 * Example:
 * arr1 = [7, 3, 9]
 * arr2 = [6, 3, 9, 2, 9, 4]
 *
 * Union → {2, 3, 4, 6, 7, 9} → size = 6
 * Intersection → {3, 9} → size = 2
 *
 * ----------------------------
 * Time Complexity:
 * ----------------------------
 * - Union: O(n + m)
 * - Intersection: O(n + m)
 * (where n = size of arr1, m = size of arr2)
 *
 * ----------------------------
 * Space Complexity:
 * ----------------------------
 * - Union: O(n + m) in worst case (all unique elements).
 * - Intersection: O(min(n, m)) for storing elements of smaller array.
 */
public class Hash5 {

  /**
   * Function to find union of two arrays.
   * @param arr1 first array
   * @param arr2 second array
   * @return size of union set
   */
  public static int union(int arr1[], int arr2[]) {
    HashSet<Integer> union = new HashSet<>();

    // Add all elements from arr1
    for (int i = 0; i < arr1.length; i++) {
      union.add(arr1[i]);
    }

    // Add all elements from arr2
    for (int i = 0; i < arr2.length; i++) {
      union.add(arr2[i]);
    }

    System.out.println("Union set: " + union);
    return union.size();
  }

  /**
   * Function to find intersection of two arrays.
   * @param arr1 first array
   * @param arr2 second array
   * @return size of intersection set
   */
  public static int intersection(int arr1[], int arr2[]) {
    HashSet<Integer> intersection = new HashSet<>();
    HashSet<Integer> set = new HashSet<>();

    // Add all elements of arr1 to set
    for (int i = 0; i < arr1.length; i++) {
      set.add(arr1[i]);
    }

    // Check elements of arr2 against set
    for (int i = 0; i < arr2.length; i++) {
      if (set.contains(arr2[i])) {
        intersection.add(arr2[i]); // add common element
        set.remove(arr2[i]); // remove to avoid duplicates
      }
    }

    System.out.println("Intersection set: " + intersection);
    return intersection.size();
  }

  public static void main(String[] args) {
    int arr1[] = {7, 3, 9};
    int arr2[] = {6, 3, 9, 2, 9, 4};

    System.out.println("Union size: " + union(arr1, arr2));
    System.out.println("Intersection size: " + intersection(arr1, arr2));
  }
}
