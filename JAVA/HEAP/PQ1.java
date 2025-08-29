//Implementing Priority Queue
package HEAP;


import java.util.PriorityQueue;

public class PQ1 {
  public static void main(String[] args) {
    // PriorityQueue in Java implements a Min-Heap by default.
    // That means the smallest element always comes at the head of the queue.
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    // Adding elements to the priority queue
    pq.add(10);
    pq.add(6);
    pq.add(8);
    pq.add(2);
    pq.add(1);

    // Loop until the priority queue becomes empty
    while (!pq.isEmpty()) {
      // peek() -> returns the smallest element (head of the queue) without removing it
      System.out.println(pq.peek());

      // remove() -> deletes the head element (same as poll())
      pq.remove();
    }
  }
}
