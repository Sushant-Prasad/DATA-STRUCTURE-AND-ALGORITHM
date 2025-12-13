package Arrays;
import java.util.*;

// insertion sort
// bubble sort
// selection sort

public class array14 {

    // --------------------------------------------------------------
    // INSERTION SORT
    // --------------------------------------------------------------
    // Idea:
    // Pick each element and insert it into its correct position
    // in the left (already sorted) part of the array.
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void insertionsort(int a[], int n) {
        int i;
        for (i = 1; i < n; i++) {

            int curr = a[i];    // current value to be placed
            int prev = i - 1;   // pointer to check left side

            // Shift elements to the right until the correct position is found
            while (prev >= 0 && a[prev] > curr) {
                a[prev + 1] = a[prev];
                prev--;
            }

            // Place the current element in the correct position
            a[prev + 1] = curr;
        }

        // Print sorted array
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // --------------------------------------------------------------
    // BUBBLE SORT
    // --------------------------------------------------------------
    // Idea:
    // Repeatedly compare adjacent elements and swap if out of order.
    // Largest elements "bubble" to the end in each pass.
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void bubblesort(int a[], int n) {

        int temp;

        for (int turns = 0; turns < n - 1; turns++) {

            for (int j = 0; j < n - 1 - turns; j++) {

                // Swap if elements are in the wrong order
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        // Print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // --------------------------------------------------------------
    // SELECTION SORT
    // --------------------------------------------------------------
    // Idea:
    // Find the minimum element in the unsorted part and swap it
    // with the first element of the unsorted part.
    //
    // For descending order → Change (a[minPos] > a[j]) to (a[minPos] < a[j])
    //
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void selectionsort(int a[], int n) {

        int i, j;

        for (i = 0; i < n - 1; i++) {

            int minPos = i;  // assume current index is minimum

            // Find minimum in the remaining array
            for (j = i + 1; j < n; j++) {
                if (a[minPos] > a[j]) {
                    // For descending sort: replace '>' with '<'
                    minPos = j;
                }
            }

            // Swap the found minimum with element at position i
            int temp = a[minPos];
            a[minPos] = a[i];
            a[i] = temp;
        }

        // Print sorted array
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // --------------------------------------------------------------
    // MAIN FUNCTION
    // --------------------------------------------------------------
    // Takes input array from user and calls insertion sort
    public static void main(String args[]) {
        int i, n;

        int a[] = new int[50];  // array of size 50

        System.out.println("enter size of array ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.println("Enter the elements of array ");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(" sorted array is ");

        // Call insertion sort (you can call bubble or selection instead)
        insertionsort(a, n);
    }
}
