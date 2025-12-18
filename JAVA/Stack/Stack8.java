package Stack;

import java.util.*;

// =========================================================================
//  TITLE:
//  Valid Parentheses using Stack
// =========================================================================
//
//  PROBLEM STATEMENT:
//  ------------------
//  Given a string containing characters '(', ')', '{', '}', '[' and ']',
//  determine if the input string is valid.
//
//  A string is valid if:
//  • Open brackets are closed by the same type of brackets.
//  • Open brackets are closed in the correct order.
//  • Every closing bracket has a corresponding opening bracket.
//
// =========================================================================
//  INTUITION:
//  ----------
//  • Parentheses follow the LIFO (Last In First Out) property.
//  • Stack is the best data structure to handle such problems.
//  • Opening brackets are stored and matched when a closing bracket appears.
//
// =========================================================================
//  APPROACH:
//  ----------
//  1. Create an empty stack of characters.
//  2. Traverse each character in the string:
//      • If opening bracket → push into stack.
//      • If closing bracket:
//          - If stack is empty → invalid.
//          - Check if top of stack matches the closing bracket.
//          - If yes → pop.
//          - Else → invalid.
//  3. After traversal:
//      • If stack is empty → valid parentheses.
//      • Else → invalid.
//
// =========================================================================
//  SPECIAL NOTES FOR LOGIC:
//  ------------------------
//  • Closing brackets are NEVER pushed into the stack.
//  • Stack empty + closing bracket → invalid immediately.
//  • Pair matching is done using peek() before pop().
//  • Final stack must be empty for a valid string.
//
// =========================================================================
//  EXAMPLE:
//  --------
//  Input: "({}{}[])"
//
// =========================================================================
//  DRY RUN:
//  --------
//  String: "({}{}[])"
//
//  Step | Character | Stack State
//  --------------------------------
//    1  | '('       | (
//    2  | '{'       | ( {
//    3  | '}'       | (
//    4  | '{'       | ( {
//    5  | '}'       | (
//    6  | '['       | ( [
//    7  | ']'       | (
//    8  | ')'       | empty
//
//  Stack empty at end → VALID
//
// =========================================================================
//  KEY POINTS:
//  ------------
//  ✔ Stack handles nested structures naturally
//  ✔ One pass solution
//  ✔ Immediate rejection on mismatch
//  ✔ Works for all bracket types
//
// =========================================================================
//  TIME COMPLEXITY:
//      O(n)  → n is the length of the string
//
//  SPACE COMPLEXITY:
//      O(n)  → stack can hold at most n characters
//
// =========================================================================

public class Stack8 {

    public static boolean isValidParantheses(String str) {

        Stack<Character> s = new Stack<>();

        // Traverse each character of the string
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // ---------------------------------------------------------
            // If opening bracket → push into stack
            // ---------------------------------------------------------
            if (ch == '(' || ch == '[' || ch == '{') {
                s.push(ch);
            }
            // ---------------------------------------------------------
            // If closing bracket
            // ---------------------------------------------------------
            else {

                // If stack is empty, no matching opening bracket exists
                if (s.isEmpty()) {
                    return false;
                }

                // Check if top of stack matches the closing bracket
                if ((s.peek() == '(' && ch == ')') ||
                    (s.peek() == '{' && ch == '}') ||
                    (s.peek() == '[' && ch == ']')) {

                    s.pop(); // matched pair → remove opening bracket
                }
                else {
                    return false; // mismatch
                }
            }
        }

        // If stack is empty, all brackets matched correctly
        return s.isEmpty();
    }

    // =========================================================================
    //  MAIN METHOD
    // =========================================================================
    public static void main(String[] args) {

        String str = "({}{}[])";

        System.out.println(isValidParantheses(str));
    }
}
