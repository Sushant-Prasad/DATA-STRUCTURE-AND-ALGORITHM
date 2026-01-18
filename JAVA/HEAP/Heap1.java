/*
===========================================================
TITLE
===========================================================
Custom Min-Heap Implementation Using ArrayList

===========================================================
PROBLEM STATEMENT
===========================================================
Implement a **Min-Heap** data structure from scratch.

A Min-Heap is a **Complete Binary Tree** where:
• The value of each parent node is **less than or equal to**
  the values of its children.
• The **minimum element** is always at the root.

===========================================================
OPERATIONS SUPPORTED
===========================================================
• add(int data)   → Insert element into heap
• peek()          → Get minimum element without removing
• remove()        → Remove and return minimum element
• isEmpty()       → Check if heap is empty

===========================================================
INTUITION
===========================================================
We store the heap in an ArrayList because:
• Complete Binary Tree can be efficiently represented using an array
• Index formulas:
  - Parent: (i - 1) / 2
  - Left child:  2*i + 1
  - Right child: 2*i + 2

Two key operations maintain heap property:
• Bubble-Up  → after insertion
• Heapify-Down → after deletion

===========================================================
APPROACH
===========================================================
INSERT (add):
1) Insert element at the end
2) Bubble-up while parent > child

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
• Heapify ensures heap property recursively
• Always compare parent with both children
• ArrayList index math replaces tree pointers
===========================================================
*/

package HEAP;

import java.util.ArrayList;

public class Heap1 {

    // ---------------------------------------------------
    // Inner Heap class (Min-Heap)
    // ---------------------------------------------------
    public static class Heap {

        // ArrayList to store heap elements
        ArrayList<Integer> arr = new ArrayList<>();

        /*
         * Insert element into heap
         * Steps:
         * 1) Add element at the end
         * 2) Bubble-up to restore heap property
         */
        public void add(int data) {

            // Step 1: Add at the end
            arr.add(data);

            int childIdx = arr.size() - 1;     // index of new node
            int parIdx = (childIdx - 1) / 2;   // parent index

            // Step 2: Bubble-up
            while (childIdx > 0 && arr.get(parIdx) > arr.get(childIdx)) {

                // Swap parent and child
                int temp = arr.get(childIdx);
                arr.set(childIdx, arr.get(parIdx));
                arr.set(parIdx, temp);

                // Move up
                childIdx = parIdx;
                parIdx = (childIdx - 1) / 2;
            }
        }

        /*
         * Return minimum element (root) without removing it
         * Time Complexity: O(1)
         */
        public int peek() {
            return arr.get(0);
        }

        /*
         * Heapify-down operation
         * Restores heap property from index i downward
         */
        private void heapify(int i) {

            int left = 2 * i + 1;   // left child index
            int right = 2 * i + 2;  // right child index
            int minIdx = i;

            // Compare with left child
            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }

            // Compare with right child
            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            // If smallest is not parent, swap and continue heapify
            if (minIdx != i) {

                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        /*
         * Remove and return minimum element (root)
         * Steps:
         * 1) Swap root with last element
         * 2) Remove last element
         * 3) Heapify-down from root
         */
        public int remove() {

            int data = arr.get(0); // value to return

            // Step 1: Swap root and last element
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
         * Check if heap is empty
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

        // Print elements in ascending order
        while (!h.isEmpty()) {
            System.out.println(h.peek()); // minimum element
            h.remove();
        }
    }
}
