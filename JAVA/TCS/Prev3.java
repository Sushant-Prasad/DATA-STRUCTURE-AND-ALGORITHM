/*
===========================================================
TITLE
===========================================================
Count Elements Greater Than All Previous Elements

===========================================================
PROBLEM STATEMENT
===========================================================
Given an integer array Arr of size N, count how many elements
are greater than all elements before them.

Note:
• The first element is always counted.

===========================================================
INTUITION
===========================================================
Maintain a running maximum.
If the current element is greater than the maximum seen so far,
increase the count and update the maximum.

===========================================================
APPROACH
===========================================================
1) Initialize max with first element
2) Initialize count = 1
3) Traverse from index 1 to N-1
4) If arr[i] > max:
   - increment count
   - update max

===========================================================
TIME COMPLEXITY
===========================================================
O(N)

===========================================================
SPACE COMPLEXITY
===========================================================
O(1)
===========================================================
*/

package TCS;
import java.util.*;

public class Prev3 {

    // Function to count elements greater than all previous elements
    private static int countPrior(int[] arr, int n) {

        int max = arr[0];   // First element
        int count = 1;      // First element is always counted

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                count++;
                max = arr[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();      // Size of array
        int[] arr = new int[n];    // Exact size array

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(countPrior(arr, n));
    }
}
