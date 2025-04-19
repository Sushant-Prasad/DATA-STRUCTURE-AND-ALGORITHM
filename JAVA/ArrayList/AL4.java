package ArrayList;
//pair sum-2
//find if any pair of given sorted and rotated AL has a target sum

import java.util.ArrayList;

public class AL4 {
  public static boolean pairSum2(ArrayList<Integer> list,int target){
    int n=list.size();
    int bp=-1;// breaking point
    for(int i=0;i<n-1;i++){
      if(list.get(i)>list.get(i+1)){
        bp=i;
        break;
      }
    }
    int left=bp+1;
    int right=bp;
    while(left!=right){
      if(list.get(left)+list.get(right)==target)return true;
      if(list.get(left)+list.get(right)<target){
      left=(left + 1)%n;// bcoz array is rotated
    }
      else{
        right=(n+right-1)%n;// bcoz array is rotated
      }
    }
    return false;
  }
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(13);
    list.add(15);
    list.add(20);
    list.add(7);
    list.add(9);
    list.add(11);
    int target=29;
    System.out.println(pairSum2(list, target));
  }
}
