package Hashing;

import java.util.HashMap;
import java.util.Set;

/**
 * Title: Basic Operations on HashMap
 *
 * Description:
 * HashMap stores key-value pairs.
 * - Keys are unique.
 * - Values can be duplicated.
 * - Provides average O(1) time complexity for put, get, remove, and containsKey.
 *
 * Common Operations:
 * 1. put(key, value)       → Insert or update a key-value pair
 * 2. get(key)              → Retrieve value for a given key
 * 3. containsKey(key)      → Check if key exists
 * 4. remove(key)           → Remove key-value pair
 * 5. size()                → Get number of entries
 * 6. isEmpty()             → Check if map is empty
 * 7. keySet()              → Get all keys
 * 8. values()              → Get all values
 * 9. entrySet()            → Get key-value pairs
 */
public class HashMap1 {
  public static void main(String[] args) {
    // Create HashMap <Key=String, Value=Integer>
    HashMap<String, Integer> hm = new HashMap<>();

    // 1. put() → Insert elements into HashMap
    hm.put("India", 150);
    hm.put("USA", 60);
    hm.put("UK", 50);
    hm.put("China", 140);
    hm.put("Japan", 40);

    // Print full HashMap (unordered because HashMap doesn’t guarantee order)
    System.out.println("HashMap: " + hm);

    // 2. get() → Access value for a given key
    System.out.println("Population of India: " + hm.get("India"));

    // 3. containsKey() → Check if a key exists
    System.out.println("Contains USA? " + hm.containsKey("USA"));
    System.out.println("Contains Russia? " + hm.containsKey("Russia"));

    // 4. remove() → Delete a key-value pair
    hm.remove("UK");
    System.out.println("After removing UK: " + hm);

    // 5. size() → Number of entries
    System.out.println("Size of HashMap: " + hm.size());

    // 6. isEmpty() → Check if HashMap is empty
    System.out.println("Is HashMap empty? " + hm.isEmpty());

    // 7. Iterating over keys
    System.out.println("\nIterating using keySet():");
    Set<String> keys = hm.keySet();
    for (String k : keys) {
      System.out.println("Key: " + k + " → Value: " + hm.get(k));
    }

    // 8. Iterating using entrySet()
    System.out.println("\nIterating using entrySet():");
    for (var entry : hm.entrySet()) {
      System.out.println("Key: " + entry.getKey() + " → Value: " + entry.getValue());
    }
  }
}
