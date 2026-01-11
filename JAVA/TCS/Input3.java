/*
===========================================================
TITLE
===========================================================
Reading Space-Separated Integers from a Single Line (Java)

===========================================================
PROBLEM STATEMENT
===========================================================
Write a Java program to:
• Read a single line of input containing space-separated integers
• Convert each value into an integer
• Store the integers in an ArrayList
• Print all elements in the same order

===========================================================
INPUT FORMAT
===========================================================
• A single line of input containing integers separated by spaces

Example Input:
10 20 30 40 50

===========================================================
OUTPUT FORMAT
===========================================================
• Print all integers separated by a space

Example Output:
10 20 30 40 50

===========================================================
INTUITION
===========================================================
Sometimes input is provided in a **single line** instead of
line-by-line values. In such cases:
• Read the entire line using `Scanner.nextLine()`
• Split the line based on spaces
• Convert each token into an integer
• Store values in a dynamic structure like ArrayList

===========================================================
APPROACH
===========================================================
1) Read the entire input line using `nextLine()`
2) Split the string using space delimiter `" "`
3) Convert each token to integer using `Integer.parseInt()`
4) Store integers in an ArrayList
5) Traverse and print the ArrayList

===========================================================
TIME COMPLEXITY
===========================================================
O(n)
- n = number of integers in the input line

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
- ArrayList stores n integers

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• `nextLine()` reads the full line including spaces
• `split(" ")` separates input based on spaces
• `Integer.parseInt()` converts String to int
• If input contains non-integer tokens, `NumberFormatException`
  may occur
===========================================================
*/

package TCS;
import java.util.*;

public class Input3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read entire line of space-separated integers
        String input = sc.nextLine();

        // Split the line into individual string tokens
        String[] s = input.split(" ");

        // Create ArrayList to store integers
        ArrayList<Integer> arr = new ArrayList<>();

        // Convert each token to integer and add to ArrayList
        for (String token : s) {
            arr.add(Integer.parseInt(token));
        }

        // Print all elements
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
