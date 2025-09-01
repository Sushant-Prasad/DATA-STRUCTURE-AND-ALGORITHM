package HEAP;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Title: Sliding Window Maximum (Heap-based solution)
 *
 * Problem:
 * Given an integer array and a sliding window of size k, 
 * return the maximum value in each sliding window.
 *
 * Example:
 * Input:  arr = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 *
 * Approach (Using Max-Heap):
 * - Use a Max-Heap (PriorityQueue in Java with custom comparator).
 * - Each heap element stores both value and index (Info class).
 * - For each window:
 *     1. Remove elements from the heap that are outside the current window (index <= i - k).
 *     2. Insert the current element into the heap.
 *     3. The top of the heap (peek) is the maximum of the current window.
 *
 * Time Complexity: O(n log n)
 *   - Each element can be inserted and removed once → O(log n) per operation.
 * Space Complexity: O(n) for the heap.
 *
 * Note: This is not the optimal solution (best solution uses Deque in O(n)),
 * but it’s simpler and acceptable for understanding with heaps.
 */
public class Heap8 {

  // Helper class to store value and index of an element
  public static class Info {
    int val;
    int idx;

    Info(int val, int idx) {
      this.val = val;
      this.idx = idx;
    }
  }

  // Function to find maximum in each sliding window
  public static ArrayList<Integer> slidingWindowMax(int arr[], int k) {
    ArrayList<Integer> result = new ArrayList<>();

    // Max-Heap (store larger values first)
    PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> b.val - a.val);

    // Step 1: Insert first k elements into heap
    for (int i = 0; i < k; i++) {
      pq.add(new Info(arr[i], i));
    }
    result.add(pq.peek().val); // max of first window

    // Step 2: Process the rest of the array
    for (int i = k; i < arr.length; i++) {
      // Remove elements outside the current window
      while (!pq.isEmpty() && pq.peek().idx <= i - k) {
        pq.remove();
      }

      // Insert current element
      pq.add(new Info(arr[i], i));

      // The top of heap is the max in this window
      result.add(pq.peek().val);
    }

    return result;
  }

  // Driver code
  public static void main(String[] args) {
    int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
    int k = 3;

    ArrayList<Integer> result = slidingWindowMax(arr, k);

    System.out.println("Sliding Window Maximums:");
    for (int i : result) {
      System.out.print(i + " ");
    }
  }
}
