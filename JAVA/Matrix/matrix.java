package Matrix;
import java.util.*;
public class matrix {
    public static void main(String args[]){
        int i,j,n,m;
        int a[][] = new int[50][50];
        System.out.println("enter row and column of array");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println("enter elements of array");
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                a[i][j] = sc.nextInt();

            }
        }
        int startRow = 0;
        int endRow =n-1;
        int startCol = 0;
        int endCol = m-1;
        while(startRow<=endRow && startCol<=endCol){
            // top printing; j is for column; startRow is constant;
            for(j=startCol;j<=endCol;j++){
                System.out.print(a[startRow][j]+" ");

            }
            //right; endColumn is constant
            for(i=startRow+1;i<=endRow;i++){
                System.out.print(a[i][endCol]+" ");
            }
            //bottom;endRow is constant;
            for(j=endCol-1;j>=startCol;j--){
               if(startRow==endRow){
                    break;
                } 
            System.out.print(a[endRow][j]+" ");
            }
            //left;starColumn is constant;
             for(i=endRow-1;i>=startRow+1;i--){
                if(startCol==endCol){
                    break;
                }
                System.out.print(a[i][startCol]+" ");
            }

         startRow++;
         endRow--;
         startCol++;
         endCol--;
        }
    
    }   
}
