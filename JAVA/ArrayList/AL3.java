package ArrayList;

import java.util.*;

/*
 * ============================================================================
 *  TITLE: Pair Sum Problem (Sorted ArrayList)
 * ============================================================================
 *
 *  PROBLEM STATEMENT:
 *  -------------------
 *  Given a **sorted ArrayList** and a target value,
 *  determine whether there exists **any pair** (i, j) such that:
 *
 *        list[i] + list[j] == target
 *
 *  Return true if such a pair exists; otherwise return false.
 *
 * ============================================================================
 *  INTUITION:
 *  ----------
 *  Since the array is already **sorted**, we can use the
 *  **two-pointer technique** to find the pair in O(N) time.
 *
 *  Idea:
 *      - One pointer starts from the left (small values)
 *      - One pointer starts from the right (large values)
 *
 *      Compare their sum with target:
 *          ✔ If sum == target → Pair found
 *          ✔ If sum < target → Move left pointer to increase sum
 *          ✔ If sum > target → Move right pointer to decrease sum
 *
 * ============================================================================
 *  BRUTE FORCE APPROACH:
 *  ----------------------
 *    • Check all pairs using two nested loops.
 *    • Time Complexity: O(N²)
 *
 *  (Code is included below but commented out.)
 *
 * ============================================================================
 *  OPTIMIZED APPROACH (Two Pointer Technique):
 *  -------------------------------------------
 *    • Works only because the list is sorted
 *    • Linear time complexity → O(N)
 *
 * ============================================================================
 *  EXAMPLE:
 *  --------
 *    list   = [1, 2, 4, 7, 9, 11]
 *    target = 13
 *
 *    left=0 → 1
 *    right=5 → 11
 *
 *    1 + 11 = 12 < 13 → move left →
 *
 *    left=1 → 2
 *    right=5 → 11
 *
 *    2 + 11 = 13 → PAIR FOUND ✔
 *
 * ============================================================================
 *  DRY RUN:
 *  ---------
 *    list   = [1, 2, 4, 7, 9], target = 10
 *
 *    (left=0, right=4) 1+9 = 10 → return true
 *
 * ============================================================================
 *  KEY POINTS:
 *  ------------
 *  ✔ Two-pointer works only on sorted arrays  
 *  ✔ Efficient: O(N)  
 *  ✔ No extra space required  
 *  ✔ Only checks necessary pairs  
 *
 * ============================================================================
 *  TIME COMPLEXITY:
 *      O(N)
 *
 *  SPACE COMPLEXITY:
 *      O(1)
 * ============================================================================
 *
 *  SPECIAL NOTE FOR LOGIC:
 *  ------------------------
 *  - When sum < target → move left++ increases sum because array is sorted  
 *  - When sum > target → move right-- decreases sum  
 *
 *  This greedy movement ensures we explore all possible sums efficiently.
 *
 * ============================================================================
 */

public class AL3 {

    // ---------------------- BRUTE FORCE APPROACH ----------------------
    // Time: O(N*N)
    /*
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (list.get(i) + list.get(j) == target)
                    return true;
            }
        }
        return false;
    }
    */

    // ---------------------- OPTIMIZED APPROACH -----------------------
    // Two Pointer Technique – Time: O(N)
    public static boolean pairSum(ArrayList<Integer> list, int target) {

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            int sum = list.get(left) + list.get(right);

            // Pair found
            if (sum == target) 
                return true;

            // Need a larger sum → move left pointer
            if (sum < target) {
                left++;
            }

            // Need a smaller sum → move right pointer
            else {
                right--;
            }
        }

        return false;   // no pair found
    }

    // ---------------------- DRIVER CODE ----------------------
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(7);
        list.add(9);
        list.add(11);

        int target = 18;

        System.out.println(pairSum(list, target));
    }
}
