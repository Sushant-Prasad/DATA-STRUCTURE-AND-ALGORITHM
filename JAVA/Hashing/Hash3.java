package Hashing;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Title: Difference between HashSet, LinkedHashSet, and TreeSet
 *
 * ----------------------------
 * 1. HashSet:
 * ----------------------------
 * - Stores unique elements (no duplicates).
 * - Backed by a HashMap internally.
 * - Does NOT guarantee any order (insertion order is NOT preserved).
 * - Allows at most one null element.
 * - Time Complexity (average): O(1) for add, remove, contains.
 *
 * ----------------------------
 * 2. LinkedHashSet:
 * ----------------------------
 * - Extension of HashSet.
 * - Maintains elements in **insertion order**.
 * - Allows at most one null element.
 * - Time Complexity: O(1) average for add, remove, contains.
 *
 * ----------------------------
 * 3. TreeSet:
 * ----------------------------
 * - Implements NavigableSet (based on Red-Black Tree).
 * - Stores unique elements in **sorted (natural) order**.
 * - Does NOT allow null elements (throws NullPointerException if added).
 * - Provides additional methods like first(), last(), higher(), lower().
 * - Time Complexity: O(log n) for add, remove, contains.
 *
 * ----------------------------
 * Example Output:
 * (Note: HashSet output order may vary)
 *
 * HashSet:       [Mumbai, Pune, Kolkata, Delhi, Banglore]
 * LinkedHashSet: [Kolkata, Delhi, Pune, Mumbai, Banglore]
 * TreeSet:       [Banglore, Delhi, Kolkata, Mumbai, Pune]
 */
public class Hash3 {
  public static void main(String[] args) {
    // -------------------------------
    // HashSet Example
    // -------------------------------
    HashSet<String> hs = new HashSet<>();
    hs.add("Kolkata");
    hs.add("Delhi");
    hs.add("Pune");
    hs.add("Mumbai");
    hs.add("Banglore");
    System.out.println("HashSet (no order): " + hs);

    // -------------------------------
    // LinkedHashSet Example
    // -------------------------------
    LinkedHashSet<String> lhs = new LinkedHashSet<>();
    lhs.add("Kolkata");
    lhs.add("Delhi");
    lhs.add("Pune");
    lhs.add("Mumbai");
    lhs.add("Banglore");
    System.out.println("LinkedHashSet (insertion order): " + lhs);

    // -------------------------------
    // TreeSet Example
    // -------------------------------
    TreeSet<String> ts = new TreeSet<>();
    ts.add("Kolkata");
    ts.add("Delhi");
    ts.add("Pune");
    ts.add("Mumbai");
    ts.add("Banglore");
    System.out.println("TreeSet (sorted order): " + ts);
  }
}
