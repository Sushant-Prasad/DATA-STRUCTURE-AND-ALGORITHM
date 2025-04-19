//Triplet Sum:-
//pair sum:-find a pair that upon addition gives value equal to sum
#include<iostream>
using namespace std;
#include<vector>
vector<int> tripletSum(vector<int> arr,int sum){
  vector<int> result;
  for(int i =0;i<arr.size();i++){
    for(int j=i+1;j<arr.size();j++){
      for(int k=j+1;j<arr.size();j++){
        int temp =arr[i]+arr[j] + arr[k];
        if(temp==sum){
          result.push_back(arr[i]);
          result.push_back(arr[j]);
          result.push_back(arr[k]);
          return result;
      }
      
    }
    
     

      }
  }
  return result;
}
int main(){
  vector<int> arr = {10,20,30,40,50};
  int sum = 80;
  vector<int> result = tripletSum(arr,sum);
  for(int val : result){
    cout<<val<<" ";
  }
}