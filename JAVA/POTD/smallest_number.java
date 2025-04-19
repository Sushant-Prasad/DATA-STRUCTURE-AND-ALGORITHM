//gfg problem link :-https://www.geeksforgeeks.org/problems/smallest-number5829/1

public class smallest_number {
  public static String smallestNumber(int s, int d) {
    StringBuilder ans = new StringBuilder();
    int digit;
    for(int i=1;i<=d;i++){
      int x=s-(d-i)*9;
      if(x<=0){
        digit = 0;//if we get any negative number then we can put 0 except first place
      }else{
        digit =s-(d-i)*9;//  ith place digit
      }
        //int num = s-(d-i)*9<=0?0:s-(d-i)*9;
        if(digit>9) return "-1";//cant place any digit or it is invalid
        if(i==1 && digit==0){
          digit=1;// we cannot put 0 in first place
        }
        ans.append((char)(digit+'0'));// typecasting digit into char and appending it tom ans
        s=s-digit;
        
    }
    return ans.toString();// converting 'ans' object as a string
}
  public static void main(String[] args) {
   String res = smallestNumber(20, 3);
   System.out.println(res);
    
    
  }
  
}