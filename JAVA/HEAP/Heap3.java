/*
===========================================================
TITLE
===========================================================
Heap Sort Implementation (Using Max-Heap)

===========================================================
PROBLEM STATEMENT
===========================================================
Given an integer array, sort the array in **ascending order**
using the **Heap Sort** algorithm.

Heap Sort works by:
• Building a Max-Heap from the array
• Repeatedly placing the maximum element at the end
• Reducing heap size and restoring heap property

===========================================================
INTUITION
===========================================================
In a Max-Heap:
• The largest element is always at the root (index 0)

If we:
1) Swap the root with the last element
2) Reduce heap size
3) Heapify the root again

We gradually place the largest elements at the end of the array,
resulting in a sorted array.

===========================================================
APPROACH
===========================================================
1) Build a Max-Heap from the given array
   - Start heapifying from the last non-leaf node

2) Perform Heap Sort:
   - Swap root (largest) with last element
   - Reduce heap size
   - Heapify the root to maintain Max-Heap property

3) Repeat until heap size becomes 1

===========================================================
EXAMPLE
===========================================================
Input:
arr = [5, 3, 2, 7, 1, 6]

Step 1 (Build Max-Heap):
Max-Heap → [7, 5, 6, 3, 1, 2]

Step 2 (Heap Sort):
Place 7 at end → [2, 5, 6, 3, 1, 7]
Heapify → [6, 5, 2, 3, 1, 7]
...
Final Sorted Array:
[1, 2, 3, 5, 6, 7]

===========================================================
TIME COMPLEXITY
===========================================================
• Build Heap      → O(n)
• Heapify (each)  → O(log n)
• Heap Sort Total → O(n log n)

===========================================================
SPACE COMPLEXITY
===========================================================
O(1)
• In-place sorting
• No extra data structures used

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Array indices represent tree structure
• Parent index      → i
• Left child index  → 2*i + 1
• Right child index → 2*i + 2
• Sorting is done in ascending order using Max-Heap
===========================================================
*/

package HEAP;

public class Heap3 {

    /*
     * Heapify function
     * Restores Max-Heap property for subtree rooted at index i
     *
     * @param arr  input array
     * @param i    current root index
     * @param size current heap size
     */
    public static void heapify(int[] arr, int i, int size) {

        int left = 2 * i + 1;   // left child index
        int right = 2 * i + 2;  // right child index
        int maxIdx = i;         // assume parent is largest

        // Compare with left child
        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        // Compare with right child
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        // If parent is not the largest, swap and recurse
        if (maxIdx != i) {

            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, maxIdx, size);
        }
    }

    /*
     * Heap Sort algorithm
     * Sorts the array in ascending order
     */
    public static void heapSort(int[] arr) {

        int n = arr.length;

        // Step 1: Build Max-Heap
        // Start from last non-leaf node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {

            // Swap root (largest) with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, 0, i);
        }
    }

    // Driver code
    public static void main(String[] args) {

        int[] arr = {5, 3, 2, 7, 1, 6};

        System.out.println("Original Array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        // Perform Heap Sort
        heapSort(arr);

        System.out.println("\n\nSorted Array (Ascending Order):");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
