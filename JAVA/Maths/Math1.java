
/*You are given a 0-indexed array of n integers differences, which describes the differences between each pair of consecutive integers of a hidden sequence of length (n + 1). More formally, call the hidden sequence hidden, then we have that differences[i] = hidden[i + 1] - hidden[i].

You are further given two integers lower and upper that describe the inclusive range of values [lower, upper] that the hidden sequence can contain.

For example, given differences = [1, -3, 4], lower = 1, upper = 6, the hidden sequence is a sequence of length 4 whose elements are in between 1 and 6 (inclusive).
[3, 4, 1, 5] and [4, 5, 2, 6] are possible hidden sequences.
[5, 6, 3, 7] is not possible since it contains an element greater than 6.
[1, 2, 3, 4] is not possible since the differences are not correct.
Return the number of possible hidden sequences there are. If there are no possible sequences, return 0.
Link:-https://leetcode.com/problems/count-the-hidden-sequences/description/?envType=daily-question&envId=2025-04-21 
*/
package Maths;

public class Math1 {

    //  Method to calculate number of valid arrays based on differences and bounds
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int curr = 0; // lets starting the array from array[0]=0
        int minVal = 0;//minimum value of array
        int maxVal = 0;//max value of array

        // Traverse through the differences
        for (int d : differences) {
            curr += d;
            minVal = Math.min(minVal, curr);
            maxVal = Math.max(maxVal, curr);

            // If difference range exceeds limits, no valid array possible
            if ((upper - maxVal) - (lower - minVal) + 1 <= 0) {
                return 0;
            }
        }

        // Total number of valid arrays possible
        return (upper - maxVal) - (lower - minVal) + 1;
    }

    // ---------------- Driver Code ----------------
    public static void main(String[] args) {
        Math1 a = new Math1();

        int[] differences = {1, -3, 4};
        int lower = 1;
        int upper = 6;

        int result = a.numberOfArrays(differences, lower, upper);
        System.out.println("Number of valid arrays: " + result);
    }
}

