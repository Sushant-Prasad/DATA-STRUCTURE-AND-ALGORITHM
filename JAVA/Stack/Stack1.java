package Stack;
//stack implementation using arraylist
import java.util.*;
public class Stack1 {
  static class Stack{
  static  ArrayList<Integer> stackList = new ArrayList<>();
    public  boolean isEmpty(){
      return stackList.size()==0;
    }
    //push
    public void push(int data){
      stackList.add(data);
    }
    //pop
    public int pop(){
      if(isEmpty()){
        return -1;
      }
      int top= stackList.get(stackList.size()-1);
      stackList.remove(stackList.size()-1);
      return top;
    }
    //peek
    public  int peek(){
      if(isEmpty()){
        return -1;
      }
      return stackList.get(stackList.size()-1);
    }
    //print
    public  void display(){
      while(!isEmpty()){
        System.out.println(peek());
        pop();
      }
    }
  }
  public static void main(String[] args) {
    
    Stack s = new Stack();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    System.out.println(s.pop());
    while(!s.isEmpty()){
      System.out.println(s.peek());
      s.pop();
    }
  }

  }
  

