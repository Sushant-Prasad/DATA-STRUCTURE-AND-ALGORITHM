package Arrays;

import java.util.*;

// ============================================================================
//  TITLE:
//  Sorting Algorithms – Insertion Sort, Bubble Sort, Selection Sort
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given an array of integers, sort the array in ascending order
//  using different comparison-based sorting algorithms.
//
// ============================================================================
//  INTUITION:
//  ----------
//  Sorting arranges elements in a specific order (ascending here).
//  Different algorithms use different strategies to reorder elements.
//  This program demonstrates three basic sorting algorithms.
//
// ============================================================================
//  ALGORITHMS USED:
//  ----------------
//  1. Insertion Sort  → Builds sorted array one element at a time
//  2. Bubble Sort     → Repeatedly swaps adjacent elements
//  3. Selection Sort  → Selects minimum element and places it correctly
//
// ============================================================================
//  KEY COMPARISON:
//  ---------------
//  | Algorithm       | Time Complexity | Space | Stable |
//  |-----------------|-----------------|--------|--------|
//  | Insertion Sort  | O(n²)           | O(1)   | Yes    |
//  | Bubble Sort     | O(n²)           | O(1)   | Yes    |
//  | Selection Sort  | O(n²)           | O(1)   | No     |
//
// ============================================================================
//  SPECIAL NOTES:
//  --------------
//  • Suitable for small input sizes
//  • Used for learning and interview basics
//  • All algorithms sort in-place
//
// ============================================================================
//

public class array14 {

    // ========================================================================
    //  INSERTION SORT
    // ========================================================================
    //
    //  IDEA:
    //  -----
//  Pick one element and insert it into its correct position
//  in the already sorted part of the array.
//
//  WORKING:
//  --------
//  • Left portion of array is always sorted
//  • Current element is compared and shifted to its position
//
//  TIME COMPLEXITY:  O(n²)
//  SPACE COMPLEXITY: O(1)
//
    public static void insertionsort(int a[], int n) {

        for (int i = 1; i < n; i++) {

            int curr = a[i];      // element to be inserted
            int prev = i - 1;     // index of previous element

            // Shift elements greater than curr to the right
            while (prev >= 0 && a[prev] > curr) {
                a[prev + 1] = a[prev];
                prev--;
            }

            // Insert current element at correct position
            a[prev + 1] = curr;
        }

        // Print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // ========================================================================
    //  BUBBLE SORT
    // ========================================================================
    //
    //  IDEA:
    //  -----
    //  Repeatedly compare adjacent elements and swap them if they
    //  are in the wrong order.
    //
    //  WORKING:
    //  --------
    //  • Largest element moves to the end in each pass
    //  • Number of comparisons reduces after every iteration
    //
    //  TIME COMPLEXITY:  O(n²)
    //  SPACE COMPLEXITY: O(1)
    //
    public static void bubblesort(int a[], int n) {

        int temp;

        for (int turn = 0; turn < n - 1; turn++) {

            for (int j = 0; j < n - 1 - turn; j++) {

                // Swap if adjacent elements are in wrong order
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        // Print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // ========================================================================
    //  SELECTION SORT
    // ========================================================================
    //
    //  IDEA:
    //  -----
    //  Select the minimum element from the unsorted part
    //  and swap it with the first unsorted element.
    //
    //  NOTE:
    //  -----
    //  For descending order:
    //      Replace (a[minPos] > a[j]) with (a[minPos] < a[j])
    //
    //  TIME COMPLEXITY:  O(n²)
    //  SPACE COMPLEXITY: O(1)
    //
    public static void selectionsort(int a[], int n) {

        for (int i = 0; i < n - 1; i++) {

            int minPos = i;   // assume current index has minimum value

            // Find minimum element in unsorted part
            for (int j = i + 1; j < n; j++) {
                if (a[minPos] > a[j]) {
                    minPos = j;
                }
            }

            // Swap minimum element with first unsorted element
            int temp = a[minPos];
            a[minPos] = a[i];
            a[i] = temp;
        }

        // Print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // ========================================================================
    //  MAIN METHOD
    // ========================================================================
    public static void main(String args[]) {

        int n;
        int a[] = new int[50];

        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.println("Enter size of array:");
        n = sc.nextInt();

        // Input array elements
        System.out.println("Enter the elements of array:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Call desired sorting algorithm
        System.out.println("Sorted array is:");
        insertionsort(a, n);
        // bubblesort(a, n);
        // selectionsort(a, n);

        sc.close();
    }
}
