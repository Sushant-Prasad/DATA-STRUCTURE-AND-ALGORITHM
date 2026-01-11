/*
===========================================================
TITLE
===========================================================
Reading Comma-Separated Integers from a Single Line (Java)

===========================================================
PROBLEM STATEMENT
===========================================================
Write a Java program to:
• Read a single line of input containing **comma-separated integers**
• Convert each value into an integer
• Store the integers in an ArrayList
• Print all elements in the same order

===========================================================
INPUT FORMAT
===========================================================
• A single line of input containing integers separated by commas

Example Input:
10,20,30,40,50

===========================================================
OUTPUT FORMAT
===========================================================
• Print all integers separated by a space

Example Output:
10 20 30 40 50

===========================================================
INTUITION
===========================================================
In some problems, input values are provided in a **comma-separated**
format instead of space-separated.

To handle this:
• Read the entire line using `Scanner.nextLine()`
• Split the string using comma `","` as delimiter
• Convert each token into an integer
• Store values in a dynamic data structure (ArrayList)

===========================================================
APPROACH
===========================================================
1) Read the entire input line using `nextLine()`
2) Split the string using `","` delimiter
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
• `nextLine()` reads the complete input line
• `split(",")` separates values based on commas
• If input contains spaces like "10, 20, 30",
  trimming may be required using `token.trim()`
• `Integer.parseInt()` throws `NumberFormatException`
  if a token is not a valid integer
===========================================================
*/

package TCS;
import java.util.*;

public class Input4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read entire line of comma-separated integers
        String input = sc.nextLine();

        // Split input string using comma as delimiter
        String[] s = input.split(",");

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
