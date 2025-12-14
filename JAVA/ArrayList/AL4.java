package ArrayList;

import java.util.ArrayList;

/*
 * ============================================================================
 *  TITLE: Pair Sum in a Sorted and Rotated Array (Pair Sum – 2)
 * ============================================================================
 *
 *  PROBLEM STATEMENT:
 *  -------------------
 *  Given a sorted and rotated ArrayList, determine whether 
 *  there exists a pair (i, j) such that:
 *
 *        list[i] + list[j] == target
 *
 *  The array is sorted BUT rotated at some pivot.
 *
 *  Example of sorted & rotated list:
 *      [11, 15, 6, 8, 9, 10]   ← rotated version of [6, 8, 9, 10, 11, 15]
 *
 * ============================================================================
 *  INTUITION:
 *  ----------
 *  A sorted & rotated array has a special structure:
 *
 *      One element is a "breaking point" where the sorted order breaks.
 *
 *  Example:
 *      [13, 15, 20, 7, 9, 11]
 *               ↑ breaking point (20 > 7)
 *
 *  After identifying the breaking point:
 *
 *      smallest element (pivot) → (bp + 1)
 *      largest element         → (bp)
 *
 *  Then we can apply **circular two-pointer technique**.
 *
 * ============================================================================
 *  APPROACH (Two-pointer on circular array):
 *  -----------------------------------------
 *
 *  1️⃣ Find the breaking point:
 *          list[i] > list[i+1] → this is where rotation happened
 *
 *  2️⃣ Set pointers:
 *          left  = bp + 1   (smallest element)
 *          right = bp       (largest element)
 *
 *  3️⃣ While left != right:
 *          check sum:
 *              → if equal → return true
 *              → if sum < target → move left forward (circular)
 *              → if sum > target → move right backward (circular)
 *
 *  4️⃣ If loop ends → no pair found.
 *
 * ============================================================================
 *  SPECIAL NOTE (circular movement):
 *  ---------------------------------
 *
 *      left  = (left + 1) % n
 *      right = (right - 1 + n) % n
 *
 *  This allows pointers to wrap around in the rotated array.
 *
 * ============================================================================
 *  EXAMPLE:
 *  --------
 *      list   = [13, 15, 20, 7, 9, 11]
 *      target = 29
 *
 *      Breaking point = 20 > 7 → bp = 2
 *
 *      left = 3 → 7
 *      right = 2 → 20
 *
 *      7 + 20 = 27 < 29 → move left
 *      9 + 20 = 29 ✔ → return true
 *
 * ============================================================================
 *  DRY RUN (Step-by-step):
 *  ------------------------
 *      left = 3 (7), right = 2 (20)
 *      7 + 20 = 27 < 29 → left = (3+1)%6 = 4
 *
 *      left = 4 (9), right = 2 (20)
 *      9 + 20 = 29 → true
 *
 * ============================================================================
 *  KEY POINTS:
 *  ------------
 *  ✔ Works in O(n)  
 *  ✔ Uses rotation properties to position pointers  
 *  ✔ Circular movement ensures proper traversal  
 *  ✔ Finds pair without sorting or modifying list  
 *
 * ============================================================================
 *  TIME COMPLEXITY:
 *      O(n)
 *
 *  SPACE COMPLEXITY:
 *      O(1)
 * ============================================================================
 */

public class AL4 {

    // -----------------------------------------------------------
    // FUNCTION: Check if a sorted & rotated list has a pair sum
    // -----------------------------------------------------------
    public static boolean pairSum2(ArrayList<Integer> list, int target) {

        int n = list.size();
        int bp = -1;   // breaking point

        /* -------------------------------------------------------
         * Step 1: Find the BREAKING POINT (rotation index)
         * -------------------------------------------------------
         * The point where list[i] > list[i+1]
         */
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }

        /* -------------------------------------------------------
         * Step 2: Initialize two pointers
         * -------------------------------------------------------
         * left  → smallest element index
         * right → largest element index
         */
        int left = bp + 1;  // next element after breaking point
        int right = bp;     // breaking point itself (largest)

        /* -------------------------------------------------------
         * Step 3: Circular Two-pointer search
         * -------------------------------------------------------
         */
        while (left != right) {

            int sum = list.get(left) + list.get(right);

            // Pair found
            if (sum == target)
                return true;

            // If sum is too small → move left forward (circular)
            if (sum < target) {
                left = (left + 1) % n;
            }

            // If sum is too big → move right backward (circular)
            else {
                right = (n + right - 1) % n;
            }
        }

        return false;  // No pair found
    }


    // -----------------------------------------------------------
    // DRIVER CODE
    // -----------------------------------------------------------
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(13);
        list.add(15);
        list.add(20);
        list.add(7);
        list.add(9);
        list.add(11);

        int target = 29;

        System.out.println(pairSum2(list, target));  // Output: true
    }
}
