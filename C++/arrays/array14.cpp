// Sort 0's and 1's using single traversal (Method-3)
#include <iostream>
#include <vector>
using namespace std;

// Function to sort array containing only 0s and 1s
vector<int> sortZeroAndOne(vector<int> arr) {
    int start = 0;               // Pointer to place 0s
    int end = arr.size() - 1;    // Pointer to place 1s
    int i = 0;                   // Current index for traversal

    // Loop until start crosses end
    while (start < end && i <= end) {
        // If current element is 0, place it at 'start' index
        if (arr[i] == 0) {
            swap(arr[start], arr[i]);
            start++;
            i++; // Move to next index
        } else {
            // If current element is 1, place it at 'end' index
            swap(arr[end], arr[i]);
            end--;
            // Don't increment i here, because the swapped value at i might be 0 or 1 and needs to be checked
        }
    }

    return arr;
}

int main() {
    vector<int> arr = {0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1};
    vector<int> result = sortZeroAndOne(arr);

    // Output the sorted array
    for (int val : result) {
        cout << val << " ";
    }

    return 0;
}
