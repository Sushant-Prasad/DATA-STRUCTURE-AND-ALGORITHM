//Print elements in descending order using PriorityQueue
package HEAP;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ2 {
  public static void main(String[] args) {
   
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    // Adding elements to the priority queue
    pq.add(10);
    pq.add(6);
    pq.add(8);
    pq.add(2);
    pq.add(1);

    // Loop until the priority queue becomes empty
    while (!pq.isEmpty()) {
      
      System.out.println(pq.peek());


      pq.remove();
    }
  }
}
//Comparator.reverseOrder() makes the PriorityQueue behave as a Max-Heap.