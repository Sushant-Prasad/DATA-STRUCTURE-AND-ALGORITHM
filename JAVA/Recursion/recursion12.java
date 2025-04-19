package Recursion;
public class recursion12 {
    public static int tiling(int n){
        if(n==0 || n==1){//base case
            return 1;
        }
        int verticalTiles = tiling( n - 1); // for vetical choice
         int  horizontalTiles = tiling( n - 2);// for horizontal choice
         int totalWays =  verticalTiles + horizontalTiles;
         return totalWays;

    }
     public static void main(String args[]){
        int n = 3;
    System.out.println(tiling(n));
    }
    
    
}
