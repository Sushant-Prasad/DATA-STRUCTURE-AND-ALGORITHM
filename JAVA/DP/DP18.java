package DP;

public class DP18 {
  public static int lcs(String s1 , String s2, int n , int m){
    if(m==0 || n==0)return 0;
    int lcs=0;
    if(s1.charAt(n-1)==s2.charAt(m-1)){
      lcs = lcs(s1, s2, n-1, m-1)+1;
    }else{
      lcs = Math.max(lcs(s1, s2, n, m-1), lcs);
    }
  }
  public static void main(String[] args) {
    String s1 = "abcdge";
    String s2 = "abedg";
    
  }
  
}
