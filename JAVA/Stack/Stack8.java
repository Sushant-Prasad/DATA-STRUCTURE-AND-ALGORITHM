package Stack;
//valid parenthesis
//TC:- O(n)
import java.util.*;
public class Stack8 {
  public static boolean isValidParantheses(String str){
Stack<Character> s= new Stack<>();
  for(int i=0;i<str.length();i++){
    char ch=str.charAt(i);
    //opening bracket
    if(ch=='(' || ch=='[' || ch=='{' ){
      s.push(ch);
    }else{
      //closing bracket
      if(s.isEmpty()){// only closing brackets will not be pushed into
        return false; //stack and hence stack will be empty 
      }
      //check pairing 
      if((s.peek()=='(' && ch==')') 
      || (s.peek()=='{' && ch=='}') 
      || (s.peek()=='[' && ch==']')){
        s.pop();
      }else{
        return false;
      }
    } 
  }
  if(s.isEmpty()){
    return true;
  }else{
    return false;
  }
}
  public static void main(String[] args) {
    String str="({}{}[])";
    System.out.println(isValidParantheses(str));
    
  }
  
}
