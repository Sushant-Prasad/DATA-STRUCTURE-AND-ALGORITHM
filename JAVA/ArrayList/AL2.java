package ArrayList;

public class AL2 {

    /*
     * =========================================================================
     *  TITLE: 11. Container With Most Water
     * =========================================================================
     *
     *  PROBLEM STATEMENT:
     *  -------------------
     *  You are given an integer array 'height' where height[i] represents the 
     *  height of a vertical line drawn at index i.
     *
     *  Any two lines at index i and j (i < j) can hold water between them.
     *
     *  The area formed between two lines is:
     *          Area = min(height[i], height[j]) * (j - i)
     *
     *  Your task:
     *      Return the **maximum water** the container can store.
     *
     * =========================================================================
     *  INTUITION:
     *  ----------
     *  The area depends on:
     *      → the shorter height of the two lines
     *      → the distance between them
     *
     *  If we start with the widest container (left at 0, right at n-1):
     *      • Width is maximum.
     *      • Next step: try to increase height by moving the smaller side.
     *
     *  WHY move the smaller height?
     *      Because moving the taller height DOES NOT help —
     *      width decreases AND height remains limited by the smaller line.
     *
     * =========================================================================
     *  APPROACH (Two Pointer Technique):
     *  ----------------------------------
     *  1️⃣ Initialize:
     *          left = 0
     *          right = n - 1
     *
     *  2️⃣ Compute area at each step:
     *          currArea = min(height[left], height[right]) * (right - left)
     *
     *  3️⃣ Update maxArea if needed.
     *
     *  4️⃣ Move the pointer at the smaller height inward:
     *          if height[left] < height[right] :
     *                  left++
     *          else:
     *                  right--
     *
     *  5️⃣ Repeat until left >= right.
     *
     * =========================================================================
     *  EXAMPLE:
     *  --------
     *      height = [1,8,6,2,5,4,8,3,7]
     *
     *      Initial: left=0, right=8
     *      width = 8
     *      min height = min(1,7) = 1
     *      area = 1 * 8 = 8
     *
     *      Move left (because 1 < 7)
     *
     * =========================================================================
     *  DRY RUN (Small Example):
     *  -------------------------
     *      height = [1,4,2,3]
     *
     *      left=0 (1), right=3 (3)
     *          area = 1 * 3 = 3
     *          move left → left=1
     *
     *      left=1 (4), right=3 (3)
     *          area = 3 * 2 = 6
     *          move right → right=2
     *
     *      left=1 (4), right=2 (2)
     *          area = 2 * 1 = 2
     *          move right → right=1
     *
     *      STOP (left == right)
     *      Max area = 6
     *
     * =========================================================================
     *  KEY POINTS:
     *  ------------
     *  ✔ Two-pointer approach ensures O(n) time  
     *  ✔ Always move the pointer with the smaller height  
     *  ✔ You never need to check combinations where width shrinks AND height does not increase  
     *  ✔ This greedy approach is mathematically proven correct  
     *
     * =========================================================================
     *  SPECIAL NOTES FOR LOGIC:
     *  -------------------------
     *
     *   Why move the smaller height?
     *      Because area = min(h1, h2) * width
     *      → width always decreases
     *      → only way to increase area is to find a taller line
     *      → so move the smaller pointer
     *
     *  We never miss the optimal answer because:
     *      Any container formed with the shorter line as one boundary
     *      can only get better by replacing it with a taller line.
     *
     * =========================================================================
     *  TIME COMPLEXITY:
     *      O(n)
     *
     *  SPACE COMPLEXITY:
     *      O(1)
     * =========================================================================
     */


    // -------------------- OPTIMIZED SOLUTION -------------------------
    public static int maxArea(int[] height) {

        int left = 0;                          // left pointer
        int right = height.length - 1;         // right pointer
        int maxArea = 0;

        while (left < right) {

            // Area between current two lines
            int currArea = Math.min(height[left], height[right]) * (right - left);

            maxArea = Math.max(maxArea, currArea);

            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }


    // ------------------ DRIVER CODE ------------------
    public static void main(String[] args) {
        int[] arr = {1,12,6,2,3,4,8,3,10};
        System.out.println(maxArea(arr));  // output max water stored
    }

}
