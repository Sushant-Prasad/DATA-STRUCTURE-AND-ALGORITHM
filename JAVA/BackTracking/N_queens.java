public class N_queens {
  public static boolean isSafe(int row,int col, char board[][]){
    //vertically up
    for(int i = row-1;i>=0;i--){
      if(board[i][col]=='Q'){ // bcoz col is fixed.
        return false;
      }
    }
    //left diagonally
    for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
      if(board[i][j]=='Q'){
        return false;
      }
    }
    //right diagonally
    for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
      if(board[i][j]=='Q'){
        return false;
      }
    }
    return true;

    
  }
  public static void nQueens( char board[][], int row){
    for(int j=0;j<board.length;j++){
      //base case
      if(row==board.length){
        printBoard(board);
        return ;
      }
      if(isSafe(row,j,board)){
      board[row][j]='Q'; // placing queen
      nQueens(board,row+1);//recursive call
      board[row][j]='X';//backtracking
      }

    }
  }
  public static void printBoard(char board[][]){
    System.out.println("---------------chess Board------------");
    //printing board
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board.length;j++){
        System.out.print(board[i][j]+" ");
      }
      System.out.println();
    }
  }


  public static void main(String[] args) {
    int n=4;
    char board[][]= new char[n][n];//declaration of board
    //initialization of board
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        board[i][j]='X';
      }

    }
    nQueens( board, 0);// function call
    
  }
  
}
//Tc:- O(n!)
