//max. number in an array
#include <iostream>
#include <limits.h>
using namespace std;
int findMaxNum(int arr[],int size){
  int max =INT_MIN;
  for(int i=0;i<size;i++){
    if(arr[i]>max){
      max=arr[i];
    }
   
  }
  return max;
}
int main(){
  int arr[10]={4,6,8,10,12,55,7,3,46,16};
  int size = 10;
  cout<<findMaxNum(arr,size);
}