/*
===========================================================
TITLE
===========================================================
Minimum Changes to Make String Valid (* and # Balance)

===========================================================
PROBLEM STATEMENT
===========================================================
You are given a string `S` consisting only of the characters
‘*’ and ‘#’. The length of the string is variable.

A string is considered **valid** if:
• The number of ‘*’ characters equals the number of ‘#’ characters.

Your task is to determine the **minimum number of ‘*’ or ‘#’**
required to make the string valid.

-----------------------------------------------------------
OUTPUT RULES
-----------------------------------------------------------
• If number of ‘*’ > number of ‘#’ → output a **positive integer**
• If number of ‘#’ > number of ‘*’ → output a **negative integer**
• If both are equal               → output **0**

The ‘*’ and ‘#’ can be at any position in the string.

===========================================================
PROBLEM RESOURCE (links)
===========================================================
TCS Previous Year Question (String / Counting)

===========================================================
INTUITION
===========================================================
To make the string valid, the counts of ‘*’ and ‘#’ must match.

Key idea:
• Count how many ‘*’ are present
• Count how many ‘#’ are present
• The difference between the two counts tells us:
  - How many extra characters exist
  - Which character needs to be added or removed

===========================================================
APPROACH
===========================================================
1) Read the input string.
2) Traverse the string character by character.
3) Count:
   - `countStar` → number of ‘*’
   - `countHash` → number of ‘#’
4) Compute the difference:
   result = countStar − countHash
5) Print the result directly.

===========================================================
EXAMPLE
===========================================================
Input:
S = "###***"

Count:
* = 3
# = 3

Output:
0

===========================================================
DRY RUN
===========================================================
Input: "*##*#"

Traversal:
'*' → star = 1
'#' → hash = 1
'#' → hash = 2
'*' → star = 2
'#' → hash = 3

Result:
star - hash = 2 - 3 = -1

Meaning:
1 extra '#' → need 1 '*' to balance

===========================================================
KEY POINTS
===========================================================
• Order of characters does NOT matter
• Only the count difference is important
• Output can be positive, negative, or zero
• Simple counting problem

===========================================================
TIME COMPLEXITY
===========================================================
O(n)
- Single traversal of the string

===========================================================
SPACE COMPLEXITY
===========================================================
O(1)
- Only counters are used

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Positive result → extra ‘*’
• Negative result → extra ‘#’
• Zero → already valid string
• Output must contain only the integer value
===========================================================
*/

package TCS;
import java.util.*;

public class Prev2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the input string
        String s = sc.nextLine();

        int countStar = 0; // Counts number of '*'
        int countHash = 0; // Counts number of '#'

        // Traverse the string to count characters
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '*')
                countStar++;

            if (s.charAt(i) == '#')
                countHash++;
        }

        // Print difference as per problem requirement
        // Positive → more '*'
        // Negative → more '#'
        // Zero     → balanced
        System.out.println(countStar - countHash);
    }
}
