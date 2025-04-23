/*1399. Count Largest Group;
You are given an integer n.

Each number from 1 to n is grouped according to the sum of its digits.

Return the number of groups that have the largest size.
 
 */
package Hashing;

import java.util.HashMap;

public class Hash2 {
    class Solution {

    // Function to compute the sum of digits of a number
    public int findDigiSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10; // Add the last digit to sum
            n = n / 10;    // Remove the last digit
        }
        return sum;
    }

    // Function to count the number of groups having the largest size
    public int countLargestGroup(int n) {
        // HashMap to keep track of frequency of each digit sum
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int maxSize = 0; // To store the size of the largest group
        int count = 0;   // To count how many groups have size == maxSize

        // Loop through all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            int digiSum = findDigiSum(i); // Get the digit sum of current number

            // Update the frequency of this digit sum in the map
            map.put(digiSum, map.getOrDefault(digiSum, 0) + 1);

            // Check if this digit sum group has become the new max
            if (map.get(digiSum) == maxSize) {
                count++; // Another group with same max size
            } else if (map.get(digiSum) > maxSize) {
                maxSize = map.get(digiSum); // New max size found
                count = 1; // Reset count because this is now the largest group
            }
        }

        // Return number of groups that have size equal to maxSize
        return count;
    }
}

  
}
