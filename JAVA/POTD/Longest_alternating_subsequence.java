package POTD;

public class Longest_alternating_subsequence {
  public static int alternatingMaxLength(int[] arr) {
    // code here
  int a=1;
  int b=1;
 for(int i=1;i<arr.length;i++){
      if(arr[i]>arr[i-1]){
        a=b+1;
       
      }
      else if(arr[i]<arr[i-1]){
        b=a+1;
      }
    
      }
  return Math.max(a,b);
}
  public static void main(String[] args) {
    int[] array ={ 1, 17, 5, 10, 13, 15, 10, 5, 16, 8,13,9};
    System.out.println(alternatingMaxLength(array));
    
  }
  
}
