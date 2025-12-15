package Arrays;

import java.util.*;

// ============================================================================
//  TITLE:
//  Counting Sort Algorithm
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given an array of non-negative integers, sort the array
//  using the Counting Sort technique.
//
// ============================================================================
//  INTUITION:
//  ----------
//  Counting Sort does not compare elements.
//  Instead, it counts how many times each value appears
//  and reconstructs the sorted array using this frequency data.
//
// ============================================================================
//  APPROACH (COUNT SORT):
//  ---------------------
//  1. Find the largest element in the array.
//  2. Create a count array of size (largest + 1).
//  3. Store the frequency of each element in the count array.
//  4. Traverse the count array and rebuild the original array
//     in sorted order.
//
// ============================================================================
//  IMPORTANT NOTE:
//  ---------------
//  • Works only for non-negative integers
//  • Best when range of input values is small
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Input Array : [4, 2, 2, 8, 3, 3, 1]
//
//      Count Array : [0,1,2,2,1,0,0,0,1]
//
//      Output Array: [1, 2, 2, 3, 3, 4, 8]
//
// ============================================================================
//  DRY RUN:
//  --------
//      a = [3, 1, 2]
//
//      largest = 3
//      count = [0,1,1,1]
//
//      Sorted array → [1, 2, 3]
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Non-comparison based sorting
//  ✔ Very fast for small range values
//  ✔ Stable if implemented carefully
//
// ============================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • Index of count array represents the element value
//  • Value stored in count[i] represents frequency
//  • Original array is overwritten with sorted values
//
// ============================================================================
//  TIME COMPLEXITY:  O(n + k)   (k = largest element)
//  SPACE COMPLEXITY: O(k)
// ============================================================================
//

public class array15 {

    // ------------------------------------------------------------------------
    // METHOD NAME: countsort
    // PURPOSE    : Sorts array using Counting Sort
    // ------------------------------------------------------------------------
    public static void countsort(int a[], int n) {

        int i;

        // Step 1: Find the largest element
        int largest = Integer.MIN_VALUE;
        for (i = 0; i < n; i++) {
            largest = Math.max(largest, a[i]);
        }

        // Step 2: Create count array
        int count[] = new int[largest + 1];

        // Step 3: Store frequency of each element
        for (i = 0; i < n; i++) {
            count[a[i]]++;
        }

        // Step 4: Reconstruct the sorted array
        int j = 0; // index for original array
        for (i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                a[j] = i;
                j++;
                count[i]--;
            }
        }

        // Print sorted array
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // ------------------------------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------------------------------
    public static void main(String args[]) {

        int i, n;
        int a[] = new int[50];

        Scanner sc = new Scanner(System.in);

        // Input size of array
        System.out.println("Enter size of array:");
        n = sc.nextInt();

        // Input array elements
        System.out.println("Enter the elements of array:");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Perform counting sort
        System.out.println("Sorted array is:");
        countsort(a, n);

        sc.close();
    }
}
