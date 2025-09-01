package HEAP;

import java.util.PriorityQueue;

/**
 * Title: K Weakest Rows in a Matrix (using Comparator in PriorityQueue)
 *
 * Problem:
 * You are given a binary matrix where:
 *  - 1 represents a soldier
 *  - 0 represents a civilian
 * Soldiers are always positioned before civilians in each row (row is sorted).
 * 
 * Strength of a row = number of soldiers in that row.
 * Task: Find the indices of the k weakest rows, where:
 *  - A row is weaker if it has fewer soldiers.
 *  - If two rows have the same number of soldiers, the row with the smaller index is weaker.
 *
 * Approach:
 * - Step 1: For each row, count the number of soldiers (number of 1s).
 * - Step 2: Use a Min-Heap (PriorityQueue) with a custom Comparator:
 *       Comparator rule:
 *         1. Row with fewer soldiers comes first.
 *         2. If equal, row with smaller index comes first.
 * - Step 3: Insert (soldierCount, rowIndex) into heap.
 * - Step 4: Extract k rows from the heap → these are the k weakest rows.
 *
 * Time Complexity:
 *  - Counting soldiers: O(n * m)   (n = rows, m = cols)
 *  - Heap operations: O(n log n)
 *  - Extracting k rows: O(k log n)
 *  - Overall: O(n*m + n log n)
 *
 * Space Complexity: O(n) for the heap
 */
public class Heap6Comparator {

  // Helper class representing a row with its soldier count and index
  public static class Row {
    int SoldierCount; // number of soldiers in the row
    int idx;          // index of the row

    Row(int SoldierCount, int idx) {
      this.SoldierCount = SoldierCount;
      this.idx = idx;
    }
  }

  // Function to find k weakest rows
  public static void weakestSoldier(int arr[][], int k) {
    // Min-Heap with custom Comparator
    // Comparator logic:
    // 1. Compare by soldier count
    // 2. If equal, compare by row index
    PriorityQueue<Row> pq = new PriorityQueue<>(
      (a, b) -> {
        if (a.SoldierCount == b.SoldierCount) {
          return a.idx - b.idx; // tie → smaller index first
        }
        return a.SoldierCount - b.SoldierCount; // fewer soldiers → weaker row
      }
    );

    // Step 1: Count soldiers in each row and add to heap
    for (int i = 0; i < arr.length; i++) {
      int soldier = 0;
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == 1)
          soldier++;
      }
      pq.add(new Row(soldier, i));
    }

    // Step 2: Extract k weakest rows
    System.out.println(k + " Weakest Rows:");
    for (int i = 0; i < k; i++) {
      System.out.println("Row-" + pq.remove().idx);
    }
  }

  // Driver code
  public static void main(String[] args) {
    int arr[][] = {
        { 1, 0, 0, 0 },  // Row 0 → 1 soldier
        { 1, 1, 1, 1 },  // Row 1 → 4 soldiers
        { 1, 0, 0, 0 },  // Row 2 → 1 soldier
        { 1, 0, 0, 0 }   // Row 3 → 1 soldier
    };
    int k = 2;

    weakestSoldier(arr, k);
  }
}
