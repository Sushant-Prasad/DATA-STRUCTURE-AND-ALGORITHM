/*
===========================================================
TITLE
===========================================================
Unique Number II (Find Two Non-Repeating Numbers)

===========================================================
PROBLEM STATEMENT
===========================================================
Given an array `arr[]` containing (2*n + 2) positive numbers:

• Exactly 2 numbers appear only once  
• All other numbers appear exactly twice  

Task:
Find the two unique numbers and return them in increasing order.

===========================================================
PROBLEM RESOURCE (links)
===========================================================
https://www.geeksforgeeks.org/problems/finding-the-numbers0215/1

===========================================================
INTUITION
===========================================================
If a number appears twice, it should cancel itself.
If a number appears once, it should remain.

HashSet is perfect here because:
• Adding a number first time → it goes into the set
• Adding it second time → remove it

At the end:
• The set contains only the two numbers that appeared once

===========================================================
APPROACH
===========================================================
1) Create a HashSet to track unique elements
2) Traverse the array:
   - If element exists in set → remove it
   - Else → add it
3) After traversal, the set will contain exactly 2 elements
4) Copy them into an array
5) Sort the array
6) Return the result

===========================================================
EXAMPLE
===========================================================
Input:
arr = [1, 2, 3, 2, 1, 4]

HashSet processing:
1 → add  
2 → add  
3 → add  
2 → remove  
1 → remove  
4 → add  

HashSet = {3, 4}

Output:
[3, 4]

===========================================================
TIME COMPLEXITY
===========================================================
O(n)
• Single traversal of the array

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
• HashSet stores elements temporarily

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• HashSet automatically handles duplicates
• Exactly two elements remain at the end
• Sorting ensures increasing order as required
===========================================================
*/

package Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class Hash1 {

    class Solution {

        public int[] singleNum(int[] arr) {

            // HashSet to track numbers appearing odd number of times
            HashSet<Integer> set = new HashSet<>();

            // Traverse array
            for (int num : arr) {

                // If already present → remove (pair completed)
                if (set.contains(num)) {
                    set.remove(num);
                }
                // First occurrence → add to set
                else {
                    set.add(num);
                }
            }

            // Array to store the two unique numbers
            int[] result = new int[2];
            int index = 0;

            // Copy remaining elements from set to array
            for (int val : set) {
                result[index++] = val;
            }

            // Sort result in increasing order
            Arrays.sort(result);

            return result;
        }
    }
}
