package HEAP;

import java.util.PriorityQueue;

/**
 * Title: K Weakest Rows in a Matrix / Weakest Soldier
 *
 * Problem:
 * Given a binary matrix where:
 *  - 1 represents a soldier
 *  - 0 represents a civilian
 * Soldiers are always placed before civilians in each row (row is sorted).
 * The "strength" of a row = number of soldiers in that row.
 *
 * Task:
 * Find the indices of the k weakest rows in the matrix, where:
 *  - A row is weaker if it has fewer soldiers
 *  - If two rows have the same number of soldiers, the row with the smaller index is weaker
 *
 * Approach:
 * - Step 1: For each row, count the number of soldiers.
 * - Step 2: Store (soldierCount, rowIndex) in a Min-Heap (PriorityQueue).
 * - Step 3: Extract k rows from the heap → those will be the k weakest rows.
 *
 * Time Complexity:
 *  - Counting soldiers: O(n * m)  (n = rows, m = cols)
 *  - Inserting into heap: O(n log n)
 *  - Removing k elements: O(k log n)
 *  - Total: O(n*m + n log n)
 *
 * Space Complexity: O(n) for the heap
 */
public class Heap6 {
  
  // Helper class to represent a row with soldier count and index
  public static class Row implements Comparable<Row> {
    int SoldierCount;
    int idx;

    Row(int SoldierCount, int idx) {
      this.SoldierCount = SoldierCount;
      this.idx = idx;
    }

    // Comparison rule for PriorityQueue:
    // 1. Row with fewer soldiers comes first
    // 2. If equal, row with smaller index comes first
    @Override
    public int compareTo(Row r2) {
      if (this.SoldierCount == r2.SoldierCount) {
        return this.idx - r2.idx;
      }
      return this.SoldierCount - r2.SoldierCount;
    }
  }

  /**
   * Function to find and print the indices of the k weakest rows
   */
  public static void weakestSoldier(int arr[][], int k) {
    // Min-Heap (based on soldier count, then row index)
    PriorityQueue<Row> pq = new PriorityQueue<>();

    // Step 1: Count soldiers in each row and push to heap
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
        { 1, 0, 0, 0 },
        { 1, 1, 1, 1 },
        { 1, 0, 0, 0 },
        { 1, 0, 0, 0 }
    };
    int k = 2;
    weakestSoldier(arr, k);
  }
}
