package Hashing;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Title: Difference between TreeMap and HashMap
 *
 * -----------------------
 * HashMap:
 * -----------------------
 * - Stores key-value pairs in an unordered manner (backed by a hash table).
 * - Does NOT guarantee any ordering of keys.
 * - Allows **one null key** and multiple null values.
 * - Not thread-safe (use ConcurrentHashMap for thread safety).
 * - Average Time Complexity:
 *    - put() → O(1)
 *    - get() → O(1)
 *    - remove() → O(1)
 *   (Worst-case O(n), if hash collisions occur heavily)
 *
 * -----------------------
 * TreeMap:
 * -----------------------
 * - Stores key-value pairs in **sorted order of keys**:
 *    - Natural ordering (Comparable)
 *    - OR custom order (Comparator)
 * - Does NOT allow null keys (throws NullPointerException),
 *   but allows multiple null values.
 * - Internally implemented using a **Red-Black Tree** (a self-balancing BST).
 * - Provides navigation methods like:
 *    - firstKey(), lastKey()
 *    - higherKey(), lowerKey()
 *    - ceilingKey(), floorKey()
 * - Time Complexity:
 *    - put() → O(log n)
 *    - get() → O(log n)
 *    - remove() → O(log n)
 *
 * -----------------------
 * When to use:
 * -----------------------
 * - Use HashMap → When you need fast lookups and don't care about order.
 * - Use TreeMap → When you need keys to be stored in sorted order or
 *   need range-based operations (e.g., get all keys < X).
 *
 * -----------------------
 * Example Run:
 * -----------------------
 * TreeMap (keys sorted): {China=140, India=150, Japan=40, UK=50, USA=60}
 * HashMap (no guaranteed order): {USA=60, UK=50, China=140, Japan=40, India=150}
 */
public class TreeMap1 {
  public static void main(String[] args) {

    // -------------------------------
    // TreeMap Example
    // -------------------------------
    TreeMap<String, Integer> tm = new TreeMap<>();

    // put() → Insert elements into TreeMap
    tm.put("India", 150);
    tm.put("USA", 60);
    tm.put("UK", 50);
    tm.put("China", 140);
    tm.put("Japan", 40);

    // Print TreeMap :- keys stored in sorted (alphabetical) order
    System.out.println("TreeMap (keys sorted): " + tm);

    //-------------------------------
    // HashMap Example
    //-------------------------------
    HashMap<String, Integer> hm = new HashMap<>();

    // put() → Insert elements into HashMap
    hm.put("India", 150);
    hm.put("USA", 60);
    hm.put("UK", 50);
    hm.put("China", 140);
    hm.put("Japan", 40);

    // Print HashMap → no guaranteed order
    System.out.println("HashMap (no guaranteed order): " + hm);
  }
}
