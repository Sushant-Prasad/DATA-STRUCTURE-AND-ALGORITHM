//Union of two array(no dublicates allowed)
#include <iostream>
#include <vector>
#include <set>
using namespace std;

vector<int> unionArray(vector<int> a, vector<int> b) {
    set<int> s; // Set automatically avoids duplicates

    // Insert all elements from both arrays into the set
    for (int i = 0; i < a.size(); i++) {
        s.insert(a[i]);
    }
    for (int i = 0; i < b.size(); i++) {
        s.insert(b[i]);
    }

    // Convert set back to vector
    vector<int> result(s.begin(), s.end());
    return result;
}

int main() {
    vector<int> a = {1, 2, 4, 3, 5, 5, 6};
    vector<int> b = {1, 4, 6, 6, 5};

    vector<int> result = unionArray(a, b);

    for (int val : result) {
        cout << val << " ";
    }

    return 0;
}
