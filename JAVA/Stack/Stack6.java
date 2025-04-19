package Stack;
//Stock span problem
import java.util.*;
public class Stack6 {
  public static void stockspan(int[] stock,int[] span){
    Stack<Integer> s= new Stack<>();
    span[0]=1;// always will be 1.
    s.push(0);
    //calc for previous high price
    for(int i=1;i<stock.length;i++){
     int  currPrice=stock[i];
     while(!s.isEmpty() && currPrice>stock[s.peek()]){
      s.pop();
     }
     if(s.isEmpty()){
      span[i]=i+1;// cuurPrice is highest or equal to the highest
     }else{
      span[i]= i - s.peek();// s.peek() is previous high price of stock
     }
     s.push(i);
    }
   
  }
  public static void main(String[] args) {
    int[] stock={100,80,60,70,60,85,100};
    int[] span = new int[stock.length];
    stockspan(stock,span);
    //print span
    for(int i =0;i<span.length;i++){
      System.out.println(span[i]+" ");
    }
  }
  
}
