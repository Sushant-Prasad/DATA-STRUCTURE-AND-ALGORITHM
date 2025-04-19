package Queue;

import java.util.*;

public class Queue5 {
  public static void main(String[] args) {
  Queue<Integer> q = new LinkedList<>();// we cant create object of Queue bcoz Queue is an interface
    //Another way to create Queue
    //Queue<Integer> q = new ArrayDeque<>(); 

    q.add(5);                           
    q.add(10);
    q.add(18);
    q.add(20);
    q.add(25);
    while (!q.isEmpty()) {
      System.out.print(q.peek() + " ");
      q.remove();
    }
    
   

  }
  
}
