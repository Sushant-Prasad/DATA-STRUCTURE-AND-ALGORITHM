package BackTracking;
// find and print all permutations of a given string
public class Backracking {
  public static void findPermutations(String str,String ans) {
    //base case
    if(str.length()==0){
      System.out.println(ans);
      return;
    }
    //recursion
    for(int i=0;i<str.length();i++){
      char current = str.charAt(i); // current character
      //removing current character
      String newStr = str.substring(0, i) + str.substring(i+1);
    
    findPermutations(newStr , ans+current);// adding current key to newStr
  }
    
  }
  public static void main(String[] args) {
    String str = "abc";
    findPermutations(str, "");
  }
  
}
//TC:- O(n*n!)
//SC:-O(n)

