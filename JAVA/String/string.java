package String;

import java.util.*;

public class string {

    // =========================================================================
    //  TITLE:
    //  Check Whether a String is a Palindrome
    // =========================================================================
    //
    //  PROBLEM STATEMENT:
    //  ------------------
    //  Given a string, determine whether it is a palindrome.
    //
    //  A palindrome is a string that reads the same
    //  forwards and backwards.
    //
    // =========================================================================
    //  INTUITION:
    //  ----------
    //  • If a string is a palindrome, the first character must match
    //    the last character, the second must match the second last, and so on.
    //  • Therefore, we only need to compare characters from both ends
    //    moving toward the center.
    //
    // =========================================================================
    //  APPROACH:
    //  ----------
    //  1. Loop from index 0 to (length / 2).
    //  2. Compare:
    //        str.charAt(i) 
    //        with
    //        str.charAt(length - 1 - i)
    //  3. If any mismatch is found, the string is NOT a palindrome.
    //  4. If no mismatches are found, the string IS a palindrome.
    //
    // =========================================================================
    //  SPECIAL NOTES FOR LOGIC:
    //  ------------------------
    //  • We loop only till str.length()/2 because:
    //      - After the midpoint, comparisons repeat.
    //  • `flag` is used as an indicator:
    //      - flag = 0 → Palindrome
    //      - flag = 1 → Not Palindrome
    //
    // =========================================================================
    //  TIME COMPLEXITY:
    //      O(n)
    //
    //  SPACE COMPLEXITY:
    //      O(1)
    //
    // =========================================================================
    public static void isPalindrome(String str) {

        int flag = 0;  // Flag to detect mismatch

        // Compare characters from start and end
        for (int i = 0; i < str.length() / 2; i++) {

            // If characters do not match
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                flag = 1;
                break;   // No need to check further
            }
        }

        // Print result based on flag
        if (flag == 1) {
            System.out.println("Not Palindrome");
        } else {
            System.out.println("Palindrome");
        }
    }

    // =========================================================================
    //  MAIN METHOD
    // =========================================================================
    //  • Takes string input from user
    //  • Calls isPalindrome() to check result
    // =========================================================================
    public static void main(String args[]) {

        String str;

        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.println("Enter a string:");
        str = sc.nextLine();

        // Check palindrome
        isPalindrome(str);
    }
}
