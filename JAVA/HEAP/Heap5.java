package HEAP;

import java.util.PriorityQueue;

/**
 * Title: Minimum Cost to Connect Ropes/ connect N ropes
 *
 * Problem:
 * Given N ropes with different lengths, we need to connect them into a single rope.
 * The cost of connecting two ropes is equal to the sum of their lengths.
 * We must find the minimum total cost to connect all ropes.
 *
 * Approach (Greedy + Min-Heap):
 * - Always connect the two smallest ropes first (this ensures minimal cost at each step).
 * - Insert all rope lengths into a Min-Heap (PriorityQueue).
 * - Repeatedly remove the two smallest ropes, add their cost to total, 
 *   and insert the new combined rope back into the heap.
 * - Continue until only one rope remains.
 *
 * Time Complexity:
 * - Building heap: O(n)
 * - Each remove/insert operation: O(log n)
 * - Done (n-1) times ⇒ O(n log n)
 *
 * Space Complexity:
 * - O(n) for storing the heap
 */
public class Heap5 {
  public static int connectNRopes(int arr[]) {
    int cost = 0;

    // Step 1: Insert all rope lengths into a Min-Heap
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < arr.length; i++) {
      pq.add(arr[i]);
    }

    // Step 2: Combine ropes until only one remains
    while (pq.size() > 1) {
      int min = pq.remove();   // smallest rope
      int min2 = pq.remove();  // second smallest rope

      int length = min + min2; // new rope length
      cost += length;          // add to total cost

      pq.add(length);          // push new rope back into heap
    }

    return cost;
  }

  // Driver code
  public static void main(String[] args) {
    int ropes[] = { 2, 3, 3, 4, 6 };
    System.out.println("Minimum Cost = " + connectNRopes(ropes));
  }
}
