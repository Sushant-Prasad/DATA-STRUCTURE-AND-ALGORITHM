//Find unique element:- Every element occurs twice except one.find that unique element
//XOR operator gives 0 for same and 1 for different
#include<iostream>
#include<vector>
using namespace std;
int findUnique(vector<int> arr){
  int result = 0;//xor with 0 doesnot affect the result
for(int i=0;i<arr.size();i++){
  result = result ^arr[i]; // XOR operator  
}
return result;
}
int main(){
  vector<int> array = {1,2,4,2,1,3,6,5,5,6,4};
  cout<<findUnique(array);
}