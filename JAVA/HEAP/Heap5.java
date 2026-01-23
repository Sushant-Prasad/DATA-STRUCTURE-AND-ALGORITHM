package HEAP;

import java.util.PriorityQueue;

/*
===========================================================
TITLE
===========================================================
Minimum Cost to Connect N Ropes

===========================================================
PROBLEM STATEMENT
===========================================================
You are given an array `arr` representing lengths of `N` ropes.

You need to connect all the ropes into a single rope.
The cost of connecting two ropes is equal to the **sum of their lengths**.

Your task is to calculate the **minimum total cost** required to connect all ropes.

Rules:
• At each step, you can connect any two ropes
• The resulting rope is added back and can be used again

Input:
• int[] arr → lengths of ropes

Output:
• int → minimum cost to connect all ropes

Constraints:
• 1 ≤ N ≤ 10⁵
• 1 ≤ arr[i] ≤ 10⁶

Edge Cases:
• Only one rope → cost = 0
• All ropes having same length
• Large values requiring efficient approach

===========================================================
INTUITION
===========================================================
• Connecting longer ropes earlier increases total cost
• To minimize cost, we should always connect the **two smallest ropes first**
• This greedy choice gives the minimum possible addition at every step
• A Min-Heap allows us to efficiently fetch the smallest ropes

===========================================================
APPROACH
===========================================================
1) Insert all rope lengths into a Min-Heap (PriorityQueue)
2) While more than one rope remains:
   - Remove the two smallest ropes
   - Combine them and add their sum to total cost
   - Insert the combined rope back into the heap
3) When only one rope remains, return the total cost

===========================================================
EXAMPLE
===========================================================
Input:
arr = {2, 3, 3, 4, 6}

Step-wise combination:
2 + 3 = 5   → cost = 5
3 + 4 = 7   → cost = 12
5 + 6 = 11  → cost = 23
7 + 11 = 18 → cost = 41

Output:
41

===========================================================
TIME COMPLEXITY
===========================================================
• Heap construction → O(n)
• Each remove + insert → O(log n)
• Operations performed (n - 1) times

Overall Time Complexity:
O(n log n)

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
• Min-Heap stores all rope lengths

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Greedy strategy guarantees optimal solution
• PriorityQueue in Java acts as a Min-Heap by default
• This is similar to Huffman Encoding cost calculation
• Avoid sorting every time — heap is more efficient
===========================================================
*/

public class Heap5 {

    /*
     * Function to compute minimum cost to connect all ropes
     */
    public static int connectNRopes(int[] arr) {

        int cost = 0; // stores total cost

        // Min-Heap to always get the smallest ropes
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Insert all rope lengths into heap
        for (int rope : arr) {
            pq.add(rope);
        }

        // Combine ropes until only one remains
        while (pq.size() > 1) {

            // Extract two smallest ropes
            int first = pq.remove();
            int second = pq.remove();

            // Combine them
            int combinedLength = first + second;

            // Add cost of this connection
            cost += combinedLength;

            // Insert combined rope back into heap
            pq.add(combinedLength);
        }

        return cost;
    }

    // Driver code
    public static void main(String[] args) {

        int[] ropes = {2, 3, 3, 4, 6};

        System.out.println("Minimum Cost = " + connectNRopes(ropes));
    }
}
