//Stack implementation using 2 Queues
package Queue;

import java.util.*;

public class Queue7 {
  public static class Stack{
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    //isEmpty
    public boolean isEmpty(){
      return q1.isEmpty() && q2.isEmpty();
    }
    //add
    public void push(int data){
      if(!q1.isEmpty()){
        q1.add(data);
      }else{
        q2.add(data);

      }
    }
    //remove
    public int pop(){ //condition for queue are empty
      if(isEmpty()){
        System.out.println("empty");
        return -1;   
      }
      int top=-1;
      if(!q1.isEmpty()){
      while(!q1.isEmpty()){
        top=q1.remove();
        if(q1.isEmpty()){
          break;
        }
        q2.add(top); // adding top until q1 is empty
      }
    }else{
      while(!q2.isEmpty()){
        top=q2.remove();
        if(q2.isEmpty()){
          break;
        }
        q1.add(top);
      }
    }
      return top;
    }
    //peek
    public int peek(){
      if(isEmpty()){
        System.out.println("empty");
        return -1;   
      }
      int top=-1;
      if(!q1.isEmpty()){
      while(!q1.isEmpty()){
        top=q1.remove();
        q2.add(top); // adding top until q1 is empty
      }
    }else{
      while(!q2.isEmpty()){
        top=q2.remove();
        q1.add(top);
      }
    }
      return top;
    }
  }
  
  public static void main(String[] args) {
    Stack s1 = new Stack();
    s1.push(10);
    s1.push(15);
    s1.push(20);

    while(!s1.isEmpty()){
      System.out.println(s1.pop()+" ");
      
    }
  }
  
}
