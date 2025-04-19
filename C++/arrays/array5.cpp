//reverse an array
#include<iostream>
using namespace std;
int* reverseArray(int arr[],int size){
  int* result = new int[size];
  for(int i=0;i<size;i++){
    result[i]=arr[size-1-i];
  }
  return result;
}
int main(){
  int arr[8]={1,2,3,4,5,6,7,8};
  
  int size = 8;
  int* result =reverseArray(arr,size);
  for(int i=0; i < size;i++){
    cout<<result[i]<<" ";
  }
 delete[] result;//free the memory
}