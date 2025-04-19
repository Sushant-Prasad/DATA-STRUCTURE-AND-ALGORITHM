package Stack;
//maximum area in histogram
import java.util.*;
public class Stack10 {
  public static int maxAreaHisto(int arr[]){
    int maxArea=0;
    int NSL[]=new int[arr.length];
    int NSR[]=new int[arr.length];
    //Next smaller Left
    Stack<Integer> s=new Stack<>();
    //forward loop
    for(int i=0;i<arr.length;i++){

      while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
        s.pop();
      }
      if(s.isEmpty()){
        NSL[i]=-1;
      }else{
       NSL[i]=s.peek();
      }
      s.push(i);
    }
    //Next smaller Right
    s=new Stack<>();
    //backward loop
    for(int i=arr.length-1;i>=0;i--){

      while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
        s.pop();
      }
      if(s.isEmpty()){
        NSR[i]=arr.length;//This value is smallest so wecan cover arr.length width
      }else{
       NSR[i]=s.peek();
      }
      s.push(i);
    }
    //CURRENT AREA
    for(int i=0;i<arr.length;i++){
      int height=arr[i];
      int width=NSR[i]-NSL[i]-1;
      int currArea= height*width;
      maxArea= Math.max(maxArea, currArea);

    }
    return maxArea;
  }
  public static void main(String[] args) {
    int heights[]={2,1,5,6,2,3};// heights in histogram
    System.out.println(maxAreaHisto(heights));
    
  }
  
}
