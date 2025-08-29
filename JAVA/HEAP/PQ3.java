package HEAP;

import java.util.PriorityQueue;

/**
 * Title: Implement Priority Queue with Custom Class (Student)
 * 
 * Description:
 * This program demonstrates how to use Java's PriorityQueue with a custom class.
 * The Student class stores a student's name and rank, and implements Comparable 
 * so that the priority queue can order students automatically based on rank.
 * 
 * By default, the queue behaves like a Min-Heap (smallest rank = highest priority).
 */
public class PQ3 {

  // Student class implements Comparable so that PriorityQueue knows how to order objects
  public static class Student implements Comparable<Student> {
    String name;
    int rank;

    // Constructor
    Student(String name, int rank) {
      this.name = name;
      this.rank = rank;
    }

    // compareTo defines ordering: ascending order of rank (min-heap behavior)
   @Override
public int compareTo(Student s2) {
  // Comparison rule for PriorityQueue ordering:
  // If this.rank < s2.rank → returns negative → this comes before s2
  // If this.rank > s2.rank → returns positive → this comes after s2
  // If equal → returns 0 → both are considered equal in ordering
  // 
  // Since we are doing (this.rank - s2.rank), students will be ordered
  // in ASCENDING order of rank (Min-Heap behavior).
  return this.rank - s2.rank;
}


  public static void main(String[] args) {
    // Create a PriorityQueue of Student objects (min-heap by rank)
    PriorityQueue<Student> pq = new PriorityQueue<>();

    // Add Student objects to the queue
    pq.add(new Student("a", 50));
    pq.add(new Student("b", 10));
    pq.add(new Student("c", 7));
    pq.add(new Student("d", 60));
    pq.add(new Student("e", 55));

    // Remove and print students in ascending order of rank
    while (!pq.isEmpty()) {
      // peek() -> returns the student with the smallest rank (highest priority)
      System.out.println(pq.peek().name + " -> " + pq.peek().rank);

      // remove() -> removes the student with the smallest rank
      pq.remove();
    }
  }
}
