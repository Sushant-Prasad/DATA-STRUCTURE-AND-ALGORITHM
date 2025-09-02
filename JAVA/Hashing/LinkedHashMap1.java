package Hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Title: Difference between HashMap and LinkedHashMap
 *
 * HashMap:
 * - Stores key-value pairs.
 * - Does NOT maintain insertion order (unordered).
 * - Average O(1) time for put, get, remove.
 *
 * LinkedHashMap:
 * - Same as HashMap but maintains insertion order.
 * - Keys will be iterated in the same order they were inserted.
 * - Slightly slower than HashMap because it maintains a doubly-linked list.
 */
public class LinkedHashMap1 {
  public static void main(String[] args) {
    
    // -------------------------------
    // LinkedHashMap Example
    // -------------------------------
    LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

    // put() → Insert elements into LinkedHashMap
    lhm.put("India", 150);
    lhm.put("USA", 60);
    lhm.put("UK", 50);
    lhm.put("China", 140);
    lhm.put("Japan", 40);

    // Print full LinkedHashMap → maintains insertion order
    System.out.println("LinkedHashMap (insertion order maintained): " + lhm);

    
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

    // Print full HashMap → order is NOT guaranteed
    System.out.println("HashMap (no guaranteed order): " + hm);
  }
}
