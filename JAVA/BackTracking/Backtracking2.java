package BackTracking;

// ============================================================================
//  TITLE:
//  Print All Subsets of a String using Backtracking
// ============================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given a string, print all possible subsets (power set) of its characters.
//  A subset may contain zero or more characters, and order is preserved.
//
// ============================================================================
//  INTUITION:
//  ----------
//  For every character, we have two choices:
//      1. Include the character
//      2. Exclude the character
//  Exploring both choices recursively generates all subsets.
//
// ============================================================================
//  APPROACH (BACKTRACKING):
//  ------------------------
//  1. Traverse the string character by character.
//  2. At each index, make two recursive calls:
//        • Include the current character in the subset
//        • Exclude the current character from the subset
//  3. When the index reaches the end of the string,
//     print the formed subset.
//
// ============================================================================
//  EXAMPLE:
//  --------
//      Input  : "abc"
//      Output :
//          abc
//          ab
//          ac
//          a
//          bc
//          b
//          c
//          null
//
// ============================================================================
//  DRY RUN:
//  --------
//      str="abc", ans="", i=0
//
//      Include 'a' → ans="a"
//          Include 'b' → ans="ab"
//              Include 'c' → ans="abc" → print
//              Exclude 'c' → ans="ab"  → print
//          Exclude 'b' → ans="a"
//              Include 'c' → ans="ac"  → print
//              Exclude 'c' → ans="a"   → print
//      Exclude 'a' → ans=""
//          Include 'b' → ans="b"
//              Include 'c' → ans="bc"  → print
//              Exclude 'c' → ans="b"   → print
//          Exclude 'b' → ans=""
//              Include 'c' → ans="c"   → print
//              Exclude 'c' → ans=""    → print "null"
//
// ============================================================================
//  KEY POINTS:
//  ------------
//  ✔ Total subsets = 2ⁿ
//  ✔ Uses include/exclude recursion
//  ✔ Order of characters is preserved
//
// ============================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • Empty subset is printed as "null"
//  • Index `i` controls recursion depth
//  • ans builds subset incrementally
//
// ============================================================================
//  TIME COMPLEXITY:
//      O(2ⁿ × n)
//
//  SPACE COMPLEXITY:
//      O(n)   (recursion stack)
//
// ============================================================================
//

public class Backtracking2 {

    // ------------------------------------------------------------------------
    // METHOD NAME: findSubSet
    // PURPOSE    : Generates and prints all subsets of a string
    // ------------------------------------------------------------------------
    public static void findSubSet(String str, String ans, int i) {

        // Base case: reached end of string
        if (i == str.length()) {

            // Print empty subset as "null"
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        // Recursive case:

        // Choice 1: Include current character
        findSubSet(str, ans + str.charAt(i), i + 1);

        // Choice 2: Exclude current character
        findSubSet(str, ans, i + 1);
    }

    // ------------------------------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------------------------------
    public static void main(String[] args) {

        String str = "abc";

        // Print all subsets of the string
        findSubSet(str, "", 0);
    }
}
