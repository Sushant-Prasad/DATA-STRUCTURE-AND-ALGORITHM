//Sort 0's and 1's 
//Method-2
#include<iostream>
using namespace std;
#include<vector>
vector<int> sortZeroAndOne(vector<int> arr){
  int start = 0;
  int end=arr.size()-1;
  while(start<end){
     // Move start forward if it's already 0
    while(arr[start]==0 && start<end){
      start++;
    }
     // Move end backward if it's already 1
    while(arr[end]==1 && start<end){
      end--;
    }
     // Swap only when arr[start] is 1 and arr[end] is 0
    if(start<end){
   swap(arr[start],arr[end]);
    start++;
    end--;
    
  }

}
return arr;
}
int main(){
  vector<int> arr = {0,1,1,0,0,1,0,1,0,1,1};
  vector<int> result =sortZeroAndOne(arr);
  for(int val : result){
    cout<<val<<" ";
  }
}