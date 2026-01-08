/*
===========================================================
TITLE
===========================================================
Maximum Sum of Equal NON-OVERLAPPING Subarrays

===========================================================
PROBLEM STATEMENT
===========================================================
You are given an integer array `arr` of size `n`.

Your task is to find the **maximum sum of a subarray** such that:
• There exist **at least two subarrays**
• Both subarrays have the **same sum**
• The two subarrays are **NON-OVERLAPPING**

If no such subarray exists, print `0`.

===========================================================
INPUT FORMAT
===========================================================
• First input  → Integer `n`
• Second input → `n` integers

===========================================================
OUTPUT FORMAT
===========================================================
• Print a single integer
• Maximum sum of two equal non-overlapping subarrays
• Print `0` if none exists

===========================================================
INTUITION
===========================================================
If two non-overlapping subarrays have the same sum, then:
• One must finish earlier
• The other must start later

So for each sum:
• Track the earliest ending index
• Track the latest starting index
• If they do not overlap → valid answer

===========================================================
APPROACH
===========================================================
1) Build prefix sum array
2) Generate all subarray sums
3) For each sum, store:
   - earliest ending index
   - latest starting index
4) If earliestEnd < latestStart → non-overlapping
5) Track maximum such sum

===========================================================
TIME COMPLEXITY
===========================================================
O(n²)

===========================================================
SPACE COMPLEXITY
===========================================================
O(n²) (HashMap)
===========================================================
*/

package TCS;
import java.util.*;

public class TAG2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (n < 2) {
            System.out.println(0);
            return;
        }

        // Prefix sum
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        /*
         Map structure:
         sum -> int[]{ earliestEndIndex, latestStartIndex }
        */
        HashMap<Integer, int[]> map = new HashMap<>();

        int maxSum = 0;

        // Generate all subarrays
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {

                int sum = prefixSum[end + 1] - prefixSum[start];

                if (!map.containsKey(sum)) {
                    // first occurrence of this sum
                    map.put(sum, new int[]{end, start});
                } else {
                    int[] pos = map.get(sum);

                    int earliestEnd = pos[0];
                    int latestStart = pos[1];

                    // NON-OVERLAPPING check
                    if (earliestEnd < start || end < latestStart) {
                        maxSum = Math.max(maxSum, sum);
                    }

                    // update boundaries
                    pos[0] = Math.min(earliestEnd, end);
                    pos[1] = Math.max(latestStart, start);
                }
            }
        }

        System.out.println(maxSum);
    }
}
