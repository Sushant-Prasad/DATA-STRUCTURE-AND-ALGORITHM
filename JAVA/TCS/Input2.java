/*
===========================================================
TITLE
===========================================================
ArrayList Input and Output Using Scanner (Java)

===========================================================
PROBLEM STATEMENT
===========================================================
Write a Java program to:
• Read an integer `n` representing the number of elements
• Store `n` integers in an `ArrayList`
• Print all elements of the ArrayList in the same order

===========================================================
INPUT FORMAT
===========================================================
• First input  → Integer `n` (number of elements)
• Next `n` inputs → Integer values to be stored in ArrayList

===========================================================
OUTPUT FORMAT
===========================================================
• Print all elements of the ArrayList separated by a space

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
Unlike arrays, an `ArrayList` is a dynamic data structure:
• It can grow or shrink dynamically
• No fixed size is required at compile time

Using `Scanner`, we can:
• Read inputs one by one
• Store them directly into the ArrayList

===========================================================
APPROACH
===========================================================
1) Read integer `n`
2) Create an ArrayList with initial capacity `n`
3) Use a loop to read `n` integers and add them to the list
4) Use another loop to print the stored elements

===========================================================
TIME COMPLEXITY
===========================================================
O(n)
- One loop for input
- One loop for output

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
- Extra space used by the ArrayList

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• `ArrayList<Integer>` stores objects, not primitive `int`
• Initial capacity `n` improves performance by reducing resizing
• `get(index)` is used to access elements
• `Scanner.nextInt()` must match integer input type
===========================================================
*/

package TCS;
import java.util.*;

public class Input2 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Read number of elements
        int n = sc.nextInt();

        // Create ArrayList with initial capacity n
        ArrayList<Integer> arr = new ArrayList<>(n);

        // Read elements and add to ArrayList
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // Print ArrayList elements
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}
