package BackTracking;
 //find and print all subset of a given string
public class Backtracking2 {
  public static void findSubSet(String str,String ans, int i){
    //base case
    if(i==str.length()){
      if(str.length()==0){
        System.out.println("null");
      }else{
        System.out.println(ans);
      }
      return;
    }
    //recursion
   
    findSubSet(str, ans+str.charAt(i), i+1); //yes choice
    
    findSubSet(str, ans, i+1);//no choice
  }
  public static void main(String[] args) {
    String str = "abc";
    findSubSet(str, "", 0);  
  } 
}

//TC:- O((2^n)*n)
//SC:- O(n)

