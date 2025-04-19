package Stack;
//push at bottom of the stack
//reverse a stack
import java.util.*;
public class Stack4 {
  public static void pushAtBottom(Stack<Integer> s, int data){
    //base condition
    if(s.isEmpty()){
      s.push(data);
      return; 
    }
    //recursive call
    int top=s.pop();
    pushAtBottom(s, data);
    s.push(top);
  }
  public static void reverseStack(Stack<Integer> s){
    //base case
    if(s.isEmpty()){
      return;

    }
    //recursive call
    int top=s.pop();
    reverseStack(s);
    pushAtBottom(s, top);

  }
   public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(5);
    s.push(4);
    //pushAtBottom(s,10);
    //System.out.println(s);
    //for displaying
    reverseStack(s);
    while(!s.isEmpty()){
      System.out.println(s.pop());
    }

    
  } 
  
}
