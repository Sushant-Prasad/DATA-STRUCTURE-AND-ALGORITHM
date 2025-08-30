package HEAP;

/**
 * Title: Heap Sort Implementation
 *
 * Description:
 * This program implements Heap Sort using a Max-Heap.
 * Steps:
 *  1. Build a max-heap from the input array
 *  2. Swap the root (largest element) with the last element
 *  3. Reduce heap size and heapify the root again
 *  4. Repeat until the array is sorted
 *
 * Time Complexity:
 *  - Building heap: O(n)
 *  - Each heapify: O(log n)
 *  - Total Heap Sort: O(n log n)
 *
 * Space Complexity:
 *  - O(1) (in-place sorting, only uses constant extra space)
 */
public class Heap3 {

  // Heapify function to maintain max-heap property at index i
  public static void heapify(int arr[], int i, int size) {
    int left = 2 * i + 1;   // left child index
    int right = 2 * i + 2;  // right child index
    int maxIdx = i;         // assume parent is largest

    // check left child
    if (left < size && arr[left] > arr[maxIdx]) {
      maxIdx = left;
    }
    // check right child
    if (right < size && arr[right] > arr[maxIdx]) {
      maxIdx = right;
    }

    // if parent is not largest, swap and recurse
    if (maxIdx != i) {
      int temp = arr[i];
      arr[i] = arr[maxIdx];
      arr[maxIdx] = temp;

      heapify(arr, maxIdx, size);
    }
  }

  // Heap Sort Algorithm
  public static void heapSort(int arr[]) {
    int n = arr.length;

    // Step 1: Build max-heap (from bottom-most non-leaf to root)
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, i, n);
    }

    // Step 2: Repeatedly swap root with last element and heapify
    for (int i = n - 1; i > 0; i--) {
      // swap root (largest) with last element
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      // call heapify on reduced heap
      heapify(arr, 0, i);
    }
  }

  // Driver function
  public static void main(String[] args) {
    int arr[] = { 5, 3, 2, 7, 1, 6 };

    System.out.println("Original Array:");
    for (int x : arr) {
      System.out.print(x + " ");
    }
    System.out.println();

    // Perform heap sort
    heapSort(arr);

    System.out.println("\nSorted Array (Ascending Order):");
    for (int x : arr) {
      System.out.print(x + " ");
    }
  }
}
