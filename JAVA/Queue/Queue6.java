//Queue implementation using 2 stacks
package Queue;
import java.util.*;
public class Queue6 {
  static class Queue{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    //isEmpty
    public boolean isEmpty(){
      return s1.empty();
    }
    //add
    public void add(int data){
     //1st step
     while(!s1.isEmpty()){
      s2.push(s1.pop());
     }
     //2nd step
     s1.push(data);
     //3rd step
     while(!s2.isEmpty()){
      s1.push(s2.pop());
     }
    }
    //remove
    public int remove(){
      if(s1.isEmpty()){
        System.out.println("Queue is empty");
        return -1;
      }
      return s1.pop();
    }
    //peek
    public int peek(){
      if(s1.isEmpty()){
        System.out.println("Queue is empty");
        return -1;
      }
      return s1.peek();
    }

    
    
  }
  public static void main(String[] args) {
    Queue q = new Queue();
    q.add(5);
    q.add(10);
    q.add(13);
    q.add(20);
    q.add(25);
    while (!q.isEmpty()) {
      System.out.print(q.peek() + " ");
      q.remove();
    }
    
  }
  
}
