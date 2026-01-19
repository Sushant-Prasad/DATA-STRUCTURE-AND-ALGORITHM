/*
===========================================================
TITLE
===========================================================
Custom Max-Heap Implementation Using ArrayList

===========================================================
PROBLEM STATEMENT
===========================================================
Implement a **Max-Heap** data structure from scratch.

A Max-Heap is a **Complete Binary Tree** where:
• The value of each parent node is **greater than or equal to**
  the values of its children.
• The **maximum element** is always present at the root.

===========================================================
OPERATIONS SUPPORTED
===========================================================
• add(int data)   → Insert element into heap
• peek()          → Get maximum element without removing
• remove()        → Remove and return maximum element
• isEmpty()       → Check if heap is empty

===========================================================
INTUITION
===========================================================
We use an ArrayList to represent the heap because:
• A complete binary tree can be efficiently stored using an array
• Parent–child index relationships:
  - Parent index      → (i - 1) / 2
  - Left child index  → 2*i + 1
  - Right child index → 2*i + 2

To maintain Max-Heap property:
• Bubble-Up after insertion
• Heapify-Down after deletion

===========================================================
APPROACH
===========================================================
INSERT (add):
1) Insert element at the end of array
2) Bubble-up while parent < child

REMOVE (remove):
1) Swap root with last element
2) Remove last element
3) Heapify-down from root

===========================================================
TIME COMPLEXITY
===========================================================
add()     → O(log n)
remove()  → O(log n)
peek()    → O(1)
isEmpty() → O(1)

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
• ArrayList stores heap elements

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Root always stores maximum element
• Heapify compares parent with both children
• Recursion ensures heap property is restored fully
===========================================================
*/

package HEAP;

import java.util.ArrayList;

public class Heap2 {

    // ---------------------------------------------------
    // Inner Heap class (Max-Heap)
    // ---------------------------------------------------
    public static class Heap {

        // ArrayList to store heap elements
        ArrayList<Integer> arr = new ArrayList<>();

        /*
         * Insert a new element into the Max-Heap
         * Steps:
         * 1) Add element at the end
         * 2) Bubble-up to restore heap property
         */
        public void add(int data) {

            // Step 1: Add element at the end
            arr.add(data);

            int childIdx = arr.size() - 1;   // index of new node
            int parIdx = (childIdx - 1) / 2; // parent index

            // Step 2: Bubble-up (parent < child → swap)
            while (childIdx > 0 && arr.get(parIdx) < arr.get(childIdx)) {

                // Swap parent and child
                int temp = arr.get(childIdx);
                arr.set(childIdx, arr.get(parIdx));
                arr.set(parIdx, temp);

                // Move upwards
                childIdx = parIdx;
                parIdx = (childIdx - 1) / 2;
            }
        }

        /*
         * Return maximum element (root) without removing it
         * Time Complexity: O(1)
         */
        public int peek() {
            return arr.get(0);
        }

        /*
         * Heapify-down operation
         * Restores Max-Heap property from index i downwards
         */
        private void heapify(int i) {

            int left = 2 * i + 1;   // left child index
            int right = 2 * i + 2;  // right child index
            int maxIdx = i;

            // Compare with left child
            if (left < arr.size() && arr.get(left) > arr.get(maxIdx)) {
                maxIdx = left;
            }

            // Compare with right child
            if (right < arr.size() && arr.get(right) > arr.get(maxIdx)) {
                maxIdx = right;
            }

            // If parent is not largest, swap and continue heapify
            if (maxIdx != i) {

                int temp = arr.get(i);
                arr.set(i, arr.get(maxIdx));
                arr.set(maxIdx, temp);

                heapify(maxIdx);
            }
        }

        /*
         * Remove and return maximum element (root)
         * Steps:
         * 1) Swap root with last element
         * 2) Remove last element
         * 3) Heapify-down from root
         */
        public int remove() {

            int data = arr.get(0); // store max element

            // Step 1: Swap root with last element
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Step 2: Remove last element
            arr.remove(arr.size() - 1);

            // Step 3: Restore heap property
            if (!arr.isEmpty()) {
                heapify(0);
            }

            return data;
        }

        /*
         * Check whether heap is empty
         */
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    // ---------------------------------------------------
    // Driver Code
    // ---------------------------------------------------
    public static void main(String[] args) {

        Heap h = new Heap();

        // Insert elements
        h.add(3);
        h.add(5);
        h.add(1);
        h.add(4);
        h.add(2);

        // Print elements in descending order
        while (!h.isEmpty()) {
            System.out.println(h.peek()); // largest element
            h.remove();
        }
    }
}
