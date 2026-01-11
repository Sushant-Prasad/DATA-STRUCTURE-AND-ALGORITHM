/*
===========================================================
TITLE
===========================================================
Handling Scanner Input: nextInt() followed by nextLine()

===========================================================
PROBLEM STATEMENT
===========================================================
Write a Java program that:
• Reads an integer input
• Then reads a full line string input
• Prints both values correctly

This program demonstrates how to properly handle input
when mixing `nextInt()` and `nextLine()` using `Scanner`.

===========================================================
INPUT FORMAT
===========================================================
• First input  → An integer value
• Second input → A full line string (may contain spaces)

Example Input:
5
Hello World

===========================================================
OUTPUT FORMAT
===========================================================
• Print integer and string separated by a space

Example Output:
5 Hello World

===========================================================
INTUITION
===========================================================
The `Scanner.nextInt()` method reads only the integer value
and leaves the newline character (`\n`) in the input buffer.

If `nextLine()` is called immediately after `nextInt()`,
it reads this leftover newline instead of the actual string.

To avoid this issue, we must explicitly consume the newline.

===========================================================
APPROACH
===========================================================
1) Read integer using `nextInt()`
2) Call `nextLine()` once to consume the leftover newline
3) Read the actual string using `nextLine()`
4) Print both values

===========================================================
TIME COMPLEXITY
===========================================================
O(1)
- Constant time input operations

===========================================================
SPACE COMPLEXITY
===========================================================
O(1)
- Only primitive variables used

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• `nextInt()` does NOT consume newline (`\n`)
• `nextLine()` reads until newline
• Always add an extra `nextLine()` after numeric input
  if a string input follows
• This is a very common bug in Java input handling
===========================================================
*/

package TCS;

import java.util.Scanner;

public class Input6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read integer input
        int n = sc.nextInt();

        // Consume the leftover newline character
        sc.nextLine();

        // Read full line string input
        String s = sc.nextLine();

        // Print both values
        System.out.println(n + " " + s);
    }
}
