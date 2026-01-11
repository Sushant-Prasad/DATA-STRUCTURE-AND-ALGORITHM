/*
===========================================================
TITLE
===========================================================
Reading Integers from Curly-Brace Enclosed Input (Java)

===========================================================
PROBLEM STATEMENT
===========================================================
Write a Java program to:
• Read a single line of input containing integers enclosed in
  curly braces `{ }`
• Remove the curly braces
• Extract comma-separated integers
• Store them in an ArrayList
• Print all integers in order

===========================================================
INPUT FORMAT
===========================================================
• A single line of input

Example Input:
{10,20,30}

===========================================================
OUTPUT FORMAT
===========================================================
• Print integers separated by a space

Example Output:
10 20 30

===========================================================
INTUITION
===========================================================
Some inputs may contain extra characters (like `{` and `}`)
around the actual data. These characters are not part of the
numbers and must be removed before parsing.

===========================================================
APPROACH
===========================================================
1) Read entire input line using `Scanner.nextLine()`
2) Remove `{` and `}` using regular expression
3) Split the cleaned string using comma `,`
4) Convert each token into an integer
5) Store values in an ArrayList
6) Print the ArrayList elements

===========================================================
TIME COMPLEXITY
===========================================================
O(n)
- n = number of integers in the input

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
- ArrayList stores n integers

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• `replaceAll()` uses regular expressions
• `{` and `}` must be escaped in regex
• `Integer.parseInt()` throws `NumberFormatException`
  if token is not a valid integer
• `token.trim()` can be used to handle spaces safely
===========================================================
*/

package TCS;
import java.util.*;

public class Input5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read input line (example: {10,20,30})
        String input = sc.nextLine();

        // Remove only '{' and '}' characters using regex
        input = input.replaceAll("[\\{\\}]", "");

        // Split the remaining string using comma
        String[] s = input.split(",");

        // Create ArrayList to store integers
        ArrayList<Integer> arr = new ArrayList<>();

        // Convert each token to integer and add to ArrayList
        for (String token : s) {
            arr.add(Integer.parseInt(token.trim()));
        }

        // Print all integers
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
/*
===========================================================
SPECIAL NOTES FOR REGEX WITH DIFFERENT BRACKETS
===========================================================

Regular expressions treat brackets as **special characters**.
Hence, they must be **escaped properly** when used literally.

-----------------------------------------------------------
COMMON BRACKETS AND THEIR CORRECT REGEX
-----------------------------------------------------------

1) Square Brackets  [  ]
--------------------------------
Regex:
[\\[\\]]

Example:
input = input.replaceAll("[\\[\\]]", "");

-----------------------------------------------------------
2) Curly Braces  {  }
--------------------------------
Regex:
[\\{\\}]

Example:
input = input.replaceAll("[\\{\\}]", "");

-----------------------------------------------------------
3) Parentheses  (  )
--------------------------------
Regex:
[\\(\\)]

Example:
input = input.replaceAll("[\\(\\)]", "");

-----------------------------------------------------------
4) Angle Brackets  <  >
--------------------------------
Regex:
[<>]

Example:
input = input.replaceAll("[<>]", "");

-----------------------------------------------------------
5) Multiple Brackets Together
--------------------------------
To remove {}, [], and () together:

Regex:
[\\[\\]\\{\\}\\(\\)]

Example:
input = input.replaceAll("[\\[\\]\\{\\}\\(\\)]", "");

-----------------------------------------------------------
IMPORTANT REGEX RULES
-----------------------------------------------------------

• `[]`  → Character class (match ANY ONE character inside)
• `()`  → Grouping
• `{}`  → Quantifier (must be escaped if literal)
• `\\`  → Escape character in Java strings
• Regex always runs **after Java string parsing**

-----------------------------------------------------------
ALTERNATIVE (NO REGEX – SIMPLE & SAFE)
-----------------------------------------------------------

If only a few characters need removal:

input = input.replace("{", "")
             .replace("}", "")
             .replace("[", "")
             .replace("]", "");

✔ Easier to read
✔ No regex confusion
✔ Interview-safe

-----------------------------------------------------------
KEY TAKEAWAYS
-----------------------------------------------------------

• Brackets must be escaped in regex
• Java requires double escaping (`\\`)
• Character classes remove characters individually
• Prefer `.replace()` if regex is unnecessary
===========================================================
*/
