//Implement Stack And Queue Using Deque

package Queue;
import java.util.*;

public class Queue11 {
  static class Stack{
    Deque<Integer> dqStack = new LinkedList<>();
    //isEmpty
    public boolean isEmpty(){
      return dqStack.isEmpty();
    }
    //push
    public void push(int data){
      dqStack.addLast(data);

    }
    //pop
    public int pop(){
      if(dqStack.isEmpty()){
        
        return-1;
      }
      return dqStack.removeLast();
    }
    //peek
    public int peek(){
      if(dqStack.isEmpty()){
        
        return-1;
      }
      return dqStack.getLast();
    }


  }
  static class Queue{
    Deque<Integer> dqQueue = new LinkedList<>();
    //isEmpty
    public boolean isEmpty(){
      return dqQueue.isEmpty();
    }
    //add
    public void add(int data){
      dqQueue.addLast(data);

    }
    //remove
    public int remove(){
      if(dqQueue.isEmpty()){
        
        return-1;
      }
      return dqQueue.removeFirst();
    }
    //peek
    public int peek(){
      if(dqQueue.isEmpty()){
        
        return-1;
      }
      return dqQueue.getFirst();
    }


  }

  public static void main(String[] args) {

    Stack s = new Stack();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    while(!s.isEmpty()){
      System.out.println(s.pop()+" ");
    }
    Queue q = new Queue();
    q.add(5);
    q.add(10);
    q.add(12);
    q.add(13);
    while(!q.isEmpty()){
      System.out.println(q.remove()+" ");
    }
    
    
  }
  
}
