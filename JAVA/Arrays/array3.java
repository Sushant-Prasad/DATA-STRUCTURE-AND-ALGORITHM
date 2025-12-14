package Arrays;

// ============================================================================
//  TITLE: Linear Search in an Array
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given an array of integers and a value, check whether the value 
//  exists in the array. If found, print its position; otherwise print 
//  that it is not present.
//
// ============================================================================
//  DEFINITION (Linear Search):
//  ---------------------------
//  Linear Search is the simplest searching technique where:
//      → We scan each element one-by-one from left to right.  
//      → Compare each element with the target value.  
//      → If match found → return index.  
//
//  Works for BOTH sorted and unsorted arrays.
//
// ============================================================================
//  INTUITION:
//  ----------
//  Just check every element until you either:
//      ✔ Find the element, or  
 //     ✔ Reach the end of the array.
//
// ============================================================================
//  APPROACH:
//  ----------
//  1️⃣ Take array input from user.  
//  2️⃣ Input the value to search.  
//  3️⃣ Loop through array elements.  
//  4️⃣ If a[i] == value → element found → break.  
//  5️⃣ After loop, print result based on flag.  
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Input array: [5, 10, 3, 8, 6]
//      Search value: 8
//
//      Check each index:
//          5 ❌  
//          10 ❌  
//          3 ❌  
//          8 ✔ found at position 4  
//
// ============================================================================
//  DRY RUN:
//  --------
//      a = [2, 4, 6, 8]
//      value = 6
//
//      i = 0 → 2 != 6  
//      i = 1 → 4 != 6  
//      i = 2 → 6 == 6 → flag = 0 → break  
//
//      Output: "6 is present and position is 3"
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Works on unsorted arrays too  
//  ✔ Very simple to implement  
//  ✔ Good when array is small  
//  ✔ Inefficient for very large arrays  
//
// ============================================================================
//  TIME COMPLEXITY:
//      Best Case: O(1)   (if found at first index)
//      Worst Case: O(n)  (if last or not present)
//  
//  SPACE COMPLEXITY:
//      O(1)  (no extra space used)
//
// ============================================================================
//  NOTE:
//  -----
//  Using a flag variable helps track whether value was found.
// ============================================================================
//

import java.util.*;

public class array3 {
    public static void main(String args[]) {

        int i, n, value;
        int flag = 1; // flag = 1 means NOT found yet
        int a[] = new int[50]; // array of max size 50

        System.out.println("Enter size of array:");
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        System.out.println("Enter elements of array:");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt(); // take array input
        }

        System.out.println("Enter the value you want to search:");
        value = sc.nextInt();

        // ------------------------- LINEAR SEARCH --------------------------
        for (i = 0; i < n; i++) {
            if (a[i] == value) {  // value found
                flag = 0;
                break;            // stop searching
            }
        }

        // ------------------------- PRINT RESULT ---------------------------
        if (flag == 0) {
            System.out.println(value + " is present and position is " + (i + 1));
        } else {
            System.out.println(value + " is not present");
        }

        sc.close();
    }
}
