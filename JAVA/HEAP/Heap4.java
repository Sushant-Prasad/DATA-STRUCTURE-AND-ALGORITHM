package HEAP;

import java.util.PriorityQueue;

/**
 * Title: Find K Closest Cars to the Origin (0,0) / nearby cars
 *
 * Description:
 * Given the coordinates of cars in a 2D plane, we want to find the
 * K cars that are closest to the origin (0,0). The distance is measured
 * using Euclidean distance: sqrt(x^2 + y^2). Since sqrt is monotonic,
 * we can just compare squared distances (x^2 + y^2).
 *
 * Approach:
 * - Define a custom class Points with coordinates, distance^2, and index.
 * - Use a Min-Heap (PriorityQueue) based on distSq.
 * - Insert all cars into the heap.
 * - Remove K cars (these will be the closest).
 *
 * Time Complexity:
 *  - Insertion into PQ: O(n log n)  [n = number of cars]
 *  - Extracting K cars: O(k log n)
 *  - Overall: O(n log n)
 *
 * Space Complexity:
 *  - O(n) for the priority queue.
 */
public class Heap4 {

  // Custom class to represent a car's position
  public static class Points implements Comparable<Points> {
    int x;
    int y;
    int distSq; // squared distance from origin
    int idx;    // original index of the car

    Points(int x, int y, int distSq, int idx) {
      this.x = x;
      this.y = y;
      this.distSq = distSq;
      this.idx = idx;
    }

    // Comparable to order points in ascending order of distance
    @Override
    public int compareTo(Points p2) {
      return this.distSq - p2.distSq; // min-heap based on distance
    }
  }

  /**
   * Find and print the K closest cars to the origin
   * @param arr 2D array of car coordinates
   * @param k   number of closest cars to find
   */
  public static void nearbyCar(int arr[][], int k) {
    // Min-Heap based on squared distance
    PriorityQueue<Points> pq = new PriorityQueue<>();

    // Step 1: Insert all cars into PQ with their distance^2
    for (int i = 0; i < arr.length; i++) {
      int distSq = arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1];
      pq.add(new Points(arr[i][0], arr[i][1], distSq, i));
    }

    // Step 2: Extract k closest cars
    for (int i = 0; i < k; i++) {
      System.out.println("C" + pq.remove().idx);
    }
  }

  // Driver function
  public static void main(String[] args) {
    int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
    int k = 2;

    nearbyCar(points, k);
  }
}
