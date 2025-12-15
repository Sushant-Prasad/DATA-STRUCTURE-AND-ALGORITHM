package BackTracking;

// ============================================================================
//  TITLE:
//  N-Queens Problem using Backtracking
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given an integer N, place N queens on an N×N chessboard such that
//  no two queens attack each other.
//  A queen can attack horizontally, vertically, and diagonally.
//
// ============================================================================
//  INTUITION:
//  ----------
//  • Place one queen per row.
//  • For each row, try all columns.
//  • Place a queen only if it is safe.
//  • If placement leads to a solution, print the board.
//  • Otherwise, backtrack and try another position.
//
// ============================================================================
//  APPROACH (BACKTRACKING):
//  ------------------------
//  1. Start placing queens row by row.
//  2. For each row, try all columns.
//  3. Before placing a queen, check if it is safe.
//  4. If safe, place the queen and recurse to the next row.
//  5. If no valid position exists, remove the queen (backtrack).
//
// ============================================================================
//  SAFETY CHECK CONDITIONS:
//  ------------------------
//  A queen is safe if no other queen exists:
//      • Vertically above in the same column
//      • On the upper-left diagonal
//      • On the upper-right diagonal
//
// ============================================================================
//  EXAMPLE:
//  --------
//      N = 4
//
//      One possible solution:
//      X Q X X
//      X X X Q
//      Q X X X
//      X X Q X
//
// ============================================================================
//  DRY RUN (N = 4):
//  ----------------
//      Row 0 → Place queen at (0,1)
//      Row 1 → Place queen at (1,3)
//      Row 2 → Place queen at (2,0)
//      Row 3 → Place queen at (3,2)
//      → Solution found, print board
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Uses backtracking (place → explore → remove)
//  ✔ One queen per row simplifies logic
//  ✔ Only upper directions need to be checked
//
// ============================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • Board is filled row by row (top to bottom)
//  • 'Q' represents a queen, 'X' represents empty cell
//  • Backtracking resets the board after recursive calls
//
// ============================================================================
//  TIME COMPLEXITY:
//      O(n!)   (worst case)
//
//  SPACE COMPLEXITY:
//      O(n²)   (chessboard) + O(n) recursion stack
//
// ============================================================================
//

public class Backtracking3 {

    // ------------------------------------------------------------------------
    // METHOD NAME: isSafe
    // PURPOSE    : Checks whether a queen can be placed at (row, col)
    // ------------------------------------------------------------------------
    public static boolean isSafe(int row, int col, char board[][]) {

        // Check vertically upward
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true; // safe position
    }

    // ------------------------------------------------------------------------
    // METHOD NAME: nQueens
    // PURPOSE    : Places queens on the board using backtracking
    // ------------------------------------------------------------------------
    public static void nQueens(char board[][], int row) {

        // Base case: all queens are placed
        if (row == board.length) {
            printBoard(board);
            return;
        }

        // Try placing queen in each column of current row
        for (int j = 0; j < board.length; j++) {

            if (isSafe(row, j, board)) {

                board[row][j] = 'Q';     // Place queen
                nQueens(board, row + 1); // Recursive call
                board[row][j] = 'X';     // Backtracking (remove queen)
            }
        }
    }

    // ------------------------------------------------------------------------
    // METHOD NAME: printBoard
    // PURPOSE    : Prints the chessboard
    // ------------------------------------------------------------------------
    public static void printBoard(char board[][]) {

        System.out.println("--------------- Chess Board ---------------");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------------------------------
    public static void main(String[] args) {

        int n = 4; // Size of chessboard
        char board[][] = new char[n][n];

        // Initialize board with empty cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        // Solve N-Queens problem
        nQueens(board, 0);
    }
}
