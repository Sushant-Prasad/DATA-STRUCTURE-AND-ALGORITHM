package Hashing;

import java.util.HashSet;

/**
 * Title: Basic Operations on HashSet 
 *
 * ----------------------------
 * HashSet:
 * ----------------------------
 * - A collection that stores unique elements (no duplicates).
 * - Backed by a HashMap internally.
 * - Allows at most one `null` element.
 * - Does NOT maintain insertion order (use LinkedHashSet if you want order).
 * 
 *
 * ----------------------------
 * Common Operations:
 * ----------------------------
 * 1. add(element)     → O(1) average → Insert element into the set.
 * 2. remove(element)  → O(1) average → Remove element from the set.
 * 3. contains(element)→ O(1) average → Check if element exists.
 * 4. size()           → O(1)         → Returns number of elements.
 * 5. isEmpty()        → O(1)         → Check if set is empty.
 * 6. clear()          → O(1)         → Remove all elements.
 * 7. Iteration        → O(n)         → Traverse elements (order not guaranteed).
 *
 * ----------------------------
 * Time Complexity:
 * ----------------------------
 * - Average case: O(1) for add, remove, contains
 * - Worst case: O(n) (when many hash collisions occur)
 *
 * ----------------------------
 * Example Run:
 * Input:  add(1), add(2), add(4), add(2), add(1), add(3)
 * Output: [1, 2, 3, 4]   (order may vary)
 */
public class HashSet1 {
  public static void main(String[] args) {
    // Create HashSet of Integers
    HashSet<Integer> set = new HashSet<>();

    // -------------------------------
    // Add elements (duplicates ignored)
    // -------------------------------
    set.add(1);
    set.add(2);
    set.add(4);
    set.add(2); // duplicate → ignored
    set.add(1); // duplicate → ignored
    set.add(3);

    // Print set (order not guaranteed)
    System.out.println("HashSet: " + set);

    // -------------------------------
    // Contains check
    // -------------------------------
    System.out.println("Contains 2? " + set.contains(2)); // true
    System.out.println("Contains 5? " + set.contains(5)); // false

    // -------------------------------
    // Remove element
    // -------------------------------
    set.remove(4);
    System.out.println("After removing 4: " + set);

    // -------------------------------
    // Size of HashSet
    // -------------------------------
    System.out.println("Size: " + set.size());

    // -------------------------------
    // isEmpty check
    // -------------------------------
    System.out.println("Is empty? " + set.isEmpty());

    // -------------------------------
    // Iterating over HashSet
    // -------------------------------
    System.out.println("Iterating elements:");
    for (int num : set) {
      System.out.println(num);
    }

    // -------------------------------
    // Clear all elements
    // -------------------------------
    set.clear();
    System.out.println("After clear(): " + set);
  }
}
