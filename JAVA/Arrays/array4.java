package Arrays;

// ============================================================================
//  TITLE: Find Largest and Smallest Number in an Array
// ============================================================================
//
//  PROBLEM STATEMENT:
//  -------------------
//  Given an integer array of size n, find:
//      ✔ The largest (maximum) number
//      ✔ The smallest (minimum) number
//
// ============================================================================
//  INTUITION:
//  ----------
//  We simply scan the array once and keep updating:
//      • max → whenever we find a bigger number
//      • min → whenever we find a smaller number
//
//  This is the most efficient way because every element must be checked.
//
// ============================================================================
//  APPROACH:
//  ----------
//  1️⃣ Take array input from user  
//  2️⃣ Initialize:
//         max = Integer.MIN_VALUE (−∞)
//         min = Integer.MAX_VALUE (+∞)
//  3️⃣ Traverse array and update max & min  
//  4️⃣ Print the results  
//
// ============================================================================
//  WHY USE Integer.MIN_VALUE & Integer.MAX_VALUE?
//  ----------------------------------------------
//  • Integer.MIN_VALUE = -2,147,483,648  
//        Acts like negative infinity  
//        Ensures ANY number will be larger  
//
//  • Integer.MAX_VALUE =  2,147,483,647  
//        Acts like positive infinity  
//        Ensures ANY number will be smaller  
//
//  This avoids logical errors during comparison.
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Input: [5, 2, 9, 1, 7]
//      max = 9
//      min = 1
//
// ============================================================================
//  DRY RUN:
//  --------
//      a = [10, 3, 8]
//      max = MIN_VALUE → updated to 10
//      min = MAX_VALUE → updated to 10
//
//      Next: 3
//         max = 10 (unchanged)
//         min = 3
//
//      Next: 8
//         max = 10
//         min = 3
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Only 1 loop → O(n) time  
//  ✔ No extra space → O(1) space  
//  ✔ Works for both positive & negative numbers  
//  ✔ Best method for max/min in arrays  
//
// ============================================================================
//  TIME COMPLEXITY:   O(n)
//  SPACE COMPLEXITY:  O(1)
// ============================================================================
//

import java.util.*;

public class array4 { 
    public static void main(String args[]) {

        int i, n, max, min;
        int a[] = new int[50];

        System.out.println("Enter size of array:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.println("Enter elements of array:");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Initialize max to -∞ and min to +∞
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        // Traverse array to update max and min
        for (i = 0; i < n; i++) {

            if (max < a[i]) {   // update maximum
                max = a[i];
            }

            if (min > a[i]) {   // update minimum
                min = a[i];
            }
        }

        System.out.println("Largest number is " + max);
        System.out.println("Smallest number is " + min);
    }
}
