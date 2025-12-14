package Arrays;

// ============================================================================
//  TITLE: Binary Search on a Sorted Array
// ============================================================================
//
//  PROBLEM STATEMENT:
//  -------------------
//  Given a sorted array and a key, find the index of the key using Binary Search.
//  If the key is not present, output a message saying "number is not found".
//
// ============================================================================
//  INTUITION:
//  ----------
//  Binary Search works ONLY on sorted arrays.
//  We repeatedly divide the array into two halves:
//      - If middle element is the key → answer found.
//      - If key is greater → search in right half.
//      - If key is smaller → search in left half.
//
//  This reduces the search space by half each time.
//
// ============================================================================
//  APPROACH:
//  ----------
//  1. Take array input from user.
//  2. Initialize start = 0, end = n-1.
//  3. While start <= end:
//        mid = (start + end) / 2
//        If a[mid] == key → print index and return.
//        If a[mid] < key  → move to right half.
//        If a[mid] > key  → move to left half.
//  4. If loop ends → key not found.
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Array: [2, 5, 8, 12, 16, 23]
//      Key = 12
//
//      mid = 2 → value 8 < 12 → search right
//      mid = 4 → value 16 > 12 → search left
//      mid = 3 → value 12 found ✓
//
// ============================================================================
//  DRY RUN:
//  --------
//      a = [10, 20, 30, 40, 50], key = 40
//
//      start=0, end=4 → mid=2 → a[2]=30 < 40 → start=3
//      start=3, end=4 → mid=3 → a[3]=40 == key → found at index 3
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Works only when array is sorted  
//  ✔ Much faster than linear search  
//  ✔ Cuts search space in half each step  
//  ✔ Avoid infinite loops by updating start/end correctly  
//
// ============================================================================
//  IMPORTANT NOTE:
//  ----------------
//  The original code had unreachable "not found" print.
//  Correct approach: print "not found" AFTER the loop, not inside it.
//
// ============================================================================
//  TIME COMPLEXITY:  O(log n)
//  SPACE COMPLEXITY: O(1)
// ============================================================================
//

import java.util.*;

public class array5 {

    // ------------------------ BINARY SEARCH FUNCTION -------------------------
    public static void BinarySearch(int a[], int key, int n) {

        int start = 0, end = n - 1;
        int mid;
        boolean found = false;

        while (start <= end) {

            mid = (start + end) / 2;

            // If key is found
            if (a[mid] == key) {
                System.out.println("The index of key is: " + mid);
                found = true;
                break;
            }

            // If key is larger → search in right half
            else if (a[mid] < key) {
                start = mid + 1;
            }

            // If key is smaller → search in left half
            else {
                end = mid - 1;
            }
        }

        // If loop ends without finding key
        if (!found) {
            System.out.println("Number is not found");
        }
    }


    // ------------------------------ MAIN METHOD ------------------------------
    public static void main(String args[]) {

        int i, n, key;
        int a[] = new int[50];

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        n = sc.nextInt();

        System.out.println("Enter elements of sorted array:");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Enter key:");
        key = sc.nextInt();

        BinarySearch(a, key, n);
        
        sc.close();
    }
}
