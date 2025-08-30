package HEAP;

import java.util.ArrayList;

/**
 * Title: Custom Min-Heap Implementation
 * 
 * Description:
 * This program demonstrates how to implement a Min-Heap in Java using an ArrayList.
 * A Min-Heap is a Complete Binary Tree where the value at the root 
 * is always the smallest among all nodes.
 * 
 * Operations supported:
 *  - add(int data)   : Insert element into heap
 *  - peek()          : Get smallest element without removing
 *  - remove()        : Remove and return smallest element
 *  - isEmpty()       : Check if heap is empty
 * 
 * Time Complexity:
 *  - add()     : O(log n)   (bubble-up at most log n swaps)
 *  - remove()  : O(log n)   (heapify at most log n swaps)
 *  - peek()    : O(1)       (just return root element)
 *  - isEmpty() : O(1)
 * 
 * Space Complexity:
 *  - O(n) to store heap elements in the ArrayList
 */
public class Heap1 {

  // Inner Heap class
  public static class Heap {
    ArrayList<Integer> arr = new ArrayList<>();

    /**
     * Insert new element into heap
     * Steps:
     * 1. Add element at end
     * 2. Bubble-up: Swap with parent until heap property is restored
     */
    public void add(int data) {
      arr.add(data); // Step 1: Add at end
      int childIdx = arr.size() - 1; // index of newly added node
      int parIdx = (childIdx - 1) / 2; // parent index

      // Step 2: Bubble-up
      while (childIdx > 0 && arr.get(parIdx) > arr.get(childIdx)) {
        // swap parent and child
        int temp = arr.get(childIdx);
        arr.set(childIdx, arr.get(parIdx));
        arr.set(parIdx, temp);

        childIdx = parIdx;
        parIdx = (childIdx - 1) / 2;
      }
    }

    /**
     * Return minimum element (root of heap) without removing
     * Time Complexity: O(1)
     */
    public int peek() {
      return arr.get(0);
    }

    /**
     * Heapify function (recursive)
     * Restores heap property starting from index i downwards.
     * Time Complexity: O(log n)
     */
    private void heapify(int i) {
      int left = 2 * i + 1;  // left child index
      int right = 2 * i + 2; // right child index
      int minIdx = i;

      // check left child
      if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
        minIdx = left;
      }
      // check right child
      if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
        minIdx = right;
      }

      // if a child is smaller, swap and continue heapify
      if (minIdx != i) {
        int temp = arr.get(i);
        arr.set(i, arr.get(minIdx));
        arr.set(minIdx, temp);

        heapify(minIdx);
      }
    }

    /**
     * Remove and return minimum element (root of heap)
     * Steps:
     * 1. Swap root with last element
     * 2. Remove last element
     * 3. Heapify from root
     * 
     * Time Complexity: O(log n)
     */
    public int remove() {
      int data = arr.get(0);

      // Step 1: Swap root with last element
      int temp = arr.get(0);
      arr.set(0, arr.get(arr.size() - 1));
      arr.set(arr.size() - 1, temp);

      // Step 2: Remove last element
      arr.remove(arr.size() - 1);

      // Step 3: Heapify from root
      if (!arr.isEmpty()) {
        heapify(0);
      }

      return data;
    }

    /**
     * Check if heap is empty
     * Time Complexity: O(1)
     */
    public boolean isEmpty() {
      return arr.size() == 0;
    }
  }

  // Test Heap Implementation
  public static void main(String[] args) {
    Heap h = new Heap();

    // Insert elements into heap
    h.add(3);
    h.add(5);
    h.add(1);
    h.add(4);
    h.add(2);

    // Print elements in ascending order using heap
    while (!h.isEmpty()) {
      System.out.println(h.peek()); // O(1)
      h.remove();                   // O(log n)
    }
  }
}
