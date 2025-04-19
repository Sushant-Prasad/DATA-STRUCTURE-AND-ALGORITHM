//First Non-repeating letter in a stream of characters(only lowercase is allowed) 
package Queue;

import java.util.*;

public class Queue8 {
  public static void printNonRepeating(String str){
    int[] freq= new int[26];
Queue<Character> q = new LinkedList<>( );
for(int i=0;i<str.length();i++){
  char ch=str.charAt(i);
  q.add(ch);
  freq[ch-'a']++;//updating frequency of ch
  while(!q.isEmpty() && freq[q.peek()-'a']>1){ // either q is empty or freq is greater than 1
      q.remove();
  }
  if(q.isEmpty()){
    System.out.print(-1 + " "); //if there is no non repeating character
  }else{
    System.out.print(q.peek()+" ");//displaying non repeating character
  }

  }

}

  public static void main(String[] args) {
    String str = "aabccxbxz";
    printNonRepeating(str);
  }
}


