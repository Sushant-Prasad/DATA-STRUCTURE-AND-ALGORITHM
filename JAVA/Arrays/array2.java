package Arrays;

// ============================================================================
//  TITLE: Passing Array as an Argument in Java
// ============================================================================
//
//  KEY CONCEPT:
//  ------------
//  In Java, EVERYTHING is passed by **value**, not by reference.
//
//  ✔ When you pass an array to a method:
//        → the *reference value* (address) of the array is passed
//        → so the method can MODIFY the original array
//
//  ✔ When you pass a primitive (int, float, etc):
//        → only a COPY of the value is passed
//        → so changes inside the function DO NOT affect the original variable
//
// ============================================================================
//  NOTES:
//  ------
//  • Arrays are mutable → updates inside the function reflect outside  
//  • Primitive types are NOT mutable → changes inside do NOT reflect  
//
//  In this example:
//      marks[] gets updated because function modifies the actual array.
//      nonChangable DOES NOT change outside the method.
//
// ============================================================================
//  SPECIAL EXPLANATION:
//  ---------------------
//  nonChangable = 20;   // changes only the local copy
//
//  marks[i] = marks[i] + 5;   // modifies the actual array in memory
//
// ============================================================================
//

public class array2 {

    // ------------------------------------------------------------
    // update(): Demonstrates behavior of arrays & primitives
    // ------------------------------------------------------------
    public static void update(int marks[], int nonChangable) {

        // Increase every mark by 5 (affects original array)
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 5;  
        }

        // This change ONLY affects local copy of 'nonChangable'
        nonChangable = 20;  
    }

    // ------------------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------------------
    public static void main(String args[]) {

        int nonChangable = 10;  // primitive variable
        int marks[] = {55, 65, 75, 85, 95};  // array of marks

        // Passing array + primitive to function
        update(marks, nonChangable);

        // Display updated marks
        System.out.println("Updated marks are:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]);   // WILL be updated
        }

        // Display nonChangable
        System.out.println("nonChangable is : " + nonChangable);
        // WILL NOT be updated (remains 10)
    }
}
