package Stack;
//Next greater element
//TC:- O(n)
import java.util.*;
public class Stack7 {
  public static void nextGreater(int arr[]){
    int[] nextGreaterarr = new int[arr.length];
    Stack<Integer> s=new Stack<>();
    //backward loop
     for(int i=arr.length-1;i>=0;i--){

      while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
        s.pop();
      }
      if(s.isEmpty()){
        nextGreaterarr[i]=-1;// no greater element is avialable
      }else{
        nextGreaterarr[i]=arr[s.peek()];
      }
      s.push(i);
    }
    //for displaying 
    for(int i=0;i<nextGreaterarr.length;i++){
      System.out.print(nextGreaterarr[i]+" ");
    }
  }
  public static void main(String[] args) {
    int[] arr={10,8,11,12,16,0,1,3};
    nextGreater(arr);
    }
  }
