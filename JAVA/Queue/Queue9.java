//interleave 2 halves of a queue(even length)
package Queue;
import java.util.*;

public class Queue9 {
  public static  void printInterleave(Queue<Integer> qOriginal){
    Queue<Integer> q2 = new LinkedList<>();// 2nd Queue for storing 1st half of original queue
    int n = qOriginal.size();
    for(int i=0;i<n/2;i++){
      q2.add(qOriginal.remove());
    }
    while(!q2.isEmpty()){
      qOriginal.add(q2.remove());
      qOriginal.add(qOriginal.remove());

    }
    //return qOriginal;
  }
  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>();// given queue
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
    printInterleave(q);
    while(!q.isEmpty()){
      System.out.print(q.remove()+" ");
    }
    
  }
  
}
