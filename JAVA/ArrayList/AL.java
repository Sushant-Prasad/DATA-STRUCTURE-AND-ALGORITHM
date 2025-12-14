package ArrayList;
import java.util.*;

public class AL {
  public static void main(String[] args) {

    /*
     * -----------------------------------------------------------
     *  CREATE A 2D ARRAYLIST (ArrayList of ArrayLists)
     * -----------------------------------------------------------
     *  Mainlist → stores multiple ArrayLists
     *  al1, al2  → represent rows inside the 2D structure
     */
    ArrayList<ArrayList<Integer>> Mainlist = new ArrayList<>();
    ArrayList<Integer> al1 = new ArrayList<>();
    ArrayList<Integer> al2 = new ArrayList<>();


    /*
     * -----------------------------------------------------------
     *  FILL THE INNER LISTS
     * -----------------------------------------------------------
     *  al1 → [1, 2, 3, 4]
     *  al2 → [2, 4, 6, 8]
     */
    for (int i = 1; i < 5; i++) {
      al1.add(i);         // Add i
      al2.add(i * 2);     // Add i * 2
    }


    /*
     * -----------------------------------------------------------
     *  ADD INNER LISTS TO MAIN LIST
     * -----------------------------------------------------------
     *  Mainlist = [ [1,2,3,4], [2,4,6,8] ]
     */
    Mainlist.add(al1);
    Mainlist.add(al2);


    /*
     * -----------------------------------------------------------
     *  PRINT 2D ARRAYLIST USING NESTED LOOPS
     * -----------------------------------------------------------
     *  We access:
     *      - Each row  → Mainlist.get(i)
     *      - Each element of that row → CurrentList.get(j)
     */
    for (int i = 0; i < Mainlist.size(); i++) {
      ArrayList<Integer> CurrentList = Mainlist.get(i);

      for (int j = 0; j < CurrentList.size(); j++) {
        System.out.print(CurrentList.get(j) + " ");
      }
      System.out.println();
    }


    /*
     * -----------------------------------------------------------
     *  ALTERNATIVE: DIRECTLY PRINT THE WHOLE 2D LIST
     * -----------------------------------------------------------
     *  Java's ArrayList toString() prints nested lists naturally:
     *      [[1, 2, 3, 4], [2, 4, 6, 8]]
     */
    System.out.println(Mainlist);
  }
}
