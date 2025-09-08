package Hashing;

import java.util.HashMap;

/**
 * Title: Find Itinerary From Tickets using HashMap
 *
 * Problem:
 * - You are given a set of flight tickets in the form of (source → destination).
 * - Find the complete itinerary (travel route) from the starting point to the final destination.
 *
 * Approach:
 * 1. Build a reverse map (destination → source).
 * 2. The starting point is the city that is present in tickets.keySet()
 *    but not in revMap.keySet() (i.e., it never appears as a destination).
 * 3. Once the starting point is found:
 *    - Repeatedly move to tickets.get(current) until no further destination exists.
 *    - Print the itinerary as "A -> B -> C -> ...".
 *
 * Example:
 * Tickets:
 *   Chennai → Banglore
 *   Mumbai → Delhi
 *   Goa → Chennai
 *   Delhi → Goa
 *
 * Output:
 *   Mumbai -> Delhi -> Goa -> Chennai -> Banglore
 *
 * ----------------------------
 * Time Complexity:
 * ----------------------------
 * - Building reverse map: O(n)
 * - Finding starting point: O(n)
 * - Traversing itinerary: O(n)
 * Overall: O(n), where n = number of tickets
 *
 * ----------------------------
 * Space Complexity:
 * ----------------------------
 * - Reverse map stores n entries: O(n)
 */
public class Hash6 {

  /**
   * Finds the starting point of the itinerary.
   * 
   * @param tickets HashMap of (source → destination)
   * @return starting city
   */
  public static String getStartingPoint(HashMap<String, String> tickets) {
    HashMap<String, String> revMap = new HashMap<>();

    // Build reverse map (destination → source)
    for (String key : tickets.keySet()) {
      revMap.put(tickets.get(key), key);
    }

    // Find the starting point (a city that is never a destination)
    for (String key : tickets.keySet()) {
      if (!revMap.containsKey(key)) {
        return key;
      }
    }
    return null; // should not happen if valid input
  }

  /**
   * Prints the complete itinerary from tickets.
   * 
   * @param tickets HashMap of (source → destination)
   */
  public static void findItinerary(HashMap<String, String> tickets) {
    String start = getStartingPoint(tickets);

    // Print starting point
    System.out.print(start);

    // Traverse until no destination left
    while (tickets.containsKey(start)) {
      System.out.print(" -> " + tickets.get(start));
      start = tickets.get(start);
    }
  }

  public static void main(String[] args) {
    HashMap<String, String> tickets = new HashMap<>();
    tickets.put("Chennai", "Banglore");
    tickets.put("Mumbai", "Delhi");
    tickets.put("Goa", "Chennai");
    tickets.put("Delhi", "Goa");

    System.out.println("Itinerary:");
    findItinerary(tickets);
  }
}
