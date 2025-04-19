package POTD;
public class Remaining_String{
  public static String printString(String s, char ch, int count) {
    int i=0;
    for(i=0;i<s.length();i++){
        if(s.charAt(i)==ch){
          count--;// decreasung count when we get particular charater
        }
        if(count==0){ // checked particular character 'count' times
          break;
        }
    
  }
    if(i>=s.length()-1){ // condition for absent of the particular character
      return "";
    }
    s = s.substring(i+1); // removing string
    return s;
}
  public static void main(String[] args) {
    System.out.println(printString("Thisisdemostringabcd",'i',3));
    
  }

}