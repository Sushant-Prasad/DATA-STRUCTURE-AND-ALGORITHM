package Hashing;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Title: Iteration operation in HashSet
 *
 * ----------------------------
 * HashSet:
 * ----------------------------
 * - Stores unique elements (no duplicates allowed).
 * - Backed internally by HashMap.
 * - Allows at most one null element.
 * - Does NOT maintain insertion order (use LinkedHashSet for order).
 * - Provides average O(1) time complexity for add, remove, contains.
 *
 * ----------------------------
 * Iteration Methods:
 * ----------------------------
 * 1. Using Iterator
 *    - cities.iterator() → returns an Iterator
 *    - i.hasNext() → checks if next element exists
 *    - i.next() → returns the next element
 *
 * 2. Using Enhanced For-Each Loop
 *    - Simpler syntax, directly iterates over HashSet elements
 *
 * ----------------------------
 * Example Output:
 * (Order may vary because HashSet does not guarantee order)
 * Kolkata
 * Delhi
 * Pune
 * Mumbai
 * Banglore
 */
public class HashSet2 {
  public static void main(String[] args) {
    // Create a HashSet of Strings
    HashSet<String> cities = new HashSet<>();

    // Add elements (duplicates ignored automatically)
    cities.add("Kolkata");
    cities.add("Delhi");
    cities.add("Pune");
    cities.add("Mumbai");
    cities.add("Banglore");

    // -------------------------------
    // Iterating using Iterator
    // -------------------------------
    Iterator<String> i = cities.iterator();
    System.out.println("Iterating using Iterator:");
    while (i.hasNext()) {
      System.out.println(i.next());
    }

    // -------------------------------
    // Iterating using Enhanced For-Each Loop
    // -------------------------------
    System.out.println("\nIterating using For-Each loop:");
    for (String city : cities) {
      System.out.println(city);
    }
  }
}
