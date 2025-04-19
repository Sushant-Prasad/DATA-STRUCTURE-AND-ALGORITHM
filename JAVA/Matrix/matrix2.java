package Matrix;
public class matrix2 {
    public static void diagonalSum(int a[][]){
      int i,sum = 0;
      for(i=0;i<a.length;i++){
        //principal diagonal
        sum += a[i][i];
          
          // condition for not addingoverlapping element
          if(i != a.length-i-1){
            //secondary diagonal
            sum+= a[i][a.length-i-1];
          }
        }
    System.out.println("sum is "+sum);
    }
    
public static void main(String args[]){
    int a[][]={{1,2,3,4},
               {5,6,7,8},
               {9,10,11,12},
               {13,14,15,16}};
    diagonalSum(a);
}
}
