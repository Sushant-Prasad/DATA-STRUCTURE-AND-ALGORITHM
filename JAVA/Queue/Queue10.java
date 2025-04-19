//Queue reversal
package Queue;

import java.util.*;

public class Queue10 {
  public static void queueReversal(Queue<Integer> q) {
     Stack<Integer> s = new Stack<>();
     if(q.isEmpty()){
      System.out.println("Empty");
      return;
    }
    //Queue to stack
      while(!q.isEmpty()){
         s.push(q.remove());
    }
    //Stack to Queue
    while(!s.isEmpty()){
      q.add(s.pop());
    }



  }

  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);
    q.add(6);
    q.add(7);
    q.add(8);
    q.add(9);
    q.add(10);
    queueReversal(q);
    while (!q.isEmpty()) {
      System.out.print(q.remove() + " ");
    }

  }

}
