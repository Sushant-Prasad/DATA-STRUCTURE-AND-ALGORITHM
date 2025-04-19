package Stack;
//stack implementation using stack collection framework
import java.util.*;
public class Stack3 {
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(5);
    s.push(4);
    //System.out.println(s.pop());
    while(!s.isEmpty()){
      System.out.println(s.peek());
      s.pop();
    }
    
  }

    
  }
  

