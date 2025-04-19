//Sort 0's and 1's 
//Method-1
#include<iostream>
using namespace std;
#include<vector>
vector<int> sortZeroAndOne(vector<int> arr){
  vector<int> result;
  for(int i =0;i<arr.size();i++){
   if(arr[i]==0){
    result.push_back(arr[i]);
   }
  }
  for(int i =0;i<arr.size();i++){
    if(arr[i]==1){
     result.push_back(arr[i]);
    }
   }
  return result;
}
int main(){
  vector<int> arr = {0,1,1,0,0,1,0,1,0,1,1};
  vector<int> result =sortZeroAndOne(arr);
  for(int val : result){
    cout<<val<<" ";
  }
}