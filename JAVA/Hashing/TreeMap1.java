package Hashing;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Title: Difference between TreeMap and HashMap
 *
 * HashMap:
 * - Stores key-value pairs in an unordered manner.
 * - Does NOT guarantee any ordering of keys.
 * - Average Time Complexity: O(1) for put, get, remove.
 *
 * TreeMap:
 * - Stores key-value pairs in **sorted order of keys** (natural ordering or custom comparator).
 * - Keys must be comparable (e.g., Strings, Integers).
 * - Time Complexity: O(log n) for put, get, remove (because it uses Red-Black Tree internally).
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

    // Print TreeMap → keys stored in sorted (alphabetical) order
    System.out.println("TreeMap (keys sorted): " + tm);

    
    // -------------------------------
    // HashMap Example
    // -------------------------------
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
