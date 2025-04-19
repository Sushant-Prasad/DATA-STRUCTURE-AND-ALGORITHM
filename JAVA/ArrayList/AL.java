package ArrayList;
import java.util.*;

public class AL {
  public static void main(String[] args) {
    
    ArrayList<ArrayList<Integer>> Mainlist = new ArrayList<>();
    ArrayList<Integer> al1 = new ArrayList<>();
    ArrayList<Integer> al2 = new ArrayList<>();
    for(int i=1;i<5;i++){
      al1.add(i);
      al2.add(i*2);

    }
    Mainlist.add(al1);
    Mainlist.add(al2);
    //display 2D ArrayList
    for(int i=0;i<Mainlist.size();i++){
      ArrayList<Integer> CurrentList = Mainlist.get(i);
      for(int j=0;j<CurrentList.size();j++){
        System.out.print(CurrentList.get(j)+" ");
      }
      System.out.println();
    }
    //or we can directly display it
   System.out.println(Mainlist);
}
  
}
