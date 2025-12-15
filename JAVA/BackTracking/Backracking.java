package BackTracking;

// ============================================================================
//  TITLE:
//  Print All Permutations of a String using Backtracking
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given a string, print all possible permutations of its characters.
//  A permutation is a rearrangement of characters where order matters.
//
// ============================================================================
//  INTUITION:
//  ----------
//  For each position in the string, choose one character and
//  recursively generate permutations of the remaining characters.
//  This is a classic example of the Backtracking technique.
//
// ============================================================================
//  APPROACH (BACKTRACKING):
//  ------------------------
//  1. Maintain two strings:
//        • str → remaining characters to permute
//        • ans → current permutation being formed
//  2. Base Case:
//        • If str is empty, a complete permutation is formed.
//  3. Recursive Case:
//        • Pick each character one by one
//        • Remove it from the original string
//        • Add it to the result and recurse
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Input  : "abc"
//      Output :
//          abc
//          acb
//          bac
//          bca
//          cab
//          cba
//
// ============================================================================
//  DRY RUN:
//  --------
//      str="abc", ans=""
//      i=0 → pick 'a' → newStr="bc", ans="a"
//          i=0 → pick 'b' → newStr="c", ans="ab"
//              i=0 → pick 'c' → ans="abc" → print
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Uses backtracking (choose → explore → unchoose)
//  ✔ No extra data structures required
//  ✔ Works for any length string
//
// ============================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • substring(0, i) + substring(i+1) removes current character
//  • ans builds the permutation step-by-step
//  • Order of output depends on recursion order
//
// ============================================================================
//  TIME COMPLEXITY:
//      O(n × n!)   → n! permutations, each of length n
//
//  SPACE COMPLEXITY:
//      O(n)        → recursion stack
//
// ============================================================================
//

public class Backracking {

    // ------------------------------------------------------------------------
    // METHOD NAME: findPermutations
    // PURPOSE    : Generates and prints all permutations of a string
    // ------------------------------------------------------------------------
    public static void findPermutations(String str, String ans) {

        // Base case: if no characters are left
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Recursive case: try each character
        for (int i = 0; i < str.length(); i++) {

            char current = str.charAt(i); // current character

            // Remove the current character from string
            String newStr = str.substring(0, i) + str.substring(i + 1);

            // Recursive call with remaining string
            findPermutations(newStr, ans + current);
        }
    }

    // ------------------------------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------------------------------
    public static void main(String[] args) {

        String str = "abc";

        // Print all permutations of the string
        findPermutations(str, "");
    }
}
