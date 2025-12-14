package Arrays;

import java.util.*;

public class Array {

    /*
     * ============================================================================
     *  DEFINITION:
     *  -----------
     *  An ARRAY in Java is a **linear data structure** used to store multiple
     *  elements of the **same data type** in a contiguous block of memory.
     *
     *      Syntax:
     *         int[] marks = new int[50];
     *
     *  Here, an integer array of size 50 is created.
     *
     * ============================================================================
     *  KEY POINTS ABOUT ARRAYS:
     *  ------------------------
     *  ✔ Fixed size — cannot be changed after creation  
     *  ✔ Index starts from 0  
     *  ✔ Fast access → O(1) time using index  
     *  ✔ Used when number of elements is known  
     *  ✔ Stores homogeneous data (same type)
     *
     * ============================================================================
     *  NOTES:
     *  ------
     *  • marks[0], marks[1], marks[2] are used to store 3 subject marks  
     *  • Scanner is used to take user input  
     *  • Closing scanner is a good practice  
     *
     * ============================================================================
     *  PROGRAM PURPOSE:
     *  -----------------
     *  Take marks of 3 subjects (Physics, Math, Chemistry) from the user
     *  and store them in an integer array. Then print them.
     * ============================================================================
     */

    public static void main(String args[]) {

        // Creating an integer array of size 50
        int marks[] = new int[50];

        System.out.println("Enter marks for Physics, Math, and Chemistry:");

        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        /*
         * -------------------------------------------------------------
         *  Storing user input in array
         * -------------------------------------------------------------
         *  marks[0] → Physics marks
         *  marks[1] → Math marks
         *  marks[2] → Chemistry marks
         */
        marks[0] = sc.nextInt();
        marks[1] = sc.nextInt();
        marks[2] = sc.nextInt();

        /*
         * -------------------------------------------------------------
         *  Displaying the marks stored in the array
         * -------------------------------------------------------------
         */
        System.out.println("Physics : " + marks[0]);
        System.out.println("Maths   : " + marks[1]);
        System.out.println("Chem    : " + marks[2]);

        // Close the scanner
        sc.close();
    }
}
