//Union of two array:- add two array into third array(assuming duplicates doesnot exists)
#include<iostream>
#include<vector>
using namespace std;
vector<int> unionArray(vector<int> a ,vector<int> b){
  vector<int> result;
  for(int i=0;i<a.size();i++){
    result.push_back(a[i]);
  }
  for(int i=0;i<b.size();i++){
    result.push_back(b[i]);
  }

return result;
}
int main(){
  vector<int> a = {1,2,4,3,5,5,6};
  vector<int> b = {1,4,6,6,5};
  vector<int> result = unionArray(a, b);
  for (int val : result) {
    cout << val << " ";
}
}