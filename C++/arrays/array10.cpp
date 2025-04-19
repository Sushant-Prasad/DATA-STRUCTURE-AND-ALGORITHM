//pair sum:-find a pair that upon addition gives value equal to sum
#include<iostream>
using namespace std;
#include<vector>
vector<int> pairSum(vector<int> arr,int sum){
  vector<int> result;
  for(int i =0;i<arr.size();i++){
    for(int j=i+1;j<arr.size();j++){
      int temp =arr[i]+arr[j];
      if(temp==sum){
        result.push_back(arr[i]);
        result.push_back(arr[j]);
        return result;
    }
    
     

      }
  }
  return result;
}
int main(){
  vector<int> arr = {1,3,5,7,2,4,6};
  int sum = 9;
  vector<int> result = pairSum(arr,sum);
  for(int val : result){
    cout<<val<<" ";
  }
}