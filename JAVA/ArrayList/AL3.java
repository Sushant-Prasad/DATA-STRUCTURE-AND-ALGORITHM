package ArrayList;
//pair sum-1
//find if any pair of given sorted AL has a target sum
//------------BRUTE FORCE------------
//TC:-O(N)
import java.util.*;
public class AL3 {
  //------------BRUTE FORCE------------
//TC:-O(N*N)
  // public static boolean pairSum(ArrayList<Integer> list,int target){
  //   int n= list.size();
  //   for(int i=0;i<n;i++){
  //     for(int j=i+1;j<n;j++){
  //       if(list.get(i)+list.get(j)==target)return true;
  //     }
  //   }
  //   return false;

  // }
//--------------OPTIMIZED CODE-----------
  //2 pointer approach
  //TC:-O(N)
  public static boolean pairSum(ArrayList<Integer> list,int target){
    int left=0;
    int right= list.size()-1;
    while(left<right){
      if(list.get(left)+list.get(right)==target)return true;
      if(list.get(left)+list.get(right)<target){
      left++;}
      else{
        right--;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(4);
    list.add(7);
    list.add(9);
    list.add(11);
    int target=118;
    System.out.println(pairSum(list, target));
  }
  
}
