/*
===========================================================
TITLE
===========================================================
Array Input and Output Using Scanner (Java)

===========================================================
PROBLEM STATEMENT
===========================================================
Write a Java program to:
• Read an integer `n` representing the size of an array
• Read `n` integers as elements of the array
• Print all the array elements in the same order

===========================================================
INPUT FORMAT
===========================================================
• First input  → Integer `n` (size of the array)
• Next `n` inputs → Integer elements of the array

===========================================================
OUTPUT FORMAT
===========================================================
• Print all array elements separated by a space

===========================================================
EXAMPLE
===========================================================
Input:
5
10 20 30 40 50

Output:
10 20 30 40 50

===========================================================
INTUITION
===========================================================
To work with arrays in Java:
• We first need the size of the array
• Then read elements one by one using a loop
• Finally, traverse the array to display its contents

===========================================================
APPROACH
===========================================================
1) Read integer `n`
2) Create an integer array of size `n`
3) Use a loop to read `n` integers into the array
4) Use another loop to print the elements

===========================================================
TIME COMPLEXITY
===========================================================
O(n)
- One loop to read elements
- One loop to print elements

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
- Space used to store the array

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Scanner is used for input handling
• Array indexing starts from 0
• Output formatting uses space separation
===========================================================
SPECIAL NOTES FOR INPUT USING SCANNER.nextInt()
===========================================================

• `nextInt()` is used **only** to read integer values.
• If the input contains any other data type (like float, double,
  or string), `nextInt()` will throw an **InputMismatchException**.

-----------------------------------------------------------
COMMON Scanner METHODS FOR DIFFERENT DATA TYPES
-----------------------------------------------------------

• nextInt()       → Reads an integer (int)
• nextLong()      → Reads a long integer (long)
• nextFloat()     → Reads a floating-point number (float)
• nextDouble()    → Reads a double-precision number (double)
• next()          → Reads a single word (String without spaces)
• nextLine()      → Reads an entire line (String with spaces)
• nextBoolean()   → Reads a boolean value (true/false)

-----------------------------------------------------------
IMPORTANT BEHAVIOR DIFFERENCES
-----------------------------------------------------------

1) `nextInt()` vs `nextLine()`
--------------------------------
• `nextInt()` reads only the number and leaves the newline (`\n`)
  in the input buffer.
• A subsequent `nextLine()` may read this leftover newline and
  return an empty string.

✔ Solution:
  After `nextInt()`, use:
  sc.nextLine(); // to consume the leftover newline

-----------------------------------------------------------
2) Handling Mixed Data Types
-----------------------------------------------------------

Example:
int x = sc.nextInt();
double y = sc.nextDouble();
String s = sc.nextLine();  // may read empty line ❌

✔ Correct way:
int x = sc.nextInt();
double y = sc.nextDouble();
sc.nextLine();             // clear buffer
String s = sc.nextLine();  // reads actual string

-----------------------------------------------------------
3) Checking Input Type Safely
-----------------------------------------------------------

• Use `hasNextInt()` to avoid runtime exceptions:

if (sc.hasNextInt()) {
    int x = sc.nextInt();
}

-----------------------------------------------------------
KEY TAKEAWAYS
-----------------------------------------------------------

• Use the correct Scanner method for each data type
• Be careful when mixing `nextInt()` with `nextLine()`
• Always clear the buffer when switching from numeric input
  to string input
• For competitive programming, Scanner is convenient but slower;
  for large input, prefer BufferedReader

===========================================================
*/


package TCS;

import java.util.*;

public class Input {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read size of the array
        int n = sc.nextInt();

        // Declare array of size n
        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Print array elements
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
