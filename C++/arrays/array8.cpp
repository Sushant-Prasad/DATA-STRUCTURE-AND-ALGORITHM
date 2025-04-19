//Intersection of 2 arrays:-o/p will give common element
#include<iostream>
#include<vector>
#include <algorithm>  // For max()
using namespace std;
vector<int> IntersectionArray(vector<int> a ,vector<int> b){
  vector<int> result;
  
  for(int i=0;i<a.size();i++){
    for(int j=0;j<b.size();j++){
if(a[i]==b[j]){
  //mark to avoid duplicate matches
  b[j]=-1; //it can be minus infinity too
  result.push_back(a[i]);
}
    }
   
  }
  

return result;
}
int main(){
  vector<int> a = {1,2,4,3,5,5,6};
  vector<int> b = {1,4,6,6,5};
  vector<int> result = IntersectionArray(a, b);
  for (int val : result) {
    cout << val << " ";
}
}