package Stack;
//reverse a string using stack
import java.util.Stack;

public class Stack5 {
   public static String reverseString(String str){
    Stack<Character> s= new Stack<>();
    //pushing all character into stack
    for(int i=0;i<str.length();i++){
      s.push(str.charAt(i));
    }
    //initalizing StringBuilder with empty string
    StringBuilder ans= new StringBuilder("");
    while(!s.isEmpty()){
      ans.append(s.pop());
    }
    return ans.toString();// converting StringBuilder to string type
  }

  public static void main(String[] args) {
    String str="abcd";
    System.out.println(reverseString(str));

    
  }
  
}
