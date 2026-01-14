/*
===========================================================
TITLE
===========================================================
1399. Count Largest Group

===========================================================
PROBLEM STATEMENT
===========================================================
You are given an integer `n`.

Each number from `1` to `n` is grouped according to the
**sum of its digits**.

Your task is to return the **number of groups** that have
the **largest size**.

===========================================================
PROBLEM RESOURCE (links)
===========================================================
https://leetcode.com/problems/count-largest-group/

===========================================================
INTUITION
===========================================================
• Numbers with the same digit sum belong to the same group
• We need to:
  - Count how many numbers fall into each digit-sum group
  - Find the maximum group size
  - Count how many groups have this maximum size

HashMap is ideal because:
• Key   → digit sum
• Value → frequency (group size)

===========================================================
APPROACH
===========================================================
1) Create a helper function to compute digit sum of a number
2) Traverse numbers from 1 to n
3) For each number:
   - Compute digit sum
   - Update frequency in HashMap
4) Track:
   - `maxSize` → largest group size so far
   - `count`   → number of groups having size = maxSize
5) Return `count`

===========================================================
EXAMPLE
===========================================================
Input:
n = 13

Digit sum grouping:
1  → 1
2  → 2
...
10 → 1
11 → 2
12 → 3
13 → 4

Group sizes:
1 → {1,10} → size = 2
2 → {2,11} → size = 2
3 → {3,12} → size = 2
4 → {4,13} → size = 2

Largest size = 2
Number of such groups = 4

Output:
4

===========================================================
TIME COMPLEXITY
===========================================================
O(n × d)
• `d` = number of digits in `n` (≤ 4 for constraints)
• Practically O(n)

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
• HashMap stores digit sums and their frequencies

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Digit sum is always small (≤ 36 for n ≤ 10⁴)
• HashMap.getOrDefault() simplifies frequency updates
• `count` resets when a new maximum group size is found
===========================================================
*/

package Hashing;

import java.util.HashMap;

public class Hash2 {

    class Solution {

        // ---------------------------------------------------
        // Helper function to calculate digit sum of a number
        // ---------------------------------------------------
        public int findDigiSum(int n) {
            int sum = 0;

            // Extract digits and accumulate sum
            while (n != 0) {
                sum += n % 10; // Add last digit
                n = n / 10;    // Remove last digit
            }

            return sum;
        }

        // ---------------------------------------------------
        // Main function to count largest groups
        // ---------------------------------------------------
        public int countLargestGroup(int n) {

            // HashMap to store digitSum → frequency
            HashMap<Integer, Integer> map = new HashMap<>();

            int maxSize = 0; // Largest group size seen so far
            int count = 0;   // Number of groups having maxSize

            // Traverse numbers from 1 to n
            for (int i = 1; i <= n; i++) {

                // Calculate digit sum
                int digiSum = findDigiSum(i);

                // Update frequency of this digit sum
                map.put(digiSum, map.getOrDefault(digiSum, 0) + 1);

                int currentSize = map.get(digiSum);

                // If another group matches current max size
                if (currentSize == maxSize) {
                    count++;
                }
                // If a new maximum group size is found
                else if (currentSize > maxSize) {
                    maxSize = currentSize;
                    count = 1; // Reset count
                }
            }

            // Return number of largest groups
            return count;
        }
    }
}
