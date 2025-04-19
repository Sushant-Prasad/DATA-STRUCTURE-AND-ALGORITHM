// Left rotate an array by 1 place
#include <iostream>
#include <vector>
using namespace std;

// Function to rotate the array to the left by 1 position
vector<int> leftRotate(vector<int> arr) {
    int temp = arr[0]; // Store the first element temporarily

    // Shift all elements one position to the left
    for (int i = 1; i < arr.size(); i++) {
        arr[i - 1] = arr[i];
    }

    // Put the first element at the last position
    arr[arr.size() - 1] = temp;

    return arr; // Return the rotated array
}

int main() {
    vector<int> arr = {1, 2, 3, 4, 5};

    // Call the function to rotate the array
    vector<int> result = leftRotate(arr);

    // Print the rotated array
    for (int val : result) {
        cout << val << " ";
    }

    return 0;
}
