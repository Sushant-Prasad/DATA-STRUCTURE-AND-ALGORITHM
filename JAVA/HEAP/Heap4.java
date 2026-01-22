/*
===========================================================
TITLE
===========================================================
Find K Closest Cars to the Origin (0,0)

===========================================================
PROBLEM STATEMENT
===========================================================
You are given coordinates of `n` cars on a 2D plane.
Each car is represented by (x, y).

Your task is to find the **K cars that are closest to the origin (0,0)**.

Distance is calculated using Euclidean distance:
    distance = √(x² + y²)

NOTE:
• Since square root is monotonic, we compare using **squared distance**
  → x² + y² (avoids floating point computation)

===========================================================
INTUITION
===========================================================
To always get the closest car efficiently:
• We need a data structure that can quickly give the minimum distance

A **Min-Heap (PriorityQueue)** is perfect because:
• The smallest element is always at the top
• Insert and remove operations are efficient

===========================================================
APPROACH
===========================================================
1) Create a custom class `Points` that stores:
   - x coordinate
   - y coordinate
   - squared distance from origin
   - original index of the car

2) Implement Comparable interface so that:
   - PriorityQueue sorts points by increasing distance

3) Insert all cars into a Min-Heap (PriorityQueue)

4) Remove K elements from the heap
   - These will be the K closest cars

===========================================================
EXAMPLE
===========================================================
Input:
points = { {3,3}, {5,-1}, {-2,4} }
k = 2

Squared distances:
Car 0 → 3² + 3² = 18
Car 1 → 5² + (-1)² = 26
Car 2 → (-2)² + 4² = 20

Sorted by distance:
C0 (18), C2 (20), C1 (26)

Output:
C0
C2

===========================================================
TIME COMPLEXITY
===========================================================
• Insert n elements into PQ → O(n log n)
• Remove k elements         → O(k log n)
• Overall                   → O(n log n)

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
• PriorityQueue stores all cars

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Squared distance is used instead of actual distance
• Comparable interface ensures automatic heap ordering
• PriorityQueue in Java is a Min-Heap by default
===========================================================
*/

package HEAP;

import java.util.PriorityQueue;

public class Heap4 {

    /*
     * Custom class to represent a car's position
     * Implements Comparable so that PriorityQueue
     * orders cars by increasing distance from origin
     */
    public static class Points implements Comparable<Points> {

        int x;        // x-coordinate
        int y;        // y-coordinate
        int distSq;   // squared distance from origin
        int idx;      // original index of the car

        // Constructor
        Points(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        // Compare based on squared distance (Min-Heap behavior)
        @Override
        public int compareTo(Points p2) {
            return this.distSq - p2.distSq;
        }
    }

    /*
     * Function to print indices of K closest cars
     *
     * @param arr  2D array containing car coordinates
     * @param k    number of closest cars required
     */
    public static void nearbyCar(int[][] arr, int k) {

        // Min-Heap based on squared distance
        PriorityQueue<Points> pq = new PriorityQueue<>();

        // Step 1: Insert all cars into the heap
        for (int i = 0; i < arr.length; i++) {

            int x = arr[i][0];
            int y = arr[i][1];

            // Calculate squared distance from origin
            int distSq = x * x + y * y;

            // Add car to heap
            pq.add(new Points(x, y, distSq, i));
        }

        // Step 2: Extract K closest cars
        for (int i = 0; i < k; i++) {
            Points p = pq.remove();   // closest car
            System.out.println("C" + p.idx);
        }
    }

    // Driver method
    public static void main(String[] args) {

        int[][] points = { {3, 3}, {5, -1}, {-2, 4} };
        int k = 2;

        nearbyCar(points, k);
    }
}
